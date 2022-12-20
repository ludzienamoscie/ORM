package repositories;

import Util.CassandraNamespaces;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.relation.Relation;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import model.Client;
import model.Room;
import org.bson.conversions.Bson;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.bindMarker;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal;

public class RoomRepository extends AbstractRepository<Room> implements Repository<Room>{

    public RoomRepository(CqlSession session) {
        super(session);
    }

    @Override
    protected Room rowToEntity(Row row) {
        return new Room(row.getInt(CassandraNamespaces.ROOMNUMBER),
                row.getInt(CassandraNamespaces.CAPACITY));
    }

    @Override
    public Room get(Object element) {
        Select getRoomByID = QueryBuilder
                .selectFrom(CassandraNamespaces.ROOMS_ID)
                .all()
                .where(Relation.column("uuid").isEqualTo(bindMarker()));

        PreparedStatement preparedStatement = session.prepare(getRoomByID.build());

        return Optional.ofNullable(readRoom((ResultSet) session.execute(preparedStatement.bind(element))))
                .orElseThrow();
    }

    @Override
    public void add(Room... elements) {
        Stream.of(elements).forEach(this::createRoom);
    }

    @Override
    public void remove(Room... elements) {
        Stream.of(elements).forEach(this::deleteRoom);
    }

    @Override
    public void update(Room... elements) {
        Stream.of(elements).forEach(this::updateRoom);
    }

    @Override
    public List<Room> find(Object... elements) {
        Select getRoomsByID = QueryBuilder
                .selectFrom(CassandraNamespaces.ROOMS_ID)
                .all();
        Stream.of(elements).forEach(element ->
                getRoomsByID.where(Relation.column("uuid")
                        .isEqualTo(bindMarker())));

        PreparedStatement preparedStatement = session.prepare(getRoomsByID.build());

        return session.execute(preparedStatement.bind(elements)).all()
                .stream()
                .map(this::rowToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getAll() {
        Select getRooms = QueryBuilder
                .selectFrom(CassandraNamespaces.ROOMS_ID)
                .all();

        return session.execute(getRooms.build()).all()
                .stream()
                .map(this::rowToEntity)
                .collect(Collectors.toList());
    }


}

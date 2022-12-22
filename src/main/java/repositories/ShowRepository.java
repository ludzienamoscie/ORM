package repositories;


import Util.CassandraNamespaces;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.relation.Relation;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import model.Room;
import model.Show;
import org.bson.conversions.Bson;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.bindMarker;

public class ShowRepository extends AbstractRepository<Show> implements Repository<Show>{

    public ShowRepository(CqlSession session) {
        super(session);
    }

    @Override
    protected Show rowToEntity(Row row) {
        return new Show(
                row.getString(CassandraNamespaces.SHOW_ID),
                row.getString(CassandraNamespaces.ROOM_ID),
                row.getLocalDate(CassandraNamespaces.BEGINTIME),
                row.getLocalDate(CassandraNamespaces.ENDTIME),
                row.getString(CassandraNamespaces.SHOWTYPE)
        );
    }

    @Override
    public Show get(Object element) {
        Select getShowByID = QueryBuilder
                .selectFrom(CassandraNamespaces.SHOWS_ID)
                .all()
                .where(Relation.column("show_id").isEqualTo(bindMarker()));

        PreparedStatement preparedStatement = session.prepare(getShowByID.build());

        return Optional.ofNullable(readShow((ResultSet) session.execute(preparedStatement.bind(element))))
                .orElseThrow();
    }

    @Override
    public void add(Show... elements) {
        Stream.of(elements).forEach(this::createShow);
    }

    @Override
    public void remove(Show... elements) {
        Stream.of(elements).forEach(this::deleteShow);
    }

    @Override
    public void update(Show... elements) {
        Stream.of(elements).forEach(this::updateShow);
    }

    @Override
    public List<Show> find(Object... elements) {
        Select getShowsByID = QueryBuilder
                .selectFrom(CassandraNamespaces.SHOWS_ID)
                .all();
        Stream.of(elements).forEach(element ->
                getShowsByID.where(Relation.column("uuid")
                        .isEqualTo(bindMarker())));

        PreparedStatement preparedStatement = session.prepare(getShowsByID.build());

        return session.execute(preparedStatement.bind(elements)).all()
                .stream()
                .map(this::rowToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Show> getAll() {
        Select getShows = QueryBuilder
                .selectFrom(CassandraNamespaces.SHOWS_ID)
                .all();

        return session.execute(getShows.build()).all()
                .stream()
                .map(this::rowToEntity)
                .collect(Collectors.toList());
    }

}

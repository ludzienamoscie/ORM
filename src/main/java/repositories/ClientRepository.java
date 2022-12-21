package repositories;

import Util.CassandraNamespaces;
import managers.CinemaManager;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.relation.Relation;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import model.Client;
import org.bson.conversions.Bson;

import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal;

public class ClientRepository extends AbstractRepository<Client> implements Repository<Client> {

    public ClientRepository(CqlSession session) {
        super(session);
    }

    @Override
    protected Client rowToEntity(Row row) {
        return new Client(row.getString(CassandraNamespaces.CLIENT_ID),
                          Objects.requireNonNull(row.getLocalDate(CassandraNamespaces.BIRTHDAY)),
                          Objects.requireNonNull(row.getString(CassandraNamespaces.PHONENUMBER)),
                          Objects.requireNonNull(row.getString(CassandraNamespaces.FIRSTNAME)),
                          Objects.requireNonNull(row.getString(CassandraNamespaces.LASTNAME)),
                          row.getString(CassandraNamespaces.CLIENTTYPE));
    }

    @Override
    public Client get(Object element) {
        Select getClientByPersonalID = QueryBuilder
                .selectFrom(CassandraNamespaces.CLIENTS_ID)
                .all()
                .where(Relation.column("personalID").isEqualTo(literal(element.toString())));
        return Optional.ofNullable(readClient((ResultSet) session.execute(getClientByPersonalID.build())))
                .orElseThrow();
    }

    @Override
    public void add(Client... elements) {
        Stream.of(elements).forEach(this::createClient);
    }

    //delete
    @Override
    public void remove(Client... elements) {
        Stream.of(elements).forEach(this::deleteClient);
    }

    @Override
    public void update(Client... elements) {
        Stream.of(elements).forEach(this::updateClient);
    }

    @Override
    public List<Client> find(Object... elements) {
        Select getClientsByPersonalID = QueryBuilder
                .selectFrom(CassandraNamespaces.CLIENTS_ID)
                .all();
        Stream.of(elements).forEach(element ->
                getClientsByPersonalID.where(Relation.column("client_id")
                        .isEqualTo(literal(element.toString()))));

        return session.execute(getClientsByPersonalID.build()).all()
                .stream()
                .map(this::rowToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Client> getAll() {
        Select getClientsByPersonalID = QueryBuilder
                .selectFrom(CassandraNamespaces.CLIENTS_ID)
                .all();

        return session.execute(getClientsByPersonalID.build()).all()
                .stream()
                .map(this::rowToEntity)
                .collect(Collectors.toList());
    }

}

package repositories;

import Util.CassandraNamespaces;
import Util.EntityManagerCreator;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.relation.Relation;
import com.datastax.oss.driver.api.querybuilder.select.Select;

import model.Ticket;



import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.bindMarker;

public class TicketRepository extends AbstractRepository<Ticket> implements Repository<Ticket>{

    public TicketRepository(CqlSession session) {
        super(session);
    }

    @Override
    protected Ticket rowToEntity(Row row) {
        return new Ticket(
                row.getString(CassandraNamespaces.TICKET_ID),
                row.getString(CassandraNamespaces.SHOW_ID),
                row.getString(CassandraNamespaces.CLIENT_ID),
                row.getDouble(CassandraNamespaces.PRICE),
                row.getString(CassandraNamespaces.TICKETTYPE)
        );
    }

    @Override
    public Ticket get(Object element) {
        Select getTicketByID = QueryBuilder
                .selectFrom(CassandraNamespaces.TICKETS_ID)
                .all()
                .where(Relation.column("ticket_id").isEqualTo(bindMarker()));

        PreparedStatement preparedStatement = session.prepare(getTicketByID.build());

        return Optional.ofNullable(readTicket((ResultSet) session.execute(preparedStatement.bind(element))))
                .orElseThrow();
    }

    @Override
    public void add(Ticket... elements) {
        Stream.of(elements).forEach(this::createTicket);
    }

    @Override
    public void remove(Ticket... elements) {
        Stream.of(elements).forEach(this::deleteTicket);
    }

    @Override
    public void update(Ticket... elements) {
        Stream.of(elements).forEach(this::updateTicket);
    }

    @Override
    public List<Ticket> find(Object... elements) {
        Select getTicketsByID = QueryBuilder
                .selectFrom(CassandraNamespaces.TICKETS_ID)
                .all();
        Stream.of(elements).forEach(element ->
                getTicketsByID.where(Relation.column("uuid")
                        .isEqualTo(bindMarker())));

        PreparedStatement preparedStatement = session.prepare(getTicketsByID.build());

        return session.execute(preparedStatement.bind(elements)).all()
                .stream()
                .map(this::rowToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getAll() {
        Select getTickets = QueryBuilder
                .selectFrom(CassandraNamespaces.TICKETS_ID)
                .all();

        return session.execute(getTickets.build()).all()
                .stream()
                .map(this::rowToEntity)
                .collect(Collectors.toList());
    }

}

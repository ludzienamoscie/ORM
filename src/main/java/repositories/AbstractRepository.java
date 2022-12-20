package repositories;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.metadata.schema.ClusteringOrder;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import com.datastax.oss.driver.api.querybuilder.schema.CreateKeyspace;
import com.mongodb.ConnectionString;
import dao.ClientDao;
import dao.RoomDao;
import dao.ShowDao;
import dao.TicketDao;
import mappers.*;
import model.Client;
import model.Room;
import model.Show;
import model.Ticket;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.Conventions;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.awt.*;
import java.net.InetSocketAddress;
import java.sql.ResultSet;
import java.util.List;

import static Util.CassandraNamespaces.*;
import static com.datastax.oss.driver.api.querybuilder.SchemaBuilder.createKeyspace;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public abstract class AbstractRepository<T> implements ClientDao, RoomDao, ShowDao, TicketDao {

    protected CqlSession session;
    protected ClientMapper clientMapper;
    protected ClientDao clientDao;
    protected RoomMapper roomMapper;
    protected RoomDao roomDao;
    protected ShowMapper showMapper;
    protected ShowDao showDao;
    protected TicketMapper ticketMapper;
    protected TicketDao ticketDao;

    // Z jakiegos powodu nie rozpoznaje builderow
    public AbstractRepository(CqlSession session) {
        this.session = session;
        this.clientMapper = new ClientMapperBuilder(session).build();
        this.clientDao = clientMapper.clientDao();
        this.roomMapper = new RoomMapperBuilder(session).build();
        this.roomDao = roomMapper.roomDao();
        this.showMapper = new ShowMapperBuilder(session).build();
        this.showDao = showMapper.showDao();
        this.ticketMapper = new TicketMapperBuilder(session).build();
        this.ticketDao = ticketMapper.ticketDao();
    }

    @Override
    public void createClient(Client client) {
        clientDao.createClient(client);
    }

    @Override
    public Client readClient(ResultSet resultSet) {
        return clientDao.readClient(resultSet);
    }

    @Override
    public void updateClient(Client client) {
        clientDao.updateClient(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientDao.deleteClient(client);
    }

    @Override
    public void createRoom(Room room) {
        roomDao.createRoom(room);
    }

    @Override
    public Room readRoom(ResultSet resultSet) {
        return roomDao.readRoom(resultSet);
    }

    @Override
    public void updateRoom(Room room) {
        roomDao.updateRoom(room);
    }

    @Override
    public void deleteRoom(Room room) {
        roomDao.deleteRoom(room);
    }

    @Override
    public void createShow(Show show) {
        showDao.createShow(show);
    }

    @Override
    public Show readShow(ResultSet resultSet) {
        return showDao.readShow(resultSet);
    }

    @Override
    public void updateShow(Show show) {
        showDao.updateShow(show);
    }

    @Override
    public void deleteShow(Show show) {
        showDao.deleteShow(show);
    }

    @Override
    public void createTicket(Ticket ticket) {
        ticketDao.createTicket(ticket);
    }

    @Override
    public Ticket readTicket(ResultSet resultSet) {
        return ticketDao.readTicket(resultSet);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketDao.updateTicket(ticket);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        ticketDao.deleteTicket(ticket);
    }

    protected abstract T rowToEntity(Row row);

}

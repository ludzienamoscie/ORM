package dao;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.mapper.annotations.*;
import model.Room;
import model.Ticket;


@Dao
public interface TicketDao {

    @Insert
    void createTicket(Ticket ticket);

    @GetEntity
    Ticket readTicket(ResultSet resultSet);

    @Update
    void updateTicket(Ticket ticket);

    @Delete
    void deleteTicket(Ticket ticket);

}

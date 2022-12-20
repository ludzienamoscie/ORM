package dao;

import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.GetEntity;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Update;
import model.Room;
import model.Ticket;

import java.sql.ResultSet;

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

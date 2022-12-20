package mappers;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.DaoTable;
import dao.TicketDao;
import model.Ticket;

public interface TicketMapper {

    @DaoFactory
    TicketDao ticketDao(@DaoKeyspace String keyspace, @DaoTable String table);

    @DaoFactory
    TicketDao ticketDao();

}

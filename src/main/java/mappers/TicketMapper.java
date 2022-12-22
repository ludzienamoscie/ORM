package mappers;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.DaoTable;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;
import dao.TicketDao;
import model.Ticket;

@Mapper
public interface TicketMapper {

    @DaoFactory
    TicketDao ticketDao(@DaoKeyspace String keyspace, @DaoTable String table);

    @DaoFactory
    TicketDao ticketDao();

}

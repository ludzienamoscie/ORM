package mappers;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.DaoTable;
import dao.RoomDao;

public interface RoomMapper {

    @DaoFactory
    RoomDao roomDao(@DaoKeyspace String keyspace, @DaoTable String table);

    @DaoFactory
    RoomDao roomDao();

}

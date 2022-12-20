package mappers;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.DaoTable;
import dao.ShowDao;

public interface ShowMapper {

    @DaoFactory
    ShowDao showDao(@DaoKeyspace String keyspace, @DaoTable String table);

    @DaoFactory
    ShowDao showDao();

}

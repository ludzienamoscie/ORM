package dao;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.mapper.annotations.*;
import model.Client;


@Dao
public interface ClientDao {

    @Insert
    void createClient(Client client);

    @GetEntity
    Client readClient(ResultSet resultSet);

    @Update
    void updateClient(Client client);

    @Delete
    void deleteClient(Client client);

}

package dao;

import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.GetEntity;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Update;
import model.Client;

import java.sql.ResultSet;

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

package dao;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.mapper.annotations.*;
import model.Room;



@Dao
public interface RoomDao {

    @Insert
    void createRoom(Room room);

    @GetEntity
    Room readRoom(ResultSet resultSet);

    @Update
    void updateRoom(Room room);

    @Delete
    void deleteRoom(Room room);

}

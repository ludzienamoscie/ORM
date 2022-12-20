package dao;

import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.GetEntity;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Update;
import model.Room;

import java.sql.ResultSet;

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

package dao;

import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.GetEntity;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Update;
import model.Show;

import java.sql.ResultSet;

public interface ShowDao {

    @Insert
    void createShow(Show show);

    @GetEntity
    Show readShow(ResultSet resultSet);

    @Update
    void updateShow(Show show);

    @Delete
    void deleteShow(Show show);

}

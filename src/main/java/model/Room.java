package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import repositories.UniqueIdMgd;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Room extends AbstractEntity{

    @BsonCreator
    public Room(@BsonProperty("id")UniqueIdMgd entityId,
                @BsonProperty("room_id") Long room_id,
                @BsonProperty("roomNumber") int roomNumber,
                @BsonProperty("capacity") int capacity) {
        super(entityId);
        this.room_id = room_id;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public Room(
            Long room_id,
            int roomNumber,
            int capacity
    ){
        super(new UniqueIdMgd());
        this.room_id = room_id;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @BsonProperty("room_id")
    private Long room_id;

    @BsonProperty("roomNumber")
    private int roomNumber;

    @BsonProperty("capacity")
    private int capacity;

    @Override
    public void close() throws Exception {

    }

}
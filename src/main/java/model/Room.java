package model;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.UUID;

@Getter
@Setter
public class Room extends AbstractEntity{

    @BsonCreator
    public Room(@BsonProperty("_id") UUID uuid,
                @BsonProperty("roomNumber") int roomNumber,
                @BsonProperty("capacity") int capacity) {
        super(uuid);
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public Room(
            int roomNumber,
            int capacity
    ){
        super(UUID.randomUUID());
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

//    @BsonProperty("room_id")
//    private Long room_id;
    @BsonProperty("roomNumber")
    private int roomNumber;

    @BsonProperty("capacity")
    private int capacity;

}
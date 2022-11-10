package model;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.UUID;

@Getter
@Setter
public class Room extends AbstractEntity{

    @BsonCreator
    public Room(@BsonId UUID uuid,
                @BsonProperty("roomNumber") int roomNumber,
                @BsonProperty("capacity") int capacity) {
        this.uuid = uuid;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public Room(
            int roomNumber,
            int capacity
    ){
        this.uuid = UUID.randomUUID();
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    @BsonId
    private UUID uuid;
    @BsonProperty("roomNumber")
    private int roomNumber;

    @BsonProperty("capacity")
    private int capacity;

}
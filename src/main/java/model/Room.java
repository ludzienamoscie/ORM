package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Room extends AbstractEntity{

    //    Nie wem jak to przerobic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROOM_ID")
    private Long room_id;

    @BsonProperty("roomNumber")
    private int roomNumber;

    @BsonProperty("capacity")
    private int capacity;

    @BsonCreator
    public Room(@BsonProperty("roomNumber") int roomNumber,
                @BsonProperty("capacity") int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    protected Room() {
    }
}
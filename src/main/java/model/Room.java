package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import repositories.UniqueIdMgd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room extends AbstractEntity{

    @BsonCreator
    public Room(@BsonProperty("_id")UniqueIdMgd entityId,
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

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber && capacity == room.capacity && Objects.equals(room_id, room.room_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room_id, roomNumber, capacity);
    }
}
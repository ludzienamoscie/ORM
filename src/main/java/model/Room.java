package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="Room")
@Access(AccessType.FIELD)
public class Room extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROOM_ID")
    private Long room_id;

    // po co room number jak jest room id? // bo roomid jest dla bazy danych a fizycznie jest numer pokoju
    @Column(name="ROOMNUMBER", unique = true)
    private int roomNumber;

    @Column(name="CAPACITY")
    private int capacity;

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    protected Room() {
    }
}
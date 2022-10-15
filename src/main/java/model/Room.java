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
public class Room extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROOM_ID")
    private Long room_id;

    // po co room number jak jest room id?
    @Column(name="ROOMNUMBER", unique = true)
    private int roomNumber;

    @Column(name="CAPACITY")
    private int capacity;

    @Column(name="ROWS")
    private Integer rows;

    @Column(name="COLUMNS")
    private Integer columns;

    // tego chyba nie dajemy jako kolumne? idk
    @OneToMany
    private ArrayList<Seat> seats = new ArrayList<>();

    public Room(Long room_id, int roomNumber, Integer rows, Integer columns, ArrayList<Seat> seats) {
        this.room_id = room_id;
        this.roomNumber = roomNumber;
        this.rows = rows;
        this.columns = columns;
        this.seats = seats;
        this.capacity = columns * rows;
    }

    // to trzeba usunac i zmienic na ten wyzej, wiec trzeba testy dopasowac
    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    protected Room() {
    }
}
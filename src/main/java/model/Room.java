package model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Room {

    //private int roomNumber;
    @Id
    @Column(name="ROOMNUMBER")
    Integer roomNumber;
    //private final int capacity;
    @Column(name="CAPACITY")
    Integer capacity;

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }
}
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Room {

    //private int roomNumber;
    @Id
    @Column(name="ROOMNUMBER")
    Integer roomNumber;
    //private final int capacity;
    @Column(name="CAPACITY")
    Integer capacity;

}
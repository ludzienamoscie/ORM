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

    @Id
    @Column(name="ROOMNUMBER",unique = true)
    private Integer roomNumber;

    @Column(name="CAPACITY")
    private Integer capacity;

    public Room() {
    }
}
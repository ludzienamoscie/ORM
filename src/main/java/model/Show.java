package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

enum ShowType {
    show2D,
    show3D
}

@Getter
@Setter
@Entity
public class Show {

    //id
    @Id
    @Column(name="SHOW_UUID")
    UUID show_id;

    // Room
    @JoinColumn(name="ROOMNUMBER")
    Integer roomNumber;

    // beginTime
    @Column(name="BEGINTIME")
    LocalDateTime beginTime;

    //endTime
    @Column(name="ENDTIME")
    LocalDateTime endTime;

    // length
    //private ShowType showtype;
    @Column(name="SHOWTYPE")
    ShowType showType;

    //int availableSeats;
    @Column(name="AVAILABLESEATS")
    Integer availableSeats;

}
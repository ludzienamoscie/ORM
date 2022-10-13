package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="Show")
public class Show {

    enum ShowType {
        show2D,
        show3D
    }

    @Id
    @Column(name="SHOW_UUID",unique = true)
    private UUID show_id;

    //Jedno show odnosi sie do konkretnego pokoju, jeden pokoj moze odnosic sie do wielu show?
    @JoinColumn(name="ROOMNUMBER")
    private Integer roomNumber;

    @Column(name="BEGINTIME")
    private LocalDateTime beginTime;

    @Column(name="ENDTIME")
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name="SHOWTYPE")
    private ShowType showType;

    @Column(name="AVAILABLESEATS")
    private Integer availableSeats;

    public Show(UUID show_id, Integer roomNumber, LocalDateTime beginTime, LocalDateTime endTime, ShowType showType, Integer availableSeats) {
        this.show_id = show_id;
        this.roomNumber = roomNumber;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.showType = showType;
        this.availableSeats = availableSeats;
    }

    protected Show() {
    }
}
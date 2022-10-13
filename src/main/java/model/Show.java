package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Show {

    enum ShowType {
        show2D,
        show3D
    }

    @Id
    @Column(name="SHOW_UUID")
    private UUID show_id;

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

    public Show() {
    }
}
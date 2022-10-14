package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="Show")
public class Show extends AbstractEntity{

    enum ShowType {
        show2D,
        show3D
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SHOW_ID")
    private Long show_id;

    @ManyToOne
    @JoinColumn(name="ROOM_ID")
    private Room room;

    @Column(name="BEGINTIME")
    private LocalDateTime beginTime;

    @Column(name="ENDTIME")
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name="SHOWTYPE")
    private ShowType showType;

    @Column(name="AVAILABLESEATS")
    private Integer availableSeats;

    public Show(Room room, LocalDateTime beginTime, LocalDateTime endTime, ShowType showType, Integer availableSeats) {
        this.room = room;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.showType = showType;
        this.availableSeats = availableSeats;
    }

    protected Show() {
    }
}
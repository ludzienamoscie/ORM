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
@Access(AccessType.FIELD)
public class Show extends AbstractEntity{

    public enum ShowType {
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

    @Column(name="ENDTIME", columnDefinition = "TIMESTAMP CHECK (ENDTIME > BEGINTIME)")
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name="SHOWTYPE")
    private ShowType showType;

    @Column(name="AVAILABLESEATS")
    private Integer availableSeats;

    public Show(Room room, LocalDateTime beginTime, LocalDateTime endTime, ShowType showType) {
        this.room = room;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.showType = showType;
        this.availableSeats = room.getCapacity();
    }

    protected Show() {
    }
}
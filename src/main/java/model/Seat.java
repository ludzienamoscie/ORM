package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="Seat")
public class Seat extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SEAT_ID")
    private Long seat_id;

    @Column(name="ROW")
    private Integer row;

    @Column(name="COLUMN")
    private Integer column;

    @ManyToOne
    @JoinColumn(name="ROOM_ID")
    private Room room;

    // oznaczamy jako column?
    @Column(name="AVAILABILITY")
    private boolean isFree;

    public Seat(Long seat_id, Integer row, Integer column, Room room, boolean isFree) {
        this.seat_id = seat_id;
        this.row = row;
        this.column = column;
        this.room = room;
        this.isFree = isFree;
    }

    protected Seat() {
    }
}

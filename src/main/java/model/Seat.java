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

    @Column(name="Column")
    private Integer column;

    public Seat(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    protected Seat() {
    }
}

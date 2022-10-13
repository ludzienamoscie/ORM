package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Seat {
    @Id
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

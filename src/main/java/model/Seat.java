package model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class Seat {
    @Id
    @Column(name="SEAT_UUID")
    private UUID seatID;

    @Column(name="ROW")
    private Integer row;

    @Column(name="Column")
    private Integer column;

    public Seat(UUID seatID, Integer row, Integer column) {
        this.seatID = seatID;
        this.row = row;
        this.column = column;
    }

    protected Seat() {
    }
}

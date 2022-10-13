package model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import java.util.UUID;

public class Seat {
    @Id
    @Column(name="SEAT_UUID")
    UUID seatID;

    @Column(name="ROW")
    Integer row;

    @Column(name="Column")
    Integer column;

    public Seat(UUID seatID, Integer row, Integer column) {
        this.seatID = seatID;
        this.row = row;
        this.column = column;
    }

    public UUID getSeatID() {
        return seatID;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }
}

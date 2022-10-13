package model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Date;
import java.util.UUID;

enum ShowType {
    show2D,
    show3D
}

public class Show {

    //id
    @Id
    @Column(name="SHOW_UUID")
    UUID show_id;

    // Room; To nie powinno też byc w konstruktorze?
    @JoinColumn(name="ROOMNUMBER")
    Integer roomNumber;

    // beginTime
    @Column(name="BEGINTIME")
    Date beginTime;

    //endTime
    @Column(name="ENDTIME")
    Date endTime;

    // length
    //private ShowType showtype;
    @Column(name="SHOWTYPE")
    ShowType showType;

    //int availableSeats;
    @Column(name="AVAILABLESEATS")
    Integer availableSeats;

    public Show(UUID show_id, Date beginTime, Date endTime, ShowType showType) {
        this.show_id = show_id;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.showType = showType;
    }

    public int getAvailableSeats() {
        // ???
        return availableSeats;
    }

    public void bookSeat(int seatNr) {

    }
}
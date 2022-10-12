package model;

enum ShowType {
    show2D,
    show3D
}

public class Show {

    // Room room;
    // id
    // beginTime
    // length
    private ShowType showtype;
    int availableSeats;

    // konstruktor


    public ShowType getShowtype() {
        return showtype;
    }

    public int getAvailableSeats() {
        // ???
        return availableSeats;
    }

    public void bookSeat(int seatNr) {

    }
}
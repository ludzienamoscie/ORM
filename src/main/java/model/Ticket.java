package model;

enum TicketType{
    adultTicket,
    minorTicket,
    seniorTicket,
    groupTicket
}

public class Ticket {

    // id
    // show
    // client
    private int seatNr;
    private double price;
    private TicketType ticketType;

    // konstruktor

    public int getSeatNr() {
        return seatNr;
    }

    public double getPrice() {
        return price;
    }

    public TicketType getTicketType() {
        return ticketType;
    }
}
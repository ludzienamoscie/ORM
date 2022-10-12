package model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import java.util.UUID;

// to do osobnego pliku?
enum TicketType{
    adultTicket,
    minorTicket,
    seniorTicket,
    groupTicket
}

public class Ticket {

    @Id
    @Column(name = "TICKET_UUID")
    UUID ticket_id;

    // private int seatNr; moze seat jako osobna klasa?

    @Column(name="PRICE")
    double price;

    @Column(name="TICKETTYPE")
    TicketType ticketType;

    @JoinColumn(name="SHOW_UUID")
    UUID show_id;

    @JoinColumn(name="CLIENT_UUID")
    UUID client_id;

    // konstruktor

//    public int getSeatNr() {
//        return seatNr;
//    }

    public double getPrice() {
        return price;
    }

    public TicketType getTicketType() {
        return ticketType;
    }
}
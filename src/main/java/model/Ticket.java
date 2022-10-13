package model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import java.util.UUID;

// to do osobnego pliku? / czyli to chyba zostawiamy jako enum tak?
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

    @JoinColumn(name = "SHOW_UUID")
    UUID show_id;

    @JoinColumn(name = "CLIENT_UUID")
    UUID personalID;

    // seatNumber - co z tym robimy

    @Column(name = "PRICE")
    double price;

    @Column(name = "TICKETTYPE")
    TicketType ticketType;


    public UUID getTicket_id() {return ticket_id;}

    public UUID getShow_id() {return show_id;}

    public UUID getPersonalID() {return personalID;}

    public double getPrice() {return price;}

    public TicketType getTicketType() {return ticketType;}
}
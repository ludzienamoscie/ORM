package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Getter;

import java.util.UUID;

enum TicketType{
    adultTicket,
    minorTicket,
    seniorTicket,
    groupTicket
}

@Getter
@Entity
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

}
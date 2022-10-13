package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Ticket {
   public enum TicketType{
        adultTicket,
        minorTicket,
        seniorTicket,
        groupTicket
    }
    @Id
    @Column(name = "TICKET_UUID")
    private UUID ticket_id;

    @JoinColumn(name = "SHOW_UUID")
    private UUID show_id;

    @JoinColumn(name = "CLIENT_UUID")
    private UUID personalID;

    @JoinColumn(name="SEAT_UUID")
    private UUID seatID;

    @Column(name = "PRICE")
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "TICKETTYPE")
    private TicketType ticketType;

    public Ticket() {
    }
}
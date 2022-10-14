package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="Ticket")
public class Ticket extends AbstractEntity{
   public enum TicketType{
        adultTicket,
        minorTicket,
        seniorTicket,
        groupTicket
    }
    //@SequenceGenerator(initialValue = 10,name="nazwa")
    //@GeneratedValue(generator = "nazwa")
    //Jak jest generowany to nie potrzeba robic columny
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_ID")
    private Long ticket_id;

    @ManyToOne
    @JoinColumn(name = "SHOW_ID")
    private Show show;

    @OneToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @OneToOne
    @JoinColumn(name="SEAT_ID")
    private Seat seat;

    @NotNull
    @Column(name = "PRICE")
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "TICKETTYPE")
    private TicketType ticketType;

    public Ticket(Show show, Client client, Seat seat, double price, TicketType ticketType) {
        this.show = show;
        this.client = client;
        this.seat = seat;
        this.price = price;
        this.ticketType = ticketType;
    }
    protected Ticket() {
       }
}
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
public class Ticket {
   public enum TicketType{
        adultTicket,
        minorTicket,
        seniorTicket,
        groupTicket
    }
    @Id
    //@SequenceGenerator(initialValue = 10,name="nazwa")
    //@GeneratedValue(generator = "nazwa")
    //Jak jest generowany to nie potrzeba robic columny
    @Column(name = "TICKET_ID", unique = true)
    private Long ticket_id;

    //Relacja miedzy Ticket a Show to 1-N tak?
    @ManyToOne
    @JoinColumn(name = "SHOW_ID")
    private Show show;

    //A tu chyba relacja 1-1 bo konkretny bilet nalezy do konkretnego klienta a klient ma konkretny jeden bilet? XD
    @OneToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    //Tu tez 1-1 ?
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
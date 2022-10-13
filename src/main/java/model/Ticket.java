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
    @Column(name = "TICKET_UUID", unique = true)
    private UUID ticket_id;

    //Relacja miedzy Ticket a Show to 1-N tak?
    @JoinColumn(name = "SHOW_UUID")
    private UUID show_id;

    //A tu chyba relacja 1-1 bo konkretny bilet nalezy do konkretnego klienta a klient ma konkretny jeden bilet? XD
    @JoinColumn(name = "CLIENT_UUID")
    private UUID personalID;

    //Tu tez 1-1 ?
    @JoinColumn(name="SEAT_UUID")
    private UUID seatID;

    @NotNull
    @Column(name = "PRICE")
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "TICKETTYPE")
    private TicketType ticketType;

    public Ticket() {
    }
}
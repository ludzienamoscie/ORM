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
@Access(AccessType.FIELD)
public class Ticket extends AbstractEntity {

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

    @NotNull
    @Column(name = "PRICE")
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "TICKETTYPE")
    private TicketType ticketType;

    public Ticket(Show show, Client client,double price, TicketType ticketType) {
        this.show = show;
        this.client = client;
        this.price = price;
        this.ticketType = ticketType;
    }
    protected Ticket() {
       }
}
package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Getter
@Setter
public class Ticket extends AbstractEntity {

    //    Nie wem jak to przerobic
   public enum TicketType{
        adultTicket,
        minorTicket,
        seniorTicket,
        groupTicket
    }

    //    Nie wem jak to przerobic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_ID")
    private Long ticket_id;

    //    Nie wem jak to przerobic
    @ManyToOne
    @JoinColumn(name = "SHOW_ID")
    @BsonProperty("show")
    private Show show;

    //    Nie wem jak to przerobic
    @OneToOne
    @JoinColumn(name = "CLIENT_ID")
    @BsonProperty("client")
    private Client client;

    @NotNull
    @BsonProperty("price")
    private double price;

    @BsonProperty("ticketType")
    private TicketType ticketType;

    @BsonCreator
    public Ticket(@BsonProperty("show") Show show,
                  @BsonProperty("client") Client client,
                  @BsonProperty("price") double price,
                  @BsonProperty("ticketType") TicketType ticketType) {
        this.show = show;
        this.client = client;
        this.price = price;
        this.ticketType = ticketType;
    }
    @Override
    public void close() throws Exception {
    }

}
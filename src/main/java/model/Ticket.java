package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import repositories.UniqueIdMgd;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Getter
@Setter
public class Ticket extends AbstractEntity {

    @BsonCreator
    public Ticket(@BsonProperty("id") UniqueIdMgd entityId,
                  @BsonProperty("ticket_id") Long ticket_id,
                  @BsonProperty("show") Show show,
                  @BsonProperty("client") Client client,
                  @BsonProperty("price") double price,
                  @BsonProperty("ticketType") TicketType ticketType) {
        super(entityId);
        this.ticket_id = ticket_id;
        this.show = show;
        this.client = client;
        this.price = price;
        this.ticketType = ticketType;
    }
    //    Nie wem jak to przerobic
   public enum TicketType{
        adultTicket,
        minorTicket,
        seniorTicket,
        groupTicket
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @BsonProperty("ticket_id")
    private Long ticket_id;

    //    Nie wem jak to przerobic
    @BsonProperty("show")
    private Show show;

    //    Nie wem jak to przerobic

    @BsonProperty("client")
    private Client client;

    @NotNull
    @BsonProperty("price")
    private double price;

    @BsonProperty("ticketType")
    private TicketType ticketType;

    @Override
    public void close() throws Exception {
    }

}
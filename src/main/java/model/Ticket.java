package model;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.UUID;

@Getter
@Setter
public class Ticket extends AbstractEntity {

    @BsonCreator
    public Ticket(@BsonProperty("_id") UUID uuid,
                  @BsonProperty("show") Show show,
                  @BsonProperty("client") Client client,
                  @BsonProperty("price") double price,
                  @BsonProperty("ticketType") TicketType ticketType) {
        super(uuid);
        this.show = show;
        this.client = client;
        this.price = price;
        this.ticketType = ticketType;
    }

    public Ticket(
            Show show,
            Client client,
            double price,
            TicketType ticketType
    ){
        super(UUID.randomUUID());
        this.show = show;
        this.client = client;
        this.price = price;
        this.ticketType = ticketType;
    }

   public enum TicketType{
        adultTicket,
        minorTicket,
        seniorTicket,
        groupTicket
    }

    @BsonProperty("ticket_id")
    private Long ticket_id;

    @BsonProperty("show")
    private Show show;

    @BsonProperty("client")
    private Client client;

    @BsonProperty("price")
    private double price;

    @BsonProperty("ticketType")
    private TicketType ticketType;

}
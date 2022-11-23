package model;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.UUID;

@Getter
@Setter
public class Ticket extends AbstractEntity {

    @BsonCreator
    public Ticket(@BsonId UUID uuid,
                  @BsonProperty("ticket") Long ticket,
                  @BsonProperty("show") Show show,
                  @BsonProperty("client") Client client,
                  @BsonProperty("price") double price,
                  @BsonProperty("ticketType") TicketType ticketType) {
        this.uuid = uuid;
        this.ticket = ticket;
        this.show = show;
        this.client = client;
        this.price = price;
        this.ticketType = ticketType;
    }

    public Ticket(
            Long ticket,
            Show show,
            Client client,
            double price,
            TicketType ticketType
    ){
        this.uuid = UUID.randomUUID();
        this.ticket = ticket;
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
    @BsonId
    private UUID uuid;

    @BsonId Long ticket;

    @BsonProperty("show")
    private Show show;

    @BsonProperty("client")
    private Client client;

    @BsonProperty("price")
    private double price;

    @BsonProperty("ticketType")
    private TicketType ticketType;

}
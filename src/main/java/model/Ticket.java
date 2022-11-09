package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import repositories.UniqueIdMgd;

import javax.annotation.processing.Generated;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

public class Ticket extends AbstractEntity {

    @BsonCreator
    public Ticket(@BsonProperty("_id") UniqueIdMgd entityId,
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

    public Ticket(
            Long ticket_id,
            Show show,
            Client client,
            double price,
            TicketType ticketType
    ){
        super(new UniqueIdMgd());
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

    public Long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.price, price) == 0 && Objects.equals(ticket_id, ticket.ticket_id) && Objects.equals(show, ticket.show) && Objects.equals(client, ticket.client) && ticketType == ticket.ticketType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket_id, show, client, price, ticketType);
    }
}
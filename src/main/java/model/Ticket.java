package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.UUID;

@Getter
@Setter
@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(exclude = {})
@Entity
@CqlName("tickets_id")
public class Ticket extends AbstractEntity {

//    @BsonCreator
//    public Ticket(@BsonId UUID uuid,
//                  @BsonProperty("ticket") Long ticket,
//                  @BsonProperty("show") Show show,
//                  @BsonProperty("client") Client client,
//                  @BsonProperty("price") double price,
//                  @BsonProperty("ticketType") TicketType ticketType) {
//        this.uuid = uuid;
//        this.ticket = ticket;
//        this.show = show;
//        this.client = client;
//        this.price = price;
//        this.ticketType = ticketType;
//    }

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

    @ToString
    @RequiredArgsConstructor
    @NoArgsConstructor
   public enum TicketType{
        adultTicket,
        minorTicket,
        seniorTicket,
        groupTicket
    }
    @NonNull
    @PartitionKey
    @CqlName("ID")
    private UUID uuid;

    @NonNull
    @PartitionKey
    @CqlName("ticket_ID")
    private Long ticket;

    @NonNull
    @PartitionKey
    @CqlName("show")
    private Show show;

    @NonNull
    @PartitionKey
    @CqlName("client")
    private Client client;

    @NonNull
    @PartitionKey
    @CqlName("price")
    private double price;

    @NonNull
    @PartitionKey
    @CqlName("ticketType")
    private TicketType ticketType;

}
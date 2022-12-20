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
            UUID show_id,
            UUID client_id,
            double price,
            String ticketType
    ){
        this.uuid = UUID.randomUUID();
        this.ticket = ticket;
        this.show_id = show_id;
        // wywala u mnie, ze nie mozna resolve symbol client_id, nie wiem czemu
        this.client_id = client_id;
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
        groupTicket;

        @NonNull
        @Getter
        @CqlName("typeInfo")
        private String typeInfo;

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
    @CqlName("show_ID")
    private UUID show_id;

    @NonNull
    @PartitionKey
    @CqlName("client_ID")
    private UUID client;

    @NonNull
    @PartitionKey
    @CqlName("price")
    private double price;

    @NonNull
    @PartitionKey
    @CqlName("ticketType")
    // nie wiem jak to zrobic ogolnie dla TicketType a nie tylko dla jednego
    private String ticketType = TicketType.adultTicket.getTypeInfo();

}
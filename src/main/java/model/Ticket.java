package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.*;

@Getter
@Setter
@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"show_id","client_id","price","ticketType"})
@Entity
@CqlName("tickets_id")
public class Ticket extends AbstractEntity {
    @NonNull
    @PartitionKey
    @CqlName("ticket_id")
    private String ticket_id;

    @NonNull
    @CqlName("show_id")
    private String show_id;

    @NonNull
    @CqlName("client_id")
    private String client_id;

    @NonNull
    @CqlName("price")
    private double price;

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
    @CqlName("ticketType")
    private String ticketType = TicketType.adultTicket.getTypeInfo();

}
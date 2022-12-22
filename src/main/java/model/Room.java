package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.*;


import java.util.UUID;

@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"capacity"})
@CqlName("rooms_id")
@Entity
public class Room extends AbstractEntity{

    @NonNull
    @PartitionKey
    @CqlName("room_id")
    private String room_id;

    @NonNull
    @CqlName("capacity")
    private int capacity;

}
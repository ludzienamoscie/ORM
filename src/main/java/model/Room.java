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
//@EqualsAndHashCode(exclude = {"capacity", "roomNumber"})
@CqlName("rooms_id")
@Entity
public class Room extends AbstractEntity{

//    public Room(UUID uuid, int roomNumber, int capacity) {
//        this.uuid = uuid;
//        this.roomNumber = roomNumber;
//        this.capacity = capacity;
//    }

    public Room(
            int roomNumber,
            int capacity
    ){
        this.uuid = UUID.randomUUID();
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    @NonNull
    @PartitionKey
    @CqlName("ID")
    private UUID uuid;
    @NonNull
    @PartitionKey
    @CqlName("roomNumber")
    private int roomNumber;

    @NonNull
    @CqlName("capacity")
    private int capacity;

}
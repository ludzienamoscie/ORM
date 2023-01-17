package main.java.model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.*;
import main.java.mongo.AbstractEntity;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"capacity"})
public class Room implements Serializable {

    @BsonCreator
    @JsonbCreator
    public Room(@BsonProperty("room_id") @JsonbProperty("room_id") String room_id,
                  @BsonProperty("capacity") @JsonbProperty("capacity") int capacity) {
        this.room_id = room_id;
        this.capacity = capacity;
    }

    @Getter
    @NonNull
    @BsonProperty("room_id")
    @JsonbProperty("room_id")
    private String room_id;

    @Getter
    @NonNull
    @BsonProperty("capacity")
    @JsonbProperty("capacity")
    private int capacity;

}
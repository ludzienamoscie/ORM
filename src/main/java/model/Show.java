package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(exclude = {"??"})
@CqlName("shows_id")
@Entity
public class Show extends AbstractEntity{

//    @BsonCreator
//    public Show(@BsonId UUID uuid,
//                @BsonProperty("show_id") Long show_id,
//                @BsonProperty("room") Room room,
//                @BsonProperty("beginTime") LocalDateTime beginTime,
//                @BsonProperty("endTime") LocalDateTime endTime,
//                @BsonProperty("showType") ShowType showType) {
//        this.uuid = uuid;
//        this.show_id = show_id;
//        this.room = room;
//        this.beginTime = beginTime;
//        this.endTime = endTime;
//        this.showType = showType;
//        this.availableSeats = room.getCapacity();
//    }

    public Show(
            Long show_id,
            Room room,
            LocalDateTime beginTime,
            LocalDateTime endTime,
            ShowType showType
    ){
        this.uuid = UUID.randomUUID();
        this.show_id = show_id;
        this.room = room;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.showType = showType;
    }

    @ToString
    @RequiredArgsConstructor
    @NoArgsConstructor
    public enum ShowType {
        show2D,
        show3D
    }
    @NonNull
    @PartitionKey
    @CqlName("ID")
    private UUID uuid;

    // dwa id?
    @NonNull
    @PartitionKey
    @CqlName("show_ID")
    private Long show_id;

    @NonNull
    @PartitionKey
    @CqlName("room")
    private Room room;

    @NonNull
    @CqlName("beginTime")
    private LocalDateTime beginTime;

    @NonNull
    @CqlName("endTime")
    private LocalDateTime endTime;

    @NonNull
    @CqlName("showType")
    private ShowType showType;

    @NonNull
    @CqlName("availableSeats")
    private Integer availableSeats;

    public void decreaseSeats(){
        availableSeats--;
    }

}
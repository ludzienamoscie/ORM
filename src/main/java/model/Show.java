package model;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Show extends AbstractEntity{

    @BsonCreator
    public Show(@BsonId UUID uuid,
                @BsonProperty("show_id") Long show_id,
                @BsonProperty("room") Room room,
                @BsonProperty("beginTime") LocalDateTime beginTime,
                @BsonProperty("endTime") LocalDateTime endTime,
                @BsonProperty("showType") ShowType showType) {
        this.uuid = uuid;
        this.show_id = show_id;
        this.room = room;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.showType = showType;
        this.availableSeats = room.getCapacity();
    }

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

    public enum ShowType {
        show2D,
        show3D
    }
    @BsonId
    private UUID uuid;

    @BsonProperty("show_id")
    private Long show_id;

    @BsonProperty("room")
    private Room room;

    @BsonProperty("beginTime")
    private LocalDateTime beginTime;

    @BsonProperty("endTime")
    private LocalDateTime endTime;

    @BsonProperty("showType")
    private ShowType showType;

    private Integer availableSeats;

    public void decreaseSeats(){
        availableSeats--;
    }

}
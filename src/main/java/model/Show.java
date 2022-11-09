package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import repositories.UniqueIdMgd;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class Show extends AbstractEntity{

    @BsonCreator
    public Show(@BsonProperty("_id") UUID uuid,
                @BsonProperty("room") Room room,
                @BsonProperty("beginTime") LocalDateTime beginTime,
                @BsonProperty("endTime") LocalDateTime endTime,
                @BsonProperty("showType") ShowType showType) {
        super(uuid);
        this.room = room;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.showType = showType;
        this.availableSeats = room.getCapacity();
    }

    public Show(
            Room room,
            LocalDateTime beginTime,
            LocalDateTime endTime,
            ShowType showType
    ){
        super(UUID.randomUUID());
        this.room = room;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.showType = showType;
    }

    public enum ShowType {
        show2D,
        show3D
    }

//    @BsonProperty("show_id")
//    private Long show_id;

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
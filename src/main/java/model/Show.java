package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import repositories.UniqueIdMgd;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Show extends AbstractEntity{

    @BsonCreator
    public Show(@BsonProperty("id") UniqueIdMgd entityId,
                @BsonProperty("show_id") Long show_id,
                @BsonProperty("room") Room room,
                @BsonProperty("beginTime") LocalDateTime beginTime,
                @BsonProperty("endTime") LocalDateTime endTime,
                @BsonProperty("showType") ShowType showType) {
        super(entityId);
        this.show_id = show_id;
        this.room = room;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.showType = showType;
        this.availableSeats = room.getCapacity();
    }

    //    Nie wem jak to przerobic
    public enum ShowType {
        show2D,
        show3D
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // nie wiem jak to przerobic jak nie jest w konstruktorze

    private Integer availableSeats;

    public void decreaseSeats(){
        availableSeats--;
    }

    @Override
    public void close() throws Exception {

    }

}
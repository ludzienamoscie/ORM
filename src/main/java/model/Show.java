package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Show extends AbstractEntity{

    //    Nie wem jak to przerobic
    public enum ShowType {
        show2D,
        show3D
    }

    //    Nie wem jak to przerobic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SHOW_ID")
    private Long show_id;

    //    Nie wem jak to przerobic
    @ManyToOne
    @JoinColumn(name="ROOM_ID")
    @BsonProperty("room")
    private Room room;

    @BsonProperty("beginTime")
    private LocalDateTime beginTime;

    @BsonProperty("endTime")
    private LocalDateTime endTime;

    @BsonProperty("showType")
    private ShowType showType;

    // nie wiem jak to przerobic jak nie jest w konstruktorze
    @Column(name="AVAILABLESEATS")
    private Integer availableSeats;

    public void decreaseSeats(){
        availableSeats--;
    }

    @BsonCreator
    public Show(@BsonProperty("room") Room room,
                @BsonProperty("beginTime") LocalDateTime beginTime,
                @BsonProperty("endTime") LocalDateTime endTime,
                @BsonProperty("showType") ShowType showType) {
        this.room = room;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.showType = showType;
        this.availableSeats = room.getCapacity();
    }

    protected Show() {
    }
}
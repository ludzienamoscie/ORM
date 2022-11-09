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

public class Show extends AbstractEntity{

    @BsonCreator
    public Show(@BsonProperty("_id") UniqueIdMgd entityId,
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

    public Show(
            Long show_id,
            Room room,
            LocalDateTime beginTime,
            LocalDateTime endTime,
            ShowType showType
    ){
        super(new UniqueIdMgd());
        this.show_id = show_id;
        this.room = room;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.showType = showType;
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

    public Long getShow_id() {
        return show_id;
    }

    public void setShow_id(Long show_id) {
        this.show_id = show_id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ShowType getShowType() {
        return showType;
    }

    public void setShowType(ShowType showType) {
        this.showType = showType;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return Objects.equals(show_id, show.show_id) && Objects.equals(room, show.room) && Objects.equals(beginTime, show.beginTime) && Objects.equals(endTime, show.endTime) && showType == show.showType && Objects.equals(availableSeats, show.availableSeats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show_id, room, beginTime, endTime, showType, availableSeats);
    }
}
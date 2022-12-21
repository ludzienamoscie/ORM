package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"room_id","beginTime","endTime","showType"})
@CqlName("shows_id")
public class Show extends AbstractEntity{

    @NonNull
    @PartitionKey
    @CqlName("show_id")
    private String show_id;

    @NonNull
    @CqlName("room_id")
    private String room_id;

    @NonNull
    @CqlName("beginTime")
    private LocalDate beginTime;

    @NonNull
    @CqlName("endTime")
    private LocalDate endTime;

    @ToString
    @RequiredArgsConstructor
    @NoArgsConstructor
    public enum ShowType implements Serializable {
        show2D,
        show3D;

        @NonNull
        @Getter
        @CqlName("typeInfo")
        private String typeInfo;
    }


    @CqlName("showType")
    // nie wiem jak to zrobic ogolnie dla ShowType a nie tylko dla jednego
    private String showType = ShowType.show2D.getTypeInfo();

//    private Integer availableSeats;
//
//    public void decreaseSeats(){
//        availableSeats--;
//    }

}
package main.java.model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
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
@Entity
public class Show implements Serializable {

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
    private String showType = ShowType.show2D.getTypeInfo();

}
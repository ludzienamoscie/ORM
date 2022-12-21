package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"birthday","phoneNumber","firstName", "lastName", "clientType"})
@CqlName("clients_id")
public class Client extends AbstractEntity{

    @NonNull
    @PartitionKey
    @CqlName("client_id")
    private String client_id;

    @NonNull
    @CqlName("birthday")
    private LocalDate birthday;

    @NonNull
    @CqlName("phoneNumber")
    private String phoneNumber;

    @NonNull
    @CqlName("firstName")
    private String firstName;

    @NonNull
    @CqlName("lastName")
    private String lastName;

    @ToString
    @RequiredArgsConstructor
    @NoArgsConstructor
    public enum ClientType implements Serializable {
        adult,
        minor,
        senior;

        @NonNull
        @Getter
        @CqlName("typeInfo")
        private String typeInfo;
    }

    @CqlName("clientType")
    // nie wiem jak to zrobic ogolnie dla ClientType a nie tylko dla jednego
    private String clientType = ClientType.adult.getTypeInfo();
}
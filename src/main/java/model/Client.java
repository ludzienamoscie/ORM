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
@RequiredArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(exclude = {"firstName", "lastName", "clientType", "addressId"})
@Entity(defaultKeyspace = "cinema")
@CqlName("clients_id")
public class Client extends AbstractEntity{

//    public Client() {
//        this.uuid = uuid;
//        this.birthday = birthday;
//        this.phoneNumber = phoneNumber;
//        this.clientType = clientType;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

    public Client(
            LocalDate birthday,
            String phoneNumber,
            String clientType,
            String firstName,
            String lastName
    ){
        this.uuid = UUID.randomUUID();
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.clientType = clientType;
        this.firstName = firstName;
        this.lastName = lastName;
    }

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

    @NonNull
    @PartitionKey
    @CqlName("client_ID")
    private UUID uuid;

    @NonNull
    @CqlName("birthday")
    private LocalDate birthday;

    @NonNull
    @CqlName("phoneNumber")
    private String phoneNumber;

    @CqlName("clientType")
    // nie wiem jak to zrobic ogolnie dla ClientType a nie tylko dla jednego
    private String clientType = ClientType.adult.getTypeInfo();

    @NonNull
    @CqlName("firstName")
    @BsonProperty("firstName")
    private String firstName;

    @NonNull
    @CqlName("lastName")
    @BsonProperty("lastName")
    private String lastName;
}
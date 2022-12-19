package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

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
            Date birthday,
            String phoneNumber,
            ClientType clientType,
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
    public enum ClientType {
        adult,
        minor,
        senior
    }

    @NonNull
    @PartitionKey
    @CqlName("ID")
    private UUID uuid;

    @NonNull
    @CqlName("birthday")
    private Date birthday;

    @NonNull
    @CqlName("phoneNumber")
    private String phoneNumber;

    @CqlName("clientType")
    private ClientType clientType;

    @NonNull
    @CqlName("firstName")
    @BsonProperty("firstName")
    private String firstName;

    @NonNull
    @CqlName("lastName")
    @BsonProperty("lastName")
    private String lastName;
}
package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Client extends AbstractEntity{

    @BsonCreator
    public Client(@BsonId UUID uuid,
                  @BsonProperty("birthday") Date birthday,
                  @BsonProperty("phoneNumber") String phoneNumber,
                  @BsonProperty("clientType") ClientType clientType,
                  @BsonProperty("firstName") String firstName,
                  @BsonProperty("lastname") String lastName) {
        this.uuid = uuid;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.clientType = clientType;
        this.firstName = firstName;
        this.lastName = lastName;
    }

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

    public enum ClientType {
        adult,
        minor,
        senior
    }

    @BsonId
    private UUID uuid;
    @BsonProperty("birthday")
    private Date birthday;

    @BsonProperty("phoneNumber")
    private String phoneNumber;

    @BsonProperty("clientType")
    private ClientType clientType;

    @BsonProperty("firstName")
    private String firstName;

    @BsonProperty("lastname")
    private String lastName;
}
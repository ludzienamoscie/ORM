package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import java.util.Date;


@Getter
@Setter
public class Client extends AbstractEntity{

    //    Nie wem jak to przerobic
    public enum ClientType {
        adult,
        minor,
        senior
    }

//    Nie wem jak to przerobic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CLIENT_ID")
    private Long client_id;

    @BsonCreator
    public Client(@BsonProperty("birthday") Date birthday,
                  @BsonProperty("phoneNumber") String phoneNumber,
                  @BsonProperty("clientType") ClientType clientType,
                  @BsonProperty("firstName") String firstName,
                  @BsonProperty("lastname") String lastName) {
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.clientType = clientType;
        this.firstName = firstName;
        this.lastName = lastName;
    }

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

    protected Client() {
    }
}
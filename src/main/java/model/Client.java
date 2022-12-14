package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import repositories.UniqueIdMgd;

import java.util.Date;


@Getter
@Setter
public class Client extends AbstractEntity{

    @BsonCreator
    public Client(@BsonProperty("id") UniqueIdMgd entityId,
                  @BsonProperty("client_id") Long client_id,
                  @BsonProperty("birthday") Date birthday,
                  @BsonProperty("phoneNumber") String phoneNumber,
                  @BsonProperty("clientType") ClientType clientType,
                  @BsonProperty("firstName") String firstName,
                  @BsonProperty("lastname") String lastName) {
        super(entityId);
        this.client_id = client_id;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.clientType = clientType;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Client(
            Long client_id,
            Date birthday,
            String phoneNumber,
            ClientType clientType,
            String firstName,
            String lastName
    ){
        super(new UniqueIdMgd());
        this.client_id = client_id;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.clientType = clientType;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //    Nie wem jak to przerobic
    public enum ClientType {
        adult,
        minor,
        senior
    }

//    Nie wem jak to przerobic // jest szansa ze ma byc tak

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @BsonProperty("client_id")
    private Long client_id;

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

    @Override
    public void close() throws Exception {

    }


}
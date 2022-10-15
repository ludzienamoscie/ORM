package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="Client")
public class Client extends AbstractEntity{

    public enum ClientType {
        adult,
        minor,
        senior
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CLIENT_ID")
    private Long client_id;

    @Column(name="BIRTHDAY")
    private Date birthday;

    @Column(name="PHONENUMBER")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="CLIENTTYPE")
    private ClientType clientType;

    @Column(name="FIRSTNAME")
    private String firstName;

    @Column(name="LASTNAME")
    private String lastName;

    public Client(Date birthday, String phoneNumber, ClientType clientType, String firstName, String lastName) {
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.clientType = clientType;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected Client() {
    }
}
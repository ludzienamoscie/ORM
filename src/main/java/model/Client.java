package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;
import java.util.Date;

@Getter
@Setter
@Entity
public class Client {
    enum ClientType {
        adult,
        minor,
        senior
    }
    @Id
    @Column(name="CLIENT_UUID")
    private UUID personalID;

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

    public Client() {
    }
}
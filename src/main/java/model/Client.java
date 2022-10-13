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
public class Client {
    enum ClientType {
        adult,
        minor,
        senior
    }
    @Id
    // Tak jak w Ticket.java, mozna generowac tak to nie bedzie column
    @Column(name="CLIENT_UUID", unique = true)
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
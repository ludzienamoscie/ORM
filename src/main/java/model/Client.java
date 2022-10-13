package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
import java.util.Date;

enum ClientType {
    adult,
    minor,
    senior
}

@Getter
@Setter
@Entity
public class Client {

    @Id
    @Column(name="CLIENT_UUID")
    UUID personalID;

    //private java.util.Date birthday;
    @Column(name="BIRTHDAY")
    Date birthday;

    //private String phoneNumber;
    @Column(name="PHONENUMBER")
    String phoneNumber;

    //ClientType clientType;
    @Column(name="CLIENTTYPE")
    ClientType clientType;

    //private String firstName;
    @Column(name="FIRSTNAME")
    String firstName;

    //private String lastName;
    @Column(name="LASTNAME")
    String lastName;

}
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.UUID;

enum ClientType {
    adult,
    minor,
    senior
}

public class Client {

    @Id
    @Column(name="PERSONALID")
    String personalID;

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

    public String getPersonalID() {return personalID;}

    public java.util.Date getBirthday() {
        return birthday;
    }

    public String getPhoneNumber() {return phoneNumber;}

    public ClientType getClientType() {
        return clientType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Client(String personalID, Date birthday, String phoneNumber, ClientType clientType, String firstName, String lastName) {
        this.personalID = personalID;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.clientType = clientType;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //    public int getAge() {
//
//    }

    void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }
}
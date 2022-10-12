package model;

enum ClientType {
    adult,
    minor,
    senior
}

public class Client {

    // jakies ID
    private java.util.Date birthday;
    ClientType clientType;
    private String firstName;
    private String lastName;

    public java.util.Date getBirthday() {
        return birthday;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Client(java.util.Date birthday, ClientType clientType, String firstName, String lastName) {
        this.birthday = birthday;
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
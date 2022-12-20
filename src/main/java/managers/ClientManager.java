package managers;

import model.Client;
import repositories.ClientRepository;

import java.util.Date;
import java.util.UUID;

public class ClientManager {
    ClientRepository clientRepository;

    public ClientManager(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public boolean add(Date birthday, String phoneNumber, String clientType, String firstName, String lastName){
        Client client = new Client(birthday,phoneNumber, clientType,firstName,lastName);
        if(clientRepository.add(client) == null ){
            return false;
        }
        return true;
    }
    public void remove(Client client){
        clientRepository.remove(client);
    }
    public Client get(Client client){
        return clientRepository.get(client);
    }
}

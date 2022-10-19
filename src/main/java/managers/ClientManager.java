package managers;

import model.Client;
import repositories.ClientRepository;

import java.util.Date;

public class ClientManager {
    ClientRepository clientRepository;

    public ClientManager(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client add(Date birthday, String phoneNumber, Client.ClientType clientType, String firstName, String lastName){
        Client client = new Client(birthday,phoneNumber, clientType,firstName,lastName);
        return clientRepository.add(client);
    }
    public void remove(Client client){
        clientRepository.remove(client);
    }
    public Client get(Long id){
        return clientRepository.get(id);
    }
}

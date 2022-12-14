package managers;

import model.Client;
import repositories.ClientRepository;

import java.util.Date;

public class ClientManager {
    ClientRepository clientRepository;

    public ClientManager(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public boolean add(Long client_id,Date birthday, String phoneNumber, Client.ClientType clientType, String firstName, String lastName){
        Client client = new Client(client_id,birthday,phoneNumber, clientType,firstName,lastName);
        if(clientRepository.add(client) == null ){
            return false;
        }
        return true;
    }
    public boolean remove(Client client){
       return clientRepository.remove(client);
    }
    public Client get(Long id){
        return clientRepository.get(id);
    }
}

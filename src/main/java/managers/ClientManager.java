package managers;

import model.Client;
import repositories.ClientRepository;



public class ClientManager {
    ClientRepository clientRepository;

    public ClientManager(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public boolean add(String client_id, String phoneNumber, String firstName, String lastName, String clientType){
        Client client = new Client(client_id,phoneNumber,firstName,lastName,clientType);
        clientRepository.add(client);
        return true;
    }
    public void remove(Client client){
        clientRepository.remove(client);
    }
    public Client get(Client client){
        return clientRepository.get(client);
    }
}

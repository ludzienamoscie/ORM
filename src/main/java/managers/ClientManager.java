package managers;

import model.Client;
import repositories.ClientRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class ClientManager {
    ClientRepository clientRepository;

    public ClientManager(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public boolean add(String client_id,LocalDate birthday, String phoneNumber, String firstName, String lastName, String clientType){
        Client client = new Client(client_id,birthday,phoneNumber,firstName,lastName,clientType);
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

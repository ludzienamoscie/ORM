package managers;

import repositories.ClientRepository;

public class ClientManager {
    ClientRepository clientRepository;

    public ClientManager(ClientRepository clientRepository) {this.clientRepository = clientRepository;}
}

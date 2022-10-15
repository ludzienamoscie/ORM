package repositories;

import model.Client;
import model.Ticket;

import java.util.List;

public class ClientRepository implements Repository<Client, Long>{

    private List<Client> repository;

    public ClientRepository(List<Client> repository){
        this.repository = repository;
    }

    @Override
    public void add(Client item) {
        repository.add(item);
    }

    @Override
    public Client get(Long id) {
        for(Client c : repository) {
            if(c.getClient_id().equals(id)) return c;
        }
        return null;
    }

    @Override
    public void findBy(Client item) {
    }

    @Override
    public void remove(Client item) {
        repository.remove(item);
    }
}

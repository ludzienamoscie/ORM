package repositories;

import model.Client;

import java.util.List;

public class ClientRepository implements Repository<Client>{

    private List<Client> repository;

    public ClientRepository(List<Client> repository){
        this.repository = repository;
    }
    @Override
    public void add(Client item) {
        repository.add(item);
    }

    @Override
    public Client get(int item) {
        return repository.get(item);
    }

    @Override
    public void findBy(Client item) {
    }

    @Override
    public void remove(Client item) {
        repository.remove(item);
    }
}

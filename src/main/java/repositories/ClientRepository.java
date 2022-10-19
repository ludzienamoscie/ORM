package repositories;

import model.Client;
import model.Ticket;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ClientRepository implements Repository<Client, Long>{

    private List<Client> repository;

    public ClientRepository(){
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
    public List<Client> findBy(Predicate<Client> predicate){
        return repository.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public void remove(Client item) {
        repository.remove(item);
    }

    @Override
    public int size() {
        return repository.size();
    }
}

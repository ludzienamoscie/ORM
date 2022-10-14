package repositories;

import model.Client;
import model.Ticket;

import java.util.List;

public class TicketRepository implements Repository<Ticket>{

    private List<Ticket> repository;

    public TicketRepository(List<Ticket> repository){
        this.repository = repository;
    }
    @Override
    public void add(Ticket item) {
        repository.add(item);
    }

    @Override
    public Ticket get(int item) {
        return repository.get(item);
    }

    @Override
    public void findBy(Ticket item) {
    }

    @Override
    public void remove(Ticket item) {
        repository.remove(item);
    }
}

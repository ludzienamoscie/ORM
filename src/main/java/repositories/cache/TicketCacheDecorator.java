package repositories.cache;

import model.Ticket;
import repositories.RepositoryDecorator;
import repositories.TicketRepository;

import java.util.UUID;

public class TicketCacheDecorator extends RepositoryDecorator<Ticket> {

    private final TicketCache cache;
    private final TicketRepository repository;

    public TicketCacheDecorator(TicketRepository repository) {
        super(repository);
        cache = new TicketCache();
        this.repository = repository;
    }

    public void clearCache() {
        cache.deleteAll();
    }


    @Override
    public Ticket add(Ticket ticket) {
        if(TicketCache.isHealthy()) {
            cache.save(ticket);
        }
        return repository.add(ticket);
    }

    @Override
    public Ticket get(Ticket ticket) {
        if(TicketCache.isHealthy()) {
            cache.get(ticket.getUuid());
        }
        return repository.get(ticket);
    }

    @Override
    public void update(Ticket ticket) {
        if(TicketCache.isHealthy()) {
            cache.save(ticket);
        }
        repository.update(ticket);
    }

    @Override
    public void remove(Ticket ticket) {
        if(TicketCache.isHealthy()) {
            cache.delete(ticket);
        }
        repository.remove(ticket);
    }
}

package repositories;

import model.Client;
import model.Ticket;

import java.util.List;

public class TicketRepository implements Repository<Ticket, Long>{

    private List<Ticket> repository;

    public TicketRepository(List<Ticket> repository){
        this.repository = repository;
    }
    @Override
    public void add(Ticket item) {
        repository.add(item);
    }

    @Override
    public Ticket get(Long id) {
        for(Ticket t : repository) {
            if(t.getTicket_id().equals(id)) return t;
        }
        return null;
    }

    @Override
    public void findBy(Ticket item) {
    }

    @Override
    public void remove(Ticket item) {
        repository.remove(item);
    }

    public Ticket findBySeat(Long seatId) {
        for(Ticket t : repository) {
            if(t.getSeat().getSeat_id().equals(seatId)) return t;
        }
        return null;
    }
}

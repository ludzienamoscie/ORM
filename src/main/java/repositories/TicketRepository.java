package repositories;

import model.Ticket;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public List<Ticket> findBy(Predicate<Ticket> predicate){
        return repository.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public void remove(Ticket item) {
        repository.remove(item);
    }

//    public Ticket findBySeat(Long seatId, Long showId) {
//        for(Ticket t : repository) {
//            if(t.getSeat().getSeat_id().equals(seatId) && t.getShow().getShow_id().equals(showId)) return t;
//        }
//        return null;
//    }

    @Override
    public int size() {
        return repository.size();
    }
}

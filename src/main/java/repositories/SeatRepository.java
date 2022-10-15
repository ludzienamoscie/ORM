package repositories;

import model.Client;
import model.Seat;
import model.Ticket;

import java.util.List;

public class SeatRepository implements Repository<Seat, Long>{
    private List<Seat> repository;

    public SeatRepository(List<Seat> repository){
        this.repository = repository;
    }

    @Override
    public void add(Seat item) {
        repository.add(item);
    }

    @Override
    public Seat get(Long id) {
        for(Seat s : repository) {
            if(s.getSeat_id().equals(id)) return s;
        }
        return null;
    }

    @Override
    public void findBy(Seat item) {
    }

    @Override
    public void remove(Seat item) {
        repository.remove(item);
    }
}

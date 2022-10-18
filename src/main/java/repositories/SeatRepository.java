package repositories;

import model.Client;
import model.Seat;
import model.Ticket;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public List<Seat> findBy(Predicate<Seat> predicate){
        return repository.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public void remove(Seat item) {
        repository.remove(item);
    }

    @Override
    public int size() {
        return repository.size();
    }
}

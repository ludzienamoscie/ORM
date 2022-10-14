package repositories;

import model.Client;
import model.Seat;

import java.util.List;

public class SeatRepository implements Repository<Seat>{
    private List<Seat> repository;

    public SeatRepository(List<Seat> repository){
        this.repository = repository;
    }

    @Override
    public void add(Seat item) {
        repository.add(item);
    }

    @Override
    public Seat get(int item) {
        return repository.get(item);
    }

    @Override
    public void findBy(Seat item) {
    }

    @Override
    public void remove(Seat item) {
        repository.remove(item);
    }
}

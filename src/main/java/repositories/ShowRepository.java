package repositories;

import model.Client;
import model.Show;
import model.Ticket;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShowRepository implements Repository<Show, Long>{

    private List<Show> repository;

    public ShowRepository(List<Show> repository){
        this.repository = repository;
    }
    @Override
    public void add(Show item) {
        repository.add(item);
    }

    @Override
    public Show get(Long id) {
        for(Show s : repository) {
            if(s.getShow_id().equals(id)) return s;
        }
        return null;
    }

    @Override
    public List<Show> findBy(Predicate<Show> predicate){
        return repository.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public void remove(Show item) {
        repository.remove(item);
    }

    @Override
    public int size() {
        return repository.size();
    }
}

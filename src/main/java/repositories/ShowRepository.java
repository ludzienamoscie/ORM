package repositories;

import model.Client;
import model.Show;
import model.Ticket;

import java.util.List;

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
    public void findBy(Show item) {
    }

    @Override
    public void remove(Show item) {
        repository.remove(item);
    }
}

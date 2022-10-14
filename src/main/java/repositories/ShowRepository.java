package repositories;

import model.Client;
import model.Show;

import java.util.List;

public class ShowRepository implements Repository<Show>{

    private List<Show> repository;

    public ShowRepository(List<Show> repository){
        this.repository = repository;
    }
    @Override
    public void add(Show item) {
        repository.add(item);
    }

    @Override
    public Show get(int item) {
        return repository.get(item);
    }

    @Override
    public void findBy(Show item) {
    }

    @Override
    public void remove(Show item) {
        repository.remove(item);
    }
}

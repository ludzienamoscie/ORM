package repositories;

import model.Client;
import model.Room;

import java.util.List;

public class RoomRepository implements Repository<Room>{

    private List<Room> repository;

    public RoomRepository(List<Room> repository){
        this.repository = repository;
    }
    @Override
    public void add(Room item) {
        repository.add(item);
    }

    @Override
    public Room get(int item) {
        return repository.get(item);
    }

    @Override
    public void findBy(Room item) {
    }

    @Override
    public void remove(Room item) {
        repository.remove(item);
    }
}

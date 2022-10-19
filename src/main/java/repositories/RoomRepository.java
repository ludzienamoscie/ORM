package repositories;

import model.Client;
import model.Room;
import model.Ticket;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RoomRepository implements Repository<Room, Long>{

    private List<Room> repository;

    public RoomRepository(){
        this.repository = repository;
    }
    @Override
    public void add(Room item) {
        repository.add(item);
    }

    @Override
    public Room get(Long id) {
        for(Room r : repository) {
            if(r.getRoom_id().equals(id)) return r;
        }
        return null;
    }

    @Override
    public List<Room> findBy(Predicate<Room> predicate){
        return repository.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public void remove(Room item) {
        repository.remove(item);
    }

    @Override
    public int size() {
        return repository.size();
    }
}

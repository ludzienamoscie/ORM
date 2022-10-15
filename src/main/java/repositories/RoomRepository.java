package repositories;

import model.Client;
import model.Room;
import model.Ticket;

import java.util.List;

public class RoomRepository implements Repository<Room, Long>{

    private List<Room> repository;

    public RoomRepository(List<Room> repository){
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
    public void findBy(Room item) {
    }

    @Override
    public void remove(Room item) {
        repository.remove(item);
    }
}

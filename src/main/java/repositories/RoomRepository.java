package repositories;

import Util.EntityManagerCreator;
import jakarta.persistence.EntityManager;
import model.Client;
import model.Room;
import model.Ticket;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static model.Room_.room_id;

public class RoomRepository implements Repository<Room, Long>{

    @Override
    public Room add(Room item) {
        try(EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(item);
            manager.getTransaction().commit();
            return item;
        }
    }
    @Override
    public void remove(Room item) {
        try(EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.remove(manager.merge(item));
            manager.getTransaction().commit();
        }
    }

    @Override
    public Room get(Long id) {
        try(EntityManager manager = EntityManagerCreator.getEntityManager()){
            return manager.find(Room.class, room_id);
        }
    }

//    @Override
//    public List<Room> findBy(Predicate<Room> predicate){
//        return repository.stream().filter(predicate).collect(Collectors.toList());
//    }
//
//
//    @Override
//    public int size() {
//        return repository.size();
//    }
}

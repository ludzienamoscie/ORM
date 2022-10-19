package repositories;

import Util.EntityManagerCreator;
import jakarta.persistence.EntityManager;
import model.Client;
import model.Room;
import model.Show;
import model.Ticket;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static model.Room_.room_id;
import static model.Show_.show_id;

public class ShowRepository implements Repository<Show, Long>{
    @Override
    public Show add(Show item) {
        try(EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(item);
            manager.getTransaction().commit();
            return item;
        }catch (Exception exception) {
            return null;
        }
    }

    @Override
    public boolean remove(Show item) {
        try(EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.remove(manager.merge(item));
            manager.getTransaction().commit();
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Show get(Long id) {
        try(EntityManager manager = EntityManagerCreator.getEntityManager()){
            return manager.find(Show.class, show_id);
        }
    }
}

package repositories;

import Util.EntityManagerCreator;
import jakarta.persistence.EntityManager;
import model.Room;
import model.Ticket;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static model.Room_.room_id;
import static model.Ticket_.ticket_id;

public class TicketRepository implements Repository<Ticket, Long>{

    @Override
    public Ticket add(Ticket item) {
        try(EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(item);
            manager.getTransaction().commit();
            return item;
        }
    }
    @Override
    public void remove(Ticket item) {
        try(EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.remove(manager.merge(item));
            manager.getTransaction().commit();
        }
    }

    @Override
    public Ticket get(Long id) {
        try(EntityManager manager = EntityManagerCreator.getEntityManager()){
            return manager.find(Ticket.class, ticket_id);
        }
    }

//    @Override
//    public List<Ticket> findBy(Predicate<Ticket> predicate){
//        return repository.stream().filter(predicate).collect(Collectors.toList());
//    }


//    @Override
//    public int size() {
//        return repository.size();
//    }
}

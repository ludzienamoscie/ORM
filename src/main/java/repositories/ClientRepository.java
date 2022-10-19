package repositories;

import Util.EntityManagerCreator;
import jakarta.persistence.EntityManager;
import model.Client;
import model.Ticket;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static model.Client_.client_id;

public class ClientRepository implements Repository<Client, Long>{

    @Override
    public Client add(Client item) {
        try(EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(item);
            manager.getTransaction().commit();
            return item;
        }
    }
    @Override
    public void remove(Client item) {
        try(EntityManager manager = EntityManagerCreator.getEntityManager()) {
            manager.getTransaction().begin();
            manager.remove(manager.merge(item));
            manager.getTransaction().commit();
        }
    }

    @Override
    public Client get(Long id) {
        try(EntityManager manager = EntityManagerCreator.getEntityManager()){
            return manager.find(Client.class, client_id);
        }
    }
}

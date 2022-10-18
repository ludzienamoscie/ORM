import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Client;
import model.Room;
import model.Seat;
import org.junit.jupiter.api.Test;
import repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Test1 {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CINEMA");

     @org.junit.jupiter.api.Test
    void method() {

        try(EntityManager em = emf.createEntityManager()){
            Room room = new Room(1,3,3,9);
            // Room room2 = new Room(2,1);
            //Date birthday1 = new Date(2001,02,03);
            Seat seat = new Seat(3,3,room,true);
            //Client client = new Client(birthday1,"123456789",Client.ClientType.senior,"Jan","Kowalski");
            em.getTransaction().begin();
            //em.persist(room);
            em.persist(seat);
            // assertThrows(Exception.class,()->em.persist(room2));
            em.getTransaction().commit();
        }

//
    }

    @org.junit.jupiter.api.Test
    void repositoriesTest() {
        Date birthday1 = new Date(2001,02,03);
        Client client1 = new Client(birthday1,"123456789", Client.ClientType.adult, "Anna", "Metoda");

        ClientRepository clientRepository = new ClientRepository(new ArrayList<>());
        clientRepository.add(client1);

        // nie generuje klientowi id
        //assertNotNull(clientRepository.get(client1.getClient_id()));
    }

}

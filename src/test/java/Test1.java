import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Client;
import model.Room;
import org.junit.jupiter.api.Test;
import repositories.ClientRepository;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

// TO JEST TEST TEGO DOCKERA CAŁEGO WIEC NA RAZIE NIECH ZOSTANIE BO DZIALA XD

public class Test1 {
    @org.junit.jupiter.api.Test
    void metoda() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Room room = new Room(1,1);
        Room room2 = new Room(1,1);
        em.getTransaction().begin();
        em.persist(room);
        assertThrows(Exception.class,()->em.persist(room2));
        em.getTransaction().commit();
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

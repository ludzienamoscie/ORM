import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Room;

import static org.junit.jupiter.api.Assertions.assertThrows;

// TO JEST TEST TEGO DOCKERA CAŁEGO WIEC NA RAZIE NIECH ZOSTANIE BO DZIALA XD

public class Test1 {
    @org.junit.jupiter.api.Test
    void metoda(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Room room = new Room(1,1);
        Room room2 = new Room(1,1);
        em.getTransaction().begin();
        em.persist(room);
        assertThrows(Exception.class,()->em.persist(room2));
        em.getTransaction().commit();
    }
}

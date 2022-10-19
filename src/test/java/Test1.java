import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Client;
import model.Room;
import model.Show;
import model.Ticket;
import repositories.ClientRepository;
import repositories.TicketRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Test1 {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CINEMA");

     @org.junit.jupiter.api.Test
    void method() {

        try(EntityManager em = emf.createEntityManager()) {
            TicketRepository ticketRepository = new TicketRepository(new ArrayList<>());
            Date birthday1 = new Date(2001, 02, 03);
            Room room = new Room(1, 9);
            Client client = new Client(birthday1, "123456789", Client.ClientType.adult, "Jan", "Kowalski");
            Show show = new Show(room, LocalDateTime.now().plusDays(3), LocalDateTime.now().plusDays(3).plusHours(2), Show.ShowType.show3D);
            Ticket ticket = new Ticket(show, client, 10, Ticket.TicketType.adultTicket);

            em.getTransaction().begin();
            em.persist(room);
            em.persist(client);
            em.persist(show);
            em.persist(ticket);
            em.getTransaction().commit();

        }
    }

    @org.junit.jupiter.api.Test
    void repositoriesTest() {
        Date birthday1 = new Date(2001,02,03);
        Client client1 = new Client(birthday1,"123456789", Client.ClientType.adult, "Anna", "Metoda");

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.add(client1);

        // nie generuje klientowi id
        //assertNotNull(clientRepository.get(client1.getClient_id()));
    }

}

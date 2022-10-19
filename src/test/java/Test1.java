import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import managers.ClientManager;
import managers.RoomManager;
import managers.ShowManager;
import managers.TicketManager;
import model.Client;
import model.Room;
import model.Show;
import model.Ticket;
import org.junit.jupiter.api.Test;
import repositories.ClientRepository;
import repositories.RoomRepository;
import repositories.ShowRepository;
import repositories.TicketRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


public class Test1 {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CINEMA");

     @org.junit.jupiter.api.Test
    void method() {

        try(EntityManager em = emf.createEntityManager()) {
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
    private static final TicketRepository ticketRepository = new TicketRepository();
    private static final ShowRepository showRepository = new ShowRepository();

    private static final ClientRepository clientRepository = new ClientRepository();

    private static final RoomRepository roomRepository = new RoomRepository();

    @org.junit.jupiter.api.Test
    void repositoriesTest() {
        try(EntityManager manager = emf.createEntityManager()) {

            TicketManager ticketManager = new TicketManager(ticketRepository);

            Date birthday1 = new Date(2001, 02, 03);
            Client client = new Client(birthday1, "123456789", Client.ClientType.adult, "Jan", "Kowalski");
            Room room = new Room(1, 2);
            Show show = new Show(room, LocalDateTime.now().plusDays(3), LocalDateTime.now().plusDays(3).plusHours(2), Show.ShowType.show3D);

            ticketManager.tryBook(show,client,10,Ticket.TicketType.adultTicket);

        }
    }

    @Test
    void addTickettest(){
        TicketManager ticketManager = new TicketManager(ticketRepository);
        ShowManager showManager = new ShowManager(showRepository);
        ClientManager clientManager = new ClientManager(clientRepository);
        RoomManager roomManager = new RoomManager(roomRepository);

        Date birthday1 = new Date(2001, 02, 03);
        Client client = new Client(birthday1, "123456789", Client.ClientType.adult, "Jan", "Kowalski");
        Room room = new Room(1, 1);
        Show show = new Show(room, LocalDateTime.now().plusDays(3), LocalDateTime.now().plusDays(3).plusHours(2), Show.ShowType.show3D);

        clientRepository.add(client);
        roomRepository.add(room);
        showRepository.add(show);

        assertTrue( ticketManager.tryBook(show,client,10, Ticket.TicketType.adultTicket));

        assertFalse(ticketManager.tryBook(show,client,10, Ticket.TicketType.adultTicket));

    }

}

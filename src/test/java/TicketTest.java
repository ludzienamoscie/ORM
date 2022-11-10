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
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
public class TicketTest {
//    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CINEMA");

    private static final TicketRepository ticketRepository = new TicketRepository();
    private static final ShowRepository showRepository = new ShowRepository();
    private static final RoomRepository roomRepository = new RoomRepository();
    private static final ClientRepository clientRepository = new ClientRepository();
//    @Test
//    void ticketAddTest(){
//
//            TicketManager ticketManager = new TicketManager(ticketRepository);
//            ClientManager clientManager = new ClientManager(clientRepository);
//            ShowManager showManager = new ShowManager(showRepository);
//            RoomManager roomManager = new RoomManager(roomRepository);
//
//            Date date = new Date(2000,1,1);
//            Client client = new Client(date,"100100100", Client.ClientType.minor,"Janek","Kowalski");
//            Room room = new Room(1,2);
//            Show show = new Show(1l, room, LocalDateTime.now(),LocalDateTime.now().plusHours(2), Show.ShowType.show3D);
//            Ticket ticket = new Ticket(show,client,10, Ticket.TicketType.minorTicket);
//
//            clientRepository.add(client);
//            roomRepository.add(room);
//            showRepository.add(show);
//
//            //Sprawdzenie czy ticket zostanie dodany za pomoca Repository
//            assertNotNull(ticketRepository.add(ticket));
//
//            //Sprawdzenie czy ticket zostanie dodany za pomoca Managera
//            assertTrue(ticketManager.tryBook(show,client,5, Ticket.TicketType.adultTicket));
//
//            //Sprawdzenie czy nie mozna dodac kolejnego ticketu
////            assertFalse(ticketManager.tryBook(show,client,5, Ticket.TicketType.adultTicket));
//
//    }
//
//    @Test
//    void ticketRemoveTest(){
//            TicketManager ticketManager = new TicketManager(ticketRepository);
//            ClientManager clientManager = new ClientManager(clientRepository);
//            ShowManager showManager = new ShowManager(showRepository);
//            RoomManager roomManager = new RoomManager(roomRepository);
//
//            Date date = new Date(2000,1,1);
//            Client client = new Client(date,"100100100", Client.ClientType.minor,"Janek","Kowalski");
//            Room room = new Room(1,2);
//            Show show = new Show(room, LocalDateTime.now(),LocalDateTime.now().plusHours(2), Show.ShowType.show3D);
//            Ticket ticket = new Ticket(show,client,10, Ticket.TicketType.minorTicket);
//            Ticket ticket2 = new Ticket(show,client,10, Ticket.TicketType.minorTicket);
//
//            clientRepository.add(client);
//            roomRepository.add(room);
//            showRepository.add(show);
//
//            ticketRepository.add(ticket);
//            ticketRepository.add(ticket2);
//
//            //Sprawdzenie czy mozna usunac za pomoca Managera
//            assertTrue(ticketManager.remove(ticket));
//            //Sprawdzenie czy mozna usunac za pomoca Repository
//            assertTrue(ticketRepository.remove(ticket2));
//    }
}

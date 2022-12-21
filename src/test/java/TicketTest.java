//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import managers.ClientManager;
//import managers.RoomManager;
//import managers.ShowManager;
//import managers.TicketManager;
//import model.Client;
//import model.Room;
//import model.Show;
//import model.Ticket;
//import org.junit.jupiter.api.Test;
//import repositories.ClientRepository;
//import repositories.RoomRepository;
//import repositories.ShowRepository;
//import repositories.TicketRepository;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//public class TicketTest {
//
//    private static final TicketRepository ticketRepository = new TicketRepository();
//    private static final ShowRepository showRepository = new ShowRepository();
//    private static final RoomRepository roomRepository = new RoomRepository();
//    private static final ClientRepository clientRepository = new ClientRepository();
//
//    TicketManager ticketManager = new TicketManager(ticketRepository);
//    @Test
//    void ticketAddTest(){
//            Date date = new Date(2000,1,1);
//            Client client = new Client(date,"100100100", Client.ClientType.minor,"Janek","Kowalski");
//            Room room = new Room(1,2);
//            Show show = new Show(1l, room, LocalDateTime.now(),LocalDateTime.now().plusHours(2), Show.ShowType.show3D);
//            Ticket ticket = new Ticket(1l,show,client,10, Ticket.TicketType.minorTicket);
//
//            clientRepository.add(client);
//            roomRepository.add(room);
//            showRepository.add(show);
//
//            long oldSize1 = ticketRepository.size();
//
//            //Sprawdzenie czy ticket zostanie dodany za pomoca Repository
//            assertNotNull(ticketRepository.add(ticket));
//            assertEquals(oldSize1 + 1, ticketRepository.size());
//
//            long oldSize2 = ticketRepository.size();
//
//            //Sprawdzenie czy ticket zostanie dodany za pomoca Managera
//            assertTrue(ticketManager.tryBook(2l,show,client,5, Ticket.TicketType.adultTicket));
//            assertEquals(oldSize2 + 1, ticketRepository.size());
//
//    }
//
//    @Test
//    void ticketRemoveTest(){
//            Date date = new Date(2000,1,1);
//            Client client = new Client(date,"100100100", Client.ClientType.minor,"Janek","Kowalski");
//            Room room = new Room(1,2);
//            Show show = new Show(1l, room, LocalDateTime.now(),LocalDateTime.now().plusHours(2), Show.ShowType.show3D);
//            Ticket ticket = new Ticket(1l,show,client,10, Ticket.TicketType.minorTicket);
//            Ticket ticket2 = new Ticket(2l,show,client,10, Ticket.TicketType.minorTicket);
//
//            clientRepository.add(client);
//            roomRepository.add(room);
//            showRepository.add(show);
//
//            assertNotNull(ticketRepository.add(ticket));
//            assertNotNull(ticketRepository.add(ticket2));
//
//            long oldSize1 = ticketRepository.size();
//
//            //Sprawdzenie czy mozna usunac za pomoca Repository
//            ticketRepository.remove(ticket);
//            assertEquals(oldSize1 - 1, ticketRepository.size());
//
//            long oldSize2 = ticketRepository.size();
//
//            //Sprawdzenie czy mozna usunac za pomoca Repository
//            ticketRepository.remove(ticket2);
//            assertEquals(oldSize2 - 1, ticketRepository.size());
//    }
//
//    @Test
//    void getTicketTest(){
//        Date date = new Date(2000,1,1);
//        Client client = new Client(date,"100100100", Client.ClientType.minor,"Janek","Kowalski");
//        Room room = new Room(1,2);
//        Show show = new Show(1l, room, LocalDateTime.now(),LocalDateTime.now().plusHours(2), Show.ShowType.show3D);
//        Ticket ticket = new Ticket(1l,show,client,10, Ticket.TicketType.minorTicket);
//
//        ticketRepository.add(ticket);
//
//        //Sprawdzenie czy uuid ticketu bedzie sie zgadzal przy uzyciu funkcji get
//        assertEquals(ticket.getUuid(),ticketRepository.get(ticket).getUuid());
//
//    }
//
//    @Test
//    void updateTicketTest(){
//        Date date = new Date(2000,1,1);
//        Client client = new Client(date,"100100100", Client.ClientType.minor,"Janek","Kowalski");
//        Room room = new Room(1,2);
//        Show show = new Show(1l, room, LocalDateTime.now(),LocalDateTime.now().plusHours(2), Show.ShowType.show3D);
//        Ticket ticket = new Ticket(1l,show,client,10, Ticket.TicketType.minorTicket);
//
//        ticketRepository.add(ticket);
//
//        ticket.setPrice(29);
//        ticketRepository.update(ticket);
//
//        Ticket ticket_updated = ticketRepository.getByUUID(ticket.getUuid());
//
//        assertEquals(29,ticket_updated.getPrice());
//    }
//
//}

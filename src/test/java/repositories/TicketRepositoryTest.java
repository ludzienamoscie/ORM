package repositories;
import com.datastax.oss.driver.api.core.CqlSession;
import managers.CinemaManager;
import model.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest extends BasicsTest {

    private static CqlSession session = CinemaManager.initSession();

    private TicketRepository TicketRepository = new TicketRepository(session);

    private ShowRepository ShowRepository = new ShowRepository(session);

    private RoomRepository RoomRepository = new RoomRepository(session);

    private ClientRepository ClientRepository = new ClientRepository(session);

    private Show show;
    private Room room;
    private Client client;
    private Ticket ticket;

    @Test
    public void testAddAndGet() {
        room = new Room(randomString(),randomInt());
        show = new Show(randomString(),room.getRoom_id(),LocalDate.now(),LocalDate.now().plusDays(1),randomString());
        client = new Client(randomString(), randomString(), randomString(), randomString(), randomString());
        ticket = new Ticket(randomString(), show.getShow_id(), client.getClient_id(),10,randomString());

        RoomRepository.add(room);
        ShowRepository.add(show);
        ClientRepository.add(client);

        //Dodanie do bazy danych ticket
        TicketRepository.add(ticket);

        //Sprawdzenie za pomoca GET czy w bazie danych ticket jest tym samym ktory dodajemy
        assertEquals(ticket,TicketRepository.get(ticket.getTicket_id()));
    }

    @Test
    public void testDelete(){
        room = new Room(randomString(),randomInt());
        show = new Show(randomString(),room.getRoom_id(),LocalDate.now(),LocalDate.now().plusDays(1),randomString());
        client = new Client(randomString(), randomString(), randomString(), randomString(), randomString());
        ticket = new Ticket(randomString(), show.getShow_id(), client.getClient_id(),10,randomString());

        RoomRepository.add(room);
        ShowRepository.add(show);
        ClientRepository.add(client);

        //Dodanie ticket do bazy danych
        TicketRepository.add(ticket);

        //Usuniecie ticket z bazy danych
        TicketRepository.remove(ticket);

        //Sprawdznie czy w bazie danych nie ma takiego obiektu jak ticket
        assertThrows(NoSuchElementException.class, () -> TicketRepository.get(ticket.getTicket_id()));
    }

    @Test
    public void testUpdate(){
        room = new Room(randomString(),randomInt());
        show = new Show(randomString(),room.getRoom_id(),LocalDate.now(),LocalDate.now().plusDays(1),randomString());
        client = new Client(randomString(), randomString(), randomString(), randomString(), randomString());
        ticket = new Ticket(randomString(), show.getShow_id(), client.getClient_id(),10,randomString());

        RoomRepository.add(room);
        ShowRepository.add(show);
        ClientRepository.add(client);

        //Dodanie ticket do bazy danych
        TicketRepository.add(ticket);

        //Stworzenie ticketUpdated ktory jest taki sam jak ticket
        Ticket ticketUpdated = ticket;

        //Zmiana price dla ticketUpdated
        ticketUpdated.setPrice(20);

        //Update ticketUpdated (update ticket o konktretnym id)
        TicketRepository.update(ticketUpdated);

        //Sprawdzenie czy poprawnie zostaly zupdatowane dane
        assertEquals(ticketUpdated,TicketRepository.get(ticketUpdated.getTicket_id()));
    }

    @AfterAll
    public static void closeSession() {
        session.close();
    }
}

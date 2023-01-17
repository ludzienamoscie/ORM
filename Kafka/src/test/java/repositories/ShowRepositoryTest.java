package test.java.repositories;
import com.datastax.oss.driver.api.core.CqlSession;
import managers.CinemaManager;
import model.BasicsTest;
import model.Room;
import model.Show;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class ShowRepositoryTest extends BasicsTest {

    private static CqlSession session = CinemaManager.initSession();
    private ShowRepository repository = new ShowRepository(session);

    private RoomRepository Roomrepository = new RoomRepository(session);

    private Show show;
    private Room room;

    @Test
    public void testAddAndGet() {

        room = new Room(randomString(),randomInt());
        show = new Show(randomString(),room.getRoom_id(),LocalDate.now(),LocalDate.now().plusDays(1),randomString());

        Roomrepository.add(room);

        //Dodanie do bazy danych show
        repository.add(show);

        //Sprawdzenie za pomoca GET czy w bazie danych show jest tym samym ktory dodajemy
        assertEquals(show,repository.get(show.getShow_id()));
    }

    @Test
    public void testDelete(){
        room = new Room(randomString(),randomInt());
        show = new Show(randomString(),room.getRoom_id(),LocalDate.now(),LocalDate.now().plusDays(1),randomString());

        Roomrepository.add(room);

        //Dodanie show do bazy danych
        repository.add(show);

        //Usuniecie show z bazy danych
        repository.remove(show);

        //Sprawdznie czy w bazie danych nie ma takiego obiektu jak show
        assertThrows(NoSuchElementException.class, () -> repository.get(show.getShow_id()));
    }

    @Test
    public void testUpdate(){
        room = new Room(randomString(),randomInt());
        show = new Show(randomString(),room.getRoom_id(),LocalDate.now(),LocalDate.now().plusDays(1),randomString());

        Roomrepository.add(room);

        //Dodanie show do bazy danych
        repository.add(show);

        //Stworzenie showUpdatated ktory jest taki sam jak show
        Show showUpdated = show;

        //Zmiana lastName dla clientUpdated
        showUpdated.setEndTime(LocalDate.now().plusDays(2));

        //Update showUpdated (update show o konktretnym id)
        repository.update(showUpdated);

        //Sprawdzenie czy poprawnie zostaly zupdatowane dane
        assertEquals(showUpdated,repository.get(showUpdated.getShow_id()));
    }

    @AfterAll
    public static void closeSession() {
        session.close();
    }
}

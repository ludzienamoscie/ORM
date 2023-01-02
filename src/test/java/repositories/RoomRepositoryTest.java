package repositories;


import com.datastax.oss.driver.api.core.CqlSession;
import managers.CinemaManager;

import model.BasicsTest;
import model.Client;

import model.Room;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;



import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class RoomRepositoryTest extends BasicsTest {

    private static CqlSession session = CinemaManager.initSession();
    private RoomRepository repository = new RoomRepository(session);

    private Room room;

    @Test
    public void testAddAndGet() {
        room = new Room(randomString(),1);

        //Dodanie do bazy danych pokoju
        repository.add(room);

        //Sprawdzenie za pomoca GET czy w bazie danych client1 i client2 sa tymi samymi ktorych dodajemy
        assertEquals(room,repository.get(room.getRoom_id()));
    }

    @Test
    public void testDelete(){
        room = new Room(randomString(),randomInt());

        //Dodanie klienta do bazy danych
        repository.add(room);

        //Usuniecie klienta z bazy danych
        repository.remove(room);

        //Sprawdznie czy w bazie danych nie ma takiego obiektu jak klient
        assertThrows(NoSuchElementException.class, () -> repository.get(room.getRoom_id()));
    }

    @Test
    public void testUpdate(){
        room = new Room(randomString(),randomInt());

        //Dodanie klienta do bazy danych
        repository.add(room);

        //Stworzenie clientUpdated ktory jest taki sam jak client
        Room roomUpdated = room;

        //Zmiana lastName dla clientUpdated
        roomUpdated.setCapacity(2);

        //Update clientUpdated (update klienta o konktretnym id)
        repository.update(roomUpdated);

        //Sprawdzenie czy poprawnie zostaly zupdatowane dane
        assertEquals(roomUpdated,repository.get(roomUpdated.getRoom_id()));
    }

    @AfterAll
    public static void closeSession() {
        session.close();
    }
}

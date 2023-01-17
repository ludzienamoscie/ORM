package test.java.repositories;
import com.datastax.oss.driver.api.core.CqlSession;
import managers.CinemaManager;
import model.BasicsTest;
import model.Client;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class ClientRepositoryTest extends BasicsTest {

    private static CqlSession session = CinemaManager.initSession();
    private ClientRepository repository = new ClientRepository(session);

    private Client client;

    private Client client2;

    @Test
    public void testAddAndGet() {
        client = new Client(randomString(), randomString(), randomString(), randomString(), randomString());
        client2 = new Client(randomString(), randomString(), randomString(), randomString(), randomString());

        //Dodanie do bazy danych dwóch klientów o randomowych wartosciach
        repository.add(client);
        repository.add(client2);

        //Sprawdzenie za pomoca GET czy w bazie danych client1 i client2 sa tymi samymi ktorych dodajemy
        assertEquals(client,repository.get(client.getClient_id()));
        assertEquals(client2,repository.get(client2.getClient_id()));
    }

    @Test
    public void testDelete(){
        client = new Client(randomString(), randomString(), randomString(), randomString(), randomString());

        //Dodanie klienta do bazy danych
        repository.add(client);

        //Usuniecie klienta z bazy danych
        repository.remove(client);

        //Sprawdznie czy w bazie danych nie ma takiego obiektu jak klient
        assertThrows(NoSuchElementException.class, () -> repository.get(client.getClient_id()));
    }

    @Test
    public void testUpdate(){
        client = new Client(randomString(), randomString(), randomString(), randomString(), randomString());

        //Dodanie klienta do bazy danych
        repository.add(client);

        //Stworzenie clientUpdated ktory jest taki sam jak client
        Client clientUpdated = client;

        //Zmiana lastName dla clientUpdated
        clientUpdated.setLastName("LastName");

        //Update clientUpdated (update klienta o konktretnym id)
        repository.update(clientUpdated);

        //Sprawdzenie czy poprawnie zostaly zupdatowane dane
        assertEquals(clientUpdated,repository.get(clientUpdated.getClient_id()));
    }

    @AfterAll
    public static void closeSession() {
        session.close();
    }
}

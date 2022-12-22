package repositories;


import com.datastax.oss.driver.api.core.CqlSession;
import managers.CinemaManager;

import model.BasicsTest;
import model.Client;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import repositories.ClientRepository;


import static org.junit.jupiter.api.Assertions.*;

public class ClientRepositoryTest extends BasicsTest {

    private static CqlSession session = CinemaManager.initSession();
    private ClientRepository repository = new ClientRepository(session);


    @Test
    public void testAddAndGet() {
        Client client = new Client(randomString(), randomString(), randomString(), randomString(), randomString());

        repository.add(client);

        assertEquals(client, repository.get(client.getClient_id()));
    }

    @AfterAll
    public static void closeSession() {
        session.close();
    }
}

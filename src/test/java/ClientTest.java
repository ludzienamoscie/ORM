import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import managers.ClientManager;
import model.Client;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import repositories.ClientRepository;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
public class ClientTest {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CINEMA");

    private static final ClientRepository clientRepository = new ClientRepository();

    @Test
    void clientAddTest(){

            ClientManager clientManager = new ClientManager(clientRepository);

            Date date = new Date(2000,10,9);
            Client client1 = new Client(date,"500500500", Client.ClientType.adult,"Jan","Kowalski");

            //Sprawdzenie czy clientRepository dodaje klienta
            assertNotNull(clientRepository.add(client1));

            //Sprawdzenie czy drugi identyczny klient sie nie doda
            assertNull(clientRepository.add(client1));

            //Sprawdzenie czy clientManager dodaje klienta
            assertTrue(clientManager.add(date,"400400400", Client.ClientType.minor,"Janina","Kowalska"));
    }

    @Test
    void clientRemoveTest(){

            ClientManager clientManager = new ClientManager(clientRepository);

            Date date = new Date(2000,10,9);
            Client client1 = new Client(date,"500500500", Client.ClientType.adult,"Jan","Kowalski");
            Client client2 = new Client(date,"400400400", Client.ClientType.minor,"Janina","Kowalska");

            assertNotNull(clientRepository.add(client1));
            assertNotNull(clientRepository.add(client2));

            //Sprawdzenie czy client1 zostanie usuniety za pomoca Managera
            assertTrue(clientManager.remove(client1));

            //Sprawdzenie czy client2 zostanie usuniety za pomoca Repository
            assertTrue(clientRepository.remove(client2));

    }
}

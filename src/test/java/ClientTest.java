
import managers.ClientManager;
import model.Client;
import org.junit.jupiter.api.Test;
import repositories.ClientRepository;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {



    private static final ClientRepository clientRepository = new ClientRepository();
    private ClientManager clientManager = new ClientManager(clientRepository);

    @Test
    void clientAddTest() {
        Date date = new Date(2000, 10, 9);
        Client client1 = new Client(date, "500500500", Client.ClientType.adult, "Jan", "Kowalski");
        long oldSize1 = clientRepository.size();

        //Sprawdzenie czy clientRepository dodaje klienta
        assertNotNull(clientRepository.add(client1));
        assertEquals(oldSize1 + 1, clientRepository.size());

        long oldSize2 = clientRepository.size();

        //Sprawdzenie czy clientManager dodaje klienta
        assertTrue(clientManager.add(date, "400400400", Client.ClientType.minor, "Janina", "Kowalska"));
        assertEquals(oldSize2 + 1, clientRepository.size());
    }


    @Test
    void clientRemoveTest() {

        ClientManager clientManager = new ClientManager(clientRepository);

        Date date = new Date(2000, 10, 9);
        Client client1 = new Client(date, "500500500", Client.ClientType.adult, "Jan", "Kowalski");
        Client client2 = new Client(date, "400400400", Client.ClientType.minor, "Janina", "Kowalska");

        assertNotNull(clientRepository.add(client1));
        assertNotNull(clientRepository.add(client2));

        long oldSize1 = clientRepository.size();

        //Sprawdzenie czy client1 zostanie usuniety za pomoca Managera
        clientRepository.remove(client1);
        assertEquals(oldSize1 - 1, clientRepository.size());

        long oldSize2 = clientRepository.size();

       //Sprawdzenie czy client2 zostanie usuniety za pomoca Repository
        clientRepository.remove(client2);
        assertEquals(oldSize2 - 1, clientRepository.size());
    }

    @Test
    void getClientTest() {
        Date date = new Date(2000, 10, 9);
        Client client = new Client(date, "500500500", Client.ClientType.adult, "Jan", "Kowalski");
        clientRepository.add(client);

        //Sprawdzenie czy uuid clienta bedzie sie zgadzal przy uzyciu funkcji get
        assertEquals(client.getUuid(),clientRepository.get(client).getUuid());
    }
}

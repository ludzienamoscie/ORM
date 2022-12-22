//
//import com.datastax.oss.driver.api.core.CqlSession;
//import managers.CinemaManager;
//import managers.ClientManager;
//import model.Client;
//import org.junit.jupiter.api.Test;
//import repositories.ClientRepository;
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ClientTest {
//
//    private static CqlSession session = CinemaManager.initSession();
//    private static final ClientRepository clientRepository = new ClientRepository();
//    private ClientManager clientManager = new ClientManager(clientRepository);
//
//    private Client client;
//
//    @Test
//    void clientAddTest() {
//
//
//
//
//    }
//
//
//    @Test
//    void clientRemoveTest() {
//        Date date = new Date(2000, 10, 9);
//        Client client1 = new Client(date, "500500500", Client.ClientType.adult, "Jan", "Kowalski");
//        Client client2 = new Client(date, "400400400", Client.ClientType.minor, "Janina", "Kowalska");
//
//        assertNotNull(clientRepository.add(client1));
//        assertNotNull(clientRepository.add(client2));
//
//        long oldSize1 = clientRepository.size();
//
//        //Sprawdzenie czy client1 zostanie usuniety za pomoca Repository
//        clientRepository.remove(client1);
//        assertEquals(oldSize1 - 1, clientRepository.size());
//
//        long oldSize2 = clientRepository.size();
//
//       //Sprawdzenie czy client2 zostanie usuniety za pomoca Managera
//        clientManager.remove(client2);
//        assertEquals(oldSize2 - 1, clientRepository.size());
//    }
//
//    @Test
//    void getClientTest() {
//        Date date = new Date(2000, 10, 9);
//        Client client = new Client(date, "500500500", Client.ClientType.adult, "Jan", "Kowalski");
//        clientRepository.add(client);
//
//        //Sprawdzenie czy uuid clienta bedzie sie zgadzal przy uzyciu funkcji get
//        assertEquals(client.getUuid(),clientRepository.get(client).getUuid());
//    }
//
//    @Test
//    void updateClientTest() {
//        Date date = new Date(2000, 10, 9);
//        Client client = new Client(date, "500500500", Client.ClientType.adult, "Jan", "Kowalski");
//        clientRepository.add(client);
//
//        client.setFirstName("Janek");
//        client.setLastName("Kowalewicz");
//        clientRepository.update(client);
//
//        Client client_updated = clientRepository.getByUUID(client.getUuid());
//
//        assertEquals("Janek",client_updated.getFirstName());
//        assertEquals("Kowalewicz",client_updated.getLastName());
//
//    }
//}

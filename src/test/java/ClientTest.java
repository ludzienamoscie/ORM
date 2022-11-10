import com.mongodb.client.model.Filters;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import managers.ClientManager;
import model.Client;
import org.bson.BsonDocumentReader;
import org.bson.conversions.Bson;
import org.bson.json.JsonObject;
import org.bson.json.JsonWriter;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import repositories.ClientRepository;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

//    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CINEMA");

    private static final ClientRepository clientRepository = new ClientRepository();
    private ClientManager clientManager = new ClientManager(clientRepository);

    @Test
    void clientAddTest() {
        Date date = new Date(2000, 10, 9);
        Client client1 = new Client(UUID.randomUUID(),date, "500500500", Client.ClientType.adult, "Jan", "Kowalski");
        assertNotNull(clientRepository.add(client1));

//            ClientManager clientManager = new ClientManager(clientRepository);
//
//            Date date = new Date(2000,10,9);
//            Client client1 = new Client(date,"500500500", Client.ClientType.adult,"Jan","Kowalski");
//
        //Sprawdzenie czy clientRepository dodaje klienta
        long oldSize = clientRepository.size();


        //Sprawdzenie czy drugi identyczny klient sie nie doda
//            assertNull(clientRepository.add(client1))
//        clientRepository.add(client1);
//        assertEquals(oldSize + 1 , clientRepository.size());

        //Sprawdzenie czy clientManager dodaje klienta
        assertTrue(clientManager.add(UUID.randomUUID(),date, "400400400", Client.ClientType.minor, "Janina", "Kowalska"));

        assertEquals(oldSize + 1, clientRepository.size());
    }


    @Test
    void clientRemoveTest() {

        ClientManager clientManager = new ClientManager(clientRepository);

        Date date = new Date(2000, 10, 9);
        Client client1 = new Client(UUID.randomUUID(),date, "500500500", Client.ClientType.adult, "Jan", "Kowalski");
        Client client2 = new Client(UUID.randomUUID(),date, "400400400", Client.ClientType.minor, "Janina", "Kowalska");

        assertNotNull(clientRepository.add(client1));
        assertNotNull(clientRepository.add(client2));

        long oldSize = clientRepository.size();
        System.out.print(oldSize);
        //Sprawdzenie czy client1 zostanie usuniety za pomoca Managera
        clientRepository.remove(client1);
        assertEquals(oldSize - 1, clientRepository.size());
//
//        //Sprawdzenie czy client2 zostanie usuniety za pomoca Repository
        clientRepository.remove(client2);
        assertEquals(oldSize - 2, clientRepository.size());

    }
//
//    @Test
//    void updateClientTest() {
//        Date date = new Date(2000, 10, 9);
//        Client client = new Client(date, "500500500", Client.ClientType.adult, "Jan", "Kowalski");
//        clientRepository.add(client);
//        Client client2 = clientRepository.get(client.getUUID());
//        client2.setClientType(Client.ClientType.senior);
//
//        clientRepository.update(client, client2);
//
//        assertEquals(client2.getClientType(), clientRepository.get(client.getUUID()));
//    }
//
//    @Test
//    void toDocTest() {
//        Date date = new Date(2000, 10, 9);
//        Client client = new Client(date, "500500500", Client.ClientType.adult, "Jan", "Kowalski");
//    }
}

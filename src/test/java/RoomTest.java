import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.validation.constraints.AssertFalse;
import managers.ClientManager;
import managers.RoomManager;
import managers.ShowManager;
import model.Room;
import org.junit.jupiter.api.Test;
import repositories.ClientRepository;
import repositories.RoomRepository;

import static org.junit.jupiter.api.Assertions.*;


public class RoomTest {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CINEMA");

    private static final RoomRepository roomRepository = new RoomRepository();

//    @Test
//    void roomAddTest(){
//
//            RoomManager roomManager = new RoomManager(roomRepository);
//
//            Room room1 = new Room(7,10);
//            Room room2 = new Room(8,12);
//
//            //Sprawdzenie czy roomRepository dodaje pokoje
//            assertNotNull(roomRepository.add(room1));
//            assertNotNull(roomRepository.add(room2));
//
//            //Sprawdzenie czy drugi identyczny pokoj sie nie doda
//            assertNull(roomRepository.add(room1));
//
//            //Sprawdzenie czy roomManager dodaje pokoje
//            assertTrue(roomManager.add(1,1));
//            assertTrue(roomManager.add(2,5));
//
//            //Sprawdzenie czy pokoj z powtarzajacym roomNumber sie nie doda
//            assertFalse(roomManager.add(1,10));
//
//    }
//
//    @Test
//    void roomRemoveTest(){
//
//            RoomManager roomManager = new RoomManager(roomRepository);
//
//            Room room1 = new Room(1,1);
//            Room room2 = new Room(2,1);
//
//            assertNotNull(roomRepository.add(room1));
//            assertNotNull(roomRepository.add(room2));
//
//            //Sprawdzenie czy pokoj1 zostanie usuniety za pomoca Managera
//            assertTrue(roomManager.remove(room1));
//
//            //Sprawdzenie czy pokoj2 zostanie usuniety za pomoca Repository
//            assertTrue(roomRepository.remove(room2));
//
//    }

}

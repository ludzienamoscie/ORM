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

    private static final RoomRepository roomRepository = new RoomRepository();

    private RoomManager roomManager = new RoomManager(roomRepository);

    @Test
    void roomAddTest(){
        Room room = new Room(7,10);
        long oldSize1 = roomRepository.size();

        //Sprawdzenie czy roomRepository dodaje pokoj
        assertNotNull(roomRepository.add(room));
        assertEquals(oldSize1 + 1,roomRepository.size());

        long oldSize2 = roomRepository.size();

        //Sprawdzenie czy roomManager dodaje pokoj
        assertTrue(roomManager.add(23,1));
        assertEquals(oldSize2 + 1, roomRepository.size());
    }
//
    @Test
    void roomRemoveTest(){
        Room room1 = new Room(1,1);
        Room room2 = new Room(2,1);

        assertNotNull(roomRepository.add(room1));
        assertNotNull(roomRepository.add(room2));

        long oldSize1 = roomRepository.size();

        //Sprawdzenie czy room1 zostanie usuniety za pomoca repository
        roomRepository.remove(room1);
        assertEquals(oldSize1 - 1, roomRepository.size());

        long oldSize2 = roomRepository.size();

        //Sprawdzenie czy room2 zostanie usuniety za pomoca managera
        roomManager.remove(room2);
        assertEquals(oldSize2 - 1, roomRepository.size());
    }

    @Test
    void getRoomTest(){
        Room room = new Room(1,1);
        roomRepository.add(room);

        //Sprawdzenie czy UUID room'u bedzie sie zgadzal przy uzyciu funkcji get
        assertEquals(room.getUuid(),roomRepository.get(room).getUuid());
    }

    @Test
    void updateClientTest(){
        Room room = new Room(1,1);
        roomRepository.add(room);

        room.setRoomNumber(23);
        room.setCapacity(100);
        roomRepository.update(room);

        Room room_updated = roomRepository.getByUUID(room.getUuid());

        assertEquals(23,room_updated.getRoomNumber());
        assertEquals(100,room_updated.getCapacity());
    }

}

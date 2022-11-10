import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import managers.ClientManager;
import managers.RoomManager;
import managers.ShowManager;
import model.Room;
import model.Show;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import repositories.ClientRepository;
import repositories.RoomRepository;
import repositories.ShowRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
public class ShowTest {
//    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CINEMA");

    private static final ShowRepository showRepository = new ShowRepository();
    private static final RoomRepository roomRepository = new RoomRepository();

    @Test
    void showAddTest(){

            ShowManager showManager = new ShowManager(showRepository);
            RoomManager roomManager = new RoomManager(roomRepository);

            Room room = new Room(1,1);
            Show show1 = new Show(1l, room, LocalDateTime.now().plusHours(2),LocalDateTime.now().plusHours(4), Show.ShowType.show2D);
            Show show2 = new Show(2l, room, LocalDateTime.now().plusDays(1).plusHours(2),LocalDateTime.now().plusDays(1).plusHours(4), Show.ShowType.show3D);

            roomRepository.add(room);
            //Sprawdzenie czy showRepository dodaje show
            assertNotNull(showRepository.add(show1));
            assertNotNull(showRepository.add(show2));

            //Sprawdzenie czy drugi identyczny show sie nie doda
//            assertNull(showRepository.add(show1));

            //Sprawdzenie czy showManager dodaje show
            assertTrue(showManager.add(1l, room,LocalDateTime.now().plusDays(10),LocalDateTime.now().plusDays(10).plusHours(2), Show.ShowType.show2D));
    }

//    @Test
//    void showRemoveTest(){
//            ShowManager showManager = new ShowManager(showRepository);
//            RoomManager roomManager = new RoomManager(roomRepository);
//
//            Room room = new Room(1,1);
//            Show show1 = new Show(room, LocalDateTime.now().plusHours(2),LocalDateTime.now().plusHours(4), Show.ShowType.show2D);
//            Show show2 = new Show(room, LocalDateTime.now().plusDays(1).plusHours(2),LocalDateTime.now().plusDays(1).plusHours(4), Show.ShowType.show3D);
//
//            roomRepository.add(room);
//            showRepository.add(show1);
//            showRepository.add(show2);
//
//            //Sprawdzenie czy show1 zostanie usuniete za pomoca Managera
//            assertTrue(showManager.remove(show1));
//
//            //Sprawdzenie czy show2 zostanie usuniete za pomoca Repository
//            assertTrue(showRepository.remove(show2));
//
//    }
}

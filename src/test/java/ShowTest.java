//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import managers.ClientManager;
//import managers.RoomManager;
//import managers.ShowManager;
//import model.Room;
//import model.Show;
//import net.bytebuddy.asm.Advice;
//import org.junit.jupiter.api.Test;
//import repositories.ClientRepository;
//import repositories.RoomRepository;
//import repositories.ShowRepository;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//public class ShowTest {
//
//    private static final ShowRepository showRepository = new ShowRepository();
//    private static final RoomRepository roomRepository = new RoomRepository();
//
//    private ShowManager showManager = new ShowManager(showRepository);
//
//
//
//    @Test
//    void showAddTest(){
//
//            Room room = new Room(1,1);
//            Show show = new Show(1l, room, LocalDateTime.now().plusHours(2),LocalDateTime.now().plusHours(4), Show.ShowType.show2D);
//            roomRepository.add(room);
//
//             long oldSize1 = showRepository.size();
//
//             //Sprawdzenie czy showRepository dodaje show
//             assertNotNull(showRepository.add(show));
//             assertEquals(oldSize1 + 1, showRepository.size());
//
//             long oldSize2 = showRepository.size();
//
//             //Sprawdzenie czy showManager dodaje show
//             assertTrue(showManager.add(1l, room,LocalDateTime.now().plusDays(10),LocalDateTime.now().plusDays(10).plusHours(2), Show.ShowType.show2D));
//             assertEquals(oldSize2 + 1, showRepository.size());
//   }
//
//    @Test
//    void showRemoveTest(){
//            Room room = new Room(1,1);
//            Show show1 = new Show(1l,room, LocalDateTime.now().plusHours(2),LocalDateTime.now().plusHours(4), Show.ShowType.show2D);
//            Show show2 = new Show(2l,room, LocalDateTime.now().plusDays(1).plusHours(2),LocalDateTime.now().plusDays(1).plusHours(4), Show.ShowType.show3D);
//
//            roomRepository.add(room);
//            showRepository.add(show1);
//            showRepository.add(show2);
//
//            long oldSize1 = showRepository.size();
//
//            //Sprawdzenie czy show1 zostanie usuniete za pomoca Repository
//            showRepository.remove(show1);
//            assertEquals(oldSize1 - 1, showRepository.size());
//
//             long oldSize2 = showRepository.size();
//
//             //Sprawdzenie czy show2 zostanie usuniete za pomoca Managera
//            showManager.remove(show2);
//            assertEquals(oldSize2 - 1, showRepository.size());
//    }
//
//    @Test
//    void getShowTest(){
//        Room room = new Room(1,1);
//        Show show = new Show(1l,room, LocalDateTime.now().plusHours(2),LocalDateTime.now().plusHours(4), Show.ShowType.show2D);
//        showRepository.add(show);
//
//        //Sprawdzenie czy uuid show bedzie sie zgadzal przy uzyciu funkcji get
//        assertEquals(show.getUuid(),showRepository.get(show).getUuid());
//    }
//
//    @Test
//    void updateShowTest(){
//        Room room = new Room(1,1);
//        Show show = new Show(1l,room, LocalDateTime.now().plusHours(2),LocalDateTime.now().plusHours(4), Show.ShowType.show2D);
//        showRepository.add(show);
//
//        show.setShow_id(2l);
//        show.setShowType(Show.ShowType.show3D);
//        showRepository.update(show);
//
//        Show show_updated = showRepository.getByUUID(show.getUuid());
//
//        assertEquals(2l,show_updated.getShow_id());
//    }
//}

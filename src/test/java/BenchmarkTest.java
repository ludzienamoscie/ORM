//import managers.TicketManager;
//import model.Client;
//import model.Room;
//import model.Show;
//import model.Ticket;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import repositories.*;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//public class BenchmarkTest {
//
//    private static final TicketRepository ticketRepository = new TicketRepository();
//    private static final TicketRepository ticketCacheRepository = new TicketCacheRepository();
//
//    private static final TicketManager ticketManager = new TicketManager(ticketRepository);
//    private static final TicketManager ticketManagerCache = new TicketManager(ticketCacheRepository);
//
//    @BeforeAll
//    static void initialization(){
//
//        Date date = new Date(2000,1,1);
//        Client client = new Client(date,"100100100", Client.ClientType.minor,"Janek","Kowalski");
//        Room room = new Room(1,2);
//        Show show = new Show(1l, room, LocalDateTime.now(),LocalDateTime.now().plusHours(2), Show.ShowType.show3D);
//
//        ticketManagerCache.tryBook(1l,show,client,10, Ticket.TicketType.adultTicket);
//        ticketManagerCache.tryBook(2l,show,client,11, Ticket.TicketType.adultTicket);
//        ticketManagerCache.tryBook(3l,show,client,12, Ticket.TicketType.adultTicket);
//        ticketManagerCache.tryBook(4l,show,client,13, Ticket.TicketType.adultTicket);
//        ticketManagerCache.tryBook(5l,show,client,14, Ticket.TicketType.adultTicket);
//    }
//
//    void mongoTest(){
//       ticketManager.getByTicket(1l);
//       ticketManager.getByTicket(2l);
//       ticketManager.getByTicket(3l);
//       ticketManager.getByTicket(4l);
//       ticketManager.getByTicket(5l);
//    }
//
//    void redisCacheTest(){
//        ticketManagerCache.getByTicket(1l);
//        ticketManagerCache.getByTicket(2l);
//        ticketManagerCache.getByTicket(3l);
//        ticketManagerCache.getByTicket(4l);
//        ticketManagerCache.getByTicket(5l);
//    }
//
//    @Test
//    void Benchmark(){
//        long beginTime = System.currentTimeMillis();
//        for(int i = 0; i<100;i++){
//            mongoTest();
//        }
//        long endTime = System.currentTimeMillis();
//        long mongoTime = endTime - beginTime;
//
//        beginTime = System.currentTimeMillis();
//        for(int i = 0; i<100;i++){
//            redisCacheTest();
//        }
//        endTime = System.currentTimeMillis();
//        long redisCacheTime = endTime - beginTime;
//
//        System.out.println("Mongo time:" + mongoTime);
//        System.out.println("Redis cache time: " + redisCacheTime);
//        assertTrue(redisCacheTime < mongoTime);
//    }
//}

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import model.Client;
import model.Room;
import model.Show;
import model.Ticket;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPooled;
import repositories.ClientRepository;
import repositories.RoomRepository;
import repositories.ShowRepository;
import repositories.TicketRepository;
//import repositories.cache.TicketCache;
//import repositories.cache.TicketCacheDecorator;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class RedisTest {

    protected DefaultJedisClientConfig jedisClientConfig = DefaultJedisClientConfig.builder().build();
    protected JedisPooled RedisClient;
    protected Jsonb jsonb;

    @Test
    public void redisTest() {

        this.jedisClientConfig = DefaultJedisClientConfig.builder().build();
        this.RedisClient = new JedisPooled(new HostAndPort("localhost", 6379), jedisClientConfig);
        this.jsonb = JsonbBuilder.create();

        RedisClient.setex("1", 360, "test");
        RedisClient.setex("1", 40, "zmiana");
        RedisClient.setnx("2","nbd");
    }

//    static TicketCacheDecorator ticketCacheDecorator = new TicketCacheDecorator(new TicketRepository());
//    private static final ShowRepository showRepository = new ShowRepository();
//    private static final RoomRepository roomRepository = new RoomRepository();
//    private static final ClientRepository clientRepository = new ClientRepository();
//
//    @Test
//    public void decoratorTest() {
//        this.jedisClientConfig = DefaultJedisClientConfig.builder().build();
//        this.RedisClient = new JedisPooled(new HostAndPort("localhost", 6379), jedisClientConfig);
//        this.jsonb = JsonbBuilder.create();
//
//        Date date = new Date(2000,1,1);
//        Client client = new Client(date,"100100100", Client.ClientType.minor,"Janek","Kowalski");
//        Room room = new Room(1,2);
//        Show show = new Show(1l, room, LocalDateTime.now(),LocalDateTime.now().plusHours(2), Show.ShowType.show3D);
//
//        Ticket ticket = new Ticket(show,client,10, Ticket.TicketType.minorTicket);
//
//        assertNotNull(ticketCacheDecorator.add(ticket));
//    }

}

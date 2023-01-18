import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import managers.TicketManager;
import model.Client;
import model.Room;
import model.Show;
import model.Ticket;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPooled;
import repositories.*;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class RedisTest {
    private static final TicketCacheRepository ticketCacheRepository = new TicketCacheRepository();
    private static final TicketManager ticketManagerCache = new TicketManager(ticketCacheRepository);

    protected DefaultJedisClientConfig jedisClientConfig = DefaultJedisClientConfig.builder().build();
    protected JedisPooled RedisClient;
    protected Jsonb jsonb;

    @Test
    public void CacheRedisTest() {
        this.jedisClientConfig = DefaultJedisClientConfig.builder().build();
        this.RedisClient = new JedisPooled(new HostAndPort("localhost", 6379), jedisClientConfig);
        this.jsonb = JsonbBuilder.create();

        Date date = new Date(2000,1,1);
        Client client = new Client(date,"100100100", Client.ClientType.minor,"Janek","Kowalski");
        Room room = new Room(1,2);
        Show show = new Show(1l, room, LocalDateTime.now(),LocalDateTime.now().plusHours(2), Show.ShowType.show3D);
        Ticket ticket = new Ticket(2l,show,client,12, Ticket.TicketType.adultTicket);

        assertNotNull(ticketCacheRepository.add(ticket));
        assertTrue(ticketManagerCache.tryBook(1l,show,client,10, Ticket.TicketType.minorTicket));
    }

}

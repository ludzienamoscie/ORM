package repositories.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Ticket;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.Jedis;

import java.util.UUID;

public class TicketCache extends RedisCache {

    ObjectMapper obj;
    String prefix;

    public TicketCache() {
        super();
        obj = new ObjectMapper();
        obj.registerModule(new JavaTimeModule());
        prefix = "ticket:";
    }


    public void save(Ticket ticket) {
        String rentString;
        try {
            rentString = obj.writeValueAsString(ticket);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String key = prefix + ticket.getUuid().toString();
        pool.set(key, rentString);
    }

    public Ticket get(UUID uuid) {
        String key = prefix + uuid.toString();
        System.out.println(key);
        var ret = pool.get(key);
        return obj.convertValue(ret, Ticket.class);
    }

    public void delete(Ticket ticket) {
        String key = prefix + ticket.getUuid().toString();
        pool.del(key);
    }

    public void deleteAll() {
        DefaultJedisClientConfig clientConfig = DefaultJedisClientConfig.builder().build();
        try (Jedis jedis = new Jedis(getHostAndPort(), clientConfig)) {
            jedis.flushAll();
        }
    }

}

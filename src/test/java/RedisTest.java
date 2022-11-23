import Util.JedisClientConfig;
import com.lambdaworks.redis.*;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPooled;
import repositories.RedisCache;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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

}

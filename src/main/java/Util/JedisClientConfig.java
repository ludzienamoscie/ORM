package Util;

import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPooled;

import java.util.Set;

public class JedisClientConfig extends AbstractMongoRepository {
    private static JedisPooled pool;

    public void initConnection() {
        DefaultJedisClientConfig clientConfig = DefaultJedisClientConfig.builder().build();
        pool = new JedisPooled(new HostAndPort("localhost", 6379), clientConfig);
    }

}

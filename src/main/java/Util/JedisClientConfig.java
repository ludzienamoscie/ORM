package Util;

import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPooled;

import java.util.Set;

public class JedisClientConfig {
    private static JedisPooled pool;

    public void initConnection() {
        JedisClientConfig clientConfig = DefaultJedisClientConfig.builder().build();
        pool = new JedisPooled(new HostAndPort("localhost", 6379), clientConfig);
    }

    private void initDbConnection() {

        JedisClientConfig clientConfig = DefaultJedisClientConfig.builder().
                password("master123").build();

        Set<HostAndPort> clusterUris = Set.of(
                new HostAndPort("localhost", 7001),
                new HostAndPort("localhost", 7002),
                new HostAndPort("localhost", 7003),
                new HostAndPort("localhost", 7004),
                new HostAndPort("localhost", 7005),
                new HostAndPort("localhost", 7006)
        );

        cluster = new JedisCluster(clusterUris, clientConfig);
    }
}

package repositories.cache;

import com.google.common.cache.AbstractCache;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import com.lambdaworks.redis.RedisURI;
import redis.clients.jedis.*;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import static redis.clients.jedis.util.JedisURIHelper.getHostAndPort;

public class RedisCache {

    RedisClient redisClient;
    RedisConnection<String, String> connection;

    public RedisCache() {
        HostAndPort hnp = getHostAndPort();
        DefaultJedisClientConfig clientConfig = DefaultJedisClientConfig.builder().build();

        if(pool == null) {
            pool = new JedisPooled(hnp, clientConfig);
            task = new Healthcheck();
            timer = new Timer(true);
            healthy = TicketCache.checkHealthy();
            timer.scheduleAtFixedRate(task, 2, 2);
        }
    }

    public static String getConnectionString() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
            return appProps.getProperty("connectionString");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Property file not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public RedisConnection<String, String> getConnection() {
        return connection;
    }


    protected static HostAndPort getHostAndPort() {
        String connectionString = TicketCache.getConnectionString();
        return HostAndPort.from(connectionString);
    }

    // healthcheck

    private static TimerTask task = null;
    private static Timer timer = null;
    static class Healthcheck extends TimerTask {
        @Override
        public void run() {
            RedisCache.healthy = TicketCache.checkHealthy();
        }
    }

    private static boolean healthy;

    public static boolean checkHealthy() {
        HostAndPort hnp = getHostAndPort();
        DefaultJedisClientConfig clientConfig = DefaultJedisClientConfig.builder().build();
        try(Jedis jedis = new Jedis(hnp, clientConfig)) {
            try {
                return Objects.equals(jedis.ping(), "PONG");
            } catch(JedisConnectionException e) {
                return false;
            }
        }
    }

    public static boolean isHealthy() {
        return healthy;
    }

    // connection

    protected static JedisPooled pool;

    public void close() {
        connection.close();
        redisClient.shutdown();
    }

}

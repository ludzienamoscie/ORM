package repositories;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import com.lambdaworks.redis.RedisURI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RedisCache implements AutoCloseable {

    RedisClient redisClient;
    RedisConnection<String, String> connection;

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

    public RedisCache() {
        String connectionString = RedisCache.getConnectionString();
        redisClient = new RedisClient(RedisURI.create(connectionString));
        connection = redisClient.connect();
    }

    @Override
    public void close() {
        connection.close();
        redisClient.shutdown();
    }

}

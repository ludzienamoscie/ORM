package main.java.repositories;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import main.java.model.Client;
import main.java.redis.AbstractRedisConnector;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.jedis.search.Query;
import redis.clients.jedis.search.SearchResult;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal;

public class ClientRepository extends AbstractRedisConnector implements Repository<Client> {

    private Jsonb jsonb = JsonbBuilder.create();
    private ClientMongoRepository mongoRepository = new ClientMongoRepository();

    public ClientRepository() {
        super();
    }

    @Override
    public Client get(Object element) {
        try {
            Client client = (Client) element;
            return Optional.ofNullable(pool.jsonGet(clientPrefix + client.getClient_id(), Client.class))
                    .orElseThrow();
        } catch (JedisDataException e) {
            throw new JedisDataException("Redis operation failed", e);
        } catch (JedisException e) {
            return mongoRepository.get(element);
        }
    }

    @Override
    public void add(Client... elements) {
        try {
            Arrays.stream(elements).forEach(client ->
                    pool.jsonSet(clientPrefix + client.getClient_id(), jsonb.toJson(client)));
            mongoRepository.add(elements);
        } catch (JedisDataException e) {
            throw new JedisDataException("Redis operation failed", e);
        } catch (JedisException e) {
            throw new JedisException("Redis connection failed", e);
        }
    }

    @Override
    public void remove(Client... elements) {
        try {
            Arrays.stream(elements).forEach(client ->
                    pool.jsonDel(clientPrefix + client.getClient_id()));
            mongoRepository.remove(elements);
        } catch (JedisDataException e) {
            throw new JedisDataException("Redis operation failed", e);
        } catch (JedisException e) {
            throw new RuntimeException("Redis connection failed", e);
        }
    }

    @Override
    public void update(Client... elements) {
        try {
            Arrays.stream(elements).forEach(client ->
                    pool.jsonSet(clientPrefix + client.getClient_id(), jsonb.toJson(client)));
            mongoRepository.update(elements);
        } catch (JedisDataException e) {
            throw new JedisDataException("Redis operation failed", e);
        } catch (JedisException e) {
            throw new JedisException("Redis connection failed", e);
        }
    }

    @Override
    public List<Client> find(Object... elements) {
        try {
            return Optional.of(Arrays.stream(elements).map(this::get)
                    .collect(Collectors.toList())).orElseThrow();
        } catch (JedisException e) {
            return mongoRepository.find(elements);
        }
    }

    @Override
    public List<Client> getAll() {
        try {
            SearchResult searchResult = pool.ftSearch("client-search", new Query());

            return searchResult.getDocuments().stream()
                    .map(document -> pool.jsonGet(document.getId(), Client.class))
                    .collect(Collectors.toList());
        } catch (JedisDataException e) {
            e.printStackTrace();
            throw new JedisDataException("Redis operation failed", e);
        } catch (JedisException e) {
            return mongoRepository.getAll();
        }
    }

    @Override
    public Long size() {
        return pool.dbSize();
    }

    public void clear() {
        try (Jedis jedis = new Jedis(properties.getProperty("redisHostname"),
                Integer.parseInt(properties.getProperty("redisPort")))) {
            jedis.flushDB();
        } catch (JedisException e) {
            throw new JedisException("Redis operation failed", e);
        }
    }

    @Override
    public void close() throws Exception {
        pool.close();
    }

}

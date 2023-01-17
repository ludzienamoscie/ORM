package main.java.repositories;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.relation.Relation;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import main.java.redis.AbstractRedisConnector;
import main.java.model.Room;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.jedis.search.Query;
import redis.clients.jedis.search.SearchResult;
import repositories.RoomMongoRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.bindMarker;

public class RoomRepository extends AbstractRedisConnector implements Repository<Room>{

    private Jsonb jsonb = JsonbBuilder.create();
    private RoomMongoRepository mongoRepository = new RoomMongoRepository();

    public RoomRepository() {
        super();
    }

    @Override
    public Room get(Object element) {
        try {
            Room room = (Room) element;
            return Optional.ofNullable(pool.jsonGet(roomPrefix + room.getRoom_id(), Room.class))
                    .orElseThrow();
        } catch (JedisDataException e) {
            throw new JedisDataException("Redis operation failed", e);
        } catch (JedisException e) {
            return mongoRepository.get(element);
        }
    }

    @Override
    public void add(Room... elements) {
        try {
            Arrays.stream(elements).forEach(room ->
                    pool.jsonSet(roomPrefix + room.getRoom_id(), jsonb.toJson(room)));
            mongoRepository.add(elements);
        } catch (JedisDataException e) {
            throw new JedisDataException("Redis operation failed", e);
        } catch (JedisException e) {
            throw new JedisException("Redis connection failed", e);
        }
    }

    @Override
    public void remove(Room... elements) {
        try {
            Arrays.stream(elements).forEach(room ->
                    pool.jsonDel(roomPrefix + room.getRoom_id()));
            mongoRepository.remove(elements);
        } catch (JedisDataException e) {
            throw new JedisDataException("Redis operation failed", e);
        } catch (JedisException e) {
            throw new RuntimeException("Redis connection failed", e);
        }
    }

    @Override
    public void update(Room... elements) {
        try {
            Arrays.stream(elements).forEach(room ->
                    pool.jsonSet(roomPrefix + room.getRoom_id(), jsonb.toJson(room)));
            mongoRepository.update(elements);
        } catch (JedisDataException e) {
            throw new JedisDataException("Redis operation failed", e);
        } catch (JedisException e) {
            throw new JedisException("Redis connection failed", e);
        }
    }

    @Override
    public List<Room> find(Object... elements) {
        try {
            return Optional.of(Arrays.stream(elements).map(this::get)
                    .collect(Collectors.toList())).orElseThrow();
        } catch (JedisException e) {
            return mongoRepository.find(elements);
        }
    }

    @Override
    public List<Room> getAll() {
        try {
            SearchResult searchResult = pool.ftSearch("room-search", new Query());

            return searchResult.getDocuments().stream()
                    .map(document -> pool.jsonGet(document.getId(), Room.class))
                    .collect(Collectors.toList());
        } catch (JedisDataException e) {
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

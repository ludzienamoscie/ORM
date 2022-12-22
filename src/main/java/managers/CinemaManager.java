package managers;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import com.datastax.oss.driver.api.querybuilder.schema.CreateKeyspace;

import java.net.InetSocketAddress;

import static Util.CassandraNamespaces.*;
import static com.datastax.oss.driver.api.querybuilder.SchemaBuilder.createKeyspace;

public class CinemaManager {

    private static CqlSession session;

    public static CqlSession initSession() {
        CqlSession session = CqlSession.builder()
                .addContactPoint(new InetSocketAddress("localhost", 9042))
                .addContactPoint(new InetSocketAddress("localhost", 9043))
                .withLocalDatacenter("dc1")
                .withAuthCredentials("cassandra", "cassandrapassword")
                .withKeyspace(CqlIdentifier.fromCql("cinema"))
                .build();

        CreateKeyspace keyspace = createKeyspace(CINEMA_NAMESPACE)
                .ifNotExists()
                .withSimpleStrategy(2)
                .withDurableWrites(true);
        SimpleStatement createKeyspace = keyspace.build();
        session.execute(createKeyspace);

        SimpleStatement createClients = SchemaBuilder.createTable(CLIENTS_ID)
                .ifNotExists()
                .withPartitionKey(CqlIdentifier.fromCql("client_id"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("phoneNumber"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("firstName"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("lastName"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("clientType"), DataTypes.TEXT)
                .build();
        session.execute(createClients);

        SimpleStatement createRooms = SchemaBuilder.createTable(ROOMS_ID)
                .ifNotExists()
                .withPartitionKey(CqlIdentifier.fromCql("room_id"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("capacity"), DataTypes.INT)
                .build();
        session.execute(createRooms);

        SimpleStatement createShows = SchemaBuilder.createTable(SHOWS_ID)
                .ifNotExists()
                .withPartitionKey(CqlIdentifier.fromCql("show_id"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("room_id"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("beginTime"), DataTypes.DATE)
                .withColumn(CqlIdentifier.fromCql("endTime"), DataTypes.DATE)
                .withColumn(CqlIdentifier.fromCql("showType"), DataTypes.TEXT)
                .build();
        session.execute(createShows);

        SimpleStatement createTickets = SchemaBuilder.createTable(TICKETS_ID)
                .ifNotExists()
                .withPartitionKey(CqlIdentifier.fromCql("ticket_id"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("show_id"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("client_id"), DataTypes.TEXT)
                .withColumn(CqlIdentifier.fromCql("price"), DataTypes.DOUBLE)
                .withColumn(CqlIdentifier.fromCql("ticketType"), DataTypes.TEXT)
                .build();
        session.execute(createTickets);

        return session;
    }
}

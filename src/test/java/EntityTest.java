import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Client;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.Conventions;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.junit.jupiter.api.Test;
import repositories.Enitity;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.UUID;

import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class EntityTest {

    private ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
    private final MongoCredential mongoCredential = MongoCredential.createCredential("admin", "admin", "adminpassword".toCharArray());

    private final CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(
            PojoCodecProvider.builder()
                    .automatic(true)
                    .conventions(List.of(Conventions.ANNOTATION_CONVENTION))
                    .build());

    CodecRegistry codecRegistry = fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            pojoCodecRegistry);

    protected MongoClientSettings clientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .uuidRepresentation(UuidRepresentation.STANDARD)
            .credential(mongoCredential)
            .codecRegistry(codecRegistry)
            .build();


    protected final MongoClient mongoClient = MongoClients.create(clientSettings);
    protected final MongoDatabase mongoDatabase = mongoClient.getDatabase("CINEMA");

    MongoCollection<Enitity> enitityMongoCollection = mongoDatabase.getCollection("clients", Enitity.class);

    @Test
    void entityTest(){
        Enitity enitity = new Enitity(UUID.randomUUID(),"Filip");
        enitityMongoCollection.insertOne(enitity);

    }
}

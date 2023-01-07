package main.java.repositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import mongo.UniqueIdCodecProvider;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.Conventions;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public abstract class AbstractMongoRepository {
    protected ConnectionString connectionString;
    protected MongoCredential credential;
    protected Properties properties = new Properties();
    protected CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder()
            .automatic(true)
            .conventions(List.of(Conventions.ANNOTATION_CONVENTION))
            .build());
    protected MongoClient mongoClient;
    protected MongoDatabase hotelDB;

    public void initDbConnection() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(credential)
                .applyConnectionString(connectionString)
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .codecRegistry(CodecRegistries.fromRegistries(
                        CodecRegistries.fromProviders(new UniqueIdCodecProvider()),
                        MongoClientSettings.getDefaultCodecRegistry(),
                        pojoCodecRegistry
                ))
                .build();

        this.mongoClient = MongoClients.create(settings);
    }

    public AbstractMongoRepository() {
        try {
            this.properties.load(new FileInputStream(
                    new File("src/main/resources/credentials.properties").getAbsoluteFile()));
            this.connectionString = new ConnectionString("mongodb://" + this.properties.getProperty("mongoHostname") +
                    ":" + this.properties.getProperty("mongoPort"));
            this.credential = MongoCredential.createCredential(this.properties.getProperty("mongoUsername"),
                    this.properties.getProperty("mongoDatabase"), this.properties.getProperty("mongoPassword").toCharArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.initDbConnection();
        this.hotelDB = mongoClient.getDatabase("hotel");
    }
}
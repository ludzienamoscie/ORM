package repositories;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.UUID;

public class Enitity {


    public Enitity(@BsonId UUID uuid, @BsonProperty String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    @BsonId
    private UUID uuid;

    @BsonProperty("name")
    private String name;
}

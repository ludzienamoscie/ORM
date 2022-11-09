package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.hibernate.annotations.NamedQuery;
import repositories.UniqueIdMgd;


import java.io.Serializable;
import java.util.UUID;

public abstract class AbstractEntity {

    public AbstractEntity(UUID uuid) {
        this.uuid = uuid;
    }

    @BsonProperty("_id")
    private final UUID uuid;

    public UUID getUUID() {
        return uuid;
    }
}

package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.hibernate.annotations.NamedQuery;
import repositories.UniqueIdMgd;


import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements AutoCloseable {

    public AbstractEntity(UniqueIdMgd entityId) {
        this.entityId = entityId;
    }

    @BsonProperty("_id")
    private final UniqueIdMgd entityId;

    public UniqueIdMgd getEntityId() {
        return entityId;
    }
}

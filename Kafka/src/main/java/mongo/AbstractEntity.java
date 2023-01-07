package main.java.mongo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public abstract class AbstractEntity implements Serializable {

    @Getter
    @BsonProperty("_id")
    protected UniqueIdMgd id;

    public AbstractEntity(@NonNull UniqueIdMgd id) {
        this.id = id;
    }
}

package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.NamedQuery;
import org.junit.platform.engine.UniqueId;

import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Embedded
    @NotNull
    private UniqueId abstractEntityId; // nadal wyrzuca blad jak zmienilam z Id na UniqueId:(

    @Version
    @NotEmpty
    private long version;

    protected AbstractEntity() {
    }
}

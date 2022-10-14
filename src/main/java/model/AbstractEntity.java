package model;

import com.sun.istack.NotNull;
import jakarta.persistence.Embedded;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Embedded
    @NotNull
    private Id abstractEntityId; //nwm czy tak powinno byc

    @Version
    @NotEmpty
    private long version;

    protected AbstractEntity() {
    }
}

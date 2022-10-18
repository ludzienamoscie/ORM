package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.NamedQuery;


import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Version
    private long version;

    protected AbstractEntity() {
    }
}

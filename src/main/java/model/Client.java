package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"phoneNumber","firstName", "lastName", "clientType"})
@CqlName("clients_id")
@Entity
public class Client extends AbstractEntity{

    @NonNull
    @PartitionKey
    @CqlName("client_id")
    private String client_id;

    @NonNull
    @CqlName("phoneNumber")
    private String phoneNumber;

    @NonNull
    @CqlName("firstName")
    private String firstName;

    @NonNull
    @CqlName("lastName")
    private String lastName;

    @ToString
    @RequiredArgsConstructor
    @NoArgsConstructor
    public enum ClientType implements Serializable {
        adult,
        minor,
        senior;

        @NonNull
        @Getter
        @CqlName("typeInfo")
        private String typeInfo;
    }

    @CqlName("clientType")
    private String clientType = ClientType.adult.getTypeInfo();
}
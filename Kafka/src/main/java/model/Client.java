package main.java.model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;


@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"phoneNumber","firstName", "lastName", "clientType"})
public class Client implements Serializable {

    @BsonCreator
    @JsonbCreator
    public Client(@BsonProperty("client_id") @JsonbProperty("client_id") String client_id,
                  @BsonProperty("phoneNumber") @JsonbProperty("phoneNumber") String phoneNumber,
                  @BsonProperty("firstName") @JsonbProperty("firstName") String firstName,
                  @BsonProperty("lastName") @JsonbProperty("lastName") String lastName,
                  @BsonProperty("clientType") @JsonbProperty("clientType") String clientType) {
        this.client_id = client_id;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientType = clientType;
    }

    @Getter
    @NonNull
    @BsonProperty("client_id")
    @JsonbProperty("client_id")
    private String client_id;

    @NonNull
    @BsonProperty("phoneNumber")
    @JsonbProperty("phoneNumber")
    private String phoneNumber;

    @NonNull
    @BsonProperty("firstName")
    @JsonbProperty("firstName")
    private String firstName;

    @NonNull
    @BsonProperty("lastName")
    @JsonbProperty("lastName")
    private String lastName;

    @RequiredArgsConstructor
    @NoArgsConstructor
    public enum ClientType implements Serializable {
        adult,
        minor,
        senior;

        @NonNull
        @Getter
        @BsonProperty("typeInfo")
        @JsonbProperty("typeInfo")
        private String typeInfo;
    }

    @BsonProperty("clientType")
    @JsonbProperty("clientType")
    private String clientType = ClientType.adult.getTypeInfo();
}
package test.java.managers;

import model.*;
import model.BasicsTest;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class BasicsManagerTest extends BasicsTest {

    protected static Client createClient(String client_id, String phoneNumber, String firstName, String lastName, String clientType) {
        return new Client(client_id, phoneNumber, firstName, lastName, clientType);
    }

    protected static List<Client> getRandomClient() {
        return Collections.singletonList(
                createClient(BasicsTest.randomString(), BasicsTest.randomString(), BasicsTest.randomString(), BasicsTest.randomString(), BasicsTest.randomString()));
    }

    protected static Client randomClient() {
        return getRandomClient().get(0);
    }
}
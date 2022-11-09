package repositories;

import com.mongodb.ConnectionString;

public abstract class AbstractRepository implements AutoCloseable {

    private ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

}

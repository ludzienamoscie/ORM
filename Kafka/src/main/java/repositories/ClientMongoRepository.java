package repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import main.java.model.Client;
import main.java.repositories.AbstractMongoRepository;
import main.java.repositories.Repository;
import model.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientMongoRepository extends AbstractMongoRepository implements Repository<Client> {

    private MongoCollection<Client> collection;

    public ClientMongoRepository() {
        super();
        this.collection = cinemaDB.getCollection("clients", Client.class);
    }

    @Override
    public Client get(Object element) {
        return Optional.ofNullable(collection.find(Filters.eq("personalID", (
                (Client) element).getPersonalID())).first()).orElseThrow();
    }

    @Override
    public void add(Client... elements) {
        Stream.of(elements).forEach(collection::insertOne);
    }

    @Override
    public void remove(Client... elements) {
        Stream.of(elements).forEach(element -> collection.deleteOne(
                Filters.eq("personalID", element.getPersonalID())
        ));
    }

    @Override
    public void update(Client... elements) {
        Stream.of(elements).forEach(element -> {
            collection.replaceOne(Filters.eq("personalID", element.getPersonalID()), element);
        });
    }

    @Override
    public List<Client> find(Object... elements) {
        return Optional.of(Arrays.stream(elements)
                .map(this::get)
                .collect(Collectors.toList())).orElseThrow();
    }

    @Override
    public List<Client> getAll() {
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Long size() {
        return collection.countDocuments();
    }
}

package repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import model.Client;
import org.bson.conversions.Bson;

public class ClientRepository extends AbstractRepository implements Repository<Client, Long>{

    MongoCollection<Client> clientCollection = mongoDatabase.getCollection("clients", Client.class);
    @Override
    public Client add(Client item) {
        clientCollection.insertOne(item);
        return item;
    }
    @Override
    public void remove(Client item) {
        Bson filter = Filters.eq("_id", item.getUUID());
        clientCollection.findOneAndDelete(filter);
    }

    @Override
    public Client get(Long id) {
        Bson filter = Filters.eq("_id", id);
        return clientCollection.find(filter).first();
    }
}

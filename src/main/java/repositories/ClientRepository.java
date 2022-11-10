package repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import model.Client;
import org.bson.conversions.Bson;

import java.util.UUID;

public class ClientRepository extends AbstractRepository implements Repository<Client, UUID> {

    MongoCollection<Client> clientCollection = mongoDatabase.getCollection("clients", Client.class);

    @Override
    public synchronized Client add(Client item) {
        clientCollection.insertOne(item);
        return item;
    }

    @Override
    public void remove(Client item) {
        Bson filter = Filters.eq("_id", item.getUuid());
        clientCollection.findOneAndDelete(filter);
    }

    @Override
    public Client get(Client client) {
        Bson filter = Filters.eq("_id", client.getUuid());
        return clientCollection.find(filter).first();
    }

    @Override
    public void update(Client item1, Client item2){
        Bson filter1 = Filters.eq("_id", item1.getUuid());
        Bson filter2 = Filters.eq("_id", item2.getUuid());
        clientCollection.updateOne(filter1,filter2);
    }
    public long size() {
        return clientCollection.countDocuments();
    }

}

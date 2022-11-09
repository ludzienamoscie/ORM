package repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import model.Client;
import model.Ticket;
import org.bson.conversions.Bson;

public class ClientRepository extends AbstractRepository implements Repository<Client, Long> {

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

    @Override
    public void update(Client item1, Client item2){
        Bson filter1 = Filters.eq("_id", item1.getUUID());
        Bson filter2 = Filters.eq("_id", item2.getUUID());
        clientCollection.updateOne(filter1,filter2);
    }
    public long size() {
        return clientCollection.countDocuments();
    }

}

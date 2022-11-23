package repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import model.Client;
import org.bson.conversions.Bson;

import java.util.UUID;

public class ClientRepository extends AbstractRepository implements Repository<Client> {

    MongoCollection<Client> clientCollection = mongoDatabase.getCollection("clients", Client.class);

    //create
    @Override
    public synchronized Client add(Client item) {
        clientCollection.insertOne(item);
        return item;
    }

    //delete
    @Override
    public void remove(Client item) {
        Bson filter = Filters.eq("_id", item.getUuid());
        clientCollection.findOneAndDelete(filter);
    }

    //read
    @Override
    public Client get(Client client) {
        Bson filter = Filters.eq("_id", client.getUuid());
        return clientCollection.find(filter).first();
    }

    public Client getByUUID(UUID uuid){
        Bson filter = Filters.eq("_id",uuid);
        return clientCollection.find(filter).first();
    }

    //update
    @Override
    public void update(Client client){
       Bson filter = Filters.eq("_id",client.getUuid());
       Bson update = Updates.combine(
               Updates.set("birthday",client.getBirthday()),
               Updates.set("phoneNumber", client.getPhoneNumber()),
               Updates.set("firstName",client.getFirstName()),
               Updates.set("lastName",client.getLastName())
       );
       clientCollection.updateOne(filter,update);

    }
    public long size() {
        return clientCollection.countDocuments();
    }

}

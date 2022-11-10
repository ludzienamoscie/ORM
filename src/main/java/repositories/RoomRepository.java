package repositories;

import Util.EntityManagerCreator;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import jakarta.persistence.EntityManager;
import model.Client;
import model.Room;
import model.Ticket;
import org.bson.conversions.Bson;

public class RoomRepository extends AbstractRepository implements Repository<Room, Long>{

    MongoCollection<Room> roomCollection = mongoDatabase.getCollection("rooms", Room.class);

    @Override
    public Room add(Room item) {
        roomCollection.insertOne(item);
        return item;
    }
    @Override
    public void remove(Room item) {
        Bson filter = Filters.eq("_id", item.getUuid());
        roomCollection.findOneAndDelete(filter);
    }

    @Override
    public Room get(Long id) {
        Bson filter = Filters.eq("_id", id);
        return roomCollection.find(filter).first();
    }
    @Override
    public void update(Room item1, Room item2){
        Bson filter1 = Filters.eq("_id", item1.getUuid());
        Bson filter2 = Filters.eq("_id", item2.getUuid());
        roomCollection.updateOne(filter1,filter2);
    }
}

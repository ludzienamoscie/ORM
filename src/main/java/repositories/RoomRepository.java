package repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import model.Room;
import org.bson.conversions.Bson;

import java.util.UUID;

public class RoomRepository extends AbstractRepository implements Repository<Room>{

    MongoCollection<Room> roomCollection = mongoDatabase.getCollection("rooms", Room.class);

    //create
    @Override
    public Room add(Room item) {
        roomCollection.insertOne(item);
        return item;
    }

    //delete
    @Override
    public void remove(Room item) {
        Bson filter = Filters.eq("_id", item.getUuid());
        roomCollection.findOneAndDelete(filter);
    }

    //read
    @Override
    public Room get(Room room) {
        Bson filter = Filters.eq("_id", room.getUuid());
        return roomCollection.find(filter).first();
    }

    public Room getByUUID(UUID uuid){
        Bson filter = Filters.eq("_id",uuid);
        return roomCollection.find(filter).first();
    }

    //update
    @Override
    public void update(Room room){
        Bson filter = Filters.eq("_id", room.getUuid());
        Bson update = Updates.combine(
                Updates.set("roomNumber",room.getRoomNumber()),
                Updates.set("capacity",room.getCapacity())
        );
        roomCollection.updateOne(filter,update);
    }

    public long size() {
        return roomCollection.countDocuments();
    }
}

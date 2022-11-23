package repositories;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import model.Show;
import org.bson.conversions.Bson;

import java.util.UUID;

public class ShowRepository extends AbstractRepository implements Repository<Show>{

    MongoCollection<Show> showCollection = mongoDatabase.getCollection("shows", Show.class);

    //create
    @Override
    public Show add(Show item) {
        showCollection.insertOne(item);
        return item;
    }

    //delete
    @Override
    public void remove(Show item) {
        Bson filter = Filters.eq("_id", item.getUuid());
        showCollection.findOneAndDelete(filter);
    }

    //read
    @Override
    public Show get(Show show) {
        Bson filter = Filters.eq("_id", show.getUuid());
        return showCollection.find(filter).first();
    }

    public Show getByUUID(UUID uuid){
        Bson filter = Filters.eq("_id",uuid);
        return showCollection.find(filter).first();
    }

    @Override
    public void update(Show show){
        Bson filter = Filters.eq("_id", show.getUuid());
        Bson update = Updates.combine(
                Updates.set("show_id",show.getShow_id()),
                Updates.set("room",show.getRoom()),
                Updates.set("beginTime",show.getBeginTime()),
                Updates.set("endTime",show.getEndTime())
        );
        showCollection.updateOne(filter,update);
    }

    public long size() {
        return showCollection.countDocuments();
    }
}

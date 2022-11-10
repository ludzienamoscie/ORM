package repositories;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import model.Show;
import org.bson.conversions.Bson;

public class ShowRepository extends AbstractRepository implements Repository<Show, Long>{

    MongoCollection<Show> showCollection = mongoDatabase.getCollection("shows", Show.class);

    @Override
    public Show add(Show item) {
        showCollection.insertOne(item);
        return item;
    }

    @Override
    public void remove(Show item) {
        Bson filter = Filters.eq("_id", item.getUuid());
        showCollection.findOneAndDelete(filter);
    }

    @Override
    public Show get(Show show) {
        Bson filter = Filters.eq("_id", show.getUuid());
        return showCollection.find(filter).first();
    }

    @Override
    public void update(Show item1, Show item2){
        Bson filter1 = Filters.eq("_id", item1.getUuid());
        Bson filter2 = Filters.eq("_id", item2.getUuid());
        showCollection.updateOne(filter1,filter2);
    }
}

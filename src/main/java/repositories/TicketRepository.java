package repositories;

import Util.EntityManagerCreator;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import jakarta.persistence.EntityManager;
import model.Show;
import model.Ticket;
import org.bson.conversions.Bson;

public class TicketRepository extends AbstractRepository implements Repository<Ticket, Long>{

    MongoCollection<Ticket> ticketCollection = mongoDatabase.getCollection("tickets", Ticket.class);

    @Override
    public synchronized Ticket add(Ticket item) {
        try(EntityManager manager = EntityManagerCreator.getEntityManager()) {
            Show show = manager.find(Show.class,item.getShow().getShow_id());
            if(!isAvailable(show)){
                return null;
            }
            ticketCollection.insertOne(item);
            show.decreaseSeats();
            return item;
        }
    }
    @Override
    public void remove(Ticket item) {
        Bson filter = Filters.eq("_id", item.getUuid());
        ticketCollection.findOneAndDelete(filter);
    }

    @Override
    public Ticket get(Ticket ticket) {
        Bson filter = Filters.eq("_id", ticket.getUuid());
        return ticketCollection.find(filter).first();
    }

    @Override
    public void update(Ticket item1, Ticket item2){
        Bson filter1 = Filters.eq("_id", item1.getUuid());
        Bson filter2 = Filters.eq("_id", item2.getUuid());
        ticketCollection.updateOne(filter1,filter2);
    }

    public boolean isAvailable(Show show){
        return show.getAvailableSeats() > 0;
    }
}

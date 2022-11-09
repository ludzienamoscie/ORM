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
        Bson filter = Filters.eq("_id", item.getUUID());
        ticketCollection.findOneAndDelete(filter);
    }

    @Override
    public Ticket get(Long id) {
        Bson filter = Filters.eq("_id", id);
        return ticketCollection.find(filter).first();
    }

    public boolean isAvailable(Show show){
        if(show.getAvailableSeats() > 0) return true;
        else return false;
    }
}

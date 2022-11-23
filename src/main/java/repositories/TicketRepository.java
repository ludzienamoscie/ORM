package repositories;

import Util.EntityManagerCreator;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import jakarta.persistence.EntityManager;
import model.Show;
import model.Ticket;
import org.bson.conversions.Bson;

import java.util.UUID;

public class TicketRepository extends AbstractRepository implements Repository<Ticket>{

    MongoCollection<Ticket> ticketCollection = mongoDatabase.getCollection("tickets", Ticket.class);

    //create
    @Override
    public synchronized Ticket add(Ticket item) {

//        Show show = item.getShow();
//        if(!isAvailable(show)){
//                return null;
//        }
//        ticketCollection.insertOne(item);
//        show.decreaseSeats();
//        return item;
        ticketCollection.insertOne(item);
        return item;
    }

    //delete
    @Override
    public void remove(Ticket item) {
        Bson filter = Filters.eq("_id", item.getUuid());
        ticketCollection.findOneAndDelete(filter);
    }

    //read
    @Override
    public Ticket get(Ticket ticket) {
        Bson filter = Filters.eq("_id", ticket.getUuid());
        return ticketCollection.find(filter).first();
    }

    public Ticket getByUUID(UUID uuid){
        Bson filter = Filters.eq("_id",uuid);
        return ticketCollection.find(filter).first();
    }

    public Ticket getByTicket(Long ticket){
        Bson filter = Filters.eq("ticket",ticket);
        return ticketCollection.find(filter).first();
    }

    @Override
    public boolean update(Ticket ticket){
        Bson filter = Filters.eq("_id", ticket.getUuid());
        Bson update = Updates.combine(
                Updates.set("price",ticket.getPrice())
        );
        ticketCollection.updateOne(filter,update);
        return true;
    }

    public boolean isAvailable(Show show){
        return show.getAvailableSeats() > 0;
    }

    public long size() {
        return ticketCollection.countDocuments();
    }
}

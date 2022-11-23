package managers;

import model.*;
import org.hibernate.mapping.TableOwner;
import repositories.TicketRepository;

public class TicketManager {
    TicketRepository ticketRepository;

    public TicketManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public boolean isAvailable(Show show) {
        return show.getAvailableSeats() > 0;
    }

    public boolean tryBook(Long ticket,Show show, Client client, double price, Ticket.TicketType ticketType) {
//        if (!isAvailable(show)) return false;
//        Ticket ticket = new Ticket(show, client, price, ticketType);
//        return ticketRepository.add(ticket) != null;

        Ticket ticket1 = new Ticket(ticket,show, client,price,ticketType);
        if(ticketRepository.add(ticket1) == null){
            return false;
        }
        return true;
    }
    public void remove(Ticket ticket){
        ticketRepository.remove(ticket);
    }

    public Ticket get(Ticket ticket){
        return ticketRepository.get(ticket);
    }

    public Ticket getByTicket(Long ticket){
        return ticketRepository.getByTicket(ticket);
    }
}

package managers;

import model.*;
import repositories.TicketRepository;

public class TicketManager {
    TicketRepository ticketRepository;

    public TicketManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public boolean isAvailable(Show show) {
        return show.getAvailableSeats() > 0;
    }

    public boolean tryBook(Show show, Client client, double price, Ticket.TicketType ticketType) {
        if (!isAvailable(show)) return false;
        Ticket ticket = new Ticket(show, client, price, ticketType);
        return ticketRepository.add(ticket) != null;
    }
    public void remove(Ticket ticket){
        ticketRepository.remove(ticket);
    }

    public Ticket get(Ticket ticket){
        return ticketRepository.get(ticket);
    }
}

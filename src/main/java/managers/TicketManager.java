package managers;

import jakarta.persistence.LockModeType;
import jakarta.persistence.NamedQuery;
import jakarta.transaction.Transactional;
import model.*;
import repositories.TicketRepository;

public class TicketManager {
    TicketRepository ticketRepository;

    public TicketManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public boolean isAvailable(Show show) {
        if (show.getAvailableSeats() > 0) return true;
        else return false;
    }

    public boolean tryBook(Long ticket_id,Show show, Client client, double price, Ticket.TicketType ticketType) {
        if (!isAvailable(show)) return false;
        Ticket ticket = new Ticket(ticket_id,show, client, price, ticketType);
        if (ticketRepository.add(ticket) == null) {
            return false;
        }
        return true;
    }
    public boolean remove(Ticket ticket){
        return ticketRepository.remove(ticket);
    }
}

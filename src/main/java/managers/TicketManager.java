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

    public boolean tryBook(Show show, Client client, double price, Ticket.TicketType ticketType) {
        if (!isAvailable(show)) return false;
        Ticket ticket = new Ticket(show, client, price, ticketType);
        if (ticketRepository.add(ticket) == null) {
            return false;
        }
        return true;
    }
}

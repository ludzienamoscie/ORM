package managers;

import jakarta.transaction.Transactional;
import model.*;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.jpamodelgen.xml.jaxb.LockModeType;
import repositories.SeatRepository;
import repositories.TicketRepository;

public class TicketManager {
    TicketRepository ticketRepository;
    SeatRepository seatRepository;

    public TicketManager(TicketRepository ticketRepository, SeatRepository seatRepository)
        { this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;}

    // wymagana jest transakcja (do pilnowania ACID)
    @Transactional
    public boolean isFree(Long seat_id, Long show_id) {
        Ticket ticket = ticketRepository.findBySeat(seat_id, show_id);
        // czy ticket jest null; jesli nie znaleziono biletu z tym miejscem na ten show, to miejsce jest wolne
        return ticket == null;
    }

    @Transactional
    //@NamedQuery(lockMode=LockModeType.OPTIMISTIC_FORCE_INCREMENT) // nie dziala a tak jest w wykladzie chyba
    public boolean tryBook(Show show, Client client, Seat seat, double price, Ticket.TicketType ticketType) {
        if(!isFree(seat.getSeat_id(),show.getShow_id())) return false;
        Ticket ticket = new Ticket(show, client, seat, price, ticketType);
        ticketRepository.add(ticket);
        return true;
    }
}

package managers;

import jakarta.transaction.Transactional;
import model.Room;
import model.Seat;
import model.Ticket;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.jpamodelgen.xml.jaxb.LockModeType;
import repositories.SeatRepository;
import repositories.TicketRepository;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    TicketRepository ticketRepository;
    SeatRepository seatRepository;

    public TicketManager(TicketRepository ticketRepository, SeatRepository seatRepository)
        { this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;}

    // wymagana jest transakcja (do pilnowania ACID)
    @Transactional
    //@NamedQuery(lockMode=LockModeType.OPTIMISTIC_FORCE_INCREMENT) // nie dziala a tak jest w wykladzie chyba
    public boolean isFree(Long seat_id) {
        Ticket ticket = ticketRepository.findBySeat(seat_id);
        if(ticket != null) return false;
        seatRepository.get(seat_id).setFree(false);
        return true;
    }
}

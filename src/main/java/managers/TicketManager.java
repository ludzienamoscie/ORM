package managers;

import model.*;

import repositories.TicketRepository;

public class TicketManager {
    TicketRepository ticketRepository;

    public TicketManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public boolean add(String ticket_id,String show_id, String client_id, double price, String ticketType) {
        Ticket ticket1 = new Ticket(ticket_id,show_id, client_id,price,ticketType);
        ticketRepository.add(ticket1);
        return true;
    }
    public void remove(Ticket ticket){
        ticketRepository.remove(ticket);
    }

    public Ticket get(Ticket ticket){
        return ticketRepository.get(ticket);
    }

}

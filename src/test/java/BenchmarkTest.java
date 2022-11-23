import repositories.*;

public class BenchmarkTest {
    private static final ShowRepository showRepository = new ShowRepository();
    private static final RoomRepository roomRepository = new RoomRepository();
    private static final ClientRepository clientRepository = new ClientRepository();

    private static final TicketRepository ticketRepository = new TicketRepository();
    private static final TicketRepository ticketCacheRepository = new TicketCacheRepository();
}

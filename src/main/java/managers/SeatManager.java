package managers;

import jakarta.transaction.Transactional;
import model.Room;
import model.Seat;
import repositories.ClientRepository;
import repositories.RoomRepository;
import repositories.SeatRepository;

public class SeatManager {
    SeatRepository seatRepository;

    public SeatManager(SeatRepository seatRepository){this.seatRepository = seatRepository;}
}

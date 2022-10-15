package managers;

import jakarta.transaction.Transactional;
import model.Room;
import model.Seat;
import repositories.ClientRepository;
import repositories.RoomRepository;

import java.util.ArrayList;

public class RoomManager {
    RoomRepository roomRepository;

    public RoomManager(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

}

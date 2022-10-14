package managers;

import repositories.ClientRepository;
import repositories.RoomRepository;

public class RoomManager {
    RoomRepository roomRepository;

    public RoomManager(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }
}

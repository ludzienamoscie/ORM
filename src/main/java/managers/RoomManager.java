package managers;

import model.Room;
import repositories.RoomRepository;

public class RoomManager {
    RoomRepository roomRepository;

    public RoomManager(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public boolean add(String roomNumber,int capacity){
        Room room = new Room(roomNumber,capacity);
        roomRepository.add(room);
        return true;
    }
    public void remove(Room room){
        roomRepository.remove(room);
    }
    public Room get(Room room){
        return roomRepository.get(room);
    }
}

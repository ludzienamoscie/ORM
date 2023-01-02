package managers;

import model.Room;
import repositories.RoomRepository;

public class RoomManager {
    RoomRepository roomRepository;

    public RoomManager(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public boolean add(String room_id,int capacity){
        Room room = new Room(room_id,capacity);
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

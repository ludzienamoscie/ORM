package managers;

import model.Room;
import repositories.RoomRepository;

public class RoomManager {
    RoomRepository roomRepository;

    public RoomManager(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public Room add(int roomNumber,int capacity){
        Room room = new Room(roomNumber,capacity);
        return roomRepository.add(room);
    }
    public void remove(Room room){
        roomRepository.remove(room);
    }
    public Room get(Long id){
        return roomRepository.get(id);
    }
}

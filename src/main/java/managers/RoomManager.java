package managers;

import model.Room;
import repositories.RoomRepository;

public class RoomManager {
    RoomRepository roomRepository;

    public RoomManager(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public boolean add(int roomNumber,int capacity){
        Room room = new Room(roomNumber,capacity);
        if(roomRepository.add(room) == null){
            return false;
        }
        return true;
    }
    public boolean remove(Room room){
         return roomRepository.remove(room);
    }
    public Room get(Long id){
        return roomRepository.get(id);
    }
}

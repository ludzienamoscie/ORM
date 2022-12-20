package managers;

import model.Room;
import model.Show;
import repositories.ShowRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public class ShowManager {
    ShowRepository showRepository;

    public ShowManager(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public boolean add(Long show_id, UUID room_id, LocalDateTime beginTime, LocalDateTime endTime, String showType){
        Show show = new Show(show_id,room_id,beginTime,endTime, showType);
        if(showRepository.add(show)==null){
            return false;
        }
        return true;
    }

    public void remove(Show show){
        showRepository.remove(show);
    }

    public Show get(Show show){
        return showRepository.get(show);
    }
}

package managers;

import model.Room;
import model.Show;
import repositories.ShowRepository;

import java.time.LocalDateTime;

public class ShowManager {
    ShowRepository showRepository;

    public ShowManager(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public boolean add(Long show_id,Room room, LocalDateTime beginTime, LocalDateTime endTime, Show.ShowType showType){
        Show show = new Show(show_id,room,beginTime,endTime, showType);
        if(showRepository.add(show)==null){
            return false;
        }
        return true;
    }

    public void remove(Show show){
        showRepository.remove(show);
    }

    public Show get(Long id){
        return showRepository.get(id);
    }
}

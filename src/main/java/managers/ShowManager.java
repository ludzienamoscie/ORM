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

    public Show add(Room room, LocalDateTime beginTime, LocalDateTime endTime, Show.ShowType showType){
        Show show = new Show(room,beginTime,endTime, showType);
        return showRepository.add(show);
    }

    public void remove(Show show){
        showRepository.remove(show);
    }

    public Show get(Long id){
        return showRepository.get(id);
    }
}

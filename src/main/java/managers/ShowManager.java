package managers;

import model.Room;
import model.Show;
import repositories.ShowRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ShowManager {
    ShowRepository showRepository;

    public ShowManager(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public boolean add(String show_id, String room_id, LocalDate beginTime, LocalDate endTime, String showType){
        Show show = new Show(show_id,room_id,beginTime,endTime, showType);
        showRepository.add(show);
        return true;
    }

    public void remove(Show show){
        showRepository.remove(show);
    }

    public Show get(Show show){
        return showRepository.get(show);
    }
}

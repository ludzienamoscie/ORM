package main.java.managers;

import main.java.model.Show;
import main.java.repositories.ShowRepository;

import java.time.LocalDate;


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

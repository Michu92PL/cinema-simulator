package pl.michu.cinemasimulator.services;

import org.springframework.stereotype.Service;
import pl.michu.cinemasimulator.model.Cinema;
import pl.michu.cinemasimulator.model.Screening;

import java.util.List;

@Service
public interface ScreeningService {

    List<Screening> findAll();
    void addScreening(Screening screening);
    Screening findById(Long id);
    void removeScreeningById(Long id);
    List<Screening> findAllByCinema(Cinema cinema);
    void deleteScreeningsFromCinema(Cinema cinema);
    void deleteScreening(Screening screening);
}

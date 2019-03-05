package pl.michu.cinemasimulator.services;

import org.springframework.stereotype.Service;
import pl.michu.cinemasimulator.model.Cinema;
import pl.michu.cinemasimulator.model.Screening;

import java.util.List;
import java.util.Optional;

@Service
public interface CinemaService {

    List<Cinema> findAll();
    void addCinema(Cinema cinema);
    Cinema findById(Long id);
    void removeCinemaById(Long id);
    List<Screening> findAllScreenings(Cinema cinema);

}

package pl.michu.cinemasimulator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michu.cinemasimulator.exceptions.CinemaNotFoundException;
import pl.michu.cinemasimulator.exceptions.ScreeningNotFoundException;
import pl.michu.cinemasimulator.model.Cinema;
import pl.michu.cinemasimulator.model.Screening;
import pl.michu.cinemasimulator.repositories.CinemaRespository;
import pl.michu.cinemasimulator.repositories.MovieRepository;
import pl.michu.cinemasimulator.repositories.ScreeningRepository;

import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    CinemaRespository cinemaRespository;
    MovieRepository movieRepository;
    ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningServiceImpl(CinemaRespository cinemaRespository, MovieRepository movieRepository, ScreeningRepository screeningRepository) {
        this.cinemaRespository = cinemaRespository;
        this.movieRepository = movieRepository;
        this.screeningRepository = screeningRepository;
    }

    @Override
    public List<Screening> findAll() {
        return screeningRepository.findAll();
    }

    @Override
    public void addScreening(Screening screening) {
        screeningRepository.save(screening);
    }

    @Override
    public Screening findById(Long id) {
        return screeningRepository.findById(id).orElseThrow(()-> new ScreeningNotFoundException(id));
    }

    @Override
    public void removeScreeningById(Long id) {
        screeningRepository.deleteById(id);
    }

    @Override
    public List<Screening> findAllByCinema(Cinema cinema) {
        return screeningRepository.findAllByCinema(cinema);
    }

    @Override
    public void deleteScreeningsFromCinema(Cinema cinema) {
        for (Screening screening : cinema.getScreenings()) {
            screening.deleteCinema();
            screeningRepository.save(screening);
        }
    }

    @Override
    public void deleteScreening(Screening screening) {
        screeningRepository.delete(screening);
    }
}

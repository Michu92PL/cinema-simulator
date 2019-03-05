package pl.michu.cinemasimulator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michu.cinemasimulator.exceptions.CinemaNotFoundException;
import pl.michu.cinemasimulator.model.Cinema;
import pl.michu.cinemasimulator.model.Movie;
import pl.michu.cinemasimulator.model.Screening;
import pl.michu.cinemasimulator.repositories.CinemaRespository;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaServiceImpl implements CinemaService {

    CinemaRespository cinemaRespository;
    MovieService movieService;
    ScreeningService screeningService;

    @Autowired
    public CinemaServiceImpl(CinemaRespository cinemaRespository, MovieService movieService, ScreeningService screeningService) {
        this.cinemaRespository = cinemaRespository;
        this.movieService = movieService;
        this.screeningService = screeningService;
    }

    @Override
    public List<Cinema> findAll() {
        return cinemaRespository.findAll();
    }

    @Override
    public void addCinema(Cinema cinema) {
        cinemaRespository.save(cinema);
    }

    @Override
    public Cinema findById(Long id) {
        return cinemaRespository.findById(id).orElseThrow(()-> new CinemaNotFoundException(id));
    }

    @Override
    public void removeCinemaById(Long id) {
        Cinema cinema = findById(id);
        List<Screening> screenings = cinema.getScreenings();
        //cinema.getScreenings().forEach(screening -> screening.deleteCinema());
        //cinema.getScreenings().forEach(s -> s.getMovie().deleteScreening(s));
        //screenings.stream().map(s -> s.getMovie()).forEach(movie -> movie.deleteScreening());
        for(Screening screening : screenings){
            Movie movie = screening.getMovie();
            movie.deleteScreening(screening);
            movieService.save(movie);
        }
        cinemaRespository.deleteById(id);
    }

    @Override
    public List<Screening> findAllScreenings(Cinema cinema) {
        return null;
    }
}

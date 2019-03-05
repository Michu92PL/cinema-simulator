package pl.michu.cinemasimulator.services;

import org.springframework.stereotype.Service;
import pl.michu.cinemasimulator.model.Movie;
import pl.michu.cinemasimulator.model.Screening;

import java.util.List;

@Service
public interface MovieService {

    List<Movie> findAll();
    Movie findById(Long id);
    List<Movie> findByGenre(String genre);
    void deleteScreeningfromMovies(Screening screening);
    void save(Movie movie);


}

package pl.michu.cinemasimulator.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michu.cinemasimulator.exceptions.MovieNotFoundException;
import pl.michu.cinemasimulator.model.Movie;
import pl.michu.cinemasimulator.model.Screening;
import pl.michu.cinemasimulator.repositories.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MovieServiceImpl implements MovieService{

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public List<Movie> findByGenre(String genre) {
        return movieRepository.findAllByGenre(genre);
    }

    @Override
    public void deleteScreeningfromMovies(Screening screening) {
        List<Movie> movies = movieRepository.findAll();
        for(Movie movie : movies){
            for(Screening s : movie.getScreenings()){
                if(s.getId().equals(screening.getId())){
                    movie.deleteScreening(screening);
                    movieRepository.save(movie);
                }
            }
        }


    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }
}

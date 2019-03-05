package pl.michu.cinemasimulator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.michu.cinemasimulator.model.Cinema;
import pl.michu.cinemasimulator.model.Movie;
import pl.michu.cinemasimulator.model.Screening;
import pl.michu.cinemasimulator.services.MovieService;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public String getMovieList(Model model) {
        List<Movie> movies = movieService.findAll();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/newmovie")
    public String createMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "movieform";
    }

    @PostMapping("/movies")
    public String addMovie(Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/movie")
    public String getMovie(@RequestParam("id") Long id, Model model){
        Movie movie = movieService.findById(id);
        model.addAttribute("movie", movie);
        return "movie";
    }

    @GetMapping("where")
    public String whereToWatch(@RequestParam("id") Long id, Model model){
        Movie movie = movieService.findById(id);
        List<Screening> screenings = movie.getScreenings();
        model.addAttribute("name", movie.getTitle());
        model.addAttribute("screenings", screenings);
        return "moviescreenings";
    }

}

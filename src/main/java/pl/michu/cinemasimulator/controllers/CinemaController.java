package pl.michu.cinemasimulator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.michu.cinemasimulator.model.Cinema;
import pl.michu.cinemasimulator.model.Screening;
import pl.michu.cinemasimulator.services.CinemaService;
import pl.michu.cinemasimulator.services.MovieService;
import pl.michu.cinemasimulator.services.ScreeningService;

import java.util.List;
import java.util.Optional;

@Controller
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    @Autowired
    MovieService movieService;

    @Autowired
    ScreeningService screeningService;


    @GetMapping("/cinemas")
    public String getCinemaList(Model model){
        List<Cinema> cinemas = cinemaService.findAll();
        model.addAttribute("cinemas", cinemas);
        return "cinemas";
    }

    @GetMapping("/newcinema")
    public String createCinema(Model model){
        model.addAttribute("cinema", new Cinema());
        return "cinemaform";
    }

    @PostMapping("/cinemas")
    public String addCinema(Cinema cinema){
        cinemaService.addCinema(cinema);
        return "redirect:/cinemas";
    }

    @GetMapping("/cinema/delete/{id}")
    public String deleteCinema(@PathVariable(value = "id") Long id){
        cinemaService.removeCinemaById(id);
        return "redirect:/cinemas";
    }

}

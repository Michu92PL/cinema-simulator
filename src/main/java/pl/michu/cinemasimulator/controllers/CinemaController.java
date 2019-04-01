package pl.michu.cinemasimulator.controllers;

import com.sun.deploy.nativesandbox.comm.Request;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.michu.cinemasimulator.model.Cinema;
import pl.michu.cinemasimulator.model.Screening;
import pl.michu.cinemasimulator.services.CinemaService;
import pl.michu.cinemasimulator.services.MovieService;
import pl.michu.cinemasimulator.services.ScreeningService;

import javax.validation.Valid;
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
    public String getCinemaList(Model model) {
        List<Cinema> cinemas = cinemaService.findAll();
        model.addAttribute("cinemas", cinemas);
        return "cinemas";
    }

    @GetMapping("/newcinema")
    public String createCinema(Model model) {
        model.addAttribute("cinema", new Cinema());
        return "cinemaform";
    }

    @PostMapping("/cinemas")
    public String addCinema(@Valid Cinema cinema, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cinemaform";
        } else {
            cinemaService.addCinema(cinema);
            return "redirect:/cinemas";
        }
    }

    @GetMapping("/cinema/delete/{id}")
    public String deleteCinema(@PathVariable(value = "id") Long id) {
        cinemaService.removeCinemaById(id);
        return "redirect:/cinemas";
    }

    @GetMapping("/addscr/{id}")
    public String getScreeningForm(@PathVariable(value = "id") Long id, Model model) {
            model.addAttribute("movies", movieService.findAll());
            //Cinema cinema = cinemaService.findById(id);
            Screening screening = new Screening();
            //screening.setCinema(cinema);
            model.addAttribute("screening", screening);
            model.addAttribute("cinemaid", id);
            return "screeningform";
    }

    @PostMapping("/addscr/{id}")
    public String addScreeningToCinema(@PathVariable(value = "id") Long id, Screening screening){
        //System.out.println("HALO JESTEM TUTAJ");
        //System.out.println(screening.getMovie().getTitle());
        //System.out.println(screening.getHallNumber());
        Cinema cinema = cinemaService.findById(id);
        screening.setCinema(cinema);
        cinema.addScreening(screening);
        cinemaService.addCinema(cinema);

       /* System.out.println(screening.getCinema().getName());
        for(Screening screening1 : cinema.getScreenings()){
            System.out.println("HALOHALOHALO" + screening1.getMovie());
            System.out.println("HALOHALOHALO" + screening1.getTicketPrize());
        }
*/

        return "redirect:/cinemas";
    }
}

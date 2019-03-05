package pl.michu.cinemasimulator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.michu.cinemasimulator.model.Cinema;
import pl.michu.cinemasimulator.model.Movie;
import pl.michu.cinemasimulator.model.Screening;
import pl.michu.cinemasimulator.repositories.CinemaRespository;
import pl.michu.cinemasimulator.repositories.MovieRepository;
import pl.michu.cinemasimulator.repositories.ScreeningRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Consumer;

@Component
public class TestClass implements CommandLineRunner {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CinemaRespository respository;

    @Autowired
    ScreeningRepository screeningRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Cinema cinema = new Cinema("multikino", "towarowa", "12412512");
        Cinema cinema2 = new Cinema("citykino", "zielona", "1asdasd");


        Movie movie1 = new Movie("gladiator", "asdf", "dramat");
        Movie movie2 = new Movie("gwiezdne wojny", "asdf", "epickosc");
        Movie movie3 = new Movie("batman", "asdf", "akcja");

        Screening screening = new Screening("11", 11);
        screening.setMovie(movie1);
        movie1.addScreening(screening);

        Screening screening2 = new Screening("22",22);
        screening2.setMovie(movie2);
        movie2.addScreening(screening2);

        Screening screening3 = new Screening("33",33);
        screening3.setMovie(movie3);
        movie3.addScreening(screening3);

        Screening screening4 = new Screening("44",44);
        screening4.setMovie(movie1);
        movie1.addScreening(screening4);

        cinema.addScreening(screening);
        cinema.addScreening(screening2);
        screening.setCinema(cinema);
        screening2.setCinema(cinema);

        cinema2.addScreening(screening3);
        screening3.setCinema(cinema2);
        cinema2.addScreening(screening4);
        screening4.setCinema(cinema2);

        respository.save(cinema);
        respository.save(cinema2);

        /*Cinema kino = respository.getOne(1L);
        System.out.println(kino);
        respository.delete(kino);*/

        // respository.delete(cinema);
        respository.deleteById(1L);
        //respository.flush();

        for(Movie m : movieRepository.findAll()){
            System.out.print("TYTUŁY FILMOW: " + m.getTitle() + "   wyświetlam w kinach :   ");
            for(Screening s : m.getScreenings()){
                System.out.print(s.getCinema().getName() + " ");
            }
            System.out.println();
        }
        //respository.delete(cinema);

        /*screening.setMovie(movie);
        screening2.setMovie(movie);
        movie.addScreening(screening);
        movie.addScreening(screening2);
        cinema.addScreening(screening);
        cinema.addScreening(screening2);*/

        //em.persist(cinema);

        //Cinema test = em.find(Cinema.class, cinema.getId());
        //test.getScreenings().forEach(s -> s.getMovie().getTitle());

    }
}

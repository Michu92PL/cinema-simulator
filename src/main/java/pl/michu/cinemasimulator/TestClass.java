package pl.michu.cinemasimulator;


import org.hibernate.mapping.Collection;
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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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

       /* Cinema cinema = new Cinema("multikino", "towarowa", "12412512");
        Cinema cinema2 = new Cinema("citykino", "zielona", "1asdasd");


        Movie movie1 = new Movie("gladiator", "asdfqqqq", "dramat");
        Movie movie2 = new Movie("gwiezdne wojny", "asdfqqqq", "epickosc");
        Movie movie3 = new Movie("batman", "asdfqqq", "akcja");

        Screening screening = new Screening("11", 15,15.34);
        screening.setMovie(movie1);
        movie1.addScreening(screening);

        Screening screening2 = new Screening("22",22, 18.22);
        screening2.setMovie(movie2);
        movie2.addScreening(screening2);

        Screening screening3 = new Screening("33",33, 15.99);
        screening3.setMovie(movie3);
        movie3.addScreening(screening3);

        Screening screening4 = new Screening("44",44, 10.99);
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

        *//*Cinema kino = respository.getOne(1L);
        System.out.println(kino);
        respository.delete(kino);*//*

        // respository.delete(cinema);
        //respository.deleteById(1L);
        //respository.flush();

        for(Movie m : movieRepository.findAll()){
            System.out.print("TYTUŁY FILMOW: " + m.getTitle() + "   wyświetlam w kinach :   ");
            for(Screening s : m.getScreenings()){
                System.out.print(s.getCinema().getName() + " ");
            }
            System.out.println();
        }
        screening.reserveSeats(2);
        screening2.reserveSeats(6);
        screening3.reserveSeats(12);
        screening4.reserveSeats(12);
        *//*List<Screening> sdf = new ArrayList<>();
        sdf.add(screening);
        sdf.add(screening2);
        sdf.add(screening3);
        sdf.add(screening4);
        screeningRepository.saveAll(sdf);
        respository.save(cinema);*//*
        System.out.println("expected income ::::::" + cinema.getExpectedIncome());
        //respository.delete(cinema);

        *//*screening.setMovie(movie);
        screening2.setMovie(movie);
        movie.addScreening(screening);
        movie.addScreening(screening2);
        cinema.addScreening(screening);
        cinema.addScreening(screening2);*//*

        //em.persist(cinema);

        //Cinema test = em.find(Cinema.class, cinema.getId());
        //test.getScreenings().forEach(s -> s.getMovie().getTitle());
*/
    }
}

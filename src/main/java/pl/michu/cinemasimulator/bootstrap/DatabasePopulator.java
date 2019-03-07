package pl.michu.cinemasimulator.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.michu.cinemasimulator.model.Cinema;
import pl.michu.cinemasimulator.model.Movie;
import pl.michu.cinemasimulator.model.Screening;
import pl.michu.cinemasimulator.services.CinemaService;
import pl.michu.cinemasimulator.services.MovieService;
import pl.michu.cinemasimulator.services.ScreeningService;

@Component
public class DatabasePopulator implements ApplicationListener<ContextRefreshedEvent> {

    private CinemaService cinemaService;
    private MovieService movieService;
    private ScreeningService screeningService;

    @Autowired
    public DatabasePopulator(CinemaService cinemaService, MovieService movieService, ScreeningService screeningService) {
        this.cinemaService = cinemaService;
        this.movieService = movieService;
        this.screeningService = screeningService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        populateDatabase();
    }

    private void populateDatabase() {

        Cinema cinema1 = new Cinema("Multikino", "Towarowa 47", "12 125-12-40");
        Cinema cinema2 = new Cinema("Cinema City", "Kujawska 15a", "52 333-90-28");
        Cinema cinema3 = new Cinema("Kino Helios", "Betonowa 420", "52 475-73-09");

        Movie movie1 = new Movie("Gladiator", "Generał Maximus - prawa ręka cesarza, s" +
                "zczęśliwy mąż i ojciec - w jednej chwili traci wszystko. " +
                "Jako niewolnik-gladiator musi walczyć na arenie o przeżycie.", "Dramat historyczny");

        Movie movie2 = new Movie("Gwiezdne Wojny I: Mroczne Widmo", "Dwaj rycerze Jedi wyruszają z misją " +
                "ocalenia planety Naboo przed inwazją wojsk Federacji Handlowej. " +
                "Trafiają na pustynny glob, gdzie pomoże im mały Anakin Skywalker.", "Sci-Fi");

        Movie movie3 = new Movie("Mroczny Rycerz", "Batman, z pomocą porucznika Gordona " +
                "oraz prokuratora Harveya Denta, występuje przeciwko przerażającemu i nieobliczalnemu Jokerowi, " +
                "który chce pogrążyć Gotham City w chaosie.", "Akcja");

        Movie movie4 = new Movie("W cieniu chwały","Czterech nowojorskich policjantów ginie podczas interwencji. " +
                "Prowadzący dochodzenie detektyw, Ray Tierney, trafia na ślad afery korupcyjnej, " +
                "w którą zamieszany jest jego szwagier, Jimmy.","Kryminał");

        Movie movie5 = new Movie("Pierwszy człowiek", "Fragment życia astronauty Neila Armstronga i jego legendarnej misji kosmicznej, " +
                "dzięki której jako pierwszy człowiek stanął na Księżycu.", "Biograficzny");

        Movie movie6 = new Movie("Interstellar", "Byt ludzkości na Ziemi dobiega końca wskutek zmian klimatycznych. " +
                "Grupa naukowców odkrywa tunel czasoprzestrzenny, który umożliwia poszukiwanie nowego domu.", "Sci-fi");

        Screening screening1 = new Screening("22:00",60, 18.9);
        Screening screening2 = new Screening("15:00",40, 14.99);
        Screening screening3 = new Screening("13:00",75, 12.99);
        Screening screening4 = new Screening("13:30",25, 16.99);
        Screening screening5 = new Screening("01:00",45, 20.99);
        Screening screening6 = new Screening("18:00",80, 25.99);
        Screening screening7 = new Screening("17:00",30, 13.99);
        Screening screening8 = new Screening("17:00",30, 13.99);
        Screening screening9 = new Screening("12:00",144, 11.99);
        Screening screening10 = new Screening("09:00",48, 9.99);
        Screening screening11 = new Screening("10:00",100, 8.99);
        Screening screening12 = new Screening("12:00",120, 17.99);
        Screening screening13 = new Screening("12:30",90, 15.99);
        Screening screening14 = new Screening("23:00",88, 18.99);

        screening1.setMovie(movie3);
        screening2.setMovie(movie4);
        screening3.setMovie(movie5);
        screening4.setMovie(movie1);
        screening5.setMovie(movie2);
        screening6.setMovie(movie6);
        screening7.setMovie(movie6);
        screening8.setMovie(movie1);
        screening9.setMovie(movie2);
        screening10.setMovie(movie3);
        screening11.setMovie(movie4);
        screening12.setMovie(movie5);
        screening13.setMovie(movie5);
        screening14.setMovie(movie6);

        cinema1.addScreening(screening1);
        cinema1.addScreening(screening2);
        cinema1.addScreening(screening3);
        cinema1.addScreening(screening9);
        cinema1.addScreening(screening14);
        cinema2.addScreening(screening4);
        cinema2.addScreening(screening5);
        cinema2.addScreening(screening10);
        cinema2.addScreening(screening11);
        cinema3.addScreening(screening6);
        cinema3.addScreening(screening7);
        cinema3.addScreening(screening8);
        cinema3.addScreening(screening12);
        cinema3.addScreening(screening13);

         /* movie1.addScreening(screening4);
        movie1.addScreening(screening8);
        movie2.addScreening(screening5);
        movie3.addScreening(screening1);
        movie4.addScreening(screening2);
        movie5.addScreening(screening3);
        movie6.addScreening(screening6);
        movie6.addScreening(screening7);
        movie2.addScreening(screening9);
        movie3.addScreening(screening10);
        movie4.addScreening(screening11);
        movie5.addScreening(screening12);
        movie6.addScreening(screening7);
        movie6.addScreening(screening7);
        movie6.addScreening(screening7);*/

       /* screening1.setCinema(cinema1);
        screening2.setCinema(cinema1);
        screening3.setCinema(cinema1);
        screening4.setCinema(cinema2);
        screening5.setCinema(cinema2);
        screening6.setCinema(cinema3);
        screening7.setCinema(cinema3);
        screening8.setCinema(cinema3);*/

        screening1.reserveSeats(21);
        screening2.reserveSeats(17);
        screening3.reserveSeats(52);
        screening4.reserveSeats(18);
        screening5.reserveSeats(7);
        screening6.reserveSeats(64);
        screening7.reserveSeats(9);
        screening8.reserveSeats(4);

        cinemaService.addCinema(cinema1);
        cinemaService.addCinema(cinema2);
        cinemaService.addCinema(cinema3);

    }
}

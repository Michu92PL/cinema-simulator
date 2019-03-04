package pl.michu.cinemasimulator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michu.cinemasimulator.model.Cinema;
import pl.michu.cinemasimulator.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}

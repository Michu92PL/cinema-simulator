package pl.michu.cinemasimulator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michu.cinemasimulator.model.Cinema;

@Repository
public interface CinemaRespository extends JpaRepository<Cinema, Long> {
}

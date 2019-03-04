package pl.michu.cinemasimulator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michu.cinemasimulator.model.Movie;
import pl.michu.cinemasimulator.model.Screening;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}

package pl.michu.cinemasimulator.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 40,message = "Tytuł musi mieć między 2 a 40 znaków")
    private String title;
    @NotNull
    @Size(min = 5, max = 200, message = "Opis musi mieć między 5 a 200 znaków")
    private String description;
    @NotNull
    @Size(min = 2, max = 20, message = "Gatunek filmu musi mieć między 2 a 20 znaków")
    private String genre;

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
    private List<Screening> screenings;

    public Movie() {
    }

    public Movie(String title, String description, String genre) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.screenings = new ArrayList<>();
    }

    public void addScreening(Screening screening){
        screenings.add(screening);
    }

    public List<Screening> getScreenings() {
        return screenings;
    }


    public String getTitle() {
        return title;
    }

    public void deleteScreening(Screening screening) {
        screenings.remove(screening);
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

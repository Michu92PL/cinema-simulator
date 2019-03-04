package pl.michu.cinemasimulator.model;

import javax.persistence.*;

@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hour;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Cinema cinema;
    private Integer seats;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Movie movie;

    private Screening() {

    }

    public Screening(String hour, Integer seats) {
        this.hour = hour;
        this.seats = seats;
    }

    public Screening(String hour, Cinema cinema, Integer seats) {
        this.hour = hour;
        this.cinema = cinema;
        this.seats = seats;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }
}

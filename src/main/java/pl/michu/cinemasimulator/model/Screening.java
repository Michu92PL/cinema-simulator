package pl.michu.cinemasimulator.model;

import javax.persistence.*;

@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String startTime;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Cinema cinema;

    private Integer seatsTotal;
    private Integer seatsFree;
    private Integer seatsTaken = 0;
    private Integer ticketPrize;
    private Integer roomNumber;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Movie movie;

    private Screening() {

    }

    public Screening(String startTime, Integer seatsTotal) {
        this.startTime = startTime;
        this.seatsTotal = seatsTotal;
    }

    public Screening(String startTime, Cinema cinema, Integer seatsTotal) {
        this.startTime = startTime;
        this.cinema = cinema;
        this.seatsTotal = seatsTotal;
    }

    public void deleteCinema(){
        this.cinema = null;
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

    public Long getId() {
        return id;
    }

    public String getStartTime() {
        return startTime;
    }

    public Integer getSeatsTotal() {
        return seatsTotal;
    }

    public Movie getMovie() {
        return movie;
    }
}

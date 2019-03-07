package pl.michu.cinemasimulator.model;

import pl.michu.cinemasimulator.exceptions.NotEnoughFreeSeatsException;

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
    private Double ticketPrize;
    private Integer seatsTaken = 0;
    private Integer seatsFree = 0;
    @Transient
    private Double expectedIncome = 0.0;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Movie movie;

    private Screening() {

    }

    public Screening(String startTime, Integer  seatsTotal, Double ticketPrize) {
        this.startTime = startTime;
        this.seatsTotal = seatsTotal;
        this.ticketPrize = ticketPrize;
        this.seatsFree = seatsTotal;
    }

    public Screening(String startTime, Cinema cinema, Integer seatsTotal, Double ticketPrize) {
        this.startTime = startTime;
        this.cinema = cinema;
        this.seatsTotal = seatsTotal;
        this.ticketPrize = ticketPrize;
        this.seatsFree = seatsTotal;
    }

    public Screening(String startTime, Integer seatsTotal) {
        this.startTime = startTime;
        this.seatsTotal = seatsTotal;
        this.ticketPrize = 0.0;
        this.seatsFree = seatsTotal;

    }

    public Screening(String startTime, Cinema cinema, Integer seatsTotal) {
        this.startTime = startTime;
        this.cinema = cinema;
        this.seatsTotal = seatsTotal;
        this.ticketPrize = 0.0;
        this.seatsFree = seatsTotal;
    }

    public void reserveSeats(Integer number){
        if(seatsFree < number){
            throw new NotEnoughFreeSeatsException("Not enough free seats!");
        }
        else{
            seatsTaken = seatsTaken + number;
            seatsFree = seatsFree - seatsTaken;
        }
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void setMovie(Movie movie) {
        movie.addScreening(this);
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public Long getId() {
        return id;
    }

    public void deleteCinema() {
        this.cinema = null;
    }

    public Double getExpectedIncome(){
        expectedIncome =  seatsTaken * ticketPrize;
        return expectedIncome;
    }

    public String getStartTime() {
        return startTime;
    }

    public Integer getSeatsTotal() {
        return seatsTotal;
    }

    public Double getTicketPrize() {
        return ticketPrize;
    }

    public Integer getSeatsTaken() {
        return seatsTaken;
    }

    public Integer getSeatsFree() {
        return seatsFree;
    }
}

package pl.michu.cinemasimulator.exceptions;

public class CinemaNotFoundException extends RuntimeException {

    public CinemaNotFoundException(Long id){
        super("Nie ma takiego kina" + id);
    }
    public CinemaNotFoundException(String message) {
        super(message);
    }

    public CinemaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

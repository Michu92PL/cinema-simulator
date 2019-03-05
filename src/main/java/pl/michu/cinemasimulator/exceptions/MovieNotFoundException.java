package pl.michu.cinemasimulator.exceptions;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(Long id){
        super("Nie ma takiego filmu" + id);
    }
    public MovieNotFoundException(String message) {
        super(message);
    }

    public MovieNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

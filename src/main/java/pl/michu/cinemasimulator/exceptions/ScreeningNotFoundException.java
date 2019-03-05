package pl.michu.cinemasimulator.exceptions;

public class ScreeningNotFoundException extends RuntimeException {

    public ScreeningNotFoundException(Long id){
        super("Nie ma takiego seansu" + id);
    }

    public ScreeningNotFoundException(String message) {
        super(message);
    }

    public ScreeningNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

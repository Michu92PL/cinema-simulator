package pl.michu.cinemasimulator.exceptions;

public class NotEnoughFreeSeatsException extends RuntimeException {

    public NotEnoughFreeSeatsException(String message) {
        super(message);
    }

    public NotEnoughFreeSeatsException(String message, Throwable cause) {
        super(message, cause);
    }
}

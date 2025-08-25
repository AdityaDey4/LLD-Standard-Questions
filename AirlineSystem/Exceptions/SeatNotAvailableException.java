package AirlineSystem.Exceptions;

public class SeatNotAvailableException extends RuntimeException {
    public SeatNotAvailableException(String msg) {
        super(msg);
    }
}

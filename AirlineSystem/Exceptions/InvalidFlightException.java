package AirlineSystem.Exceptions;

public class InvalidFlightException extends RuntimeException {
    public InvalidFlightException(String msg) {
        super(msg);
    }
}

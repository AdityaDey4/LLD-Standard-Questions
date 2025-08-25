package AirlineSystem.Exceptions;

public class InvalidIdException extends RuntimeException {
    
    InvalidIdException(String msg) {
        super(msg);
    }
}

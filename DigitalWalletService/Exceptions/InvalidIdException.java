package DigitalWalletService.Exceptions;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String msg) {
        super(msg);
    }
}

package DigitalWalletService.Exceptions;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException(String msg) {
        super(msg);
    }
}

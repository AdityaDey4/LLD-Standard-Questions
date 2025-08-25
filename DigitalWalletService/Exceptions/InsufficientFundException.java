package DigitalWalletService.Exceptions;

public class InsufficientFundException extends RuntimeException {
    
    public InsufficientFundException(String msg) {
        super(msg);
    }
}

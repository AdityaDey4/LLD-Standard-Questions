package DigitalWalletService.PaymentMethod;

import DigitalWalletService.User;
import DigitalWalletService.Enum.Currency;
import DigitalWalletService.Enum.PaymentTypes;

public abstract class PaymentMethod {
    private final String id;
    private final User user;

    public PaymentMethod(String id, User user) {
        this.id = id;
        this.user = user;
    }

    public String getId() {return this.id;}
    public User getUser(){ return this.user;}

    public abstract void processPayment(Double amount, Currency currency);
    public abstract PaymentTypes getPaymentTypes();
}

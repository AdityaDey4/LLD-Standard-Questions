package DigitalWalletService.PaymentMethod;

import DigitalWalletService.User;
import DigitalWalletService.Enum.Currency;
import DigitalWalletService.Enum.PaymentTypes;

public class Card extends PaymentMethod {
    
    private final String card_number;
    private final PaymentTypes paymentTypes = PaymentTypes.CARD;

    public Card(String card_number, String id, User user) {
        super(id, user);
        this.card_number = card_number;
    }

    @Override
    public PaymentTypes getPaymentTypes() {
        return this.paymentTypes;
    }

    @Override
    public void processPayment(Double amount, Currency currency) {
         System.err.println("Payment amount : "+amount+" has been processed in currency : "+currency+" by using : "+PaymentTypes.CARD);
    }
    
}

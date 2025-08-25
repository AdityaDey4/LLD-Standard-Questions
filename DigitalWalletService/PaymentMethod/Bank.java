package DigitalWalletService.PaymentMethod;

import DigitalWalletService.User;
import DigitalWalletService.Enum.Currency;
import DigitalWalletService.Enum.PaymentTypes;

public class Bank extends PaymentMethod {
    private final int bank_account_no;
    private final PaymentTypes paymentTypes = PaymentTypes.BANK;

    public Bank(int bank_account_no, String id, User user) {
        super(id, user);
        this.bank_account_no = bank_account_no;
    }
    
    public int getAccountNo(){return this.bank_account_no;}

    @Override
    public PaymentTypes getPaymentTypes() {
        return this.paymentTypes;
    }

    @Override
    public void processPayment(Double amount, Currency currency) {
        System.err.println("Payment amount : "+amount+" has been processed in currency : "+currency+" by using : "+PaymentTypes.BANK);
    }
}

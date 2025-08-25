package DigitalWalletService;

import java.time.LocalDateTime;

import DigitalWalletService.Enum.PaymentTypes;

public class Transaction {
    private final String id;
    private final Account source;
    private final Account destination;
    private final PaymentTypes paymentTypes;
    private final double amount;
    private final LocalDateTime dateTime;

    public Transaction(String id, Account source, Account destination, PaymentTypes paymentTypes, double amount) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.paymentTypes = paymentTypes;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getId() {return this.id;}
    public Account getSourceAccount(){return this.source;}
    public Account getDestinationAccount(){return this.destination;}
    public PaymentTypes getPaymentTypes(){return this.paymentTypes;}
    public double getTransactionAmount(){return this.amount;}

    public String formatTransaction() {
        return "Sender : "+source.getUser().getName()
                +" from account no : "+source.getAccountNo()
                +" Receiver : "+destination.getUser().getName()
                +" to account no : "+destination.getAccountNo()
                +" on : "+dateTime
                +" Payment Type : "+paymentTypes
                +" Amount : "+amount+" "+source.getCurrency();
    }
}

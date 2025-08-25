package DigitalWalletService;

import DigitalWalletService.Enum.Currency;

public class Account {
    private final String id;
    private final User user;
    private final Currency currency;
    private final int account_number;
    private double amount; 

    Account(String id, User user, Currency currency, int account_number) {
        this.id = id;
        this.user = user;
        this.currency = currency;
        this.account_number = account_number;
    }

    public String getId(){return this.id;};
    public User getUser(){return this.user;}
    public Currency getCurrency(){return this.currency;}
    public int getAccountNo(){return this.account_number;}
    public double getAmount(){return this.amount;}

    public void creditAmount(double amount) {this.amount+=amount;}
    public void debitAmount(double amount) {this.amount-=amount;}
}

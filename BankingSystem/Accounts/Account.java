package BankingSystem.Accounts;

import BankingSystem.Enum.AccountType;

public abstract class Account {
    private double balance;
    private long accountNo;
    AccountType type;

    public Account(long accountNo, AccountType type, double balance) {
        this.balance = balance;
        this.accountNo = accountNo;
        this.type = type;
    }

    public void deposit(double amount) {
        this.balance+=amount;
        printBalance();
    }

    public boolean withdraw(double amount) {

        if(amount > balance) {
            System.out.println("Insufficient Fund");
            return false;
        }

        balance-=amount;
        printBalance();
        return true;
    }

    public void printBalance() {
        System.out.println("Account No : "+accountNo+" Available Balance : "+balance);
    }
    
    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void updateBalanceByMonth();
}

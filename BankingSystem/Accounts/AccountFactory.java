package BankingSystem.Accounts;

import java.util.Random;

import BankingSystem.Enum.AccountType;

public class AccountFactory {
    
    public static Account getAccountInstance(AccountType type, double amount) {

        Random random = new Random();
        long accountNo = Math.abs(random.nextLong());
        if(type == AccountType.SAVINGS) {
            return new Savings(accountNo, type, amount);
        } else if(type == AccountType.CURRENT) {    
            return new Current(accountNo, type, amount);
        } 

        return null;
    } 
}

package DigitalWalletService.Repository;

import java.util.HashMap;
import java.util.Map;

import DigitalWalletService.Account;
import DigitalWalletService.Exceptions.InsufficientFundException;

public class AccountRepo {
    
    private final Map<String, Account> accounts = new HashMap<>();

    public void saveAccount(Account account){accounts.put(account.getId(), account);}
    public Account findAccountById(String id) {
        if(!accounts.containsKey(id)) return null;

        return accounts.get(id);
    }

    public void addAmount(Account account, double amount) {
        account.creditAmount(amount);
        System.err.println("Amount : "+amount+account.getCurrency()+" has been credited to account no : "+account.getAccountNo()+" by "+account.getUser().getName());
    }
    public void withdrawAmount(Account account, double amount) {
        
        if(account.getAmount() < amount) {
            throw new InsufficientFundException("Insufficient Fund");
        }
        account.debitAmount(amount);
        System.err.println("Amount : "+amount+" has been debited form account no : "+account.getAccountNo()+" by "+account.getUser().getName());
    }
}

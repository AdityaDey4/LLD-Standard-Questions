package BankingSystem;

import java.util.ArrayList;
import java.util.List;

import BankingSystem.Accounts.Account;
import BankingSystem.Accounts.AccountFactory;
import BankingSystem.Enum.AccountType;

public class BankingSystem {
    
    List<Account> accounts = new ArrayList<>();

    public Account openAccount(AccountType type, double balance) {

        Account newAccount = AccountFactory.getAccountInstance(type, balance);
        accounts.add(newAccount);

        return newAccount;
    }

    public void monthEnd() {
        for(Account account : accounts) {
            account.updateBalanceByMonth();
        }
    }
}

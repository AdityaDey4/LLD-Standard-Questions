package BankingSystem;

import BankingSystem.Accounts.Account;
import BankingSystem.Enum.AccountType;

public class Main {
    public static void main(String[] args) {

        BankingSystem bs = new BankingSystem();
        
        Account ac1 = bs.openAccount(AccountType.CURRENT, 500);
        Account ac2 = bs.openAccount(AccountType.SAVINGS, 1000);
        Account ac3 = bs.openAccount(AccountType.SAVINGS, 2000);

        ac1.deposit(1550.50);
        ac2.withdraw(1500);
        ac3.printBalance();
        
        bs.monthEnd();

        ac1.printBalance();
        ac2.printBalance();
        ac3.printBalance();
    }
}

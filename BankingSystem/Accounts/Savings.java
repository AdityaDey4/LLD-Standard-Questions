package BankingSystem.Accounts;

import BankingSystem.Enum.AccountType;
import BankingSystem.Enum.Constant;

public class Savings extends Account {

    public Savings(long accountNo, AccountType type, double balance) {
        super(accountNo, type, balance);
    }

    @Override
    public void updateBalanceByMonth() {
        
        double balance = super.getBalance();
        double interest = (balance*Constant.INTEREST_RATE.val)/100;
        
        super.setBalance(balance+interest);
    }
    
}

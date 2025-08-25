package BankingSystem.Accounts;

import BankingSystem.Enum.AccountType;
import BankingSystem.Enum.Constant;

public class Current extends Account {

    Current(long accountNo, AccountType type, double balance) {
        super(accountNo, type, balance);
    }

    @Override
    public void updateBalanceByMonth() {
        
        double balance = super.getBalance();
        super.setBalance(balance-Constant.MAINTENANCE_CHARGE.val);
    }
    
}

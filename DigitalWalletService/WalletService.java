package DigitalWalletService;

import java.util.UUID;

import DigitalWalletService.Enum.Currency;
import DigitalWalletService.PaymentMethod.PaymentMethod;
import DigitalWalletService.Repository.AccountRepo;
import DigitalWalletService.Repository.PaymentMethodRepo;
import DigitalWalletService.Repository.TransactionRepo;
import DigitalWalletService.Repository.UserRepo;

public class WalletService {
    
    private static WalletService instance;
    private final UserRepo userRepo;
    private final AccountRepo accountRepo;
    private final PaymentMethodRepo paymentMethodRepo;
    private final TransactionRepo transactionRepo;

    private WalletService(UserRepo userRepo, AccountRepo accountRepo, PaymentMethodRepo paymentMethodRepo, TransactionRepo transactionRepo){
        this.userRepo = userRepo;
        this.accountRepo = accountRepo;
        this.paymentMethodRepo = paymentMethodRepo;
        this.transactionRepo = transactionRepo;
    }

    public static WalletService getInstance(UserRepo userRepo, AccountRepo accountRepo, PaymentMethodRepo paymentMethodRepo, TransactionRepo transactionRepo) {
        if(instance == null) {
            instance = new WalletService(userRepo, accountRepo, paymentMethodRepo, transactionRepo);
        }

        return instance;
    }

    public void addUser(User user) {
        userRepo.saveUser(user);
    }

    public Account createAccount(User user, Currency currency) {
        Account account = new Account(UUID.randomUUID().toString(), user, currency, Math.abs(UUID.randomUUID().hashCode()));
        accountRepo.saveAccount(account);  

        return account;
    }

    public void addAmount(Account account, double amount) {
        accountRepo.addAmount(account, amount);
    }

    public void withdrawAmount(Account account, double amount) {
        accountRepo.withdrawAmount(account, amount);
    }

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethodRepo.savePaymentMethod(paymentMethod);
    }

    public void removePaymentMethod(PaymentMethod paymentMethod) {
        paymentMethodRepo.removePaymentMethod(paymentMethod);
    }

    public synchronized Transaction processTransaction(String userId, String sourceAccountId, String receiverAccountId, String paymentMethodId, double amount) {
        return transactionRepo.processTransAction(userId, sourceAccountId, receiverAccountId, paymentMethodId, amount);
    }

    public void printTransactionHistoryOfAccount(String userId, String accountId) {
        transactionRepo.getTransActionHistory(userId, accountId);
    }
}

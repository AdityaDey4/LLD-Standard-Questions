package DigitalWalletService;

import java.util.List;

import DigitalWalletService.Enum.Currency;
import DigitalWalletService.PaymentMethod.Bank;
import DigitalWalletService.PaymentMethod.Card;
import DigitalWalletService.PaymentMethod.PaymentMethod;
import DigitalWalletService.Repository.AccountRepo;
import DigitalWalletService.Repository.PaymentMethodRepo;
import DigitalWalletService.Repository.TransactionRepo;
import DigitalWalletService.Repository.UserRepo;

public class Main {
    
    public static void main(String[] args) {

        UserRepo userRepo = new UserRepo();
        AccountRepo accountRepo = new AccountRepo();
        PaymentMethodRepo paymentMethodRepo = new PaymentMethodRepo();
        TransactionRepo transactionRepo = new TransactionRepo(userRepo, accountRepo, paymentMethodRepo);

        WalletService walletService = WalletService.getInstance(userRepo, accountRepo, paymentMethodRepo, transactionRepo);

        User user1 = new User("User1", "Aditya", 629679872);
        User user2 = new User("User2", "Rudra", 876543219);
        walletService.addUser(user1);
        walletService.addUser(user2);

        Account account1 = walletService.createAccount(user1, Currency.INR);
        Account account2 = walletService.createAccount(user1, Currency.EUR);
        Account account3 = walletService.createAccount(user2, Currency.USD);

        walletService.addAmount(account1, 5000);
        walletService.addAmount(account3, 35);

        PaymentMethod paymentMethod1 = new Card("123456789102", "PM1", user1);
        PaymentMethod paymentMethod2 = new Bank(12047, "PM2", user2);
        walletService.addPaymentMethod(paymentMethod1);
        walletService.addPaymentMethod(paymentMethod2);

        walletService.processTransaction("User1", account1.getId(), account3.getId(), "PM1", 1127.78);
        try {
            walletService.processTransaction("User2", account3.getId(), account2.getId(), "PM2", 49);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }

        walletService.printTransactionHistoryOfAccount("User1", account1.getId());
        walletService.printTransactionHistoryOfAccount("User2", account3.getId());

        List<PaymentMethod> methods = paymentMethodRepo.getPaymentMethodsOfUsers(user2);
        System.err.println(methods);
    }
}

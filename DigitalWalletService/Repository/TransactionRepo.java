package DigitalWalletService.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import DigitalWalletService.Account;
import DigitalWalletService.CurrencyConverter;
import DigitalWalletService.Transaction;
import DigitalWalletService.User;
import DigitalWalletService.Exceptions.InsufficientFundException;
import DigitalWalletService.Exceptions.InvalidIdException;
import DigitalWalletService.Exceptions.InvalidUserException;
import DigitalWalletService.PaymentMethod.PaymentMethod;

public class TransactionRepo {
    
    private final Map<String, Transaction> transactions = new HashMap<>();

    private final UserRepo userRepo;
    private final AccountRepo accountRepo;
    private final PaymentMethodRepo paymentMethodRepo;
    private final CurrencyConverter currencyConverter;

    public TransactionRepo(UserRepo userRepo, AccountRepo accountRepo, PaymentMethodRepo paymentMethodRepo) {
        this.userRepo = userRepo;
        this.accountRepo = accountRepo;
        this.paymentMethodRepo = paymentMethodRepo;
        currencyConverter = new CurrencyConverter();
    }

    public void saveTransaction(Transaction transaction) {
        this.transactions.put(transaction.getId(), transaction);
    }
    public Transaction getTransactionById(String id) {
        if(!transactions.containsKey(id)) return null;

        return transactions.get(id);
    }

    public synchronized Transaction processTransAction(String userId, String sourceAccountId, String receiverAccountId, String paymentMethodId, double amount) {

        User user = userRepo.findUserById(userId);
        Account source = accountRepo.findAccountById(sourceAccountId);
        Account receiver = accountRepo.findAccountById(receiverAccountId);
        PaymentMethod paymentMethod = paymentMethodRepo.findPaymentMethodById(paymentMethodId);

        if(user == null || source == null || receiver == null || paymentMethod == null) {
            throw new InvalidIdException("Invalid id");
        }

        if(!source.getUser().getId().equals(userId) || !paymentMethod.getUser().getId().equals(userId)) {
            throw new InvalidUserException("User is not the owner of provided account or Payment Method");
        }

        if(source.getAmount() < amount) {
            throw new InsufficientFundException("Insufficient fund");
        }


        double receivedAmount = currencyConverter.convert(amount, source.getCurrency(), receiver.getCurrency());
        receiver.creditAmount(receivedAmount);

        paymentMethod.processPayment(amount , source.getCurrency());
        source.debitAmount(amount);

        Transaction transaction = new Transaction(UUID.randomUUID().toString(), source, receiver, paymentMethod.getPaymentTypes(), amount);
        transactions.put(transaction.getId(), transaction);

        return transaction;
    }

    public void getTransActionHistory(String userId, String accountId) {

        User user = userRepo.findUserById(userId);
        Account account = accountRepo.findAccountById(accountId);
        if(user == null || account == null) {
            throw new InvalidIdException("Invalid id");
        }

        if(!account.getUser().getId().equals(userId)) {
            throw new InvalidUserException("User is not the owner of provided account");
        }

        for(Transaction transaction : transactions.values()) {
            if(transaction.getSourceAccount().getId().equals(account.getId())) {
                System.err.println("Status : SEND "+transaction.formatTransaction());
            }
            if(transaction.getDestinationAccount().getId().equals(account.getId())) {
                System.err.println("Status : RECEIVED "+transaction.formatTransaction());
            }
        }

        System.err.println("Available Balance : "+account.getAmount()+" "+account.getCurrency());
        System.err.println();
    }
}

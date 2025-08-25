package Splitwise;

import java.util.*;

import Splitwise.Enum.SplitType;
import Splitwise.Split.Split;

public class ExpenceManager {
    List<User> users;
    List<Expence> expences;
    Map<User, Map<User, Double>> sheet;

    ExpenceManager() {
        users = new ArrayList<>();
        expences = new ArrayList<>();
        sheet = new HashMap<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void createExpence(User paidBy, int totalAmount, int totalUsers, SplitType type, List<Split> splits, String notes) {
        
        Expence newExpence = new Expence(paidBy, totalUsers, totalAmount, notes, splits, type);
        expences.add(newExpence);

        sheet.putIfAbsent(paidBy, new HashMap<>());

        for(Split split : splits) {
            User paidTo = split.getUser();
            if(paidTo == paidBy) continue;

            // negative : paidTo has to send money to paidBy
            sheet.putIfAbsent(paidTo, new HashMap<>());
            sheet.get(paidTo).put(paidBy, sheet.get(paidTo).getOrDefault(paidBy, 0.0)-split.getAmount());

            // postitve : paidBy will receive from paidTo
            sheet.get(paidBy).put(paidTo, sheet.get(paidBy).getOrDefault(paidTo, 0.0)+split.getAmount());
        }
    }

    public void printAllSplits() {

        boolean txnHappened = false;
        for(User mapUser : sheet.keySet()) {
            for(User mapMapUser : sheet.get(mapUser).keySet()) {
                txnHappened = true;
                double amount = sheet.get(mapUser).get(mapMapUser);
                if(amount < 0) continue;
                print(mapUser, mapMapUser, amount);
            }
        }

        if(!txnHappened) {
            System.out.println("No Transaction Happened");
        }
        
        System.out.println();
    }

    public void printIndividualSplit(User user) {
        boolean txnHappened = false;
        for(User otherUser : sheet.get(user).keySet()) {
            txnHappened = true;
            print(user, otherUser, sheet.get(user).get(otherUser));
        }

        if(!txnHappened) {
            System.out.println("No Transaction Happened");
        }

        System.out.println();
    }

    public void print(User mapUser, User mapMapUser, double amount) {

        // positive : mapMapUser = paidTo, mapUser = paiBy
        if(amount > 0) {
            System.out.println(mapMapUser.name+" owes "+mapUser.name+" : amount -> "+amount);
        }else {
            // negative : mapMapUser = paidBy, mapUser = paidTo
            System.out.println(mapUser.name+" owes "+mapMapUser.name+" : amount -> "+(-amount));
        }
    }
}

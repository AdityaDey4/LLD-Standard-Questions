package Splitwise.Split;

import Splitwise.User;

public abstract class Split {
    private User user;
    private double amount;

    public Split(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }

    public double getAmount () {
        return amount;
    }

    public User getUser() {
        return user;
    }
}

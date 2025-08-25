package Splitwise.Split;

import Splitwise.User;

public class PercentSplit extends Split {
    
    int percent;
    public PercentSplit(User user, double amount, int percent) {
        super(user, amount);
        this.percent = percent;
    }
}

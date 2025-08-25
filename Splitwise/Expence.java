package Splitwise;

import java.util.List;

import Splitwise.Enum.SplitType;
import Splitwise.Split.Split;

public class Expence {
    User paidBy;
    int totalUsers;
    double totalAmount;
    String notes;
    List<Split> splits;
    SplitType type;

    Expence(User paidBy, int totalUser, double totalAmount, String notes, List<Split> splits, SplitType type) {
        this.paidBy = paidBy;
        this.notes = notes;
        this.totalAmount = totalAmount;
        this.totalUsers = totalUser;
        this.splits = splits;
        this.type = type;
    }
}

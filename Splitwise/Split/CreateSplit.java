package Splitwise.Split;

import java.util.ArrayList;
import java.util.List;

import Splitwise.User;
import Splitwise.Enum.SplitType;

public class CreateSplit {
    
    public static List<Split> createSplit(SplitType type, int totalAmount, List<User> othUsers, List<Integer> values) {

        List<Split> splits = new ArrayList<>();

        if(type == SplitType.EQUAL) {
            int totalUser = othUsers.size();
            double amount = totalAmount/totalUser;

            for(User user : othUsers) {
                splits.add(new EqualSplit(user, amount));
            }
        } else if(type == SplitType.EXACT) {
            if(checkInvalidAmount(totalAmount, othUsers, values)) {
                System.out.println("Invalid Input");
                return null;
            }

            for(int i=0; i<values.size(); i++) {
                splits.add(new ExactSplit(othUsers.get(i), (double) values.get(i)));
            }
        } else {
            if(checkInvalidPercent(totalAmount, othUsers, values)) {
                System.out.println("Invalid Input");
                return null;
            }

            double percent = totalAmount/100;
            for(int i=0; i<values.size(); i++) {
                double percentAmount = percent*values.get(i);
                splits.add(new PercentSplit(othUsers.get(i), percentAmount, values.get(i)));
            }
        }

        return splits;
    }

    public static boolean checkInvalidAmount(int totalAmount, List<User> othUsers, List<Integer> values) {
        int sum = 0;
        for(int it : values) sum+= it;

        return sum != totalAmount || values.size() != othUsers.size();
    }

    public static boolean checkInvalidPercent(int totalAmount, List<User> othUsers, List<Integer> values) {
        int sum = 0;
        for(int it : values) sum+= it;

        return sum != 100 || values.size() != othUsers.size();
    }
}

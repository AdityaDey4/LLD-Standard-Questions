package Splitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Splitwise.Enum.SplitType;
import Splitwise.Split.CreateSplit;
import Splitwise.Split.Split;

public class Main {
    public static void main(String[] args) {
        ExpenceManager expenseManager = new ExpenceManager();

        User user1 = new User("User1", "gaurav@workat.tech");
        User user2 = new User("User2", "sagar@workat.tech");
        User user3 = new User("User3", "hi@workat.tech");
        User user4 = new User("User4", "mock-interviews@workat.tech");

        expenseManager.addUser(user1);
        expenseManager.addUser(user2);
        expenseManager.addUser(user3);
        expenseManager.addUser(user4);

        expenseManager.printAllSplits();


        List<User> list1 = new ArrayList<>();
        list1.add(user1);
        list1.add(user2);
        list1.add(user3);
        list1.add(user4);
        List<Split> split1= CreateSplit.createSplit(SplitType.EQUAL, 1000, list1, null);
        expenseManager.createExpence(user1, 1000, 4, SplitType.EQUAL, split1, "Momo");
        expenseManager.printAllSplits();
        expenseManager.printIndividualSplit(user4);


        List<User> list2 = new ArrayList<>();
        list2.add(user2);
        list2.add(user3);
        List<Split> split2 = CreateSplit.createSplit(SplitType.EXACT, 1250, list2, Arrays.asList(370, 880));
        expenseManager.createExpence(user1, 1000, 2, SplitType.EXACT, split2, "Shopping");
        expenseManager.printAllSplits();


        List<User> list3 = new ArrayList<>();
        list3.add(user1);
        list3.add(user2);
        list3.add(user3);
        list3.add(user4);
        List<Split> split3 = CreateSplit.createSplit(SplitType.PERCENT, 1200, list3, Arrays.asList(40, 20, 20, 20));
        expenseManager.createExpence(user4, 1200, 4, SplitType.PERCENT, split3, "Beer");
        expenseManager.printAllSplits();
        expenseManager.printIndividualSplit(user1);
    }
}

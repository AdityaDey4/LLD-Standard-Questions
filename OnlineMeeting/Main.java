package OnlineMeeting;

import java.util.ArrayList;
import java.util.List;

import OnlineMeeting.Enum.Interval;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        MeetingScheduler scheduler = new MeetingScheduler(2);
        User user1 = new User("A", "a.");
        User user2 = new User("B", "b.");
        User user3 = new User("C", "c.");

        List<User> list1 = new ArrayList<>();
        list1.add(user1);
        list1.add(user2);

        scheduler.bookMeeting(Interval.ONE_TWO, list1);
        System.out.println();

        list1.remove(0);
        scheduler.bookMeeting(Interval.ONE_TWO, list1);
        System.out.println();

        list1.add(user3);
        scheduler.bookMeeting(Interval.ONE_TWO, list1);
        System.out.println();
    }
}

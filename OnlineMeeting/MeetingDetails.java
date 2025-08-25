package OnlineMeeting;

import java.util.List;

import OnlineMeeting.Enum.Interval;

public class MeetingDetails {
    Interval interval;
    List<User> list;

    MeetingDetails(Interval interval, List<User> users) {
        list = users;
        this.interval = interval;
    }
}

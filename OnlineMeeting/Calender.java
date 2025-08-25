package OnlineMeeting;

import java.util.ArrayList;
import java.util.List;

public class Calender {
    List<MeetingDetails> details = new ArrayList<>();

    public void addMeetingToCalender(MeetingDetails md) {
        this.details.add(md);
    }
}

package OnlineMeeting;

import OnlineMeeting.Enum.Interval;

public class MeetingRooms implements NoftifyObserver {
    String id;
    int capacity;
    Calender calender;

    MeetingRooms(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        calender = new Calender();
    }

    public boolean isAvailable(Interval interval) {
        
        for(MeetingDetails md : calender.details) {
            if(md.interval != interval) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void notifyUsers(MeetingDetails md) {
        System.out.println("A new meeting has been created in this room, id : "+this.id+" Time : "+md.interval.getTime());
    }
}

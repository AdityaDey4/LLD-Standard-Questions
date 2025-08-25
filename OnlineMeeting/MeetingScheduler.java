package OnlineMeeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import OnlineMeeting.Enum.Interval;

public class MeetingScheduler {
    MeetingRooms rooms[];
    
    MeetingScheduler(int n) {
        rooms = new MeetingRooms[n];
        createMeetingRooms();
    }

    public void createMeetingRooms() {
        int n = rooms.length;
        for(int i=0; i<n; i++) {
            rooms[i] = new MeetingRooms(Integer.toString(i+1), i+1);
        }

        Arrays.sort(rooms, (a, b)-> a.capacity-b.capacity);
    }

    public MeetingDetails bookMeeting(Interval interval, List<User> guests) {
        
        for(MeetingRooms room : rooms) {
            if(room.capacity < guests.size()) continue;

            boolean intervalPresent = false;
            for(MeetingDetails md : room.calender.details) {
                if(md.interval == interval) {
                    intervalPresent = true;
                    break;
                } 
            }

            if(!intervalPresent) {
                MeetingDetails newMeeting = new MeetingDetails(interval, guests);
                room.calender.addMeetingToCalender(newMeeting);

                System.out.println("Meeting Booked Successfully");

                List<NoftifyObserver> observers = new ArrayList<>();
                observers.addAll(guests);
                observers.add(room);
                notifyObservers(observers, newMeeting);
                return newMeeting;
            }
        }

        System.out.println("Sorry, Meeting is not booked");
        return null;
    }

    public void notifyObservers(List<NoftifyObserver> observers, MeetingDetails meetingDetails) {
        for(NoftifyObserver ob : observers) {
            ob.notifyUsers(meetingDetails);
        }
    }
}

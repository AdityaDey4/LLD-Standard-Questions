package ConcertBookingSystem.Observer;

import ConcertBookingSystem.Models.*;

public class UserObserver implements Observer {
    private User user;
    public UserObserver(User user) { this.user = user; }

    @Override
    public void update(Concert concert) {
        user.getNotificationPreference().send(user, 
            "Hello "+user.getName()+" , new seats has been added for concert at " + concert.getVenue());
    }
}
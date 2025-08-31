package ConcertBookingSystem.Strategy;

import ConcertBookingSystem.Models.User;

public class SMSNotification implements Notification {
    public void send(User user, String message) {
        System.out.println("SMS to " + user.getPhone() + ": " + message);
    }
}

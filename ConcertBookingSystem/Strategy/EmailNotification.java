package ConcertBookingSystem.Strategy;

import ConcertBookingSystem.Models.User;

public class EmailNotification implements Notification {
    public void send(User user, String message) {
        System.out.println("Email to " + user.getEmail() + ": " + message);
    }
}

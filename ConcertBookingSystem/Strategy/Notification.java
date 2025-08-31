package ConcertBookingSystem.Strategy;

import ConcertBookingSystem.Models.User;

public interface Notification {
    void send(User user, String message);
}

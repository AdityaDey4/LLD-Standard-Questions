package ConcertBookingSystem.Observer;

import ConcertBookingSystem.Models.Concert;

public interface Observer {
    void update(Concert concert);
}
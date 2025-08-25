package AirlineSystem.Repository;

import java.util.HashMap;
import java.util.Map;

import AirlineSystem.Entities.Booking;
import AirlineSystem.Enum.BookingStatus;

public class BookingRepo {
    
    Map<String, Booking> bookings = new HashMap<>();

    public void save(Booking booking) {
        bookings.put(booking.getId(), booking);
    }

    public Booking findBookingById(String id) {
        if(!bookings.containsKey(id)) {
            return null;
        }
        return bookings.get(id);
    }

    public void cancelBooking(String id) {
        Booking booking = bookings.get(id);
        if(booking != null) booking.setBookingStatus(BookingStatus.CANCELLED);
    }
}

package AirlineSystem.Entities;

import AirlineSystem.Enum.BookingStatus;

public class Booking {
    
    private final String id;
    private final Flight flight;
    private final Seat seat;
    private final Passenger passenger;
    private BookingStatus bookingStatus;

    public Booking(String id, Flight flight, Seat seat, Passenger passenger) {
        this.id = id;
        this.flight = flight;
        this.seat = seat;
        this.passenger = passenger;
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public String getId() {
        return id;
    }

    public Flight getFlight() {
        return flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}

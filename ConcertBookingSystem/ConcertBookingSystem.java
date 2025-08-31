package ConcertBookingSystem;

import ConcertBookingSystem.Enums.SeatType;
import ConcertBookingSystem.Models.*;
import ConcertBookingSystem.Services.*;
import ConcertBookingSystem.Payment.*;
import ConcertBookingSystem.Refund.*;
import java.util.*;

public class ConcertBookingSystem {
    private UserService userService = new UserService();
    private ConcertService concertService = new ConcertService();
    private SeatService seatService = new SeatService();
    private BookingService bookingService = new BookingService(userService, concertService, seatService);
    private SimpleRefundPolicy refundService = new SimpleRefundPolicy();



    public void addUser(User user) {
        userService.addUser(user);
    }

    public void addConcert(Concert concert, List<Seat> seats) {
        concertService.addConcert(concert, seats);
        seatService.registerSeats(seats);
    }

    public void addMoreSeatsForConcert(Concert concert, List<Seat> seats) {
        concertService.addMoreSeats(concert, seats);
        seatService.registerSeats(seats);
    }

    public synchronized Booking bookConcert(int userId, int concertId, SeatType seatType, String paymentType) {

        Booking booking = bookingService.createBooking(userId, concertId, seatType);

        PaymentMethod method = PaymentFactory.getPaymentMethod(paymentType);
        method.pay(booking.getSeat().getPrice());

        return booking;
    }

    public Booking cancelBooking(int bookingId) {

        Booking booking = bookingService.cancelBooking(bookingId, refundService);
        return booking;
    }
}

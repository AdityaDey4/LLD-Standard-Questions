package ConcertBookingSystem.Services;

import ConcertBookingSystem.Models.Booking;
import ConcertBookingSystem.Models.*;
import ConcertBookingSystem.Enums.BookingStatus;
import ConcertBookingSystem.Enums.SeatType;
import ConcertBookingSystem.Exceptions.InvalidIdException;

import java.time.LocalDateTime;
import java.util.*;

import ConcertBookingSystem.Refund.SimpleRefundPolicy;

public class BookingService {
    private Map<Integer, Booking> bookings = new HashMap<>();
    private int bookingCounter = 1;

    private UserService userService;
    private ConcertService concertService;
    private SeatService seatService;

    public BookingService(UserService userService, ConcertService concertService, SeatService seatService) {
        this.userService = userService;
        this.concertService = concertService;
        this.seatService = seatService;
    }

    public synchronized Booking createBooking(int userId, int concertId, SeatType seatType) {
        User user = userService.getUser(userId);
        Concert concert = concertService.getConcert(concertId);
        Seat seat = concertService.getAvailableSeat(concert, user, seatType);

        Booking booking = new Booking(bookingCounter++, seat, concert, user);
        bookings.put(booking.getId(), booking);
        seatService.markBooked(seat.getId());

        user.getNotificationPreference().send(user, "Hi "+user.getName()+", Booking Confirmed, Venue : "+concert.getVenue());
        return booking;
    }

    public Booking cancelBooking(int bookingId, SimpleRefundPolicy refundPolicy)  {
        if (!bookings.containsKey(bookingId)) throw new InvalidIdException("Invalid Booking ID");

        Booking booking = bookings.get(bookingId);
        booking.setStatus(BookingStatus.CANCELLED);

        double refundAmount = refundPolicy.calculateRefund(booking.getSeat().getPrice(), booking.getConcert().getTime(), LocalDateTime.now());
        booking.setRefundAmount(refundAmount);

        seatService.markAvailable(booking.getSeat().getId());
        System.err.println(refundAmount+" has been refunded");

        User user = booking.getUser();
        user.getNotificationPreference().send(user, "Hi "+user.getName()+", Booking Cancelled, Venue : "+booking.getConcert().getVenue());
        return booking;
    }
}
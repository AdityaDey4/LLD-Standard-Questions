package AirlineSystem;

import java.time.LocalDate;
import java.util.UUID;

import AirlineSystem.Entities.Booking;
import AirlineSystem.Entities.Flight;
import AirlineSystem.Entities.Passenger;
import AirlineSystem.Entities.Seat;
import AirlineSystem.Enum.BookingStatus;
import AirlineSystem.Enum.PaymentType;
import AirlineSystem.Enum.SeatStatus;
import AirlineSystem.Enum.SeatType;
import AirlineSystem.Exceptions.InvalidFlightException;
import AirlineSystem.Exceptions.SeatNotAvailableException;
import AirlineSystem.Exceptions.UnauthorizedException;
import AirlineSystem.Repository.BookingRepo;
import AirlineSystem.Repository.FlightRepo;
import AirlineSystem.Repository.PassengerRepo;
import AirlineSystem.Repository.PaymentRepo;
import DigitalWalletService.Exceptions.InvalidIdException;

public class BookingManager {
    
    private final BookingRepo bookingRepo;
    private final FlightRepo flightRepo;
    private final PassengerRepo passengerRepo;
    private final PaymentRepo paymentRepo;
    private final RefundPolicy refundPolicy;

    public BookingManager(BookingRepo bookingRepo, FlightRepo flightRepo, PassengerRepo passengerRepo, PaymentRepo paymentRepo) {
        this.bookingRepo = bookingRepo;
        this.flightRepo = flightRepo;
        this.passengerRepo = passengerRepo;
        this.paymentRepo = paymentRepo;
        refundPolicy = new RefundPolicy();
    }

    public synchronized Booking createBooking(String passengerId, String flightId, SeatType seatType, PaymentType paymentType) {

        Flight flight = flightRepo.findFlightById(flightId);
        Passenger passenger = passengerRepo.findPassengerById(passengerId);
        
        if(flight == null || passenger == null) {
            throw new InvalidIdException("Invalid Id");
        }

        if(LocalDate.now().isAfter(flight.getDepartureTime())) {
            throw new InvalidFlightException("You can't book this flight now");
        }

        boolean checkSeatAvailablity = flightRepo.checkSeatAvailablity(flightId, seatType);
        if(!checkSeatAvailablity) {
            throw new SeatNotAvailableException("Seat Type : "+seatType+" is not available");
        }

        Seat bookedSeat = flightRepo.bookSeat(flightId, seatType);
        Booking booking = new Booking(UUID.randomUUID().toString(), flight, bookedSeat, passenger);

        paymentRepo.processPayment(bookedSeat.getPrice(), paymentType);
        bookingRepo.save(booking);

        return booking;
    }

    public synchronized void cancelBooking(String bookingId, String passengerId) {

        Booking booking = bookingRepo.findBookingById(bookingId);
        Passenger passenger = passengerRepo.findPassengerById(passengerId);

        if(booking == null || passenger == null) {
            throw new InvalidIdException("Invalid Id");
        }

        if(!booking.getPassenger().getId().equals(passengerId)) {
            throw new UnauthorizedException("You are not authorized to cancel this booking");
        }

        Seat cancelSeat = booking.getSeat();
        cancelSeat.setSeatStatus(SeatStatus.AVAILABLE);
        booking.setBookingStatus(BookingStatus.CANCELLED);

        double refundAmount = refundPolicy.refund(cancelSeat.getPrice(), booking.getFlight().getDepartureTime(), LocalDate.now());
        paymentRepo.refundMoney(refundAmount, passenger);
    }   
}

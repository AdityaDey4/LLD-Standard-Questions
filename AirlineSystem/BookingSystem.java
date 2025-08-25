package AirlineSystem;

import java.util.List;

import AirlineSystem.Entities.AirCraft;
import AirlineSystem.Entities.Booking;
import AirlineSystem.Entities.Flight;
import AirlineSystem.Entities.Passenger;
import AirlineSystem.Enum.PaymentType;
import AirlineSystem.Enum.SeatType;
import AirlineSystem.Repository.AirCraftRepo;
import AirlineSystem.Repository.BookingRepo;
import AirlineSystem.Repository.FlightRepo;
import AirlineSystem.Repository.PassengerRepo;
import AirlineSystem.Repository.PaymentRepo;
import AirlineSystem.Search.MultipleSearch;

public class BookingSystem {
    
    private static BookingSystem instance;
    private final AirCraftRepo airCraftRepo;
    private final BookingRepo bookingRepo;
    private final FlightRepo flightRepo;
    private final PassengerRepo passengerRepo;
    private final PaymentRepo paymentRepo;
    private final BookingManager bookingManager;

    private BookingSystem() {
        this.airCraftRepo = new AirCraftRepo();
        this.bookingRepo = new BookingRepo();
        this.flightRepo = new FlightRepo();
        this.passengerRepo = new PassengerRepo();
        this.paymentRepo = new PaymentRepo();
        this.bookingManager = new BookingManager(bookingRepo, flightRepo, passengerRepo, paymentRepo);
    }

    public static BookingSystem getInstance() {

        if(instance == null) {
            instance = new BookingSystem();
        }

        return instance;
    }

    public void addAirCraft(AirCraft airCraft) {
        airCraftRepo.save(airCraft);
    }

    public void registerPassenger(Passenger passenger) {
        passengerRepo.save(passenger);
    }

    public void createFlight(Flight flight) {
        flightRepo.save(flight);    
    }

    public synchronized Booking createBooking(String passengerId, String flightId, SeatType seatType, PaymentType paymentType) {
        return bookingManager.createBooking(passengerId, flightId, seatType, paymentType);
    }

    public synchronized void cancelBooking(String bookingId, String passengerId) {
        bookingManager.cancelBooking(bookingId, passengerId);
    }

    public void filter(MultipleSearch search) {
        List<Flight> filteredFlights =  SearchEngine.filter(flightRepo.getAllFlights(), search);
        for(Flight flight : filteredFlights) {
            flight.flightFormatter();
        }
    }
}

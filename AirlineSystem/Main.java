package AirlineSystem;

import java.time.LocalDate;
import java.util.Arrays;

import AirlineSystem.Entities.AirCraft;
import AirlineSystem.Entities.Booking;
import AirlineSystem.Entities.Flight;
import AirlineSystem.Entities.Passenger;
import AirlineSystem.Entities.Seat;
import AirlineSystem.Enum.PaymentType;
import AirlineSystem.Enum.SeatType;
import AirlineSystem.Search.DepartureTimeSearch;
import AirlineSystem.Search.MultipleSearch;
import AirlineSystem.Search.SourceSearch;

public class Main {

    public static void main(String[] args) {
        
        BookingSystem bookingSystem = BookingSystem.getInstance();

        AirCraft airCraft1 = new AirCraft("001", 1);
        bookingSystem.addAirCraft(airCraft1);

        Seat seat1 = new Seat(1, SeatType.PREMIUM, 45000);
        Flight flight1 = new Flight("001", "Kolkata", "Mumbai", LocalDate.of(2025, 8, 24), LocalDate.of(2025, 8, 26), airCraft1, Arrays.asList(seat1));
        bookingSystem.createFlight(flight1);


        Passenger passenger1 = new Passenger("001", "Aditya Dey", "abc@gmail.com");
        Passenger passenger2 = new Passenger("002", "Rudra Mondal", "xyz@gmail.com");
        bookingSystem.registerPassenger(passenger1);
        bookingSystem.registerPassenger(passenger2);

        try{
            bookingSystem.createBooking(passenger1.getId(), flight1.getId(), SeatType.BUSINESS, PaymentType.CASH);
        }catch(Exception exception) {
            System.err.println(exception.getMessage());
        }

        Booking booking1 =  bookingSystem.createBooking(passenger1.getId(), flight1.getId(), SeatType.PREMIUM, PaymentType.UPI);
        
        try{
            bookingSystem.cancelBooking(booking1.getId(), passenger2.getId());
        }catch(Exception exception) {
            System.err.println(exception.getMessage());
        }

        bookingSystem.cancelBooking(booking1.getId(), passenger1.getId());

        Booking booking2 =  bookingSystem.createBooking(passenger2.getId(), flight1.getId(), SeatType.PREMIUM, PaymentType.CASH);


        Flight flight2 = new Flight("001", "Kolkata", "Bangalore", LocalDate.of(2025, 8, 25), LocalDate.of(2025, 8, 26), airCraft1, Arrays.asList(seat1));
        bookingSystem.createFlight(flight2);


        bookingSystem.filter(new MultipleSearch(Arrays.asList(new SourceSearch("Kolkata"), new DepartureTimeSearch(LocalDate.of(2025, 8, 24)))));
    }
}
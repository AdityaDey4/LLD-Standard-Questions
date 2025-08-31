package ConcertBookingSystem;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import ConcertBookingSystem.Enums.SeatType;
import ConcertBookingSystem.Models.Booking;
import ConcertBookingSystem.Models.Concert;
import ConcertBookingSystem.Models.Seat;
import ConcertBookingSystem.Models.User;
import ConcertBookingSystem.Strategy.NotificationFactory;

public class Main {
    public static void main(String[] args) {
        ConcertBookingSystem system = new ConcertBookingSystem();

        User u1 = new User(1, "Aditya", "adi@email.com", "999999999", NotificationFactory.getNotification("SMS"));
        User u2 = new User(2, "Rudra", "rudra@email.com", "999999998", NotificationFactory.getNotification("Email"));
        User u3 = new User(3, "Rohit", "rohit@email.com", "999999997", NotificationFactory.getNotification("Email"));
        system.addUser(u1);
        system.addUser(u2);
        system.addUser(u3);

        Concert c1 = new Concert(1, "Salt Lake Stadium", LocalDateTime.now().plusDays(5));
        List<Seat> seats = Arrays.asList(
            new Seat(1, SeatType.REGULAR, c1, 500)
        );
        system.addConcert(c1, seats);


        try {
            Booking b1  = system.bookConcert(2, 1, SeatType.VIP, "upi");
        }catch(Exception ex){System.err.println(ex.getMessage());}

        Booking b2 = system.bookConcert(1, 1, SeatType.REGULAR, "upi"); // perfect booking

        try {
            Booking b3 = system.bookConcert(3, 1, SeatType.REGULAR, "card"); 
        }catch(Exception ex){System.err.println(ex.getMessage());}

        system.cancelBooking(b2.getId());
        system.addMoreSeatsForConcert(c1, Arrays.asList(
            new Seat(2, SeatType.VIP, c1, 1000)
        ));
    }
}
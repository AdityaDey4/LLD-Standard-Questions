package Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Booking.Booking;
import Database.BookingDB;
import Enum.SeatStatus;
import Enum.SeatType;
import Hall.CinemaHall;
import Hall.Seat;
import Movie.Movie;
import Movie.Show;

public class Admin extends Person {

    private BookingDB db;
    public Admin(String name, String address, int ph, BookingDB db) {
        super(name, address, ph);
        this.db = db;
    }

    public void addMovie(Movie movie) {
        db.addMovie(movie);
    }

    public void addCinemaHall(CinemaHall hall) {
        db.addHalls(hall);
    }

    public void addCinemaHallSeat(CinemaHall hall, int regular, int vip) {

        Map<SeatType, List<Seat>> map = new HashMap<>();
        map.put(SeatType.REGULAR, new ArrayList<>());
        map.put(SeatType.VIP, new ArrayList<>());


        for(int i=0; i<regular; i++) {
            map.get(SeatType.REGULAR).add(new Seat(i, SeatType.REGULAR, SeatStatus.ACTIVE));
        }
        for(int i=0; i<vip; i++) {
            map.get(SeatType.VIP).add(new Seat(i, SeatType.VIP, SeatStatus.ACTIVE));
        }
        hall.createSeats(map);
    }

    public void addShow(CinemaHall hall, Show show) {
        db.addShows(hall, show);
    }

    public void printBookingDetails() {
        List<Booking> bookings = db.getAllBookings();
        for(Booking b : bookings) {
            b.printBookingDetails();
        }
    }
}

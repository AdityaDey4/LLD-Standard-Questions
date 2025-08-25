package Database;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Account.User;
import Booking.Booking;
import Enum.BookingStatus;
import Enum.City;
import Enum.SeatStatus;
import Enum.SeatType;
import Hall.CinemaHall;
import Hall.Seat;
import Movie.Movie;
import Movie.Show;

public class BookingDB {
    
    private static BookingDB bookingDB;
    private List<Movie> movies = new ArrayList<>();
    private List<CinemaHall> halls = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    private BookingDB()  {}

    public static BookingDB getInstance() {
        if(bookingDB == null) {
            bookingDB = new BookingDB();
        }

        return bookingDB;
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public void addHalls(CinemaHall hall) {
        this.halls.add(hall);
    }

    public void addShows(CinemaHall hall, Show show) {
        for(CinemaHall h : halls) {
            if(h.getHallName().equalsIgnoreCase(hall.getHallName())) {
                h.addShow(show);
            }
        }
    }

    public List<Show> getAllShows(String hallName) {
        
        for(CinemaHall hall : halls) {
            if(hall.getHallName().equalsIgnoreCase(hallName)) return hall.getShows();
        }

        System.out.println(hallName+" does not exist.");
        return null;
    }

    public List<CinemaHall> getCinemaHalls(String movieTitle, City city) {
        List<CinemaHall> list = new ArrayList<>();
        for(CinemaHall cn : halls) {
            if(cn.city == city) {
                for(Movie s : cn.getMovies()) {
                    if(s.getName().equalsIgnoreCase(movieTitle)) {
                        list.add(cn);
                        break;
                    }
                }
            }
        }

        return list;
    }

    public Seat bookShowSeat(User user, SeatType type, Show show) {
        Map<SeatType, List<Seat>> map = show.getSeatMap();
        for(Seat seat : map.get(type)) {
            seat.setSeatStatus(SeatStatus.BOOKED);
            bookings.add(new Booking(user, show, seat, BookingStatus.CONFIRMED));
            System.out.println("Seat booked successfully, "+seat.seatDetails());

            return seat;
        }

        return null;
    }
   
    public void cancelShowSeat(User user, Seat seat, Show show) {
        Map<SeatType, List<Seat>> map = show.getSeatMap();
        for(Seat st : map.get(seat.getSeatType())) {

            if(st != seat) continue;
            seat.setSeatStatus(SeatStatus.ACTIVE);
            bookings.add(new Booking(user, show, seat, BookingStatus.CANCELLED));
            System.out.println("Seat cancelled successfully, "+seat.seatDetails());
            return;
        }
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}

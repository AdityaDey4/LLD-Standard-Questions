package Account;

import java.util.List;

import Database.BookingDB;
import Enum.City;
import Enum.SeatType;
import Hall.CinemaHall;
import Hall.Seat;
import Movie.Show;

public class User extends Person {

    private BookingDB db;
    public User(String name, String address, int ph, BookingDB db) {
        super(name, address, ph);
        this.db = db;
    }

    // this must return Seat as user booking it.
    public Seat bookShow(SeatType type, Show show) {
        show.printAllSeats();
       if(! show.isSeatAvailable(type)) return null;

       Seat bookedSeat = db.bookShowSeat(this, type, show);
       show.printAllSeats();

       return bookedSeat;
    }

    public void cancelShow(Seat seat, Show show) {
        db.cancelShowSeat(this, seat, show);
        show.printAllSeats();
    }

    public List<CinemaHall> getCinemaHalls(City city, String movieName) {
        List<CinemaHall> halls =  db.getCinemaHalls(movieName, city);

        for(CinemaHall hall : halls) {
            System.out.println(hall.getHallName()+", address : "+hall.getHallAddress());
            for(Show show : hall.getShows()) {
                if(show.getMovie().getName().equalsIgnoreCase(movieName)) {
                    System.out.println(show.getShowDetails());
                }
            }
        }

        return halls;
    }

    public List<Show> getShows(String hallName) {
        List<Show> shows = db.getAllShows(hallName);

        for(Show show : shows) {
            System.out.println(show.getShowDetails());
        }
        return shows;
    }
}

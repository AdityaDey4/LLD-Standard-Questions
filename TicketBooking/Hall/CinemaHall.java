package Hall;

import java.util.*;

import Enum.City;
import Enum.SeatType;
import Movie.Movie;
import Movie.Show;

public class CinemaHall {
    private String name;
    private String address;
    private Map<SeatType, List<Seat>> seats;
    private List<Show> shows;
    private Set<Movie> set;
    public City city;

    public CinemaHall(String name, String address, City city) {
        this.name = name;
        this.address = address;
        this.city = city;
        seats = new HashMap<>();
        shows = new ArrayList<>();
        set = new HashSet<>();
    }

    public void createSeats(Map<SeatType, List<Seat>> map) {
        this.seats = map;
    }

    public void addShow(Show show) {
        shows.add(show);
        set.add(show.getMovie());
        show.initializeHallSeats(this, this.seats);
    }

    public List<Show> getShows() {
        return this.shows;
    }

    public Set<Movie> getMovies() {
        return this.set;
    }

    public String getHallName() {
        return this.name;
    }
    
    public String getHallAddress() {
        return this.address;
    }
}

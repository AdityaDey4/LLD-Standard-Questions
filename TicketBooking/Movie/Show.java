package Movie;

import java.util.List;
import java.util.Map;

import Enum.SeatStatus;
import Enum.SeatType;
import Hall.CinemaHall;
import Hall.Seat;

public class Show {
    private Movie movie;
    private CinemaHall hall;
    private double price;
    private String startTime;
    private String endTime;
    private String date;
    private Map<SeatType, List<Seat>> map;

    public Show(Movie movie, double price, String date, String startTime, String endTime) {
        this.movie = movie;
        this.price = price;
        this.date = date;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public void initializeHallSeats(CinemaHall hall, Map<SeatType, List<Seat>> map) {
        this.map = map;
        this.hall = hall;
    }

    public boolean isSeatAvailable(SeatType type) {

        for(Seat seat : map.get(type)) {
            if(seat.getSeatType() == type && seat.getSeatStatus() == SeatStatus.ACTIVE) {
                return true;
            }
        }
        System.out.println("Seat Not available for type "+type);
        return false;
    }

    public  Map<SeatType, List<Seat>> getSeatMap() {
        return this.map;
    }

    public Movie getMovie() {
        return movie;
    }

    public void printAllSeats() {
    
        for(SeatType type : map.keySet()) {
            System.out.println("TYPE : "+type);

            for(Seat seat : map.get(type)) {
                System.out.println(seat.seatDetails());
            }
        }
    }

    public String getShowDetails() {
        return "Movie name : "+movie.getName()+ " Hall name : "+ this.hall.getHallName()+" Hall address : "+ this.hall.getHallAddress()+"price : "+this.price+" date : "+this.date+" Time : from "+this.startTime+" to "+this.endTime;
    }
}

package Booking;


import Account.User;
import Enum.BookingStatus;
import Hall.Seat;
import Movie.Show;

public class Booking {
    
    private User user;
    private Show show;
    private Seat seat;
    private BookingStatus status;

    public Booking(User user, Show show, Seat seat, BookingStatus status) {
        this.user = user;
        this.show = show;
        this.seat = seat;
        this.status = status;
    }

    public void changeStatus(BookingStatus status) {
        this.status = status;
    }

    public void printBookingDetails() {
        System.out.println("User : "+user.getName()+" , Booking Status : "+status+" Seat Number : "+seat.getSeatNumber()+" Seat Type"+seat.getSeatType()+" "+show.getShowDetails());
    }
}

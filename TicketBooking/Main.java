import Account.Admin;
import Account.User;
import Database.BookingDB;
import Enum.City;
import Enum.SeatType;
import Hall.CinemaHall;
import Hall.Seat;
import Movie.Movie;
import Movie.Show;

public class Main {
    public static void main(String[] args) {

        System.out.println();

        BookingDB db = BookingDB.getInstance();
        Admin admin = new Admin("Aditya", "Haroa", 629679872, db);
        User user = new User("Rudra", "Sodpur", 123456789, db);
        User user2 = new User("Adi", "Haroa", 123456789, db);

        Movie movie1 = new Movie("Dhol", "24 june 2025", "Hindi", "Comedy film");
        Movie movie2 = new Movie("K3G", "5 January 2005", "Hindi", "Family film");
        Movie movie3 = new Movie("Partner", "20 December 2010", "Hindi", "Comedy film, Romantic film");

        CinemaHall hall1 = new CinemaHall("Rabindra Hall", "Sodpur", City.KOLKATA);
        CinemaHall hall2 = new CinemaHall("City Hall", "Mangalore", City.BANGALORE);
        

        Show show1 = new Show(movie1, 200, "20 july 2025", "7 pm", "11 pm");
        Show show2 = new Show(movie2, 900, "15 july 2025", "7 pm", "11 pm");
        Show show3 = new Show(movie3, 1200, "13 july 2025", "7 pm", "11 pm");
        Show show4 = new Show(movie2, 900, "16 july 2025", "7 pm", "11 pm");

        admin.addMovie(movie1);
        admin.addMovie(movie2);
        admin.addMovie(movie3);

        admin.addCinemaHall(hall1);
        admin.addCinemaHall(hall2);

        admin.addCinemaHallSeat(hall1, 1, 0);
        admin.addCinemaHallSeat(hall2, 2, 1);

        admin.addShow(hall1, show1);
        admin.addShow(hall2, show2);
        admin.addShow(hall2, show3);
        admin.addShow(hall2, show4);

               
    //    user.getCinemaHalls(City.BANGALORE, "K3G");
    //    System.out.println();

    //    user.getShows(hall2.getHallName());
    //    System.out.println();

       Seat bookedSeat1 = user.bookShow(SeatType.VIP, show2); 
       System.out.println();
       
       user.cancelShow(bookedSeat1, show2);

       Seat bookedSeat2 = user.bookShow(SeatType.REGULAR, show2); 
       System.out.println();

       Seat bookedSeat3 = user2.bookShow(SeatType.REGULAR, show1); 
       System.out.println();

       admin.printBookingDetails();
       System.out.println();
    }
}

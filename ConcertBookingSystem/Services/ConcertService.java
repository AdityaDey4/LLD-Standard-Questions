package ConcertBookingSystem.Services;

import ConcertBookingSystem.Models.Concert;
import ConcertBookingSystem.Models.*;
import ConcertBookingSystem.Observer.UserObserver;
import ConcertBookingSystem.Enums.SeatStatus;
import ConcertBookingSystem.Enums.SeatType;
import ConcertBookingSystem.Exceptions.InvalidIdException;
import java.util.*;

import AirlineSystem.Exceptions.SeatNotAvailableException;

public class ConcertService {
    private Map<Integer, Concert> concerts = new HashMap<>();
    private Map<Integer, List<Seat>> seats = new HashMap<>();
    private Map<Integer, UserObserver> observers = new HashMap();

    public void addConcert(Concert concert, List<Seat> seatList) {
        concerts.put(concert.getId(), concert);
        seats.put(concert.getId(), new ArrayList<>(seatList));
    }

    public void addMoreSeats(Concert concert, List<Seat> seatList) {
  
        for(Seat seat : seatList) {
            seats.get(concert.getId()).add(seat);
        }
        notifyAllObservers(concert);
    }

    private void notifyAllObservers(Concert concert) {

        for(UserObserver observer : observers.values()) {
            observer.update(concert);
        }
        observers = new HashMap<>();
    }

    public Concert getConcert(int id) {
        if (!concerts.containsKey(id)) throw new InvalidIdException("Invalid Concert ID: " + id);
        return concerts.get(id);
    }

    public List<Seat> getSeatsForConcert(int concertId) {
        return seats.getOrDefault(concertId, new ArrayList<>());
    }

    public Seat getAvailableSeat(Concert concert, User user, SeatType seatType) {
        for(Seat seat : seats.get(concert.getId())) {
            if(seat.getType() == seatType && seat.getStatus() == SeatStatus.AVAILABLE) return seat;
        }

        observers.put(user.getId(), new UserObserver(user));
        throw new SeatNotAvailableException("Sorry, "+user.getName()+" ,Seat type : "+seatType+ " is sold out, we will let you know when new seats will be added.");
    }
}

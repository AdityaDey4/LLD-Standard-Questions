package ConcertBookingSystem.Services;

import ConcertBookingSystem.Models.Seat;
import ConcertBookingSystem.Enums.SeatStatus;
import ConcertBookingSystem.Exceptions.InvalidIdException;
import java.util.*;

public class SeatService {
    private Map<Integer, Seat> seatMap = new HashMap<>();

    public void registerSeats(List<Seat> seats) {
        for (Seat seat : seats) seatMap.put(seat.getId(), seat);
    }

    public Seat getSeat(int seatId) {
        if (!seatMap.containsKey(seatId)) throw new InvalidIdException("Invalid Seat ID: " + seatId);
        return seatMap.get(seatId);
    }

    public void markBooked(int seatId) {
        seatMap.get(seatId).setStatus(SeatStatus.BOOKED);
    }

    public void markAvailable(int seatId) {
        seatMap.get(seatId).setStatus(SeatStatus.AVAILABLE);
    }
}
package AirlineSystem.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import AirlineSystem.Entities.Flight;
import AirlineSystem.Entities.Seat;
import AirlineSystem.Enum.FlightStatus;
import AirlineSystem.Enum.SeatStatus;
import AirlineSystem.Enum.SeatType;
import AirlineSystem.Exceptions.SeatNotAvailableException;

public class FlightRepo {
    
    Map<String, Flight> flights = new HashMap<>();

    public void save(Flight flight) {
        flights.put(flight.getId(), flight);
    }

    public Flight findFlightById(String id) {
        if(!flights.containsKey(id)) {
            return null;
        }
        return flights.get(id);
    }

    public void cancelFlight(String id) {
        Flight flight = flights.get(id);
        if(flight != null) flight.setFlightStatus(FlightStatus.CANCELLED);
    }

    public List<Seat> getAvailableSeats(Flight flight) {
        
        List<Seat> availableSeats = new ArrayList();
        for (Seat seat : flight.getSeats().values()) {
            if (seat.getSeatStatus() == SeatStatus.AVAILABLE)
                availableSeats.add(seat);
        }

        return availableSeats;
    }

    public boolean checkSeatAvailablity(String id, SeatType seatType) {
        Flight flight = flights.get(id);
        if(flight == null) return false;

        List<Seat> availableSeat = getAvailableSeats(flight);
        for(Seat seat : availableSeat) {
            if(seat.getSeatType() == seatType) return true;
        }

        return false;
    }

    public synchronized Seat bookSeat(String id, SeatType seatType) {
        Flight flight = flights.get(id);

        List<Seat> availableSeat = getAvailableSeats(flight);
        for(Seat seat : availableSeat) {
            if(seat.getSeatType() == seatType) {
                seat.setSeatStatus(SeatStatus.RESERVED);
                return seat;
            }
        }

        throw new SeatNotAvailableException("Seat Type : "+seatType+" is not available");
    }

    public List<Flight> getAllFlights() {
        return flights.values().stream()
                .filter(flight -> !flight.getDepartureTime().isBefore(LocalDate.now())) // departure >= today
                .collect(Collectors.toList());
    }
}

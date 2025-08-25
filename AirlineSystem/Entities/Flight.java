package AirlineSystem.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import AirlineSystem.Enum.FlightStatus;

public class Flight {
    private final String id;
    private final String source;
    private String destination;
    private LocalDate arrivalTime;
    private LocalDate departureTime;
    private final AirCraft airCraft;
    private FlightStatus flightStatus;
    private Map<Integer, Seat> seats;

    public Flight(String id, String source, String destination, LocalDate departureTime, LocalDate arrivalTime,
             AirCraft airCraft, List<Seat> seats) {
        this.id = UUID.randomUUID().toString();
        this.source = source;
        this.destination = destination;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.airCraft = airCraft;
        this.flightStatus = FlightStatus.ON_TIME;
        seatInitialization(seats);
    }

    private void seatInitialization(List<Seat> seats2) {
        
        this.seats = new HashMap<>();
        for(Seat seat : seats2) {
            seats.put(seat.getSeatNumber(), seat);
        }
    }

    public String getId() {
        return this.id;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getArrivalTime() {
        return arrivalTime;
    }

    public LocalDate getDepartureTime() {
        return departureTime;
    }

    public AirCraft getAirCraft() {
        return airCraft;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public Map<Integer, Seat> getSeats() {
        return seats;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setArrivalTime(LocalDate arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(LocalDate departureTime) {
        this.departureTime = departureTime;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public void flightFormatter() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        StringBuilder sb = new StringBuilder();
        sb.append("Flight Details\n");
        sb.append("-----------------------------\n");
        sb.append("Source: ").append(this.getSource()).append("\n");
        sb.append("Destination: ").append(this.getDestination()).append("\n");
        sb.append("Departure: ").append(this.getDepartureTime().format(formatter)).append("\n");
        sb.append("Arrival: ").append(this.getArrivalTime().format(formatter)).append("\n");
        sb.append("Status: ").append(this.getFlightStatus()).append("\n");

        System.err.println(sb.toString());
    }
}

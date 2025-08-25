package AirlineSystem.Search;

import java.time.LocalDate;

import AirlineSystem.Entities.Flight;

public class DepartureTimeSearch implements Search{
    
    LocalDate departureDate;
    public DepartureTimeSearch(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
    @Override
    public boolean isSatisfyBy(Flight flight) {
        return flight.getDepartureTime().equals(departureDate);
    }
}

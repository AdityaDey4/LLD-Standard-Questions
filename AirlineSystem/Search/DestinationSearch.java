package AirlineSystem.Search;

import AirlineSystem.Entities.Flight;

public class DestinationSearch implements Search{
    
    String destination;
    public DestinationSearch(String destination) {
        this.destination = destination;
    }
    @Override
    public boolean isSatisfyBy(Flight flight) {
        return flight.getDestination().equals(destination);
    }
}

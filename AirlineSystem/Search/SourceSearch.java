package AirlineSystem.Search;

import AirlineSystem.Entities.Flight;

public class SourceSearch implements Search {

    String source;
    public SourceSearch(String source) {
        this.source = source;
    }
    @Override
    public boolean isSatisfyBy(Flight flight) {
        return flight.getSource().equals(source);
    }
    
}

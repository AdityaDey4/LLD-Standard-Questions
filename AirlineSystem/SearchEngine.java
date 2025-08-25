package AirlineSystem;

import java.util.ArrayList;
import java.util.List;

import AirlineSystem.Entities.Flight;
import AirlineSystem.Search.MultipleSearch;

public class SearchEngine {
    
    public static List<Flight> filter(List<Flight> flights, MultipleSearch search) {

        List<Flight> filteredFlights = new ArrayList<>();
        for(Flight flight : flights) {
            if(search.isSatisfyBy(flight)) filteredFlights.add(flight);
        }

        return filteredFlights;
    }
}

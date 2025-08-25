package AirlineSystem.Search;

import java.util.List;

import AirlineSystem.Entities.Flight;

public class MultipleSearch implements Search {
    List<Search> seachingMethods;
    public MultipleSearch(List<Search> searchs) {
        this.seachingMethods = searchs;
    }
    @Override
    public boolean isSatisfyBy(Flight flight) {
        
        for(Search search : seachingMethods) {
            
            if(!search.isSatisfyBy(flight)) return false;
        }

        return true;
    }
}

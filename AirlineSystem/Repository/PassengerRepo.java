package AirlineSystem.Repository;

import java.util.HashMap;
import java.util.Map;

import AirlineSystem.Entities.Passenger;

public class PassengerRepo {
    
    Map<String, Passenger> passengers = new HashMap<>();

    public void save(Passenger passenger) {
        passengers.put(passenger.getId(), passenger);
    }

    public Passenger findPassengerById(String id) {
        if(!passengers.containsKey(id)) {
            return null;
        }
        return passengers.get(id);
        
    }
}

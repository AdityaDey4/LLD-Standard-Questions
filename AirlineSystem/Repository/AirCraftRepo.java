package AirlineSystem.Repository;

import java.util.HashMap;
import java.util.Map;

import AirlineSystem.Entities.AirCraft;

public class AirCraftRepo {
    
    Map<String, AirCraft> airCrafts = new HashMap<>();

    public void save(AirCraft airCraft) {
        airCrafts.put(airCraft.getId(), airCraft);
    }

    public AirCraft getAirCraftById(String id) {
        if(!airCrafts.containsKey(id)) {
            return null;
        }
        return airCrafts.get(id);
    }
}

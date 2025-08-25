package ParkingLot;

import java.util.*;

import ParkingLot.Vehicle.Vehicle;

public class ParkingFloor {
    private final String floodId;
    private final List<Slot> slots;

    public ParkingFloor(String id) {
        this.floodId = id;
        this.slots = new ArrayList<>();
    }

    public String getFloorId() {
        return this.floodId;
    }
    
    public void addSlot(Slot slot) {
        this.slots.add(slot);
    }

    public List<Slot> getSlots() {
        return this.slots;
    }

    public Map<String, Integer> getAvailability() {
        Map<String, Integer> map = new HashMap<>();
        for(Slot slot : slots) {
            if(!slot.isOccupied()) {
                map.put(slot.getType(), map.getOrDefault(slot.getType(), 0) +1);
            }
        }

        return map;
    }

    public Slot getAvailableSlot(Vehicle vehicle) {
        for(Slot slot : slots) {
            if(!slot.isOccupied()) return slot;
        }

        return null;
    }
}

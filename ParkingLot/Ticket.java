package ParkingLot;

import ParkingLot.Vehicle.Vehicle;

public class Ticket {
    
    private final String ticketId;
    private final Vehicle vehicle;
    private final Slot slot;

    public Ticket(String id, Vehicle vehicle, Slot slot) {
        this.ticketId = id;
        this.vehicle = vehicle;
        this.slot = slot;
    }

    public Slot getSlot() { return slot; }
    public Vehicle getVehicle() { return vehicle; }
    public String getId() { return ticketId; }
}

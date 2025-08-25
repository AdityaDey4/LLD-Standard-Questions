package ParkingLot.Gates;

import ParkingLot.ParkingLot;
import ParkingLot.Ticket;
import ParkingLot.Vehicle.Vehicle;

public class EntryGate {

    private final String entryGateId;

    public EntryGate(String id) {
        this.entryGateId = id;
    }
    
    public Ticket generateTicket(Vehicle vehicle) {
        System.out.println(vehicle.getType()+" numbered "+vehicle.getVehileNumber()+" entered from gate (ID): "+entryGateId);
        return ParkingLot.getInstance().parkVehicle(vehicle);
    }
}

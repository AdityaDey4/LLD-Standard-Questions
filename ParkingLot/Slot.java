package ParkingLot;

import ParkingLot.Vehicle.Vehicle;

public class Slot {
    private final String slotId;
    private final String type;
    private boolean isOccupied;
    private Vehicle vehicle;

    public Slot(String slotId, String type) {
        this.slotId = slotId;
        this.type = type;
        this.isOccupied = false;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
        System.out.println(vehicle.getType()+" Parked Successfully");
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public boolean canFit(Vehicle vehicle) {
        return this.type.equalsIgnoreCase(vehicle.getType()) && !this.isOccupied;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }

    public String getType() {
        return this.type;
    }
}

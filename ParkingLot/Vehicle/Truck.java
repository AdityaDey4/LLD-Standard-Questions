package ParkingLot.Vehicle;

public class Truck implements Vehicle {

    String vehicleNumber;

    public Truck(String number) {
        this.vehicleNumber = number;
    }

    @Override
    public String getType() {
        return "Truck";
    }

    @Override
    public String getVehileNumber() {
        return this.vehicleNumber;
    }
    
}

package ParkingLot.Vehicle;

public class Bike implements Vehicle {

    String vehicleNumber;

    public Bike(String number) {
        this.vehicleNumber = number;
    }

    @Override
    public String getType() {
        return "Bike";
    }

    @Override
    public String getVehileNumber() {
        return this.vehicleNumber;
    }
    
}

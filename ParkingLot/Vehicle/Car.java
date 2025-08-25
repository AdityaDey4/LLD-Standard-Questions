package ParkingLot.Vehicle;

public class Car implements Vehicle{

    String vehicleNumber;

    public Car(String number) {
        this.vehicleNumber = number;
    }

    @Override
    public String getType() {
        return "Car";
    }

    @Override
    public String getVehileNumber() {
        return this.vehicleNumber;
    }
    
}

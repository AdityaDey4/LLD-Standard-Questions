package ParkingLot.Utils;

public class CostCalculate {
    
    public static double calculateAmount(String type) {
        switch (type.toLowerCase()) {
            case "bike": return 20.00;
            case "truck": return 50.00;
            case "car": return 35.00;
            default: throw new IllegalArgumentException("Invalid Vehicle Type");

        }
    }
}

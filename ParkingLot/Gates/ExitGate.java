package ParkingLot.Gates;

import ParkingLot.ParkingLot;
import ParkingLot.Ticket;

public class ExitGate {
    
    private static String gateId;

    public ExitGate(String id) {
        this.gateId = id;
    }

    public void processExit(Ticket ticket, String paymentType) {
        System.out.println("Vehicle exiting from Gate ID: " + gateId);
        ParkingLot.getInstance().exitVehicle(ticket, "upi");
    }
}

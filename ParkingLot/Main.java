package ParkingLot;

import ParkingLot.Gates.EntryGate;
import ParkingLot.Gates.ExitGate;
import ParkingLot.Observer.DisplayBoard;
import ParkingLot.Vehicle.Car;
import ParkingLot.Vehicle.Vehicle;

public class Main {
    public static void main(String args[]) {
        ParkingLot lot = ParkingLot.getInstance();
        lot.addObserver(DisplayBoard.getInstance());

        ParkingFloor floor1 = new ParkingFloor("Floor1");
        floor1.addSlot(new Slot("F1C1", "Car"));
        floor1.addSlot(new Slot("F1C2", "Car"));
        floor1.addSlot(new Slot("F1B1", "Bike"));
        lot.addFloor(floor1);

        // Entry
        EntryGate entryGate = new EntryGate("En1");
        Vehicle car = new Car("KA01AB1234");
        Ticket ticket = entryGate.generateTicket(car);

        // Exit
        ExitGate exitGate = new ExitGate("Ex1");
        if (ticket != null) exitGate.processExit(ticket, "upi");
    }
}

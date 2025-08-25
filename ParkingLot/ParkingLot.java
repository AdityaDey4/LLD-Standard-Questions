package ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ParkingLot.Observer.DisplayObserver;
import ParkingLot.Payment.Payment;
import ParkingLot.Payment.PaymentFactory;
import ParkingLot.Utils.CostCalculate;
import ParkingLot.Vehicle.Vehicle;

public class ParkingLot {
    
    private static ParkingLot instance;
    private final List<ParkingFloor> floors = new ArrayList<>();
    private final List<DisplayObserver> observers = new ArrayList<>();

    private ParkingLot() {}

    public static ParkingLot getInstance() {
        if(instance == null) {
            instance = new ParkingLot();
        }

        return instance;
    }

    public void addObserver(DisplayObserver ob) {
        this.observers.add(ob);
    }

    public void notifyObserver() {
        for(DisplayObserver ob : observers) {
            ob.update();
        }
    }

    public void addFloor(ParkingFloor floor) {
        this.floors.add(floor);
        notifyObserver();
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for(ParkingFloor floor : floors) {
            Slot availableSlot = floor.getAvailableSlot(vehicle);
            if(availableSlot != null) {
                availableSlot.parkVehicle(vehicle);
                notifyObserver();
                return new Ticket(UUID.randomUUID().toString(), vehicle, availableSlot);
            }
        }

        System.out.println("No parking space available for this "+vehicle.getType());
        return null;
    }

    public void exitVehicle(Ticket ticket, String paymentType) {

        Payment paymentMethod = PaymentFactory.getPaymentMethod(paymentType);
        double amount = CostCalculate.calculateAmount(ticket.getVehicle().getType());

        paymentMethod.pay(amount);
        ticket.getSlot().removeVehicle();
        notifyObserver();
        
    }

    public void displayAvailability() {
        System.out.println("--- Parking Availability ---");
        for (ParkingFloor floor : floors) {
            System.out.println("Floor: " + floor.getFloorId());
            System.out.println(floor.getAvailability());
        }
    }
}

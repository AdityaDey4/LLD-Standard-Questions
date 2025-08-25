package ParkingLot.Payment;

public class CashPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println(amount+" paid using Cash.");
    }
    
}

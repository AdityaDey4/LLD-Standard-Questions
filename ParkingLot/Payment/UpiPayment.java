package ParkingLot.Payment;

public class UpiPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println(amount+" paid using UPI");
    }
    
}

package ParkingLot.Payment;

public class CardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println(amount+" paid using Card");
    }
    
}

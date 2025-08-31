package ConcertBookingSystem.Payment;

public class UpiPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI.");
    }
}
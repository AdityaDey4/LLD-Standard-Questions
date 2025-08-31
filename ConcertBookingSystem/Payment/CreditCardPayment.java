package ConcertBookingSystem.Payment;

public class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Credit Card.");
    }
}

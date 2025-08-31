package ConcertBookingSystem.Payment;

public class PaymentFactory {
    public static PaymentMethod getPaymentMethod(String type) {
        if (type.equalsIgnoreCase("upi")) return new UpiPayment();
        if (type.equalsIgnoreCase("card")) return new CreditCardPayment();
        throw new IllegalArgumentException("Invalid Payment Type");
    }
}
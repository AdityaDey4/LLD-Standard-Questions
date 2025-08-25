package ParkingLot.Payment;

public class PaymentFactory {
    public static Payment getPaymentMethod(String type) {

       switch (type.toLowerCase()) {
            case "upi": return new UpiPayment();
            case "cash": return new CashPayment();
            case "card": return new CardPayment();
            default: throw new IllegalArgumentException("Invalid Payment Type");

        }
    }
}   

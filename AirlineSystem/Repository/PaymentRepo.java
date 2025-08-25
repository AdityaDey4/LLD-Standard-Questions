package AirlineSystem.Repository;

import AirlineSystem.Entities.Passenger;
import AirlineSystem.Enum.PaymentType;
import AirlineSystem.Payment.Payment;
import AirlineSystem.Payment.PaymentFactory;

public class PaymentRepo {
    
    public void processPayment(double amount, PaymentType paymentType) {
        Payment payment = PaymentFactory.getPaymentMethod(paymentType);
        payment.pay(amount);
    }

    public void refundMoney(double amount, Passenger passenger) {
        System.err.println(amount+" rupees has been refunded to "+passenger.getName());
    }
}

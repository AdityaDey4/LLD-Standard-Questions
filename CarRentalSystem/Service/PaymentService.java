package CarRentalSystem.Service;

import CarRentalSystem.Customer;
import CarRentalSystem.Enum.PaymentType;
import CarRentalSystem.Payment.Payment;
import CarRentalSystem.Payment.PaymentFactory;

public class PaymentService {
    public void collect(PaymentType type, long amount) {
        Payment p = PaymentFactory.getPaymentMethod(type);
        p.pay(amount);
    }
    public void refund(PaymentType type, long amount, Customer customer) {
        Payment p = PaymentFactory.getPaymentMethod(type);
        p.refund(amount, customer);
    }
}
package ResturantSystem.Service;

import ResturantSystem.Bill.Bill;
import ResturantSystem.Enum.PaymentType;
import ResturantSystem.Payment.Payment;
import ResturantSystem.Payment.PaymentFactory;

public class PaymentService {
    public void pay(Bill bill, PaymentType paymentType) {
        Payment payment = PaymentFactory.getPaymentMethod(paymentType);
        payment.pay(bill.getBillComponent().calculateTotal());
    }
}

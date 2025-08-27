package ResturantSystem.State;

import ResturantSystem.Bill.Bill;
import ResturantSystem.Enum.PaymentType;
import ResturantSystem.Exception.InvalidStateMethod;
import ResturantSystem.Model.Order;
import ResturantSystem.Payment.Payment;
import ResturantSystem.Payment.PaymentFactory;

public class PaymentState implements State {
    
    private final Order order;
    public PaymentState(Order order) {
        this.order = order;
    }
    @Override
    public void prepareAndServe() {
        throw new InvalidStateMethod("You can't perform this method while processing payment");
    }
    @Override
    public Bill generateBill() {
        throw new InvalidStateMethod("Bill has already been generated, no way to update it.");
    }
    @Override
    public void processPayment(Bill bill, PaymentType paymentType) {
        Payment payment = PaymentFactory.getPaymentMethod(paymentType);
        payment.pay(bill.getBillComponent().calculateTotal());
        order.setState(null);
    }
}

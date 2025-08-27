package ResturantSystem.State;

import ResturantSystem.Bill.Bill;
import ResturantSystem.Enum.PaymentType;

public interface State {

    public void prepareAndServe();
    public Bill generateBill();
    public void processPayment(Bill bill, PaymentType paymentType);
}

package ResturantSystem.State;

import ResturantSystem.Bill.BaseBill;
import ResturantSystem.Bill.Bill;
import ResturantSystem.Bill.BillComponent;
import ResturantSystem.Enum.PaymentType;
import ResturantSystem.Exception.InvalidStateMethod;
import ResturantSystem.Model.Order;

public class BillGenerationState implements State{
    
    private final Order order;
    public BillGenerationState(Order order) {
        this.order = order;
    }
    @Override
    public void prepareAndServe() {
        throw new InvalidStateMethod("You can't perform handle operation while generating Bill");
    }
    @Override
    public Bill generateBill() {
        
        BillComponent billComponent = new BaseBill(order);
        Bill billWithDetails = new Bill(billComponent);
        
        order.setState(new PaymentState(order));
        return billWithDetails;
    }
    @Override
    public void processPayment(Bill bill, PaymentType paymentType) {
        throw new InvalidStateMethod("Let the bill to generate first");
    }
}

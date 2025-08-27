package ResturantSystem.State;

import ResturantSystem.Bill.Bill;
import ResturantSystem.Enum.PaymentType;
import ResturantSystem.Exception.InvalidStateMethod;
import ResturantSystem.Model.MenuItem;
import ResturantSystem.Model.Order;

public class PreparationState implements State {

    private final Order order;
    public PreparationState(Order order) {
        this.order = order;
    }
    @Override
    public void prepareAndServe() {
        System.err.println("You order is preparaing.........");
        System.err.println("Here is your Order : ");
        StringBuilder sb = new StringBuilder();
        
        for(MenuItem menuItem : order.getItems()) {
            sb.append(menuItem.getName()+", ");
        }

        System.err.println(sb.toString());

        order.setState(new BillGenerationState(order));
    }
    @Override
    public Bill generateBill() {
        throw new InvalidStateMethod("You can't generate bill during order preparation");
    }
    @Override
    public void processPayment(Bill bill, PaymentType paymentType) {
        throw new InvalidStateMethod("You can't process payment during order preparation");
    }
    
}

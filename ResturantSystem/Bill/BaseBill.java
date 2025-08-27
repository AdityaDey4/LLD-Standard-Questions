package ResturantSystem.Bill;

import java.util.List;

import ResturantSystem.Model.MenuItem;
import ResturantSystem.Model.Order;

public class BaseBill implements BillComponent {

    private final Order order;
    public BaseBill(Order order) {
         this.order = order; 
    }

    @Override
    public double calculateTotal() { 
        return order.getTotalCost(); 
    }

    @Override
    public String getDescription() {
        
        StringBuilder sb = new StringBuilder();
        List<MenuItem> items = order.getItems();

        for(MenuItem item : items) {
            sb.append("Name : "+item.getName()+" Price : "+item.getPrice()+"\n");
        }

        return sb.toString(); 
    }
    
}

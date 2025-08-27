package ResturantSystem;

import java.util.Arrays;

import ResturantSystem.Enum.PaymentType;
import ResturantSystem.Model.Customer;
import ResturantSystem.Model.MenuItem;
import ResturantSystem.Model.Order;
import ResturantSystem.Model.Table;

public class Main {
    public static void main(String args[]) {
        
        ResturantSystem resturantSystem = ResturantSystem.getInstance();

        MenuItem item1 = resturantSystem.addMenuItem("Chicken Kabab", 350.00);
        MenuItem item2 = resturantSystem.addMenuItem("Mixed Rice", 100.00);

        Table table = resturantSystem.addTable("001", 4);

        Customer c1 = new Customer("001", "Aditya Dey", 658);
        Order order1 = resturantSystem.makeOrder(c1, Arrays.asList(item1, item2), table);

        Customer c2 = new Customer("001", "Aditya Dey", 658);

        try {
            Order order2 = resturantSystem.makeOrder(c2, Arrays.asList(item2), table);
            resturantSystem.processOrder(order2, PaymentType.CARD);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }

        resturantSystem.processOrder(order1, PaymentType.CASH);

        Order order2 = resturantSystem.makeOrder(c2, Arrays.asList(item2), table);
        resturantSystem.processOrder(order2, PaymentType.CARD);
    }
}

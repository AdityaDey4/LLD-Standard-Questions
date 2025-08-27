package ResturantSystem;

import java.util.*;
import java.util.UUID;

import ResturantSystem.Bill.Bill;
import ResturantSystem.Enum.PaymentType;
import ResturantSystem.Model.Customer;
import ResturantSystem.Model.MenuItem;
import ResturantSystem.Model.Order;
import ResturantSystem.Model.Table;
import ResturantSystem.Service.BillingService;
import ResturantSystem.Service.MenuService;
import ResturantSystem.Service.OrderService;
import ResturantSystem.Service.PaymentService;
import ResturantSystem.Service.TableService;

public class ResturantSystem {

    private static ResturantSystem instance;

    // Services encapsulate their own in-memory stores
    private final MenuService menuService;
    private final TableService tableService;
    private final OrderService orderService;
    private final BillingService billingService;
    private final PaymentService paymentService;

    private ResturantSystem() {
        this.menuService = new MenuService();
        this.tableService = new TableService();
        this.orderService = new OrderService();
        this.billingService = new BillingService( 100.0); // 18% tax, ₹100 service charge
        this.paymentService = new PaymentService();
    }

    public static synchronized ResturantSystem getInstance() {
        if (instance == null) instance = new ResturantSystem();
        return instance;
    }

    public MenuItem addMenuItem(String name, double price) {
        return menuService.addMenuItem(UUID.randomUUID().toString(), name, price);
    }
    public void removeMenuItem(String name) { menuService.removeMenuItemByName(name); }
    public List<MenuItem> getMenu() { return menuService.listMenu(); }

    public Table addTable(String tableId, int capacity) { return tableService.addTable(tableId, capacity); }
    public boolean reserveTable(String tableId) { return tableService.reserve(tableId); }
    public void releaseTable(String tableId) { tableService.release(tableId); }

    public Order makeOrder(Customer customer, List<MenuItem> items, Table table) {
        return orderService.createOrder(UUID.randomUUID().toString(), customer, items, table);
    }

    public void processOrder(Order order, PaymentType paymentType) {
        
        order.getState().prepareAndServe();
        Bill bill = order.getState().generateBill();

        billingService.decorate(bill);
        bill.printBill();

        order.getState().processPayment(bill, paymentType);

        orderService.completeAndFreeTable(order);
    }
}

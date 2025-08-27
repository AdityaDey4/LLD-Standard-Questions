package ResturantSystem.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import ResturantSystem.Enum.TableStatus;
import ResturantSystem.Exception.TableNotAvailabeException;
import ResturantSystem.Model.Customer;
import ResturantSystem.Model.MenuItem;
import ResturantSystem.Model.Order;
import ResturantSystem.Model.Table;

public class OrderService {
    private final Map<String, Order> orders = new ConcurrentHashMap<>();

    public Order createOrder(String id, Customer customer, List<MenuItem> items, Table table) {
        if (table.getTableStatus() == TableStatus.RESERVED) {
            throw new TableNotAvailabeException("Table is not available");
        }
        Order order = new Order(id, customer, items, table);
        orders.put(order.getId(), order);
        table.setTableStatus(TableStatus.RESERVED);
        return order;
    }

    public Order get(String orderId) { return orders.get(orderId); }

    public void completeAndFreeTable(Order order) {
        if (order != null && order.getState() == null) {
            order.getTable().setTableStatus(TableStatus.AVAILABLE);
        }
    }

    public List<Order> allOrders() { return new ArrayList<>(orders.values()); }
}

package ResturantSystem.Model;

import java.util.List;

import ResturantSystem.State.PreparationState;
import ResturantSystem.State.State;

public class Order {
    
    private final String id;
    private final Customer customer;
    private final List<MenuItem> items;
    private final Table table;
    private double totalCost;

    State state;

    public Order(String id, Customer customer, List<MenuItem> items, Table table) {
        this.customer = customer;
        this.items = items;
        this.table = table;
        this.id = id;
        this.state = new PreparationState(this);
        calculateTotal();
    }

    public String getId() {
        return this.id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public Table getTable() {
        return table;
    }

    public double getTotalCost() {
        return totalCost;
    }

    private void calculateTotal() {
        this.totalCost = items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }
}

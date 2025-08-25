package Others;
import java.util.Scanner;
import java.util.*;
// ------------------------------
// Product.java
// ------------------------------
class Product {
    int id;
    String name;
    int price;
    int quantity;

    public Product(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public void reduceQuantity() {
        if (quantity > 0) quantity--;
    }
}

// ------------------------------
// Inventory.java (Simplified)
// ------------------------------

class Inventory {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProduct(int id) {
        for (Product p : products) {
            if (p.id == id) return p;
        }
        return null;
    }

    public void displayProducts() {
        for (Product p : products) {
            System.out.println(p.id + ": " + p.name + " - Rs." + p.price + " (Qty: " + p.quantity + ")");
        }
    }
}

// ------------------------------
// State.java (Interface)
// ------------------------------
interface State {
    void insertMoney(int amount);
    void selectProduct(int productId);
    void dispense();
    void refund();
}

// ------------------------------
// IdleState.java
// ------------------------------
class IdleState implements State {
    VendingMachine vm;

    public IdleState(VendingMachine vm) {
        this.vm = vm;
    }

    public void insertMoney(int amount) {
        vm.setBalance(amount);
        vm.setState(vm.getMoneyInsertedState());
        System.out.println("Money inserted: Rs." + amount);
    }

    public void selectProduct(int productId) {
        System.out.println("Insert money first.");
    }

    public void dispense() {
        System.out.println("Insert money and select product first.");
    }

    public void refund() {
        System.out.println("No money to refund.");
    }
}

// ------------------------------
// MoneyInsertedState.java
// ------------------------------
class MoneyInsertedState implements State {
    VendingMachine vm;

    public MoneyInsertedState(VendingMachine vm) {
        this.vm = vm;
    }

    public void insertMoney(int amount) {
        vm.addBalance(amount);
        System.out.println("Additional Rs." + amount + " inserted. Total: Rs." + vm.getBalance());
    }

    public void selectProduct(int productId) {
        Product p = vm.getInventory().getProduct(productId);
        if (p == null || !p.isAvailable()) {
            System.out.println("Product not available.");
            return;
        }
        if (vm.getBalance() < p.price) {
            System.out.println("Insufficient funds. Product price: Rs." + p.price);
            return;
        }
        vm.setSelectedProduct(p);
        vm.setState(vm.getProductSelectedState());
        System.out.println("Product selected: " + p.name);
    }

    public void dispense() {
        System.out.println("Select a product first.");
    }

    public void refund() {
        System.out.println("Refunding Rs." + vm.getBalance());
        vm.setBalance(0);
        vm.setState(vm.getIdleState());
    }
}

// ------------------------------
// ProductSelectedState.java
// ------------------------------
class ProductSelectedState implements State {
    VendingMachine vm;

    public ProductSelectedState(VendingMachine vm) {
        this.vm = vm;
    }

    public void insertMoney(int amount) {
        System.out.println("Money already inserted.");
    }

    public void selectProduct(int productId) {
        System.out.println("Product already selected.");
    }

    public void dispense() {
        Product p = vm.getSelectedProduct();
        p.reduceQuantity();
        int change = vm.getBalance() - p.price;
        System.out.println("Dispensing: " + p.name);
        if (change > 0) System.out.println("Returning change: Rs." + change);
        vm.setBalance(0);
        vm.setSelectedProduct(null);
        vm.setState(vm.getIdleState());
    }

    public void refund() {
        System.out.println("Refunding Rs." + vm.getBalance());
        vm.setBalance(0);
        vm.setSelectedProduct(null);
        vm.setState(vm.getIdleState());
    }
}

// ------------------------------
// VendingMachine.java
// ------------------------------
class VendingMachine {
    private State idleState;
    private State moneyInsertedState;
    private State productSelectedState;
    private State currentState;

    private Inventory inventory;
    private Product selectedProduct;
    private int balance;

    public VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        moneyInsertedState = new MoneyInsertedState(this);
        productSelectedState = new ProductSelectedState(this);
        currentState = idleState;
    }

    public void insertMoney(int amount) { currentState.insertMoney(amount); }
    public void selectProduct(int id) { currentState.selectProduct(id); }
    public void dispense() { currentState.dispense(); }
    public void refund() { currentState.refund(); }

    public void setState(State s) {
        this.currentState = s;
        System.out.println("[State Changed] → " + s.getClass().getSimpleName());
    }

    public void setBalance(int b) { balance = b; }
    public void addBalance(int a) { balance += a; }
    public int getBalance() { return balance; }
    public void setSelectedProduct(Product p) { selectedProduct = p; }
    public Product getSelectedProduct() { return selectedProduct; }
    public Inventory getInventory() { return inventory; }
    public State getIdleState() { return idleState; }
    public State getMoneyInsertedState() { return moneyInsertedState; }
    public State getProductSelectedState() { return productSelectedState; }
}

// ------------------------------
// Main.java
// ------------------------------

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.getInventory().addProduct(new Product(101, "Coke", 25, 5));
        vm.getInventory().addProduct(new Product(102, "Pepsi", 35, 3));
        vm.getInventory().addProduct(new Product(103, "Soda", 20, 4));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Vending Machine ---");
            vm.getInventory().displayProducts();
            System.out.println("1. Insert Money\n2. Select Product\n3. Dispense\n4. Refund\n5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    vm.insertMoney(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    vm.selectProduct(sc.nextInt());
                    break;
                case 3:
                    vm.dispense();
                    break;
                case 4:
                    vm.refund();
                    break;
                case 5:
                    System.out.println("Exiting... Bye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

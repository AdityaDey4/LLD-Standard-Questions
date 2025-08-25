package CarRentalSystem.Payment;

import CarRentalSystem.Customer;

public interface Payment {
    void pay(double amount);
    default void refund(double amount, Customer customer) {
        System.out.println(amount + " rupees has been refunded.");
    }
}

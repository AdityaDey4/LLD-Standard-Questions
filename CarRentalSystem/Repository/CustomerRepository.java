package CarRentalSystem.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import CarRentalSystem.Customer;

public class CustomerRepository {
    private final Map<String, Customer> customers = new HashMap<>();

    public void save(Customer c) { customers.put(c.getId(), c); }
    public Optional<Customer> findById(String id) { return Optional.ofNullable(customers.get(id)); }
}

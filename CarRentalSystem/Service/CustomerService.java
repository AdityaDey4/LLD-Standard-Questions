package CarRentalSystem.Service;

import java.util.Optional;

import CarRentalSystem.Customer;
import CarRentalSystem.Repository.CustomerRepository;

public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public void addCustomer(Customer customer){repo.save(customer); }
    public Optional<Customer> findById(String id) { return repo.findById(id); }
}

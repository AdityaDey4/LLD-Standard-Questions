package CarRentalSystem;

import CarRentalSystem.Enum.Model;
import CarRentalSystem.Enum.PaymentType;
import CarRentalSystem.Refund.RefundPolicy;
import CarRentalSystem.Refund.SimpleRefundPolicy;
import CarRentalSystem.Repository.CarRepository;
import CarRentalSystem.Repository.CustomerRepository;
import CarRentalSystem.Repository.ReservationRepository;
import CarRentalSystem.Service.CarService;
import CarRentalSystem.Service.CustomerService;
import CarRentalSystem.Service.PaymentService;
import CarRentalSystem.Service.ReservationService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Setup repositories
        CarRepository carRepo = new CarRepository();
        CustomerRepository customerRepo = new CustomerRepository();
        ReservationRepository reservationRepo = new ReservationRepository();

        // Setup services
        CarService carService = new CarService(carRepo);
        CustomerService customerService = new CustomerService(customerRepo);
        PaymentService paymentService = new PaymentService();
        RefundPolicy refundPolicy = new SimpleRefundPolicy();
        ReservationService reservationService = new ReservationService(carService, customerService, paymentService, reservationRepo, refundPolicy);

        // Facade
        BrookerFacade brookerFacade = new BrookerFacade(carService, reservationService, customerService);

        // Seed data
        Car car1 = new Car("car-1", Model.SEDAN, "WB12AB3456", 2023, 1200);
        Car car2 = new Car("car-2", Model.SEDAN, "WB09CD4321", 2024, 5000);
        brookerFacade.addCar(car1);
        brookerFacade.addCar(car2);

        Customer c1 = new Customer("cust-1", "Aditya Dey", 6296798726L, "DL-XYZ-123");
        Customer c2 = new Customer("cust-2", "Rudra Mondal", 6296798725L, "DL-XYZ-456");
        brookerFacade.addCustomer(c1);
        brookerFacade.addCustomer(c2);

        Reservation r1 = null;
        try {
            r1 = brookerFacade.reserve("car-1", "cust-1",
                LocalDate.of(2025, 8, 3), LocalDate.of(2025, 8, 10), PaymentType.UPI);

            // overlapped
            brookerFacade.reserve("car-1", "cust-2",
                    LocalDate.of(2025, 8, 5), LocalDate.of(2025, 8, 7), PaymentType.CASH);
        } catch (Exception ex) {
            System.err.println("[Expected] " + ex.getMessage());
        }

        Reservation r2 = null;
        try{
            // Non-overlapped
            r2 = brookerFacade.reserve("car-1", "cust-2",
            LocalDate.of(2025, 8, 12), LocalDate.of(2025, 8, 14), PaymentType.CASH);
        }catch(Exception ex) {
            System.err.println("[Nothing] " + ex.getMessage());
        }
        
        try {

            // Cancel with refund (assume cancel on 2025-08-01 => >= 48h before start)
            if(r2 != null) brookerFacade.cancel(r2.getId(), LocalDate.of(2025, 8, 1));
            
            // Cancel late (0% refund)
            if(r1 != null) brookerFacade.cancel(r1.getId(), LocalDate.of(2025, 8, 5));
        } catch(Exception ex) {
             System.err.println("[Nothing] " + ex.getMessage());
        }

        // List reservations by customer
        brookerFacade.reservationsByCustomer("cust-1").forEach(System.out::println);
        brookerFacade.reservationsByCustomer("cust-2").forEach(System.out::println);
    }
}

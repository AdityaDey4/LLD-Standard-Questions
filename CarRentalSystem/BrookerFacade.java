package CarRentalSystem;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import CarRentalSystem.Enum.PaymentType;
import CarRentalSystem.Service.CarService;
import CarRentalSystem.Service.CustomerService;
import CarRentalSystem.Service.ReservationService;


// The Facade Pattern provides a unified, simplified interface to a complex subsystem of classes, libraries, or frameworks.
// It hides the complexity of the subsystem.
// The client interacts only with the facade, not the internals.

public class BrookerFacade {
    private final CarService carService;
    private final ReservationService reservationService;
    private final CustomerService customerService;

    public BrookerFacade(CarService carService,
                        ReservationService reservationService,
                        CustomerService customerService) {
        this.carService = carService;
        this.reservationService = reservationService;
        this.customerService = customerService;
    }


    public void addCar(Car car) { carService.addCar(car); }
    public List<Car> listCars() { return carService.listAll(); }
    public Optional<Car> getCar(String carId) { return carService.findById(carId); }

    public void addCustomer(Customer c) { customerService.addCustomer(c); }

    public Reservation reserve(String carId, String customerId, LocalDate start, LocalDate end, PaymentType pt) throws Exception {
        return reservationService.createReservation(carId, customerId, start, end, pt);
    }

    public Reservation cancel(String reservationId, LocalDate cancelDate) throws Exception {
        return reservationService.cancelReservation(reservationId, cancelDate);
    }

    public List<Reservation> reservationsByCustomer(String customerId) {
        return reservationService.getReservationsByCustomer(customerId);
    }
}

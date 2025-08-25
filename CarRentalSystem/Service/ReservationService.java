package CarRentalSystem.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

import CarRentalSystem.Car;
import CarRentalSystem.Customer;
import CarRentalSystem.Reservation;
import CarRentalSystem.Enum.PaymentType;
import CarRentalSystem.Refund.RefundPolicy;
import CarRentalSystem.Repository.ReservationRepository;

public class ReservationService {
    private final CarService carService;
    private final CustomerService customerService;
    private final PaymentService paymentService;
    private final ReservationRepository reservationRepo;
    private final RefundPolicy refundPolicy;

    public ReservationService(CarService carService,
                              CustomerService customerService,
                              PaymentService paymentService,
                              ReservationRepository reservationRepo,
                              RefundPolicy refundPolicy) {
        this.carService = carService;
        this.customerService = customerService;
        this.paymentService = paymentService;
        this.reservationRepo = reservationRepo;
        this.refundPolicy = refundPolicy;
    }

    public synchronized Reservation createReservation(String carId,
                                                      String customerId,
                                                      LocalDate start, LocalDate end,
                                                      PaymentType paymentType) throws Exception {

        Car car = carService.findById(carId).orElseThrow(() -> new Exception("Car not found: " + carId));
        Customer customer = customerService.findById(customerId).orElseThrow(() -> new Exception("Customer not found: " + customerId));

        // Availability by overlap check
        List<Reservation> overlaps = reservationRepo.findActiveOverlapping(carId, start, end);
        if (!overlaps.isEmpty()) {
            throw new Exception("Car " + car + " is not available for " + start + " to " + end);
        }

        long days = ChronoUnit.DAYS.between(start, end) + 1;
        long totalCost = days * car.getDailyRent();

        // Collect payment
        paymentService.collect(paymentType, totalCost);

        Reservation r = new Reservation(UUID.randomUUID().toString(), carId, customerId, start, end, totalCost, paymentType);
        reservationRepo.save(r);
        System.out.println("[Reservation Created] " + r);
        return r;
    }

    public synchronized Reservation cancelReservation(String reservationId, LocalDate cancelDate) throws Exception {
        Reservation r = reservationRepo.findById(reservationId)
                .orElseThrow(() -> new Exception("Reservation not found: " + reservationId));

        long refund = refundPolicy.calculateRefund(r.getTotalCost(), cancelDate, r.getStartDate(), r.getEndDate());
        if (refund > 0) {
            Customer customer = customerService.findById(r.getCustomerId()).orElseThrow(() -> new Exception("Customer not found: " + r.getCustomerId()));
            paymentService.refund(r.getPaymentType(), refund, customer);
        }
        r.cancel(refund);
        reservationRepo.update(r);
        System.out.println("[Reservation Canceled] " + r);
        return r;
    }
    
    public List<Reservation> getReservationsByCustomer(String customerId) {
        return reservationRepo.findByCustomerId(customerId);
    }
}

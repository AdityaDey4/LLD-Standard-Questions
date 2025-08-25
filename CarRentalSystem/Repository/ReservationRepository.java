package CarRentalSystem.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import CarRentalSystem.Reservation;
import CarRentalSystem.Enum.Status;

public class ReservationRepository {
    private final Map<String, Reservation> reservations = new HashMap<>();

    public void save(Reservation r) { reservations.put(r.getId(), r); }
    public void update(Reservation reservation) { reservations.put(reservation.getId(), reservation); }
    public Optional<Reservation> findById(String id) { return Optional.ofNullable(reservations.get(id)); }

    public List<Reservation> findActiveOverlapping(String carId, LocalDate start, LocalDate end) {
        return reservations.values().stream()
            .filter(r -> r.getCarId().equals(carId) && r.getStatus() == Status.CONFIRMED)
            .filter(r -> !(r.getEndDate().isBefore(start) || r.getStartDate().isAfter(end)))
            .collect(Collectors.toList());
    }

    public List<Reservation> findByCustomerId(String customerId) {
        return reservations.values().stream()
                .filter(r -> r.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }
}

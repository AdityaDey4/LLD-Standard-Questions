package ConcertBookingSystem.Refund;

import java.time.LocalDateTime;

public interface RefundPolicy {
    double calculateRefund(double totalPaid, LocalDateTime now, LocalDateTime start);
}

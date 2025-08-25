package CarRentalSystem.Refund;

import java.time.LocalDate;

public interface RefundPolicy {
    long calculateRefund(long totalPaid, LocalDate now, LocalDate start, LocalDate end);
}

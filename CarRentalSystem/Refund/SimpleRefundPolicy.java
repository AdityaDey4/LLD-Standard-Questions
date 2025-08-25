package CarRentalSystem.Refund;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Simple policy:
 * - Cancel >= 48 hours before start: 100% refund
 * - Cancel < 48 hours before start but before start date: 50% refund
 * - Cancel on/after start date: 0% refund
 */
public class SimpleRefundPolicy implements RefundPolicy {
    @Override
    public long calculateRefund(long totalPaid, LocalDate now, LocalDate start, LocalDate end) {
        long hoursUntilStart = ChronoUnit.HOURS.between(now.atStartOfDay(), start.atStartOfDay());
        if (hoursUntilStart >= 48) return totalPaid;
        if (now.isBefore(start)) return Math.round(totalPaid * 0.5);
        return 0L;
    }
}

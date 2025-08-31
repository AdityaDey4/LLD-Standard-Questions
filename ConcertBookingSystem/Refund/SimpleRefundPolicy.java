package ConcertBookingSystem.Refund;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Simple policy:
 * - Cancel >= 48 hours before start: 100% refund
 * - Cancel < 48 hours before start but before start date: 50% refund
 * - Cancel on/after start date: 0% refund
 */
public class SimpleRefundPolicy implements RefundPolicy {
    @Override
    public double calculateRefund(double price, LocalDateTime start, LocalDateTime now) {
        long hoursUntilStart = ChronoUnit.HOURS.between(now, start);
        if (hoursUntilStart >= 48) return price;
        if (now.isBefore(start)) return Math.round(price * 0.5);
        return 0L;
    }
}

package AirlineSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RefundPolicy {
    
    // More that 48 hours -> 75%
    // Less than 48 hours but not depurture day -> 25%
    // else 0%
    public double refund(double amount, LocalDate departure, LocalDate cancellation) {
        long hoursUntilStart = ChronoUnit.HOURS.between(cancellation.atStartOfDay(), departure.atStartOfDay());
        if (hoursUntilStart > 48) return Math.round(amount*0.75);
        if (cancellation.isBefore(departure)) return Math.round(amount * 0.25);
        return 0.00;
    }
}

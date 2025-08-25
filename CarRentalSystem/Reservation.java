package CarRentalSystem;

import java.time.LocalDate;

import CarRentalSystem.Enum.PaymentType;
import CarRentalSystem.Enum.Status;

public class Reservation {

    String id;
    String carId;
    String customerId;
    LocalDate startDate;
    LocalDate endDate;
    long totalCost;
    PaymentType paymentType;

    Status status;
    long refundedAmount;

    public Reservation(String id, String carId, String customerId,
                       LocalDate startDate, LocalDate endDate,
                       long totalCost, PaymentType paymentType) {
        this.id = id;
        this.carId = carId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.paymentType = paymentType;
        this.status = Status.CONFIRMED;
        this.refundedAmount = 0L;
    }

    public String getId() {return this.id;}
    public String getCarId() {return this.carId;}
    public String getCustomerId() {return this.customerId;}
    public Status getStatus() {return this.status;}
    public LocalDate getStartDate() {return this.startDate;}
    public LocalDate getEndDate() {return this.endDate;}
    public long getTotalCost() { return totalCost; }
    public PaymentType getPaymentType() { return paymentType; }

    public void cancel(long refundMoney) {
        this.status = Status.CANCELED;
        this.refundedAmount = refundMoney;
    }

    @Override
    public String toString() {
        return "Reservation{id=" + id +
                ", carId=" + carId +
                ", customerId=" + customerId +
                ", start=" + startDate +
                ", end=" + endDate +
                ", total=" + totalCost +
                ", status=" + status +
                ", refunded=" + refundedAmount + "}";
    }
}

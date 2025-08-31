package ConcertBookingSystem.Models;

import java.time.LocalDateTime;

import ConcertBookingSystem.Enums.BookingStatus;

public class Booking {
    private int id;
    private Seat seat;
    private Concert concert;
    private User user;
    private LocalDateTime time;
    private BookingStatus status;
    private LocalDateTime cancelTime;
    private double refundAmount;

    public Booking(int id, Seat seat, Concert concert, User user) {
        this.id = id;
        this.seat = seat;
        this.concert = concert;
        this.user = user;
        this.time = LocalDateTime.now();
        this.status = BookingStatus.CONFIRMED;
    }

    public int getId() { return id; }
    public Seat getSeat() { return seat; }
    public Concert getConcert() { return concert; }
    public User getUser() { return user; }
    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }
    public void setCancelTime(LocalDateTime cancelTime) { this.cancelTime = cancelTime; }
    public void setRefundAmount(double refundAmount) { this.refundAmount = refundAmount; }
}

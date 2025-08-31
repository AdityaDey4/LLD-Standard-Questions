package ConcertBookingSystem.Models;

import ConcertBookingSystem.Enums.SeatStatus;
import ConcertBookingSystem.Enums.SeatType;

public class Seat {
    private int id;
    private SeatStatus status;
    private SeatType type;
    private Concert concert;
    private double price;

    public Seat(int id, SeatType type, Concert concert, double price) {
        this.id = id;
        this.type = type;
        this.status = SeatStatus.AVAILABLE;
        this.concert = concert;
        this.price = price;
    }

    public int getId() { return id; }
    public SeatStatus getStatus() { return status; }
    public void setStatus(SeatStatus status) { this.status = status; }
    public SeatType getType() { return type; }
    public Concert getConcert() { return concert; }
    public double getPrice() { return price; }
}

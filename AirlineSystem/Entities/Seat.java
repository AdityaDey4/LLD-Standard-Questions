package AirlineSystem.Entities;

import AirlineSystem.Enum.SeatStatus;
import AirlineSystem.Enum.SeatType;

public class Seat {
    private final int seatNumber;
    private final SeatType seatType;
    private final double price;
    private SeatStatus seatStatus;

    public Seat(int seatNumber, SeatType seatType, double price) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.price = price;
        this.seatStatus = SeatStatus.AVAILABLE;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public double getPrice() {
        return price;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }
}

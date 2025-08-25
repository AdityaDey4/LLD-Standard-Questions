package Hall;

import Enum.SeatStatus;
import Enum.SeatType;

public class Seat {
    
    private int number;
    private SeatType type;
    private SeatStatus status;

    public Seat(int number , SeatType type, SeatStatus status) {
        this.number = number;
        this.status = status;
        this.type = type;
    }

    public SeatStatus getSeatStatus() {
        return status;
    }

    public void setSeatStatus(SeatStatus status) {
        this.status = status;
    }

    public SeatType getSeatType() {
        return type;
    }

    public int getSeatNumber() {
        return number;
    }
    
    public String seatDetails() {
        return "Seat Number : "+this.number+", Seat Type : "+this.type+", Seat Status : "+this.status;
    }
}

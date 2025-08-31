package ConcertBookingSystem.Models;

import java.time.LocalDateTime;

public class Concert {
    private int id;
    private String venue;
    private LocalDateTime time;
    private boolean isSoldOut;

    public Concert(int id, String venue, LocalDateTime time) {
        this.id = id;
        this.venue = venue;
        this.time = time;
        this.isSoldOut = false;
    }

    public int getId() { return id; }
    public String getVenue() { return venue; }
    public LocalDateTime getTime() { return time; }
    public boolean isSoldOut() { return isSoldOut; }
    public void setSoldOut(boolean soldOut) { isSoldOut = soldOut; }
}

package AirlineSystem.Entities;

public class AirCraft {
    private final String id;
    private final int totalSeats;

    public AirCraft(String id, int totalSeats) {
        this.id = id;
        this.totalSeats = totalSeats;
    }

    public String getId() {
        return id;
    }

    public int getTotalSeats() {
        return totalSeats;
    }
}

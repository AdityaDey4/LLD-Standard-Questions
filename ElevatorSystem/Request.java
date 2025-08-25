package ElevatorSystem;

public class Request {
    private Direction direction;
    private int floor;

    Request(Direction d, int f) {
        this.direction = d;
        this.floor = f;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public int getFloor() {
        return this.floor;
    }
}

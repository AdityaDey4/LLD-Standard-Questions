package ElevatorSystem.Builder;

import ElevatorSystem.Direction;
import ElevatorSystem.ElevatorCar;
import ElevatorSystem.Strategy.MovingStrategy;

public class ElevatorCarBuilder {
    private String id;
    private int currentFloor = 0;
    private Direction direction = Direction.UP;
    private MovingStrategy strategy;

    public ElevatorCarBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ElevatorCarBuilder setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
        return this;
    }

    public ElevatorCarBuilder setDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public ElevatorCarBuilder setStrategy(MovingStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public ElevatorCar build() {
        if (id == null || strategy == null) {
            throw new IllegalStateException("ElevatorCar must have a non-null id and strategy.");
        }

        return new ElevatorCar(id, currentFloor, direction, strategy);
    }
}

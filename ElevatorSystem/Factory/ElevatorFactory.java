package ElevatorSystem.Factory;

import ElevatorSystem.Direction;
import ElevatorSystem.ElevatorCar;
import ElevatorSystem.Builder.ElevatorCarBuilder;
import ElevatorSystem.Strategy.LOOKStrategy;
import ElevatorSystem.Strategy.MovingStrategy;
import ElevatorSystem.Strategy.SCANStrategy;

public class ElevatorFactory {
    
    public static ElevatorCar createElevator(String id, int currentFloor, Direction direction, String algorithm) {

        MovingStrategy strategy;

        switch (algorithm.toLowerCase()) {
            case "look":
                strategy = new LOOKStrategy();
                break;
            case "scan":
                strategy = new SCANStrategy();
                break;
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        }

        return new ElevatorCarBuilder()
                .setId(id)
                .setCurrentFloor(currentFloor)
                .setDirection(direction)
                .setStrategy(strategy)
                .build();
    }
}

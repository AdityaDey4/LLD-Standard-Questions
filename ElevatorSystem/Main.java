package ElevatorSystem;

import ElevatorSystem.Factory.ElevatorFactory;

public class Main {
    
    public static void main(String[] args) {

        ElevatorHandler elevatorHandler = ElevatorHandler.getInstance();

        elevatorHandler.addElevatorCar(ElevatorFactory.createElevator("EC1", 0, Direction.UP, "look"));
        elevatorHandler.addElevatorCar(ElevatorFactory.createElevator("EC2", 5, Direction.UP,  "scan"));
        elevatorHandler.addElevatorCar(ElevatorFactory.createElevator("EC3", 10, Direction.DOWN,  "scan"));

        elevatorHandler.setMaintenance(0, true);

        Request rq1 = new Request(Direction.UP, 7);
        Request rq2 = new Request(Direction.UP, 5);
        Request rq3 = new Request(Direction.DOWN, 9);

        elevatorHandler.addRequest(rq1);
        elevatorHandler.addRequest(rq2);
        elevatorHandler.addRequest(rq3);


        elevatorHandler.executeRequest();
    }
}

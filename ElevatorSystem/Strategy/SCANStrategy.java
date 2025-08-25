package ElevatorSystem.Strategy;

import ElevatorSystem.Direction;
import ElevatorSystem.ElevatorCar;

public class SCANStrategy implements MovingStrategy {

    @Override
    public void move(ElevatorCar elevatorCar) {
        if(elevatorCar.getMaintenance()) return;
        elevatorCar.displayPanel();

        if(elevatorCar.getDirection() == Direction.UP) {
            elevatorCar.getUpRequests().remove(elevatorCar.getCurrentFloor());
            Integer up = elevatorCar.getUpRequests().ceiling(elevatorCar.getCurrentFloor()+1);
            if(up == null) {
                if(elevatorCar.getCurrentFloor() == 10 )elevatorCar.setDirection(Direction.DOWN);
                else elevatorCar.changeFloor(10);
            }else {
                elevatorCar.changeFloor(up);
            }
        }else {
            elevatorCar.getDownRequests().remove(elevatorCar.getCurrentFloor());
            Integer down = elevatorCar.getDownRequests().floor(elevatorCar.getCurrentFloor()-1);
            if(down == null) {
                if(elevatorCar.getCurrentFloor() == 0) elevatorCar.setDirection(Direction.UP);
                else elevatorCar.changeFloor(0);
            }else {
                elevatorCar.changeFloor(down);
            }
        }
    }
    
}

package ElevatorSystem.Strategy;

import ElevatorSystem.Direction;
import ElevatorSystem.ElevatorCar;

public class LOOKStrategy implements MovingStrategy {

    @Override
    public void move(ElevatorCar elevatorCar) {
        if(elevatorCar.getMaintenance()) return;
        elevatorCar.displayPanel();

        if(elevatorCar.getDirection() == Direction.UP) {
            elevatorCar.getUpRequests().remove(elevatorCar.getCurrentFloor());
            Integer up = elevatorCar.getUpRequests().ceiling(elevatorCar.getCurrentFloor()+1);
            if(up == null) {
                elevatorCar.setDirection(Direction.DOWN);
            }else {
                elevatorCar.changeFloor(up);
            }
        }else {
            elevatorCar.getDownRequests().remove(elevatorCar.getCurrentFloor());
            Integer down = elevatorCar.getDownRequests().floor(elevatorCar.getCurrentFloor()-1);
            if(down == null) {
                elevatorCar.setDirection(Direction.UP);
            }else {
                elevatorCar.changeFloor(down);
            }
        }
    }
    
}

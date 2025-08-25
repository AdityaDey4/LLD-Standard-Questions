package ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorHandler {

    private List<ElevatorCar> elevatorCars = new ArrayList<>();
    private static ElevatorHandler elevatorHandler;

    private ElevatorHandler() {
    };

    public static ElevatorHandler getInstance() {
        if (elevatorHandler == null) {
            elevatorHandler = new ElevatorHandler();
        }

        return elevatorHandler;
    }

    public void setMaintenance(int index, boolean maintenance) {
        if(index >= elevatorCars.size()) return;
        elevatorCars.get(index).setMaintenance(maintenance);
    }

    public void addElevatorCar(ElevatorCar ev) {
        this.elevatorCars.add(ev);
    }

    public void addRequest(Request request) {

        ElevatorCar bestCar = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorCar ev : elevatorCars) {
            if (ev.canAssignExternalRequest(request)) {
                int distance = Math.abs(ev.getCurrentFloor() - request.getFloor());
                if (distance < minDistance) {
                    bestCar = ev;
                    minDistance = distance;
                }
            }
        }

        if (bestCar != null) {
            bestCar.addExternalRequest(request);
        } else {

            for(ElevatorCar ev : elevatorCars) {
                if(ev.getMaintenance() == false) {
                    ev.addExternalRequest(request);
                    return;
                }
            }
        }
    }

    public void executeRequest() {
        // for(ElevatorCar ev : elevatorCars) {
        //     ev.printALl();
        // }

        while (hasRequests()) {
            for (ElevatorCar ev : elevatorCars) {
                if (!ev.hasHandledAllRequests())
                    ev.move();
                else

                    if(ev.getMaintenance()) System.out.println("Maintance Going On : " + ev.getId());
                    else System.out.println("IDLE : " + ev.getId());
            }

            System.out.println();
        }
    }

    public boolean hasRequests() {
        for (ElevatorCar ev : elevatorCars) {
            if (!ev.hasHandledAllRequests())
                return true;
        }

        return false;
    }
}

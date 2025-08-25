package ParkingLot.Observer;

import ParkingLot.ParkingLot;

public class DisplayBoard implements DisplayObserver {

    private static DisplayBoard instance;

    private DisplayBoard(){}

    public static DisplayBoard getInstance() {
        if(instance == null) {
            instance = new DisplayBoard();
        }

        return instance;
    }

    @Override
    public void update() {
        ParkingLot.getInstance().displayAvailability();
    }
    
}

package TrafficSignal;

import TrafficSignal.Enum.Direction;

public class Main {
    public static void main(String args[]) {
        
        SignalLight nLight = new SignalLight(Direction.SOUTH, Direction.NORTH);
        SignalLight eLight = new SignalLight(Direction.WEST, Direction.EAST);
    

        Intersection intersection = new Intersection();
        intersection.addDirectionPair(Direction.SOUTH, Direction.NORTH, nLight);
        intersection.addDirectionPair(Direction.WEST, Direction.EAST, eLight);

        SignalController controller = new SignalController(intersection);
        controller.startControlLoop();

        try {
            Thread.sleep(4500);
            controller.emergencyOccured(Direction.NORTH);
        }catch(Exception e) {}

    }
}
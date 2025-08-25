package TrafficSignal;

import java.util.ArrayList;
import java.util.List;

import TrafficSignal.Enum.Color;
import TrafficSignal.Enum.Direction;
import TrafficSignal.State.RedState;
import TrafficSignal.State.SignalState;

public class SignalController {

    Intersection intersection;
    private final List<SignalLight> signalSequence;
    int currentIndex = 0;
    private boolean running = false;
    Direction emergencyDirection;

    SignalController(Intersection intersection) {
        this.intersection = intersection;
        this.signalSequence = new ArrayList<>(intersection.getUniqueSignalLights());
    }

    public void startControlLoop() {
        this.running = true;
        Thread runningThread = new Thread(() -> {
            while (running) {

                if (Thread.currentThread().isInterrupted()) {
                    this.running = false;
                    System.out.println("Signal Thread has been interrupted");
                    break;
                }

                SignalLight currentLight;

                // Emergency: use signal light for emergencyDirection
                if (emergencyDirection != null) {
                    currentLight = intersection.getSignalLight(emergencyDirection);
                    currentIndex = signalSequence.indexOf(currentLight); // update index
                    emergencyDirection = null;
                } else {
                    currentLight = signalSequence.get(currentIndex);
                }

                SignalState currState = currentLight.getCurrentState();
                // for reinitializing the state as the state become null for below loop
                if(currState == null) {
                    currState = currentLight.setCurrentState(new RedState(Color.RED));
                }

                while(currState != null) {
                    currentLight.changing();
                    currState = currentLight.getCurrentState();

                    if(currState != null) {
                        if(!threadSleep(currState.duration)) {
                            running = false;
                            break;
                        }
                    }
                }

                currentIndex = (currentIndex + 1) % signalSequence.size();
            }
        });

        runningThread.start();

        // new Thread(() -> {
        //     try {
        //         Thread.sleep(17000);
        //         runningThread.interrupt();
        //         System.out.println("Session End");
        //     } catch (Exception e) {
        //         System.out.println("Exception Occurred in mini thread");
        //     }
        // }).start();
        
    }

    public void emergencyOccured(Direction direction) {
        System.out.println("Emergency at : "+direction);
        emergencyDirection = direction;
    }

    public boolean threadSleep(int millis) {
        try {
            Thread.currentThread().sleep(millis);
            return true;
        } catch (Exception e) {
            System.out.println("Thread interrupted during sleep.");
            return false;
        }
    }

    public void endControlLoop() {
        this.running = false;
    }
}

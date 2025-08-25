package TrafficSignal.State;

import TrafficSignal.SignalLight;
import TrafficSignal.Enum.Color;

public class YellowState extends SignalState {

    public YellowState(Color color) {
        super(color, 1000);
    }
    
    @Override
    public void handle(SignalLight signalLight) {
        System.out.println("Direction : "+signalLight.getDirection()+" Light : "+light);
    }

    @Override
    public SignalState nextState(SignalLight signalLight) {
        // return new RedState(Color.RED);
        return null;
    }
    
}

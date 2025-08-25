package TrafficSignal.State;

import TrafficSignal.SignalLight;
import TrafficSignal.Enum.Color;

public class RedState extends SignalState {

    public RedState(Color color) {
        super(color, 5000);
    }

    @Override
    public void handle(SignalLight signalLight) {
        System.out.println("Direction : "+signalLight.getDirection()+" Light : "+light);
    }

    @Override
    public SignalState nextState(SignalLight signalLight) {
        return new GreenState(Color.GREEN);
        
    }
}

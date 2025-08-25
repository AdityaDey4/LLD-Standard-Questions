package TrafficSignal.State;

import TrafficSignal.SignalLight;
import TrafficSignal.Enum.Color;

public class GreenState extends SignalState{

    public GreenState(Color color) {
        super(color, 4000);
    }

    @Override
    public void handle(SignalLight signalLight) {
        System.out.println("Direction : "+signalLight.getDirection()+" Light : "+light);
    }

    @Override
    public SignalState nextState(SignalLight signalLight) {
        return new YellowState(Color.YELLOW);
    }
}

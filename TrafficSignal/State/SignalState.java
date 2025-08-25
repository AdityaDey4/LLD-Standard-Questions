package TrafficSignal.State;

import TrafficSignal.SignalLight;
import TrafficSignal.Enum.Color;

public abstract class SignalState {
    public Color light;
    public int duration;
    SignalState(Color lString, int duration) {
        this.light = lString;
        this.duration = duration;
    }
    public abstract void handle(SignalLight signalLight);
    public abstract SignalState nextState(SignalLight signalLight);
}

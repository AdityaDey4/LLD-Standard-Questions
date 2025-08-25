package TrafficSignal;

import java.util.Arrays;
import java.util.List;

import TrafficSignal.Enum.Color;
import TrafficSignal.Enum.Direction;
import TrafficSignal.State.RedState;
import TrafficSignal.State.SignalState;

public class SignalLight {
    
    private SignalState state;
    private Direction direction1;
    private Direction direction2;
    int redLightDuration;

    SignalLight(Direction direction1, Direction direction2) {
        this.state = new RedState(Color.RED);
        redLightDuration = this.state.duration;
        this.direction1 = direction1;
        this.direction2 = direction2;
    }

    public void changing() {
        state.handle(this);
        SignalState nextState = state.nextState(this);
        Color nextLight = nextState == null ? Color.RED : nextState.light;
        int nextLightDuration = nextState == null ? redLightDuration : nextState.duration;
        System.out.println("Signal Changing in Directions : "+direction1+" & "+direction2+" from : "+state.light+" to "+nextLight+" for "+nextLightDuration/1000+" seconds");
        this.state = nextState;
    }

    public SignalState getCurrentState() {
        return this.state;
    }

    public SignalState setCurrentState(SignalState state) {
        this.state = state;
        return state;
    }

    public List<Direction> getDirection() {
        return Arrays.asList(direction1, direction2);
    }
}

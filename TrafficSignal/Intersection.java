package TrafficSignal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import TrafficSignal.Enum.Direction;

public class Intersection {
    private final Map<Direction, SignalLight> directionToSignal = new HashMap<>();
    private final Set<SignalLight> uniqueSignalLights = new HashSet<>();

    public void addDirectionPair(Direction d1, Direction d2, SignalLight signalLight) {
        directionToSignal.put(d1, signalLight);
        directionToSignal.put(d2, signalLight);
        uniqueSignalLights.add(signalLight);
    }

    public SignalLight getSignalLight(Direction direction) {
        return directionToSignal.get(direction);
    }

    public Set<SignalLight> getUniqueSignalLights() {
        return uniqueSignalLights;
    }
}

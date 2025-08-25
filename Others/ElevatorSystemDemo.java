package Others;

import java.util.*;

enum Direction {
    UP, DOWN
}

class Request {
    int floor;

    public Request(int floor) {
        this.floor = floor;
    }
}

class DisplayPanel {
    void show(int floor, Direction direction) {
        System.out.println("[DISPLAY] Floor: " + floor + " | Direction: " + direction);
    }
}

class Elevator {
    int currentFloor = 6;
    Direction direction = Direction.UP;
    TreeSet<Integer> upRequests = new TreeSet<>();
    TreeSet<Integer> downRequests = new TreeSet<>();

    DisplayPanel panel = new DisplayPanel();

    public void addRequest(int floor) {
        if (floor >= currentFloor) {
            upRequests.add(floor);
        } else {
            downRequests.add(floor);
        }
    }

    public void step() {
        panel.show(currentFloor, direction); // Always show current state

        if (direction == Direction.UP) {
            Integer next = upRequests.ceiling(currentFloor + 1);
            if (next != null) {
                moveTo(next);
                upRequests.remove(next);
            } else {
                direction = Direction.DOWN;
            }
        } else {
            Integer next = downRequests.floor(currentFloor - 1);
            if (next != null) {
                moveTo(next);
                downRequests.remove(next);
            } else {
                direction = Direction.UP;
            }
        }
    }

    private void moveTo(int floor) {
        System.out.println("Moving from floor " + currentFloor + " to floor " + floor);
        currentFloor = floor;
    }

    public boolean hasPendingRequests() {
        return !upRequests.isEmpty() || !downRequests.isEmpty();
    }
}

public class ElevatorSystemDemo {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        // Simulate adding requests
        elevator.addRequest(3);
        elevator.addRequest(5);
        elevator.addRequest(7);

        // Run the elevator until all requests are fulfilled
        while (elevator.hasPendingRequests()) {
            elevator.step();
        }

        elevator.addRequest(6);
        elevator.addRequest(1);
        elevator.addRequest(4);

        while (elevator.hasPendingRequests()) {
            elevator.step();
        }

        System.out.println("All requests completed. Final Direction: " + elevator.direction);
    }
}

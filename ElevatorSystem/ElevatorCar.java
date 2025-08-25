package ElevatorSystem;

import java.util.Random;
import java.util.TreeSet;

import ElevatorSystem.Strategy.MovingStrategy;

public class ElevatorCar {
    
    private String id;
    private int currentFloor;
    private TreeSet<Integer> upRequests;
    private TreeSet<Integer> downRequests;
    private Direction direction;
    private boolean  inMaintenance;
    private MovingStrategy strategy;

    public ElevatorCar(String id, int currentFloor, Direction direction, MovingStrategy strategy) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.direction = direction;
        this.inMaintenance = false;
        this.strategy = strategy;

        upRequests = new TreeSet<>();
        downRequests = new TreeSet<>();
    }

    public void setMaintenance(boolean flag) {
        this.inMaintenance = flag;
    }
    
    public boolean getMaintenance() {
        return this.inMaintenance;
    }

    public void addExternalRequest(Request request) {
        if(currentFloor <= request.getFloor()) upRequests.add(request.getFloor());
        else downRequests.add(request.getFloor());

        Random rand = new Random();
        int getRandomFloor = request.getDirection() == Direction.UP 
                            ? rand.nextInt(10-request.getFloor()+1)+request.getFloor()
                            : rand.nextInt(request.getFloor());

        System.out.println(request.getFloor()+" : "+request.getDirection()+" : "+getRandomFloor);
        
        addInternalRequest(new Request(request.getDirection(), getRandomFloor));
    }

    private void addInternalRequest(Request request) {
        if(currentFloor <= request.getFloor()) upRequests.add(request.getFloor());
        else downRequests.add(request.getFloor());
    }

    public boolean canAssignExternalRequest(Request request) {

        if(inMaintenance) return false;
        if(request.getDirection() == this.direction) {
            if(this.direction == Direction.UP && request.getFloor() >= this.currentFloor) {
                return true;
            }
            else if(this.direction == Direction.DOWN && request.getFloor() <= this.currentFloor) {
                return true;
            }
        }

        return false;
    }

    public void move() {
        strategy.move(this);        
    }

    public void displayPanel() {
        System.out.println("Elevator : "+this.id+" CurrentFloor : "+currentFloor+" Direction : "+this.direction);
    }

    public void changeFloor(int floor) {
        System.out.println("Elevator : "+this.id+" Moving From : "+currentFloor+" to : "+floor);
        currentFloor = floor;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public String getId() {
        return this.id;
    }

    public TreeSet<Integer> getUpRequests() {
        return this.upRequests;
    }

    public TreeSet<Integer> getDownRequests() {
        return this.downRequests;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction d) {
        this.direction = d;
    }

    public boolean hasHandledAllRequests() {
        return upRequests.isEmpty() && downRequests.isEmpty();
    }

    public void printALl() {
        System.out.println(id);
        System.out.println(currentFloor);
        System.out.println(direction);
        System.out.println(upRequests);
        System.out.println(downRequests);
    }
}

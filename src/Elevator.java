import java.util.ArrayList;
import java.util.List;

class Elevator {
    private int currentFloor;
    private Direction direction;
    private List<Integer> destinations;

    public Elevator() {
        this.currentFloor = 0; // Start from the ground floor (0)
        this.direction = Direction.IDLE;
        this.destinations = new ArrayList<>();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void addDestination(int destination) {
        destinations.add(destination);
        if (destination > currentFloor) {
            direction = Direction.UP;
        } else if (destination < currentFloor) {
            direction = Direction.DOWN;
        }
    }

    public boolean hasDestination() {
        return !destinations.isEmpty();
    }

    public void move() {
        if (hasDestination()) {
            int destination = destinations.get(0);
            if (destination > currentFloor) {
                currentFloor++;
            } else if (destination < currentFloor) {
                currentFloor--;
            }

            System.out.println("Elevator is on floor " + currentFloor);
            if (currentFloor == destinations.get(0)) {
                System.out.println("Boarding the elevator...");
            }

            try {
                Thread.sleep(500); // Hold for at least 0.5 seconds on each floor
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (destination == currentFloor) {
                destinations.remove(0);
                System.out.println("Exiting the elevator...");
            }
        } else {
            direction = Direction.IDLE;
        }
    }
}
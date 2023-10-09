import java.util.ArrayList;
import java.util.List;

class ElevatorSystem {
    private List<Elevator> elevators;
    private List<Floor> floors;

    public ElevatorSystem(int numElevators, int numFloors) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator());
        }
        floors = new ArrayList<>();
        for (int i = 0; i < numFloors; i++) {
            floors.add(new Floor(i));
        }
    }

    public Elevator requestElevator(int floor) {
        // Implement a simple elevator request algorithm here
        // For now, let's just return the first elevator.
        if (!elevators.isEmpty()) {
            return elevators.get(0);
        }
        return null;
    }
}
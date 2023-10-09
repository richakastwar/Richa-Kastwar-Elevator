import java.util.Scanner;

public class ElevatorController {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(1, 10); // 10 floors (0-9)
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the floor you are on (0-9) or 'q' to quit: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting elevator system.");
                break;
            }

            try {
                int userFloor = Integer.parseInt(input);
                if (userFloor < 0 || userFloor > 9) {
                    System.out.println("Invalid floor number. Please enter a number between 0 and 9.");
                    continue;
                }

                Elevator elevator = elevatorSystem.requestElevator(userFloor);
                if (elevator != null) {
                    System.out.println("Elevator requested. Please wait.");

                    System.out.print("Enter your desired destination floor (0-9): ");
                    int destinationFloor = Integer.parseInt(scanner.nextLine());
                    if (destinationFloor < 0 || destinationFloor > 9) {
                        System.out.println("Invalid destination floor. Please enter a number between 0 and 9.");
                        continue;
                    }

                    elevator.addDestination(userFloor);
                    elevator.addDestination(destinationFloor);

                    while (elevator.hasDestination()) {
                        elevator.move();
                    }
                } else {
                    System.out.println("No available elevators. Please wait.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        scanner.close();
    }
}

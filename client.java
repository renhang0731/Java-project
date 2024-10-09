
package apr24.assignmenty1g3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        Transport[] transports = {
            new Ship("Cargo Ship", 2000000),
            new Ship("Tranquility", 3000),
            new Plane("Boeing 777", 18000),
            new Plane("Air Force One", 80000)
        };

        for (Transport transport : transports) {
            System.out.println("\n"+transport.toString());
            transport.move();
        }

        Scanner scanner = new Scanner(System.in);
        int transportSelection = -1;

        while (transportSelection != 0) {
            System.out.println("\nTransport Menu:");
            for (int i = 0; i < transports.length; i++) {
                System.out.println((i + 1) + ". " + transports[i].name);
            }
            System.out.println("Enter Selection (0 to exit):");
            try {
                transportSelection = scanner.nextInt();
                if (transportSelection < 0 || transportSelection > transports.length) {
                    System.out.println("Invalid input.");
                    continue;
                }
                if (transportSelection == 0) break;

                Transport selectedTransport = transports[transportSelection - 1];
                boolean actionCompleted = false;

                while (!actionCompleted) {
                    System.out.println("\nAction Menu:");
                    System.out.println("1. Load");
                    System.out.println("2. Unload");
                    System.out.println("3. Current Load");
                    System.out.println("Enter Selection (0 to cancel):");
                    int actionSelection = scanner.nextInt();
                    switch (actionSelection) {
                        case 1 -> {
                            System.out.println("Enter load weight in kg:");
                            int loadWeight = scanner.nextInt();
                            try {
                                selectedTransport.load(loadWeight);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            System.out.println("The current load of " + selectedTransport.name + " is " + selectedTransport.currentLoad + " kg.");
                        }
                        case 2 -> {
                            System.out.println("Enter weight in kg to unload:");
                            int unloadWeight = scanner.nextInt();
                            try {
                                selectedTransport.unload(unloadWeight);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            System.out.println("The current load of " + selectedTransport.name + " is " + selectedTransport.currentLoad + " kg.");
                        }
                        case 3 -> System.out.println("The current load of " + selectedTransport.name + " is " + selectedTransport.currentLoad + " kg.");
                        case 0 -> actionCompleted = true;
                        default -> System.out.println("Invalid input.");
                    }

                    if (actionSelection != 0) {
                        actionCompleted = true;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.next(); // Clear the invalid input
            }
        }

        System.out.println("Thank you for using the system.");
    }
}


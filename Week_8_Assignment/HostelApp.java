package STEP_SEM_3.Week_8_Assignment;

import java.util.Scanner;

// Abstract Base Class
abstract class HostelRoom {
    protected int units;

    public HostelRoom(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

// Derived Classes
class SingleRoom extends HostelRoom {
    public SingleRoom(int units) { super(units); }

    @Override
    public double calculateBill() {
        return units * 8.0; // 8 per unit
    }
}

class SharedRoom extends HostelRoom {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants; // 6 per unit divided equally
    }
}

class ACRoom extends HostelRoom {
    public ACRoom(int units) { super(units); }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0; // 10 per unit + fixed charge 200
    }
}

// Main Driver Class
public class HostelApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            HostelRoom room = null;

            if (type.equals("SINGLE")) {
                room = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occupants = scanner.nextInt();
                room = new SharedRoom(units, occupants);
            } else if (type.equals("AC")) {
                room = new ACRoom(units);
            }

            if (room != null) {
                double bill = room.calculateBill();
                grandTotal += bill;
                System.out.printf("%s: %.2f%n", type, bill);
            }
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}

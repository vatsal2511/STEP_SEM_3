package STEP_SEM_3.Week_8_Assignment;

import java.util.Scanner;

// Abstract Base Class
abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
}

// Derived Classes
class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }

    @Override
    public double calculateCharge() {
        return hours * 10.0; // 10 per hour
    }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }

    @Override
    public double calculateCharge() {
        return 30.0 + (hours - 1) * 20.0; // 30 first hour + 20 per additional hour
    }
}

class Truck extends Vehicle {
    public Truck(int hours) { super(hours); }

    @Override
    public double calculateCharge() {
        return Math.max(100.0, hours * 50.0); // 50 per hour, minimum 100
    }
}

// Main Driver Class
public class ParkingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            Vehicle vehicle = null;

            if (type.equals("BIKE")) {
                vehicle = new Bike(hours);
            } else if (type.equals("CAR")) {
                vehicle = new Car(hours);
            } else if (type.equals("TRUCK")) {
                vehicle = new Truck(hours);
            }

            if (vehicle != null) {
                double charge = vehicle.calculateCharge();
                grandTotal += charge;
                System.out.printf("%s: %.2f%n", type, charge);
            }
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
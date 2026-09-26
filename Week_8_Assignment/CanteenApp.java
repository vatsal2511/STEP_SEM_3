package STEP_SEM_3.Week_8_Assignment;

import java.util.Scanner;

// Abstract Base Class
abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
}

// Derived Classes
class StudentCustomer extends Customer {
    public StudentCustomer(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95; // 5% discount
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0; // Full amount plus 10 service charge
    }
}

// Main Driver Class
public class CanteenApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            Customer customer = null;

            if (type.equals("STUDENT")) {
                customer = new StudentCustomer(amount);
            } else if (type.equals("STAFF")) {
                customer = new StaffCustomer(amount);
            } else if (type.equals("GUEST")) {
                customer = new GuestCustomer(amount);
            }

            if (customer != null) {
                double finalAmount = customer.calculateFinalAmount();
                grandTotal += finalAmount;
                System.out.printf("%s: %.2f%n", type, finalAmount);
            }
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
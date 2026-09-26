package STEP_SEM_3.Week_8_Assignment;

import java.util.Scanner;

// Abstract Base Class
abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

// Derived Classes
class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10; // 10% of monthly salary
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05; // 5% of monthly salary
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.0; // Fixed bonus 2000
    }
}

// Main Driver Class
public class BonusApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            Employee employee = null;

            if (type.equals("FULLTIME")) {
                employee = new FullTimeEmployee(name, salary);
            } else if (type.equals("PARTTIME")) {
                employee = new PartTimeEmployee(name, salary);
            } else if (type.equals("INTERN")) {
                employee = new InternEmployee(name, salary);
            }

            if (employee != null) {
                double bonus = employee.calculateBonus();
                grandTotal += bonus;
                System.out.printf("%s: %.2f%n", employee.getName(), bonus);
            }
        }

        System.out.printf("Total Bonus: %.2f%n", grandTotal);
        scanner.close();
    }
}
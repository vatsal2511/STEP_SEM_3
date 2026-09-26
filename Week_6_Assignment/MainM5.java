package STEP_SEM_3.Week_6_Assignment;

class Employee {
    // Instance fields
    String empName;
    double salary;

    // Shared static fields
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor incrementing class-level counter
    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    // Static method accessing only static members
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class MainM5 {
    public static void main(String[] args) {
        // Instantiating 3 Employee objects
        Employee e1 = new Employee("Anand", 50000);
        Employee e2 = new Employee("Bhavna", 62000);
        Employee e3 = new Employee("Chetan", 48000);

        // Accessing static method via Class reference
        Employee.printCompanyInfo();
    }
}
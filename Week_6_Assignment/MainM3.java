package STEP_SEM_3.Week_6_Assignment;

class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Overloaded constructor for interns chaining to the 3-arg constructor
    public Employee(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    // Prints profile details in one line
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class MainM3 {
    public static void main(String[] args) {
        Employee permEmp = new Employee("E101", "Divya", 65000);
        Employee internEmp = new Employee("E102", "Arjun");

        permEmp.printProfile();
        internEmp.printProfile();
    }
}
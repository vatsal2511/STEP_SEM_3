package STEP_SEM_3.Week_6;

class Student {
    // Instance variables
    String name;
    double attendance;

    // Shared static variables
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor incrementing static counter on every creation
    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    // Static method accessing only static context
    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class MainM5 {
    public static void main(String[] args) {
        // Instantiate two Student objects
        Student s1 = new Student("Ravi", 85.5);
        Student s2 = new Student("Anitha", 92.0);

        // Call static method using the Class name
        Student.printCollegeInfo();
    }
}

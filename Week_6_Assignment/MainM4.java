package STEP_SEM_3.Week_6_Assignment;

class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class MainM4 {
    public static void main(String[] args) {
        // Original instance
        HallTicket priya = new HallTicket("Priya", 0);

        // Reference assignment (pointing to the same object)
        HallTicket copy = priya;

        // Modifying through reference variable
        copy.seatNumber = 45;

        // Verify values and identity comparisons
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        // Creating a separate object instance with identical data
        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
    }
}

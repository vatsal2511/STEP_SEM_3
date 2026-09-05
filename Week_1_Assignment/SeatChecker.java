package STEP_SEM_3.Week_1_Assignment;

public class SeatChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        
        // Compare every seat against every other seat
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break; // Prevents printing the exact same pair multiple times
                }
            }
        }
        
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] test1 = {101, 102, 103, 102, 105};
        int[] test2 = {101, 102, 103, 104, 105};
        
        System.out.print("Input 1: ");
        checkDuplicateSeats(test1);
        
        System.out.print("Input 2: ");
        checkDuplicateSeats(test2);
    }
}

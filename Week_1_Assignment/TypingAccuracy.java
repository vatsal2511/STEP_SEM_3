package STEP_SEM_3.Week_1_Assignment;

public class TypingAccuracy {

    public static void checkTypingAccuracy(String original, String typed) {
        int matchCount = 0;
        int firstMismatch = -1;
        int total = original.length();
        
        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchCount++;
            } else if (firstMismatch == -1) {
                firstMismatch = i; // Store 0-based index of first mismatch
            }
        }
        
        double accuracy = ((double) matchCount / total) * 100;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matchCount, total, accuracy);
        
        if (firstMismatch != -1) {
            // Using firstMismatch + 1 to convert to a 1-based position for output
            System.out.printf("First Mismatch at position %d ('%c' vs '%c')\n", 
                (firstMismatch + 1), original.charAt(firstMismatch), typed.charAt(firstMismatch));
        } else {
            System.out.println("No Mismatches");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}

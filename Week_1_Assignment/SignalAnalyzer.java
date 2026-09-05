package STEP_SEM_3.Week_1_Assignment;

public class SignalAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) return;
        
        char maxChar = signalLog.charAt(0);
        int maxLength = 1;
        
        char currentChar = signalLog.charAt(0);
        int currentLength = 1;
        
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentLength++;
            } else {
                currentChar = signalLog.charAt(i);
                currentLength = 1;
            }
            
            // Update running maximum if current streak is longer
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxChar = currentChar;
            }
        }
        
        System.out.printf("Longest Streak: '%c' repeated %d times\n", maxChar, maxLength);
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}

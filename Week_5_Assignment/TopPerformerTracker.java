package STEP_SEM_3.Week_5_Assignment;

public class TopPerformerTracker {

    static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length == 0) {
            return "Min: 0\nMax: 0 Spread: 0";
        }

        int min = scores[0];
        int max = scores[0];

        // Single pass to track min and max simultaneously
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + "\nMax: " + max + " Spread: " + spread;
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores));
        // Output:
        // Min: 33
        // Max: 90 Spread: 57
    }
}

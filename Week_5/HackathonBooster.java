package STEP_SEM_3.Week_5;

import java.util.Arrays;

public class HackathonBooster {
    
    static void curveScores(int[] scores, int bonus) {
        // Loop through the original array and add the bonus in place
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores)); // Output: [80, 95, 70]
    }
}

package STEP_SEM_3.Week_5_Assignment;

import java.util.Arrays;

public class FantasyMultiplier {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores != null) {
            // Apply 2x multiplier for the Captain
            if (captainIndex >= 0 && captainIndex < playerScores.length) {
                playerScores[captainIndex] *= 2.0;
            }
            // Apply 1.5x multiplier for the Vice-Captain
            if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
                playerScores[viceCaptainIndex] *= 1.5;
            }
        }
    }

    public static void main(String[] args) {
        double[] scores = {40.0, 55.0, 30.0, 62.0};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores)); // Output: [40.0, 110.0, 30.0, 93.0]
    }
}

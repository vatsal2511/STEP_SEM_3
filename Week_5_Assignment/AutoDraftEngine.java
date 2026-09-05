package STEP_SEM_3.Week_5_Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() { return name; }
    public int getMatchesPlayed() { return matchesPlayed; }
    public double getBattingAverage() { return battingAverage; }
    public boolean isInjured() { return injured; }

    @Override
    public int compareTo(Player other) {
        // Descending order of batting average (fantasy points/ranking metric)
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class AutoDraftEngine {

    // Overloaded rule 1: Experience-only check for established players (matches >= 10)
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overloaded rule 2: Combined matches and fitness check for newer players (matches >= 5 and not injured)
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        List<Player> draftableList = new ArrayList<>();

        // Step 1: Filter candidates using overloaded rules
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftableList.add(p);
            }
        }

        // Step 2: Convert to array and sort using the Comparable implementation
        Player[] draftableArray = draftableList.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        // Step 3: Format the final ranked output string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            sb.append((i + 1)).append(". ").append(draftableArray[i].getName());
            if (i < draftableArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
        // Output: 1. Rahul | 2. Virat | 3. Dev
    }
}

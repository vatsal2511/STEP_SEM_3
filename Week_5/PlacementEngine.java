package STEP_SEM_3.Week_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
    public int getCodingScore() { return codingScore; }

    // Composite score calculation for ranking (e.g., CGPA scaled + coding score weighted)
    public double getCompositeScore() {
        return (cgpa * 10.0) + (codingScore * 0.5);
    }

    @Override
    public int compareTo(Candidate other) {
        // Descending order of composite score
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }
}

public class PlacementEngine {

    // Overloaded quick filter: CGPA-only
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Overloaded combined filter: Borderline CGPA with strong coding score
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();

        // Step 1: Filter using overloaded methods
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted.add(c);
            }
        }

        // Step 2: Convert to array and sort using Comparable implementation
        Candidate[] shortlistArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistArray);

        // Step 3: Format output string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlistArray.length; i++) {
            Candidate c = shortlistArray[i];
            sb.append((i + 1)).append(". ").append(c.getName())
              .append(" (").append(c.getCompositeScore()).append(")");
            if (i < shortlistArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
        // Output: 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }
}

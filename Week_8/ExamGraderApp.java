import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

// Abstract Base Class
abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String text, String correctAnswer, String studentAnswer, double points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double evaluate();
}

// Derived Classes
class MCQQuestion extends Question {
    public MCQQuestion(String text, String correctAnswer, String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0.0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String text, String correctAnswer, String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String text, String correctAnswer, String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluate() {
        String[] keywords = correctAnswer.split(",");
        String studentTextLower = studentAnswer.toLowerCase();
        int matchCount = 0;

        for (String kw : keywords) {
            if (studentTextLower.contains(kw.trim().toLowerCase())) {
                matchCount++;
            }
        }

        if (matchCount >= 2) return 0.75 * points;
        else if (matchCount == 1) return 0.50 * points;
        else return 0.0;
    }
}

// Main Driver Class
public class ExamGraderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        double totalScore = 0.0;
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(line);
            ArrayList<String> tokens = new ArrayList<>();

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    tokens.add(matcher.group(1));
                } else {
                    tokens.add(matcher.group(2));
                }
            }

            if (tokens.size() >= 5) {
                String qType = tokens.get(0);
                String text = tokens.get(1);
                String correct = tokens.get(2);
                String student = tokens.get(3);
                double points = Double.parseDouble(tokens.get(4));

                Question q = null;
                if (qType.equals("MCQ")) {
                    q = new MCQQuestion(text, correct, student, points);
                } else if (qType.equals("TF")) {
                    q = new TFQuestion(text, correct, student, points);
                } else if (qType.equals("ESSAY")) {
                    q = new EssayQuestion(text, correct, student, points);
                }

                if (q != null) {
                    double score = q.evaluate();
                    totalScore += score;
                    System.out.printf("%s: %.2f%n", qType, score);
                }
            }
        }

        System.out.printf("Total Score: %.2f%n", totalScore);
        scanner.close();
    }
}
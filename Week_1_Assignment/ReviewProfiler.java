package STEP_SEM_3.Week_1_Assignment;

public class ReviewProfiler {

    public static void classifyWordLengths(String review) {
        // Split string into words based on whitespace
        String[] words = review.split("\\s+");
        int shortCount = 0, mediumCount = 0, longCount = 0;
        
        for (String word : words) {
            // Strip out standard punctuation to ensure accurate length calculation
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            int len = cleanWord.length();
            
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }
        
        System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        String review = "This movie was absolutely fantastic and thrilling";
        classifyWordLengths(review);
    }
}

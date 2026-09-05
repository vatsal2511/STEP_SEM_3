import java.util.HashMap;

public class UniqueLetterHunt {

    public static char findFirstNonRepeatingChar(String text) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        
        // Compute frequency of every character
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Scan left to right for the first unique character
        for (char c : text.toCharArray()) {
            if (frequencyMap.get(c) == 1) {
                return c;
            }
        }
        
        return '\0'; // Null character indicates none found
    }

    public static void main(String[] args) {
        String[] testStrings = {"swiss", "aabbcc"};
        
        for (String text : testStrings) {
            char result = findFirstNonRepeatingChar(text);
            if (result != '\0') {
                System.out.println("Input: \"" + text + "\" | First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("Input: \"" + text + "\" | No Non-Repeating Character Found");
            }
        }
    }
}
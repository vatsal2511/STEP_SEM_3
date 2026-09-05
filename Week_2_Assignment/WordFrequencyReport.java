package STEP_SEM_3.Week_2_Assignment;

import java.util.*;

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        List<String> stopWords = Arrays.asList("the", "was", "and", "a", "is", "of", "in");
        
        // Normalize text: lowercase and strip periods/commas
        String normalized = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = normalized.split("\\s+");
        
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty()) continue;
            
            boolean isStopWord = false;
            for (String sw : stopWords) {
                if (word.equals(sw)) {
                    isStopWord = true;
                    break;
                }
            }
            
            if (!isStopWord) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }
        
        // Sort entries by count in descending order
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
    }
}
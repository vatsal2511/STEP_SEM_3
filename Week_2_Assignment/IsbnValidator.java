package STEP_SEM_3.Week_2_Assignment;

public class IsbnValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String pubCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return pubCode + rest;
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        
        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        // Validate remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        String pubCode = code.substring(0, 3);
        String yearPart = code.substring(3, 7);
        String catalogPart = code.substring(7, 13);
        
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ").append(yearPart)
          .append(" | CATALOG: ").append(catalogPart);
          
        return sb.toString();
    }

    public static void main(String[] args) {
        String raw1 = "pen2026004251";
        System.out.println(validateAndFormat(normalizeCode(raw1)));

        String raw2 = "12N2026004251";
        System.out.println(validateAndFormat(normalizeCode(raw2)));
    }
}

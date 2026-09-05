package STEP_SEM_3.Week_2;

public class BankReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }
        
        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        
        // Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        String bankCode = reference.substring(0, 3);
        String datePart = reference.substring(3, 9); // ddMMyy
        String seqPart = reference.substring(9, 14); // 5 digits sequence
        
        String formattedDate = datePart.substring(0, 2) + "/" + 
                               datePart.substring(2, 4) + "/" + 
                               datePart.substring(4, 6);
                               
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(formattedDate).append(" | SEQ: ").append(seqPart);
          
        return sb.toString();
    }

    public static void main(String[] args) {
        String test1 = " hdf03022600042";
        String norm1 = normalizeReference(test1);
        System.out.println(validateAndFormat(norm1));

        String test2 = "12F03022600042";
        String norm2 = normalizeReference(test2);
        System.out.println(validateAndFormat(norm2));
    }
}

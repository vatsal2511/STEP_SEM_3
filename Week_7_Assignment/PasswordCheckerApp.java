package STEP_SEM_3.Week_7_Assignment;

// Immutable Domain Class (Write-only password)
class PasswordChecker {
    private final String password; // No getter provided

    public PasswordChecker(String password) {
        this.password = password != null ? password : "";
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

// Main Driver Class
public class PasswordCheckerApp {
    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("abcd strength: " + pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("abcdefgh strength: " + pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("abcdefghij strength: " + pc3.getStrength());
    }
}

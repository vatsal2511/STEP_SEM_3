package STEP_SEM_3.Week_7;

// Domain Class
class Locker {
    private final int lockerNumber;
    private String code; // Write-only field (No getter provided)

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode)) {
            this.code = newCode;
            System.out.println("Code successfully changed.");
            return true;
        } else {
            System.out.println("Rejected: Incorrect current code entered. Code unchanged.");
            return false;
        }
    }
}

// Main Driver Class
public class LockerApp {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}

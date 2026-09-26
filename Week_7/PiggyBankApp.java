package STEP_SEM_3.Week_7;

// Domain Class
class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public String getId() {
        return id;
    }

    public double getSavings() {
        return savings;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("Deposited " + amount + " -> savings = " + savings);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            return;
        }
        if (amount > savings) {
            System.out.println("Withdrawal of " + amount + " rejected, savings stays " + savings);
        } else {
            savings -= amount;
            System.out.println("Withdrew " + amount + " -> savings = " + savings);
        }
    }
}

// Main Driver Class
public class PiggyBankApp {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println("Final Savings: " + pb.getSavings());
    }
}
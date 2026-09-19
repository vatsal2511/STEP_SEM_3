package STEP_SEM_3.Week_6;

class MessWallet {
    private double balance;

    // Public constructor preventing negative initial balance
    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Negative opening balance provided. Setting balance to 0.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    // Top-up method rejecting non-positive amounts
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be greater than 0.");
        } else {
            this.balance += amount;
            System.out.println("Balance after top-up: " + this.balance);
        }
    }

    // Deduct method preventing overdraft
    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Deduct rejected: Amount must be greater than 0.");
        } else {
            this.balance -= amount;
            System.out.println("Balance after deduction: " + this.balance);
        }
    }

    // Read-only getter for balance
    public double getBalance() {
        return this.balance;
    }
}

public class MainM2 {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}

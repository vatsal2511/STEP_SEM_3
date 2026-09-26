package STEP_SEM_3.Week_6_Assignment;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    // Constructor validating positive initial basic salary
    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Negative basic salary provided. Setting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0;
    }

    // Credits bonus if amount > 0
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Credit rejected: Amount must be greater than 0.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Deducts percentage tax from basic salary if within 0 - 100 range
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax deduction rejected: Invalid percentage.");
        } else {
            this.basicSalary -= (this.basicSalary * percent / 100.0);
            System.out.println("Tax % deducted: " + (int) percent);
        }
    }

    // Read-only getter for net salary
    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class MainM2 {
    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
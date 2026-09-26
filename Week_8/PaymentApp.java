import java.util.Scanner;

// Abstract Base Class
abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAdjustedAmount();
}

// Derived Classes
class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.02; // 2% fee
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.01; // 1% fee
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.00; // 0% fee
    }
}

// Main Driver Class
public class PaymentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            PaymentMethod payment = null;

            if (type.equals("CARD")) {
                payment = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                payment = new WalletPayment(amount);
            } else if (type.equals("BANKTRANSFER")) {
                payment = new BankTransferPayment(amount);
            }

            if (payment != null) {
                double adjusted = payment.calculateAdjustedAmount();
                grandTotal += adjusted;
                System.out.printf("%s: %.2f%n", type, adjusted);
            }
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
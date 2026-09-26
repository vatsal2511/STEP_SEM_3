package STEP_SEM_3.Week_8_Assignment;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Abstract Base Class
abstract class StreamingPlan {
    protected String name;
    protected LocalDate startDate;

    public StreamingPlan(String name, String startDateStr) {
        this.name = name;
        this.startDate = LocalDate.parse(startDateStr);
    }

    public String getName() {
        return name;
    }

    public abstract int getValidityDays();

    public String calculateRenewalDate() {
        LocalDate renewalDate = startDate.plusDays(getValidityDays());
        return renewalDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}

// Derived Classes
class BasicPlan extends StreamingPlan {
    public BasicPlan(String name, String startDateStr) {
        super(name, startDateStr);
    }

    @Override
    public int getValidityDays() {
        return 30; // Valid for 30 days
    }
}

class StandardPlan extends StreamingPlan {
    public StandardPlan(String name, String startDateStr) {
        super(name, startDateStr);
    }

    @Override
    public int getValidityDays() {
        return 90; // Valid for 90 days
    }
}

class PremiumPlan extends StreamingPlan {
    public PremiumPlan(String name, String startDateStr) {
        super(name, startDateStr);
    }

    @Override
    public int getValidityDays() {
        return 365; // Valid for 365 days
    }
}

// Main Driver Class
public class StreamingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String planType = scanner.next();
            String name = scanner.next();
            String startDateStr = scanner.next();
            StreamingPlan plan = null;

            if (planType.equals("BASIC")) {
                plan = new BasicPlan(name, startDateStr);
            } else if (planType.equals("STANDARD")) {
                plan = new StandardPlan(name, startDateStr);
            } else if (planType.equals("PREMIUM")) {
                plan = new PremiumPlan(name, startDateStr);
            }

            if (plan != null) {
                System.out.println(plan.getName() + ": " + plan.calculateRenewalDate());
            }
        }

        scanner.close();
    }
}

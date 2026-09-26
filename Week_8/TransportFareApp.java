import java.util.Scanner;

// Abstract Base Class
abstract class Journey {
    protected double distance;

    public Journey(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
}

// Derived Classes
class BusJourney extends Journey {
    public BusJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(10.0, fare);
    }
}

class TrainJourney extends Journey {
    public TrainJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroJourney extends Journey {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

// Main Driver Class
public class TransportFareApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String transportType = scanner.next();
            double distance = scanner.nextDouble();
            Journey journey = null;

            if (transportType.equals("BUS")) {
                journey = new BusJourney(distance);
            } else if (transportType.equals("TRAIN")) {
                journey = new TrainJourney(distance);
            } else if (transportType.equals("METRO")) {
                double peakFactor = scanner.nextDouble();
                journey = new MetroJourney(distance, peakFactor);
            }

            if (journey != null) {
                double fare = journey.calculateFare();
                grandTotal += fare;
                System.out.printf("%s: %.2f%n", transportType, fare);
            }
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
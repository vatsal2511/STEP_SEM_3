package STEP_SEM_3.Week_7_Assignment;

// Domain Class
class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // Default start color
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void next() {
        switch (color) {
            case "RED":
                color = "GREEN";
                break;
            case "GREEN":
                color = "YELLOW";
                break;
            case "YELLOW":
                color = "RED";
                break;
            default:
                color = "RED";
                break;
        }
    }
}

// Main Driver Class
public class TrafficLightApp {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Initial Color: " + t.getColor());

        t.next();
        System.out.println("After next(): " + t.getColor());

        t.next();
        System.out.println("After next(): " + t.getColor());

        t.next();
        System.out.println("After next(): " + t.getColor());
    }
}

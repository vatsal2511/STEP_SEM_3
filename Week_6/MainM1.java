package STEP_SEM_3.Week_6;

class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    // Constructor to set all three fields
    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // Instance method to print one formatted line
    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class MainM1 {
    public static void main(String[] args) {
        // Creating three PlacementRecord objects and storing them in an array
        PlacementRecord[] records = {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        // Iterating and printing each record
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}
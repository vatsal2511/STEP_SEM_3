package STEP_SEM_3.Week_6;

class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class MainM4 {
    public static void main(String[] args) {
        // Create original object
        IdCard ravi = new IdCard("Ravi", 0);
        
        // Point duplicate variable to same object reference
        IdCard duplicate = ravi;

        // Modify object through duplicate reference
        duplicate.booksIssued = 3;

        // Check values and identity comparison
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // Create a separate new object with identical values
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
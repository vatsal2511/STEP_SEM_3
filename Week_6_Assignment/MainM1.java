package STEP_SEM_3.Week_6_Assignment;

class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    // Constructor to initialize book details
    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Instance method to display formatted inventory line
    public void printEntry() {
        System.out.println(title + " by " + author + " " + copiesAvailable + " copies available");
    }
}

public class MainM1 {
    public static void main(String[] args) {
        // Storing BookInventory objects in an array
        BookInventory[] inventory = {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        // Iterating and printing entries
        for (BookInventory book : inventory) {
            book.printEntry();
        }
    }
}
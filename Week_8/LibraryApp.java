import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Abstract Base Class
abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowDuration();

    public String calculateDueDate(LocalDate currentDate) {
        LocalDate dueDate = currentDate.plusDays(getBorrowDuration());
        return dueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}

// Derived Classes
class Book extends LibraryItem {
    public Book(String title) { super(title); }

    @Override
    public int getBorrowDuration() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title) { super(title); }

    @Override
    public int getBorrowDuration() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) { super(title); }

    @Override
    public int getBorrowDuration() {
        return 3;
    }
}

// Main Driver Class
public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        Pattern pattern = Pattern.compile("^(\\w+)\\s+\"([^\"]+)\"$");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String itemType = matcher.group(1);
                String title = matcher.group(2);
                LibraryItem item = null;

                if (itemType.equals("BOOK")) {
                    item = new Book(title);
                } else if (itemType.equals("DVD")) {
                    item = new DVD(title);
                } else if (itemType.equals("MAGAZINE")) {
                    item = new Magazine(title);
                }

                if (item != null) {
                    System.out.println(title + ": " + item.calculateDueDate(currentDate));
                }
            }
        }
        scanner.close();
    }
}
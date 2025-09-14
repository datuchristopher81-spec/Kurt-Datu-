import java.util.Scanner;
public class Lab1JavaReview {

    
    static final int MAX_BOOKS = 5;
    static String[] titles = new String[MAX_BOOKS];
    static String[] status = new String[MAX_BOOKS];
    static int bookCount = 0;  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        
        do {
            
            System.out.println("\n==================================");
            System.out.println("||          L  B  M  S          ||");
            System.out.println("||   LIBRARY BOOK MANAGEMENT    ||");
            System.out.println("||          SYSTEM              ||");
            System.out.println("==================================");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book Status");
            System.out.println("3. Show All Books");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    updateBookStatus(sc);
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("\nExiting program... Goodbye and thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    public static void addBook(Scanner sc) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("Book limit reached. Cannot add more books.");
            return;
        }

        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        titles[bookCount] = title;          
        status[bookCount] = "Available";    
        bookCount++;                        

        System.out.println("Book added successfully!");
    }

    
    public static void updateBookStatus(Scanner sc) {
        if (bookCount == 0) {
            System.out.println("No books available to update.");
            return;
        }

        showBooks();
        System.out.print("Enter book number to update: ");
        int num = sc.nextInt();
        sc.nextLine(); 

        if (num < 1 || num > bookCount) {
            System.out.println("Invalid book number.");
            return;
        }

        int index = num - 1; 
        if (status[index].equals("Available")) {
            status[index] = "Borrowed";
        } else {
            status[index] = "Available";
        }

        System.out.println("Book status updated.");
    }

    public static void showBooks() {
        if (bookCount == 0) {
            System.out.println("No books to display.");
            return;
        }

        System.out.println("\n--- List of Books ---");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". Title: " + titles[i] + " | Status: " + status[i]);
        }
    }
   
    public static void generateReport() {
        int available = 0;
        int borrowed = 0;

        for (int i = 0; i < bookCount; i++) {
            if (status[i].equals("Available")) {
                available++;
            } else {
                borrowed++;
            }
        }

        System.out.println("\n--- Book Report ---");
        System.out.println("Total books: " + bookCount);
        System.out.println("Available books: " + available);
        System.out.println("Borrowed books: " + borrowed);
    }
}

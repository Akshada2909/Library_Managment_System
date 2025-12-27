import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        library.addBook(new Book("101", "Java Basics", "James", "Programming"));
        library.addBook(new Book("102", "OOP Concepts", "Dennis", "Programming"));

        library.addMember(new Member(1, "Akshada", "9999999999"));

        while (true) {
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. View Books");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    library.viewBooks();
                    break;

                case 2:
                    System.out.print("Enter title or author: ");
                    String key = sc.nextLine();
                    Book book = library.searchBook(key);
                    if (book != null) {
                        System.out.println("Book Found: " + book.getTitle());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    int mid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String bt = sc.nextLine();
                    library.borrowBook(mid, bt);
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    int rm = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String rb = sc.nextLine();
                    library.returnBook(rm, rb);
                    break;

                case 5:
                    System.out.println("Thank you for using Library Management System.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

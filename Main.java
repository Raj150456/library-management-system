import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = Storage.load();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- LIBRARY MANAGEMENT ---");
            System.out.println("1. Add Book");
            System.out.println("2. Search Books");
            System.out.println("3. Register User");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. View All Books");
            System.out.println("7. View All Users");
            System.out.println("8. View Transactions");
            System.out.println("9. Save & Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Title: "); String title = sc.nextLine();
                    System.out.print("Author: "); String author = sc.nextLine();
                    System.out.print("ISBN: "); String isbn = sc.nextLine();
                    System.out.print("Genre: "); String genre = sc.nextLine();
                    library.addBook(new Book(title, author, isbn, genre));
                    break;
                case 2:
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();
                    library.searchBook(keyword).forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("User ID: "); String userId = sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Contact: "); String contact = sc.nextLine();
                    library.addUser(new User(userId, name, contact));
                    break;
                case 4:
                    System.out.print("User ID: "); String uId = sc.nextLine();
                    System.out.print("ISBN: "); String bIsbn = sc.nextLine();
                    System.out.print("Transaction ID: "); String tId = sc.nextLine();
                    library.borrowBook(uId, bIsbn, tId);
                    break;
                case 5:
                    System.out.print("User ID: "); String rUId = sc.nextLine();
                    System.out.print("ISBN: "); String rIsbn = sc.nextLine();
                    library.returnBook(rUId, rIsbn);
                    break;
                case 6:
                    library.getBooks().forEach(System.out::println);
                    break;
                case 7:
                    library.getUsers().forEach(System.out::println);
                    break;
                case 8:
                    library.getTransactions().forEach(System.out::println);
                    break;
                case 9:
                    Storage.save(library);
                    System.out.println("Data saved. Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 9);

        sc.close();
    }
}

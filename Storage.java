import java.io.*;
import java.util.ArrayList;

public class Storage {
    private static final String DATA_FILE = "library_data.txt";

    // Save library data to file
    public static void save(Library library) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE));

            // Save books
            ArrayList<Book> books = library.getBooks();
            writer.write("BOOKS:" + books.size());
            writer.newLine();
            for (Book book : books) {
                writer.write(book.getTitle() + "|" + book.getAuthor() + "|" +
                        book.getIsbn() + "|" + book.getGenre() + "|" + book.isAvailable());
                writer.newLine();
            }

            // Save users
            ArrayList<User> users = library.getUsers();
            writer.write("USERS:" + users.size());
            writer.newLine();
            for (User user : users) {
                writer.write(user.getUserId() + "|" + user.getName() + "|" + user.getContact());
                writer.newLine();
                // Save borrowed books for this user
                ArrayList<String> borrowed = user.getBorrowedBooks();
                writer.write("BORROWED:" + borrowed.size());
                writer.newLine();
                for (String isbn : borrowed) {
                    writer.write(isbn);
                    writer.newLine();
                }
            }

            // Save transactions
            ArrayList<Transaction> transactions = library.getTransactions();
            writer.write("TRANSACTIONS:" + transactions.size());
            writer.newLine();
            for (Transaction trans : transactions) {
                writer.write(trans.getTransactionId() + "|" + trans.getUserId() + "|" +
                        trans.getIsbn() + "|" + trans.getBorrowDate() + "|" + trans.getReturnDate());
                writer.newLine();
            }

            writer.close();
            System.out.println("✓ Data saved to " + DATA_FILE);

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load library data from file
    public static Library load() {
        Library library = new Library();
        File file = new File(DATA_FILE);

        // If no file exists, return empty library
        if (!file.exists()) {
            System.out.println("No saved data found. Starting fresh.");
            return library;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE));
            String line;

            // Load books
            line = reader.readLine();
            if (line != null && line.startsWith("BOOKS:")) {
                int bookCount = Integer.parseInt(line.split(":")[1]);
                for (int i = 0; i < bookCount; i++) {
                    line = reader.readLine();
                    String[] parts = line.split("\\|");
                    Book book = new Book(parts[0], parts[1], parts[2], parts[3]);
                    book.setAvailable(Boolean.parseBoolean(parts[4]));
                    library.addBookSilent(book); // Add without printing message
                }
            }

            // Load users
            line = reader.readLine();
            if (line != null && line.startsWith("USERS:")) {
                int userCount = Integer.parseInt(line.split(":")[1]);
                for (int i = 0; i < userCount; i++) {
                    line = reader.readLine();
                    String[] parts = line.split("\\|");
                    User user = new User(parts[0], parts[1], parts[2]);

                    // Load borrowed books for this user
                    line = reader.readLine();
                    if (line.startsWith("BORROWED:")) {
                        int borrowedCount = Integer.parseInt(line.split(":")[1]);
                        for (int j = 0; j < borrowedCount; j++) {
                            String isbn = reader.readLine();
                            user.borrowBook(isbn);
                        }
                    }

                    library.addUserSilent(user); // Add without printing message
                }
            }

            // Load transactions
            line = reader.readLine();
            if (line != null && line.startsWith("TRANSACTIONS:")) {
                int transCount = Integer.parseInt(line.split(":")[1]);
                for (int i = 0; i < transCount; i++) {
                    line = reader.readLine();
                    String[] parts = line.split("\\|");
                    // Transactions are reconstructed from the saved data
                    library.addTransactionSilent(parts[0], parts[1], parts[2], parts[3], parts[4]);
                }
            }

            reader.close();
            System.out.println("✓ Data loaded from " + DATA_FILE);

        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        return library;
    }
}

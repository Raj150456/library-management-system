import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Transaction> transactions;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    // Add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Add a user
    public void addUser(User user) {
        users.add(user);
        System.out.println("User registered successfully!");
    }

    // Search books by keyword (title, author, or ISBN)
    public ArrayList<Book> searchBook(String keyword) {
        ArrayList<Book> results = new ArrayList<>();
        keyword = keyword.toLowerCase();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword) ||
                    book.getAuthor().toLowerCase().contains(keyword) ||
                    book.getIsbn().toLowerCase().contains(keyword)) {
                results.add(book);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No books found!");
        }
        return results;
    }

    // Borrow a book
    public void borrowBook(String userId, String isbn, String transactionId) {
        User user = findUser(userId);
        Book book = findBook(isbn);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed!");
            return;
        }

        // Process borrowing
        book.setAvailable(false);
        user.borrowBook(isbn);
        Transaction transaction = new Transaction(transactionId, userId, isbn);
        transactions.add(transaction);
        System.out.println("Book borrowed successfully!");
    }

    // Return a book
    public void returnBook(String userId, String isbn) {
        User user = findUser(userId);
        Book book = findBook(isbn);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        // Find the transaction
        Transaction transaction = findActiveTransaction(userId, isbn);
        if (transaction == null) {
            System.out.println("No active borrow record found!");
            return;
        }

        // Process return
        book.setAvailable(true);
        user.returnBook(isbn);
        transaction.markReturned();
        System.out.println("Book returned successfully!");
    }

    // Helper method to find a user
    private User findUser(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    // Helper method to find a book
    private Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Helper method to find active transaction
    private Transaction findActiveTransaction(String userId, String isbn) {
        for (Transaction transaction : transactions) {
            if (transaction.getUserId().equals(userId) &&
                    transaction.getIsbn().equals(isbn) &&
                    !transaction.isReturned()) {
                return transaction;
            }
        }
        return null;
    }

    // Getters for viewing data
    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    // Silent methods for loading data (no print messages)
    public void addBookSilent(Book book) {
        books.add(book);
    }

    public void addUserSilent(User user) {
        users.add(user);
    }

    public void addTransactionSilent(String transId, String userId, String isbn,
            String borrowDate, String returnDate) {
        Transaction trans = new Transaction(transId, userId, isbn);
        // Note: We can't set the dates directly with current Transaction class
        // This is a simple implementation - dates will be reset to current time
        if (!returnDate.equals("null")) {
            trans.markReturned();
        }
        transactions.add(trans);
    }
}

import java.util.ArrayList;

public class User {
    private String userId;
    private String name;
    private String contact;
    private ArrayList<String> borrowedBooks; // Store ISBNs of borrowed books

    // Constructor
    public User(String userId, String name, String contact) {
        this.userId = userId;
        this.name = name;
        this.contact = contact;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public ArrayList<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Add a borrowed book
    public void borrowBook(String isbn) {
        borrowedBooks.add(isbn);
    }

    // Remove a returned book
    public void returnBook(String isbn) {
        borrowedBooks.remove(isbn);
    }

    // toString for displaying user info
    @Override
    public String toString() {
        return "User: " + name + " [ID: " + userId + "] - Books borrowed: " + borrowedBooks.size();
    }
}

import java.time.LocalDate;

public class Transaction {
    private String transactionId;
    private String userId;
    private String isbn;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    // Constructor for borrowing
    public Transaction(String transactionId, String userId, String isbn) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.isbn = isbn;
        this.borrowDate = LocalDate.now();
        this.returnDate = null; // Not returned yet
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    // Mark as returned
    public void markReturned() {
        this.returnDate = LocalDate.now();
    }

    // Check if book is returned
    public boolean isReturned() {
        return returnDate != null;
    }

    // toString for displaying transaction info
    @Override
    public String toString() {
        String status = isReturned() ? "Returned on " + returnDate : "Still borrowed";
        return "Transaction [ID: " + transactionId + "] User: " + userId +
                ", Book ISBN: " + isbn + ", Borrowed: " + borrowDate + " - " + status;
    }
}

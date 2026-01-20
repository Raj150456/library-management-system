public class Book {
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, String isbn, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.isAvailable = true; // New books are available by default
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // toString for displaying book info
    @Override
    public String toString() {
        String status = isAvailable ? "Available" : "Borrowed";
        return "Book: " + title + " by " + author + " [ISBN: " + isbn + "] - " + status;
    }
}

# Library Management System

> A console-based Java application demonstrating OOP principles, file I/O, and data persistence for managing library operations.

## 📚 Overview

A fully functional library management system built in Java that manages books, users, and transactions. The application features a menu-driven console interface and file-based persistence to save and load data between sessions.

**Learning Focus**: Object-oriented programming, file I/O, collections framework, and application architecture

## ✨ Key Features

- **Book Management**
  - Add books with title, author, ISBN, and genre
  - Search books by title, author, or ISBN (case-insensitive)
  - View all books with availability status
  - Track book availability in real-time

- **User Management**
  - Register users with unique ID, name, and contact information
  - Track borrowed books per user
  - View all registered users

- **Transaction System**
  - Borrow books with transaction tracking
  - Return books with automatic status updates
  - View complete transaction history with timestamps
  - Validate user and book existence before transactions

- **Data Persistence**
  - Automatic save/load functionality using file-based storage
  - Preserves books, users, transactions, and borrow status
  - Data persisted to `library_data.txt`

## 🛠️ Tech Stack

- **Language**: Java (console application)
- **Storage**: File-based persistence (text file)
- **Data Structures**: ArrayList for collections management

## 📂 Project Structure

```
library-management-system/
├── Main.java          # Application entry point with menu-driven UI
├── Library.java       # Core library logic and operations
├── Book.java          # Book entity with properties and methods
├── User.java          # User entity with borrowed books tracking
├── Transaction.java   # Transaction records with borrow/return dates
├── Storage.java       # File I/O for data persistence
└── library_data.txt   # Auto-generated data file (created on first save)
```

## 🚀 How to Run

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Terminal/Command Prompt

### Steps

1. **Clone the repository**

   ```bash
   git clone https://github.com/Raj150456/library-management-system.git
   cd library-management-system
   ```

2. **Compile the Java files**

   ```bash
   javac *.java
   ```

3. **Run the application**

   ```bash
   java Main
   ```

4. **Using the application**
   - The menu will display 9 options
   - Enter the number corresponding to your desired action
   - Follow the prompts to add books, register users, borrow/return books, etc.
   - Select option 9 to save data and exit

### Alternative: Using an IDE

- Open the project folder in Eclipse, IntelliJ IDEA, or VS Code
- Run `Main.java` directly from the IDE

## 💡 What I Learned

- **OOP Principles**: Implemented encapsulation, abstraction, and separation of concerns across 5 distinct classes
- **Collections Framework**: Used `ArrayList` for dynamic data management
- **File I/O**: Implemented complete save/load functionality using `BufferedReader` and `BufferedWriter`
- **Data Validation**: Added checks for user existence, book availability, and transaction integrity
- **Application Flow**: Designed a menu-driven interface with proper input handling and error messages

## 🔄 Future Enhancements

- [ ] Add database integration (SQLite/MySQL) to replace file-based storage
- [ ] Implement due dates and late fee calculations
- [ ] Add book reservation system for unavailable books
- [ ] Create a graphical user interface (GUI) using JavaFX or Swing
- [ ] Add unit tests using JUnit for core functionality
- [ ] Implement user authentication and role-based access (admin/member)
- [ ] Add data validation and exception handling improvements
- [ ] Generate reports (most borrowed books, active users, etc.)

## 📝 Interview Talking Points

**Class Design & Interactions**:

- `Book` class encapsulates book properties (title, author, ISBN, genre) and availability status
- `User` class maintains user details and tracks borrowed books using ArrayList
- `Library` class acts as the central controller, managing all books, users, and transactions
- `Transaction` class records borrow/return events with timestamps
- `Storage` class handles serialization/deserialization to persist data

**Key Implementation Details**:

- Used helper methods (`findUser`, `findBook`, `findActiveTransaction`) for clean code organization
- Implemented "silent" methods in Library class to avoid duplicate messages during data loading
- Designed a structured file format with section markers (BOOKS:, USERS:, TRANSACTIONS:) for reliable parsing

**What I'd Improve**:

- Replace text file storage with a relational database for better scalability
- Add comprehensive input validation and exception handling
- Implement unit tests to ensure reliability
- Refactor to use design patterns (e.g., Repository pattern for data access)
- Add logging framework instead of console print statements

## 📄 License

This is a student learning project created for educational purposes.

---

**Author**: Raj  
**GitHub**: [Raj150456](https://github.com/Raj150456)  
**Project URL**: [library-management-system](https://github.com/Raj150456/library-management-system)

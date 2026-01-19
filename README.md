# Library Management System (student project)

Project Title
library-management-system — a Java project to practice OOP and basic application flow.

Overview
- Learning goal: Implement core OOP concepts (classes, methods) and practice building a small application in Java.
- What it does: Provides basic library management features (e.g., add books, list books, issue/return logic). The exact features depend on the code in the repo.

Key Features
- Basic data structures for books and users (classes in Java)
- CRUD-like operations for book records
- Console-based or simple UI (depending on the code in the repository)

Tech Stack (only what exists in the repo)
- Java (source code)

How to run locally
1. Clone the repo:
   git clone https://github.com/Raj150456/library-management-system.git
2. Inspect the repo for build files:
   - If there is a build tool (Maven/Gradle), use it:
     mvn clean install
     # or
     gradle run
   - If plain Java source files:
     Find the main class and compile:
     javac -d out src/**/*.java
     java -cp out package.MainClass
   - Or open the project in an IDE (Eclipse/IntelliJ) and run the main class.
3. Follow any additional instructions in the repository (check for a README or run scripts).

What I learned
- Applying OOP design and organizing classes and packages in Java
- The compile-run cycle and using basic build tools or IDEs
- How to think about state (books, loans) and simple data modeling

Future improvements
- Add persistent storage (e.g., simple file-based or SQLite via JDBC)
- Add a simple web UI or REST API (JS/HTML frontend + Java backend) to demonstrate full-stack learning
- Add validation and tests for the core logic

Notes for interview
- Be ready to describe 1–2 classes you implemented and how they interact (Book, User, Loan).
- Explain what you'd change if you had more time (persistence, tests, separation of concerns).
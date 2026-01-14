# Library Management System

A simple Java-based Library Management System with a graphical user interface built using Swing and SQLite database.

## Features

- **Add Books**: Add new books to the library with Book ID, Title, Author, and Quantity
- **View Books**: Display all books in a table format
- **Data Persistence**: Books are stored in a SQLite database
- **Input Validation**: Validates user input before adding books
- **Error Handling**: Comprehensive error handling for database operations
- **User-Friendly GUI**: Intuitive Swing-based graphical interface

## Requirements

- Java JDK 8 or higher
- SQLite JDBC driver (sqlite-jdbc-3.50.2.0.jar)

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/AkshayaaVeena/Library-Management-System.git
   cd Library-Management-System
   ```

2. **Download SQLite JDBC Driver**:
   - Download `sqlite-jdbc-3.50.2.0.jar` from [SQLite JDBC](https://github.com/xerial/sqlite-jdbc)
   - Place it in the `lib/` folder

3. **Compile the project**:
   ```bash
   javac *.java
   ```

## Usage

Run the application with:

```bash
java -cp ".;lib/*" LibraryManager
```

### How to Use the Application

1. **Launch** the application using the command above
2. **Enter Book Details**:
   - Book ID (numeric)
   - Title (text)
   - Author (text)
   - Quantity (numeric)
3. **Click "Add Book"** to add the book to the library
4. **View Books** in the table below the form
5. **Form clears** automatically after successful addition

## Project Structure

```
LibraryManagementSystem/
├── DBConnection.java          # Database connection and initialization
├── LibraryManager.java         # Main GUI application
├── Test.java                   # Test file
├── lib/
│   └── sqlite-jdbc-3.50.2.0.jar  # SQLite JDBC driver
└── README.md                   # This file
```

## File Descriptions

- **DBConnection.java**: Handles SQLite database connection and creates the `books` table
- **LibraryManager.java**: Main application with Swing GUI components for adding and viewing books
- **Test.java**: Test file for the project

## Database Schema

The application creates a `books` table with the following columns:

```sql
CREATE TABLE books (
    book_id INTEGER PRIMARY KEY,
    title TEXT NOT NULL,
    author TEXT NOT NULL,
    quantity INTEGER NOT NULL
)
```

## Error Handling

The application includes error handling for:
- Invalid Book ID input (non-numeric)
- Empty form fields
- Database connection failures
- SQL exceptions

## Technologies Used

- **Java**: Core programming language
- **Swing**: GUI framework
- **SQLite**: Database
- **JDBC**: Database connectivity

## Future Enhancements

- Delete books functionality
- Edit existing books
- Search functionality
- Book availability tracking
- User authentication
- Export to CSV/PDF

## Author

[Akshaya Veena](https://github.com/AkshayaaVeena)

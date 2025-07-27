# 📚 Library Management System

## Overview

The **Library Management System** is a core Java-based application designed to help librarians manage books, members, and borrowing activities in a concurrent and extensible way. This system supports fundamental operations such as book catalog management, member registration, borrowing and returning books, and tracking borrowing history. It is built with scalability and maintainability in mind, leveraging design principles like the Singleton pattern and thread-safe collections.

---

## 🚀 Features

- 📖 **Book Management**
    - Add, update, and remove books from the catalog
    - Each book includes details: `ISBN`, `Title`, `Author`, `Publication Year`, `Availability Status`

- 👤 **Member Management**
    - Register and unregister members
    - Each member has: `Member ID`, `Name`, `Contact Info`, `Borrowing History`

- 🔄 **Borrowing & Returning**
    - Enforces borrowing limits (e.g., max books per member)
    - Tracks loan duration
    - Maintains borrowing history per member

- 🔍 **Search Functionality**
    - Search books by title, author, or keyword

- ⚙️ **Concurrency Support**
    - Uses `ConcurrentHashMap` to manage concurrent access to books and members safely

- 🧱 **Extensible Design**
    - Clean architecture supporting future enhancements (e.g., reservation system, overdue tracking)

---

## 🏗️ Design Highlights

| Component           | Description |
|---------------------|-------------|
| `Book`              | Represents a book in the catalog with core details and status |
| `Member`            | Represents a library user with identity and borrowing record |
| `LibraryManager`    | Singleton class managing the entire library state and operations |
| `LibraryManagerDemo`| Entry point demonstrating usage of the system |

---

## 📦 Class Responsibilities

### ✅ `Book`
- Fields: `isbn`, `title`, `author`, `publicationYear`, `isAvailable`
- Methods: Getters, setters, availability toggling

### ✅ `Member`
- Fields: `memberId`, `name`, `contactInfo`, `borrowedBooks` (List)
- Methods: Add/remove book from borrowing history

### ✅ `LibraryManager` (Singleton)
- Manages:
    - `ConcurrentHashMap<String, Book>` (catalog)
    - `ConcurrentHashMap<String, Member>` (members)
- Methods:
    - `addBook(Book book)`
    - `removeBook(String isbn)`
    - `registerMember(Member member)`
    - `unregisterMember(String memberId)`
    - `borrowBook(String memberId, String isbn)`
    - `returnBook(String memberId, String isbn)`
    - `searchBooks(String keyword)`

### ✅ `LibraryManagementSystemDemo`
- Demonstrates:
    - Adding/removing books
    - Registering members
    - Borrowing and returning books
    - Searching catalog

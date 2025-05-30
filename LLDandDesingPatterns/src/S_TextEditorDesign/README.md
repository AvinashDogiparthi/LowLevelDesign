# 📝 Text Editor using Flyweight and Command Patterns

## 📌 Problem Statement

Design a Text Editor with the following features:

### Functional Requirements
1. `display()` → Display the entire content.
2. `display(n, m)` → Display content from line `n` to `m`.
3. `insert(n, text)` → Insert `text` at line `n`.
4. `delete(n)` → Delete line `n`.
5. `delete(n, m)` → Delete all lines from `n` to `m`.
6. `copy(n, m)` → Copy content from line `n` to `m` to clipboard.
7. `paste(n)` → Paste content from clipboard to line `n`.
8. `undo()` → Undo the last command.
9. `redo()` → Redo the last undone command.

---

## 🎯 Design Goals
- Optimize memory usage.
- Efficient text operations with undo/redo support.
- Structure system to be maintainable and extensible.

---

## 🧠 Why Use Flyweight Pattern?

When designing a text editor, memory can be wasted due to repeated characters and formatting styles. The **Flyweight Pattern** solves this by:

- Sharing common objects like characters and formatting.
- Separating **intrinsic state** (character, font, size, color) from **extrinsic state** (position, line number).

### ✅ Use Cases for Flyweight:
1. When memory is limited.
2. When many objects share similar state.
3. When object creation is expensive.

---

## ⚙️ Flyweight Pattern Solution

### Components:
- `CharacterFlyweight`: Stores shared character attributes (intrinsic state).
- `CharacterFlyweightFactory`: Creates and manages flyweight cache.
- `Line`: Represents a line of text using a list of character flyweights.

### Benefits:
- Reduces memory usage significantly.
- Improves performance by caching and reusing characters.

---

## 🧰 Command Pattern Solution

To support undo/redo functionality, we used the **Command Pattern**.

### Components:
- `Command` interface: Defines `execute()` and `undo()`.
- `InsertCommand`, `DeleteCommand`, `PasteCommand`: Concrete command classes.
- `TextEditor`: Maintains stacks for undo and redo commands.

### Benefits:
- Decouples the operation execution from UI/business logic.
- Easy to extend with new commands.
- Enables undo/redo with consistent logic.

---

## 🧪 Example Usage

```java
TextEditor editor = new TextEditor();

editor.insert(0, "Hello World");
editor.insert(1, "This is line 2");
editor.insert(2, "This is line 3");
editor.display();

editor.copy(0, 1);
editor.paste(2);
editor.display();

editor.undo();
editor.display();

editor.redo();
editor.display();

# StackOverflow System (LLD)

## Overview
This project implements a **low-level design (LLD)** for a simplified version of **StackOverflow**.  
The system allows users to **post questions, answer them, comment, vote, and search**. It also supports **tags, reputation scoring, and concurrent access handling**.

The design follows an **object-oriented and interface-driven approach**, ensuring scalability and extensibility.

---

![UML Diagram](PA_StackOverFlowDesign/umldiagram.PNG)

## Key Features

- **User Management**
    - Create and manage users.
    - Track user contributions (questions, answers, comments).

- **Question Management**
    - Users can post questions with associated tags.
    - Search questions by **keywords, tags, or user profiles**.

- **Answer & Comment System**
    - Users can post answers to questions.
    - Users can comment on both questions and answers.

- **Voting System**
    - Upvote or downvote questions and answers.
    - Votes affect user **reputation score**.

- **Reputation Management**
    - Reputation is calculated based on user activity and the quality of contributions.
    - Higher reputation grants more privileges.

- **Tag Management**
    - Questions are associated with tags for easier categorization.
    - Supports tag-based search.

- **Concurrency & Data Consistency**
    - System design ensures **thread-safety** and **consistent updates** under concurrent access.

---

## Design Components

### 1. **StackOverFlow**
- Singleton entry point for the platform.
- Manages users, questions, answers, tags, and reputation.

### 2. **UserManagementService**
- Handles creation and retrieval of users.
- Manages mapping between users and their posted questions/answers.

### 3. **User**
- Represents a system user.
- Attributes: `userId`, `userName`, `reputation`.
- Tracks posted questions, answers, and comments.

### 4. **Question**
- Represents a posted question.
- Attributes: `questionId`, `content`, `tags`, `author`.
- Supports comments, votes, and linked answers.

### 5. **Answer**
- Represents an answer to a question.
- Attributes: `answerId`, `content`, `author`.
- Supports comments and votes.

### 6. **Comment**
- Represents a comment on a **question or answer**.
- Attributes: `commentId`, `content`, `author`.

### 7. **Tag**
- Represents a label (e.g., `java`, `system-design`, `database`).
- Used to group questions and enable **tag-based search**.

### 8. **Voting**
- Allows users to **upvote or downvote** questions/answers.
- Influences the reputation score of the content author.

---

## Class Responsibilities

- **`StackOverFlow`** → Core orchestrator of system.
- **`UserManagementService`** → Manages user data and mappings.
- **`User`** → Encapsulates user profile, reputation, and activity.
- **`Question`** → Stores question details and linked answers/comments.
- **`Answer`** → Represents an answer with linked comments and votes.
- **`Comment`** → Represents user comments on questions/answers.
- **`Tag`** → Supports categorization and search.
- **`Voting`** → Handles upvotes/downvotes.

---

## Example Flow

### 1. Create Users
```java
StackOverFlow so = StackOve

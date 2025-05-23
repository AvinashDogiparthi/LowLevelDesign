# Customer Issue Resolution System

## Overview

This repository contains a **Low-Level Design (LLD)** implementation of a **Customer Issue Resolution System**, built for large-scale e-commerce platforms like Amazon or Flipkart.

The system is designed to:
- Track and manage customer issues (e.g., order delays, payment failures).
- Assign these issues to appropriate customer service agents based on predefined strategies.
- Maintain agent work history.
- Run efficiently in a **multi-threaded environment** with full **thread safety**.

---

## Key Highlights

- ✅ Thread-safe implementation for concurrent operations.
- ✅ Assignment of issues based on two strategies:
    1. **Experience-based Assignment** – Issues are assigned to the most experienced available agent.
    2. **Availability-based Assignment** – Issues are assigned to the first available qualified agent.
- ✅ Designed using the following object-oriented **design patterns**:
    - **Factory Pattern**
    - **Strategy Pattern**
    - **Singleton Pattern**

---

## Design Patterns Used

### 🔧 Factory Pattern
Used to encapsulate the creation of `Issue` objects based on their type.

```java
Issue issue = IssueFactory.createIssue("I1", IssueType.PAYMENT);

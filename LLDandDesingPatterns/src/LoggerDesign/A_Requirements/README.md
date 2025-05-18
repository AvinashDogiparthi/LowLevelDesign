# 📄 Custom Logging System

This repository contains a robust, high-performance logging system designed to support multiple logging levels, thread-safety, and asynchronous logging with flexible configuration options. It uses **Strategy**, **Singleton**, and **Chain of Responsibility** design patterns to ensure scalability and flexibility.

---

## 📌 **Table of Contents**
- [Introduction](#introduction)
- [Design Patterns Used](#design-patterns-used)
- [Features](#features)
- [Architecture Overview](#architecture-overview)
- [Logging Levels](#logging-levels)
- [Appenders (Log Destinations)](#appenders-log-destinations)
- [Thread-Safety and Asynchronous Logging](#thread-safety-and-asynchronous-logging)
- [Message Formatting (Layouts)](#message-formatting-layouts)
- [Configuration Management](#configuration-management)
- [Log Filters](#log-filters)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Performance Considerations](#performance-considerations)

---

## 🚦 **Introduction**
This custom logging system is a high-performance, multi-threaded logging framework designed to handle millions of log messages per second. It supports multiple logging levels, flexible configurations, and efficient log management using advanced design patterns.

---

## ✅ **Design Patterns Used**
### 1. **Strategy Pattern:**
- Used for defining various log formatting strategies.
- Allows selecting different log formats (e.g., JSON, plain text) at runtime.

### 2. **Singleton Pattern:**
- Ensures a single instance of `LogManager` across the application.
- Provides a global access point for the logging system.

### 3. **Chain of Responsibility Pattern:**
- Implements a chain of loggers (ConsoleAppender, FileAppender, RollingFileAppender).
- Each logger processes the log message if conditions are met and forwards it down the chain.

---

## ✅ **Features**
- **Logging Levels:** Support for multiple levels (DEBUG, INFO, WARN, ERROR, FATAL).
- **High Performance:** Can handle 1 million concurrent logs per second.
- **Appenders (Log Destinations):**
    - ConsoleAppender (Logs to the console).
    - FileAppender (Logs to a specified file).
    - RollingFileAppender (Supports log rotation based on size or time).
- **Thread-Safety:** Logs from multiple threads do not overlap or get mixed.
- **Asynchronous Logging:** Uses a queue to buffer log messages.
- **Customizable Layouts:** Support for user-defined log formats.
- **Dynamic Configuration:** Configuration through a JSON file with the ability to update at runtime.
- **Log Filters:** Conditional logging based on keywords or patterns.

---

## ✅ **Architecture Overview**
### ✅ **Core Components:**
1. **Logger (Strategy Pattern):** Main class responsible for logging messages, supporting different formats.
2. **LogManager (Singleton Pattern):** Manages a single instance of Logger, provides configuration.
3. **Appender (Chain of Responsibility Pattern):** Manages log destinations (Console, File, Rolling File).
4. **Formatter/Layout:** Defines log message format.
5. **Queue (Asynchronous Logging):** Buffers log messages for worker threads.

---

## ✅ **Logging Levels**
The logging system supports five standard logging levels:
- **DEBUG:** Detailed debugging information.
- **INFO:** General operational messages.
- **WARN:** Potential issues that do not disrupt operation.
- **ERROR:** Errors that affect a specific operation but allow the application to continue.
- **FATAL:** Severe errors causing the application to crash.

### ✅ **Usage Example:**
```java
Logger logger = LogManager.getLogger("ApplicationLogger");
logger.debug("This is a debug message");
logger.info("Application started successfully");
logger.warn("This is a warning message");
logger.error("An error occurred");
logger.fatal("Critical system failure");

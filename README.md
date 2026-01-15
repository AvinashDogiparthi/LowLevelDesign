# Low Level Designs & Design Patterns

![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java)
![Build](https://img.shields.io/badge/Build-Maven-blue?style=for-the-badge&logo=apachemaven)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

Welcome to the **System Design and Design Patterns** repository! 

This repository serves as a comprehensive reference for developers mastering **Low-Level Design (LLD)**. It contains production-ready implementations of Object-Oriented Design (OOD) principles, design patterns, and full-scale system design solutions using **Java**.

---

## Table of Contents

1. [Core Concepts](#-core-concepts)
2. [Design Patterns](#-design-patterns)
3. [System Design Solutions (LLD)](#-system-design-solutions-lld)
4. [How to Run](#-how-to-run)
5. [Contributing](#-contributing)

---

## 🧠 Core Concepts

Understanding the foundational principles of software architecture.

| Module | Description |
| :--- | :--- |
| **[A_SOLIDPrinciples](LLDandDesingPatterns/src/A_SOLIDPrinciples)** | Implementation of S.O.L.I.D principles (Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion). |

---

## Design Patterns

Comprehensive implementations of Creational, Structural, and Behavioral patterns.

| Code | Pattern Name | Description |
| :--- | :--- | :--- |
| **AA** | [Singleton](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/AA_SingletonDesignPattern) | Thread-safe, Lazy, Eager, and Enum implementations. |
| **A** | [Strategy](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/A_StrategyDesignPattern) | Interchangeable algorithms (e.g., Parking Spot allocation). |
| **B** | [Observer](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/B_ObserverDesignPattern) | Publish-Subscribe mechanism (e.g., Availability notifications). |
| **C** | [Factory](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/C_FactoryDesignPattern) | Interface-based object creation logic. |
| **D** | [Abstract Factory](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/D_AbstractFactoryDesignPattern) | Creating families of related or dependent objects. |
| **E** | [Chain of Responsibility](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/E_ChainResponsibilityDesignPattern) | Passing requests along a chain of handlers. |
| **F** | [Proxy](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/F_ProxyDesignPattern) | Controlling access to an object (Lazy loading, Protection). |
| **G** | [Null Object](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/G_NullObjectDesignPattern) | Handling null references gracefully with default behavior. |
| **H** | [State](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/H_StateDesignPattern) | Altering object behavior when its internal state changes. |
| **I** | [Composite](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/I_CompositeDesignPattern) | Tree structures of objects (Part-Whole hierarchy). |
| **J** | [Adapter](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/J_AdapterDesignPattern) | Bridging incompatible interfaces to work together. |
| **K** | [Builder](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/K_BuilderDesignPattern) | Step-by-step construction of complex objects. |
| **L** | [Facade](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/L_FacadeDesignPattern) | Simplified interface to a complex subsystem. |
| **M** | [Bridge](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/M_BridgeDesignPattern) | Decoupling abstraction from its implementation. |
| **N** | [Flyweight](https://github.com/AvinashDogiparthi/LowLevelDesign/tree/main/LLDandDesingPatterns/src/B_DesignPatterns/N_FlyweightDesignPattern) | Efficient sharing of objects to reduce memory load. |

---

## Low Level Designs (LLD)

Real-world low-level design problems often asked in technical interviews.

| Code | System / Problem | Key Concepts / Description |
| :--- | :--- | :--- |
| **C** | [Parking Lot](LLDandDesingPatterns/src/CA_ParkingLotDesign_V2) | Multi-floor parking management, Ticket generation, Spot allocation. |
| **CA** | [Producer Consumer](LLDandDesingPatterns/src/CA_ProducerConsumerDesign) | Multi-threading, Blocking Queues, Concurrency control. |
| **D** | [Tic Tac Toe](LLDandDesingPatterns/src/D_TicTacToeLLD) | Game loop, Board management, Player strategies. |
| **E** | [Car Rental System](LLDandDesingPatterns/src/E_CarRentalSystem) | Inventory management, Booking reservations, Store locations. |
| **F** | [Snake & Ladder](LLDandDesingPatterns/src/F_SnakeAndLadder) | Game entities (Board, Dice, Player), Movement logic. |
| **G** | [BookMyShow](LLDandDesingPatterns/src/G_BookMyShow_V2) | Movie ticketing, Theater seating, Concurrency handling for booking. |
| **H** | [Vending Machine](LLDandDesingPatterns/src/H_VendingMachineDesign) | State Pattern implementation (Idle, Selection, Dispense). |
| **I** | [ATM Design](LLDandDesingPatterns/src/J_ATMDesign) | State Pattern, Transaction handling, Cash dispensing chain. |
| **J** | [File System](LLDandDesingPatterns/src/K_FileSystemDesign) | Composite Pattern, Command Pattern for file operations. |
| **K** | [Calculator](LLDandDesingPatterns/src/I_SimpleArithmeticCalculator) | Basic arithmetic operations and expression evaluation. |
| **--** | [Logger](LLDandDesingPatterns/src/LoggerDesign) | Chain of Responsibility, Log levels, Appenders. |
| **M** | [Uber/Ride Sharing](LLDandDesingPatterns/src/M_UberDesign) | Driver matching strategies, Trip management, Pricing. |
| **N** | [Zepto/Quick Commerce](LLDandDesingPatterns/src/N_ZeptoStoreDesign) | Inventory, Order management, Delivery assignment strategies. |
| **O** | [CultFit/Gym](LLDandDesingPatterns/src/O_CultFitDesign) | Workout scheduling, Slot booking, Center management. |
| **P** | [Twitter/Social](LLDandDesingPatterns/src/P_TwitterDesign) | User graph, News feed generation, Posting, Following. |
| **Q** | [Swiggy/Food Delivery](LLDandDesingPatterns/src/Q_SwiggyDesign) | Restaurant menu, Order processing, Coupons & Discounts. |
| **R** | [Issue Resolver](LLDandDesingPatterns/src/R_IssueResolvingSystem) | Ticketing system, Agent assignment, Strategy pattern. |
| **S** | [Text Editor](LLDandDesingPatterns/src/S_TextEditorDesign) | Flyweight pattern for characters, Formatting, Undo/Redo stack. |
| **T** | [Meeting Scheduler](LLDandDesingPatterns/src/T_MeetingScheduler) | Calendar slot availability, Invite management (Microsoft Teams style). |
| **U** | [Flight Booking](LLDandDesingPatterns/src/U_FlightBookingManagement) | Airline inventory, Seat selection, Booking status, Search. |
| **V** | [Hotel Management](LLDandDesingPatterns/src/V_HotelManagementSystem) | Room booking, Guest management, Service allocation. |

---

## 🚀 How to Run

Follow these steps to get the project up and running on your local machine.

### 1. Prerequisites
Ensure you have the following installed:
* **Java JDK**: Version 17+ (Verify with `java -version`)
* **Maven**: Version 3.6+ (Verify with `mvn -version`)
* **IDE**: IntelliJ IDEA (Recommended), Eclipse, or VS Code.

### 2. Setup
```bash
# Clone the repository
git clone [https://github.com/AvinashDogiparthi/LowLevelDesign.git](https://github.com/AvinashDogiparthi/LowLevelDesign.git)

# Navigate to project directory
cd LowLevelDesign
```

---

## 🤝 Contributing

Contributions are welcome! Whether it's fixing a bug, improving documentation, or adding a new design pattern implementation, your help is appreciated.

1.  **Fork** the repository.
2.  Create a new branch (`git checkout -b feature/AmazingFeature`).
3.  **Commit** your changes (`git commit -m 'Add some AmazingFeature'`).
4.  **Push** to the branch (`git push origin feature/AmazingFeature`).
5.  Open a **Pull Request**.

Please feel free to open [Issues](https://github.com/AvinashDogiparthi/LowLevelDesign/issues) for improvements or suggestions.

---

## ❤️ Support

If you find this repository helpful or use it for your learning, please give it a **Star** ⭐! Your support encourages the creation of more comprehensive guides and design implementations.

---

## 📧 Contact

For any queries, feedback, or discussions regarding Low Level Design:

* **Email**: dnvavinash@gmail.com
* **LinkedIN**: [click here](https://www.linkedin.com/in/avinash-dogiparthi-5a6323189/)

Feel free to reach out via GitHub for any collaborations!

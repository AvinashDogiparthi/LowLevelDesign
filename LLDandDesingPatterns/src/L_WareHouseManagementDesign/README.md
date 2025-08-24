# 📦 Warehouse Management System (LLD)

## 📘 Overview
This project implements a **Warehouse Management System** where packages can be assigned and stored in **lockers** based on their size.  
The design ensures that packages are placed in the most suitable locker and allows efficient assignment, un-assignment, and management of lockers.

---

## 🎯 Key Features
- **Singleton Design Pattern**
    - The `WareHouse` class follows the Singleton pattern to ensure only one warehouse instance is active at a time.

- **Locker Management**
    - Create, update, and delete lockers.
    - Each locker is associated with a **size** (`PackageSizeEnum`).

- **Package Assignment**
    - Assign a package to the first available locker of matching size.
    - Maintain bi-directional mapping between **Locker ↔ Package** for fast lookups.

- **Package Un-assignment**
    - Unassign a package from its allocated locker.
    - Frees up the locker for future usage.

- **Error Handling**
    - Handles cases where no locker is available for the requested package size.
    - Prevents un-assigning a package that was never assigned.

---

## 🏗️ Design Components

### 1. **WareHouse**
- Singleton entry point for managing lockers and packages.
- Maintains two maps:
    - `lockerVsPackageMap` → Which package is stored in which locker.
    - `packageVsLockerMap` → Reverse lookup from package to locker.

### 2. **LockerService**
- Service responsible for **locker-level operations**:
    - Creating, updating, deleting lockers.
    - Fetching available locker for a given size.
    - Assigning / un-assigning packages from lockers.

### 3. **Locker**
- Represents a physical locker in the warehouse.
- Identified by a **lockerId** and linked to a **PackageSizeEnum**.

### 4. **Package**
- Represents a package that needs to be stored.
- Identified by a **packageId** and a **packageSizeEnum**.

### 5. **PackageSizeEnum**
- Enum defining package sizes (e.g., `SMALL`, `MEDIUM`, `LARGE`).
- Used to match packages with appropriate lockers.

---

## 📂 Class Responsibilities

- **`WareHouse`**
    - Singleton orchestrator for warehouse operations.
    - Manages locker-package assignments.

- **`LockerService`**
    - Handles low-level locker CRUD and allocation logic.

- **`Locker`**
    - Encapsulates locker details.

- **`Package`**
    - Encapsulates package details.

---

## ⚙️ Example Flow

### 1. Create Lockers
```java
WareHouse wareHouse = WareHouse.getInstance();
wareHouse.createLocker(1, PackageSizeEnum.SMALL);
wareHouse.createLocker(2, PackageSizeEnum.LARGE);

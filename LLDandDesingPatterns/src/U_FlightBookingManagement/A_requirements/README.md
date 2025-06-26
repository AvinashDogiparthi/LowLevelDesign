# ✈️ Flight Booking Service – Low-Level Design (LLD)

This module is part of a larger **Flight Booking Management System**, focused on handling core airline operations such as seat management, pricing updates, and user-based booking flows. It leverages object-oriented principles and a singleton service class to encapsulate all flight-related operations.

---

## 🧩 Class: `FlightBookingService`

`FlightBookingService` is a **singleton class** that acts as the entry point for managing flights, booking seats, updating flight configurations, and handling cancellations.

---

## ✅ Key Responsibilities

- Create and manage flight routes
- Add/remove seats to flights
- Book and cancel seats for users
- Update flight metadata and fare prices

---

## ⚙️ Exposed Methods & Functionality

### 🔧 Flight Lifecycle

#### `establishANewFlightConnection(...)`
- Initializes a new flight with given seat prices and route details
- Prevents duplicate creation via internal flight map

#### `updateFlightOriginStation(...)`, `updateFlightDestinationStation(...)`
- Allows changing a flight’s origin or destination station post-creation

---

### 💺 Seat Inventory Management

#### `addSeatInFlight(flightID, seatID, seatCategoryEnum)`
- Adds a seat of specific category (Economy, Business, Premium) to a flight

#### `removeSeatFromFlight(flightID, seatID)`
- Removes a seat from a flight’s inventory by seat ID

---

### 📦 Booking Flow

#### `bookSeat(flightID, user, seatCategoryEnum)`
- Books an available seat in the selected fare class for the user
- Returns the booked `Seat` object if successful

#### `cancelBooking(flightID, user, seatID)`
- Cancels a booking for a specific seat, releasing it back into the inventory

---

### 💰 Fare Management

#### `updateEconomySeatPrice(...)`
#### `updateBusinessSeatPrice(...)`
#### `updatePremiumSeatPrice(...)`
- Dynamically updates seat pricing for each fare class on a specific flight

---

## 🧠 Design Highlights

- **Singleton Pattern** used for centralized booking coordination
- **Encapsulation** of seat operations via internal `Flight` object delegation
- **Enum-based design** for `SeatCategoryEnum` ensures clarity and type safety
- **Thread-safe instantiation** for the service using synchronized `getInstance()`

---

## 🗂 Directory Structure


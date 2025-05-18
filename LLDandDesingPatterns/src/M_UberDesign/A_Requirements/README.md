# 🚖 Uber-like Ride-Hailing System

This repository contains the design and implementation of an **Uber-like Ride-Hailing System**, supporting multiple cities, dynamic ride allocation, real-time cab management, and seamless payment processing.

---

## 📌 **Table of Contents**
- [Introduction](#introduction)
- [Problem Statement](#problem-statement)
- [System Design Overview](#system-design-overview)
- [Key Functionalities](#key-functionalities)
- [Cab Management](#cab-management)
- [Ride Management](#ride-management)
- [Payment Processing](#payment-processing)
- [Scalability and Optimizations](#scalability-and-optimizations)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)

---

## 🚦 **Introduction**
The **Uber-like Ride-Hailing System** is a scalable and flexible platform that allows users to book rides from multiple cities. The system efficiently allocates the nearest available cab to the user, manages the ride lifecycle, and processes payments seamlessly.

---

## 📌 **Problem Statement**
Design a ride-hailing system that allows:
- Users to request rides in multiple cities.
- Real-time allocation of the nearest available cab.
- Payment processing for rides.
- Dynamic cab management (location updates, availability).
- Secure and scalable architecture.

---

## ✅ **System Design Overview**
### ✅ **Architecture:**
- **User Management:** Handles user registration, ride history, and wallet balance.
- **Cab Management:** Manages cab details (driver, location, availability).
- **Ride Management:** Manages ride creation, progress, completion, and cancellation.
- **Payment Processing:** Manages ride payment from the user’s wallet.

### ✅ **Data Structures:**
- **Cab Map:**
    - Key: City Name
    - Value: List of available cabs
- **Ride Map:**
    - Key: Ride ID
    - Value: Ride object (rider, cab, start and end locations, ride status)
- **User Wallet:** Stores the user’s available cash for rides.

---

## ✅ **Key Functionalities**
### ✅ **1. User Management:**
- Users can:
    - Register an account.
    - Maintain a wallet balance.
    - View ride history.

### ✅ **2. Cab Management:**
- Cabs have the following attributes:
    - **Vehicle Number**
    - **Driver (Name and ID)**
    - **Current Location (Coordinates)**
    - **Availability Status**
    - **City (Bangalore, Chennai, etc.)**
- Cabs are assigned to cities and can only serve within their city.
- Nearest cab allocation is based on distance calculation.

### ✅ **3. Ride Management:**
- Riders can:
    - Request a ride by specifying start and end locations.
    - The nearest available cab is assigned.
    - Ride cost is calculated based on distance.
    - Ride is automatically completed and charged once the destination is reached.

### ✅ **4. Payment Processing:**
- Ride cost is calculated as:

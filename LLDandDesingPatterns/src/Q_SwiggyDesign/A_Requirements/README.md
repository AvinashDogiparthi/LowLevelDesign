# 🚀 Food Delivery System

This repository contains the design and implementation of a **Food Delivery System**. It is a comprehensive solution for managing food orders, restaurant interactions, customer profiles, and delivery management.

---

## 📌 **Table of Contents**
- [Introduction](#introduction)
- [Requirements](#requirements)
- [Features](#features)
- [System Design](#system-design)
- [Modules and Functionalities](#modules-and-functionalities)
---

## 🚦 **Introduction**
The **Food Delivery System** is designed to provide a complete solution for managing a food delivery service. It facilitates the interaction of restaurants, customers, and delivery agents with a central admin, ensuring smooth and efficient order processing.

---

## 📌 **Requirements**
The system is designed to cater to the following requirements:

### ✅ **Restaurant Management**
- Restaurants can register themselves on the platform.
- Restaurants can manage (add/update) their food menu.

### ✅ **User Management**
- Users can create, update, delete, and view their profiles.
- Users can search for restaurants using:
    - Restaurant name.
    - City name.

### ✅ **Menu Management**
- Users can view the food menu of restaurants.
- Users can filter food items based on:
    - Meal Type (Breakfast, Lunch, Dinner).
    - Cuisine Type (Indian, Chinese, Italian, etc.).

### ✅ **Cart Management**
- Users can:
    - Add items to the cart.
    - Remove items from the cart.
    - View all items in the cart.

### ✅ **Order Management**
- Users can:
    - Place an order.
    - Cancel an order.
    - View their order history.
    - Get the current status of any order (e.g., Ordered, Out for Delivery, Delivered).

### ✅ **Coupon Management**
- Users can:
    - Apply coupons to their orders.
    - Get a detailed bill with tax calculations.

### ✅ **Payment Management**
- Users can make payments using various modes:
    - Credit Card.
    - Wallet.
    - UPI, etc.

### ✅ **Delivery Management**
- Delivery agents can:
    - View all deliveries assigned to them using their ID.
    - Get the delivery status.

---

## ⚡ **System Design**
The system follows a modular and scalable architecture, ensuring efficient handling of user interactions, order processing, and delivery management.

### **Key Components:**
1. **User Module:** Manages user registration, profile, and authentication.
2. **Restaurant Module:** Handles restaurant registration and menu management.
3. **Menu Module:** Manages food items and categories.
4. **Cart Module:** Manages user cart interactions.
5. **Order Module:** Handles order placement, cancellation, and tracking.
6. **Coupon Module:** Manages discount coupons and bill calculations.
7. **Payment Module:** Facilitates multiple payment methods.
8. **Delivery Module:** Manages delivery assignments and status tracking.

---

## 🚀 **Modules and Functionalities**

### ✅ **User Module**
- User Registration, Login, and Profile Management.
- Search for restaurants by name or city.

### ✅ **Restaurant Module**
- Restaurant Registration and Menu Management.
- Add, update, and manage food items.

### ✅ **Menu Module**
- Display available food items to users.
- Filter items based on Meal Type or Cuisine Type.

### ✅ **Cart Module**
- Add and remove items from the cart.
- View cart items and total price.

### ✅ **Order Module**
- Place an order with selected items.
- Cancel existing orders.
- Track order status.

### ✅ **Coupon Module**
- Apply discount coupons to the order.
- Calculate and display the bill with tax details.

### ✅ **Payment Module**
- Make payments using multiple modes (Credit Card, Wallet, UPI).
- Secure and seamless payment process.

### ✅ **Delivery Module**
- Delivery agents can view their assigned deliveries.
- Update delivery status (Out for Delivery, Delivered).

---

## 🛠️ **Design patterns used **
    - Strategy (for payment processing).
    - Decorator (for coupon application).
    - Singleton (for service instances).
    - Builder


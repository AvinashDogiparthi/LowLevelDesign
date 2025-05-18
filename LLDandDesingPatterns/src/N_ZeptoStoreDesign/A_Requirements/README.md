# 🚀 Zepto-like Grocery Delivery System

This repository contains the design and implementation of a **Zepto-like Grocery Delivery System**, designed for efficient and flexible order fulfillment using multiple warehouse selection strategies. It allows users to manage their carts, place orders, and receive deliveries efficiently.

---

## 📌 **Table of Contents**
- [Introduction](#introduction)
- [Problem Statement](#problem-statement)
- [System Design Overview](#system-design-overview)
- [Key Functionalities](#key-functionalities)
- [Warehouse Selection Strategies](#warehouse-selection-strategies)
- [Product Management](#product-management)
- [Cart Management](#cart-management)
- [Order Management](#order-management)
- [Scalability and Optimizations](#scalability-and-optimizations)
- [Technologies Used](#technologies-used)

---

## 🚦 **Introduction**
The **Zepto-like Grocery Delivery System** is a scalable platform that allows users to shop for groceries using a multi-warehouse selection strategy. Users can create a cart, choose their preferred warehouse strategy, and receive deliveries efficiently. The system is designed to automatically split orders across multiple warehouses if items are unavailable in the chosen warehouse.

---

## 📌 **Problem Statement**
Design a grocery delivery system with the following requirements:
- Users can select groceries and manage their cart.
- Users can choose their warehouse selection strategy:
    - **Nearest Warehouse**: Select the warehouse closest to the user.
    - **Warehouse with Complete Inventory**: Select the warehouse with all items in stock.
- If the chosen warehouse does not have all items:
    - The order is split, and items are fetched from other warehouses.
- Once items are delivered, they are removed from the warehouse inventory.

---

## ✅ **System Design Overview**
### ✅ **Architecture:**
- **User Management:** Handles user registration, cart management, and order history.
- **Product Management:** Manages product inventory in multiple warehouses.
- **Warehouse Management:** Manages warehouse details, including available inventory.
- **Order Management:** Handles order creation, splitting, processing, and delivery.

### ✅ **Data Structures:**
- **User Map:**
    - Key: User ID
    - Value: User object (name, cart, order history)
- **Product Map:**
    - Key: Product ID
    - Value: Product object (name, price, stock count)
- **Warehouse Map:**
    - Key: Warehouse ID
    - Value: Warehouse object (location, available products)
- **Order List:** List of all orders placed by users.

---

## ✅ **Key Functionalities**
### ✅ **1. User Cart Management:**
- Users can add products to their cart.
- Users can update product quantities in their cart.
- Users can remove products from their cart.

### ✅ **2. Product Management:**
- Products have the following attributes:
    - **Product ID** (unique identifier)
    - **Name**
    - **Price**
    - **Stock (in each warehouse)**

### ✅ **3. Warehouse Selection Strategies:**
- Users can choose how their order is fulfilled:
    - **Nearest Warehouse Strategy:** Orders are fulfilled from the closest warehouse to the user.
    - **Complete Inventory Warehouse Strategy:** Orders are fulfilled from a warehouse that has all the required items.
- If the chosen warehouse cannot fulfill the entire order:
    - The order is split across multiple warehouses.
    - Users receive multiple deliveries (one from each warehouse).

### ✅ **4. Order Management:**
- Orders are created from the user’s cart.
- Orders are processed based on the selected warehouse strategy.
- If an order is split, separate orders are created for each warehouse.
- Once an order is delivered, the product quantities are deducted from the warehouse inventory.

### ✅ **5. Inventory Management:**
- Warehouse inventory is automatically updated after order delivery.
- If a product’s stock is depleted in a warehouse, it is marked as unavailable.

---

## ✅ **Warehouse Selection Strategies**
### ✅ **1. Nearest Warehouse Strategy:**
- The system selects the warehouse closest to the user.
- If the nearest warehouse does not have all items:
    - The order is split into two:
        - One for the nearest warehouse (available items).
        - One for another warehouse (remaining items).

### ✅ **2. Complete Inventory Warehouse Strategy:**
- The system selects a warehouse that has all items in the user’s cart.
- If no such warehouse is found:
    - The order is split across multiple warehouses.

---

## ✅ **Product Management**
- Products have the following attributes:
    - **Product ID:** Unique identifier for each product.
    - **Product Name:** The name of the product (e.g., "Apple").
    - **Price:** The cost of the product.
    - **Stock:** The quantity available in each warehouse.

### ✅ **Product Lifecycle:**
- Products are stored in warehouses.
- Once an order is delivered, the product stock is deducted from the warehouse inventory.

---

## ✅ **Cart Management**
- Users can add products to their cart.
- Users can update quantities or remove items.
- Users can view their current cart before placing an order.

### ✅ **Cart Operations:**
- `Add Product`: Add a product to the cart.
- `Update Quantity`: Change the quantity of an existing product.
- `Remove Product`: Remove a product from the cart.

---

## ✅ **Order Management**
- Orders are created from the user’s cart.
- Based on the selected warehouse strategy, the order is processed:
    - If the warehouse can fulfill the order, a single order is created.
    - If not, the order is split into multiple orders.
- Orders are marked as delivered once processed, and inventory is deducted from the warehouse.

### ✅ **Order Splitting Example:**
1. User selects "Nearest Warehouse Strategy".
2. Nearest warehouse has 2 out of 3 items in stock.
3. The order is split:
    - Order 1: 2 items from the nearest warehouse.
    - Order 2: 1 item from another warehouse.

---

## ✅ **Scalability and Optimizations**
- The system is designed to scale with multiple warehouses and users.
- Inventory management is optimized using HashMap for constant time access.
- Order splitting is efficiently handled using the selected warehouse strategy.
- Can be easily extended to support dynamic warehouse addition.

---

## 🛠️ **Technologies Used**
- **Programming Language:** Java
- **Data Structures:** HashMap, ArrayList
- **Design Patterns:**
    - Strategy (for warehouse selection).
    - Singleton (for central inventory management).
- **Architecture:** Modular and scalable.

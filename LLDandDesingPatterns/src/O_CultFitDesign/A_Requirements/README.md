# 🚀 Gym Slot Booking System

This repository contains the design and implementation of a **Gym Slot Booking System**, a scalable and efficient platform that allows both admins and customers to manage gym slots. It includes user differentiation, automatic waitlist management, and real-time slot availability.

---

## 📌 **Table of Contents**
- [Introduction](#introduction)
- [Problem Statement](#problem-statement)
- [System Design Overview](#system-design-overview)
- [User Roles and Permissions](#user-roles-and-permissions)
- [Functional Requirements](#functional-requirements)
- [Waitlist Management](#waitlist-management)

---

## 🚦 **Introduction**
The **Gym Slot Booking System** is a platform that allows users to book and manage gym slots. The system supports two user roles: **Admin** and **Customer**, with distinct permissions for each. It also provides a **waitlist queue** to ensure users get notified and automatically booked if slots become available.

---

## 📌 **Problem Statement**
Design a system to manage gym slot bookings with the following requirements:
- Users should be differentiated as **Admins** and **Customers**.
- A **waitlist queue** should be implemented for customers:
    - Customers will be notified and automatically booked if a slot becomes available.
- Real-time display of **slot availability** should be provided.

---

## ✅ **System Design Overview**
### ✅ **Architecture:**
- **User Management:** Differentiates between Admin and Customer roles.
- **Slot Management:** Admins can create, update, cancel, and manage gym slots.
- **Booking Management:** Customers can book and cancel slots.
- **Waitlist Management:** Customers who cannot book immediately are added to a waitlist.
- **Notification System:** Automatically notifies customers and books slots if they become available.

### ✅ **Data Structures:**
- **User Map:**
    - Key: User ID
    - Value: User object (role, name, bookings)
- **Slot Map:**
    - Key: Slot ID
    - Value: Slot object (time, capacity, booked count)
- **Waitlist Queue:**
    - A queue of customers waiting for each slot.

---

## ✅ **User Roles and Permissions**
### **1. Admin:**
- Can register new gyms.
- Can add, update, and delete workout slots.
- Can cancel slots.
- Can book slots (just like a customer).

### **2. Customer:**
- Can book available slots.
- Can cancel their bookings.
- Can view available slots.
- Can be added to a waitlist if slots are full.

---

## ✅ **Functional Requirements**
### ✅ **1. Slot Management (Admin):**
- Admins can register gyms and create slots for different workouts.
- Admins can update slot details (time, capacity).
- Admins can cancel any slot.
- Admins can book slots for themselves.

### ✅ **2. Slot Booking (Customer):**
- Customers can view available slots.
- Customers can book a slot if it is available.
- If the slot is full, the customer is added to a waitlist.
- Customers can cancel their bookings.

### ✅ **3. Waitlist Management:**
- A waitlist queue is maintained for each slot.
- If a booked slot is canceled, the first customer in the waitlist is automatically notified and booked.
- Customers are notified in real-time when they get a slot.

### ✅ **4. Display Availability:**
- Customers can view the list of all available slots.
- Each slot displays:
    - Workout type
    - Timing
    - Total capacity
    - Available spots
    - Waitlist count (if applicable)

---

## ✅ **Waitlist Management**
- A **Waitlist Queue** is maintained for each slot.
- If a slot is full:
    - Customers trying to book are added to the waitlist.
    - The queue is managed on a **First-Come, First-Serve (FCFS)** basis.
- Automatic booking is triggered:
    - When an existing booking is canceled, the first customer in the waitlist is booked.
- Real-time notifications:
    - Customers in the waitlist are notified if they are automatically booked.


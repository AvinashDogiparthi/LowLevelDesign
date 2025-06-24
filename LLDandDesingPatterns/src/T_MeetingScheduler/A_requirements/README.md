# 🗓️ Meeting Room Scheduler - Low Level Design

This project demonstrates the **Low-Level Design (LLD)** of a simple yet scalable **Meeting Room Scheduler System** using core OOP principles and modular design. It manages room bookings with features like time slot handling, participant notifications, and slot ownership control.

---

## ✅ Features Covered

### 1. **Multiple Meeting Rooms**
- Supports configuration of multiple rooms.
- Each room is identified by a unique `meetingRoomID`.

### 2. **Daily Time Slots**
- Each room has **24 hourly time slots (0–23)** for any given day.
- Slots are managed per date using the `date` parameter (e.g., "2025-06-24").

### 3. **Slot Booking Logic**
- A user (the `slotManager`) can book a slot by specifying:
    - Meeting date
    - Starting time (`fromTime`)
    - Slot ID (`meetingSlotID`)
    - Room ID (`meetingRoomID`)
    - List of participants

- A slot can only be booked if:
    - The room exists
    - The slot ID is valid
    - The slot is not already occupied

### 4. **Slot Manager Privileges**
- The user who books a slot becomes the **Slot Manager**.
- Only the Slot Manager can:
    - Cancel the meeting
    - Reschedule the meeting to another time

### 5. **Notifications**
- Once a meeting is booked, **all participants are notified** about:
    - Slot timing
    - Room ID
    - Meeting manager

### 6. **Availability Checker**
- Exposed an interface to fetch **all available slots** for a given room and date.

---

## 🧱 Core Classes

- `MeetingRoom`
- `MeetingSlot`
- `User`
- `MeetingRoomService`

---

## 📦 Example API

```java
public boolean bookASlotInMeetingRoom(
    User meetingManager,
    List<User> participantsList,
    String date,
    int fromTime,
    int meetingSlotID,
    int meetingRoomID
)

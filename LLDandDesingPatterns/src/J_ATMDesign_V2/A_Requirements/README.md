# ATM Machine Design (LLD) - Version 2

This project is a **Low-Level Design (LLD)** implementation of an **ATM (Automated Teller Machine)** system using Object-Oriented Programming principles and the **State Design Pattern**. The design handles real-world ATM behavior through a sequence of state transitions and user interactions.

---

## ✅ Requirements Covered

### 🎯 Functional Requirements
1. **Card Insertion**
    - Accepts user card and initiates ATM session.

2. **PIN Validation**
    - Verifies the entered PIN against the stored PIN.

3. **Transaction Type Selection**
    - Supports the following transaction types:
        - `SHOW_BALANCE`
        - `WITHDRAW`
        - `DEPOSIT`

4. **Show Balance**
    - Displays the current balance to the user.

5. **Withdraw Money**
    - Dispenses cash and updates the user's account balance.

6. **Deposit Money**
    - Accepts a map of currency notes and adds to the user's account balance.

7. **Collect Card**
    - Ends the session and ejects the card.

---

### 🚫 Unauthorized Actions Prevention
The design strictly enforces **valid state transitions**, e.g.:
- Cannot perform withdrawal or deposit **without inserting a card and validating PIN.**
- Cannot call `showBalance()` before selecting a valid transaction type.
- Operations attempted in the wrong state are gracefully rejected.

---

## 🏗️ Design Highlights

### 🧠 Design Pattern Used: **State Design Pattern**
Each ATM state is represented as a separate class implementing a common interface:
- `IdleState`
- `HasCardState`
- `PinEnteredState`
- `TransactionSelectedState`
- `CashDispensedState`

This allows easy maintenance, better extensibility, and clear separation of responsibilities per state.

### 🔁 Transitions
The `ATM` context holds a reference to the current state. Actions are delegated to the state object, which decides the next state based on the action and internal logic.

---

## 🧪 Test Cases in Main
The `Main.java` demonstrates the following test scenarios:

| Case | Description | Expected Outcome |
|------|-------------|------------------|
| 1 | Call `showBalance()` directly | Fails – unauthorized in Idle state |
| 2 | Insert card → enter PIN → select `SHOW_BALANCE` → show balance → collect card | Success |
| 3 | Call `withdrawMoney()` directly | Fails – unauthorized in Idle state |
| 4 | Insert card → enter PIN → select `WITHDRAW` → withdraw → collect card | Success |
| 5 | Call `depositMoney()` directly | Fails – unauthorized in Idle state |
| 6 | Insert card → enter PIN → select `DEPOSIT` → deposit → collect card | Success |

---

## 🧾 Components

- `ATM` – Context class managing the current state.
- `ATMState` – Interface defining supported ATM actions.
- `Card` – Represents a user card with card number, expiry, PIN, and holder name.
- `UserBankAccount` – Represents the bank account and current balance.
- `TransactionTypeEnum` – Enum for transaction types.
- `CurrencyNotesEnum` – Enum for denomination values.

---

## 📦 Future Enhancements

- Add support for receipt printing.
- Limit number of PIN attempts.
- Integrate a transaction history module.
- Simulate ATM cash note dispensing with limits.



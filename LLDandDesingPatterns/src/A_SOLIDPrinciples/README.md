# SOLID Principles: A Practical Guide

> **Core Philosophy:** SOLID principles aren’t about perfect code. They’re about keeping systems maintainable as they grow. Think of them as guardrails that make refactoring feel less like surgery and more like editing.

## What You'll Learn
* What each principle actually means.
* Real code examples (Bad vs. Good).
* When to apply them (and when not to).
* How to detect "code smells."

---

## The 5 Principles

## 1. S — Single Responsibility Principle (SRP)
**The Rule:** A class should have one, and only one, reason to change.

#### ❌ The Problem
The `InvoiceService` handles logic, database operations, and email notifications.
* *Changes to tax rules?* Edit `InvoiceService`.
* *Switching DBs?* Edit `InvoiceService`.
* *Email config?* Edit `InvoiceService`.

```java
public class InvoiceService {
    public void createInvoice(Invoice invoice) {
        // 1. Validate
        if (invoice.getItems().isEmpty()) throw new IllegalArgumentException("No items");
        
        // 2. Calculate pricing
        BigDecimal tax = subtotal.multiply(new BigDecimal("0.18"));
        
        // 3. Save to database
        jdbcTemplate.update("INSERT INTO invoices...", ...);
        
        // 4. Send email
        emailClient.send(invoice.getCustomerEmail(), "Invoice Created");
    }
}
```

#### ✅ The Solution 
Delegate responsibilities to dedicated classes.

```java
public class InvoiceService {
    private final InvoiceValidator validator;
    private final InvoiceCalculator calculator;
    private final InvoiceRepository repository;
    private final NotificationSender notificationSender;
    
    public void createInvoice(Invoice invoice) {
        validator.validate(invoice);
        calculator.calculateTotals(invoice);
        repository.save(invoice);
        notificationSender.sendInvoiceCreated(invoice);
    }
}
```

When to apply :
* Class exceeds 300 lines. 
* Class name contains generic terms like "Manager", "Handler", or "Util". 
* Changes in one area break unrelated tests.

---


## 2. O — Open/Closed Principle (OCP)
**The Rule:** Open for extension, closed for modification. Add new features by creating new classes, not editing old ones.

#### ❌ The Problem
Adding PLATINUM tier means editing this method. Every change risks breaking existing discounts.

```java
public class DiscountService {
    public BigDecimal applyDiscount(Customer customer, BigDecimal price) {
        if (customer.getTier() == Tier.GOLD) {
            return price.multiply(new BigDecimal("0.8"));
        } else if (customer.getTier() == Tier.SILVER) {
            return price.multiply(new BigDecimal("0.9"));
        } else if (customer.getTier() == Tier.STUDENT) {
            return price.multiply(new BigDecimal("0.85"));
        }
        return price;
    }
}
```

#### ✅ The Solution
Delegate responsibilities to dedicated classes.

![img.png](img.png)
```java
public interface DiscountPolicy {
    BigDecimal apply(Customer customer, BigDecimal price);
}

public class GoldDiscountPolicy implements DiscountPolicy {
    public BigDecimal apply(Customer customer, BigDecimal price) {
        return price.multiply(new BigDecimal("0.8"));
    }
}
```

![img_1.png](img_1.png)
```java
public class DiscountService {
    private final Map<Tier, DiscountPolicy> policies;
    
    public BigDecimal applyDiscount(Customer customer, BigDecimal price) {
        DiscountPolicy policy = policies.get(customer.getTier());
        return policy.apply(customer, price);
    }
}
```

**Add a new tier?**  Just create PlatinumDiscountPolicy. DiscountService never changes.

When to apply :
* You have lots of if/else or switch statements based on types.
* You frequently add new variants of logic.
* You need a plugin architecture.
---

## 3. L — Liskov Substitution Principle (LSP)
**The Rule:** Subtypes must be substitutable for their base types. If code expects a Parent, giving it a Child shouldn't break anything.

#### ❌ The Mistake
A Square is not a Rectangle in programming because changing width doesn't automatically change height in a Rectangle, but it must in a Square.

```java
Rectangle rect = new Square();
rect.setWidth(5);
rect.setHeight(4);
// FAILS! Area is 16 (4*4), expected 20.
assert rect.getArea() == 20;
```

#### ✅ The Solution
Use a common interface (Shape) rather than inheritance if behavior differs.

```java
public interface Shape {
    double area();
}

public class Rectangle implements Shape {  }
public class Square implements Shape {  }
```





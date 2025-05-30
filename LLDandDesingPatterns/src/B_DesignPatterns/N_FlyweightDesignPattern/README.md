# Flyweight Design Pattern

The **Flyweight Pattern** is a structural design pattern that helps reduce memory usage by sharing objects that are similar in nature. It achieves this by separating shared data (intrinsic) from unique data (extrinsic), allowing multiple objects to reference a single shared instance.

---

## 🧠 When to Use the Flyweight Pattern

You should consider using the Flyweight Pattern in the following scenarios:

---

### 1. 🚫 Limited Memory Availability

#### ✅ Problem:
Creating a large number of similar objects consumes a lot of memory, especially if most of their data is identical.

#### 🛠️ How Flyweight Solves It:
- Stores shared (intrinsic) data once and reuses it.
- Only extrinsic data (unique per object) is passed at runtime.
- Greatly reduces the number of full object instances in memory.

**Example:**
In a video game, if there are 100,000 trees with the same shape and texture but different positions, the Flyweight pattern lets you store a single `TreeType` object (intrinsic) and reuse it with different coordinates (extrinsic).

---

### 2. 🔄 Shared Object Data (Intrinsic vs Extrinsic)

#### ✅ Problem:
You need to manage many objects that differ only slightly, such as by position, size, or style.

#### 🛠️ How Flyweight Solves It:
- Splits the object into:
    - **Intrinsic state**: Common data shared among objects.
    - **Extrinsic state**: Context-specific data passed at runtime.
- This allows you to cache and reuse intrinsic objects, reducing overall object creation.

**Example:**
In a text editor, the character `'A'` appears many times. Instead of storing thousands of separate `'A'` objects, store one `'A'` flyweight with font data and pass its position and color as extrinsic properties.

---

### 3. 🏗️ Expensive Object Creation

#### ✅ Problem:
Instantiating a large number of complex objects is computationally expensive and time-consuming.

#### 🛠️ How Flyweight Solves It:
- Creates each heavy object (flyweight) only once.
- Reuses these shared instances wherever needed.
- Delegates variable behavior via extrinsic data, avoiding repeated instantiation costs.

**Example:**
In a CAD application, rendering thousands of bolts or gears is costly. With Flyweight, the gear model is created once and reused at different coordinates with transformations applied externally.

---

## 🧬 Summary Table

| Scenario                       | Problem                                              | Flyweight Solution                                         |
|-------------------------------|------------------------------------------------------|------------------------------------------------------------|
| **Limited memory**            | Too many similar objects consume memory             | Reuse shared intrinsic data across instances               |
| **Shared object data**        | Redundant storage of identical data                 | Separate shared (intrinsic) and unique (extrinsic) state   |
| **Expensive object creation** | Object creation is slow and resource-heavy          | Cache and reuse existing objects instead of recreating     |

---

## 📌 Key Concepts

- **Intrinsic State**: Shared, immutable data (e.g., shape, color, model)
- **Extrinsic State**: Unique per use-case, passed in externally (e.g., position, scale)
- **Flyweight Factory**: Manages the pool of flyweight instances and returns reused objects

---

## ✅ Benefits

- Reduces memory footprint significantly
- Improves performance in applications requiring many similar objects
- Encourages reuse and centralization of shared data

---

## ⚠️ Drawbacks

- Increased complexity due to intrinsic/extrinsic separation
- Requires careful design to manage shared vs non-shared state
- Not beneficial if objects don’t share enough common data

---

## 📎 Example Use Cases

- Text rendering (characters reuse font information)
- Game development (trees, rocks, bullets reuse models/textures)
- UI toolkits (buttons with common styles)
- CAD software (repeating geometric shapes)

---

> 🧠 Tip: Profile your application before applying Flyweight. It's most useful when memory or object creation cost is a proven bottleneck.

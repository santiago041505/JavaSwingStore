# Simple Store Management System (Java Swing Architecture)

A lightweight, local desktop retail application built using Java Swing. This project demonstrates basic graphical user interface (GUI) interactions, state persistence using global memory references, and tracking mechanics via foundational single-dimensional data arrays.

---

## 1. System Overview

The system mimics a retail storefront point-of-sale (POS) desk dashboard paired with localized monitoring frames. The architecture relies on an **event-driven model** where interactions on the main dashboard trigger mutations in global state data, which are then dynamically pulled and displayed by sub-component windows.

### High-Level Workflow
1. Application Entry: The system boots through `MainStore.java`, initializing the parent framework (`MainFrame.java`).
2. Product Loading: On initialization, the dashboard fetches the inventory manifest directly from a central storage utility (`Data.java`).
3. Cart Staging: Users stage operational lines into a data cart, automatically checking stock limitations.
4. Checkout & Logging: Processing a purchase logs transactional records into sequential history buffers and permanently updates remaining product volumes.

---

## 2. Component & Frame Responsibilities

The software splits visual tasks and database access across distinct classes to separate window logic from data management.

### 🏢 MainStore.java (Application Bootstrap)
 Responsibility: Serves as the system entry execution root.
 Core Logic: Contains the `main` method. It initializes the Swing event thread pipeline cleanly via `java.awt.EventQueue.invokeLater` to safely render the main dashboard layout.

### 💻 MainFrame.java (Primary Point-of-Sale Workspace)
* Responsibility: Acts as the interface interaction driver for sales tasks.
* Core Mechanisms:
* Displays the primary product list and custom numerical inputs (`JSpinner`) for item collection.
* Manages active purchasing records visually via a tabular canvas (`JTable`).
* Triggers confirmation dialog receipts on request.
* Hosts menu navigation linkages to call specialized inspection utility frames.

### 📦 Inventory.java (Stock Monitor Panel)
* Responsibility: Provides immediate visibility into stock levels.
* Core Mechanisms:
* Implements `DISPOSE_ON_CLOSE` routine parameters to exist as a transient child frame without disrupting background system lifecycles.
* Dynamically targets `txtInventory` (`JTextArea`) to construct a read-only list formatting item tallies left in reserve.

### 📜 Transaction.java (Sales Log Summary Viewer)
* Responsibility: Acts as a runtime auditing trail for store operations.
* Core Mechanisms:
* Scans historically committed cart sales archives.
* Populates a non-editable layout string reporting total items sold, individual volumes, and final checkout revenues.

### 🗃️ Data.java (Central Storage Engine)
* Responsibility: Acts as the central database and transaction processor for the whole app.
* Core Mechanisms:
* Hosts all global store metrics using shared class-level (`static`) data arrays.
* Performs structural array manipulation logic, logic checking for stock levels, and processing for complete checkout routines.

---

## 3. How Arrays Are Used (State & Data Management)

This application deliberately avoids complex relational database servers. Instead, it maintains state across three matching array matrices that map items by their array index number (position).

### A. Core Inventory Arrays
The base catalog relies on parallel, primitive array offsets to store product specs:
```java
public static String[] productName = {"Rice", "Sugar", "Coffee", "Milk"};
public static double[] productPrice = {50.0, 25.0, 25.0, 15.0};
public static int[] productQuantity = {20, 20, 20, 20};

**SCREENSHOTS**
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/b36ef887-667a-4f63-bca3-13d9ee6e744c" />
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/c5e60702-ffed-4375-a071-abfe0f8b0fb9" />
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/e802d581-0d5b-4a25-be35-86a52e6b1bd0" />




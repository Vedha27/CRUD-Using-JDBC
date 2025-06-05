# CRUD-Using-JDBC
# JDBC Mini Project: Employee Management System

## 📌 Project Overview

This is a simple Java mini project using **JDBC (Java Database Connectivity)** to perform **CRUD operations** on an Employee database.  
It also demonstrates the use of **ACID properties** to ensure reliable and consistent transactions.

---

## 🔧 Technologies Used

- Java (JDK 8 or higher)
- MySQL Database
- JDBC API
- Eclipse or IntelliJ IDEA
- MySQL Workbench (optional)

---

## 🧱 Database Schema

**Table Name:** `employee`

| Column Name | Data Type    | Description        |
|-------------|--------------|--------------------|
| id          | INT (PK)     | Employee ID        |
| name        | VARCHAR(50)  | Employee Name      |
| salary      | INT          | Employee Salary    |
| department  | VARCHAR(50)  | Employee Department|

---

## ✨ Features

- Add new employee (Create)
- View all employees (Read)
- Update employee details (Update)
- Delete an employee (Delete)
- Manual transaction control using `setAutoCommit(false)`
- Proper use of **ACID properties**

---

## 🔁 ACID Properties Demonstrated

1. **Atomicity**  
   ➤ Each CRUD operation is executed as a transaction. If any step fails, the entire transaction is rolled back.

2. **Consistency**  
   ➤ Database integrity is preserved with valid data input and constraints.

3. **Isolation**  
   ➤ Transaction isolation levels can be set using `Connection.setTransactionIsolation()`, ensuring one transaction does not interfere with another.

4. **Durability**  
   ➤ Once `commit()` is called, the changes are permanent in the database.

---

## 🔨 How to Run

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/jdbc-mini-project.git
   cd jdbc-mini-project

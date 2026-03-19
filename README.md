# Java-JDBC

## Project Overview
This project demonstrates a simple Java application using **JDBC** to connect to a **MySQL** database.  
It includes a **Student Management System** example where you can add, delete, update, and search for students.

---

## Key Features
- Built with Java SE  
- JDBC connection to MySQL  
- CRUD operations (Create, Read, Update, Delete)  
- Simple console-based interface  

---

## Installation & Usage
1. Create a MySQL database named `students`.  
2. Create the `Student` table:
```sql
CREATE TABLE Student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    surname VARCHAR(50),
    age INT
);

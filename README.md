Java-JDBC

Project Overview:
This project demonstrates a simple Java application using JDBC to connect to a MySQL database. It includes a Student Management System example where you can add, delete, update, and search for students.

Key Features

Built with Java SE

JDBC connection to MySQL

CRUD operations (Create, Read, Update, Delete)

Simple console-based interface

Installation & Usage

Create a MySQL database named students

Create the Student table:

CREATE TABLE Student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    surname VARCHAR(50),
    age INT
);

Update your MySQL username and password in DBConnection.java

Compile and run the project:

javac *.java
java Main
Possible Extensions

Add more tables or relationships

Integrate a GUI using Swing or JavaFX

Use Hibernate or Spring JDBC for more advanced database handling

Technologies

Java SE 17+

JDBC

MySQL

Contact

For questions about this project, feel free to reach out via my GitHub profile
.  

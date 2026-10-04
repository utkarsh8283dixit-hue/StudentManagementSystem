# Student Management System

## Project Overview

Student Management System is a Java-based mini project developed using
Java, JDBC and MySQL. The application allows users to manage student
records efficiently through a simple console-based interface.

The system stores student information permanently in a MySQL database.

## Technologies Used

- Java
- JDBC
- MySQL
- IntelliJ IDEA
- Maven
- MySQL Connector/J

## Features

1. Add Student
2. View All Students
3. Update Student
4. Delete Student
5. Search Student by ID
6. Input Validation
7. Delete Confirmation
8. Persistent Database Storage

## Student Information

The system stores:

- Student ID
- Student Name
- Age
- Course
- Email
- Phone Number

## Database

Database Name:

student_management

Table Name:

students

### Table Structure

| Column | Data Type | Description |
|--------|-----------|-------------|
| id | INT | Primary Key |
| name | VARCHAR(100) | Student Name |
| age | INT | Student Age |
| course | VARCHAR(100) | Course |
| email | VARCHAR(100) | Email Address |
| phone | VARCHAR(15) | Phone Number |

## Project Structure

StudentManagementSystem
│
├── pom.xml
├── README.md
│
└── src
└── main
└── java
└── com.student
├── DBConnection.java
├── Student.java
├── StudentDAO.java
└── Main.java

## How to Run

### Step 1: Install Requirements

Install:

- JDK
- IntelliJ IDEA
- MySQL
- MySQL Workbench

### Step 2: Create Database

Run the following SQL command:

```sql
CREATE DATABASE student_management;
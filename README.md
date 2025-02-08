# College_Data_Management

## Overview
The **College_Data_Management** system is a web-based application developed using **Java, Servlets, JSP, JavaScript, and MySQL**. It provides essential features for managing student and staff details, recording student marks, and handling user authentication. The system ensures data integrity and delivers a user-friendly interface for efficient college administration.

## Technologies Used
- **Backend:** Java, Servlet, JSP
- **Frontend:** JavaScript, HTML, CSS
- **Database:** MySQL
- **Server:** Apache Tomcat

## Features
- **Student Management:**
  - Add, update, and delete student details
  - Record student marks
- **Staff Management:**
  - Add, update, and delete staff details
- **User Authentication:**
  - Secure login and logout functionality
  - Role-based access control
- **Data Integrity & User-Friendly Interface:**
  - Ensures consistency and accuracy of stored information
  - Simplified UI for easy navigation

## Installation & Setup
### Prerequisites:
- JDK (Java Development Kit)
- Apache Tomcat Server
- MySQL Database
- Any IDE (Eclipse, IntelliJ IDEA, or NetBeans)

### Steps to Setup:
1. Clone the repository:
   ```sh
   https://github.com/tanmay156/College_Data_Management.git
   ```
2. Import the project into your IDE.
3. Configure **Apache Tomcat** server.
4. Set up the MySQL database:
   - Create a database named `college_db`.
   - Import the provided SQL script (`database.sql`) into MySQL.
5. Update the database configuration in `db-config.properties`.
6. Deploy the project on **Tomcat Server**.
7. Access the application at:
   ```
   http://localhost:8080/College_Data_Management
   ```

## Database Schema
- **Students Table:** Stores student details and marks.
- **Staff Table:** Stores staff details.
- **Users Table:** Manages user authentication.

## Usage
1. **Admin Login:** Access the dashboard with administrative privileges.
2. **Manage Students & Staff:** Perform CRUD operations on student and staff records.
3. **Record Student Marks:** Add and update marks for students.
4. **Logout:** Securely exit the system.

## Future Enhancements
- Implement role-based access for staff and students.
- Improve UI using a modern framework (React, Vue, or Angular).
- Add reports and analytics for student performance.

## Contributors
- **Tanmay Jadhav** (Developer)



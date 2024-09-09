# Library Management System

## Overview

The Library Management System is a Java Spring Boot application designed to manage books, authors, categories, and publishers in a library. 
It features CRUD operations for each of these entities and a user interface built with Thymeleaf.

## Features

- **Manage Books**: Add, update, delete, and view books.
- **Manage Authors**: Add, update, delete, and view authors.
- **Manage Categories**: Add, update, delete, and view categories.
- **Manage Publishers**: Add, update, delete, and view publishers.
- **User Interface**: Built with Thymeleaf for a dynamic and interactive experience.

## Technologies Used

- **Java**: Programming language for backend logic.
- **Spring Boot**: Framework for building the application.
- **Thymeleaf**: Template engine for rendering web pages.
- **Spring Data JPA**: For database interactions.
- **H2 database**: Database for storing data. (YOU can use Mysql).

## Prerequisites

- Java 11 or later
- MySQL
- Maven

properties
Copy code

spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=yourpassword
Build and Run the Application
Build the project using Maven:

Open your browser and navigate to http://localhost:8080.

Project Structure
src/main/java/com/yourdomain/librarymanagementsystem: Contains Java source files.
controller/: Contains Spring MVC controllers for handling web requests.
model/: Contains JPA entity classes.
repository/: Contains Spring Data JPA repositories.
service/: Contains service classes for business logic.
src/main/resources/: Contains application configuration files.
application.properties: Configuration file for database and application settings.
src/main/resources/templates/: Contains Thymeleaf templates for the user interface.


Usage
Navigate to the application in your web browser.
Use the navigation menu to manage books, authors, categories, and publishers.
Utilize the CRUD operations to interact with the data.

Contributing
Feel free to submit issues, create pull requests, or provide suggestions for improvements.

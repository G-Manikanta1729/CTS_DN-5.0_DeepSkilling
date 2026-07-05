# Exercise 9: Creating a Spring Boot Application

## Week 2 – Spring Framework

### Module
**Spring Boot**

### Exercise
**Exercise 9: Creating a Spring Boot Application**

---

# Introduction

Modern enterprise applications require several technologies such as web servers, dependency management, database connectivity, REST APIs, security, logging, and configuration management. Configuring all these components manually using the traditional Spring Framework requires a significant amount of XML configuration and project setup.

**Spring Boot** simplifies this process by providing a convention-based approach to application development. It eliminates most of the manual configuration required in traditional Spring applications and allows developers to build production-ready applications quickly.

In this exercise, a **Library Management System** is developed using Spring Boot. The application exposes REST APIs to perform CRUD (Create, Read, Update, Delete) operations on books. Spring Data JPA is used to interact with the database, while the H2 in-memory database is used to store data during application execution.

This exercise demonstrates how multiple Spring technologies work together to build a complete backend application with minimal configuration.

---

# Objective

The objective of this exercise is to understand how to build a complete Spring Boot application from scratch.

After completing this exercise, you will learn:

- What is Spring Boot?
- Why Spring Boot is used.
- How Spring Boot simplifies application development.
- How to create a Spring Boot project using Spring Initializr.
- How to configure an H2 Database.
- How to create Entity and Repository classes.
- How to develop REST APIs using Spring Web.
- How Spring Data JPA performs CRUD operations.
- How to run and test a Spring Boot application.

---

# Scenario

A software company is developing a **Library Management System** to manage book information.

The application should allow users to:

- Add a new book.
- View all books.
- Search for a specific book.
- Update book details.
- Delete books.

Instead of configuring the entire Spring Framework manually, the development team decides to use **Spring Boot**, which automatically configures the application and reduces development time.

The application uses:

- Spring Web to create REST APIs.
- Spring Data JPA to perform database operations.
- H2 Database to store book information.
- Spring Boot's embedded Tomcat server to run the application.

---

# Technologies Used

| Technology | Purpose |
|------------|---------|
| Java 21 | Programming Language |
| Spring Boot | Rapid Application Development Framework |
| Spring Web | Building REST APIs |
| Spring Data JPA | Database Operations |
| Hibernate | ORM Framework used by Spring Data JPA |
| H2 Database | In-memory Database |
| Maven | Dependency Management and Build Tool |
| IntelliJ IDEA | Integrated Development Environment |
| Postman | Testing REST APIs |

---

# Prerequisites

Before performing this exercise, you should know:

- Java Programming
- Object-Oriented Programming (OOP)
- Maven Basics
- Spring Core
- Spring IoC
- Dependency Injection
- Basic SQL
- HTTP Request and Response

---

# Concepts Used

## 1. What is Spring Boot?

### Definition

**Spring Boot** is an extension of the Spring Framework that simplifies the development of Java applications by providing automatic configuration, embedded servers, starter dependencies, and production-ready features.

In simple words,

> **Spring Boot allows developers to create Spring applications quickly with minimal configuration.**

---

## Why was Spring Boot introduced?

Before Spring Boot, developers had to:

- Configure XML files manually.
- Configure web servers separately.
- Add many dependency JAR files.
- Configure database connections manually.
- Manage application deployment manually.

This required significant time and effort.

Spring Boot solves these problems by providing:

- Automatic Configuration
- Embedded Web Server
- Starter Dependencies
- Production-ready Features
- Simplified Project Setup

---

## Traditional Spring vs Spring Boot

| Traditional Spring | Spring Boot |
|--------------------|-------------|
| Large XML configuration | Minimal or no XML configuration |
| Manual server configuration | Embedded Tomcat server |
| Manual dependency management | Starter dependencies |
| Complex setup | Quick setup |
| More boilerplate code | Less boilerplate code |

---

# 2. Features of Spring Boot

Spring Boot provides several powerful features that simplify application development.

## Auto Configuration

Spring Boot automatically configures the application based on the dependencies present in the project.

Example:

If the project contains the Spring Web dependency, Spring Boot automatically configures:

- Dispatcher Servlet
- Embedded Tomcat
- Web Configuration

without requiring manual configuration.

---

## Starter Dependencies

Instead of adding multiple individual libraries, Spring Boot provides starter packages.

Example:

```
spring-boot-starter-web
```

This single dependency includes everything required for web development.

Similarly,

```
spring-boot-starter-data-jpa
```

provides all libraries required for JPA and Hibernate.

---

## Embedded Server

Spring Boot includes an embedded web server such as:

- Tomcat
- Jetty
- Undertow

In this exercise, the application runs using the embedded **Tomcat Server**.

Therefore, there is no need to install Apache Tomcat separately.

The application simply starts by running the main class.

---

## Production-Ready Features

Spring Boot provides built-in support for:

- Health Monitoring
- Metrics
- Logging
- External Configuration
- Security Integration

These features make Spring Boot suitable for enterprise applications.

---

# 3. What is Spring Initializr?

### Definition

**Spring Initializr** is an online project generator that creates a ready-to-use Spring Boot project.

Instead of manually creating the project structure and configuring Maven, developers simply select:

- Project Type
- Java Version
- Spring Boot Version
- Dependencies

Spring Initializr automatically generates the project.

Website:

```
https://start.spring.io
```

---

## Why Use Spring Initializr?

Spring Initializr automatically:

- Creates the Maven project.
- Generates the project structure.
- Adds required dependencies.
- Creates the main application class.
- Creates the `application.properties` file.
- Configures Maven Wrapper.

This saves considerable development time.

---

# 4. Spring Boot Architecture

The overall architecture of the application is shown below.

```
Client
    │
    ▼
HTTP Request
    │
    ▼
Spring Boot Application
    │
    ▼
REST Controller
    │
    ▼
Repository
    │
    ▼
Hibernate (JPA)
    │
    ▼
H2 Database
    │
    ▼
HTTP Response (JSON)
```

Each component has a specific responsibility:

- **REST Controller** receives HTTP requests from the client.
- **Repository** performs database operations.
- **Hibernate** converts Java objects into SQL queries.
- **H2 Database** stores and retrieves the data.
- Spring Boot converts Java objects into JSON responses automatically.

---

# 5. What is a REST API?

A **REST API (Representational State Transfer API)** is a web service that allows different applications to communicate using HTTP.

The client sends an HTTP request.

The server processes the request.

The server returns a response, usually in **JSON** format.

Examples of HTTP methods used in this exercise:

| Method | Purpose |
|---------|---------|
| POST | Add a new Book |
| GET | Retrieve Books |
| PUT | Update Book Details |
| DELETE | Delete a Book |

---

# Learning Outcomes

After completing this exercise, you will be able to:

- Explain the purpose of Spring Boot.
- Understand the advantages of Spring Boot over traditional Spring.
- Create a Spring Boot project using Spring Initializr.
- Configure an H2 Database.
- Understand Spring Data JPA.
- Build REST APIs using Spring Web.

---

# Project Structure

The project follows the standard Maven directory structure generated using **Spring Initializr**.

```
Exercise_9_Creating_a_Spring_Boot_Application
│
├── README.md
├── pom.xml
├── .gitignore
│
├── src
│   ├── main
│   │   ├── java
│   │   │
│   │   └── com.library
│   │        │
│   │        ├── controller
│   │        │      └── BookController.java
│   │        │
│   │        ├── entity
│   │        │      └── Book.java
│   │        │
│   │        ├── repository
│   │        │      └── BookRepository.java
│   │        │
│   │        └── LibraryManagementApplication.java
│   │
│   └── resources
│          └── application.properties
│
└── Output
    ├── SpringBootStarted.png
    ├── H2Console.png
    ├── POST_Request.png
    ├── GET_Request.png
    ├── PUT_Request.png
    ├── DELETE_Request.png
    └── DatabaseOutput.png
```

---

# Folder and File Description

| File / Folder | Description |
|---------------|-------------|
| **pom.xml** | Contains Maven configuration and all Spring Boot dependencies. |
| **LibraryManagementApplication.java** | Main class that starts the Spring Boot application. |
| **Book.java** | Entity class representing the BOOK table in the database. |
| **BookRepository.java** | Repository interface that performs CRUD operations using Spring Data JPA. |
| **BookController.java** | REST Controller exposing HTTP endpoints for CRUD operations. |
| **application.properties** | Contains application configuration such as database properties and JPA settings. |
| **Output** | Contains screenshots of successful execution and API testing. |

---

# Implementation

The implementation of this exercise is divided into six simple steps.

---

# Step 1 : Create a Spring Boot Project

The project is created using **Spring Initializr**.

Project Information

| Property | Value |
|----------|-------|
| Project | Maven |
| Language | Java |
| Spring Boot | 3.x |
| Group | com.library |
| Artifact | LibraryManagement |
| Packaging | Jar |
| Java Version | 21 |

The following dependencies are selected while generating the project.

- Spring Web
- Spring Data JPA
- H2 Database

Spring Initializr automatically generates a complete Spring Boot project with all required configuration files.

---

# Step 2 : Maven Configuration (pom.xml)

The **pom.xml** file is the heart of every Maven project.

It contains:

- Project Information
- Spring Boot Parent
- Dependencies
- Maven Plugins
- Build Configuration

Some important dependencies included in this project are:

```xml
spring-boot-starter-web
```

Provides:

- REST API support
- Embedded Tomcat Server
- Spring MVC
- JSON Conversion

---

```xml
spring-boot-starter-data-jpa
```

Provides:

- Spring Data JPA
- Hibernate ORM
- Repository Support
- CRUD Operations

---

```xml
h2
```

Provides:

- H2 In-Memory Database
- Lightweight Database
- Easy Testing Environment

---

# Why Maven?

Maven automatically:

- Downloads required libraries.
- Resolves dependency conflicts.
- Builds the project.
- Packages the application.
- Manages project lifecycle.

Without Maven, developers would have to manually download and configure every required JAR file.

---

# Step 3 : Configure application.properties

The `application.properties` file is located inside:

```
src/main/resources
```

It contains all application-level configuration.

Example configuration:

```properties
spring.application.name=LibraryManagement

spring.datasource.url=jdbc:h2:mem:librarydb

spring.datasource.driverClassName=org.h2.Driver

spring.datasource.username=sa

spring.datasource.password=

spring.h2.console.enabled=true

spring.h2.console.path=/h2-console

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true
```

---

# Understanding Each Property

### spring.application.name

Defines the name of the Spring Boot application.

```
LibraryManagement
```

---

### spring.datasource.url

Specifies the database connection URL.

```
jdbc:h2:mem:librarydb
```

Meaning:

- `jdbc` → Java Database Connectivity
- `h2` → H2 Database
- `mem` → Store the database in memory
- `librarydb` → Database name

---

### spring.datasource.driverClassName

Specifies the JDBC Driver used to communicate with the H2 database.

```
org.h2.Driver
```

---

### spring.datasource.username

Default username used to connect to the H2 database.

```
sa
```

---

### spring.datasource.password

Password for the H2 database.

In this exercise, it is left empty.

---

### spring.h2.console.enabled

Enables the H2 Database Console.

```
true
```

This allows us to access:

```
http://localhost:8080/h2-console
```

---

### spring.h2.console.path

Defines the URL path for accessing the H2 Console.

```
/h2-console
```

---

### spring.jpa.database-platform

Specifies the Hibernate dialect.

Since the project uses the H2 database, Hibernate uses:

```
H2Dialect
```

to generate compatible SQL statements.

---

### spring.jpa.hibernate.ddl-auto

Automatically creates or updates database tables based on Entity classes.

```
update
```

This means:

- Create tables if they do not exist.
- Update tables whenever the Entity changes.
- No manual SQL scripts are required.

---

### spring.jpa.show-sql

Displays SQL queries executed by Hibernate in the console.

Example:

```
insert into book ...

select * from book ...

delete from book ...
```

This helps developers understand what Hibernate is doing internally.

---

# Step 4 : Create the Entity Class

Package

```
com.library.entity
```

Class

```
Book.java
```

The `Book` class represents a single book in the Library Management System.

Each object of this class corresponds to one row in the database table.

The class contains the following attributes:

- id
- title
- author
- price

---

# Understanding JPA Annotations

## @Entity

```java
@Entity
```

Marks the class as a JPA Entity.

Spring Data JPA automatically maps this class to a database table.

```
Book Class

↓

BOOK Table
```

---

## @Id

```java
@Id
```

Marks the Primary Key of the table.

Every table requires a unique identifier.

```
BOOK

↓

ID

↓

Primary Key
```

---

## @GeneratedValue

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

Automatically generates unique values for the Primary Key.

Example:

```
1

2

3

4

5
```

The developer does not need to assign IDs manually.

---

## Empty Constructor

```java
public Book() {

}
```

Hibernate requires a default constructor to create objects internally.

Without it, Hibernate cannot instantiate the Entity.

---

## Parameterized Constructor

```java
public Book(String title,
            String author,
            double price)
```

Used to create objects easily in Java code.

Example:

```java
Book book = new Book(
        "Spring Boot",
        "Rod Johnson",
        899
);
```

---

## Getters and Setters

Getter methods retrieve values from an object.

Setter methods modify the values of an object.

Spring Boot, Hibernate, and Jackson use getters and setters internally for:

- Data Binding
- JSON Conversion
- Database Operations

---

# Step 5 : Create the Repository

Package

```
com.library.repository
```

Interface

```
BookRepository.java
```

The Repository acts as the bridge between the application and the database.

Instead of writing SQL queries manually, Spring Data JPA provides built-in methods.

The interface extends:

```java
JpaRepository<Book, Long>
```

---

# Understanding JpaRepository

The following declaration:

```java
JpaRepository<Book, Long>
```

contains two parameters.

| Parameter | Meaning |
|-----------|---------|
| Book | Entity Class |
| Long | Primary Key Data Type |

Since the `id` field in the `Book` Entity is of type `Long`, the second parameter is also `Long`.

---

# Built-in CRUD Methods

By extending `JpaRepository`, the application automatically gets methods such as:

- save()
- findAll()
- findById()
- delete()
- deleteById()
- existsById()
- count()
- saveAll()

No implementation is required because Spring Data JPA provides these methods automatically.

---

# Advantages of Spring Data JPA

Without Spring Data JPA, developers must write:

- JDBC Connection Code
- SQL Queries
- Prepared Statements
- Result Set Handling
- Resource Cleanup

With Spring Data JPA, a single method call such as:

```java
bookRepository.save(book);
```

automatically performs the database operation.

This greatly reduces code complexity and improves maintainability.

---

# Step 6 : Create the REST Controller

Package

```
com.library.controller
```

Class

```
BookController.java
```

The **Controller Layer** acts as the entry point of the application.

It receives HTTP requests from clients such as:

- Web Applications
- Mobile Applications
- Postman
- Browser

The controller processes the request, communicates with the Repository layer, and returns the response to the client.

In this exercise, the `BookController` class exposes REST APIs for performing CRUD operations on books.

---

# Understanding Spring MVC Annotations

Spring Boot provides several annotations that simplify REST API development.

---

## @RestController

```java
@RestController
```

### Definition

Marks the class as a REST Controller.

It combines two annotations:

- `@Controller`
- `@ResponseBody`

This tells Spring Boot that every method inside this class should return data directly as an HTTP response instead of returning a web page.

Example:

```java
@RestController
public class BookController {

}
```

Without `@RestController`, the application cannot expose REST APIs.

---

## @RequestMapping

```java
@RequestMapping("/books")
```

### Definition

Defines the base URL for all methods inside the controller.

Instead of writing:

```
/addBook

/getBooks

/deleteBook
```

Spring automatically prefixes every endpoint with:

```
/books
```

Example:

```
GET

/books
```

```
POST

/books
```

```
PUT

/books/1
```

```
DELETE

/books/1
```

---

## @Autowired

```java
@Autowired
private BookRepository bookRepository;
```

### Definition

Automatically injects the required Bean.

Instead of manually creating the Repository object,

```java
BookRepository repository =
new BookRepository();
```

Spring performs Dependency Injection automatically.

The `BookRepository` Bean is created by the Spring IoC Container and injected into the Controller.

---

## @RequestBody

```java
@RequestBody
```

### Definition

Converts incoming JSON data into a Java object.

Suppose the client sends:

```json
{
    "title":"Java Programming",
    "author":"James Gosling",
    "price":650
}
```

Spring automatically converts this JSON into:

```java
Book book
```

No manual parsing is required.

---

## @PathVariable

```java
@PathVariable Long id
```

### Definition

Extracts values directly from the URL.

Example URL:

```
/books/5
```

Spring automatically extracts:

```
id = 5
```

and passes it to the method.

---

# CRUD Operations

CRUD stands for:

| Operation | Description |
|------------|-------------|
| Create | Add new records |
| Read | Retrieve records |
| Update | Modify existing records |
| Delete | Remove records |

The application implements all four operations.

---

# Create Book

### HTTP Method

```
POST
```

### URL

```
/books
```

### Purpose

Adds a new book to the database.

### Sample Request

```json
{
    "title":"Spring Boot",
    "author":"Rod Johnson",
    "price":899
}
```

### Processing Flow

```
Client

↓

BookController

↓

BookRepository

↓

Hibernate

↓

H2 Database

↓

Book Saved
```

### Response

```json
{
    "id":1,
    "title":"Spring Boot",
    "author":"Rod Johnson",
    "price":899.0
}
```

---

# Get All Books

### HTTP Method

```
GET
```

### URL

```
/books
```

### Purpose

Retrieves every book stored in the database.

Spring internally executes:

```java
bookRepository.findAll();
```

### Sample Response

```json
[
    {
        "id":1,
        "title":"Spring Boot",
        "author":"Rod Johnson",
        "price":899.0
    }
]
```

---

# Get Book By ID

### HTTP Method

```
GET
```

### URL

```
/books/{id}
```

Example:

```
/books/1
```

### Purpose

Retrieves a single book using its ID.

Spring internally executes:

```java
bookRepository.findById(id);
```

### Sample Response

```json
{
    "id":1,
    "title":"Spring Boot",
    "author":"Rod Johnson",
    "price":899.0
}
```

---

# Update Book

### HTTP Method

```
PUT
```

### URL

```
/books/{id}
```

Example

```
/books/1
```

### Purpose

Updates an existing book.

Spring performs the following steps:

1. Finds the existing record.
2. Updates the values.
3. Saves the updated object.

Internally,

```java
bookRepository.save(book);
```

updates the database.

---

# Delete Book

### HTTP Method

```
DELETE
```

### URL

```
/books/{id}
```

Example

```
/books/1
```

### Purpose

Deletes the specified book.

Spring internally executes:

```java
bookRepository.deleteById(id);
```

### Response

```
Book Deleted Successfully.
```

---

# HTTP Methods Used

| HTTP Method | Purpose | Example |
|--------------|---------|----------|
| POST | Create a new resource | `/books` |
| GET | Retrieve resources | `/books` |
| GET | Retrieve a single resource | `/books/1` |
| PUT | Update a resource | `/books/1` |
| DELETE | Delete a resource | `/books/1` |

---

# Request Processing Flow

Whenever a client sends a request, Spring Boot processes it in the following order.

```
Client

↓

HTTP Request

↓

Embedded Tomcat Server

↓

Dispatcher Servlet

↓

BookController

↓

BookRepository

↓

Hibernate

↓

H2 Database

↓

Hibernate

↓

BookRepository

↓

BookController

↓

HTTP Response (JSON)

↓

Client
```

---

# Execution Flow

The complete execution flow of the application is shown below.

```
Application Starts
        │
        ▼
Spring Boot Initializes
        │
        ▼
Embedded Tomcat Starts
        │
        ▼
H2 Database Starts
        │
        ▼
Hibernate Creates BOOK Table
        │
        ▼
Spring Creates Beans
        │
        ▼
REST APIs Become Available
        │
        ▼
Client Sends HTTP Request
        │
        ▼
Controller Receives Request
        │
        ▼
Repository Executes Operation
        │
        ▼
Hibernate Generates SQL
        │
        ▼
Database Executes Query
        │
        ▼
Result Returned
        │
        ▼
Spring Converts Java Object into JSON
        │
        ▼
HTTP Response Sent to Client
```

---

# Internal Working of the Application

When the application starts, Spring Boot performs several tasks automatically.

## Step 1

The `LibraryManagementApplication` class starts the application.

```java
SpringApplication.run(
LibraryManagementApplication.class,
args
);
```

---

## Step 2

Spring Boot scans all packages.

It identifies:

- Controllers
- Repositories
- Entities
- Configuration Classes

---

## Step 3

Spring creates Beans for all required components.

Examples:

- BookController
- BookRepository

---

## Step 4

Spring configures Hibernate automatically.

Hibernate scans the `Book` Entity and creates the corresponding `BOOK` table.

---

## Step 5

The embedded Tomcat server starts.

By default, the application runs on:

```
http://localhost:8080
```

---

## Step 6

The application waits for incoming HTTP requests.

Example:

```
GET /books
```

---

## Step 7

The request reaches the `BookController`.

The appropriate method is selected based on:

- URL
- HTTP Method

---

## Step 8

The Controller calls the `BookRepository`.

The Repository performs the required database operation using Spring Data JPA.

---

## Step 9

Hibernate converts Java method calls into SQL queries.

Example:

```java
findAll()
```

becomes:

```sql
SELECT * FROM BOOK;
```

---

## Step 10

The H2 Database executes the SQL query and returns the result.

---

## Step 11

Spring Boot converts the returned Java objects into JSON format.

Example:

```java
Book
```

↓

```json
{
    "id":1,
    "title":"Spring Boot",
    "author":"Rod Johnson",
    "price":899
}
```

---

## Step 12

The JSON response is sent back to the client.

This entire process happens automatically without requiring the developer to write:

- SQL queries
- JSON conversion code
- HTTP response handling
- Database connection code

Spring Boot handles all these tasks internally, allowing developers to focus on business logic.

---

# Running the Application

After completing the implementation, the application can be started directly from IntelliJ IDEA.

Open:

```
LibraryManagementApplication.java
```

Run the main method.

```java
SpringApplication.run(
LibraryManagementApplication.class,
args
);
```

Spring Boot performs the following operations automatically:

- Starts the Spring IoC Container.
- Creates all required Beans.
- Configures Hibernate.
- Creates the H2 Database.
- Creates the BOOK table.
- Starts the Embedded Tomcat Server.
- Makes all REST APIs available.

If everything is configured correctly, the console displays a message similar to:

```
Started LibraryManagementApplication
```

This indicates that the application has started successfully.

---

# Accessing the H2 Database Console

Since this project uses the **H2 In-Memory Database**, Spring Boot also provides a web-based database console.

Open the following URL in your browser:

```
http://localhost:8080/h2-console
```

Use the following configuration:

| Property | Value |
|----------|-------|
| JDBC URL | jdbc:h2:mem:librarydb |
| Username | sa |
| Password | *(Leave Empty)* |

Click **Connect**.

If the connection is successful, you can view the automatically created **BOOK** table.

---

# Testing the REST APIs

The REST APIs can be tested using:

- Postman
- IntelliJ HTTP Client
- VS Code REST Client
- cURL

---

## Add a Book

### Method

```
POST
```

### URL

```
http://localhost:8080/books
```

### Request Body

```json
{
    "title":"Java Programming",
    "author":"James Gosling",
    "price":650
}
```

---

## Get All Books

### Method

```
GET
```

### URL

```
http://localhost:8080/books
```

---

## Get Book by ID

### Method

```
GET
```

### URL

```
http://localhost:8080/books/1
```

---

## Update Book

### Method

```
PUT
```

### URL

```
http://localhost:8080/books/1
```

### Request Body

```json
{
    "title":"Spring Boot",
    "author":"Rod Johnson",
    "price":899
}
```

---

## Delete Book

### Method

```
DELETE
```

### URL

```
http://localhost:8080/books/1
```

---

# Expected Output

## POST Response

```json
{
    "id":1,
    "title":"Java Programming",
    "author":"James Gosling",
    "price":650.0
}
```

---

## GET Response

```json
[
    {
        "id":1,
        "title":"Java Programming",
        "author":"James Gosling",
        "price":650.0
    }
]
```

---

## PUT Response

```json
{
    "id":1,
    "title":"Spring Boot",
    "author":"Rod Johnson",
    "price":899.0
}
```

---

## DELETE Response

```
Book Deleted Successfully.
```

---

# Output Screenshots

The following screenshots should be included inside the **Output** folder.

- Spring Boot application started successfully.
- H2 Console login page.
- BOOK table displayed in H2 Console.
- POST API execution.
- GET API execution.
- PUT API execution.
- DELETE API execution.
- Final BOOK table after CRUD operations.

These screenshots provide visual proof that the application has been implemented and tested successfully.

---

# Advantages of Spring Boot

Spring Boot provides numerous advantages over traditional Spring applications.

## 1. Minimal Configuration

Most configurations are handled automatically through Auto Configuration.

---

## 2. Faster Development

Developers can build applications much more quickly with fewer configuration files.

---

## 3. Embedded Web Server

Spring Boot includes an embedded Tomcat server, eliminating the need to install and configure a separate application server.

---

## 4. Starter Dependencies

Spring Boot Starter dependencies simplify dependency management by grouping commonly used libraries together.

---

## 5. Production Ready

Spring Boot includes built-in support for:

- Monitoring
- Logging
- Health Checks
- Metrics
- External Configuration

---

## 6. Easy Database Integration

Spring Data JPA integrates seamlessly with relational databases and significantly reduces boilerplate database code.

---

## 7. Reduced Boilerplate Code

Spring Boot eliminates much of the repetitive configuration code required in traditional Java web applications.

---

# Common Errors and Solutions

## Error

```
Port 8080 is already in use
```

### Solution

Stop the application currently using port **8080** or change the server port in `application.properties`.

---

## Error

```
Whitelabel Error Page
```

### Solution

Verify that the requested URL matches the mappings defined in `BookController`.

---

## Error

```
Table "BOOK" not found
```

### Solution

Check that:

- The `Book` class is annotated with `@Entity`.
- `spring.jpa.hibernate.ddl-auto=update` is configured correctly.
- The application started successfully.

---

## Error

```
404 Not Found
```

### Solution

Verify:

- Controller package location.
- URL mapping.
- HTTP method.
- Application is running.

---

## Error

```
BeanCreationException
```

### Solution

Check:

- Dependencies in `pom.xml`.
- Entity configuration.
- Repository interface.
- Application startup logs.

---

# Interview Questions

## 1. What is Spring Boot?

**Answer**

Spring Boot is an extension of the Spring Framework that simplifies Java application development by providing automatic configuration, embedded servers, and starter dependencies.

---

## 2. What are the advantages of Spring Boot?

**Answer**

- Auto Configuration
- Embedded Server
- Starter Dependencies
- Production-ready Features
- Reduced Configuration
- Faster Development

---

## 3. What is Spring Initializr?

**Answer**

Spring Initializr is an online tool used to generate ready-to-use Spring Boot projects with the required dependencies and project structure.

---

## 4. What is Spring Data JPA?

**Answer**

Spring Data JPA simplifies database access by providing repository interfaces with built-in CRUD operations, reducing the need to write SQL queries manually.

---

## 5. What is Hibernate?

**Answer**

Hibernate is an Object-Relational Mapping (ORM) framework that maps Java objects to database tables and converts Java operations into SQL queries.

---

## 6. What is an Entity?

**Answer**

An Entity is a Java class annotated with `@Entity` that represents a table in a relational database.

---

## 7. What is JpaRepository?

**Answer**

`JpaRepository` is a Spring Data JPA interface that provides built-in methods for CRUD operations without requiring manual implementation.

---

## 8. What is H2 Database?

**Answer**

H2 is a lightweight, in-memory relational database commonly used for development, testing, and learning purposes.

---

## 9. What is a REST Controller?

**Answer**

A REST Controller is a class annotated with `@RestController` that handles HTTP requests and returns data (typically JSON) to clients.

---

## 10. What is the purpose of `application.properties`?

**Answer**

It stores application configuration such as database settings, server configuration, logging, and JPA properties.

---

## Key Learnings

After completing this exercise, you have learned:

- Spring Boot Fundamentals
- Spring Initializr
- Maven Project Structure
- Spring Boot Auto Configuration
- Embedded Tomcat Server
- H2 Database Configuration
- Spring Data JPA
- Hibernate ORM
- Entity Mapping
- Repository Pattern
- REST Controller
- HTTP Methods
- CRUD Operations
- JSON Request and Response
- Application Configuration using `application.properties`
- API Testing with Postman
- Spring Boot Application Lifecycle

---

# Conclusion

This exercise demonstrates how Spring Boot simplifies the development of modern Java applications by reducing configuration and providing powerful built-in features. A complete **Library Management System** backend was created using **Spring Boot**, **Spring Web**, **Spring Data JPA**, and the **H2 Database**.

The application exposes REST APIs to perform CRUD operations on books, while Spring Data JPA and Hibernate handle database interactions automatically. The use of **Spring Initializr**, **embedded Tomcat**, and **Auto Configuration** significantly reduces development effort and allows developers to focus on business logic rather than infrastructure setup.

By completing this exercise, you have gained practical experience in building a RESTful backend application, configuring a database, implementing JPA repositories, testing APIs, and understanding the overall architecture of a Spring Boot application. These concepts form the foundation for developing scalable enterprise applications and are essential for advanced topics such as **Spring Security**, **Spring Boot Microservices**, **Spring Cloud**, and **Spring Boot REST API Development**.
- Perform CRUD operations using JPA.
- Test REST APIs using Postman.
- Build complete backend applications using Spring Boot.

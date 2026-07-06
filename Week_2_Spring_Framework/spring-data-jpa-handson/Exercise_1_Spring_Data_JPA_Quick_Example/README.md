# Exercise 1: Spring Data JPA - Quick Example

## Week 2 – Spring Framework

### Module
**Spring Data JPA with Spring Boot & Hibernate**

### Exercise
**Exercise 1: Spring Data JPA - Quick Example**

---

# Introduction

Modern enterprise applications store and manage large amounts of data such as customer information, employee records, product details, banking transactions, and library management data. In Java applications, this data is typically stored in relational databases like MySQL, Oracle, PostgreSQL, or SQL Server.

Traditionally, interacting with a database required developers to write large amounts of JDBC code for creating connections, executing SQL queries, processing results, and closing database resources. As applications became larger, maintaining this code became difficult and time-consuming.

To overcome these challenges, Java introduced the **Java Persistence API (JPA)**, a standard specification for Object-Relational Mapping (ORM). Hibernate became the most popular implementation of JPA, providing powerful ORM capabilities. Later, **Spring Data JPA** further simplified database access by automatically implementing repository classes and providing built-in CRUD operations.

In this exercise, a simple **Country Management** application is developed using **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**. The application retrieves country details stored in a MySQL database using Spring Data JPA without writing SQL queries manually.

This exercise serves as the foundation for all upcoming Spring Data JPA exercises.

---

# Objective

The objective of this exercise is to understand how Spring Data JPA simplifies database operations in a Spring Boot application.

After completing this exercise, you will learn:

- Why ORM is required.
- What is JPA.
- What is Hibernate.
- What is Spring Data JPA.
- How Spring Boot integrates with Spring Data JPA.
- How to configure a MySQL database.
- How to create Entity, Repository, and Service classes.
- How Spring automatically performs database operations.
- How to retrieve records from a database using `findAll()`.

---

# Scenario

A software company is developing a simple **Country Management System**.

The company maintains a database containing information about different countries.

Initially, the application should retrieve all available countries from the database and display them in the console.

Instead of writing SQL queries manually using JDBC, the development team decides to use **Spring Data JPA**, which automatically performs database operations with minimal code.

The application consists of:

- A MySQL database containing the Country table.
- A Country Entity representing the database table.
- A Repository that communicates with the database.
- A Service layer that contains business logic.
- A Spring Boot application that retrieves and displays all countries.

---

# Technologies Used

| Technology | Purpose |
|------------|---------|
| Java 21 (or later) | Programming Language |
| Spring Boot | Application Framework |
| Spring Data JPA | Simplified Database Access |
| Hibernate | ORM Framework |
| MySQL 8 | Relational Database |
| Maven | Dependency Management |
| IntelliJ IDEA | IDE |
| SLF4J | Logging Framework |

---

# Prerequisites

Before performing this exercise, you should be familiar with:

- Core Java
- Object-Oriented Programming (OOP)
- Maven Basics
- Spring Boot Basics
- MySQL Basics
- SQL (CREATE, INSERT, SELECT)
- Dependency Injection (DI)
- Spring IoC Container

---

# Concepts Used

## 1. What is ORM?

### Definition

**ORM (Object-Relational Mapping)** is a programming technique that maps Java objects to relational database tables.

Instead of writing SQL queries manually, developers work with Java objects, and the ORM framework automatically converts object operations into SQL statements.

For example,

```
Java Object

↓

Book

↓

ORM

↓

BOOK Table
```

If a developer creates a Java object,

```java
Book book = new Book();
```

Hibernate automatically converts it into an SQL statement like:

```sql
INSERT INTO BOOK ...
```

Similarly,

```java
bookRepository.findAll();
```

is internally converted into:

```sql
SELECT * FROM BOOK;
```

---

## Why is ORM Needed?

Without ORM, developers must:

- Create database connections.
- Write SQL queries.
- Execute queries.
- Process ResultSets.
- Convert database rows into Java objects.
- Close database resources.

This results in a large amount of repetitive code.

ORM eliminates these repetitive tasks by automatically handling the communication between Java objects and database tables.

---

# 2. What is JPA?

### Definition

**JPA (Java Persistence API)** is a Java specification that defines a standard way to perform Object-Relational Mapping (ORM).

JPA itself is **not a framework** and does **not contain any implementation**.

It only defines rules and interfaces that ORM frameworks must follow.

Think of JPA as a blueprint or contract.

Example:

```
JPA

↓

Rules

↓

Hibernate Implements Those Rules
```

Some common JPA annotations include:

- `@Entity`
- `@Table`
- `@Id`
- `@Column`
- `@GeneratedValue`

These annotations help map Java classes to database tables.

---

# 3. What is Hibernate?

### Definition

**Hibernate** is an Object-Relational Mapping (ORM) framework and the most widely used implementation of JPA.

Hibernate converts Java object operations into SQL queries automatically.

For example,

```java
countryRepository.findAll();
```

Hibernate internally generates SQL similar to:

```sql
SELECT * FROM country;
```

Hibernate manages:

- Database connections
- SQL generation
- Object creation
- Result mapping
- Transaction management

This significantly reduces development effort.

---

# 4. What is Spring Data JPA?

### Definition

**Spring Data JPA** is a Spring module that simplifies database access by building on top of JPA and Hibernate.

Instead of writing DAO (Data Access Object) classes manually, developers simply create a Repository interface.

For example,

```java
public interface CountryRepository
        extends JpaRepository<Country, String> {

}
```

Spring Data JPA automatically provides implementations for common database operations.

Built-in methods include:

- `save()`
- `findAll()`
- `findById()`
- `delete()`
- `deleteById()`
- `count()`
- `existsById()`

No SQL queries or method implementations are required for these operations.

---

# Difference Between JPA, Hibernate, and Spring Data JPA

| Feature | JPA | Hibernate | Spring Data JPA |
|----------|-----|-----------|-----------------|
| Type | Specification | ORM Framework | Spring Module |
| Provides Implementation | No | Yes | Uses Hibernate/JPA |
| SQL Generation | No | Yes | Yes (through Hibernate) |
| CRUD Operations | No | Yes | Yes (Simplified) |
| Repository Support | No | No | Yes |
| Boilerplate Code | High | Medium | Very Low |

---

# Application Architecture

The architecture of this exercise is shown below.

```
MySQL Database
        │
        ▼
Country Table
        │
        ▼
Hibernate
        │
        ▼
Spring Data JPA
        │
        ▼
CountryRepository
        │
        ▼
CountryService
        │
        ▼
OrmLearnApplication
        │
        ▼
Console Output
```

Each layer has a specific responsibility:

- **Country Table** stores the country data.
- **Hibernate** converts Java operations into SQL queries.
- **Spring Data JPA** provides repository implementations.
- **CountryRepository** communicates with the database.
- **CountryService** contains business logic.
- **OrmLearnApplication** starts the application and displays the retrieved data.

---

# Learning Outcomes

After completing this exercise, you will be able to:

- Explain the purpose of ORM.
- Understand why JPA was introduced.
- Differentiate between JPA, Hibernate, and Spring Data JPA.
- Configure a Spring Boot project with MySQL.
- Create Entity, Repository, and Service classes.
- Retrieve database records using Spring Data JPA.
- Understand how Hibernate generates SQL automatically.
- Explain the overall architecture of a Spring Data JPA application.
---

# Project Structure

The project follows the standard Maven directory structure generated using **Spring Initializr**.

```
Exercise_1_Spring_Data_JPA_Quick_Example
│
├── README.md
├── pom.xml
├── .gitignore
│
├── src
│   ├── main
│   │   ├── java
│   │   │
│   │   │   └── com.cognizant.ormlearn
│   │   │         │
│   │   │         ├── model
│   │   │         │      └── Country.java
│   │   │         │
│   │   │         ├── repository
│   │   │         │      └── CountryRepository.java
│   │   │         │
│   │   │         ├── service
│   │   │         │      └── CountryService.java
│   │   │         │
│   │   │         └── OrmLearnApplication.java
│   │   │
│   │   └── resources
│   │          └── application.properties
│   │
│   └── test
│
└── Output
    ├── Database.png
    ├── Console_Output.png
    └── Project_Structure.png
```

---

# Folder and File Description

| File / Folder | Description |
|---------------|-------------|
| **pom.xml** | Contains Maven configuration and project dependencies. |
| **OrmLearnApplication.java** | Main class that starts the Spring Boot application. |
| **Country.java** | Entity class representing the Country table in the database. |
| **CountryRepository.java** | Repository interface responsible for database operations. |
| **CountryService.java** | Service class containing business logic. |
| **application.properties** | Stores application configuration such as database connection and Hibernate settings. |
| **Output** | Contains screenshots of successful execution. |

---

# Implementation

The implementation of this exercise can be divided into six simple steps.

---

# Step 1 : Create the Spring Boot Project

The project is created using **Spring Initializr**.

Project Configuration

| Property | Value |
|----------|-------|
| Project | Maven |
| Language | Java |
| Spring Boot | 3.x |
| Group | com.cognizant |
| Artifact | orm-learn |
| Packaging | Jar |
| Java Version | 21 |

Dependencies selected:

- Spring Boot DevTools
- Spring Data JPA
- MySQL Driver

Spring Initializr automatically generates the complete project structure and required Maven configuration.

---

# Step 2 : Configure MySQL Database

A database named **ormlearn** is created in MySQL.

```sql
CREATE DATABASE ormlearn;
```

The Country table is created using:

```sql
CREATE TABLE country(
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50)
);
```

Sample data is inserted into the table.

```sql
INSERT INTO country VALUES ('IN','India');

INSERT INTO country VALUES ('US','United States of America');
```

The final table contains:

| Code | Name |
|------|------|
| IN | India |
| US | United States of America |

---

# Step 3 : Configure application.properties

The configuration file is located inside:

```
src/main/resources
```

The file contains database connection details and Hibernate configuration.

Example:

```properties
spring.application.name=orm_learn

spring.datasource.url=jdbc:mysql://localhost:3306/ormlearn
spring.datasource.username=root
spring.datasource.password=********
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

logging.level.org.springframework=INFO
logging.level.com.cognizant=DEBUG
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.orm.jdbc.bind=TRACE
```

---

# Understanding Each Property

## spring.application.name

Defines the name of the Spring Boot application.

```
orm_learn
```

---

## spring.datasource.url

Specifies the database connection URL.

```
jdbc:mysql://localhost:3306/ormlearn
```

Meaning:

- `jdbc` → Java Database Connectivity
- `mysql` → MySQL Database
- `localhost` → Database Server
- `3306` → Default MySQL Port
- `ormlearn` → Database Name

---

## spring.datasource.username

Specifies the MySQL username.

Example:

```
root
```

---

## spring.datasource.password

Specifies the password used to connect to MySQL.

---

## spring.datasource.driver-class-name

Defines the JDBC Driver.

```
com.mysql.cj.jdbc.Driver
```

This driver enables Java applications to communicate with MySQL.

---

## spring.jpa.hibernate.ddl-auto

Defines how Hibernate manages database tables.

```
validate
```

Meaning:

- Validate whether the existing database structure matches the Entity classes.
- Hibernate does **not** create or modify tables.

---

## spring.jpa.show-sql

Displays SQL queries generated by Hibernate.

Example:

```sql
SELECT co_code,
       co_name
FROM country;
```

This helps developers understand the SQL generated internally.

---

## Logging Configuration

The logging properties configure the amount of information displayed in the console.

They help developers:

- Monitor application execution.
- View SQL queries.
- Debug application behavior.

---

# Step 4 : Create the Entity Class

Package

```
com.cognizant.ormlearn.model
```

Class

```
Country.java
```

The `Country` class represents a single row in the **country** database table.

Each object of this class corresponds to one country stored in MySQL.

The class contains two attributes:

- code
- name

---

# Understanding JPA Annotations

## @Entity

```java
@Entity
```

Marks the class as a JPA Entity.

Hibernate automatically maps this class to a database table.

```
Country Class

↓

country Table
```

---

## @Table

```java
@Table(name = "country")
```

Specifies the exact database table associated with the Entity.

Without this annotation, Hibernate attempts to derive the table name automatically.

---

## @Id

```java
@Id
```

Marks the Primary Key.

Every database table requires a unique identifier.

In this project,

```
co_code
```

acts as the Primary Key.

---

## @Column

```java
@Column(name="co_code")
```

Maps the Java field to the corresponding database column.

Example:

| Java Field | Database Column |
|------------|-----------------|
| code | co_code |
| name | co_name |

This allows Java naming conventions and database naming conventions to differ.

---

## Default Constructor

```java
public Country() {

}
```

Hibernate requires an empty constructor because it creates Entity objects internally using reflection.

---

## Parameterized Constructor

```java
public Country(String code,
               String name)
```

Allows developers to create Country objects easily.

Example:

```java
Country country =
new Country("IN","India");
```

---

## Getters and Setters

Getter methods retrieve values.

Setter methods modify values.

Spring Boot, Hibernate, and Jackson internally use these methods for:

- Object Mapping
- Data Binding
- JSON Conversion
- Database Operations

---

# Step 5 : Create Repository

Package

```
com.cognizant.ormlearn.repository
```

Interface

```
CountryRepository.java
```

The Repository acts as the communication layer between the application and the database.

Instead of writing SQL queries manually, Spring Data JPA provides built-in methods.

The interface extends:

```java
JpaRepository<Country, String>
```

---

# Understanding JpaRepository

The declaration:

```java
JpaRepository<Country, String>
```

contains two parameters.

| Parameter | Meaning |
|-----------|---------|
| Country | Entity Class |
| String | Primary Key Data Type |

Since the primary key (`co_code`) is of type `String`, the second parameter is also `String`.

---

# Built-in CRUD Methods

By extending `JpaRepository`, the following methods become available automatically:

- save()
- findAll()
- findById()
- delete()
- deleteById()
- existsById()
- count()
- saveAll()

No implementation is required because Spring Data JPA provides these methods internally.

---

## @Repository

```java
@Repository
```

Marks the interface as a Repository component.

Spring automatically detects it during component scanning and creates a Bean for it.

---

# Step 6 : Create Service Layer

Package

```
com.cognizant.ormlearn.service
```

Class

```
CountryService.java
```

The Service layer contains the application's business logic.

Instead of calling the Repository directly from the main class, requests pass through the Service layer.

This separation improves maintainability and follows a layered architecture.

---

## @Service

```java
@Service
```

Marks the class as a Service component.

Spring creates an object (Bean) of this class and manages its lifecycle.

---

## @Autowired

```java
@Autowired
private CountryRepository countryRepository;
```

Spring automatically injects the `CountryRepository` Bean into the Service class.

Developers do not need to create the Repository object manually.

---

## @Transactional

```java
@Transactional
```

Defines that the method should execute within a database transaction.

Transactions ensure:

- Data consistency
- Automatic rollback if an exception occurs
- Safe execution of database operations

Although this exercise only retrieves data, using `@Transactional` follows standard enterprise application practices.

---

## getAllCountries()

The `getAllCountries()` method retrieves all records from the Country table.

Internally, it calls:

```java
countryRepository.findAll();
```

Spring Data JPA delegates this request to Hibernate, which generates the appropriate SQL query and retrieves the data from MySQL.

---

# Step 7 : Main Application Class

The entry point of every Spring Boot application is the main class.

In this project, the main class is:

```
OrmLearnApplication.java
```

The application starts from the `main()` method.

```java
public static void main(String[] args) {

    ApplicationContext context =
            SpringApplication.run(
                    OrmLearnApplication.class,
                    args);

    LOGGER.info("Inside Main");

    countryService =
            context.getBean(CountryService.class);

    testGetAllCountries();

}
```

This method performs the following operations:

1. Starts the Spring Boot application.
2. Creates the Spring IoC Container.
3. Initializes all Spring Beans.
4. Retrieves the `CountryService` Bean.
5. Calls the `testGetAllCountries()` method.
6. Displays all countries stored in the MySQL database.

---

# Understanding SpringApplication.run()

```java
SpringApplication.run(
OrmLearnApplication.class,
args
);
```

This is one of the most important methods in Spring Boot.

When this method executes, Spring Boot automatically:

- Starts the Spring IoC Container.
- Scans the project packages.
- Detects all Spring Components.
- Creates Beans.
- Connects to the MySQL Database.
- Configures Hibernate.
- Creates the EntityManager.
- Initializes Repository Beans.
- Makes the application ready for execution.

Without this method, the Spring Boot application cannot start.

---

# ApplicationContext

```java
ApplicationContext context =
SpringApplication.run(...);
```

### Definition

The **ApplicationContext** is the Spring IoC Container.

It stores all objects (Beans) managed by Spring.

Example:

```
ApplicationContext

│

├── CountryService Bean

├── CountryRepository Bean

├── EntityManager Bean

├── DataSource Bean

└── Hibernate Bean
```

Instead of creating objects manually using:

```java
new CountryService();
```

Spring creates and manages these objects automatically.

---

# Retrieving a Bean

```java
countryService =
context.getBean(CountryService.class);
```

This statement retrieves the `CountryService` object from the Spring IoC Container.

Since Spring already created the object, developers simply request it from the container.

This is one of the core principles of **Dependency Injection (DI)**.

---

# Testing Method

```java
private static void testGetAllCountries() {

    LOGGER.info("Start");

    List<Country> countries =
            countryService.getAllCountries();

    LOGGER.debug("Countries : {}", countries);

    LOGGER.info("End");

}
```

This method performs three simple operations:

1. Displays **Start**.
2. Retrieves all countries from the Service layer.
3. Displays the retrieved country list.
4. Displays **End**.

The output verifies that Spring Data JPA successfully retrieved data from MySQL.

---

# Logging using SLF4J

Instead of using:

```java
System.out.println();
```

this project uses **SLF4J (Simple Logging Facade for Java)**.

Logger declaration:

```java
private static final Logger LOGGER =
LoggerFactory.getLogger(
OrmLearnApplication.class
);
```

---

## Why Logging?

Logging helps developers:

- Monitor application execution.
- Debug problems.
- View SQL queries.
- Record application events.
- Track exceptions.

Logging is preferred over `System.out.println()` because it provides different log levels and better control.

---

## Log Levels

| Log Level | Purpose |
|------------|----------|
| TRACE | Very detailed execution information |
| DEBUG | Debugging information |
| INFO | General application information |
| WARN | Warning messages |
| ERROR | Error messages |

In this exercise:

```java
LOGGER.info("Inside Main");
```

prints:

```
Inside Main
```

while:

```java
LOGGER.debug("Countries : {}", countries);
```

prints the list of countries retrieved from the database.

---

# Execution Flow

The execution flow of the application is shown below.

```
Start Application

        │

        ▼

SpringApplication.run()

        │

        ▼

Spring IoC Container Created

        │

        ▼

Beans Created

        │

        ▼

Database Connected

        │

        ▼

Hibernate Initialized

        │

        ▼

Repository Bean Created

        │

        ▼

Service Bean Created

        │

        ▼

CountryService Retrieved

        │

        ▼

testGetAllCountries()

        │

        ▼

findAll()

        │

        ▼

Hibernate Generates SQL

        │

        ▼

MySQL Executes Query

        │

        ▼

Country Objects Returned

        │

        ▼

Console Displays Countries
```

---

# Internal Working of Spring Data JPA

When the application starts, several operations happen automatically.

## Step 1

Spring Boot scans all packages.

It identifies:

- Entity Classes
- Repository Interfaces
- Service Classes
- Configuration Classes

---

## Step 2

Spring creates Beans for all components.

Example:

- CountryService
- CountryRepository

---

## Step 3

Spring Boot configures Hibernate.

Hibernate scans the `Country` Entity.

It understands that the Entity maps to the `country` table.

---

## Step 4

Spring Boot creates a connection to MySQL using the configuration defined in:

```
application.properties
```

---

## Step 5

When

```java
countryRepository.findAll();
```

is executed,

Spring Data JPA forwards the request to Hibernate.

---

## Step 6

Hibernate converts the Java method call into SQL.

Internally,

```java
findAll();
```

becomes

```sql
SELECT
    co_code,
    co_name
FROM country;
```

---

## Step 7

MySQL executes the SQL query.

The result returned is:

| co_code | co_name |
|----------|----------|
| IN | India |
| US | United States of America |

---

## Step 8

Hibernate converts each row into a Java object.

Example:

```
Database Row

↓

IN

India

↓

Country Object

↓

Country("IN","India")
```

---

## Step 9

Spring Data JPA returns a list of Country objects.

```
List<Country>
```

---

## Step 10

The Service layer returns the list to the Main class.

---

## Step 11

The Logger prints:

```
Countries :
[
Country{code='IN', name='India'},
Country{code='US', name='United States of America'}
]
```

---

# How findAll() Works

One of the biggest advantages of Spring Data JPA is that developers do not implement CRUD methods manually.

When the application executes:

```java
countryRepository.findAll();
```

Spring Data JPA internally performs the following steps:

```
findAll()

        │

        ▼

JpaRepository

        │

        ▼

Hibernate

        │

        ▼

SQL Generated

        │

        ▼

SELECT * FROM country

        │

        ▼

MySQL Database

        │

        ▼

Country Objects

        │

        ▼

List<Country>
```

The developer writes only one line of code, while Spring Data JPA performs all database operations internally.

---

# Complete Application Flow

The overall architecture of this exercise is shown below.

```
MySQL Database

        │

        ▼

Country Table

        │

        ▼

Hibernate ORM

        │

        ▼

Spring Data JPA

        │

        ▼

CountryRepository

        │

        ▼

CountryService

        │

        ▼

OrmLearnApplication

        │

        ▼

Logger

        │

        ▼

Console Output
```

This layered architecture separates responsibilities:

- **Database Layer** stores the data.
- **Hibernate Layer** maps Java objects to database tables.
- **Repository Layer** performs database operations.
- **Service Layer** contains business logic.
- **Application Layer** starts the program.
- **Logger** displays execution details.

This separation improves maintainability, readability, and scalability of the application.

---

# Running the Application

After completing the implementation, the application can be executed directly from IntelliJ IDEA.

Open:

```
OrmLearnApplication.java
```

Run the `main()` method.

```java
SpringApplication.run(
        OrmLearnApplication.class,
        args
);
```

When the application starts successfully, Spring Boot automatically performs the following tasks:

- Starts the Spring IoC Container.
- Scans all project packages.
- Creates all required Spring Beans.
- Establishes a connection with the MySQL database.
- Initializes Hibernate.
- Creates Repository and Service Beans.
- Executes the `main()` method.
- Retrieves all countries from the database.

If everything is configured correctly, the console displays logs similar to:

```
Inside Main

Start

Countries :
[
Country{code='IN', name='India'},
Country{code='US', name='United States of America'}
]

End
```

This confirms that Spring Boot successfully connected to the database and retrieved the records.

---

# Verifying Data in MySQL

Open **MySQL Workbench**.

Execute:

```sql
USE ormlearn;
```

Verify the Country table:

```sql
SELECT * FROM country;
```

Expected Output:

| co_code | co_name |
|----------|----------|
| IN | India |
| US | United States of America |

This confirms that the application is reading data from the correct database.

---

# Expected Console Output

When the application runs successfully, the console should display messages similar to:

```
Inside Main

Start

Countries :
[
Country{code='IN', name='India'},
Country{code='US', name='United States of America'}
]

End
```

Hibernate also generates SQL similar to:

```sql
select
    c1_0.co_code,
    c1_0.co_name
from
    country c1_0;
```

This verifies that the `findAll()` method executed successfully.

---

# Output Screenshots

Include the following screenshots inside the **Output** folder.

- Spring Boot application started successfully.
- IntelliJ Console displaying retrieved countries.
- MySQL Workbench showing the `country` table.
- Project Structure.
- Successful execution of SQL query in MySQL.

These screenshots serve as proof that the exercise has been implemented and executed successfully.

---

# Advantages of Spring Data JPA

Spring Data JPA offers several advantages over traditional database programming.

## 1. Reduced Boilerplate Code

Developers do not need to write JDBC code for:

- Creating database connections.
- Executing SQL queries.
- Processing ResultSets.
- Closing database resources.

---

## 2. Automatic CRUD Operations

Common database operations are already implemented.

Examples include:

- save()
- findAll()
- findById()
- delete()
- deleteById()

No manual implementation is required.

---

## 3. Better Maintainability

The code is divided into separate layers:

- Entity Layer
- Repository Layer
- Service Layer

This improves readability and makes the application easier to maintain.

---

## 4. ORM Support

Hibernate automatically maps Java objects to database tables.

Developers work with Java objects instead of SQL queries.

---

## 5. Database Independence

The application can easily switch from MySQL to Oracle, PostgreSQL, or SQL Server with minimal configuration changes.

---

## 6. Integration with Spring Boot

Spring Boot automatically configures:

- DataSource
- Hibernate
- EntityManager
- Transaction Management

This significantly reduces configuration effort.

---

# Common Errors and Solutions

## Error

```
Access denied for user 'root'
```

### Solution

Verify the username and password specified in `application.properties`.

---

## Error

```
Unknown database 'ormlearn'
```

### Solution

Create the database before running the application.

```sql
CREATE DATABASE ormlearn;
```

---

## Error

```
Table 'country' doesn't exist
```

### Solution

Create the `country` table and insert the required sample data before executing the application.

---

## Error

```
Communications link failure
```

### Solution

Ensure that the MySQL Server is running and that the port number is correct.

---

## Error

```
BeanCreationException
```

### Solution

Verify:

- Entity annotations
- Repository interface
- Service class
- Package structure
- Spring Boot dependencies

---

## Error

```
Not a managed type
```

### Solution

Ensure that the Entity class is annotated with:

```java
@Entity
```

and is located within the package scanned by Spring Boot.

---

# Interview Questions

## 1. What is ORM?

**Answer**

ORM (Object-Relational Mapping) is a technique that maps Java objects to relational database tables, allowing developers to work with objects instead of writing SQL queries manually.

---

## 2. What is JPA?

**Answer**

JPA (Java Persistence API) is a Java specification that defines standards for Object-Relational Mapping. It provides interfaces and annotations but does not provide an implementation.

---

## 3. Is JPA a framework?

**Answer**

No.

JPA is only a specification.

Frameworks such as Hibernate implement JPA.

---

## 4. What is Hibernate?

**Answer**

Hibernate is an ORM framework that implements JPA and automatically converts Java object operations into SQL queries.

---

## 5. What is Spring Data JPA?

**Answer**

Spring Data JPA is a Spring module that simplifies database access by providing Repository interfaces with built-in CRUD operations.

---

## 6. What is an Entity?

**Answer**

An Entity is a Java class annotated with `@Entity` that represents a table in a relational database.

---

## 7. What is the purpose of `@Table`?

**Answer**

`@Table` maps an Entity class to a specific database table.

---

## 8. Why is `@Id` required?

**Answer**

`@Id` identifies the primary key of the Entity.

Every database table requires a unique identifier.

---

## 9. What is `JpaRepository`?

**Answer**

`JpaRepository` is a Spring Data JPA interface that provides built-in CRUD methods such as `save()`, `findAll()`, `findById()`, and `delete()`.

---

## 10. What is `@Transactional`?

**Answer**

`@Transactional` ensures that a method executes within a database transaction, providing data consistency and automatic rollback in case of failures.

---

## 11. What is the purpose of `ApplicationContext`?

**Answer**

`ApplicationContext` is the Spring IoC Container that creates, stores, and manages all Spring Beans.

---

## 12. Why do we use `@Autowired`?

**Answer**

`@Autowired` automatically injects dependent Beans into a class, eliminating the need for manual object creation.

---

## Key Learnings

After completing this exercise, you have learned:

- Spring Data JPA Fundamentals
- Object-Relational Mapping (ORM)
- Java Persistence API (JPA)
- Hibernate ORM
- Spring Boot and MySQL Integration
- Entity Mapping
- Repository Pattern
- Service Layer
- Dependency Injection
- Spring IoC Container
- Transaction Management
- Logging using SLF4J
- Hibernate SQL Generation
- Database Retrieval using `findAll()`
- Layered Application Architecture

---

# Conclusion

This exercise demonstrates how **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL** work together to build a simple yet powerful database-driven application.

Instead of writing complex JDBC code, the application uses **Spring Data JPA** to retrieve country details with a single repository method. Hibernate automatically converts Java operations into SQL queries, while Spring Boot manages configuration, dependency injection, transaction management, and database connectivity.

By implementing this exercise, you have learned how to configure a Spring Boot project, connect it to a MySQL database, create Entity, Repository, and Service classes, retrieve records using `findAll()`, and understand the internal execution flow of a Spring Data JPA application.

These concepts provide the foundation for upcoming topics such as **custom query methods**, **CRUD operations**, **entity relationships (O/R Mapping)**, **Hibernate Query Language (HQL)**, **Native Queries**, and advanced Spring Data JPA features used in enterprise applications.

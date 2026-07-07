# Exercise 4: Add a New Country

## Week 2 – Spring Framework

### Module
**Spring Data JPA with Spring Boot & Hibernate**

### Exercise
**Exercise 4: Add a New Country**

---

# Introduction

Modern enterprise applications frequently require storing new information in a database. Whether it is adding a new customer in a banking system, registering a new student in a university portal, creating a new employee in a Human Resource Management System, or adding a new product in an e-commerce application, inserting new records into a database is one of the most common operations performed by business applications.

In traditional Java applications, inserting data into a database required writing several lines of JDBC code, including creating database connections, writing SQL `INSERT` statements, preparing queries, executing them, handling exceptions, and closing resources manually.

Spring Data JPA simplifies this entire process by providing built-in repository methods. One such method is **`save()`**, which allows developers to persist Java objects into a database without writing SQL queries manually.

In this exercise, we extend the **Country Management System** created in the previous exercises by implementing functionality to insert a new country into the MySQL database using Spring Data JPA. After inserting the country, the application retrieves the same record using its country code to verify that the insertion was successful.

This exercise demonstrates how Spring Boot, Spring Data JPA, Hibernate, and MySQL work together to perform database insertion operations efficiently.

---

# Objective

The primary objective of this exercise is to understand how Spring Data JPA inserts new records into a database using the built-in `save()` method.

After completing this exercise, you will be able to:

- Understand how the `save()` method works.
- Insert new records into a MySQL database.
- Use the Service layer to perform business operations.
- Understand transaction management using `@Transactional`.
- Verify inserted records using `findById()`.
- Understand how Hibernate generates SQL `INSERT` statements automatically.
- Learn the internal execution flow of Spring Data JPA during persistence operations.

---

# Scenario

A software company is developing a **Library Management System**.

The application maintains information about different countries because they are used while storing publisher details, author information, branch locations, and library addresses.

Initially, the application was capable of displaying all countries and retrieving a country using its country code.

Now the business requirement has changed.

The administrator should be able to add a new country whenever required.

For example,

```
Administrator

        │

        ▼

Enter Country Details

        │

        ▼

Country Code : NP

Country Name : Nepal

        │

        ▼

Save Country

        │

        ▼

Database Updated

        │

        ▼

Retrieve Newly Added Country

        │

        ▼

Display Country Details
```

The application should save the new country in the database and verify the insertion by retrieving the same country using its country code.

---

# Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Spring Boot | Application Framework |
| Spring Data JPA | Persistence Layer |
| Hibernate | ORM Framework |
| MySQL | Relational Database |
| Maven | Dependency Management |
| IntelliJ IDEA | Integrated Development Environment |
| SLF4J | Logging Framework |

---

# Prerequisites

Before implementing this exercise, you should be familiar with the following concepts:

- Core Java
- Object-Oriented Programming (OOP)
- Exception Handling
- Collections Framework
- Spring Boot Basics
- Spring IoC Container
- Dependency Injection
- Spring Data JPA
- Hibernate
- MySQL
- CRUD Operations

Knowledge of the previous exercises is recommended because this exercise extends the same project.

Specifically:

- Spring Data JPA – Quick Example
- Find Country Based on Country Code

---

# What is CRUD?

CRUD represents the four basic operations that every database-driven application performs.

CRUD stands for:

| Operation | Description |
|-----------|-------------|
| **Create** | Insert new data into the database |
| **Read** | Retrieve data from the database |
| **Update** | Modify existing records |
| **Delete** | Remove records from the database |

Almost every enterprise application performs these four operations.

Examples include:

- Banking Applications
- E-Commerce Websites
- Hospital Management Systems
- Student Management Systems
- Employee Management Systems

In this exercise, we focus on the **Create** operation.

---

# What is the `save()` Method?

### Definition

`save()` is a built-in method provided by the `JpaRepository` interface.

It is used to store an Entity object in the database.

Unlike traditional JDBC programming, developers do not need to write SQL `INSERT` statements manually.

Instead, they simply pass the Entity object to the `save()` method.

Example:

```java
countryRepository.save(country);
```

Spring Data JPA automatically delegates the operation to Hibernate, which generates the required SQL query and executes it.

---

# How Does `save()` Work?

The `save()` method accepts an Entity object as input.

Example:

```java
Country country = new Country();

country.setCode("NP");
country.setName("Nepal");

countryRepository.save(country);
```

Internally, Hibernate converts this Java object into a database row.

```
Country Object

↓

Country(code="NP", name="Nepal")

↓

Hibernate

↓

INSERT INTO country

↓

MySQL Database
```

Thus, developers work with Java objects instead of SQL queries.

---

# Insert vs Update

One interesting feature of the `save()` method is that it can perform both **INSERT** and **UPDATE** operations depending on whether the primary key already exists.

### Case 1: Insert

If the primary key does **not** exist in the database, Hibernate generates an `INSERT` statement.

Example:

```java
country.setCode("ZZ");
country.setName("Sample Country");
```

Generated SQL:

```sql
INSERT INTO country (co_code, co_name)
VALUES ('ZZ', 'Sample Country');
```

A new row is created.

---

### Case 2: Update

If the primary key already exists, Hibernate treats the operation as an update.

Example:

```java
country.setCode("IN");
country.setName("Republic of India");
```

Hibernate updates the existing record instead of inserting a duplicate.

This intelligent behavior makes the `save()` method one of the most powerful features of Spring Data JPA.

---

# Why Use Spring Data JPA Instead of JDBC?

Without Spring Data JPA, developers would need to:

- Create a database connection.
- Write an SQL `INSERT` statement.
- Create a `PreparedStatement`.
- Bind parameters.
- Execute the query.
- Handle SQL exceptions.
- Close the connection.

Using Spring Data JPA, the same operation requires only one line of code:

```java
countryRepository.save(country);
```

This significantly reduces boilerplate code and improves maintainability.

---

# Learning Outcomes

After completing this exercise, you will be able to:

- Insert new records into a database using Spring Data JPA.
- Explain the purpose of the `save()` method.
- Differentiate between `INSERT` and `UPDATE` operations performed by `save()`.
- Understand how Hibernate converts Java objects into database records.
- Use the Service layer to perform business operations.
- Apply `@Transactional` for database modifications.
- Verify inserted records using repository methods.
- Explain the complete execution flow of a persistence operation in a Spring Boot application.

---

# Project Structure

This exercise continues the same **Spring Boot** project created in the previous hands-on exercises. Only the required classes are modified to implement the functionality of adding a new country into the database.

The project follows the standard Maven directory structure generated using **Spring Initializr**.

```
Exercise_4_Add_New_Country
│
├── README.md
├── pom.xml
├── .gitignore
│
├── src
│   ├── main
│   │   ├── java
│   │   │
│   │   │   └── com.cognizant.orm_learn
│   │   │         │
│   │   │         ├── model
│   │   │         │      └── Country.java
│   │   │         │
│   │   │         ├── repository
│   │   │         │      └── CountryRepository.java
│   │   │         │
│   │   │         ├── service
│   │   │         │      ├── CountryService.java
│   │   │         │      └── exception
│   │   │         │             └── CountryNotFoundException.java
│   │   │         │
│   │   │         └── OrmLearnApplication.java
│   │   │
│   │   └── resources
│   │          └── application.properties
│   │
│   └── test
│
└── Output
    ├── Console_Output.png
    ├── Database_Output.png
    └── Project_Structure.png
```

---

# Folder Description

| Folder | Purpose |
|----------|----------|
| model | Contains Entity classes that represent database tables. |
| repository | Contains Repository interfaces for database operations. |
| service | Contains business logic. |
| exception | Contains custom exception classes. |
| resources | Contains application configuration files. |

---

# File Description

| File | Description |
|------|-------------|
| Country.java | Entity class mapped to the Country table. |
| CountryRepository.java | Repository interface that performs CRUD operations. |
| CountryService.java | Contains business methods such as retrieving and saving countries. |
| CountryNotFoundException.java | Custom exception thrown when a country is not found. |
| OrmLearnApplication.java | Main class that starts the Spring Boot application. |
| application.properties | Stores database and Hibernate configuration. |

---

# Implementation

The implementation of this exercise can be divided into five simple steps.

---

# Step 1 : Create a Country Object

The first step is to create a Java object representing the country that needs to be inserted into the database.

Example:

```java
Country country = new Country();

country.setCode("NP");
country.setName("Nepal");
```

The object now contains the following data:

```
Country

↓

Code : NP

Name : Nepal
```

At this stage, the object exists only in memory.

No database operation has been performed yet.

---

# Step 2 : Service Layer

Package

```
com.cognizant.orm_learn.service
```

Class

```
CountryService.java
```

The Service layer contains the business logic of the application.

Instead of calling the Repository directly from the Main class, the request passes through the Service layer.

This follows the layered architecture used in enterprise Spring applications.

---

## @Service

```java
@Service
```

Marks the class as a Spring Service component.

Spring automatically creates an object (Bean) of this class during application startup.

---

## @Autowired

```java
@Autowired
private CountryRepository countryRepository;
```

Automatically injects the Repository Bean into the Service class.

Developers do not create the Repository object manually.

Spring performs Dependency Injection automatically.

---

## @Transactional

```java
@Transactional
```

This annotation tells Spring that the method should execute within a database transaction.

If every operation completes successfully,

```
Transaction

↓

Commit
```

If an error occurs,

```
Transaction

↓

Rollback
```

This guarantees data consistency.

---

# addCountry()

The new method introduced in this exercise is:

```java
@Transactional
public void addCountry(Country country){

    countryRepository.save(country);

}
```

This method performs only one operation.

```
Receive Country Object

↓

Call Repository

↓

Save Object

↓

Return
```

Although the implementation contains only one line of code, Spring Data JPA internally performs many operations.

---

# Step 3 : Repository Layer

Package

```
com.cognizant.orm_learn.repository
```

Interface

```
CountryRepository.java
```

The Repository layer communicates directly with the database.

It extends:

```java
JpaRepository<Country,String>
```

The two generic parameters represent:

| Parameter | Meaning |
|------------|---------|
| Country | Entity Class |
| String | Primary Key Type |

Because the Country code is a String,

```java
JpaRepository<Country,String>
```

is used.

---

# save()

The Repository provides the built-in method:

```java
save(country);
```

Developers do not implement this method.

Spring Data JPA automatically provides its implementation.

Internally,

```
save()

↓

EntityManager

↓

Hibernate

↓

SQL INSERT

↓

Database
```

---

# Step 4 : Main Class

The application is executed from

```
OrmLearnApplication.java
```

The main method performs the following operations.

```
Start Spring Boot

↓

Create IoC Container

↓

Create Beans

↓

Get CountryService Bean

↓

Call testAddCountry()
```

---

# testAddCountry()

The new test method performs four tasks.

### Task 1

Create a Country object.

```java
Country country = new Country();
```

---

### Task 2

Assign values.

```java
country.setCode("NP");

country.setName("Nepal");
```

---

### Task 3

Save the Country.

```java
countryService.addCountry(country);
```

---

### Task 4

Retrieve the Country.

```java
Country addedCountry =
countryService.findCountryByCode("NP");
```

---

### Task 5

Display the Country.

```java
LOGGER.debug("Country : {}", addedCountry);
```

Console Output:

```
Country{code='NP', name='Nepal'}
```

---

# Data Flow

The complete data flow is shown below.

```
Country Object

↓

CountryService

↓

CountryRepository

↓

save()

↓

Hibernate

↓

INSERT Query

↓

MySQL

↓

Country Table
```

---

# Bean Communication

Spring manages all application components as Beans.

The communication between Beans is illustrated below.

```
OrmLearnApplication

↓

CountryService Bean

↓

CountryRepository Bean

↓

Hibernate

↓

MySQL Database
```

Each Bean has a single responsibility, making the application modular and maintainable.

---

# Why Do We Use a Service Layer?

Instead of directly calling the Repository from the Main class, we use the Service layer because it:

- Separates business logic from data access.
- Improves maintainability.
- Makes testing easier.
- Encourages code reuse.
- Follows enterprise application architecture.

This layered approach is one of the core design principles of Spring Boot applications.

---

# Summary of Implementation

The implementation consists of the following sequence:

1. Create a `Country` object.
2. Assign a country code and country name.
3. Pass the object to `CountryService`.
4. `CountryService` calls `countryRepository.save()`.
5. Spring Data JPA delegates the request to Hibernate.
6. Hibernate generates the SQL `INSERT` statement.
7. MySQL stores the new record.
8. The application retrieves the same country using `findCountryByCode()`.
9. The retrieved object is displayed in the console, confirming that the record has been successfully inserted.

---

# Internal Working

Although inserting a new country into the database requires only a single line of code:

```java
countryRepository.save(country);
```

many operations take place internally before the data is actually stored in the database.

Spring Boot, Spring Data JPA, Hibernate, and MySQL work together behind the scenes to complete the operation.

Understanding this internal workflow helps developers understand how Spring applications interact with relational databases.

---

# Complete Execution Flow

The following diagram illustrates the complete flow of this exercise.

```
Application Starts

        │

        ▼

Spring Boot Application

        │

        ▼

Spring IoC Container

        │

        ▼

CountryService Bean

        │

        ▼

addCountry()

        │

        ▼

CountryRepository

        │

        ▼

save()

        │

        ▼

Spring Data JPA

        │

        ▼

Hibernate

        │

        ▼

Generate SQL INSERT

        │

        ▼

MySQL Database

        │

        ▼

Country Table Updated

        │

        ▼

findCountryByCode()

        │

        ▼

Retrieve Country

        │

        ▼

Console Output
```

---

# Step-by-Step Execution

## Step 1 : Application Startup

Execution begins from:

```java
public static void main(String[] args)
```

The application starts using:

```java
ApplicationContext context =
SpringApplication.run(
        OrmLearnApplication.class,
        args);
```

Spring Boot performs several initialization tasks automatically.

---

## Step 2 : Creating the IoC Container

Spring creates the **Inversion of Control (IoC) Container**.

The IoC Container is responsible for:

- Creating Beans
- Managing Bean lifecycle
- Injecting dependencies
- Managing transactions

Beans created include:

- CountryService
- CountryRepository
- EntityManager
- DataSource
- TransactionManager

---

## Step 3 : Dependency Injection

Spring injects the Repository Bean into the Service Bean.

```
CountryService

↓

@Autowired

↓

CountryRepository
```

Developers never create these objects manually.

---

## Step 4 : Creating the Country Object

Inside the test method:

```java
Country country = new Country();

country.setCode("NP");

country.setName("Nepal");
```

The object exists only in JVM memory.

```
Heap Memory

↓

Country

Code = NP

Name = Nepal
```

At this stage, the database has not been modified.

---

## Step 5 : Calling addCountry()

The following statement is executed.

```java
countryService.addCountry(country);
```

Control moves to the Service layer.

---

## Step 6 : Transaction Begins

The method contains:

```java
@Transactional
```

Spring opens a database transaction before executing the method.

```
Transaction Started

↓

Execute Database Operation

↓

Commit / Rollback
```

Transactions ensure that the database remains consistent.

---

## Step 7 : Repository Method

The Service layer executes:

```java
countryRepository.save(country);
```

Control moves to Spring Data JPA.

---

# How save() Works

Developers call only:

```java
save(country);
```

Internally:

```
save()

↓

JpaRepository

↓

SimpleJpaRepository

↓

EntityManager

↓

Hibernate

↓

Generate SQL

↓

Execute Query
```

The framework hides all implementation details from the developer.

---

# Persistence Context

Before inserting the entity into the database, Hibernate places it inside the **Persistence Context**.

```
Country Object

↓

Persistence Context

↓

Managed Entity

↓

Database
```

The Persistence Context keeps track of every managed entity.

If changes occur before the transaction commits, Hibernate automatically synchronizes them with the database.

---

# SQL Generation

Developers never write SQL manually.

Hibernate automatically generates SQL similar to:

```sql
INSERT INTO country
(co_name, co_code)
VALUES (?, ?);
```

The actual values are:

```
Parameter 1

↓

Nepal

Parameter 2

↓

NP
```

Hibernate binds these values and executes the query.

---

# Database Operation

MySQL receives:

```sql
INSERT INTO country
(co_name, co_code)
VALUES
('Nepal','NP');
```

The database inserts a new row.

```
Country Table

-------------------------

NP

Nepal
```

---

# Transaction Commit

If no errors occur,

Spring commits the transaction.

```
Transaction

↓

Commit

↓

Data Saved Permanently
```

The inserted record now becomes a permanent part of the database.

---

# Verifying the Insert

Immediately after saving the object,

the application executes:

```java
Country addedCountry =
countryService.findCountryByCode("NP");
```

The application retrieves the same record to verify that the insertion was successful.

---

# SQL Generated During Verification

Hibernate generates another SQL statement.

```sql
SELECT
co_code,
co_name
FROM country
WHERE co_code=?
```

Parameter:

```
NP
```

The database returns:

```
NP

Nepal
```

Hibernate converts the database row back into a Java object.

---

# Object Mapping

Hibernate performs Object-Relational Mapping (ORM).

```
Database Row

↓

NP

Nepal

↓

Country Object

↓

Country

code = NP

name = Nepal
```

This conversion happens automatically.

---

# Bean Communication

The communication between Spring Beans is illustrated below.

```
OrmLearnApplication

        │

        ▼

CountryService Bean

        │

        ▼

CountryRepository Bean

        │

        ▼

EntityManager

        │

        ▼

Hibernate

        │

        ▼

MySQL Database
```

Each Bean has a specific responsibility.

---

# Layered Architecture

This project follows the layered architecture commonly used in enterprise applications.

```
Presentation Layer

↓

OrmLearnApplication

↓

Business Layer

↓

CountryService

↓

Persistence Layer

↓

CountryRepository

↓

Database Layer

↓

MySQL
```

Separating responsibilities into layers improves:

- Code readability
- Maintainability
- Reusability
- Scalability
- Testability

---

# Sequence Diagram

The sequence of interactions is shown below.

```
User

│

▼

OrmLearnApplication

│

▼

CountryService

│

▼

CountryRepository

│

▼

Spring Data JPA

│

▼

Hibernate

│

▼

MySQL Database

│

▼

Country Table

│

▼

Country Object

│

▼

Console Output
```

---

# Why Use Spring Data JPA?

Without Spring Data JPA, developers would manually write:

- JDBC Connection
- SQL INSERT Statement
- PreparedStatement
- Parameter Binding
- Exception Handling
- Transaction Management
- Connection Closing

With Spring Data JPA, the same task is reduced to:

```java
countryRepository.save(country);
```

This significantly reduces boilerplate code and allows developers to focus on business logic rather than database management.

---

# Summary of Internal Working

The complete insertion process can be summarized as follows:

```
Create Country Object

↓

Call addCountry()

↓

Service Layer

↓

Repository Layer

↓

save()

↓

Spring Data JPA

↓

Hibernate

↓

Generate INSERT SQL

↓

Execute SQL

↓

Commit Transaction

↓

Retrieve Country

↓

Display Output
```

This demonstrates how Spring Data JPA simplifies database persistence by combining the power of Spring Boot, Hibernate, and JPA into a clean and developer-friendly programming model.

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
- Reads the configuration from `application.properties`.
- Establishes a connection with the MySQL database.
- Initializes Hibernate.
- Creates all required Spring Beans.
- Creates a new `Country` object.
- Saves the Country object into the database.
- Retrieves the same Country using its country code.
- Displays the retrieved Country in the console.

If everything is configured correctly, the console displays output similar to:

```
Start

Hibernate:
insert into country
(co_name, co_code)
values (?, ?)

Hibernate:
select
co_code,
co_name
from country
where co_code=?

Country : Country{code='NP', name='Nepal'}

End
```

This confirms that the country has been successfully inserted and retrieved from the database.

---

# Verifying the Database

Open **MySQL Workbench**.

Select the database:

```sql
USE ormlearn;
```

Execute:

```sql
SELECT * FROM country
WHERE co_code='NP';
```

Expected Output:

| co_code | co_name |
|----------|----------|
| NP | Nepal |

If you use another test code such as **ZZ** or **TS**, replace **NP** with the corresponding code.

This confirms that the data has been stored successfully in the database.

---

# Expected Console Output

The console should display logs similar to the following:

```
Started OrmLearnApplication

Start

Hibernate:
insert into country
(co_name, co_code)
values (?, ?)

Hibernate:
select
co_code,
co_name
from country
where co_code=?

Country : Country{code='NP', name='Nepal'}

End
```

The generated SQL confirms that Hibernate executed both the **INSERT** and **SELECT** operations successfully.

---

# Executed Output

<img width="1918" height="1022" alt="Output" src="https://github.com/user-attachments/assets/3627e453-3320-4644-81c5-f9cd0fd2ae53" />

---

# Output Screenshots

Include the following screenshots inside the **Output** folder.

- IntelliJ Project Structure.
- Spring Boot Console Output.
- MySQL Workbench displaying the inserted country.
- Successful execution of the SQL query.

These screenshots demonstrate that the application has been implemented and executed successfully.

---

# Advantages of Using save()

The `save()` method provides several advantages.

## 1. Eliminates Manual SQL

Developers do not need to write SQL `INSERT` statements manually.

---

## 2. Automatic Object Mapping

Hibernate automatically converts Java objects into database rows.

```
Country Object

↓

Hibernate

↓

Database Record
```

---

## 3. Supports Both Insert and Update

The same method can perform:

- INSERT
- UPDATE

depending on whether the primary key already exists.

---

## 4. Transaction Support

When used with:

```java
@Transactional
```

Spring automatically manages database transactions.

If an error occurs,

```
Rollback
```

is performed automatically.

---

## 5. Less Boilerplate Code

Instead of writing hundreds of lines of JDBC code, developers simply write:

```java
countryRepository.save(country);
```

This improves readability and maintainability.

---

# Common Errors and Solutions

## Error

```
Duplicate entry for primary key
```

### Cause

The country code already exists in the database.

### Solution

Use a unique country code before inserting a new record.

---

## Error

```
Country not found
```

### Cause

The application attempts to retrieve a country that does not exist.

### Solution

Verify that the record was inserted successfully before searching.

---

## Error

```
Access denied for user
```

### Cause

Incorrect MySQL username or password.

### Solution

Verify the credentials in:

```properties
spring.datasource.username

spring.datasource.password
```

---

## Error

```
Table 'country' doesn't exist
```

### Cause

The Country table has not been created.

### Solution

Create the table before running the application.

---

## Error

```
No qualifying bean found
```

### Cause

Spring could not locate the required Bean.

### Solution

Verify:

- `@Service`
- `@Repository`
- Package structure
- Component scanning

---

## Error

```
Transaction rolled back
```

### Cause

An exception occurred during the save operation.

### Solution

Check the exception stack trace and verify that the inserted data satisfies database constraints.

---

# Interview Questions

## 1. What is the purpose of the `save()` method?

**Answer**

The `save()` method inserts a new Entity into the database or updates an existing Entity if the primary key already exists.

---

## 2. Which interface provides the `save()` method?

**Answer**

`JpaRepository`.

---

## 3. Does `save()` always perform an INSERT?

**Answer**

No.

If the primary key does not exist, it performs an **INSERT**.

If the primary key already exists, it performs an **UPDATE**.

---

## 4. What annotation is used for transaction management?

**Answer**

`@Transactional`.

---

## 5. Why is `@Transactional` important?

**Answer**

It ensures that all database operations execute as a single transaction.

If an error occurs, the transaction is rolled back automatically.

---

## 6. Which layer calls `save()`?

**Answer**

The Service layer invokes `save()` through the Repository layer.

---

## 7. Which component generates SQL?

**Answer**

Hibernate generates SQL statements automatically.

---

## 8. What is ORM?

**Answer**

Object-Relational Mapping (ORM) is the process of mapping Java objects to relational database tables.

---

## 9. What is the role of the Repository layer?

**Answer**

The Repository layer communicates with the database using Spring Data JPA.

---

## 10. Why is Spring Data JPA preferred over JDBC?

**Answer**

It reduces boilerplate code, automatically generates SQL, manages transactions, and improves maintainability.

---

## 11. Can `save()` update an existing record?

**Answer**

Yes.

If an Entity with the same primary key already exists, `save()` updates that record instead of inserting a duplicate.

---

## 12. What happens after calling `save()`?

**Answer**

Hibernate generates an SQL `INSERT` or `UPDATE` statement, executes it, and synchronizes the Entity with the database.

---

## 13. Why do we verify the inserted record?

**Answer**

To ensure that the persistence operation completed successfully and that the data was stored correctly.

---

## 14. What is the benefit of using a Service layer?

**Answer**

The Service layer separates business logic from data access, making the application easier to maintain and test.

---

## 15. What is the role of Hibernate in this exercise?

**Answer**

Hibernate maps the Java `Country` object to the database table, generates the SQL query, executes it, and manages the persistence process.

---

# Key Learnings

After completing this exercise, you have learned:

- CRUD Create Operation
- Spring Data JPA `save()` Method
- Entity Persistence
- Transaction Management
- Hibernate ORM
- Automatic SQL Generation
- Repository Pattern
- Service Layer
- Layered Architecture
- Spring Bean Management
- Object-Relational Mapping (ORM)
- Verifying Persisted Data

---

# Conclusion

This exercise demonstrates how **Spring Data JPA** simplifies the process of inserting new records into a relational database using the built-in `save()` method.

Instead of writing manual SQL statements and JDBC code, developers simply create an Entity object and pass it to the Repository. Spring Data JPA delegates the request to Hibernate, which automatically generates the required SQL `INSERT` statement and persists the data in the MySQL database.

The exercise also highlights the importance of the **Service layer**, **transaction management**, and **Hibernate's Object-Relational Mapping (ORM)** capabilities. By retrieving the same record after insertion, the application verifies that the data has been successfully stored.

Understanding the `save()` method is essential because it forms the foundation for implementing complete CRUD operations in Spring Boot applications. These concepts will be extended further in upcoming exercises involving **Update**, **Delete**, **Custom Query Methods**, **Entity Relationships**, **JPQL**, and **Native Queries**.

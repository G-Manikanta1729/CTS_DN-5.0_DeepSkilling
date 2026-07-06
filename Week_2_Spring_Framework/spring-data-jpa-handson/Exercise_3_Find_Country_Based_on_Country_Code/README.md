# Exercise 3: Find Country Based on Country Code

## Week 2 – Spring Framework

### Module
**Spring Data JPA with Spring Boot & Hibernate**

### Exercise
**Exercise 3: Find Country Based on Country Code**

---

# Introduction

Most enterprise applications require retrieving a specific record from a database using a unique identifier. For example, a banking application retrieves an account using the account number, an employee management system retrieves an employee using the employee ID, and an online shopping application retrieves a product using the product ID.

Similarly, in this exercise, a **Country Management System** retrieves a country using its unique **country code**.

In the previous exercise, the application fetched **all countries** from the database using the `findAll()` method. While retrieving all records is useful in many scenarios, enterprise applications often need to retrieve only a single record based on its primary key. Spring Data JPA provides the `findById()` method to accomplish this.

This exercise demonstrates how to retrieve a specific country from a MySQL database using Spring Data JPA, Hibernate, and Spring Boot. It also introduces the concepts of **Optional**, **exception handling**, and **custom exceptions** to safely handle situations where the requested country does not exist.

---

# Objective

The objective of this exercise is to understand how Spring Data JPA retrieves a single entity from a database using its primary key.

After completing this exercise, you will learn:

- How to retrieve a record using `findById()`.
- Why Spring Data JPA returns an `Optional` object.
- How to use the `Optional` class safely.
- How to create and use a custom exception.
- How Hibernate generates SQL for retrieving a single record.
- How Spring Boot, Spring Data JPA, and Hibernate work together to perform database operations.

---

# Scenario

A software company is developing a **Library Management System**.

The application stores information about different countries because they are required for managing publishers, authors, and branch locations.

The country details are stored in a MySQL database.

Initially, the application displayed all countries using the `findAll()` method. Now, the business requirement has changed.

Instead of displaying every country, the application should retrieve only one country using its unique country code.

For example,

```
Country Code

↓

IN

↓

Retrieve

↓

India
```

If the country exists, its details should be displayed.

If the country does not exist, the application should throw a meaningful exception indicating that the requested country could not be found.

This improves application reliability and prevents invalid data from being processed.

---

# Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Spring Boot | Application Framework |
| Spring Data JPA | Database Access Layer |
| Hibernate | ORM Framework |
| MySQL | Relational Database |
| Maven | Dependency Management |
| IntelliJ IDEA | IDE |
| SLF4J | Logging Framework |

---

# Prerequisites

Before performing this exercise, you should understand:

- Core Java
- Object-Oriented Programming (OOP)
- Exception Handling
- Collections Framework
- Java Optional Class
- Spring Boot Basics
- Spring IoC Container
- Dependency Injection
- Spring Data JPA
- Hibernate
- MySQL

Knowledge of **Exercise 1 (Spring Data JPA – Quick Example)** is recommended because this exercise extends the same project.

---

# Concepts Used

## 1. Primary Key

### Definition

A **Primary Key** is a column (or a combination of columns) whose value uniquely identifies each row in a database table.

Every table should have a primary key to ensure that each record can be uniquely identified.

In this project, the **country code** acts as the primary key.

Example:

| Country Code | Country Name |
|--------------|--------------|
| IN | India |
| US | United States of America |
| JP | Japan |

Here, no two countries can have the same country code.

---

## 2. Retrieving Data by Primary Key

In enterprise applications, retrieving a record using its primary key is one of the most common database operations.

Examples:

- Employee → Employee ID
- Student → Roll Number
- Customer → Customer ID
- Book → ISBN
- Country → Country Code

Instead of searching all records, the application directly retrieves the required record using its unique identifier.

---

## 3. What is `findById()`?

### Definition

`findById()` is a built-in method provided by the `JpaRepository` interface.

It retrieves a single entity using its primary key.

Syntax:

```java
findById(ID id)
```

Example:

```java
countryRepository.findById("IN");
```

Here,

- `"IN"` is the primary key.
- Spring Data JPA searches the `country` table.
- Hibernate generates the SQL query.
- If a matching record exists, it is returned.
- Otherwise, an empty result is returned.

Internally, Hibernate generates SQL similar to:

```sql
SELECT
    co_code,
    co_name
FROM
    country
WHERE
    co_code = 'IN';
```

---

## 4. What is `Optional`?

### Definition

`Optional` is a container object introduced in Java 8.

It represents a value that **may or may not be present**.

Instead of returning `null`, Spring Data JPA returns an `Optional` object when using `findById()`.

Example:

```java
Optional<Country> country =
countryRepository.findById("IN");
```

There are two possibilities:

### Case 1: Country Exists

```
Optional

↓

Country("IN","India")
```

The `Optional` object contains a valid `Country`.

---

### Case 2: Country Does Not Exist

```
Optional

↓

Empty
```

The `Optional` object contains no value.

Using `Optional` helps developers avoid `NullPointerException` and encourages explicit handling of missing data.

---

## Why Does Spring Data JPA Return Optional?

Suppose a developer searches for:

```java
countryRepository.findById("XX");
```

If no country with code `"XX"` exists, returning `null` could lead to runtime errors.

By returning an `Optional`, Spring Data JPA forces developers to check whether a value is present before accessing it.

Example:

```java
Optional<Country> result =
countryRepository.findById("IN");

if(result.isPresent()){

    Country country = result.get();

}
```

This makes the application safer and more robust.

---

## 5. What is Exception Handling?

### Definition

Exception Handling is a mechanism that allows a program to detect and handle runtime errors without terminating unexpectedly.

Instead of crashing, the application can display meaningful error messages or take corrective actions.

Example:

Suppose a user searches for a country with code:

```
XX
```

If the country does not exist, the application should not terminate abruptly.

Instead, it should inform the user that the country was not found.

---

## 6. What is a Custom Exception?

A **Custom Exception** is a user-defined exception created to represent a specific business error.

In this exercise, the application defines:

```java
CountryNotFoundException
```

This exception is thrown whenever the requested country code does not exist in the database.

Creating custom exceptions improves code readability and allows developers to handle business-specific scenarios more effectively.

---

# Application Architecture

The overall architecture of this exercise is shown below.

```
Country Code

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

Country Object

        │

        ▼

Console Output
```

Each layer has a specific responsibility:

- **OrmLearnApplication** starts the application and initiates the search.
- **CountryService** contains the business logic.
- **CountryRepository** communicates with the database.
- **Spring Data JPA** provides repository functionality.
- **Hibernate** converts Java operations into SQL.
- **MySQL** stores the country data.

---

# Learning Outcomes

After completing this exercise, you will be able to:

- Retrieve a database record using its primary key.
- Understand how `findById()` works.
- Explain the purpose of `Optional`.
- Handle missing data safely.
- Create and use custom exceptions.
- Understand how Hibernate generates SQL for primary key lookups.
- Explain the complete execution flow of a Spring Data JPA application when retrieving a single entity.

---

# Project Structure

The project follows the standard Maven directory structure generated using **Spring Initializr**. This exercise extends the project created in **Exercise 1 (Spring Data JPA - Quick Example)** by adding the functionality to retrieve a country using its primary key.

```
Exercise_3_Find_Country_Based_on_Country_Code
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
│   │   │         │      ├── CountryService.java
│   │   │         │      │
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

# Folder and File Description

| File / Folder | Description |
|---------------|-------------|
| **pom.xml** | Contains all Maven dependencies required for the project. |
| **application.properties** | Stores MySQL database configuration and Hibernate settings. |
| **Country.java** | Entity class representing the `country` database table. |
| **CountryRepository.java** | Repository interface used to perform database operations. |
| **CountryService.java** | Contains business logic for retrieving a country. |
| **CountryNotFoundException.java** | Custom exception thrown when a country is not found. |
| **OrmLearnApplication.java** | Main class that starts the Spring Boot application. |

---

# Implementation

The implementation of this exercise can be divided into six simple steps.

---

# Step 1 : Configure the Database

The application uses the **ormlearn** database created in the previous exercise.

The `country` table stores information about different countries.

Example:

| Country Code | Country Name |
|--------------|--------------|
| IN | India |
| US | United States of America |
| JP | Japan |
| AU | Australia |

The primary key of this table is:

```
co_code
```

This uniquely identifies every country.

---

# Step 2 : Entity Class

The Entity class used in this exercise is:

```
Country.java
```

The class represents the **country** database table.

Each object of the `Country` class corresponds to one row in the table.

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

The Entity contains two fields:

- code
- name

---

# JPA Annotations Used

## @Entity

```java
@Entity
```

Marks the class as a JPA Entity.

Spring Boot and Hibernate automatically map this class to a database table.

---

## @Table

```java
@Table(name = "country")
```

Specifies the exact database table associated with the Entity.

Without this annotation, Hibernate attempts to determine the table name automatically.

---

## @Id

```java
@Id
```

Identifies the primary key of the Entity.

In this project,

```
co_code
```

is the primary key.

---

## @Column

```java
@Column(name="co_code")
```

Maps a Java field to a database column.

Example:

| Java Field | Database Column |
|------------|-----------------|
| code | co_code |
| name | co_name |

---

# Step 3 : Repository Layer

Package

```
com.cognizant.ormlearn.repository
```

Interface

```
CountryRepository.java
```

The Repository layer acts as the communication layer between the application and the database.

Instead of writing SQL queries manually, Spring Data JPA provides built-in CRUD methods through the `JpaRepository` interface.

The repository declaration is:

```java
public interface CountryRepository
        extends JpaRepository<Country, String> {

}
```

---

# Understanding JpaRepository

The declaration

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

# Built-in Methods Used

The `JpaRepository` interface already provides many methods.

Some commonly used methods include:

- save()
- saveAll()
- findAll()
- findById()
- delete()
- deleteById()
- count()
- existsById()

In this exercise, the application uses:

```java
findById()
```

No implementation is required because Spring Data JPA generates it automatically.

---

## What Does findById() Return?

Unlike `findAll()`, which returns a list of objects,

```java
List<Country>
```

the `findById()` method returns:

```java
Optional<Country>
```

This indicates that the requested country may or may not exist in the database.

---

# Step 4 : Service Layer

Package

```
com.cognizant.ormlearn.service
```

Class

```
CountryService.java
```

The Service layer contains the business logic of the application.

Instead of calling the Repository directly from the main class, all requests pass through the Service layer.

This improves maintainability and follows the layered architecture of Spring applications.

---

## @Service

```java
@Service
```

Marks the class as a Spring Service component.

Spring automatically creates an object (Bean) of this class and manages its lifecycle.

---

## @Autowired

```java
@Autowired
private CountryRepository countryRepository;
```

Automatically injects the `CountryRepository` Bean into the Service class.

Developers do not need to create the Repository object manually using the `new` keyword.

---

## @Transactional

```java
@Transactional
```

Ensures that the method executes within a database transaction.

Even though this exercise performs only a read operation, using `@Transactional` is a standard practice in enterprise applications.

---

# findCountryByCode()

The new method introduced in this exercise is:

```java
public Country findCountryByCode(String countryCode)
```

This method performs the following steps:

1. Accepts the country code as input.
2. Calls `findById()` on the repository.
3. Receives an `Optional<Country>` object.
4. Checks whether the country exists.
5. Returns the `Country` object if found.
6. Throws a custom exception if the country does not exist.

The overall flow is:

```
Country Code

↓

findById()

↓

Optional<Country>

↓

Country Found?

↓

Yes --------> Return Country

No ---------> Throw Exception
```

---

# Step 5 : Optional

The following statement is used inside the service method.

```java
Optional<Country> result =
countryRepository.findById(countryCode);
```

The `Optional` object safely stores the result returned by `findById()`.

There are two possibilities.

### Case 1 : Country Exists

```
Optional

↓

Country("IN","India")
```

The object is retrieved successfully.

---

### Case 2 : Country Does Not Exist

```
Optional

↓

Empty
```

The `Optional` object contains no value.

The application checks this using:

```java
result.isPresent()
```

If the result is empty, a custom exception is thrown.

---

# Step 6 : Custom Exception

Package

```
com.cognizant.ormlearn.service.exception
```

Class

```
CountryNotFoundException.java
```

A custom exception is created to represent a business-specific error.

Instead of throwing a generic exception, the application throws:

```java
CountryNotFoundException
```

whenever the requested country does not exist.

This improves readability and clearly communicates the reason for the error.

Example:

```
User enters

↓

XX

↓

Country not available

↓

Throw CountryNotFoundException
```

Creating custom exceptions is a common practice in enterprise Java applications because it allows developers to handle different business scenarios in a clean and organized manner.

---

# Main Class

The entry point of the application is:

```
OrmLearnApplication.java
```

This class starts the Spring Boot application, loads the Spring IoC Container, retrieves the required Spring Bean, and tests the service method.

The application follows these steps:

1. Starts the Spring Boot application.
2. Creates the Spring IoC Container.
3. Loads all Spring Beans.
4. Retrieves the `CountryService` Bean.
5. Calls the `findCountryByCode()` method.
6. Displays the retrieved country details in the console.

---

# Understanding SpringApplication.run()

The application starts using:

```java
ApplicationContext context =
SpringApplication.run(
        OrmLearnApplication.class,
        args
);
```

### What happens internally?

When this statement executes, Spring Boot performs several tasks automatically.

```
Application Starts

        │

        ▼

Spring Boot Starts

        │

        ▼

Reads application.properties

        │

        ▼

Creates IoC Container

        │

        ▼

Scans Packages

        │

        ▼

Creates Beans

        │

        ▼

Connects to MySQL

        │

        ▼

Initializes Hibernate

        │

        ▼

Application Ready
```

The returned `ApplicationContext` contains all the Spring-managed objects (Beans).

---

# Retrieving the CountryService Bean

The following statement retrieves the service object from the Spring IoC Container.

```java
countryService =
context.getBean(CountryService.class);
```

Spring returns the already created Bean.

Developers do **not** create the object manually using:

```java
new CountryService();
```

This is one of the major advantages of the Spring Framework.

---

# Calling the Service Method

The application invokes:

```java
countryService.findCountryByCode("IN");
```

This begins the complete database retrieval process.

---

# Internal Execution Flow

The complete execution flow of this exercise is shown below.

```
OrmLearnApplication

        │

        ▼

CountryService

        │

        ▼

CountryRepository

        │

        ▼

JpaRepository

        │

        ▼

Hibernate

        │

        ▼

JDBC

        │

        ▼

MySQL Database

        │

        ▼

Country Record

        │

        ▼

Country Object

        │

        ▼

Console Output
```

Each layer has a specific responsibility.

---

# Detailed Execution Flow

## Step 1

Application starts.

```
main()

↓

SpringApplication.run()
```

---

## Step 2

Spring creates all required Beans.

Examples:

- CountryService
- CountryRepository
- EntityManager
- DataSource

---

## Step 3

The Service method is called.

```
findCountryByCode("IN")
```

---

## Step 4

The Service delegates the request to the Repository.

```
countryRepository.findById("IN")
```

---

## Step 5

Spring Data JPA delegates the request to Hibernate.

---

## Step 6

Hibernate generates SQL.

Example:

```sql
SELECT
co_code,
co_name
FROM country
WHERE co_code='IN';
```

---

## Step 7

MySQL executes the SQL query.

---

## Step 8

The database returns the matching row.

```
IN

India
```

---

## Step 9

Hibernate converts the database row into a Java object.

```
Database Row

↓

Country Object
```

---

## Step 10

The Service returns the Country object.

---

## Step 11

The Main class prints the Country object.

Console Output:

```
Country{code='IN', name='India'}
```

---

# How findById() Works Internally

Developers simply write:

```java
countryRepository.findById("IN");
```

Internally, Spring Data JPA performs several operations automatically.

```
findById()

        │

        ▼

JpaRepository

        │

        ▼

EntityManager

        │

        ▼

Hibernate

        │

        ▼

Generate SQL

        │

        ▼

Execute Query

        │

        ▼

Receive Result

        │

        ▼

Create Country Object

        │

        ▼

Return Optional<Country>
```

Developers only write one line of code, while the framework handles the remaining work.

---

# Understanding Optional

The method

```java
findById()
```

returns

```java
Optional<Country>
```

instead of

```java
Country
```

This is because the requested record may or may not exist.

---

## Case 1 : Country Exists

```
findById("IN")

↓

Optional

↓

Country

↓

India
```

The Optional object contains a valid Country.

---

## Case 2 : Country Does Not Exist

```
findById("XX")

↓

Optional

↓

Empty
```

The Optional object contains no value.

This prevents the application from throwing a `NullPointerException`.

---

# Checking Optional

The application checks whether the object exists.

```java
if(result.isPresent()){
```

If true,

```
Country Found
```

Otherwise,

```
Country Not Found
```

---

# Retrieving the Country Object

If the Country exists,

```java
Country country =
result.get();
```

The Country object is extracted from the Optional container and returned.

---

# Exception Handling Flow

Suppose the user searches for:

```
XX
```

The execution becomes:

```
findById("XX")

↓

Optional Empty

↓

isPresent()

↓

False

↓

Throw CountryNotFoundException
```

This prevents invalid data from being processed.

---

# SQL Generated by Hibernate

Developers never write SQL manually.

Hibernate automatically generates SQL similar to:

```sql
SELECT
co_code,
co_name
FROM
country
WHERE
co_code=?
```

The parameter value is:

```
IN
```

Hibernate binds this value and executes the query.

This behavior can be observed in the console output when SQL logging is enabled.

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

EntityManager Bean

        │

        ▼

Hibernate

        │

        ▼

Database
```

Each Bean performs a dedicated responsibility, making the application modular and easy to maintain.

---

# Layered Architecture

This project follows the layered architecture recommended for Spring Boot applications.

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

Database

↓

MySQL
```

Separating responsibilities into layers improves readability, maintainability, testing, and scalability.

---

# Sequence Diagram

The sequence of interactions between the components is shown below.

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

Hibernate

│

▼

MySQL Database

│

▼

Country Record

│

▼

Country Object

│

▼

Console Output
```

---

# Why Use a Service Layer?

Instead of directly accessing the Repository from the Main class, the request passes through the Service layer.

Benefits include:

- Separation of concerns.
- Centralized business logic.
- Easier testing.
- Better maintainability.
- Reusability across multiple controllers or services.

This layered approach is widely used in enterprise Spring Boot applications.

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
- Connects to the MySQL database.
- Initializes Hibernate.
- Creates all required Spring Beans.
- Retrieves the `CountryService` Bean.
- Executes the `findCountryByCode()` method.
- Retrieves the requested country from the database.
- Displays the country details in the console.

If everything is configured correctly, the console displays output similar to:

```
Inside Main

Start

Country : Country{code='IN', name='India'}

End
```

This confirms that the application successfully retrieved the country from the database using its primary key.

---

# Expected Console Output

When the application runs successfully, the console displays logs similar to:

```
Inside Main

Start

Hibernate:
select
    c1_0.co_code,
    c1_0.co_name
from
    country c1_0
where
    c1_0.co_code=?

Country : Country{code='IN', name='India'}

End
```

The generated SQL verifies that Hibernate internally executed the correct query.

---

# Executed Output

<img width="1907" height="1021" alt="Output" src="https://github.com/user-attachments/assets/a47431f7-0bac-44fd-ad60-9712650369e2" />

---

# Verifying Data in MySQL

Open **MySQL Workbench**.

Select the database:

```sql
USE ormlearn;
```

Execute:

```sql
SELECT * FROM country;
```

Verify that the required country exists.

Example:

| co_code | co_name |
|----------|----------|
| IN | India |
| US | United States of America |
| JP | Japan |

This confirms that the application is retrieving data from the correct database.

---

# Output Screenshots

Include the following screenshots inside the **Output** folder.

- IntelliJ Project Structure.
- Spring Boot Console Output.
- MySQL Workbench showing the Country table.
- Successful retrieval of country **IN**.
- (Optional) Exception output when an invalid country code is searched.

These screenshots serve as proof that the exercise has been implemented successfully.

---

# Advantages of Using findById()

Using `findById()` provides several advantages.

## 1. Fast Retrieval

Since the search is performed using the primary key, the database can locate the required record efficiently.

---

## 2. Built-in Method

Developers do not need to write SQL queries manually.

Example:

```java
countryRepository.findById("IN");
```

Spring Data JPA generates the required SQL automatically.

---

## 3. Safe Return Type

Instead of returning `null`, `findById()` returns an `Optional`.

This encourages developers to explicitly handle missing data.

---

## 4. Cleaner Code

Only one line of code is required.

Without Spring Data JPA, developers would need to write:

- JDBC Connection
- PreparedStatement
- SQL Query
- ResultSet Processing
- Object Mapping
- Resource Cleanup

---

## 5. Better Error Handling

The application can throw meaningful custom exceptions such as:

```java
CountryNotFoundException
```

instead of generic runtime exceptions.

---

# Common Errors and Solutions

## Error

```
Country not found with code: XX
```

### Cause

The specified country code does not exist in the database.

### Solution

Insert the record into the database or search using a valid country code.

---

## Error

```
Optional.get() without checking
```

### Cause

Calling:

```java
result.get();
```

without verifying that the `Optional` contains a value.

### Solution

Always check:

```java
result.isPresent()
```

or use:

```java
result.orElseThrow(...)
```

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
Not a managed type
```

### Cause

The Entity class is missing the `@Entity` annotation.

### Solution

Annotate the Entity class correctly.

---

## Error

```
Access denied for user
```

### Cause

Incorrect MySQL username or password.

### Solution

Verify:

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

# Interview Questions

## 1. What is `findById()`?

**Answer**

`findById()` is a built-in method provided by `JpaRepository` that retrieves a single Entity using its primary key.

---

## 2. What does `findById()` return?

**Answer**

It returns an `Optional<T>` instead of the Entity directly.

---

## 3. Why does Spring Data JPA return `Optional`?

**Answer**

Because the requested record may not exist. Returning `Optional` avoids `NullPointerException` and encourages safe handling of missing values.

---

## 4. What is `Optional`?

**Answer**

`Optional` is a container object introduced in Java 8 that represents a value that may or may not be present.

---

## 5. What is `isPresent()`?

**Answer**

It checks whether the `Optional` object contains a value.

---

## 6. What is `get()`?

**Answer**

It retrieves the value stored inside an `Optional`.

It should only be called after verifying that the value exists.

---

## 7. Why do we create `CountryNotFoundException`?

**Answer**

To represent a business-specific error when the requested country does not exist.

---

## 8. What is the purpose of a custom exception?

**Answer**

Custom exceptions make code more readable and allow developers to handle business errors more effectively.

---

## 9. Which layer communicates with the database?

**Answer**

The Repository layer communicates with the database using Spring Data JPA and Hibernate.

---

## 10. Which component generates SQL?

**Answer**

Hibernate generates SQL queries.

---

## 11. Does Spring Data JPA generate SQL?

**Answer**

No.

Spring Data JPA delegates persistence operations to Hibernate.

---

## 12. Why is `findById()` faster than searching all records?

**Answer**

Because it searches using the primary key, which is usually indexed by the database.

---

## 13. What happens if the country does not exist?

**Answer**

`findById()` returns an empty `Optional`, and the application throws `CountryNotFoundException`.

---

## 14. What is the role of the Service layer?

**Answer**

The Service layer contains business logic and acts as an intermediary between the application and the Repository.

---

## 15. Why is layered architecture important?

**Answer**

It separates responsibilities, improves maintainability, enhances testability, and makes applications easier to extend.

---

# Key Learnings

After completing this exercise, you have learned:

- Primary Key Retrieval
- Spring Data JPA `findById()`
- Optional Class
- Safe Handling of Missing Data
- Custom Exceptions
- Repository Layer
- Service Layer
- Exception Handling
- Hibernate SQL Generation
- Layered Architecture
- Spring Boot Bean Management
- Database Retrieval Using Primary Key

---

# Conclusion

This exercise demonstrates how **Spring Data JPA** retrieves a single entity from a database using the `findById()` method. Instead of writing SQL queries manually, developers simply invoke a repository method, while Spring Data JPA and Hibernate handle the database interaction internally.

The exercise also introduces the **Optional** class, which provides a safe way to handle values that may or may not exist, reducing the chances of `NullPointerException`. In addition, a custom exception (`CountryNotFoundException`) is used to handle business-specific error scenarios in a clean and meaningful way.

By completing this exercise, you have learned how to retrieve data using a primary key, understand the internal execution flow of Spring Data JPA, implement exception handling, and follow a layered architecture. These concepts form the foundation for more advanced Spring Data JPA topics such as **custom query methods**, **CRUD operations**, **entity relationships (O/R Mapping)**, **JPQL**, **Native Queries**, and **transaction management**, which are covered in the upcoming exercises.

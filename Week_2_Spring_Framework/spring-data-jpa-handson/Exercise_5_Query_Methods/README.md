# Exercise 5: Demonstrate Implementation of Query Methods Feature of Spring Data JPA

## Week 2 – Spring Framework

### Module
**Spring Data JPA with Spring Boot & Hibernate**

### Exercise
**Exercise 5: Demonstrate Implementation of Query Methods Feature of Spring Data JPA**

---

# Introduction

In enterprise applications, retrieving data based on specific conditions is one of the most frequently performed database operations. Users may search for products by name, employees by department, students by roll number, or countries by their names. Writing SQL queries manually for every search operation can become repetitive and difficult to maintain.

Spring Data JPA simplifies this process by introducing **Query Methods**, also known as **Derived Query Methods**. Instead of writing SQL statements or JPQL queries, developers only need to define repository methods following Spring Data JPA's naming conventions. Spring automatically interprets the method names and generates the required SQL queries at runtime.

In this exercise, we extend the **Country Management System** developed in the previous hands-on exercises by implementing different Query Methods on the `Country` entity. The application demonstrates three commonly used search operations:

- Searching countries whose names contain specific text.
- Searching countries whose names contain specific text in ascending alphabetical order.
- Searching countries whose names start with a given alphabet.

This exercise demonstrates how Spring Data JPA automatically converts method names into SQL queries, significantly reducing boilerplate code while improving readability and developer productivity.

---

# Objective

The primary objective of this exercise is to understand how **Spring Data JPA Query Methods** work and how they eliminate the need for writing SQL queries manually.

After completing this exercise, you will be able to:

- Understand the concept of Query Methods.
- Create derived query methods in Spring Data JPA.
- Perform search operations using repository method names.
- Retrieve filtered data from a MySQL database.
- Sort query results using method naming conventions.
- Understand how Spring Data JPA generates SQL automatically.
- Explain the internal working of Query Methods.

---

# Scenario

A software company has developed a **Country Management System** that stores information about countries.

Initially, the application was capable of:

- Displaying all countries.
- Retrieving a country using its country code.
- Adding a new country.

Now the business team has introduced additional search requirements.

The administrator should be able to:

### Requirement 1

Search all countries whose names contain a specific word.

Example:

```
Search Text

↓

ou

↓

Matching Countries

↓

Bouvet Island

Djibouti

Guadeloupe

Luxembourg

South Africa

South Sudan

...
```

---

### Requirement 2

Display the same search results in **ascending alphabetical order**.

```
Search Text

↓

ou

↓

Sort Alphabetically

↓

Bouvet Island

Djibouti

French Southern Territories

Guadeloupe

Luxembourg

South Africa

...
```

---

### Requirement 3

Search countries whose names begin with a specific alphabet.

Example:

```
Search Letter

↓

Z

↓

Matching Countries

↓

Zambia

Zimbabwe
```

Instead of writing SQL queries manually, the application should use **Spring Data JPA Query Methods** to perform these searches automatically.

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
- Collections Framework
- Exception Handling
- Spring Boot
- Spring IoC Container
- Dependency Injection
- Spring Data JPA
- Hibernate
- Repository Pattern
- CRUD Operations
- MySQL

It is recommended that the following exercises are completed before starting this hands-on:

- Spring Data JPA – Quick Example
- Find Country Based on Country Code
- Add a New Country

---

# What are Query Methods?

A **Query Method** is a method declared inside a Spring Data JPA Repository whose name follows predefined naming conventions.

Spring Data JPA analyzes the method name and automatically generates the required SQL query.

Developers do not need to write SQL manually.

Example:

```java
List<Country> findByNameContaining(String text);
```

Without writing any SQL, Spring Data JPA automatically generates a query similar to:

```sql
SELECT *
FROM country
WHERE co_name LIKE '%text%';
```

This feature makes data retrieval much easier and faster.

---

# What are Derived Query Methods?

Derived Query Methods are repository methods whose names describe the query to be executed.

Spring Data JPA derives the SQL query directly from the method name.

Example:

```java
findByNameContaining(String text)
```

can be interpreted as:

```
find

↓

By

↓

Name

↓

Containing
```

Spring converts this into the appropriate SQL query automatically.

---

# Query Methods Implemented in this Exercise

This exercise demonstrates three commonly used Query Methods.

### 1. Search Countries Containing Text

Repository Method:

```java
findByNameContaining(String text)
```

Example:

```
Input

↓

ou

↓

Output

↓

Bouvet Island

Djibouti

Guadeloupe

Luxembourg

South Africa
```

---

### 2. Search Countries Containing Text in Ascending Order

Repository Method:

```java
findByNameContainingOrderByNameAsc(String text)
```

This method retrieves the same matching countries but sorts them alphabetically.

---

### 3. Search Countries Starting With an Alphabet

Repository Method:

```java
findByNameStartingWith(String alphabet)
```

Example:

```
Input

↓

Z

↓

Output

↓

Zambia

Zimbabwe
```

---

# Why Use Query Methods?

Without Query Methods, developers would need to write SQL queries manually for every search operation.

For example:

```sql
SELECT *
FROM country
WHERE co_name LIKE '%ou%'
ORDER BY co_name ASC;
```

Using Spring Data JPA, the same functionality is achieved by writing:

```java
findByNameContainingOrderByNameAsc("ou");
```

This reduces boilerplate code and improves readability.

---

# Advantages of Query Methods

Using Query Methods provides several advantages.

- No SQL queries need to be written manually.
- Improves code readability.
- Reduces boilerplate code.
- Faster development.
- Easier maintenance.
- Type-safe repository methods.
- Automatic SQL generation by Spring Data JPA.
- Better integration with Hibernate.
- Encourages clean repository design.
- Commonly used in enterprise Spring Boot applications.

---

# Learning Outcomes

After completing this exercise, you will be able to:

- Explain what Query Methods are.
- Create derived query methods in Spring Data JPA.
- Perform filtered search operations.
- Retrieve sorted records using repository method names.
- Understand how Spring Data JPA generates SQL automatically.
- Use repository methods without writing SQL.
- Understand the interaction between Spring Data JPA and Hibernate.
- Explain the internal workflow of Query Methods.
- Build cleaner and more maintainable persistence layers.

---

# Project Structure

This exercise continues the same **Spring Boot** project created in the previous Spring Data JPA hands-on exercises. Instead of creating a new project, we extend the existing **orm-learn** project by adding **Spring Data JPA Query Methods**.

The project follows the standard Maven directory structure generated using **Spring Initializr**.

```
Exercise_5_Demonstrate_Implementation_of_Query_Methods_Feature_of_Spring_Data_JPA
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
│   │   │
│   │   │       ├── model
│   │   │       │      └── Country.java
│   │   │       │
│   │   │       ├── repository
│   │   │       │      └── CountryRepository.java
│   │   │       │
│   │   │       ├── service
│   │   │       │      └── CountryService.java
│   │   │       │
│   │   │       ├── service
│   │   │       │      └── exception
│   │   │       │             └── CountryNotFoundException.java
│   │   │       │
│   │   │       └── OrmLearnApplication.java
│   │   │
│   │   └── resources
│   │          └── application.properties
│   │
│   └── test
│
└── Output
    ├── Console_Output_Query1.png
    ├── Console_Output_Query2.png
    ├── Console_Output_Query3.png
    └── Project_Structure.png
```

---

# Folder Description

| Folder | Purpose |
|----------|----------|
| **model** | Contains Entity classes mapped to database tables. |
| **repository** | Contains Spring Data JPA Repository interfaces. |
| **service** | Contains business logic. |
| **service.exception** | Contains custom exception classes. |
| **resources** | Contains application configuration files such as `application.properties`. |

---

# File Description

| File | Description |
|------|-------------|
| **Country.java** | Entity class mapped to the Country table. |
| **CountryRepository.java** | Repository interface containing all Query Methods. |
| **CountryService.java** | Contains business logic and repository calls. |
| **CountryNotFoundException.java** | Custom exception created in previous exercises. |
| **OrmLearnApplication.java** | Main class used to test all Query Methods. |
| **application.properties** | Database and Hibernate configuration. |

---

# Implementation

The implementation of this exercise can be divided into three major sections.

1. Repository Layer
2. Service Layer
3. Testing through OrmLearnApplication

---

# Repository Layer

Package

```
com.cognizant.orm_learn.repository
```

Class

```
CountryRepository.java
```

The Repository layer communicates directly with the database.

It extends

```java
JpaRepository<Country,String>
```

which already provides CRUD operations such as:

- save()
- findAll()
- findById()
- delete()
- count()

In this exercise, we extend the Repository by adding custom **Query Methods**.

---

# Query Method 1

```java
List<Country> findByNameContaining(String text);
```

### Purpose

Returns all countries whose names contain the specified text.

Example

```
Input

↓

ou

↓

Output

↓

Bouvet Island

Djibouti

Guadeloupe

Luxembourg

South Africa
```

---

### Spring Interpretation

Spring reads the method name as

```
find

↓

By

↓

Name

↓

Containing
```

Automatically generated SQL is similar to

```sql
SELECT *
FROM country
WHERE co_name LIKE '%ou%';
```

No SQL is written by the developer.

---

# Query Method 2

```java
List<Country> findByNameContainingOrderByNameAsc(String text);
```

### Purpose

Returns matching countries in ascending alphabetical order.

Example

```
Input

↓

ou

↓

Output

↓

Bouvet Island

Djibouti

French Southern Territories

Guadeloupe

Luxembourg

South Africa
```

---

### Spring Interpretation

Spring understands

```
find

↓

By

↓

Name

↓

Containing

↓

OrderBy

↓

Name

↓

Ascending
```

Generated SQL becomes similar to

```sql
SELECT *
FROM country
WHERE co_name LIKE '%ou%'
ORDER BY co_name ASC;
```

---

# Query Method 3

```java
List<Country> findByNameStartingWith(String alphabet);
```

### Purpose

Returns countries whose names start with a specified alphabet.

Example

```
Input

↓

Z

↓

Output

↓

Zambia

Zimbabwe
```

---

### Generated SQL

```sql
SELECT *
FROM country
WHERE co_name LIKE 'Z%';
```

---

# Final Repository Interface

```java
@Repository
public interface CountryRepository
        extends JpaRepository<Country, String> {

    List<Country> findByNameContaining(String text);

    List<Country> findByNameContainingOrderByNameAsc(String text);

    List<Country> findByNameStartingWith(String alphabet);

}
```

---

# Service Layer

Package

```
com.cognizant.orm_learn.service
```

Class

```
CountryService.java
```

The Service layer acts as an intermediary between the Main class and the Repository.

Instead of directly accessing the Repository, the Main class communicates with the Service layer.

This follows the layered architecture recommended for enterprise applications.

---

## @Service

```java
@Service
```

Marks the class as a Spring Service Bean.

Spring automatically creates and manages the object.

---

## @Autowired

```java
@Autowired
private CountryRepository countryRepository;
```

Injects the Repository Bean automatically.

Developers do not create the Repository object manually.

---

## @Transactional(readOnly = true)

All Query Methods perform only **read operations**.

Therefore,

```java
@Transactional(readOnly = true)
```

is used.

Benefits:

- Optimized transactions
- Better performance
- Indicates that the method will not modify database records

---

# Service Method 1

```java
@Transactional(readOnly = true)
public List<Country> searchCountries(String text){

    return countryRepository.findByNameContaining(text);

}
```

Flow

```
Search Text

↓

Service

↓

Repository

↓

Database

↓

List<Country>
```

---

# Service Method 2

```java
@Transactional(readOnly = true)
public List<Country> searchCountriesSorted(String text){

    return countryRepository
            .findByNameContainingOrderByNameAsc(text);

}
```

Flow

```
Search Text

↓

Repository

↓

ORDER BY

↓

Sorted Countries
```

---

# Service Method 3

```java
@Transactional(readOnly = true)
public List<Country> searchCountriesStartingWith(String alphabet){

    return countryRepository
            .findByNameStartingWith(alphabet);

}
```

Flow

```
Alphabet

↓

Repository

↓

LIKE 'Z%'

↓

Matching Countries
```

---

# Main Class

Class

```
OrmLearnApplication.java
```

The CTS hands-on requires testing the Query Methods from the Main class.

The application contains three separate test methods.

---

## Test Method 1

```java
testSearchCountryContaining();
```

Purpose:

Tests

```java
findByNameContaining()
```

using

```
ou
```

as the search text.

---

## Test Method 2

```java
testSearchCountryContainingSorted();
```

Purpose:

Tests

```java
findByNameContainingOrderByNameAsc()
```

using

```
ou
```

and verifies that the results are sorted alphabetically.

---

## Test Method 3

```java
testSearchCountryStartingWith();
```

Purpose:

Tests

```java
findByNameStartingWith()
```

using

```
Z
```

as the search alphabet.

---

# Data Flow

The complete flow for every Query Method is:

```
OrmLearnApplication

↓

CountryService

↓

CountryRepository

↓

Spring Data JPA

↓

Hibernate

↓

Generated SQL

↓

MySQL Database

↓

List<Country>

↓

Console Output
```

---

# Bean Communication

Spring manages every component as a Bean.

```
OrmLearnApplication

↓

CountryService Bean

↓

CountryRepository Bean

↓

EntityManager

↓

Hibernate

↓

MySQL Database
```

Each Bean has a single responsibility, making the application modular, reusable, and easy to maintain.

---

# Summary of Implementation

The implementation consists of the following sequence:

1. Extend the Repository with three Query Methods.
2. Add corresponding Service methods.
3. Annotate the methods with `@Transactional(readOnly = true)`.
4. Test each Query Method separately from `OrmLearnApplication`.
5. Display the retrieved countries in the console.
6. Verify that Spring Data JPA automatically generates the required SQL queries without writing SQL manually.

---

# Internal Working

Although developers only write simple repository methods such as:

```java
findByNameContaining(String text);
```

or

```java
findByNameStartingWith(String alphabet);
```

Spring Data JPA performs many operations internally before returning the required data.

The framework analyzes the repository method name, generates the appropriate SQL query, executes it through Hibernate, maps the database records to Java objects, and finally returns the results to the application.

Understanding this internal execution flow helps developers appreciate how Spring Data JPA eliminates boilerplate code while maintaining excellent performance and readability.

---

# Complete Execution Flow

The complete execution of this exercise is shown below.

```
Application Starts

        │

        ▼

Spring Boot Starts

        │

        ▼

Spring IoC Container

        │

        ▼

CountryService Bean

        │

        ▼

Repository Query Method

        │

        ▼

Spring Data JPA

        │

        ▼

Method Name Parser

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

MySQL Database

        │

        ▼

Country Records

        │

        ▼

Country Objects

        │

        ▼

Console Output
```

---

# Step-by-Step Internal Execution

## Step 1 : Application Starts

Execution begins from

```java
public static void main(String[] args)
```

The application starts using

```java
ApplicationContext context =
SpringApplication.run(
        OrmLearnApplication.class,
        args);
```

Spring Boot performs the following tasks automatically.

- Reads `application.properties`
- Creates the IoC Container
- Connects to MySQL
- Initializes Hibernate
- Creates all Spring Beans

---

## Step 2 : Bean Creation

Spring creates all required Beans.

Examples include:

- CountryService
- CountryRepository
- EntityManager
- DataSource
- TransactionManager

These Beans are managed entirely by the Spring IoC Container.

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

# Query Method 1 Execution

Suppose the application executes:

```java
countryService.searchCountries("ou");
```

Execution Flow

```
OrmLearnApplication

↓

CountryService

↓

findByNameContaining()

↓

Spring Data JPA

↓

Hibernate

↓

SQL

↓

Database

↓

Country Objects

↓

Console
```

---

# How Spring Understands Method Names

The method

```java
findByNameContaining(String text)
```

is divided into keywords.

```
find

↓

By

↓

Name

↓

Containing
```

Each keyword has a specific meaning.

| Keyword | Meaning |
|----------|----------|
| find | Retrieve records |
| By | Apply condition |
| Name | Entity property |
| Containing | LIKE '%value%' |

Spring combines these keywords to generate SQL automatically.

---

# SQL Generated

Hibernate generates SQL similar to

```sql
SELECT
co_code,
co_name
FROM country
WHERE co_name LIKE ?;
```

Parameter

```
%ou%
```

No SQL is written by the developer.

---

# Query Method 2 Execution

Method

```java
findByNameContainingOrderByNameAsc("ou")
```

Spring analyzes

```
find

↓

By

↓

Name

↓

Containing

↓

OrderBy

↓

Name

↓

Asc
```

Generated SQL

```sql
SELECT
co_code,
co_name
FROM country
WHERE co_name LIKE ?
ORDER BY co_name ASC;
```

Notice that the sorting operation is completely derived from the method name.

---

# Query Method 3 Execution

Method

```java
findByNameStartingWith("Z")
```

Spring interprets

```
find

↓

By

↓

Name

↓

StartingWith
```

Generated SQL

```sql
SELECT
co_code,
co_name
FROM country
WHERE co_name LIKE ?;
```

Parameter

```
Z%
```

The query returns only countries whose names begin with **Z**.

---

# Method Name Parsing

One of the biggest advantages of Spring Data JPA is its ability to parse repository method names.

Example

```java
findByNameContainingOrderByNameAsc()
```

Spring internally breaks it into

```
find

↓

By

↓

Name

↓

Containing

↓

OrderBy

↓

Name

↓

Ascending
```

and constructs the corresponding SQL query automatically.

This feature is called **Query Derivation**.

---

# Hibernate's Role

Spring Data JPA itself does not execute SQL.

Instead, it delegates persistence operations to Hibernate.

The execution flow becomes

```
Repository

↓

Spring Data JPA

↓

Hibernate

↓

Generate SQL

↓

Execute SQL

↓

Receive Result

↓

Convert to Objects
```

Hibernate performs Object-Relational Mapping (ORM), converting database rows into Java objects.

---

# Object Mapping

Suppose MySQL returns the following rows.

| co_code | co_name |
|----------|----------|
| ZA | South Africa |
| ZM | Zambia |
| ZW | Zimbabwe |

Hibernate converts them into Java objects.

```
Database Rows

↓

Country Objects

↓

List<Country>
```

Each row becomes an instance of the `Country` class.

---

# Persistence Context

Before returning the objects to the application, Hibernate stores them inside the **Persistence Context**.

```
Database

↓

Persistence Context

↓

Managed Entity

↓

Java Object
```

The Persistence Context tracks Entity objects while the transaction is active.

---

# Transaction Flow

All Service methods are annotated with

```java
@Transactional(readOnly = true)
```

Execution flow

```
Start Transaction

↓

Execute SELECT Query

↓

Retrieve Data

↓

Close Transaction
```

Since these methods only read data, no database modifications occur.

---

# Bean Communication

The communication between Spring Beans is shown below.

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

Each Bean performs a specific responsibility.

---

# Layered Architecture

This project follows the standard layered architecture.

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

Each layer has a clearly defined responsibility.

This architecture improves:

- Maintainability
- Readability
- Scalability
- Testability
- Reusability

---

# Sequence Diagram

The interaction between components is illustrated below.

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

Country Records

│

▼

Country Objects

│

▼

Console Output
```

---

# Why Use Query Methods?

Without Query Methods, developers would need to write SQL manually.

Example:

```sql
SELECT *
FROM country
WHERE co_name LIKE '%ou%'
ORDER BY co_name ASC;
```

Using Spring Data JPA, the same functionality is implemented using

```java
findByNameContainingOrderByNameAsc("ou");
```

Advantages include:

- Less boilerplate code
- Better readability
- Easier maintenance
- Automatic SQL generation
- Faster development
- Cleaner Repository interfaces

---

# Summary of Internal Working

The complete execution can be summarized as follows.

```
Call Repository Method

↓

Spring Parses Method Name

↓

Spring Data JPA

↓

Hibernate

↓

Generate SQL

↓

Execute Query

↓

Retrieve Rows

↓

Convert Rows into Country Objects

↓

Return List<Country>

↓

Display Console Output
```

This exercise demonstrates one of the most powerful features of Spring Data JPA: **Query Derivation**, where meaningful repository method names are automatically translated into SQL queries without requiring developers to write SQL manually.

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

The application starts the Spring Boot framework and loads the Spring IoC Container.

During startup, Spring Boot performs the following tasks automatically:

- Reads the `application.properties` configuration file.
- Creates the Spring IoC Container.
- Establishes the MySQL database connection.
- Initializes Hibernate.
- Creates all Spring Beans.
- Retrieves the `CountryService` Bean.
- Executes the selected Query Method.
- Displays the retrieved countries in the console.

Only one test method should be executed at a time for clear output.

---

# Testing Query Method 1

Enable:

```java
testSearchCountryContaining();
```

Comment the remaining methods.

```java
//testSearchCountryContainingSorted();

//testSearchCountryStartingWith();
```

The application searches for countries whose names contain:

```
ou
```

---

# Expected Console Output

```
Start

Country{code='BV', name='Bouvet Island'}

Country{code='DJ', name='Djibouti'}

Country{code='GP', name='Guadeloupe'}

Country{code='LU', name='Luxembourg'}

Country{code='ZA', name='South Africa'}

Country{code='GS', name='South Georgia and the South Sandwich Islands'}

Country{code='SS', name='South Sudan'}

Country{code='UM', name='United States Minor Outlying Islands'}

End
```

The exact output depends on the data available in your database.

---

# Testing Query Method 2

Enable

```java
testSearchCountryContainingSorted();
```

Comment the remaining methods.

The application searches for

```
ou
```

and displays the matching countries in ascending alphabetical order.

---

# Expected Console Output

```
Start

Bouvet Island

Djibouti

French Southern Territories

Guadeloupe

Luxembourg

South Africa

South Georgia and the South Sandwich Islands

South Sudan

United States Minor Outlying Islands

End
```

The output verifies that Spring Data JPA generated the ORDER BY clause automatically.

---

# Testing Query Method 3

Enable

```java
testSearchCountryStartingWith();
```

The application searches for countries beginning with

```
Z
```

---

# Expected Console Output

```
Start

Country{code='ZM', name='Zambia'}

Country{code='ZW', name='Zimbabwe'}

End
```

This confirms that the Query Method correctly filters records using the specified prefix.

---

# Hibernate SQL Generation

For the first Query Method, Hibernate generates SQL similar to

```sql
SELECT
co_code,
co_name
FROM country
WHERE co_name LIKE ?;
```

Parameter:

```
%ou%
```

---

For the second Query Method

```sql
SELECT
co_code,
co_name
FROM country
WHERE co_name LIKE ?
ORDER BY co_name ASC;
```

---

For the third Query Method

```sql
SELECT
co_code,
co_name
FROM country
WHERE co_name LIKE ?;
```

Parameter:

```
Z%
```

These SQL queries are generated automatically by Hibernate based on the Repository method names.

---

# Verifying Results in MySQL

Open **MySQL Workbench**.

Select the database.

```sql
USE ormlearn;
```

Execute the following queries.

---

## Query Method 1

```sql
SELECT *
FROM country
WHERE co_name LIKE '%ou%';
```

---

## Query Method 2

```sql
SELECT *
FROM country
WHERE co_name LIKE '%ou%'
ORDER BY co_name ASC;
```

---

## Query Method 3

```sql
SELECT *
FROM country
WHERE co_name LIKE 'Z%';
```

The SQL results should match the output displayed by the Spring Boot application.

---

# Output Screenshots

Include the following screenshots inside the **Output** folder.

- IntelliJ Project Structure.
- Console output for Query Method 1.
- Console output for Query Method 2.
- Console output for Query Method 3.
- MySQL Workbench showing the SQL query results.

These screenshots demonstrate the successful implementation of the exercise.

---

# Advantages of Query Methods

Spring Data JPA Query Methods provide several advantages.

## 1. No SQL Required

Developers define repository methods instead of writing SQL queries manually.

---

## 2. Automatic Query Generation

Spring Data JPA derives SQL queries directly from repository method names.

---

## 3. Cleaner Repository Layer

Repository interfaces remain simple and readable.

Example:

```java
findByNameContaining("ou");
```

is much easier to understand than writing SQL.

---

## 4. Less Boilerplate Code

Developers no longer need to write:

- JDBC Connection
- SQL Queries
- PreparedStatement
- ResultSet Processing
- Resource Cleanup

---

## 5. Better Readability

Repository method names clearly describe the operation being performed.

---

## 6. Easy Sorting

Sorting can be implemented directly within the method name.

Example:

```java
findByNameContainingOrderByNameAsc()
```

No explicit ORDER BY query is required.

---

## 7. Type Safety

Repository methods are validated during compilation, reducing runtime query errors.

---

## 8. Faster Development

Developers focus on business logic while Spring generates SQL automatically.

---

# Common Errors and Solutions

## Error

```
No property 'name' found
```

### Cause

The Repository method refers to an Entity field that does not exist.

### Solution

Ensure the method name matches the Entity field exactly.

Example:

```java
private String name;
```

Repository

```java
findByNameContaining()
```

---

## Error

```
No qualifying bean found
```

### Cause

Spring could not locate the Repository Bean.

### Solution

Verify:

- @Repository
- @Service
- Package structure
- Component scanning

---

## Error

```
Table 'country' doesn't exist
```

### Cause

The database table has not been created.

### Solution

Create the table before executing the application.

---

## Error

```
Access denied for user
```

### Cause

Incorrect database credentials.

### Solution

Verify

```properties
spring.datasource.username

spring.datasource.password
```

---

## Error

```
Query returned no results
```

### Cause

The specified search text does not match any country names.

### Solution

Use a valid search string such as:

```
ou

or

Z
```

---

# Interview Questions

## 1. What are Query Methods?

**Answer**

Query Methods are Repository methods whose names follow Spring Data JPA conventions. Spring automatically derives SQL queries from these method names.

---

## 2. What is Query Derivation?

**Answer**

Query Derivation is the process by which Spring Data JPA analyzes Repository method names and automatically generates SQL queries.

---

## 3. Which interface provides Query Method support?

**Answer**

`JpaRepository`

---

## 4. Does Spring Data JPA require SQL for Query Methods?

**Answer**

No.

Spring automatically generates SQL from the Repository method name.

---

## 5. What does `Containing` represent?

**Answer**

It represents SQL

```sql
LIKE '%value%'
```

---

## 6. What does `StartingWith` represent?

**Answer**

It represents SQL

```sql
LIKE 'value%'
```

---

## 7. What does `OrderByNameAsc` represent?

**Answer**

It generates

```sql
ORDER BY name ASC
```

---

## 8. Why are Query Methods preferred?

**Answer**

They reduce boilerplate code, improve readability, and eliminate the need for manually writing SQL queries.

---

## 9. Which framework generates SQL?

**Answer**

Hibernate.

---

## 10. Does Spring Data JPA execute SQL directly?

**Answer**

No.

Spring Data JPA delegates persistence operations to Hibernate.

---

## 11. Why are the Service methods marked as `readOnly = true`?

**Answer**

Because they only retrieve data and do not modify the database.

---

## 12. What is the role of Hibernate?

**Answer**

Hibernate performs Object-Relational Mapping (ORM), generates SQL queries, executes them, and maps database rows to Java objects.

---

## 13. What is the role of the Repository layer?

**Answer**

The Repository layer provides database access and exposes Query Methods.

---

## 14. What is the benefit of Layered Architecture?

**Answer**

It separates responsibilities into Presentation, Business, Persistence, and Database layers, improving maintainability and scalability.

---

## 15. Can Query Methods perform sorting?

**Answer**

Yes.

Sorting can be defined directly in the method name using keywords such as:

```java
OrderByNameAsc

OrderByNameDesc
```

---

# Key Learnings

After completing this exercise, you have learned:

- Spring Data JPA Query Methods
- Query Derivation
- Automatic SQL Generation
- Repository Method Naming Conventions
- LIKE Queries
- Sorting Using Repository Methods
- Hibernate ORM
- Repository Pattern
- Service Layer
- Layered Architecture
- Spring Bean Management
- Database Search Operations

---

# Conclusion

This exercise demonstrates one of the most powerful capabilities of **Spring Data JPA**—**Query Methods**. Instead of writing SQL queries manually, developers define descriptive repository method names, and Spring Data JPA automatically derives the required database queries.

Throughout this exercise, three different Query Methods were implemented to search countries by partial names, retrieve sorted results, and filter countries based on the starting alphabet. These operations required no manual SQL while still producing efficient database queries through Hibernate.

By completing this exercise, you have gained practical experience in implementing derived query methods, understanding how Spring Data JPA parses repository method names, and observing how Hibernate generates SQL automatically. These concepts form the foundation for more advanced Spring Data JPA features such as **custom queries using `@Query`**, **JPQL**, **Native SQL Queries**, **Specifications**, **Paging and Sorting**, and **Entity Relationships**, which are commonly used in enterprise Spring Boot applications.

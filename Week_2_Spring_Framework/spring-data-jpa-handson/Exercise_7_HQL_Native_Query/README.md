# Exercise 7 – Demonstrate Hibernate Query Language (HQL) and Native Query using Spring Data JPA

---

# Introduction

In the previous exercises, we learned how Spring Data JPA automatically generated SQL queries for basic CRUD operations using methods such as `save()`, `findById()`, `findAll()`, and custom Query Methods.

Although these predefined methods are sufficient for simple applications, enterprise applications often require more complex database operations such as filtering records, joining multiple tables, calculating aggregate values, retrieving customized data, and executing optimized database-specific SQL statements.

To handle these requirements, Spring Data JPA provides multiple query mechanisms.

Among them, the most commonly used are:

- Hibernate Query Language (HQL)
- Java Persistence Query Language (JPQL)
- Native SQL Query

These query languages allow developers to retrieve and manipulate database records in a flexible and efficient manner while still benefiting from Hibernate's Object Relational Mapping (ORM).

This exercise demonstrates how HQL and Native Queries are implemented using Spring Data JPA repositories. It also explains how Hibernate converts HQL into SQL, how joins are performed using entity relationships, and when Native SQL should be preferred over HQL.

---

# Objective

The objective of this exercise is to understand how Hibernate Query Language (HQL) and Native SQL Queries are used in Spring Data JPA applications.

After completing this exercise, you will be able to:

- Understand Hibernate Query Language (HQL).
- Understand Java Persistence Query Language (JPQL).
- Understand Native SQL Queries.
- Write custom queries using the `@Query` annotation.
- Retrieve filtered records using HQL.
- Use aggregate functions such as `AVG()`.
- Pass parameters using `@Param`.
- Retrieve related entities using `JOIN FETCH`.
- Execute database-specific SQL using Native Queries.
- Compare HQL, JPQL, Query Methods, and Native SQL.
- Understand Hibernate's internal query processing.

---

# Why Do We Need Custom Queries?

Spring Data JPA provides several predefined methods.

Examples:

```java
findAll()

findById()

save()

delete()
```

These methods work well for basic CRUD operations.

However, consider the following requirements.

- Retrieve only permanent employees.
- Find employees belonging to a particular department.
- Calculate average salary.
- Retrieve employees along with their department and skills.
- Execute optimized SQL specific to MySQL.

These operations cannot always be implemented using predefined repository methods.

Therefore, custom queries become necessary.

---

# What is Hibernate Query Language (HQL)?

Hibernate Query Language (HQL) is an object-oriented query language provided by Hibernate.

Unlike SQL, HQL works with:

- Java Classes
- Entity Objects
- Java Properties

instead of

- Database Tables
- Database Columns

Example

HQL

```java
SELECT e
FROM Employee e
WHERE e.permanent = true
```

SQL

```sql
SELECT *

FROM employee

WHERE em_permanent = 1;
```

Notice the difference.

HQL uses

```
Employee

salary

department
```

instead of

```
employee

em_salary

em_dp_id
```

Hibernate automatically converts HQL into SQL before executing it.

---

# What is JPQL?

Java Persistence Query Language (JPQL) is the standard query language defined by the JPA specification.

Hibernate Query Language (HQL) is Hibernate's implementation of JPQL.

For most Spring Boot applications,

HQL and JPQL look almost identical.

Example

```java
SELECT e
FROM Employee e
```

works in both JPQL and HQL.

---

# What is Native SQL Query?

A Native Query allows developers to execute actual SQL statements directly on the database.

Example

```sql
SELECT *

FROM employee;
```

Unlike HQL,

Native SQL uses

- Actual Table Names
- Actual Column Names
- Database-specific SQL syntax

Spring Data JPA executes the SQL exactly as written.

---

# HQL vs Native SQL

| Feature | HQL | Native SQL |
|----------|-----|------------|
| Uses Entity Classes | ✅ Yes | ❌ No |
| Uses Java Fields | ✅ Yes | ❌ No |
| Uses Database Tables | ❌ No | ✅ Yes |
| Uses Database Columns | ❌ No | ✅ Yes |
| Database Independent | ✅ Yes | ❌ No |
| Supports Vendor Specific SQL | ❌ Limited | ✅ Yes |

---

# Learning Outcomes

After completing this exercise, you will understand:

- Writing HQL queries.
- Writing Native SQL queries.
- Using `@Query`.
- Using `@Param`.
- Using aggregate functions.
- Understanding `JOIN FETCH`.
- Avoiding LazyInitializationException.
- Improving query performance.
- Hibernate SQL generation.

---

# Technologies Used

| Technology | Version |
|------------|----------|
| Java | 21 |
| Spring Boot | 3.x |
| Spring Data JPA | Latest |
| Hibernate ORM | Latest |
| MySQL | 8.x |
| Maven | 3.x |
| IntelliJ IDEA | 2024.x |
| Git | Latest |
| GitHub | Repository Hosting |

---

# Software Requirements

Before running this project, ensure the following software is installed.

- Java Development Kit (JDK 21)
- IntelliJ IDEA
- Maven
- MySQL Server
- MySQL Workbench
- Git
- GitHub Account

---

# Project Structure

```text
Exercise_7_HQL_Native_Query
│
├── README.md
├── pom.xml
├── .gitignore
│
├── src
│   ├── main
│   │
│   ├── java
│   │   └── com.cognizant.orm_learn
│   │       │
│   │       ├── model
│   │       │     ├── Employee.java
│   │       │     ├── Department.java
│   │       │     └── Skill.java
│   │       │
│   │       ├── repository
│   │       │     ├── EmployeeRepository.java
│   │       │     ├── DepartmentRepository.java
│   │       │     └── SkillRepository.java
│   │       │
│   │       ├── service
│   │       │     ├── EmployeeService.java
│   │       │     ├── DepartmentService.java
│   │       │     └── SkillService.java
│   │       │
│   │       └── OrmLearnApplication.java
│   │
│   └── resources
│         └── application.properties
│
└── Output
    ├── 01_HQL_Output.png
    ├── 02_JOIN_FETCH_Output.png
    ├── 03_Average_Salary_Output.png
    ├── 04_Native_Query_Output.png
```

---

# Database Used

This exercise uses the same Payroll database created in the previous O/R Mapping exercise.

The following tables are used.

```
department

employee

skill

employee_skill
```

---

# Entity Relationship

```
Department

↓

Employee

↓

Skill
```

Relationship Mapping

```
Department

1

↓

Many Employees

↓

Many Skills
```

---

# Query Methods Covered

During this exercise, four different query techniques are demonstrated.

```
Query Method

↓

HQL

↓

HQL with JOIN FETCH

↓

Native SQL
```

Each technique solves a different business requirement.

---

# Hands-on Implementations

The exercise consists of the following implementations.

## Hands-on 2

Retrieve all permanent employees using HQL.

---

## Hands-on 4

Calculate the average salary of employees using HQL aggregate functions.

---

## Hands-on 5

Retrieve all employees using Native SQL Query.

---

# JPA Annotations Used

| Annotation | Purpose |
|------------|---------|
| `@Query` | Defines custom HQL or SQL queries. |
| `@Param` | Passes named parameters to queries. |
| `@Transactional` | Manages database transactions. |
| `@Repository` | Declares repository interfaces. |
| `@Service` | Declares service classes. |
| `@ManyToOne` | Maps Employee to Department. |
| `@ManyToMany` | Maps Employee to Skill. |
| `@JoinTable` | Maps the join table. |

---

# Exercise Workflow

The execution flow of this exercise is illustrated below.

```
Application

↓

Service Layer

↓

Repository Layer

↓

HQL / Native Query

↓

Hibernate

↓

Generated SQL

↓

MySQL Database

↓

Query Result

↓

Hibernate

↓

Java Objects

↓

Application Output
```

Unlike JDBC, developers do not manually convert `ResultSet` objects into Java objects.

Hibernate automatically performs object mapping and returns fully populated entity objects.

---

# Concepts Covered

This exercise introduces several important concepts used in enterprise Spring Boot applications.

- Hibernate Query Language (HQL)
- Java Persistence Query Language (JPQL)
- Native SQL Query
- Custom Repository Queries
- Aggregate Functions
- Named Parameters
- JOIN FETCH
- Lazy Loading
- Query Optimization
- SQL Generation
- Spring Data JPA Integration

These concepts form the foundation for writing efficient, maintainable, and scalable database queries in enterprise Java applications.

# Complete Implementation

This exercise demonstrates three different approaches for querying data in Spring Data JPA.

Instead of relying only on predefined repository methods like `findAll()` and `findById()`, custom queries are written using the `@Query` annotation.

The implementation covers:

```
Spring Boot Application

↓

Service Layer

↓

Repository Layer

↓

Hibernate Query Language (HQL)

↓

Hibernate ORM

↓

Generated SQL

↓

MySQL Database
```

The developer writes HQL or Native SQL, while Hibernate is responsible for translating HQL into SQL and mapping the returned rows back into Java objects.

---

# Layered Architecture

The application follows a layered architecture.

```
+--------------------------------------+

        OrmLearnApplication

+--------------------------------------+
                    │
                    ▼
+--------------------------------------+

          Service Layer

EmployeeService

DepartmentService

SkillService

+--------------------------------------+
                    │
                    ▼
+--------------------------------------+

        Repository Layer

EmployeeRepository

DepartmentRepository

SkillRepository

+--------------------------------------+
                    │
                    ▼
+--------------------------------------+

       Spring Data JPA

+--------------------------------------+
                    │
                    ▼
+--------------------------------------+

          Hibernate ORM

+--------------------------------------+
                    │
                    ▼
+--------------------------------------+

          MySQL Database

+--------------------------------------+
```

Each layer performs one specific responsibility.

This separation improves maintainability, readability, testing, and scalability.

---

# Repository Layer

Unlike JDBC applications, no DAO implementation classes are created.

Only repository interfaces are written.

```
EmployeeRepository

DepartmentRepository

SkillRepository
```

Example

```java
public interface EmployeeRepository
extends JpaRepository<Employee,Integer>{

}
```

Spring Data JPA automatically provides implementations for:

- save()
- findById()
- findAll()
- delete()
- count()

The developer writes only additional custom queries whenever required.

---

# Service Layer

The Service Layer contains business logic.

Responsibilities include

- Calling repository methods.
- Managing transactions.
- Returning entity objects.
- Implementing business rules.

Example

```
EmployeeService

↓

EmployeeRepository

↓

Hibernate

↓

Database
```

All database operations execute inside

```java
@Transactional
```

which automatically manages transactions.

---

# What is @Query?

The `@Query` annotation allows developers to write custom database queries.

Without `@Query`

Spring Data JPA generates SQL automatically.

Example

```java
findAll()
```

With `@Query`

Developers control exactly which records should be retrieved.

Example

```java
@Query("SELECT e FROM Employee e")
```

Spring Data JPA sends the query to Hibernate.

Hibernate converts it into SQL.

---

# Hibernate Query Language (HQL)

Hibernate Query Language is an object-oriented query language.

It operates on

```
Java Objects
```

instead of

```
Database Tables
```

Example

```
Employee

↓

Java Class
```

instead of

```
employee

↓

Database Table
```

This makes applications database independent.

---

# HQL Query Demonstration

The first custom query implemented retrieves all permanent employees.

Repository Method

```java
@Query("""
SELECT e
FROM Employee e
WHERE e.permanent=true
""")
```

Notice

```
Employee
```

is the Java class.

```
permanent
```

is the Java field.

Neither of them exists inside MySQL.

Hibernate automatically maps them.

---

# Execution Flow

```
EmployeeRepository

↓

HQL Query

↓

Hibernate

↓

SQL Generation

↓

employee Table

↓

Employee Objects
```

The developer never writes SQL manually.

---

# Business Requirement

The company wants to display

```
Only Permanent Employees
```

Instead of

```
All Employees
```

The query filters records automatically.

Example

```
John

Permanent

↓

Returned
```

```
David

Temporary

↓

Ignored
```

---

# Generated SQL

Hibernate converts

```java
SELECT e
FROM Employee e
WHERE e.permanent=true
```

into SQL similar to

```sql
SELECT *

FROM employee

WHERE em_permanent=1;
```

The conversion happens automatically.

---

# Why JOIN FETCH?

Initially,

Hibernate retrieves only Employee objects.

Associated objects

```
Department

Skill
```

remain lazily loaded.

Later,

when the application accesses

```java
employee.getDepartment()

employee.getSkillList()
```

Hibernate executes additional SQL queries.

This increases database calls.

---

# N+1 Problem

Suppose

```
100 Employees
```

exist.

Without JOIN FETCH,

Hibernate executes

```
1 Query

↓

Employees
```

then

```
100 Queries

↓

Departments
```

then

```
100 Queries

↓

Skills
```

Total

```
201 Queries
```

This is called

```
N+1 Problem
```

It reduces application performance significantly.

---

# JOIN FETCH Solution

Instead of allowing Hibernate to execute multiple queries,

we write

```java
SELECT DISTINCT e

FROM Employee e

LEFT JOIN FETCH e.department

LEFT JOIN FETCH e.skillList

WHERE e.permanent=true
```

Now Hibernate generates

```
One Optimized SQL Query
```

instead of hundreds.

---

# LEFT JOIN FETCH

The keyword

```
LEFT JOIN
```

joins related tables.

The keyword

```
FETCH
```

instructs Hibernate to immediately populate the related entity.

Example

Without FETCH

```
Employee

↓

Department

Not Loaded
```

With FETCH

```
Employee

↓

Department

Loaded Immediately
```

The same applies to

```
Skill List
```

---

# Why DISTINCT?

Suppose

John possesses

```
Java

SQL

Spring Boot
```

The SQL JOIN produces

```
John

Java
```

```
John

SQL
```

```
John

Spring Boot
```

Without

```
DISTINCT
```

Hibernate may return

```
John

John

John
```

Using

```java
SELECT DISTINCT e
```

ensures that only one Employee object is returned.

---

# Aggregate Function

The second implementation demonstrates

```
AVG()
```

Average Salary

Repository Method

```java
@Query("""
SELECT AVG(e.salary)

FROM Employee e

WHERE e.department.id=:id
""")
```

The average salary is calculated directly by the database.

No manual calculation is required.

---

# Named Parameters

Instead of

```
?
```

Spring Data JPA supports

```
:id
```

Example

```java
@Param("id")
```

Application Flow

```
Department ID

↓

@Param

↓

HQL

↓

Hibernate

↓

SQL

↓

Average Salary
```

Named parameters improve readability.

---

# Aggregate Query Flow

```
Application

↓

EmployeeService

↓

EmployeeRepository

↓

AVG()

↓

Hibernate

↓

MySQL

↓

Average Value

↓

Application
```

Only one value is returned.

---

# Native Query

The final implementation demonstrates Native SQL.

Unlike HQL,

Native SQL uses

```
Database Tables

Database Columns
```

instead of

```
Java Classes

Java Fields
```

Repository Method

```java
@Query(
value="SELECT * FROM employee",
nativeQuery=true
)
```

Hibernate executes the SQL exactly as written.

---

# Native Query Execution

```
Native SQL

↓

Hibernate

↓

MySQL

↓

Rows

↓

Employee Objects
```

Even though SQL is written manually,

Hibernate still converts database rows into Java objects automatically.

---

# HQL vs Native Query

### HQL

```
Employee

↓

Java Class
```

```
salary

↓

Java Field
```

Portable across databases.

Automatically converted into SQL.

---

### Native SQL

```
employee

↓

Database Table
```

```
em_salary

↓

Database Column
```

Database specific.

Executed directly.

---

# When to Use HQL?

Use HQL when

- Database independence is important.
- Working with entities.
- Joining mapped relationships.
- Using entity fields.
- Developing enterprise applications.

---

# When to Use Native SQL?

Use Native SQL when

- Complex SQL is required.
- Database-specific functions are used.
- Performance tuning is needed.
- Stored procedures are involved.
- Vendor-specific features are required.

---

# Complete Query Processing

```
Application

↓

Repository

↓

@Query

↓

Hibernate

↓

HQL Parser

↓

SQL Generator

↓

MySQL

↓

Rows

↓

Hibernate

↓

Entity Objects

↓

Application
```

This entire conversion happens automatically.

Developers interact only with Java objects.

No ResultSet processing is required.

---

# Concepts Demonstrated

This exercise successfully demonstrates:

- Custom Repository Queries
- Hibernate Query Language
- Java Persistence Query Language
- Native SQL Queries
- Aggregate Functions
- Named Parameters
- JOIN FETCH
- DISTINCT
- Query Optimization
- Automatic SQL Generation
- Hibernate Entity Mapping
- Repository Abstraction
- Service Layer Architecture
- Transaction Management

These concepts are widely used in enterprise Spring Boot applications to write efficient, maintainable, and optimized database queries.

# Internal Working of Hibernate Query Language (HQL)

Hibernate Query Language is not executed directly by the database.

Unlike SQL, HQL is understood only by Hibernate.

Hibernate converts HQL into SQL before sending it to the database.

The complete execution flow is illustrated below.

```
Application

↓

EmployeeRepository

↓

HQL Query

↓

Hibernate Query Parser

↓

Hibernate SQL Generator

↓

JDBC Driver

↓

MySQL Database

↓

Result Set

↓

Hibernate ORM

↓

Employee Objects

↓

Application
```

The developer never interacts directly with SQL when using HQL.

---

# Internal Working of @Query

Whenever Spring Boot starts,

Spring scans every repository interface.

```
@Repository

↓

EmployeeRepository
```

Spring finds

```java
@Query(...)
```

and stores the query.

Later,

when the repository method is called,

Spring executes the stored query.

Execution Flow

```
EmployeeRepository

↓

@Query

↓

Hibernate

↓

Generated SQL

↓

Database
```

---

# Hibernate Query Parser

Hibernate contains an internal parser.

Its responsibility is

- Reading HQL
- Validating syntax
- Identifying entities
- Identifying fields
- Creating SQL

Example

Developer writes

```java
SELECT e

FROM Employee e

WHERE e.salary>50000
```

Hibernate understands

```
Employee

↓

employee table
```

```
salary

↓

em_salary column
```

Then generates SQL automatically.

---

# HQL Compilation Process

```
HQL

↓

Parser

↓

Syntax Tree

↓

Semantic Analysis

↓

SQL Generator

↓

Database SQL
```

Every HQL query passes through these stages before execution.

---

# SQL Generation

Suppose the repository contains

```java
@Query("""
SELECT e

FROM Employee e

WHERE e.permanent=true
""")
```

Hibernate generates SQL similar to

```sql
SELECT *

FROM employee

WHERE em_permanent=1;
```

Notice

Developer never writes SQL.

Hibernate generates it.

---

# Object Mapping

After executing SQL,

MySQL returns

```
Rows
```

Example

```
1

John

75000

1996-02-15
```

Hibernate converts this row into

```
Employee Object
```

instead of

```
ResultSet
```

Developer receives

```java
Employee
```

directly.

---

# Entity Lifecycle

Every entity passes through four states.

```
New

↓

Managed

↓

Detached

↓

Removed
```

---

## New State

Object exists only in JVM memory.

Example

```java
Employee employee=new Employee();
```

Hibernate does not know about it.

---

## Managed State

After

```java
employeeRepository.save(employee);
```

Hibernate tracks the object.

Any modification becomes synchronized with the database.

---

## Detached State

After transaction completion,

Hibernate stops monitoring the entity.

The object still exists,

but changes are not synchronized automatically.

---

## Removed State

Calling

```java
employeeRepository.delete(employee);
```

marks the entity for deletion.

Hibernate generates

```
DELETE
```

SQL.

---

# Persistence Context

Persistence Context is Hibernate's first-level cache.

```
Application

↓

Persistence Context

↓

Database
```

Whenever an entity is requested,

Hibernate checks

```
Persistence Context
```

first.

If found,

no SQL query executes.

Otherwise,

Hibernate queries the database.

---

# Benefits of Persistence Context

- Faster execution
- Reduced database calls
- Automatic synchronization
- Better performance
- Entity identity guarantee

---

# Dirty Checking

Hibernate continuously monitors managed entities.

Suppose

```java
employee.setSalary(90000);
```

Developer does not write

```sql
UPDATE employee
```

Instead,

Hibernate detects the modification automatically.

At transaction commit,

Hibernate generates

```sql
UPDATE employee
```

This feature is called

```
Dirty Checking
```

---

# Lazy Loading

Lazy Loading means

```
Load only when required.
```

Example

Employee object

↓

Department

↓

Not Loaded Initially

Only when

```java
employee.getDepartment()
```

is called,

Hibernate retrieves the department.

Advantages

- Faster initial loading
- Less memory usage
- Better performance

---

# Eager Loading

Eager Loading means

```
Load Immediately.
```

When Employee loads,

Department

Skill List

both load together.

Advantages

- Simple navigation
- No LazyInitializationException

Disadvantages

- More memory consumption
- Larger SQL queries
- Slower initial loading

---

# LazyInitializationException

One of the most common Hibernate exceptions.

Scenario

```
Employee Loaded

↓

Session Closed

↓

employee.getSkillList()

↓

Exception
```

Reason

Hibernate cannot access the database after the session closes.

Solutions

- Use JOIN FETCH
- Access data inside a transaction
- Use FetchType.EAGER only when appropriate

---

# JOIN FETCH

JOIN FETCH is one of the most important HQL optimizations.

Without JOIN FETCH

```
Employee

↓

Department

↓

Another Query

↓

Skills

↓

Another Query
```

Many SQL statements execute.

With JOIN FETCH

```
Employee

↓

Department

↓

Skills
```

All entities are retrieved using

```
One SQL Query
```

This significantly improves performance.

---

# N+1 Problem

Suppose

```
100 Employees
```

exist.

Without JOIN FETCH

Hibernate executes

```
1 Query

↓

Employees
```

then

```
100 Queries

↓

Departments
```

then

```
100 Queries

↓

Skills
```

Total

```
201 Queries
```

This is called

```
N+1 Problem
```

It negatively impacts application performance.

JOIN FETCH eliminates this issue.

---

# Aggregate Functions

Hibernate supports SQL aggregate functions.

Examples

```
COUNT()

SUM()

AVG()

MIN()

MAX()
```

In this exercise,

the following query was implemented.

```java
SELECT AVG(e.salary)

FROM Employee e

WHERE e.department.id=:id
```

Hibernate converts it into SQL automatically.

---

# Named Parameters

Instead of positional parameters,

Spring Data JPA supports named parameters.

Example

```java
@Param("id")
```

Advantages

- Better readability
- Easier maintenance
- Reduced errors
- Self-documenting queries

---

# Native Query Processing

Native Queries skip HQL parsing.

Execution Flow

```
Native SQL

↓

Hibernate

↓

JDBC

↓

MySQL

↓

Rows

↓

Entity Objects
```

Hibernate still maps rows into Java objects.

Only SQL generation is skipped.

---

# HQL vs Native Query Execution

## HQL

```
Application

↓

HQL

↓

Hibernate Parser

↓

SQL Generation

↓

Database

↓

Objects
```

---

## Native Query

```
Application

↓

SQL

↓

Database

↓

Objects
```

Native Query bypasses Hibernate's query translation.

---

# Performance Considerations

For enterprise applications,

follow these best practices.

### Use HQL by default

HQL is database-independent and easier to maintain.

---

### Use Native SQL only when necessary

Examples

- Stored Procedures
- Window Functions
- Database-specific syntax
- Complex reporting queries

---

### Prefer JOIN FETCH

It eliminates

```
N+1 Problem
```

and reduces unnecessary SQL queries.

---

### Avoid Unnecessary EAGER Fetching

Eager loading increases

- Memory usage
- Query execution time
- Network traffic

Prefer LAZY loading unless immediate access to related data is required.

---

### Use Aggregate Functions in the Database

Instead of retrieving all records and calculating values in Java,

let the database perform

```
COUNT

SUM

AVG

MIN

MAX
```

Databases are optimized for these operations.

---

# Best Practices

- Keep HQL simple and readable.
- Use entity names instead of table names.
- Use Java property names instead of column names.
- Prefer named parameters over positional parameters.
- Use JOIN FETCH carefully.
- Avoid unnecessary Native Queries.
- Keep repository methods focused on one responsibility.
- Use transactions at the service layer.
- Enable SQL logging during development.
- Review generated SQL for performance optimization.

---

# Real-World Applications

Hibernate Query Language is extensively used in enterprise software.

Examples include:

- Banking Systems
- E-Commerce Applications
- Hospital Management Systems
- ERP Solutions
- Human Resource Management Systems
- Learning Management Systems
- Inventory Management Systems
- Payroll Applications
- Airline Reservation Systems
- Customer Relationship Management (CRM)

In all these systems, HQL simplifies database interaction while maintaining portability across different relational database management systems.

---

# Summary

This exercise demonstrated the complete lifecycle of query execution using Spring Data JPA and Hibernate.

Starting from custom repository methods, Hibernate parsed HQL statements, generated optimized SQL, executed queries through JDBC, and converted database rows back into Java entity objects.

The implementation also covered query optimization using `JOIN FETCH`, aggregate functions with `AVG()`, named parameters using `@Param`, and direct database interaction using Native SQL queries. These techniques are fundamental for building efficient, scalable, and maintainable enterprise applications using Spring Boot and Hibernate.

# Running the Application

Follow the steps below to execute the project successfully.

---

## Step 1: Start MySQL Server

Ensure that MySQL Server is running.

Verify that the **ormlearn** database exists.

```sql
SHOW DATABASES;
```

Expected Output

```
ormlearn
```

---

## Step 2: Verify Required Tables

Execute

```sql
SHOW TABLES;
```

Expected Output

```
department

employee

employee_skill

skill
```

These tables were created during the previous O/R Mapping exercise.

---

## Step 3: Verify Sample Data

Execute the following SQL statements.

```sql
SELECT * FROM department;
```

```sql
SELECT * FROM employee;
```

```sql
SELECT * FROM skill;
```

```sql
SELECT * FROM employee_skill;
```

Ensure that the database contains sufficient sample data before running the application.

---

## Step 4: Configure Database Connection

Verify the following properties inside

```
application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ormlearn
spring.datasource.username=root
spring.datasource.password=********

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

---

## Step 5: Run the Spring Boot Application

Execute

```
OrmLearnApplication.java
```

Spring Boot initializes

- Spring Container
- Repository Beans
- Service Beans
- Hibernate Session Factory
- Database Connection

Hibernate validates entity mappings before executing the repository methods.

---

# Demonstration Performed

This exercise demonstrates three major implementations.

---

# Demonstration 1

## Get Permanent Employees using HQL

Repository Method

```java
@Query("""
SELECT DISTINCT e

FROM Employee e

LEFT JOIN FETCH e.department

LEFT JOIN FETCH e.skillList

WHERE e.permanent=true
""")
```

Business Requirement

Retrieve only permanent employees.

Operations Performed

- Execute HQL query.
- Join Department.
- Join Skill List.
- Return Employee objects.

Hibernate automatically converts HQL into SQL.

---

# Demonstration 2

## Average Salary using HQL

Repository Method

```java
@Query("""
SELECT AVG(e.salary)

FROM Employee e

WHERE e.department.id=:id
""")
```

Business Requirement

Calculate the average salary of employees working in a specific department.

Operations Performed

- Accept Department ID.
- Execute AVG().
- Return average salary.

The database performs the calculation.

No manual looping or calculations are required.

---

# Demonstration 3

## Native SQL Query

Repository Method

```java
@Query(
value="SELECT * FROM employee",
nativeQuery=true
)
```

Business Requirement

Retrieve all employees using database SQL.

Operations Performed

- Execute SQL directly.
- Retrieve employee rows.
- Convert rows into Employee objects.

Hibernate performs object mapping automatically.

---

# Output Screenshots

Capture the following screenshots for documentation.

| Screenshot | Description |
|------------|-------------|
| 01_HQL_Output.png | Permanent employees retrieved using HQL |
| 02_JOIN_FETCH_Output.png | HQL using JOIN FETCH |
| 03_Average_Salary_Output.png | Average salary calculation |
| 04_Native_Query_Output.png | Native SQL query execution |
| 05_SQL_Logs.png | Hibernate generated SQL |

---

# Database Verification

Verify that data retrieval is correct.

Execute

```sql
SELECT * FROM employee;
```

Verify department mapping

```sql
SELECT *

FROM department;
```

Verify employee skills

```sql
SELECT *

FROM employee_skill;
```

Verify skills

```sql
SELECT *

FROM skill;
```

Compare database records with the console output.

Both should match.

---

# Advantages of Hibernate Query Language

- Object-oriented query language.
- Uses entity classes instead of tables.
- Database independent.
- Easier to read.
- Easier to maintain.
- Automatically converted into SQL.
- Supports joins.
- Supports aggregate functions.
- Integrates seamlessly with Spring Data JPA.
- Eliminates manual ResultSet processing.

---

# Advantages of Native SQL

- Full SQL support.
- Supports vendor-specific database features.
- Better control over complex queries.
- Can execute stored procedures.
- Supports database-specific optimization.
- Useful for reporting applications.

---

# HQL vs Native SQL Summary

| Feature | HQL | Native SQL |
|----------|-----|------------|
| Uses Java Classes | ✅ | ❌ |
| Uses Java Fields | ✅ | ❌ |
| Uses Table Names | ❌ | ✅ |
| Uses Column Names | ❌ | ✅ |
| Database Independent | ✅ | ❌ |
| Supports Vendor Features | ❌ | ✅ |
| Automatically Converted to SQL | ✅ | ❌ |

---

# Common Errors

---

## QuerySyntaxException

### Error

```
QuerySyntaxException
```

### Cause

Incorrect entity name or field name in HQL.

### Solution

Use

```
Employee
```

instead of

```
employee
```

Use

```
salary
```

instead of

```
em_salary
```

---

## LazyInitializationException

### Cause

Trying to access lazily loaded collections after the Hibernate session is closed.

### Solution

- Use `JOIN FETCH`.
- Access related data inside a transaction.
- Use EAGER fetching only when necessary.

---

## Parameter Binding Error

### Error

```
Parameter not bound
```

### Cause

Named parameter does not match the `@Param` annotation.

Example

Incorrect

```java
:id
```

```java
@Param("department")
```

Correct

```java
:id
```

```java
@Param("id")
```

---

## SQL Syntax Error

### Cause

Incorrect table or column name in a Native Query.

### Solution

Verify actual database table names.

---

## Database Connection Error

### Cause

Incorrect JDBC URL or MySQL Server not running.

### Solution

- Start MySQL Server.
- Verify credentials.
- Check `application.properties`.

---

# Interview Questions

## Basic

1. What is Hibernate Query Language (HQL)?
2. What is JPQL?
3. What is Native SQL Query?
4. What is the purpose of `@Query`?
5. What is the purpose of `@Param`?
6. What is Hibernate?
7. What is Spring Data JPA?
8. What is the difference between SQL and HQL?
9. Why do we use custom queries?
10. What is a Repository?

---

## Intermediate

11. Explain `JOIN FETCH`.
12. What is the N+1 Problem?
13. Why is `DISTINCT` used in HQL?
14. Explain aggregate functions in HQL.
15. What is `AVG()`?
16. Explain named parameters.
17. Explain Lazy Loading.
18. Explain Eager Loading.
19. Explain Persistence Context.
20. Explain Dirty Checking.

---

## Advanced

21. Difference between HQL and JPQL.
22. Difference between HQL and Native SQL.
23. How does Hibernate convert HQL into SQL?
24. When should Native SQL be preferred?
25. What is query optimization?
26. Explain Hibernate Query Parser.
27. How does Spring Data JPA execute `@Query`?
28. What are the advantages of HQL?
29. Explain the complete query execution lifecycle.
30. Explain the architecture of Spring Data JPA.

---

# Key Learnings

After completing this exercise, the following concepts were understood:

- Writing custom repository queries.
- Using the `@Query` annotation.
- Understanding Hibernate Query Language.
- Understanding Java Persistence Query Language.
- Executing Native SQL queries.
- Using named parameters with `@Param`.
- Calculating aggregate values using `AVG()`.
- Using `JOIN FETCH` to optimize queries.
- Avoiding the N+1 Query Problem.
- Understanding Hibernate query processing.
- Automatic HQL to SQL conversion.
- Object mapping performed by Hibernate.
- Repository abstraction using Spring Data JPA.
- Service-layer transaction management.
- Writing efficient and maintainable database queries.

---

# Conclusion

This exercise successfully demonstrated the implementation of **Hibernate Query Language (HQL)** and **Native SQL Queries** using **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**.

The implementation showed how developers can write expressive, object-oriented HQL queries using entity classes and Java properties instead of database tables and columns. It also demonstrated how Hibernate automatically parses HQL, generates optimized SQL, executes it through JDBC, and converts database records into Java entity objects.

The exercise further covered query optimization using **`JOIN FETCH`**, aggregate calculations using **`AVG()`**, parameterized queries with **`@Param`**, and direct database interaction through **Native SQL Queries**.

Overall, this hands-on provided practical experience in writing efficient, optimized, and maintainable database queries—an essential skill for developing enterprise-level Spring Boot applications with Hibernate and Spring Data JPA.

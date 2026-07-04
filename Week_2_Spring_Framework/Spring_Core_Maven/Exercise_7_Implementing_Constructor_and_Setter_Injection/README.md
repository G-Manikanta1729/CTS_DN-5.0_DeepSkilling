# Exercise 7: Implementing Constructor and Setter Injection

## Week 2 – Spring Framework

### Module
**Spring Core and Maven**

### Exercise
**Exercise 7: Implementing Constructor and Setter Injection**

---

# Introduction

Dependency Injection (DI) is one of the most important features of the Spring Framework. It allows the Spring IoC (Inversion of Control) Container to provide the required dependencies to a class instead of allowing the class to create them manually.

Spring supports multiple types of Dependency Injection, among which **Constructor Injection** and **Setter Injection** are the most commonly used.

In the previous exercises, we implemented **Setter Injection**, where Spring injected the required dependency using a setter method. In this exercise, we extend that concept by implementing **both Constructor Injection and Setter Injection** within the same class.

The `BookService` class requires two types of information:

- A **Library Name**, which is essential when the object is created.
- A **BookRepository** object, which is injected after object creation.

The Library Name is injected using the **Constructor**, while the BookRepository is injected using the **Setter Method**.

This exercise demonstrates how Spring creates a Bean using a constructor and then injects additional dependencies using setter methods.

---

# Objective

The objective of this exercise is to understand how Spring performs both **Constructor Injection** and **Setter Injection** within the same Bean.

After completing this exercise, you will learn:

- What is Constructor Injection?
- What is Setter Injection?
- Difference between Constructor and Setter Injection.
- Why Constructor Injection is used.
- Why Setter Injection is used.
- How Spring performs both injections.
- How to configure Constructor Injection using XML.
- How to configure Setter Injection using XML.
- How the Spring IoC Container manages both injection techniques.

---

# Scenario

A software company is developing a **Library Management System** using the Spring Framework.

The application contains two classes:

- **BookRepository**
- **BookService**

The `BookService` class requires two pieces of information:

1. The **Library Name**, which is mandatory and should be available as soon as the object is created.
2. The **BookRepository** object, which provides access to book-related operations.

To achieve this, the development team decides to use:

- **Constructor Injection** for the Library Name.
- **Setter Injection** for the BookRepository.

The Spring IoC Container is configured using an XML configuration file named **applicationContext.xml**.

When the application starts, Spring creates the `BookService` Bean using the constructor, injects the `BookRepository` using the setter method, stores the fully configured Bean inside the IoC Container, and provides it to the application whenever required.

---

# Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Spring Core | IoC Container and Dependency Injection |
| Maven | Dependency Management |
| XML | Bean Configuration |
| IntelliJ IDEA | Integrated Development Environment |

---

# Prerequisites

Before performing this exercise, you should know:

- Java Classes and Objects
- Constructors
- Methods
- Setter Methods
- Spring IoC Container
- Dependency Injection
- XML Configuration
- Maven Basics

---

# Concepts Used

## 1. What is Dependency Injection?

### Definition

Dependency Injection (DI) is a design pattern in which the required dependencies of a class are provided by an external source instead of the class creating them manually.

In Spring, the external source is the **Spring IoC Container**.

Instead of writing:

```java
BookRepository repository = new BookRepository();
```

Spring automatically creates the object and injects it wherever required.

---

# 2. Constructor Injection

### Definition

Constructor Injection is a type of Dependency Injection in which the required dependencies are provided through the **constructor** of a class.

The dependency is passed while the object is being created.

Example:

```java
public BookService(String libraryName) {

    this.libraryName = libraryName;

}
```

The Spring IoC Container calls this constructor automatically.

---

## Why Constructor Injection?

Constructor Injection is generally used for **mandatory dependencies**.

If an object cannot function without a particular value or dependency, it should be supplied through the constructor.

Examples:

- Library Name
- Database URL
- Application Configuration
- Company Name

These values should be available immediately after object creation.

---

## Real-Life Example

Imagine buying a new laptop.

When you purchase it, the following components are already included:

- Processor
- RAM
- Motherboard

Without these components, the laptop cannot function.

These are mandatory components.

Similarly,

Constructor Injection provides the mandatory information required during object creation.

---

# 3. Setter Injection

### Definition

Setter Injection is a type of Dependency Injection in which dependencies are provided using setter methods after the object has been created.

Example:

```java
public void setBookRepository(BookRepository bookRepository) {

    this.bookRepository = bookRepository;

}
```

Spring automatically calls this setter method and injects the required dependency.

---

## Why Setter Injection?

Setter Injection is suitable for dependencies that are **optional** or may change after object creation.

Examples:

- Repository Objects
- Service Objects
- Configuration Objects
- Helper Classes

These dependencies can be injected after the object has already been created.

---

## Real-Life Example

Imagine joining a company.

When you join, the company gives you:

- Employee ID
- Employee Name

These are permanent and mandatory.

Later, the company provides:

- Laptop
- Access Card
- Email Account

These resources are assigned after you join.

Similarly,

Constructor Injection initializes the object with mandatory information, while Setter Injection provides additional dependencies later.

---

# 4. Why Use Both Constructor and Setter Injection?

Many enterprise applications require both mandatory and optional dependencies.

Constructor Injection is used for mandatory values.

Setter Injection is used for optional or changeable dependencies.

Using both techniques together makes the application more flexible and easier to maintain.

---

# 5. Difference Between Constructor Injection and Setter Injection

| Constructor Injection | Setter Injection |
|------------------------|------------------|
| Dependency is provided through the constructor. | Dependency is provided through a setter method. |
| Used for mandatory dependencies. | Used for optional dependencies. |
| Object cannot be created without the dependency. | Object can be created first and configured later. |
| Injection happens during object creation. | Injection happens after object creation. |
| Promotes immutable objects. | Allows dependencies to be modified later if required. |

---

# 6. Spring IoC Container

The Spring IoC Container is responsible for:

- Reading the XML configuration.
- Creating Beans.
- Calling constructors.
- Calling setter methods.
- Injecting dependencies.
- Managing Bean lifecycle.
- Returning configured Beans to the application.

In this exercise, the IoC Container performs both Constructor Injection and Setter Injection automatically.

---

# Real-Life Analogy

Imagine a university admitting a new student.

During admission, the student receives:

- Student ID
- Roll Number
- Branch

These details are permanent and mandatory.

Later, the university provides:

- Library Card
- Hostel Room
- Laboratory Access

The admission details are similar to **Constructor Injection** because they are required at the time of creation.

The additional facilities are similar to **Setter Injection** because they can be assigned after admission.

This is exactly how Spring performs Constructor Injection followed by Setter Injection.

---

# Learning Outcomes

After completing this exercise, you will be able to:

- Understand Constructor Injection.
- Understand Setter Injection.
- Explain the differences between Constructor and Setter Injection.
- Configure Constructor Injection using XML.
- Configure Setter Injection using XML.
- Configure multiple injection techniques within the same Bean.
- Understand how the Spring IoC Container performs Bean creation and dependency injection.
- Build more flexible and maintainable Spring applications using both injection techniques.

---

# Project Structure

The project follows the standard Maven directory structure recommended for Spring Framework applications.

```
Exercise_7_Implementing_Constructor_and_Setter_Injection
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
│   │        ├── repository
│   │        │      └── BookRepository.java
│   │        │
│   │        ├── service
│   │        │      └── BookService.java
│   │        │
│   │        └── main
│   │               └── LibraryManagementApplication.java
│   │
│   └── resources
│          └── applicationContext.xml
│
└── Output
    └── Output.png
```

---

# Folder and File Description

| File / Folder | Description |
|---------------|-------------|
| **pom.xml** | Contains Maven configuration and Spring dependencies. |
| **BookRepository.java** | Repository layer responsible for book-related data operations. |
| **BookService.java** | Service layer containing both Constructor Injection and Setter Injection. |
| **applicationContext.xml** | Spring configuration file that defines Beans and configures both injection techniques. |
| **LibraryManagementApplication.java** | Main class that loads the Spring IoC Container and tests the application. |
| **Output** | Contains screenshots of the successful program execution. |

---

# Implementation

The implementation of this exercise is divided into six simple steps.

---

# Step 1 : Create a Maven Project

Create a Maven project named **LibraryManagement**.

Project Information

| Property | Value |
|----------|-------|
| Group ID | com.library |
| Artifact ID | LibraryManagement |
| Version | 1.0-SNAPSHOT |

Maven automatically creates the standard project directory structure.

---

# Step 2 : Add Spring Dependency

Open **pom.xml** and add the Spring Context dependency.

```xml
<dependency>

    <groupId>org.springframework</groupId>

    <artifactId>spring-context</artifactId>

    <version>6.1.8</version>

</dependency>
```

---

## Why is Spring Context Required?

The **spring-context** module provides:

- Spring IoC Container
- Dependency Injection
- Bean Management
- ApplicationContext
- XML Configuration Support

Without this dependency, Spring cannot create or manage Beans.

---

# Step 3 : Create the Repository Class

Package

```
com.library.repository
```

Class

```
BookRepository.java
```

```java
package com.library.repository;

public class BookRepository {

    public void displayRepository() {

        System.out.println("Book Repository Bean Created Successfully.");

    }

}
```

---

# Understanding BookRepository

The Repository Layer is responsible for interacting with the database.

In a real Library Management System, this class would perform operations such as:

- Add Book
- Update Book
- Delete Book
- Search Book
- Retrieve Book Information

For this exercise, the Repository simply prints a message indicating that the Bean has been created successfully.

---

# Step 4 : Create the Service Class

Package

```
com.library.service
```

Class

```
BookService.java
```

```java
package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private String libraryName;

    private BookRepository bookRepository;

    // Constructor Injection
    public BookService(String libraryName) {

        this.libraryName = libraryName;

    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

    }

    public void displayService() {

        System.out.println("Library Name : " + libraryName);

        System.out.println("Book Service Bean Created Successfully.");

        bookRepository.displayRepository();

    }

}
```

---

# Understanding BookService

The Service Layer contains the business logic of the application.

Examples include:

- Issue Books
- Return Books
- Calculate Fine
- Validate Book Details
- Manage Library Operations

In this exercise, it demonstrates both **Constructor Injection** and **Setter Injection**.

---

## Understanding the Constructor

```java
public BookService(String libraryName)
```

The constructor receives the **Library Name** while creating the object.

Spring automatically calls this constructor.

Internally, Spring performs an operation similar to:

```java
BookService service =
new BookService("Central Library");
```

This is called **Constructor Injection**.

---

## Understanding the Setter Method

```java
public void setBookRepository(BookRepository bookRepository)
```

After creating the object, Spring calls this setter method.

Internally, Spring performs:

```java
service.setBookRepository(repository);
```

This is called **Setter Injection**.

---

## Why Both Are Used?

The `libraryName` is mandatory because a Library Service cannot exist without knowing which library it belongs to.

The `BookRepository` is another Bean that provides repository functionality, so it is injected after object creation.

This demonstrates how Spring supports multiple injection techniques within the same Bean.

---

# Step 5 : Configure the Spring IoC Container

Create

```
src/main/resources/applicationContext.xml
```

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans
xmlns="http://www.springframework.org/schema/beans"

xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

xsi:schemaLocation="
http://www.springframework.org/schema/beans
https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Repository Bean -->

    <bean
            id="bookRepository"
            class="com.library.repository.BookRepository"/>

    <!-- Service Bean -->

    <bean
            id="bookService"
            class="com.library.service.BookService">

        <!-- Constructor Injection -->

        <constructor-arg
                value="Central Library"/>

        <!-- Setter Injection -->

        <property
                name="bookRepository"
                ref="bookRepository"/>

    </bean>

</beans>
```

---

# Understanding applicationContext.xml

The `applicationContext.xml` file is the central configuration file of the Spring application.

When the application starts, Spring reads this file and performs the following tasks:

- Creates Beans.
- Calls Constructors.
- Calls Setter Methods.
- Injects Dependencies.
- Stores Beans inside the IoC Container.

---

# Understanding `<constructor-arg>`

```xml
<constructor-arg
        value="Central Library"/>
```

This tells Spring:

> While creating the `BookService` Bean, call its constructor and pass the value `"Central Library"`.

Equivalent Java code:

```java
BookService service =
new BookService("Central Library");
```

This is **Constructor Injection**.

---

# Understanding `<property>`

```xml
<property
        name="bookRepository"
        ref="bookRepository"/>
```

This tells Spring:

- Find the Bean with ID `bookRepository`.
- Call the setter method.
- Inject the Bean into `BookService`.

Equivalent Java code:

```java
service.setBookRepository(repository);
```

This is **Setter Injection**.

---

# Step 6 : Create the Main Class

Package

```
com.library.main
```

Class

```
LibraryManagementApplication.java
```

```java
package com.library.main;

import com.library.service.BookService;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service =
                context.getBean("bookService", BookService.class);

        service.displayService();

    }

}
```

---

# Understanding the Main Class

The main class starts the Spring application.

It performs the following operations:

### Step 1

Loads

```
applicationContext.xml
```

using

```java
new ClassPathXmlApplicationContext(...)
```

---

### Step 2

Starts the Spring IoC Container.

---

### Step 3

Reads all Bean definitions.

---

### Step 4

Creates the `BookRepository` Bean.

---

### Step 5

Creates the `BookService` Bean using the constructor.

---

### Step 6

Injects the `BookRepository` Bean using the setter method.

---

### Step 7

Stores both Beans inside the IoC Container.

---

### Step 8

Returns the fully configured `BookService` Bean.

```java
BookService service =
context.getBean("bookService", BookService.class);
```

Notice that the application never creates any object manually.

Spring performs:

- Object Creation
- Constructor Injection
- Setter Injection
- Dependency Management

automatically through the IoC Container.

---

# Execution Flow

The following diagram illustrates how Spring performs both Constructor Injection and Setter Injection when the application starts.

```
Application Starts
        │
        ▼
Load applicationContext.xml
        │
        ▼
Spring IoC Container Starts
        │
        ▼
Read Bean Definitions
        │
        ▼
Create BookRepository Bean
        │
        ▼
Call BookService Constructor
(Constructor Injection)
        │
        ▼
Inject BookRepository Bean
using Setter Method
(Setter Injection)
        │
        ▼
Store Beans Inside IoC Container
        │
        ▼
Application Requests BookService Bean
        │
        ▼
Spring Returns Configured Bean
        │
        ▼
displayService() Executes
        │
        ▼
displayRepository() Executes
        │
        ▼
Output Displayed
```

---

# Internal Working of Spring

When the application starts, the Spring Framework performs the following operations automatically.

---

## Step 1

The application starts by executing the main method.

```java
ApplicationContext context =
new ClassPathXmlApplicationContext("applicationContext.xml");
```

This statement starts the Spring IoC Container.

---

## Step 2

Spring loads the configuration file.

```
applicationContext.xml
```

The configuration file contains information about:

- Bean Definitions
- Constructor Arguments
- Setter Properties
- Bean Relationships

---

## Step 3

Spring creates the Repository Bean.

Internally it performs an operation similar to:

```java
BookRepository repository =
new BookRepository();
```

---

## Step 4

Spring creates the Service Bean.

It notices the following XML configuration.

```xml
<constructor-arg
value="Central Library"/>
```

Therefore, Spring calls:

```java
BookService service =
new BookService("Central Library");
```

This is called **Constructor Injection**.

---

## Step 5

Spring then finds:

```xml
<property

name="bookRepository"

ref="bookRepository"/>
```

It automatically calls

```java
service.setBookRepository(repository);
```

This is called **Setter Injection**.

---

## Step 6

The completely initialized object now looks like

```
BookService

│

├── libraryName

│      "Central Library"

│

└── BookRepository

       Bean Reference
```

The object is now fully configured.

---

## Step 7

Spring stores the Bean inside the IoC Container.

```
Spring IoC Container

│

├── BookRepository Bean

└── BookService Bean
        │
        ├── Library Name
        └── BookRepository
```

---

## Step 8

The application requests

```java
BookService service =
context.getBean("bookService",
BookService.class);
```

Instead of creating another object,

Spring returns the existing Bean from the IoC Container.

---

## Step 9

The following method executes.

```java
service.displayService();
```

Internally,

```
displayService()

↓

displayRepository()

↓

Output
```

---

# Expected Output

```
Library Name : Central Library

Book Service Bean Created Successfully.

Book Repository Bean Created Successfully.
```

---

# Executed Output

<img width="1730" height="957" alt="Output" src="https://github.com/user-attachments/assets/921b3281-809d-4c0d-b1f5-927e6b7b0227" />

---

# Constructor Injection vs Setter Injection

| Constructor Injection | Setter Injection |
|------------------------|------------------|
| Dependency is injected through the constructor. | Dependency is injected through a setter method. |
| Executed during object creation. | Executed after object creation. |
| Suitable for mandatory dependencies. | Suitable for optional dependencies. |
| Ensures the object is fully initialized at creation. | Allows dependencies to be changed later if required. |
| Promotes immutable objects. | Provides flexibility to modify dependencies. |
| Uses `<constructor-arg>` in XML. | Uses `<property>` in XML. |

---

# Why Use Both Together?

Many real-world applications require both mandatory and optional dependencies.

For example:

### Mandatory

- Library Name
- Database URL
- Company Name
- Configuration File

These values should always be available when the object is created.

Therefore,

**Constructor Injection** is used.

---

### Optional

- Repository
- Logger
- Notification Service
- Email Service

These dependencies may be assigned after object creation.

Therefore,

**Setter Injection** is used.

Using both approaches makes applications more flexible and maintainable.

---

# Advantages

## Constructor Injection

- Ensures mandatory dependencies are provided.
- Prevents partially initialized objects.
- Makes objects more reliable.
- Encourages immutable design.
- Easier to test mandatory dependencies.

---

## Setter Injection

- Suitable for optional dependencies.
- Dependencies can be changed later.
- Provides greater flexibility.
- Simplifies configuration.
- Useful when dependencies are not always required.

---

## Advantages of Using Spring for Dependency Injection

- Automatic object creation.
- Automatic dependency management.
- Loose coupling between classes.
- Better code maintainability.
- Improved testability.
- Centralized configuration.
- Easy to modify dependencies without changing business logic.
- Better scalability for enterprise applications.

---

# Common Errors and Solutions

## Error

```
No qualifying bean found
```

### Reason

Incorrect Bean ID.

### Solution

Verify the Bean ID in `applicationContext.xml`.

---

## Error

```
BeanCreationException
```

### Reason

Constructor arguments or Bean configuration are incorrect.

### Solution

Verify:

- Constructor parameters.
- Bean class names.
- XML syntax.

---

## Error

```
NullPointerException
```

### Reason

Setter Injection was not performed.

### Solution

Verify that:

- Setter method exists.
- `<property>` is configured correctly.
- Bean reference is correct.

---

## Error

```
Cannot resolve Bean
```

### Reason

Incorrect package or class name.

### Solution

Verify the package structure and class names.

---

# Interview Questions

## 1. What is Constructor Injection?

**Answer**

Constructor Injection is a Dependency Injection technique where Spring provides required dependencies through the constructor while creating the Bean.

---

## 2. What is Setter Injection?

**Answer**

Setter Injection is a Dependency Injection technique where Spring injects dependencies by calling setter methods after creating the Bean.

---

## 3. What is the difference between Constructor Injection and Setter Injection?

**Answer**

Constructor Injection is used for mandatory dependencies and occurs during object creation, whereas Setter Injection is used for optional dependencies and occurs after object creation.

---

## 4. Which injection type is recommended?

**Answer**

Constructor Injection is generally preferred for mandatory dependencies because it ensures that an object is fully initialized when it is created. Setter Injection is useful for optional dependencies.

---

## 5. Which XML tag is used for Constructor Injection?

**Answer**

```xml
<constructor-arg>
```

---

## 6. Which XML tag is used for Setter Injection?

**Answer**

```xml
<property>
```

---

## 7. Can Constructor Injection and Setter Injection be used together?

**Answer**

Yes. A single Bean can use Constructor Injection for mandatory dependencies and Setter Injection for optional dependencies. This exercise demonstrates exactly that.

---

## 8. Who performs Dependency Injection in Spring?

**Answer**

The Spring IoC Container performs Dependency Injection automatically by reading the configuration from `applicationContext.xml`.

---

## 9. What is the role of ApplicationContext?

**Answer**

`ApplicationContext` loads the Spring configuration, creates Beans, injects dependencies, manages the Bean lifecycle, and provides configured Beans to the application.

---

## 10. Why is Dependency Injection important?

**Answer**

Dependency Injection reduces coupling between classes, improves maintainability, simplifies testing, and allows Spring to manage object creation and configuration.

---

# Key Learnings

After completing this exercise, you have learned:

- Constructor Injection
- Setter Injection
- XML-based Constructor Injection
- XML-based Setter Injection
- Spring Bean Configuration
- Spring IoC Container
- ApplicationContext
- Bean Creation
- Bean Wiring
- Difference between Constructor and Setter Injection
- Combining multiple injection techniques in a single Bean

---

# Conclusion

This exercise demonstrates how the Spring Framework supports multiple Dependency Injection techniques within the same Bean. The `BookService` Bean is initialized using **Constructor Injection** to provide the mandatory `libraryName`, while the `BookRepository` dependency is injected later using **Setter Injection**.

By combining both approaches, Spring creates a fully initialized and loosely coupled object without requiring the developer to manually instantiate or connect the dependencies. This reduces boilerplate code, improves maintainability, and makes applications easier to test and extend.

Understanding both Constructor Injection and Setter Injection is an important step in mastering the Spring Framework, as these techniques are widely used in enterprise applications built with **Spring Core**, **Spring Boot**, **Spring MVC**, **Spring Data JPA**, and other Spring modules.

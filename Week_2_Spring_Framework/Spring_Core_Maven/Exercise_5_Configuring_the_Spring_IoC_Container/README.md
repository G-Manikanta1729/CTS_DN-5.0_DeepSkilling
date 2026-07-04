# Exercise 5: Configuring the Spring IoC Container

## Week 2 – Spring Framework

### Module
**Spring Core and Maven**

### Exercise
**Exercise 5: Configuring the Spring IoC Container**

---

# Introduction

One of the most important features of the Spring Framework is the **IoC (Inversion of Control) Container**. It is considered the heart of the Spring Framework because it is responsible for creating, configuring, managing, and destroying Java objects called **Beans**.

In a traditional Java application, the programmer creates objects manually using the `new` keyword. As applications grow larger, managing object creation and dependencies becomes difficult and results in tightly coupled code.

The Spring IoC Container solves this problem by taking control of object creation and dependency management. Instead of developers creating objects manually, Spring creates the required objects, stores them inside the container, injects dependencies between them, and provides them whenever requested.

In this exercise, the Spring IoC Container is configured using an XML configuration file named **applicationContext.xml**. Two beans (`BookService` and `BookRepository`) are created and managed by the IoC Container. The dependency between these two classes is established using **Setter Dependency Injection**.

This exercise demonstrates how the Spring IoC Container works internally and how it simplifies object management in enterprise applications.

---

# Objective

The objective of this exercise is to understand how to configure and use the **Spring IoC Container** using XML-based configuration.

After completing this exercise, you will learn:

- What is the Spring IoC Container?
- Why the IoC Container is required.
- What are Spring Beans?
- How Spring creates and manages Beans.
- How to configure Beans using XML.
- How Setter Dependency Injection works inside the IoC Container.
- How to load and use the ApplicationContext.

---

# Scenario

A company is developing a **Library Management System** using the Spring Framework.

The application contains two classes:

- **BookRepository**
- **BookService**

The `BookService` class depends on the `BookRepository` class to perform book-related operations.

Instead of creating these objects manually using the `new` keyword, the development team wants Spring to create and manage them automatically.

To achieve this, the application is configured using the **Spring IoC Container**, where all Bean definitions and dependencies are declared inside the `applicationContext.xml` file.

When the application starts, Spring reads the XML configuration, creates the required Beans, injects the dependencies, and provides the configured objects to the application.

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
- Methods
- Constructors
- Setter Methods
- Maven Basics
- Spring Framework Basics
- IoC (Inversion of Control)
- Dependency Injection (DI)

---

# Concepts Used

## 1. What is the Spring IoC Container?

### Definition

The **Spring IoC (Inversion of Control) Container** is the core component of the Spring Framework responsible for creating, configuring, managing, and destroying Java objects called **Beans**.

Instead of the programmer creating objects manually, the IoC Container creates them automatically based on the configuration provided.

In simple words,

> **The Spring IoC Container is a factory that creates, manages, and supplies objects whenever they are needed.**

---

## Why is the IoC Container Needed?

Consider the following Java code.

```java
BookRepository repository = new BookRepository();

BookService service = new BookService();

service.setBookRepository(repository);
```

In this approach, the programmer is responsible for:

- Creating objects.
- Managing object lifecycle.
- Injecting dependencies.

As applications become larger, this approach becomes difficult to maintain.

The Spring IoC Container automates all these tasks.

---

## How Does the IoC Container Work?

```
Application Starts

↓

Spring Reads XML Configuration

↓

Creates Beans

↓

Injects Dependencies

↓

Stores Beans

↓

Provides Beans Whenever Requested
```

The developer only requests the required Bean.

Spring performs all the remaining tasks automatically.

---

# 2. What is a Spring Bean?

### Definition

A **Spring Bean** is any Java object that is created, configured, and managed by the Spring IoC Container.

For example,

```xml
<bean
    id="bookRepository"
    class="com.library.repository.BookRepository"/>
```

When Spring starts, it creates an object of the `BookRepository` class and stores it inside the IoC Container.

Similarly,

```xml
<bean
    id="bookService"
    class="com.library.service.BookService"/>
```

creates and manages the `BookService` object.

---

## Characteristics of a Spring Bean

A Spring Bean is:

- Created by the IoC Container.
- Managed by the IoC Container.
- Configured through XML or annotations.
- Available throughout the application whenever required.

---

# 3. What is ApplicationContext?

### Definition

`ApplicationContext` is one of the most commonly used implementations of the Spring IoC Container.

It is responsible for:

- Reading configuration files.
- Creating Beans.
- Managing Bean lifecycle.
- Injecting dependencies.
- Returning Beans to the application.

Example:

```java
ApplicationContext context =
new ClassPathXmlApplicationContext("applicationContext.xml");
```

This statement starts the Spring IoC Container.

---

# 4. What is applicationContext.xml?

The **applicationContext.xml** file is the configuration file used by the Spring IoC Container.

It contains information about:

- Bean definitions.
- Bean IDs.
- Bean classes.
- Dependency Injection.
- Bean relationships.

When the application starts, Spring reads this file and performs all required configurations automatically.

---

# 5. Bean Configuration

Bean configuration tells Spring which objects should be created.

Example:

```xml
<bean
    id="bookRepository"
    class="com.library.repository.BookRepository"/>
```

This tells Spring:

- Create a `BookRepository` object.
- Store it inside the IoC Container.
- Assign the ID `bookRepository`.

---

# 6. Dependency Injection Inside the IoC Container

The `BookService` class depends on `BookRepository`.

Instead of creating the dependency manually,

```java
BookRepository repository = new BookRepository();
```

Spring injects it automatically.

Example:

```xml
<property
    name="bookRepository"
    ref="bookRepository"/>
```

This tells Spring:

- Find the Bean named `bookRepository`.
- Pass it to the `BookService` object through its setter method.

This process is called **Setter Dependency Injection**.

---

# 7. Real-Life Analogy

Imagine a university.

Without an IoC Container:

Each professor purchases:

- Whiteboard
- Marker
- Projector
- Laptop

individually.

With an IoC Container:

The university provides all these resources before the professor enters the classroom.

The professor simply focuses on teaching.

Similarly,

Without Spring:

The programmer creates every object manually.

With Spring:

The IoC Container creates all required objects and provides them automatically.

---

# Learning Outcomes

After completing this exercise, you will be able to:

- Explain the purpose of the Spring IoC Container.
- Understand Spring Bean management.
- Configure Beans using XML.
- Load the Spring ApplicationContext.
- Configure Setter Dependency Injection.
- Understand how Spring manages object creation.
- Build loosely coupled Java applications using Spring.

---

# Project Structure

The project follows the standard Maven directory structure recommended for Spring Framework applications.

```
Exercise_5_Configuring_the_Spring_IoC_Container
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
| **pom.xml** | Contains Maven configuration, project information, and Spring dependencies. |
| **BookRepository.java** | Repository class that simulates data access operations. |
| **BookService.java** | Service class containing business logic and depending on `BookRepository`. |
| **applicationContext.xml** | Spring IoC Container configuration file where Beans and dependencies are defined. |
| **LibraryManagementApplication.java** | Main class used to start the Spring application and retrieve Beans from the IoC Container. |
| **Output** | Stores screenshots showing successful execution of the application. |

---

# Implementation

The implementation of this exercise is divided into five simple steps.

---

# Step 1 : Create a Maven Project

A Maven project named **LibraryManagement** is created.

The project uses Maven to manage external libraries and dependencies.

Project Information

| Property | Value |
|----------|-------|
| Group ID | com.library |
| Artifact ID | LibraryManagement |
| Version | 1.0-SNAPSHOT |

---

# Step 2 : Add Spring Dependency

The following dependency is added to the **pom.xml** file.

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

- IoC Container
- Dependency Injection
- Bean Management
- ApplicationContext
- XML Configuration Support

Without this dependency, the Spring IoC Container cannot be created.

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

The Repository Layer is responsible for communicating with the database.

In a real Library Management System, this class would perform operations such as:

- Add Book
- Delete Book
- Update Book
- Search Book
- Retrieve Book Details

For this exercise, it simply prints a message indicating that the Bean has been created successfully.

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

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

    }

    public void displayService() {

        System.out.println("Book Service Bean Created Successfully.");

        bookRepository.displayRepository();

    }

}
```

---

# Understanding BookService

The Service Layer contains the application's business logic.

Examples:

- Issue Books
- Return Books
- Calculate Fine
- Search Books
- Validate Book Information

In this exercise, the Service Layer simply displays a message and calls the Repository method.

---

## Understanding the Dependency

Notice the following declaration.

```java
private BookRepository bookRepository;
```

This means:

**BookService depends on BookRepository.**

Instead of creating the object manually,

```java
BookRepository repository = new BookRepository();
```

Spring creates the object automatically.

---

## Understanding the Setter Method

```java
public void setBookRepository(BookRepository bookRepository)
```

This is called a **Setter Method**.

The Spring IoC Container calls this method automatically and injects the required Bean.

This process is called **Setter Dependency Injection**.

---

# Step 5 : Configure the Spring IoC Container

Inside

```
src/main/resources
```

create

```
applicationContext.xml
```

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans
xmlns="http://www.springframework.org/schema/beans"

xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

xsi:schemaLocation="
http://www.springframework.org/schema/beans
https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean
            id="bookRepository"
            class="com.library.repository.BookRepository"/>

    <bean
            id="bookService"
            class="com.library.service.BookService">

        <property
                name="bookRepository"
                ref="bookRepository"/>

    </bean>

</beans>
```

---

# Understanding applicationContext.xml

This file is the heart of the Spring application.

When the application starts, Spring reads this configuration file.

The IoC Container performs the following tasks automatically.

- Creates Beans.
- Stores Beans.
- Injects Dependencies.
- Manages Bean Lifecycle.
- Provides Beans whenever required.

---

# Understanding the `<bean>` Tag

Example

```xml
<bean
id="bookRepository"
class="com.library.repository.BookRepository"/>
```

Meaning

- Create an object of BookRepository.
- Store it inside the IoC Container.
- Assign the Bean ID as **bookRepository**.

---

# Understanding the `<property>` Tag

```xml
<property

name="bookRepository"

ref="bookRepository"/>
```

This tells Spring

- Find the Bean named **bookRepository**.
- Pass it to the setter method.
- Inject it into BookService.

Internally, Spring performs something similar to:

```java
BookRepository repository = new BookRepository();

BookService service = new BookService();

service.setBookRepository(repository);
```

The programmer never writes this code.

The IoC Container performs it automatically.

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

It performs the following operations.

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

Creates all configured Beans.

---

### Step 5

Injects the required dependencies.

---

### Step 6

Returns the requested Bean.

```java
BookService service =
context.getBean("bookService", BookService.class);
```

Notice that the application never creates a `BookRepository` object.

Everything is managed by the Spring IoC Container.

This is the biggest advantage of using Spring.

---

# Execution Flow

The following diagram illustrates how the Spring IoC Container works when the application starts.

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
Create BookService Bean
        │
        ▼
Inject BookRepository into BookService
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

# Internal Working of the Spring IoC Container

When the application starts, Spring performs several operations automatically.

## Step 1

The application executes the main method.

```java
ApplicationContext context =
new ClassPathXmlApplicationContext("applicationContext.xml");
```

This statement starts the **Spring IoC Container**.

---

## Step 2

Spring reads the XML configuration file.

```
applicationContext.xml
```

Inside this file, Spring finds the following Bean definitions.

```
BookRepository

BookService
```

---

## Step 3

Spring creates the `BookRepository` object.

Internally, it performs an operation similar to:

```java
BookRepository repository = new BookRepository();
```

---

## Step 4

Spring creates the `BookService` object.

Internally,

```java
BookService service = new BookService();
```

---

## Step 5

Spring notices the following configuration.

```xml
<property

name="bookRepository"

ref="bookRepository"/>
```

Spring understands that the `BookService` Bean requires the `BookRepository` Bean.

---

## Step 6

Spring automatically calls the setter method.

Internally,

```java
service.setBookRepository(repository);
```

This process is called **Setter Dependency Injection**.

---

## Step 7

Both Beans are stored inside the IoC Container.

```
Spring IoC Container

│

├── BookRepository Bean

└── BookService Bean
        │
        └── contains BookRepository
```

---

## Step 8

The application requests the BookService Bean.

```java
BookService service =
context.getBean("bookService", BookService.class);
```

Instead of creating a new object, Spring returns the existing Bean from the IoC Container.

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
```

The output is displayed successfully.

---

# Expected Output

```
Book Service Bean Created Successfully.

Book Repository Bean Created Successfully.
```

---

# Executed Output

<img width="1731" height="960" alt="Output" src="https://github.com/user-attachments/assets/7ebb1064-ab86-4aa4-b7db-c614ab7a788b" />

---

# Exercise 2 vs Exercise 5

Many beginners think these two exercises are identical because the code is very similar.

However, the learning objectives are different.

| Exercise 2 | Exercise 5 |
|------------|------------|
| Focuses on Dependency Injection | Focuses on the Spring IoC Container |
| Demonstrates Setter Injection | Demonstrates Bean Creation and Bean Management |
| Explains how dependencies are injected | Explains how Spring creates, stores, manages, and injects Beans |
| Main concept is DI | Main concept is IoC Container |

Although the implementation is similar, Exercise 5 emphasizes the role of the **Spring IoC Container**.

---

# Advantages of the Spring IoC Container

The Spring IoC Container provides several benefits.

## 1. Automatic Object Creation

Developers do not need to create objects manually.

Instead of writing:

```java
BookRepository repository =
new BookRepository();
```

Spring creates the object automatically.

---

## 2. Automatic Dependency Injection

Dependencies between classes are configured using XML or annotations.

Spring injects them automatically.

---

## 3. Loose Coupling

Classes do not create their own dependencies.

This reduces coupling and improves flexibility.

---

## 4. Better Maintainability

Changing one component does not require modifications in multiple classes.

Configuration changes can often be made without changing business logic.

---

## 5. Better Reusability

Beans created by Spring can be reused throughout the application.

---

## 6. Centralized Configuration

All Bean definitions are maintained in one place.

```
applicationContext.xml
```

This improves readability and maintainability.

---

# Common Errors and Solutions

## Error

```
No qualifying bean found
```

### Reason

The Bean ID is incorrect.

### Solution

Verify that the Bean ID in the XML file matches the ID used in `getBean()`.

---

## Error

```
Cannot resolve Bean
```

### Reason

The class name or package name is incorrect.

### Solution

Verify the package structure and class names.

---

## Error

```
BeanCreationException
```

### Reason

The XML configuration is invalid or the Bean cannot be created.

### Solution

Check the Bean definition and XML syntax.

---

## Error

```
NullPointerException
```

### Reason

Dependency Injection did not occur.

### Solution

Verify that:

- The setter method exists.
- The `<property>` tag is correctly configured.
- The Bean reference is correct.

---

# Interview Questions

## 1. What is the Spring IoC Container?

**Answer**

The Spring IoC Container is the core component of the Spring Framework responsible for creating, configuring, managing, and destroying Spring Beans.

---

## 2. What is a Spring Bean?

**Answer**

A Spring Bean is a Java object created, configured, and managed by the Spring IoC Container.

---

## 3. What is ApplicationContext?

**Answer**

ApplicationContext is the central interface of the Spring Framework that loads configuration files, creates Beans, manages Bean lifecycle, and performs Dependency Injection.

---

## 4. What is applicationContext.xml?

**Answer**

It is the XML configuration file used to define Spring Beans and configure Dependency Injection.

---

## 5. What is the purpose of the `<bean>` tag?

**Answer**

The `<bean>` tag tells Spring which class should be instantiated and managed by the IoC Container.

---

## 6. What is the purpose of the `<property>` tag?

**Answer**

The `<property>` tag tells Spring to inject a dependency into a Bean through its setter method.

---

## 7. What is Setter Dependency Injection?

**Answer**

Setter Dependency Injection is a technique in which Spring injects dependencies by calling the setter methods of a class.

---

## 8. What is the difference between IoC and DI?

**Answer**

**IoC** transfers the responsibility of object creation and management to Spring.

**DI** is the mechanism through which Spring provides required dependencies to those objects.

---

## 9. Why is the Spring IoC Container important?

**Answer**

It simplifies application development by automating object creation, dependency management, and Bean lifecycle management, resulting in loosely coupled and maintainable applications.

---

## 10. Which implementation of the IoC Container is used in this exercise?

**Answer**

`ClassPathXmlApplicationContext`

It loads the XML configuration file from the application's classpath.

---

# Key Learnings

After completing this exercise, you have learned:

- Spring IoC Container
- Spring Bean Management
- Bean Configuration using XML
- ApplicationContext
- ClassPathXmlApplicationContext
- Setter Dependency Injection
- Bean Wiring
- Bean Lifecycle (Basic Understanding)
- XML-Based Spring Configuration
- Loose Coupling using Spring

---

# Conclusion

This exercise demonstrates how the **Spring IoC Container** acts as the central component of the Spring Framework by creating, configuring, managing, and providing Java objects (Beans) throughout the application.

Instead of manually creating objects and managing dependencies, the Spring IoC Container automates these tasks using the `applicationContext.xml` configuration file. The `BookRepository` and `BookService` classes are registered as Beans, and the dependency between them is established through **Setter Dependency Injection**.

By centralizing object creation and dependency management, Spring promotes **loose coupling**, **better maintainability**, **code reusability**, and **simplified application development**.

Understanding the Spring IoC Container is essential because it forms the foundation for advanced Spring technologies such as **Spring Boot**, **Spring MVC**, **Spring Data JPA**, **Spring Security**, and **Microservices**. Mastering this concept prepares developers to build scalable and maintainable enterprise Java applications.

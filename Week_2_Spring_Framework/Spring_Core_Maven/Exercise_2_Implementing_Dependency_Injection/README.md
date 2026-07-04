# Exercise 2: Implementing Dependency Injection

## Week 2 - Spring Framework

### Module
**Spring Core and Maven**

### Exercise
**Exercise 2: Implementing Dependency Injection**

---

# Introduction

In the previous exercise, we learned how to configure a basic Spring application and how the Spring IoC (Inversion of Control) Container creates and manages Java objects called **Beans**.

However, creating objects alone is not enough for real-world applications. Most classes depend on other classes to perform their work.

For example, a **BookService** class needs a **BookRepository** class to access book information from the database.

Instead of allowing the `BookService` class to create its own `BookRepository` object, Spring provides the required object automatically. This concept is called **Dependency Injection (DI)**.

This exercise demonstrates how to implement **Setter Dependency Injection** using **Spring XML Configuration**.

---

# Objective

The objective of this exercise is to understand how Spring performs **Dependency Injection (DI)** using the **Setter Injection** approach.

After completing this exercise, you will learn:

- What is Dependency Injection?
- Why Dependency Injection is required.
- Difference between IoC and DI.
- How Spring injects dependencies using XML.
- How Setter Injection works.
- How Spring manages relationships between Beans.

---

# Scenario

A company is developing a **Library Management System**.

The application contains two classes:

- **BookRepository**
- **BookService**

The `BookService` class needs to use the `BookRepository` class to perform book-related operations.

Instead of creating the `BookRepository` object manually inside the `BookService` class, the company wants Spring Framework to create the object and inject it automatically.

To achieve this, Spring's **IoC Container** is configured using the `applicationContext.xml` file.

---

# Technologies Used

| Technology | Purpose |
|------------|---------|
| Java 21 | Programming Language |
| Spring Core | IoC Container and Dependency Injection |
| Maven | Dependency Management |
| XML | Bean Configuration |
| IntelliJ IDEA | IDE |

---

# Prerequisites

Before performing this exercise, you should know:

- Java Classes and Objects
- Methods
- Constructors
- Setter Methods
- Spring IoC
- Spring Beans
- Maven Basics

---

# Concepts Used

## 1. Dependency

### Definition

A dependency is an object that another object requires to perform its work.

### Example

Suppose a Car needs an Engine.

```
Car
 │
Needs
 │
Engine
```

The Engine is the dependency.

Similarly,

```
BookService
      │
Needs
      │
BookRepository
```

Here,

- BookService = Dependent Class
- BookRepository = Dependency

---

## 2. Dependency Injection (DI)

### Definition

Dependency Injection is a design pattern in which the required dependency of a class is provided by an external source instead of the class creating it itself.

In Spring, the external source is the **Spring IoC Container**.

Instead of writing:

```java
BookRepository repository = new BookRepository();
```

Spring creates the object and injects it into the `BookService` class.

---

## 3. Why Do We Need Dependency Injection?

Imagine an application containing:

- CustomerService
- ProductService
- OrderService
- PaymentService
- EmailService

If every class creates its own objects using `new`, the application becomes tightly coupled and difficult to maintain.

Example:

```java
CustomerRepository repository = new CustomerRepository();
```

If the repository implementation changes, every dependent class must also be modified.

Dependency Injection solves this problem by allowing Spring to create and provide the required objects.

This results in:

- Loose Coupling
- Better Maintainability
- Easy Testing
- Better Reusability

---

## 4. Inversion of Control (IoC) vs Dependency Injection (DI)

Many beginners think IoC and DI are the same. They are related but not identical.

### Inversion of Control (IoC)

IoC means that the responsibility of creating and managing objects is transferred from the programmer to the Spring Framework.

Example:

Instead of:

```java
BookService service = new BookService();
```

Spring creates the object.

### Dependency Injection (DI)

DI means Spring not only creates the object but also provides the objects that it depends on.

Example:

```
Spring

↓

Creates BookRepository

↓

Creates BookService

↓

Injects BookRepository

↓

Returns BookService
```

---

## 5. Setter Injection

Setter Injection is one of the three ways Spring performs Dependency Injection.

The dependency is provided through a setter method.

Example:

```java
public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
}
```

Spring calls this setter automatically and passes the required object.

This exercise demonstrates **Setter Injection**.

---

## 6. Spring Bean

A Spring Bean is a Java object created, configured, and managed by the Spring IoC Container.

Example:

```xml
<bean id="bookRepository"
      class="com.library.repository.BookRepository"/>
```

When the application starts, Spring creates this object automatically.

---

## 7. ApplicationContext

`ApplicationContext` is the central interface of the Spring Framework.

It is responsible for:

- Reading XML configuration
- Creating Beans
- Managing Bean lifecycle
- Injecting dependencies
- Returning Beans whenever requested

Example:

```java
ApplicationContext context =
new ClassPathXmlApplicationContext("applicationContext.xml");
```

This statement starts the Spring Container.

---

## 8. applicationContext.xml

The `applicationContext.xml` file contains the configuration of the Spring application.

In this exercise, it performs two tasks:

1. Creates the Beans.
2. Injects the `BookRepository` Bean into the `BookService` Bean.

Example:

```xml
<bean id="bookRepository"
      class="com.library.repository.BookRepository"/>

<bean id="bookService"
      class="com.library.service.BookService">

    <property name="bookRepository"
              ref="bookRepository"/>

</bean>
```

The `<property>` tag tells Spring to call the setter method and inject the required Bean.

---

# Real-World Analogy

Imagine a restaurant.

Without Dependency Injection:

The customer cooks the food, prepares the table, and serves themselves.

With Dependency Injection:

The restaurant prepares the food and serves it to the customer.

```
Restaurant
      │
Creates Food
      │
Serves Food
      │
Customer Eats
```

Similarly,

Without Spring:

The programmer creates every object manually.

With Spring:

Spring creates the objects and injects them wherever required.

---

# Learning Outcomes

After completing this exercise, you will be able to:

- Understand Dependency Injection.
- Explain the relationship between IoC and DI.
- Configure Setter Injection using XML.
- Create Spring Beans.
- Inject dependencies using the `<property>` element.
- Understand how Spring manages relationships between Beans.
- Build loosely coupled applications using the Spring Framework.

---

# Project Structure

The project follows the standard Maven directory structure recommended for Spring applications.

```
Exercise_2_Implementing_Dependency_Injection
│
├── pom.xml
├── README.md
├── .gitignore
│
├── src
│   ├── main
│   │   ├── java
│   │   │
│   │   │── com.library
│   │   │      │
│   │   │      ├── repository
│   │   │      │      └── BookRepository.java
│   │   │      │
│   │   │      ├── service
│   │   │      │      └── BookService.java
│   │   │      │
│   │   │      └── main
│   │   │             └── LibraryManagementApplication.java
│   │   │
│   │   └── resources
│   │          └── applicationContext.xml
│   │
│   └── test
│
└── Output
```

---

# Folder and File Description

| File / Folder | Description |
|---------------|-------------|
| **pom.xml** | Contains project information and Maven dependencies required to run the application. |
| **src/main/java** | Contains the Java source code. |
| **repository** | Contains the data access layer (`BookRepository`). |
| **service** | Contains the business logic layer (`BookService`). |
| **main** | Contains the main class that starts the application. |
| **resources** | Stores configuration files such as `applicationContext.xml`. |
| **applicationContext.xml** | Configures Spring Beans and Dependency Injection. |
| **Output** | Stores screenshots of the program output. |

---

# Implementation

This exercise is implemented in six simple steps.

---

# Step 1: Create a Maven Project

A Maven project named **LibraryManagement** is created.

Maven automatically creates the standard project structure and downloads the required libraries.

Project Name:

```
LibraryManagement
```

---

# Step 2: Add Spring Dependency

Open the **pom.xml** file and add the Spring Context dependency.

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.1.8</version>
</dependency>
```

## Why is this dependency required?

The `spring-context` module provides:

- Spring IoC Container
- Dependency Injection support
- ApplicationContext
- XML Bean Configuration

Without this dependency, Spring cannot create or manage Beans.

---

# Step 3: Create the Repository Class

Package:

```
com.library.repository
```

Class:

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

## Purpose of BookRepository

The Repository Layer is responsible for interacting with the database.

In a real Library Management System, this class would perform operations such as:

- Add Book
- Update Book
- Delete Book
- Search Book
- Fetch Book Details

For this exercise, the class simply prints a message to verify that Spring has successfully created the Bean.

---

# Step 4: Create the Service Class

Package:

```
com.library.service
```

Class:

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

# Understanding BookService.java

This class represents the **Service Layer**.

The Service Layer contains the business logic of the application.

Examples include:

- Validate book information
- Issue books
- Return books
- Calculate overdue fines
- Manage library operations

For this exercise, the Service Layer simply prints a message and calls the Repository method.

---

## Understanding the Dependency

Notice the following line:

```java
private BookRepository bookRepository;
```

This means:

**BookService depends on BookRepository.**

Instead of creating the object manually like this:

```java
BookRepository repository = new BookRepository();
```

Spring will create the object and inject it automatically.

---

## Understanding the Setter Method

```java
public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
}
```

This is called a **Setter Method**.

Spring calls this method automatically and passes the `BookRepository` Bean.

This process is called **Setter Dependency Injection**.

---

# Step 5: Configure Spring Beans

Inside

```
src/main/resources
```

create the file

```
applicationContext.xml
```

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="bookRepository"
          class="com.library.repository.BookRepository"/>

    <bean id="bookService"
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

When the application starts, Spring reads this XML file.

It performs two tasks:

1. Creates all Beans.
2. Injects dependencies between Beans.

---

## Understanding `<bean>`

Example:

```xml
<bean id="bookRepository"
      class="com.library.repository.BookRepository"/>
```

Meaning:

- Create an object of `BookRepository`.
- Store it inside the Spring IoC Container.
- Assign the Bean ID as `bookRepository`.

---

## Understanding `<property>`

```xml
<property
    name="bookRepository"
    ref="bookRepository"/>
```

### name

The value of `name` must match the property name in the Java class.

Since the property is

```java
private BookRepository bookRepository;
```

Spring automatically looks for

```java
setBookRepository(...)
```

and calls it.

---

### ref

`ref="bookRepository"`

means

Inject the Bean whose ID is **bookRepository**.

Spring performs something similar to:

```java
BookRepository repository = new BookRepository();

BookService service = new BookService();

service.setBookRepository(repository);
```

The programmer does not write this code.

Spring performs it automatically.

---

# Step 6: Create the Main Class

Package:

```
com.library.main
```

Class:

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

The main class is responsible for starting the Spring application.

It performs the following operations:

1. Loads the XML configuration.
2. Starts the Spring IoC Container.
3. Creates all configured Beans.
4. Injects dependencies.
5. Returns the required Bean.
6. Executes the program.

Notice that we only retrieve the `BookService` Bean.

We never create a `BookRepository` object manually.

Spring has already injected it into `BookService`.

This is the main advantage of Dependency Injection.

---

# Execution Flow

The following diagram shows how the application works internally.

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
Create BookRepository Bean
        │
        ▼
Create BookService Bean
        │
        ▼
Inject BookRepository into BookService
        │
        ▼
Store Both Beans in IoC Container
        │
        ▼
Application Requests BookService Bean
        │
        ▼
Spring Returns BookService Bean
        │
        ▼
displayService() is Executed
        │
        ▼
displayRepository() is Called
        │
        ▼
Output Displayed
```

---

# What Happens Internally?

When the application starts, the following operations are performed automatically by Spring.

### Step 1

The application executes the main method.

```java
ApplicationContext context =
new ClassPathXmlApplicationContext("applicationContext.xml");
```

Spring starts its IoC Container.

---

### Step 2

Spring reads the configuration file.

```
applicationContext.xml
```

It finds two Bean definitions.

```
BookRepository

BookService
```

---

### Step 3

Spring creates the BookRepository object.

Equivalent Java code:

```java
BookRepository repository = new BookRepository();
```

---

### Step 4

Spring creates the BookService object.

Equivalent Java code:

```java
BookService service = new BookService();
```

---

### Step 5

Spring notices the following configuration.

```xml
<property
    name="bookRepository"
    ref="bookRepository"/>
```

It understands that BookService requires BookRepository.

---

### Step 6

Spring automatically calls the setter method.

Equivalent Java code:

```java
service.setBookRepository(repository);
```

This is the actual Dependency Injection.

---

### Step 7

Spring stores both objects inside the IoC Container.

```
Spring IoC Container

│

├── BookRepository Bean

└── BookService Bean
        │
        └── contains BookRepository
```

---

### Step 8

The application requests the BookService Bean.

```java
BookService service =
context.getBean("bookService", BookService.class);
```

Spring returns the already created object.

---

### Step 9

The method is executed.

```java
service.displayService();
```

Internally,

```java
displayService()

↓

displayRepository()
```

---

# Expected Output

```
Book Service Bean Created Successfully.

Book Repository Bean Created Successfully.
```

---

# Expected Output

<img width="1918" height="1015" alt="Output" src="https://github.com/user-attachments/assets/76f9f8cd-cb1f-460d-bc27-d46ca28bb10d" />

---

# Exercise 1 vs Exercise 2

| Exercise 1 | Exercise 2 |
|------------|------------|
| Spring creates Beans | Spring creates Beans |
| Beans are independent | BookRepository is injected into BookService |
| Demonstrates IoC | Demonstrates IoC + Dependency Injection |
| No relationship between Beans | Beans are connected through Setter Injection |

---

# Advantages of Dependency Injection

Dependency Injection provides several advantages over manually creating objects.

### 1. Loose Coupling

Classes are not responsible for creating their own dependencies.

This makes the application flexible.

---

### 2. Better Maintainability

Changing one class does not require modifying multiple classes.

The configuration can be updated without changing business logic.

---

### 3. Easier Testing

Dependencies can be replaced with mock objects during unit testing.

This makes testing simple and reliable.

---

### 4. Better Reusability

The same object can be shared among multiple classes.

This avoids unnecessary object creation.

---

### 5. Improved Readability

The relationships between classes are clearly defined in the Spring configuration.

---

# Real-Life Example

Imagine a school.

Without Dependency Injection:

Every teacher buys their own:

- Marker
- Duster
- Chalk

This creates unnecessary work.

With Dependency Injection:

The school provides these resources to every classroom.

Teachers simply focus on teaching.

Similarly,

Spring provides the required objects to the classes.

The classes focus only on their business logic.

---

# Key Differences Between Manual Object Creation and Spring DI

## Manual Object Creation

```java
BookRepository repository = new BookRepository();

BookService service = new BookService();

service.setBookRepository(repository);
```

The programmer creates and manages every object.

---

## Using Spring Dependency Injection

```java
BookService service =
context.getBean("bookService", BookService.class);
```

Spring creates, configures, injects, and manages all required objects.

The programmer simply requests the Bean.

---

# Interview Questions

## 1. What is Dependency Injection?

**Answer:**

Dependency Injection is a design pattern in which the required dependencies of a class are provided by an external source instead of the class creating them itself.

In Spring, the IoC Container performs Dependency Injection.

---

## 2. What is the difference between IoC and DI?

**IoC**

- Spring creates and manages objects.

**DI**

- Spring injects the required objects into other objects.

IoC answers:

> Who creates the object?

DI answers:

> How does the object receive its dependency?

---

## 3. What is Setter Injection?

Setter Injection is a type of Dependency Injection where Spring provides dependencies through setter methods.

Example:

```java
public void setBookRepository(BookRepository repository)
```

---

## 4. Why is Setter Injection used?

Setter Injection is used when dependencies are optional or when they need to be changed after object creation.

---

## 5. What is a Spring Bean?

A Spring Bean is a Java object that is created, configured, and managed by the Spring IoC Container.

---

## 6. What is ApplicationContext?

ApplicationContext is the central interface of the Spring Framework responsible for:

- Loading configuration
- Creating Beans
- Managing Bean lifecycle
- Performing Dependency Injection

---

## 7. What is the purpose of applicationContext.xml?

It is the XML configuration file that tells Spring:

- Which Beans to create.
- How Beans are connected.
- Which dependencies should be injected.

---

## 8. What does the `<property>` tag do?

The `<property>` tag tells Spring to call a setter method and inject the specified Bean.

Example:

```xml
<property name="bookRepository"
          ref="bookRepository"/>
```

---

# Key Learnings

After completing this exercise, you have learned:

- Spring Dependency Injection
- Setter Injection
- Spring Bean Configuration
- XML-based Dependency Injection
- ApplicationContext
- IoC Container
- Bean Relationships
- Bean Wiring
- Loose Coupling
- Spring Bean Lifecycle (Basic Understanding)

---

# Conclusion

This exercise demonstrates how Spring Framework performs **Dependency Injection** using **Setter Injection** and **XML Configuration**.

Instead of creating dependent objects manually, Spring creates and injects them automatically through the IoC Container. This results in applications that are **loosely coupled**, **easy to maintain**, **easy to test**, and **more scalable**.

Understanding Dependency Injection is one of the most important concepts in the Spring Framework because it forms the foundation for advanced technologies such as **Spring Boot**, **Spring MVC**, **Spring Data JPA**, **Spring Security**, and **Microservices**.

This exercise builds upon the concepts learned in Exercise 1 and prepares you for more advanced dependency injection techniques, such as **Constructor Injection**, **Annotation-Based Configuration**, and **Spring Boot Dependency Injection**.

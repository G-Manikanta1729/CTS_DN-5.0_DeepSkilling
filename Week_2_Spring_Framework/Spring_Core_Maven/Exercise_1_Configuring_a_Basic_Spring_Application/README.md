# Exercise 1: Configuring a Basic Spring Application

## Week 2 - Spring Framework

### Module
**Spring Core and Maven**

---

## Objective

The objective of this exercise is to understand the fundamentals of the **Spring Framework** by creating a simple Spring Core application using **Maven** and **XML configuration**.

This exercise introduces the basic concepts of Spring such as:

- Spring Framework
- Maven
- Spring Bean
- Inversion of Control (IoC)
- Dependency Injection (DI)
- ApplicationContext
- XML-Based Bean Configuration

---

# Scenario

A company is developing a **Library Management System**.

The application contains different layers such as:

- Service Layer
- Repository Layer

Instead of creating Java objects manually using the `new` keyword, the company wants Spring Framework to create and manage those objects.

To achieve this, Spring's IoC Container is configured using an XML file called **applicationContext.xml**.

When the application starts, Spring creates all the required objects (Beans) and stores them inside its container.

The application simply requests the required objects whenever they are needed.

---

# Technologies Used

- Java 21
- Spring Core
- Maven
- XML
- IntelliJ IDEA

---

# Prerequisites

Before performing this exercise, you should know:

- Java Classes and Objects
- Packages
- Basic XML
- Basic Maven

---

# What is Spring Framework?

Spring Framework is an **open-source Java framework** used for developing enterprise applications.

It reduces the complexity of Java development by managing object creation, dependencies, configuration, transactions, security, and many other common tasks.

Instead of writing repetitive code, developers can focus on implementing the business logic while Spring handles the infrastructure.

### Example

Without Spring:

```java
BookService service = new BookService();
```

The programmer creates the object.

With Spring:

```xml
<bean id="bookService"
      class="com.library.service.BookService"/>
```

Spring creates the object automatically.

---

# What is Maven?

Maven is a **build automation and dependency management tool**.

It helps developers:

- Download required libraries automatically
- Manage project dependencies
- Compile Java projects
- Package applications
- Run tests

All dependencies are declared inside the **pom.xml** file.

Example:

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.1.8</version>
</dependency>
```

Maven downloads the required Spring libraries automatically.

---

# What is a Spring Bean?

A **Spring Bean** is a Java object that is created, configured, and managed by the Spring IoC Container.

Normally:

```java
BookRepository repository = new BookRepository();
```

With Spring:

```xml
<bean id="bookRepository"
      class="com.library.repository.BookRepository"/>
```

Spring creates the object and stores it inside the container.

---

# What is Inversion of Control (IoC)?

**Definition**

Inversion of Control (IoC) is a principle in which the responsibility of creating and managing objects is transferred from the programmer to the Spring Framework.

### Without IoC

```java
BookService service = new BookService();
```

The programmer creates the object.

### With IoC

Spring creates the object.

The programmer simply requests it.

---

# What is Dependency Injection (DI)?

Dependency Injection (DI) is a technique used by Spring to provide one object to another object instead of letting the object create its own dependencies.

### Example

Without DI

```java
Engine engine = new Engine();
```

With DI

Spring creates the `Engine` object and injects it wherever required.

This makes applications:

- Loosely Coupled
- Easy to Test
- Easy to Maintain

---

# What is ApplicationContext?

`ApplicationContext` is the main interface of the Spring IoC Container.

It is responsible for:

- Reading the XML configuration
- Creating Beans
- Managing Bean lifecycle
- Returning Beans whenever requested

Example:

```java
ApplicationContext context =
new ClassPathXmlApplicationContext("applicationContext.xml");
```

This starts the Spring Container.

---

# What is applicationContext.xml?

`applicationContext.xml` is the configuration file of a Spring application.

It contains all the Bean definitions.

Example:

```xml
<bean id="bookService"
      class="com.library.service.BookService"/>

<bean id="bookRepository"
      class="com.library.repository.BookRepository"/>
```

When the application starts, Spring reads this file and creates all the configured Beans.

---

# Real-World Analogy

Imagine staying in a hotel.

Without a hotel, you have to buy your own:

- Bed
- Chair
- AC
- TV

With a hotel, everything is already available.

You simply use the facilities.

Similarly,

Without Spring:

The developer creates every object manually.

With Spring:

Spring creates and manages all objects.

The developer simply requests the required object.

---

# Learning Outcomes

After completing this exercise, you will be able to:

- Understand the basics of Spring Framework.
- Create a Maven-based Spring project.
- Configure Spring using XML.
- Define Spring Beans.
- Load the Spring ApplicationContext.
- Retrieve Beans from the Spring Container.
- Execute a simple Spring Core application.

---

# Executed Output

<img width="1732" height="958" alt="Output" src="https://github.com/user-attachments/assets/f5c8d793-a47b-4b50-9cee-e0fa6f88555b" />

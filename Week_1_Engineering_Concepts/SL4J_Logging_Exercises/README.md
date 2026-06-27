# SLF4J Logging Exercises

## Overview

This folder contains hands-on exercises demonstrating the fundamentals of the **SLF4J (Simple Logging Facade for Java) Logging Framework**. Logging is one of the most important practices in software development because it helps developers monitor application behavior, identify issues, and debug applications efficiently.

These exercises are part of the **CTS DN 5.0 Deep Skilling Program** and introduce the concepts of logging, warning messages, error messages, and logging frameworks using **SLF4J** and **Logback**.

---

# What is Logging?

A **log** is a record of events that occur while an application is running.

Instead of simply displaying messages on the console using `System.out.println()`, professional applications record important information such as application startup, user actions, warnings, and errors using a logging framework.

Example log:

```text
10:15:02 INFO  Application Started
10:15:10 INFO  User Login Successful
10:15:20 WARN  Low Disk Space
10:15:30 ERROR Database Connection Failed
```

These records help developers understand exactly what happened inside an application.

---

# Why is Logging Required?

Imagine a banking application.

A customer reports:

> "The application crashed while transferring money."

Without logging, developers would not know:

* Which user was performing the transaction.
* Whether the database was connected.
* Whether the payment gateway responded.
* At which step the application failed.

With logging, developers can simply inspect the log file and identify the exact cause of the problem.

Logging helps in:

* Debugging applications
* Monitoring application health
* Tracking user activities
* Identifying runtime errors
* Troubleshooting production issues

---

# What is SLF4J?

**SLF4J** stands for:

> **Simple Logging Facade for Java**

SLF4J is not a logging framework by itself.

Instead, it provides a **common interface** for different logging frameworks such as:

* Logback
* Log4j
* java.util.logging

This allows developers to write logging statements using a single API while changing the underlying logging implementation without modifying application code.

---

# Why is it Called a Facade?

A **Facade** acts as a common interface between your application and the actual logging framework.

Instead of directly communicating with Logback or Log4j, your application communicates with SLF4J.

Execution flow:

```text
Java Application
        │
        ▼
      SLF4J
        │
        ▼
     Logback
        │
        ▼
 Console / Log File
```

This design provides flexibility because the logging implementation can be changed without changing the application code.

---

# Why Not Use System.out.println()?

Although `System.out.println()` is useful for learning Java, it has several limitations.

| System.out.println()                     | SLF4J Logging                      |
| ---------------------------------------- | ---------------------------------- |
| Prints plain text                        | Produces structured log messages   |
| No log levels                            | Supports multiple log levels       |
| Difficult to manage                      | Easy to filter and search          |
| Console output only                      | Console and file logging           |
| Not suitable for enterprise applications | Widely used in enterprise software |

Because of these advantages, modern Java applications use logging frameworks instead of `System.out.println()`.

---

# Log Levels

SLF4J supports different logging levels based on the importance of the message.

## INFO

Used for normal application events.

Examples:

* Application started
* User logged in
* Order placed successfully

Example:

```java
logger.info("Application Started");
```

---

## WARN

Used when something unusual occurs but the application can continue.

Examples:

* Low disk space
* Password expiring soon
* Slow API response

Example:

```java
logger.warn("Low Disk Space");
```

---

## ERROR

Used when an operation fails or an unexpected problem occurs.

Examples:

* Database connection failed
* File not found
* Payment transaction failed

Example:

```java
logger.error("Database Connection Failed");
```

---

# Technologies Used

* Java 21 (LTS)
* Maven
* SLF4J
* Logback
* IntelliJ IDEA

---

# Folder Structure

```text
SL4J_Logging_Exercises
│
├── Exercise_1_Logging_Error_Messages_and_Warning_Levels
│
├── Output_Exercise_1_Logging_Error_Messages_and_Warning_Levels.png
│
└── README.md
```

---

# Exercise Included

## Exercise 1 – Logging Error Messages and Warning Levels

### Objective

Demonstrate how to use SLF4J for logging warning and error messages.

### Concepts Covered

* Creating a Logger object
* Logging warning messages
* Logging error messages
* Integrating SLF4J with Logback
* Configuring logging dependencies using Maven

---

# Project Workflow

```
Java Application
        │
        ▼
Logger Object
        │
        ▼
SLF4J API
        │
        ▼
Logback Framework
        │
        ▼
Console Output
```

---

# Learning Outcomes

After completing these exercises, you will be able to:

* Understand the purpose of application logging.
* Differentiate between logging and console printing.
* Understand the architecture of SLF4J.
* Configure SLF4J using Maven.
* Use different logging levels.
* Log warning and error messages.
* Understand how enterprise Java applications maintain logs.

---

# Advantages of Using SLF4J

* Provides a common logging interface.
* Works with multiple logging frameworks.
* Produces structured log messages.
* Improves debugging and maintenance.
* Suitable for enterprise-scale applications.
* Easy integration with Spring Boot and other Java frameworks.

---

# Expected Output

The application prints log messages similar to:

```text
21:15:30.123 [main] ERROR LoggingExample -- This is an error message

21:15:30.125 [main] WARN LoggingExample -- This is a warning message
```

The screenshot of the successful execution is included in this folder.

---

# Conclusion

SLF4J provides a simple and flexible way to implement logging in Java applications. Instead of relying on `System.out.println()`, developers use structured logging with different log levels to monitor application behavior, identify issues, and simplify debugging. By combining SLF4J with Logback, enterprise applications can generate consistent and maintainable logs while remaining independent of the underlying logging implementation.

---

# Author

**Grandhe Manikanta Sri Sai Kiran**

CTS DN 5.0 Deep Skilling Program

Week 1 – Engineering Concepts

SLF4J Logging Exercises

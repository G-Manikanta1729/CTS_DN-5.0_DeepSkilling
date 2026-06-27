# Exercise 1: Logging Error Messages and Warning Levels

## Objective

The objective of this exercise is to understand how to use the **SLF4J (Simple Logging Facade for Java)** logging framework to generate **warning** and **error** messages in a Java application.

This exercise demonstrates how professional Java applications record important events instead of using `System.out.println()` statements. It also introduces the concept of logging frameworks and different logging levels.

---

# Scenario

In enterprise applications, developers need to monitor application behavior and identify runtime issues. Instead of printing plain messages to the console, applications use logging frameworks to record information with different severity levels.

This exercise demonstrates:

* Configuring SLF4J using Maven
* Using Logback as the logging implementation
* Logging warning messages
* Logging error messages

---

# Problem Statement

Develop a Java application that demonstrates logging using **SLF4J**.

Requirements:

1. Configure the project with SLF4J and Logback.
2. Create a logger object.
3. Log an error message.
4. Log a warning message.
5. Execute the application and observe the generated logs.

---

# What is Logging?

Logging is the process of recording important events that occur while an application is running.

Examples of logged events include:

* Application startup
* User login
* Database connection
* API requests
* Warning messages
* Error messages
* Application shutdown

Instead of simply displaying text on the console, logging frameworks generate structured log messages that help developers monitor and debug applications.

Example:

```text
10:15:02 INFO  Application Started
10:15:10 INFO  User Login Successful
10:15:20 WARN  Low Disk Space
10:15:30 ERROR Database Connection Failed
```

---

# Why is Logging Required?

Suppose a banking application crashes while processing a transaction.

Without logging, developers cannot determine:

* Which operation failed
* Whether the database was connected
* Whether the server responded
* Which user was performing the transaction

With logging, developers can identify the exact cause of the failure by examining the generated log messages.

Logging provides:

* Easier debugging
* Faster issue identification
* Better application monitoring
* Runtime diagnostics
* Production troubleshooting

---

# What is SLF4J?

**SLF4J** stands for:

> **Simple Logging Facade for Java**

SLF4J is not a logging framework itself.

It is a common logging interface that allows applications to work with different logging implementations without changing the application code.

Common logging implementations include:

* Logback
* Log4j
* java.util.logging

---

# Why is it Called a Facade?

A **Facade** acts as an intermediate layer between the application and the logging framework.

Instead of directly communicating with Logback, the application communicates with SLF4J.

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

Because of this design, developers can replace the underlying logging framework without modifying application code.

---

# Technologies Used

* Java 21 (LTS)
* Maven
* SLF4J API
* Logback Classic
* IntelliJ IDEA

---

# Project Structure

```text
Exercise_1_Logging_Error_Messages_and_Warning_Levels
│
├── src
│   └── main
│       └── java
│           └── LoggingExample.java
│
├── pom.xml
├── .gitignore
└── README.md
```

---

# Dependencies

The project uses the following Maven dependencies:

## SLF4J API

Provides the standard logging interface used by the application.

## Logback Classic

Provides the actual implementation responsible for displaying log messages.

---

# Project Components

## LoggingExample.java

This class demonstrates basic logging using SLF4J.

Responsibilities:

* Create a Logger object.
* Log an error message.
* Log a warning message.

---

# Implementation Workflow

## Step 1

Create a Logger object.

```java
private static final Logger logger =
        LoggerFactory.getLogger(LoggingExample.class);
```

The Logger is responsible for generating log messages.

---

## Step 2

Log an error message.

```java
logger.error("This is an error message");
```

The ERROR level indicates that a serious problem has occurred.

Examples:

* Database connection failed
* File not found
* Payment failed
* Server unavailable

---

## Step 3

Log a warning message.

```java
logger.warn("This is a warning message");
```

The WARN level indicates that something unusual happened, but the application can continue executing.

Examples:

* Low disk space
* Password expiring soon
* Slow API response

---

# Execution Flow

```text
Application Starts
        │
        ▼
Logger Object Created
        │
        ▼
logger.error(...)
        │
        ▼
SLF4J API
        │
        ▼
Logback
        │
        ▼
Console Output
        │
        ▼
logger.warn(...)
        │
        ▼
SLF4J API
        │
        ▼
Logback
        │
        ▼
Console Output
```

---

# Log Levels Used

## WARN

Used when the application encounters a non-critical issue.

Characteristics:

* Application continues running.
* Indicates something requires attention.
* Used for potential future problems.

Example:

```java
logger.warn("Low Disk Space");
```

---

## ERROR

Used when an operation fails.

Characteristics:

* Indicates a serious problem.
* Requires investigation.
* May affect application functionality.

Example:

```java
logger.error("Database Connection Failed");
```

---

# Difference Between WARN and ERROR

| WARN                          | ERROR                       |
| ----------------------------- | --------------------------- |
| Indicates a potential problem | Indicates an actual failure |
| Application continues running | Operation has failed        |
| Medium severity               | High severity               |
| Used for caution              | Used for critical issues    |

---

# Advantages of SLF4J Logging

* Standard logging API
* Easy integration with Java applications
* Supports multiple logging implementations
* Structured log messages
* Better debugging support
* Suitable for enterprise applications
* Can write logs to console or files

---

# Expected Output

The application generates log messages similar to:

```text
21:15:30.123 [main] ERROR LoggingExample -- This is an error message

21:15:30.125 [main] WARN LoggingExample -- This is a warning message
```

The exact timestamp may differ depending on the execution time.

---

# Executed Output

<img width="1732" height="957" alt="Output_Exercise_1_Logging_Error_Messages_and_Warning_Levels" src="https://github.com/user-attachments/assets/bffd4922-7fef-4b0d-a3dd-2241d27a8e4d" />

---

# Learning Outcomes

After completing this exercise, you will be able to:

* Understand the purpose of logging.
* Understand the architecture of SLF4J.
* Configure SLF4J using Maven.
* Create Logger objects.
* Log warning messages.
* Log error messages.
* Understand the difference between WARN and ERROR log levels.
* Understand why enterprise applications use logging frameworks instead of `System.out.println()`.

---

# Conclusion

This exercise demonstrates the fundamentals of application logging using SLF4J and Logback. By replacing `System.out.println()` with structured logging, developers can record important application events, identify runtime issues, and simplify debugging. The exercise also introduces the WARN and ERROR logging levels, which are commonly used in enterprise Java applications to monitor application health and diagnose failures efficiently.

---

# Author

**Grandhe Manikanta Sri Sai Kiran**

CTS DN 5.0 Deep Skilling Program

Week 1 – Engineering Concepts

SLF4J Logging Exercises

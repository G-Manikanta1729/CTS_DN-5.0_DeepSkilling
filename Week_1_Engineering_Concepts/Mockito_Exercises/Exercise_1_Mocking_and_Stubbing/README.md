# Exercise 1: Mocking and Stubbing

## Objective

The objective of this exercise is to understand the basic concepts of **Mockito**, including **Mocking** and **Stubbing**, while performing unit testing with **JUnit 5**.

In this exercise, a service class depends on an external API. Instead of calling the real API during testing, Mockito is used to create a fake object (mock) and define its behavior (stub), allowing the service to be tested independently.

---

# Scenario

A service named **MyService** fetches data from an **ExternalApi**.

In a real-world application, the external API could represent:

* REST APIs
* Web Services
* Databases
* Payment Gateways
* Email Services

While unit testing, we should not depend on these external systems because they may:

* Be unavailable
* Be slow
* Require internet connectivity
* Return unpredictable data
* Increase testing time

Mockito solves this problem by replacing the real dependency with a mock object.

---

# Problem Statement

Test the `MyService` class without calling the real `ExternalApi`.

Requirements:

1. Create a mock object for `ExternalApi`.
2. Stub the `getData()` method.
3. Verify that `MyService` returns the mocked data.

---

# Technologies Used

* Java 21 (LTS)
* Maven
* JUnit 5
* Mockito Core
* IntelliJ IDEA

---

# Project Structure

```
Exercise_1_Mocking_and_Stubbing
│
├── src
│   │
│   ├── main
│   │   └── java
│   │       ├── ExternalApi.java
│   │       └── MyService.java
│   │
│   └── test
│       └── java
│           └── MyServiceTest.java
│
├── pom.xml
├── .gitignore
└── README.md
```

---

# Project Components

## 1. ExternalApi.java

Represents an external dependency.

Example:

```java
public class ExternalApi {

    public String getData() {
        return "Real Data";
    }

}
```

Normally, this method would connect to an external system.

---

## 2. MyService.java

Business logic class.

```java
public class MyService {

    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

}
```

Responsibilities:

* Receives the dependency through constructor injection.
* Calls `getData()`.
* Returns the received result.

---

## 3. MyServiceTest.java

Contains the JUnit test using Mockito.

Responsibilities:

* Create a mock object.
* Stub method behavior.
* Call the service.
* Verify the returned value.

---

# Implementation Workflow

## Step 1

Create a mock object.

```java
ExternalApi mockApi = mock(ExternalApi.class);
```

Mockito creates a fake version of `ExternalApi`.

No real object is created.

---

## Step 2

Stub the method.

```java
when(mockApi.getData()).thenReturn("Mock Data");
```

Meaning:

Whenever

```java
getData()
```

is called,

return

```
Mock Data
```

instead of

```
Real Data
```

---

## Step 3

Inject the mocked dependency.

```java
MyService service = new MyService(mockApi);
```

Now the service communicates with the mocked API instead of the real API.

---

## Step 4

Call the business method.

```java
String result = service.fetchData();
```

Execution flow:

```
MyService
      ↓
Mock ExternalApi
      ↓
Returns "Mock Data"
```

---

## Step 5

Verify the output.

```java
assertEquals("Mock Data", result);
```

JUnit checks whether the expected and actual values are equal.

If equal,

```
Test Passed
```

Otherwise,

```
Test Failed
```

---

# Complete Execution Flow

```
JUnit Test
      │
      ▼
Create Mock Object
      │
      ▼
Stub getData()
      │
      ▼
Create MyService
      │
      ▼
Call fetchData()
      │
      ▼
Mock getData()
      │
      ▼
Returns "Mock Data"
      │
      ▼
assertEquals()
      │
      ▼
Test Passed
```

---

# Expected Output

```
Tests run: 1

Tests passed: 1

BUILD SUCCESS
```

---

# Executed Output

<img width="1732" height="957" alt="Exercise_1_Mocking_and_Stubbing" src="https://github.com/user-attachments/assets/74cbb08c-a169-4ca1-898d-ab8c8f88e7fc" />

---

# Key Mockito Methods Used

## mock()

Creates a fake object.

```java
mock(ExternalApi.class);
```

---

## when()

Specifies which mocked method is being configured.

```java
when(mockApi.getData())
```

---

## thenReturn()

Defines the value that should be returned.

```java
thenReturn("Mock Data");
```

---

## assertEquals()

Checks whether expected and actual values are equal.

```java
assertEquals(expected, actual);
```

---

# Why Mocking is Required

Without Mockito:

```
JUnit Test
      ↓
MyService
      ↓
Real External API
      ↓
Internet
      ↓
Server
      ↓
Database
```

Problems:

* Slow execution
* Internet dependency
* Server dependency
* Database dependency
* Unstable tests

---

With Mockito:

```
JUnit Test
      ↓
MyService
      ↓
Mock ExternalApi
      ↓
Returns Fake Data
```

Benefits:

* Fast testing
* No internet required
* No database required
* No API dependency
* Predictable results
* Independent unit tests

---

# Learning Outcomes

After completing this exercise, you will be able to:

* Understand the purpose of Mockito.
* Create mock objects using `mock()`.
* Stub methods using `when()` and `thenReturn()`.
* Test business logic independently of external systems.
* Perform isolated unit testing.
* Integrate Mockito with JUnit 5 and Maven.

---

# Conclusion

This exercise demonstrates how Mockito helps isolate a class under test by replacing real dependencies with mock objects. By using stubbing, predefined responses can be returned without invoking actual external systems, resulting in faster, reliable, and independent unit tests. This is a fundamental concept in modern Java unit testing and serves as the foundation for more advanced Mockito features such as interaction verification, argument matching, spying, and dependency injection.

---

# Author

**Grandhe Manikanta Sri Sai Kiran**

CTS DN 5.0 Deep Skilling Program

Week 1 – Engineering Concepts

Mockito Exercises

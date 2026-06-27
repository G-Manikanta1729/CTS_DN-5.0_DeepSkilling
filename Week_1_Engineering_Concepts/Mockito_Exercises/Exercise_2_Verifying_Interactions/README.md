# Exercise 2: Verifying Interactions

## Objective

The objective of this exercise is to understand how to **verify interactions** between objects using **Mockito**.

In this exercise, a mock object is created for an external dependency, and Mockito's `verify()` method is used to confirm that a specific method is invoked during the execution of the business logic.

Unlike stubbing, which defines what a mocked method should return, verification ensures that expected interactions actually occurred.

---

# Scenario

A service class (`MyService`) depends on an external API (`ExternalApi`) to fetch data.

Instead of checking the returned value, this exercise focuses on verifying that the service correctly invokes the `getData()` method of the external API.

This type of testing is commonly used when the correctness of an operation depends on whether another object was called.

---

# Problem Statement

Verify that the `fetchData()` method of `MyService` invokes the `getData()` method of `ExternalApi`.

Requirements:

1. Create a mock object for the external API.
2. Inject the mock into the service.
3. Execute the service method.
4. Verify that the expected method was called.

---

# Technologies Used

* Java 21 (LTS)
* Maven
* JUnit 5
* Mockito Core
* IntelliJ IDEA

---

# Project Structure

```text
Exercise_2_Verifying_Interactions
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

Represents the external dependency.

```java
public class ExternalApi {

    public String getData() {
        return "Real Data";
    }

}
```

In a real application, this class could communicate with:

* REST APIs
* Databases
* Cloud Services
* Third-party applications

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
* Returns the obtained result.

---

## 3. MyServiceTest.java

JUnit test class using Mockito.

Responsibilities:

* Create the mock object.
* Inject the mock dependency.
* Execute the business method.
* Verify interaction with the dependency.

---

# Implementation Workflow

## Step 1

Create the mock object.

```java
ExternalApi mockApi = mock(ExternalApi.class);
```

Mockito creates a fake implementation of the external API.

No real API is contacted.

---

## Step 2

Inject the mocked dependency.

```java
MyService service = new MyService(mockApi);
```

The service now communicates with the mock object.

---

## Step 3

Execute the service method.

```java
service.fetchData();
```

Execution flow:

```text
MyService
      ↓
Mock ExternalApi
      ↓
getData()
```

---

## Step 4

Verify the interaction.

```java
verify(mockApi).getData();
```

Mockito checks whether:

```java
getData()
```

was called during execution.

If the method was invoked,

```text
Verification Successful
```

Otherwise,

```text
Test Failed
```

---

# Complete Execution Flow

```text
JUnit Test
      │
      ▼
Create Mock Object
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
Mockito Records Interaction
      │
      ▼
verify(mockApi).getData()
      │
      ▼
Verification Successful
      │
      ▼
Test Passed
```

---

# Expected Output

```text
Tests run: 1

Tests passed: 1

BUILD SUCCESS
```

---

# Executed Output

<img width="1735" height="956" alt="Exercise_2_Verifying_Interactions" src="https://github.com/user-attachments/assets/7c687e33-f0ac-4d61-93bb-57c73bc0c7ff" />

---

# Key Mockito Methods Used

## mock()

Creates a fake implementation of a class.

```java
ExternalApi mockApi = mock(ExternalApi.class);
```

---

## verify()

Checks whether a mocked method was actually invoked.

```java
verify(mockApi).getData();
```

This confirms that the interaction occurred during execution.

---

# Why Verification is Required

In many applications, the correctness of a feature depends on whether another object was called.

Examples include:

* Sending an email after user registration.
* Saving records to a database.
* Calling a payment gateway.
* Writing logs.
* Triggering notifications.

Verification ensures these interactions happen as expected.

---

# Advantages of Mockito Verification

* Ensures expected methods are invoked.
* Detects missing interactions.
* Helps validate business workflows.
* Improves confidence in unit tests.
* Keeps tests independent of external systems.

---

# Difference Between Stubbing and Verification

| Stubbing                             | Verification                                 |
| ------------------------------------ | -------------------------------------------- |
| Defines how a mocked method behaves. | Confirms whether a mocked method was called. |
| Uses `when(...).thenReturn(...)`.    | Uses `verify(...)`.                          |
| Focuses on returned values.          | Focuses on interactions.                     |

---

# Learning Outcomes

After completing this exercise, you will be able to:

* Create mock objects using Mockito.
* Inject mocked dependencies into service classes.
* Execute business methods using mocked objects.
* Verify interactions using `verify()`.
* Understand interaction-based unit testing.
* Use Mockito with JUnit 5 and Maven effectively.

---

# Conclusion

This exercise demonstrates how Mockito's verification feature can be used to ensure that expected interactions occur during program execution. Instead of validating returned values, verification confirms that specific methods are invoked on mocked dependencies. This technique is widely used in enterprise applications to test interactions with services such as databases, APIs, messaging systems, and notification services while keeping unit tests fast, reliable, and independent of external resources.

---

# Author

**Grandhe Manikanta Sri Sai Kiran**

CTS DN 5.0 Deep Skilling Program

Week 1 – Engineering Concepts

Mockito Exercises

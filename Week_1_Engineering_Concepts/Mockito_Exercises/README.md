# Mockito Exercises

## Overview

This folder contains hands-on exercises demonstrating the fundamentals of **Mockito**, one of the most widely used mocking frameworks for Java unit testing. Mockito is commonly used along with **JUnit 5** to isolate classes under test by creating fake (mock) objects for their dependencies.

These exercises are part of the **CTS DN 5.0 Deep Skilling Program** and focus on understanding how to create mock objects, stub method behavior, and verify interactions between classes.

---

# Objectives

The objectives of these exercises are:

- Understand the purpose of Mockito.
- Learn how to create mock objects.
- Learn how to stub methods using predefined return values.
- Learn how to verify method interactions.
- Perform isolated unit testing without depending on external systems.
- Gain practical experience using Mockito with JUnit 5.

---

# Technologies Used

- Java 21 (LTS)
- JUnit 5
- Mockito Core
- Maven
- IntelliJ IDEA

---

# Folder Structure

```
Mockito_Exercises
│
├── Exercise_1_Mocking_and_Stubbing
│
├── Exercise_2_Verifying_Interactions
│
├── Outputs
│   ├── Exercise_1_Mocking_and_Stubbing.png
│   └── Exercise_2_Verifying_Interactions.png
│
└── README.md
```

---

# Exercises Included

## Exercise 1 – Mocking and Stubbing

### Scenario

Test a service that depends on an external API without actually calling the real API.

### Concepts Covered

- Creating mock objects
- Stubbing methods
- Using `when()`
- Using `thenReturn()`
- Unit testing with fake dependencies

### Files

- ExternalApi.java
- MyService.java
- MyServiceTest.java

---

## Exercise 2 – Verifying Interactions

### Scenario

Verify that a specific method was invoked during execution.

### Concepts Covered

- Creating mock objects
- Calling service methods
- Using `verify()`
- Interaction testing
- Ensuring expected method invocation

### Files

- ExternalApi.java
- MyService.java
- MyServiceTest.java

---

# Key Mockito Concepts Learned

## Mock Object

A mock object is a fake implementation of a real object created by Mockito. It allows testing without calling external systems such as APIs, databases, or web services.

Example:

```java
ExternalApi mockApi = mock(ExternalApi.class);
```

---

## Stubbing

Stubbing defines how a mocked method should behave when it is called.

Example:

```java
when(mockApi.getData()).thenReturn("Mock Data");
```

Instead of executing the real method, Mockito returns the predefined value.

---

## Verify

Verify checks whether a particular method was actually called during test execution.

Example:

```java
verify(mockApi).getData();
```

This confirms that the service invoked `getData()` exactly once.

---

# How to Run

1. Open the project in IntelliJ IDEA.
2. Allow Maven to download all dependencies.
3. Navigate to:

```
src/test/java
```

4. Right-click the test class.
5. Select:

```
Run MyServiceTest
```

6. Verify that all tests pass successfully.

---

# Expected Output

All test cases should execute successfully.

```
Tests run: 1
Tests passed: 1
```

The `Outputs` folder contains screenshots of successful execution.

---

# Learning Outcomes

After completing these exercises, you will be able to:

- Understand why mocking is required in unit testing.
- Create mock objects using Mockito.
- Stub methods with predefined return values.
- Verify interactions between classes.
- Write isolated and reliable unit tests.
- Use Mockito together with JUnit 5 in Maven projects.

---

# References

- Mockito Documentation
- JUnit 5 User Guide
- Maven Documentation

---

# Author

**Grandhe Manikanta Sri Sai Kiran**

CTS DN 5.0 Deep Skilling Program

Week 1 – Engineering Concepts

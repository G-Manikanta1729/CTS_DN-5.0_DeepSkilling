# JUnit Basic Testing Exercises

## Overview

This folder contains the implementation of basic JUnit 5 testing exercises completed as part of the **CTS DN 5.0 Deep Skilling Program**.

The objective of these exercises is to understand the fundamentals of unit testing using **JUnit 5**, including project setup, writing test cases, using assertions, organizing tests with the Arrange–Act–Assert (AAA) pattern, and managing test fixtures using setup and teardown methods.

---

## Learning Objectives

After completing these exercises, you will be able to:

* Set up a Maven-based Java project for JUnit testing.
* Configure JUnit 5 dependencies using Maven.
* Write and execute unit tests.
* Use different JUnit assertion methods.
* Understand and implement the Arrange–Act–Assert (AAA) testing pattern.
* Use test fixtures with `@BeforeEach` and `@AfterEach`.
* Execute and validate test cases using IntelliJ IDEA.

---

## Technologies Used

* Java 25
* JUnit 5
* Apache Maven
* IntelliJ IDEA Community Edition
* Git & GitHub

---

## Folder Structure

```
JUnit_Basic_Testing_Exercises
│
├── Exercise_1_Setting_Up_JUnit
│
├── Exercise_3_Assertions_in_JUnit
│
├── Exercise_4_AAA_Pattern_Test_Fixtures_Setup_Teardown
│
├── Outputs
│   ├── Exercise_1_Output.png
│   ├── Exercise_3_Output.png
│   └── Exercise_4_Output.png
│
└── README.md
```

---

# Exercise 1 – Setting Up JUnit

## Objective

Configure a Java Maven project to support JUnit 5 testing.

### Tasks Performed

* Created a Maven Java project.
* Configured the project using `pom.xml`.
* Added the JUnit 5 dependency.
* Imported Maven dependencies.
* Created the first JUnit test class.
* Successfully executed the test.

### Concepts Covered

* Maven Project Structure
* JUnit Dependency Configuration
* Test Class Creation
* Running Unit Tests

---

# Exercise 3 – Assertions in JUnit

## Objective

Learn and use different assertion methods provided by JUnit 5.

### Assertion Methods Implemented

* `assertEquals()`
* `assertTrue()`
* `assertFalse()`
* `assertNull()`
* `assertNotNull()`

### Concepts Covered

* Expected vs Actual Results
* Boolean Assertions
* Null Assertions
* Validation of Test Outcomes

---

# Exercise 4 – Arrange–Act–Assert (AAA) Pattern

## Objective

Organize unit tests using the Arrange–Act–Assert (AAA) pattern and understand the use of test fixtures.

### Tasks Performed

* Created a `Calculator` class.
* Implemented unit tests using the AAA pattern.
* Used `@BeforeEach` for setup.
* Used `@AfterEach` for teardown.
* Successfully executed the test cases.

### Concepts Covered

* Arrange–Act–Assert (AAA)
* Test Fixtures
* Setup Methods
* Teardown Methods
* Reusable Test Objects

---

# Maven Project Structure

```
Exercise
│
├── pom.xml
│
└── src
    ├── main
    │   └── java
    │
    └── test
        └── java
```

---

# Outputs

The `Outputs` folder contains execution screenshots for each exercise, demonstrating successful compilation and execution of the JUnit test cases.

---

# Skills Acquired

* Unit Testing Fundamentals
* Maven Project Configuration
* JUnit 5 Framework
* Assertions
* Test Lifecycle
* Test Fixtures
* Arrange–Act–Assert Pattern
* IntelliJ IDEA
* Git Version Control

---

# Conclusion

These exercises provide a strong foundation in JUnit 5 by covering project setup, assertion methods, test organization, and the JUnit test lifecycle. The concepts learned here serve as the basis for advanced testing topics such as Mockito, Test-Driven Development (TDD), integration testing, and Spring Boot testing.

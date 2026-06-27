# Exercise 4: Arrange–Act–Assert (AAA) Pattern, Test Fixtures, Setup and Teardown Methods in JUnit

## Objective

The objective of this exercise is to understand how to organize JUnit test cases using the **Arrange–Act–Assert (AAA) Pattern** and learn how to manage test initialization and cleanup using **test fixtures** with `@BeforeEach` and `@AfterEach` annotations.

This exercise demonstrates how to write clean, maintainable, and reusable unit tests by separating test preparation, execution, and verification into distinct phases.

---

# Problem Statement

**Scenario:**

You need to organize your JUnit test cases using the Arrange–Act–Assert (AAA) pattern and use setup and teardown methods to prepare and clean up the test environment before and after every test execution.

### Steps

1. Configure a Maven-based Java project with JUnit 5.
2. Create a simple Java class to test.
3. Write JUnit test cases using the AAA Pattern.
4. Use `@BeforeEach` for setup.
5. Use `@AfterEach` for teardown.
6. Execute the test successfully.

---

# Project Structure

```text
Exercise_4_AAA_Pattern_Test_Fixtures_Setup_Teardown
│
├── pom.xml
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── Calculator.java
│   │   └── resources
│   │
│   └── test
│       └── java
│           └── AAATest.java
│
├── .gitignore
│
└── README.md
```

---

# Technologies Used

* Java 25
* JUnit 5
* Apache Maven
* IntelliJ IDEA Community Edition
* Git
* GitHub

---

# Maven Dependency

JUnit 5 dependency added in the `pom.xml` file.

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.12.2</version>
    <scope>test</scope>
</dependency>
```

---

# Maven Surefire Plugin

The Maven Surefire Plugin is responsible for discovering and executing JUnit test cases.

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.5.2</version>
</plugin>
```

---

# Production Class

A simple `Calculator` class was created to demonstrate unit testing.

### Calculator.java

```java
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

}
```

---

# Test Class

The `AAATest` class demonstrates:

* Arrange–Act–Assert (AAA) Pattern
* Test Fixtures
* `@BeforeEach`
* `@AfterEach`

---

# Arrange–Act–Assert (AAA) Pattern

The AAA Pattern is a widely accepted structure for writing readable and maintainable unit tests.

## 1. Arrange

Prepare the required objects and test data.

Example:

```java
int a = 5;
int b = 3;
```

Purpose:

* Initialize variables.
* Create required objects.
* Prepare test input.

---

## 2. Act

Execute the method being tested.

Example:

```java
int result = calculator.add(a, b);
```

Purpose:

* Invoke the functionality under test.
* Capture the returned result.

---

## 3. Assert

Verify that the actual result matches the expected result.

Example:

```java
assertEquals(8, result);
```

Purpose:

* Compare expected and actual values.
* Determine whether the test passes or fails.

---

# Test Fixtures

A **Test Fixture** is the common setup required before executing a test.

Instead of creating the `Calculator` object inside every test method, it is initialized once before each test using `@BeforeEach`.

This improves:

* Code readability
* Code reuse
* Maintainability

---

# Setup Method

The setup method executes **before every test case**.

```java
@BeforeEach
void setUp() {
    calculator = new Calculator();
}
```

Purpose:

* Create the required objects.
* Prepare the test environment.
* Ensure each test starts with a fresh state.

---

# Teardown Method

The teardown method executes **after every test case**.

```java
@AfterEach
void tearDown() {
    calculator = null;
}
```

Purpose:

* Release resources.
* Clean up objects.
* Reset the test environment.

---

# Test Execution Flow

Each test follows the sequence below:

```text
@BeforeEach
        ↓
Arrange
        ↓
Act
        ↓
Assert
        ↓
@AfterEach
```

This sequence is repeated for every test method.

---

# Implementation Steps

### Step 1

Created a Maven-based Java project.

---

### Step 2

Configured Java 25 as the project SDK.

---

### Step 3

Added JUnit 5 dependency to the `pom.xml` file.

---

### Step 4

Reloaded the Maven project.

---

### Step 5

Created the `Calculator` class.

---

### Step 6

Created the `AAATest` class.

---

### Step 7

Implemented:

* `@BeforeEach`
* `@AfterEach`
* AAA Pattern
* `assertEquals()`

---

### Step 8

Executed the test successfully.

---

# Execution

The JUnit test was executed using IntelliJ IDEA.

The setup method executed before the test.

The test verified the addition operation.

The teardown method executed after the test.

---

# Expected Output

```text
Setting up...

Cleaning up...

Tests Passed

Process finished with exit code 0
```

---

# Executed Output

<img width="1727" height="957" alt="Exercise_4_AAA_Pattern_Test_Fixtures_Setup_Teardown" src="https://github.com/user-attachments/assets/25c66184-47f2-4cae-bf62-08757f6003b6" />

---

# JUnit Annotations Used

| Annotation    | Purpose                           |
| ------------- | --------------------------------- |
| `@Test`       | Marks a method as a test case     |
| `@BeforeEach` | Executes before every test method |
| `@AfterEach`  | Executes after every test method  |

---

# Concepts Learned

* Unit Testing
* Arrange–Act–Assert (AAA) Pattern
* Test Fixtures
* Setup Methods
* Teardown Methods
* JUnit Lifecycle
* `@BeforeEach`
* `@AfterEach`
* Assertions
* Maven Project Structure

---

# Files Included

| File              | Description                                                      |
| ----------------- | ---------------------------------------------------------------- |
| `Calculator.java` | Production class containing the business logic                   |
| `AAATest.java`    | JUnit test class demonstrating the AAA Pattern and test fixtures |
| `pom.xml`         | Maven configuration with JUnit dependency                        |
| `.gitignore`      | Ignores IDE and build-generated files                            |
| `README.md`       | Documentation for this exercise                                  |

---

# Learning Outcome

After completing this exercise, I learned how to:

* Organize unit tests using the Arrange–Act–Assert (AAA) Pattern.
* Separate test preparation, execution, and validation.
* Use `@BeforeEach` to initialize test objects.
* Use `@AfterEach` to clean up resources after test execution.
* Create reusable test fixtures.
* Execute JUnit test cases using IntelliJ IDEA.
* Improve the readability and maintainability of unit tests.

---

# Conclusion

This exercise introduces one of the most widely used testing practices in software development—the **Arrange–Act–Assert (AAA) Pattern**. Combined with **Test Fixtures** and the JUnit test lifecycle annotations (`@BeforeEach` and `@AfterEach`), it enables developers to write clean, reusable, and maintainable unit tests.

The concepts learned in this exercise form the foundation for advanced testing topics such as **Mockito**, **Mock Objects**, **Dependency Injection in Tests**, **Spring Boot Testing**, and **Test-Driven Development (TDD)**.

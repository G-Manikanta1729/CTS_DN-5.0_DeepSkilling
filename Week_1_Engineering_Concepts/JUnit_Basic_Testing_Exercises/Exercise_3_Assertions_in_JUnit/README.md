# Exercise 3: Assertions in JUnit

## Objective

The objective of this exercise is to understand and implement various **JUnit 5 assertion methods** used to validate the correctness of program execution. Assertions are the core mechanism of unit testing because they compare the expected result with the actual result produced by the code.

This exercise demonstrates how different assertions are used to verify boolean conditions, object references, null values, and equality between expected and actual values.

---

# Problem Statement

**Scenario:**

You need to use different assertions in JUnit to validate your test results.

### Steps

1. Configure a Maven-based Java project with JUnit 5.
2. Create a JUnit test class.
3. Write test cases using different assertion methods.
4. Execute the test and verify successful execution.

---

# Project Structure

```text
Exercise_3_Assertions_in_JUnit
│
├── pom.xml
│
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   │
│   └── test
│       └── java
│           └── AssertionsTest.java
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

# Test Class

The test class created for this exercise is:

```text
AssertionsTest.java
```

It demonstrates different assertion methods provided by JUnit 5.

---

# Assertions Implemented

## 1. assertEquals()

Checks whether the expected value and the actual value are equal.

```java
assertEquals(5, 2 + 3);
```

Expected Result:

* Test passes because `2 + 3 = 5`.

---

## 2. assertTrue()

Checks whether the given condition evaluates to **true**.

```java
assertTrue(5 > 3);
```

Expected Result:

* Test passes because the condition evaluates to true.

---

## 3. assertFalse()

Checks whether the given condition evaluates to **false**.

```java
assertFalse(5 < 3);
```

Expected Result:

* Test passes because the condition evaluates to false.

---

## 4. assertNull()

Checks whether the specified object reference is **null**.

```java
assertNull(null);
```

Expected Result:

* Test passes because the object reference is null.

---

## 5. assertNotNull()

Checks whether the specified object reference is **not null**.

```java
assertNotNull(new Object());
```

Expected Result:

* Test passes because a new object is created successfully.

---

# Test Class Implementation

The `AssertionsTest` class contains a single test method that demonstrates all five assertion methods.

The assertions verify:

* Equality of values
* Boolean conditions
* Null references
* Object existence

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

Reloaded the Maven project to download required libraries.

---

### Step 5

Created the `AssertionsTest` class inside the `src/test/java` directory.

---

### Step 6

Implemented various assertion methods.

---

### Step 7

Executed the test successfully using IntelliJ IDEA.

---

# Execution

The test class was executed using IntelliJ IDEA.

The execution verified that all assertions were satisfied.

---

# Expected Output

```text
Tests Passed

Process finished with exit code 0
```

---

# Executed Output

<img width="1727" height="957" alt="Exercise_3_Assertions_in_JUnit" src="https://github.com/user-attachments/assets/250be9b0-6a71-4ad1-b8a4-bcefcc2fe618" />

---

# Assertions Used

| Assertion         | Purpose                                        |
| ----------------- | ---------------------------------------------- |
| `assertEquals()`  | Compares expected and actual values            |
| `assertTrue()`    | Verifies that a condition is true              |
| `assertFalse()`   | Verifies that a condition is false             |
| `assertNull()`    | Checks whether an object reference is null     |
| `assertNotNull()` | Checks whether an object reference is not null |

---

# Concepts Learned

* Unit Testing
* JUnit Assertions
* Equality Validation
* Boolean Assertions
* Null Checking
* Object Validation
* Test Case Execution
* Maven Dependency Management

---

# Files Included

| File                  | Description                                      |
| --------------------- | ------------------------------------------------ |
| `pom.xml`             | Maven project configuration                      |
| `AssertionsTest.java` | JUnit test class demonstrating assertion methods |
| `.gitignore`          | Ignores IDE and build-generated files            |
| `README.md`           | Documentation for this exercise                  |

---

# Learning Outcome

After completing this exercise, I learned how to:

* Write JUnit test cases using assertion methods.
* Compare expected and actual values using `assertEquals()`.
* Validate boolean expressions using `assertTrue()` and `assertFalse()`.
* Check null and non-null references using `assertNull()` and `assertNotNull()`.
* Execute JUnit test cases successfully in IntelliJ IDEA.
* Understand the role of assertions in validating program behavior.

---

# Conclusion

This exercise introduces the fundamental assertion methods provided by JUnit 5. Assertions are an essential component of unit testing because they determine whether a test case passes or fails. Understanding these assertions provides the foundation for writing reliable and maintainable unit tests, which will be further extended in subsequent exercises involving the Arrange–Act–Assert (AAA) pattern, test fixtures, Mockito, and Test-Driven Development (TDD).

# Exercise 1: Setting Up JUnit

## Objective

The objective of this exercise is to configure a Java project for unit testing using **JUnit 5**. This exercise introduces the process of creating a Maven-based Java project, adding JUnit dependencies, creating a test class, and executing the first JUnit test successfully.

---

# Problem Statement

**Scenario:**

You need to set up JUnit in a Java project to begin writing and executing unit tests.

### Steps

1. Create a new Java project using IntelliJ IDEA.
2. Configure the project as a Maven project.
3. Add the JUnit 5 dependency to the `pom.xml` file.
4. Create a new JUnit test class.
5. Execute the test and verify successful execution.

---

# Project Structure

```text
Exercise_1_Setting_Up_JUnit
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
│           └── CalculatorTest.java
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

The following dependency was added to the `pom.xml` file to enable JUnit 5 support.

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

A simple test class named `CalculatorTest` was created inside the `src/test/java` directory.

```java
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void firstTest() {
        System.out.println("JUnit is working!");
    }

}
```

---

# Implementation Steps

### Step 1

Created a new Maven Java project using IntelliJ IDEA.

---

### Step 2

Configured Java 25 as the project SDK.

---

### Step 3

Added the JUnit 5 dependency to the `pom.xml` file.

---

### Step 4

Reloaded the Maven project to download all required JUnit libraries.

---

### Step 5

Created the first JUnit test class.

---

### Step 6

Executed the test successfully using IntelliJ IDEA.

---

# Execution

The test was executed using the IntelliJ IDEA Run option.

**Result**

* Test executed successfully.
* JUnit framework loaded correctly.
* Maven dependencies resolved successfully.

---

# Expected Output

```text
JUnit is working!

Process finished with exit code 0

Tests Passed
```

---

# Executed Output

<img width="1732" height="960" alt="Exercise_1_Setting_Up_JUnit" src="https://github.com/user-attachments/assets/8d77de35-28c4-432f-bf72-04e84870acce" />

---

# Concepts Learned

* Introduction to Unit Testing
* JUnit 5 Framework
* Maven Project Structure
* Maven Dependency Management
* Test Classes
* Test Methods
* `@Test` Annotation
* Running JUnit Tests
* IntelliJ IDEA Project Configuration

---

# Files Included

| File                  | Description                                      |
| --------------------- | ------------------------------------------------ |
| `pom.xml`             | Maven project configuration and JUnit dependency |
| `CalculatorTest.java` | First JUnit test class                           |
| `.gitignore`          | Ignores build and IDE-generated files            |
| `README.md`           | Documentation for this exercise                  |

---

# Learning Outcome

After completing this exercise, I learned how to:

* Create a Maven-based Java project.
* Configure JUnit 5 using Maven.
* Understand the standard Maven directory structure.
* Create and execute a JUnit test class.
* Verify successful test execution in IntelliJ IDEA.
* Use Maven to manage project dependencies.

---

# Conclusion

This exercise establishes the foundation for JUnit-based unit testing. By successfully configuring a Maven project, adding JUnit 5 dependencies, and executing the first test case, the project is now ready for writing more comprehensive unit tests in subsequent exercises involving assertions, test fixtures, the Arrange–Act–Assert (AAA) pattern, Mockito, and Test-Driven Development (TDD).

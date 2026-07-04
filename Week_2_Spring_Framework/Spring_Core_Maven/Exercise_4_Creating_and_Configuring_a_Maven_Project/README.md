# Exercise 4: Creating and Configuring a Maven Project

## Week 2 - Spring Framework

### Module
**Spring Core and Maven**

### Exercise
**Exercise 4: Creating and Configuring a Maven Project**

---

# Introduction

Modern Java applications often require several external libraries and frameworks to implement various functionalities such as dependency injection, web development, logging, database connectivity, and security.

Managing these libraries manually is difficult because developers must download JAR files, add them to the project, and keep them updated whenever new versions are released.

To solve this problem, Java provides **Maven**, a powerful build automation and dependency management tool.

In this exercise, a new Maven project is created for a **Library Management System**. The project is configured by adding Spring Framework dependencies such as **Spring Context**, **Spring AOP**, and **Spring Web MVC**. Additionally, the Maven Compiler Plugin is configured to compile the project using Java 1.8 compatibility.

This exercise forms the foundation for all future Spring applications because almost every Spring project is created and managed using Maven.

---

# Objective

The objective of this exercise is to understand how to create and configure a Maven project for Spring Framework development.

After completing this exercise, you will learn:

- What is Maven?
- Why Maven is used.
- What is a POM file?
- How Maven manages dependencies.
- How to add Spring Framework libraries.
- How to configure Maven plugins.
- How to build a Maven project successfully.

---

# Scenario

A software company is developing a **Library Management System** using the Spring Framework.

Before implementing any business logic, the development team needs to create a Maven project that can automatically manage project dependencies.

The project requires the following Spring modules:

- Spring Context
- Spring AOP
- Spring Web MVC

The development team also wants Maven to compile the project using Java 1.8 compatibility.

Therefore, a Maven project is created and configured by editing the **pom.xml** file.

---

# Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Maven | Build Automation and Dependency Management |
| Spring Framework | Java Enterprise Framework |
| Spring Context | IoC Container and Dependency Injection |
| Spring AOP | Aspect-Oriented Programming |
| Spring Web MVC | Web Application Development |
| IntelliJ IDEA | Integrated Development Environment |

---

# Prerequisites

Before performing this exercise, you should know:

- Basic Java Programming
- Classes and Objects
- XML Basics
- Spring Framework Basics
- IoC and Dependency Injection
- IntelliJ IDEA Basics

---

# Concepts Used

## 1. What is Maven?

### Definition

**Maven** is an open-source build automation and dependency management tool used primarily for Java projects.

It helps developers:

- Manage project dependencies
- Compile source code
- Execute tests
- Package applications
- Generate documentation
- Build projects automatically

Instead of manually downloading JAR files, Maven automatically downloads all required libraries from the **Maven Central Repository**.

---

### Why Do We Need Maven?

Imagine you are developing a Spring application.

Without Maven:

- Download Spring JAR files manually.
- Copy them into the project.
- Update them whenever a new version is released.
- Download additional dependent libraries manually.

This process is time-consuming and error-prone.

With Maven:

Simply specify the dependency inside the `pom.xml` file.

Example:

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.1.8</version>
</dependency>
```

Maven automatically downloads the library and all required dependent libraries.

---

## Real-Life Example

Imagine constructing a house.

Without Maven:

You personally purchase:

- Cement
- Bricks
- Steel
- Sand
- Paint

One by one.

With Maven:

You simply provide the contractor with a list of required materials.

The contractor purchases everything automatically.

Similarly,

The developer specifies dependencies.

Maven downloads everything automatically.

---

# What is a POM File?

### Definition

POM stands for **Project Object Model**.

The **pom.xml** file is the heart of every Maven project.

It contains all project information such as:

- Project Name
- Version
- Dependencies
- Plugins
- Java Version
- Build Configuration

Without the `pom.xml` file, Maven cannot manage the project.

---

### Example

```xml
<groupId>com.library</groupId>

<artifactId>LibraryManagement</artifactId>

<version>1.0-SNAPSHOT</version>
```

These values uniquely identify the project.

---

# What are Dependencies?

### Definition

A dependency is an external library required by an application.

Instead of writing every feature from scratch, developers use libraries created by others.

Examples:

- Spring Framework
- Hibernate
- JUnit
- Logback
- MySQL Connector

These are all dependencies.

---

### Example

```xml
<dependency>

    <groupId>org.springframework</groupId>

    <artifactId>spring-context</artifactId>

    <version>6.1.8</version>

</dependency>
```

When Maven reads this dependency, it downloads the Spring Context library automatically.

---

# What are Maven Plugins?

### Definition

A Maven Plugin is a component that performs a specific task during the build process.

Examples:

- Compile Java code
- Execute tests
- Package the application
- Generate documentation
- Create JAR files

Plugins extend Maven's functionality.

---

## Maven Compiler Plugin

In this exercise, the **Maven Compiler Plugin** is configured.

Its purpose is to compile Java source code.

Example:

```xml
<plugin>

    <artifactId>maven-compiler-plugin</artifactId>

</plugin>
```

The plugin is configured to compile the project using Java 1.8 compatibility.

---

# Spring Dependencies Used

This exercise adds three important Spring Framework modules.

---

## Spring Context

Spring Context is the core module of the Spring Framework.

It provides:

- IoC Container
- Dependency Injection
- Bean Management
- ApplicationContext

It is required by almost every Spring application.

---

## Spring AOP

Spring AOP stands for **Aspect-Oriented Programming**.

It is used to separate common functionalities from business logic.

Examples include:

- Logging
- Security
- Transactions
- Exception Handling

Instead of writing repetitive code inside every method, Spring AOP handles these concerns automatically.

---

## Spring Web MVC

Spring Web MVC is used to develop web applications.

It follows the **Model-View-Controller (MVC)** design pattern.

Responsibilities include:

- Receiving HTTP requests
- Processing requests
- Calling business logic
- Returning responses to users

Most Spring-based web applications use this module.

---

# Why Are These Dependencies Added?

This exercise prepares the project for future Spring development.

The dependencies added in this exercise will later be used to develop:

- Spring Core Applications
- Spring MVC Applications
- REST APIs
- Enterprise Web Applications
- Spring Boot Projects

Although these libraries are not used immediately, configuring them at the beginning ensures that the project is ready for future development.

---

# Learning Outcomes

After completing this exercise, you will be able to:

- Understand Maven architecture.
- Create a Maven project.
- Understand the purpose of the `pom.xml` file.
- Add Spring Framework dependencies.
- Configure Maven plugins.
- Build a Maven project successfully.
- Understand how Maven downloads dependencies automatically.
- Prepare a Java project for Spring Framework development.

---

# Project Structure

The project follows the standard Maven directory structure recommended for Java and Spring applications.

```
Exercise_4_Creating_and_Configuring_a_Maven_Project
│
├── README.md
├── pom.xml
├── .gitignore
│
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   │
│   └── test
│       └── java
│
└── Output
    └── Build_Success.png
```

---

# Folder and File Description

| File / Folder | Description |
|---------------|-------------|
| **README.md** | Documentation of the exercise including concepts and implementation. |
| **pom.xml** | The Project Object Model (POM) file that contains project configuration, dependencies, plugins, and build information. |
| **src/main/java** | Stores the application's Java source code. |
| **src/main/resources** | Stores configuration files such as XML, properties files, etc. |
| **src/test/java** | Stores test classes written using JUnit or other testing frameworks. |
| **Output** | Contains screenshots showing successful execution of the project. |

---

# Implementation

The implementation of this exercise is divided into four simple steps.

---

# Step 1: Create a Maven Project

A new Maven project named **LibraryManagement** is created using IntelliJ IDEA.

During project creation, Maven automatically generates the standard directory structure.

Project Details

| Property | Value |
|----------|-------|
| Project Name | LibraryManagement |
| Group ID | com.library |
| Artifact ID | LibraryManagement |
| Version | 1.0-SNAPSHOT |

---

# Step 2: Configure the pom.xml File

The **pom.xml** file is the most important file in a Maven project.

It contains:

- Project Information
- Java Version
- Dependencies
- Plugins
- Build Configuration

A simplified structure of the POM file is shown below.

```xml
<project>

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.library</groupId>

    <artifactId>LibraryManagement</artifactId>

    <version>1.0-SNAPSHOT</version>

    <properties>
        ...
    </properties>

    <dependencies>
        ...
    </dependencies>

    <build>
        ...
    </build>

</project>
```

---

# Understanding Each Section of pom.xml

## modelVersion

```xml
<modelVersion>4.0.0</modelVersion>
```

This specifies the version of the Maven Project Object Model.

Currently, all Maven projects use version **4.0.0**.

---

## groupId

```xml
<groupId>com.library</groupId>
```

The **groupId** uniquely identifies the organization or company that owns the project.

Example:

```
com.library
```

This follows the Java package naming convention.

---

## artifactId

```xml
<artifactId>LibraryManagement</artifactId>
```

The **artifactId** specifies the name of the project.

This name is used when Maven generates the final JAR file.

Example:

```
LibraryManagement-1.0-SNAPSHOT.jar
```

---

## version

```xml
<version>1.0-SNAPSHOT</version>
```

This specifies the current version of the project.

A **SNAPSHOT** version indicates that the project is still under development.

---

# Step 3: Add Spring Dependencies

Three Spring Framework dependencies are added.

---

## Spring Context

```xml
<dependency>

    <groupId>org.springframework</groupId>

    <artifactId>spring-context</artifactId>

    <version>6.1.8</version>

</dependency>
```

### Purpose

Provides:

- Spring IoC Container
- Dependency Injection
- Bean Management
- ApplicationContext

This is the core dependency required for almost every Spring application.

---

## Spring AOP

```xml
<dependency>

    <groupId>org.springframework</groupId>

    <artifactId>spring-aop</artifactId>

    <version>6.1.8</version>

</dependency>
```

### Purpose

Provides support for:

- Logging
- Security
- Transactions
- Exception Handling
- Cross-cutting concerns

Spring AOP helps reduce repetitive code by separating common functionalities from business logic.

---

## Spring Web MVC

```xml
<dependency>

    <groupId>org.springframework</groupId>

    <artifactId>spring-webmvc</artifactId>

    <version>6.1.8</version>

</dependency>
```

### Purpose

Provides components required for building web applications.

Examples:

- Controllers
- Request Mapping
- View Resolution
- REST APIs
- MVC Architecture

Although this exercise does not build a web application, adding this dependency prepares the project for future Spring MVC development.

---

# Step 4: Configure Maven Compiler Plugin

The Maven Compiler Plugin is added inside the `<build>` section.

```xml
<build>

    <plugins>

        <plugin>

            <groupId>org.apache.maven.plugins</groupId>

            <artifactId>maven-compiler-plugin</artifactId>

            <version>3.11.0</version>

            <configuration>

                <source>1.8</source>

                <target>1.8</target>

            </configuration>

        </plugin>

    </plugins>

</build>
```

---

# Understanding the Maven Compiler Plugin

The Maven Compiler Plugin is responsible for compiling Java source code.

Without this plugin, Maven would not know which Java version should be used during compilation.

---

## source

```xml
<source>1.8</source>
```

Specifies the Java language version used to compile the source code.

In this exercise, Java 8 syntax is used.

---

## target

```xml
<target>1.8</target>
```

Specifies the version of Java Virtual Machine (JVM) that the compiled bytecode should support.

This ensures that the application can run on Java 8 compatible JVMs.

---

# How Maven Downloads Dependencies

When the project is opened or Maven is reloaded, the following process takes place.

```
Developer

↓

Writes Dependency in pom.xml

↓

Maven Reads pom.xml

↓

Connects to Maven Central Repository

↓

Downloads Required Libraries

↓

Downloads Dependent Libraries

↓

Stores Them in Local Repository

↓

Project Can Use Them
```

The downloaded libraries appear under **External Libraries** inside IntelliJ IDEA.

---

# Build the Project

After configuring the project, Maven is instructed to compile the application.

Using IntelliJ:

```
Maven

↓

Lifecycle

↓

Compile
```

or

```
Build

↓

Build Project
```

Maven performs the following operations:

1. Reads the `pom.xml` file.
2. Downloads missing dependencies.
3. Resolves dependency relationships.
4. Compiles Java source files.
5. Generates class files inside the `target` directory.

If everything is configured correctly, Maven displays a successful build message.

---

# Understanding BUILD SUCCESS

Example:

```
[INFO] BUILD SUCCESS
```

This message confirms that:

- The `pom.xml` file is valid.
- All dependencies were downloaded successfully.
- The Maven Compiler Plugin executed successfully.
- The project compiled without any errors.

This indicates that the Maven project has been configured correctly and is ready for further Spring development.

---

# Execution Flow

The following diagram illustrates how Maven processes the project when it is built.

```
Developer
      │
      ▼
Creates Maven Project
      │
      ▼
Writes Project Information
inside pom.xml
      │
      ▼
Adds Spring Dependencies
      │
      ▼
Configures Maven Compiler Plugin
      │
      ▼
Runs Maven Build
      │
      ▼
Maven Reads pom.xml
      │
      ▼
Downloads Required Dependencies
from Maven Central Repository
      │
      ▼
Stores Dependencies in Local Repository
      │
      ▼
Compiles Project
      │
      ▼
Generates Target Directory
      │
      ▼
Displays BUILD SUCCESS
```

---

# Internal Working of Maven

When the project is built, Maven performs the following operations automatically.

## Step 1

Maven reads the **pom.xml** file.

```
pom.xml
```

The POM file contains:

- Project Information
- Dependencies
- Plugins
- Build Configuration

---

## Step 2

Maven checks all project dependencies.

Example:

```
Spring Context

Spring AOP

Spring Web MVC
```

---

## Step 3

If the dependencies are not available on the local system, Maven connects to the **Maven Central Repository**.

```
Developer

↓

Maven

↓

Maven Central Repository

↓

Downloads Libraries
```

---

## Step 4

Downloaded libraries are stored in the local Maven repository.

Example location:

```
C:\Users\<username>\.m2\repository
```

Whenever another project requires the same library, Maven uses the locally stored version instead of downloading it again.

---

## Step 5

Maven reads the Compiler Plugin configuration.

```xml
<source>1.8</source>

<target>1.8</target>
```

This tells Maven:

- Compile using Java 8 language features.
- Generate Java 8 compatible bytecode.

---

## Step 6

Maven compiles the source code.

Compiled `.class` files are generated inside the **target** directory.

---

## Step 7

If no errors occur, Maven displays:

```
BUILD SUCCESS
```

This indicates that the project has been configured correctly.

---

# Expected Output

When the project is compiled successfully, Maven displays output similar to:

```
[INFO] Scanning for projects...

[INFO] Building LibraryManagement 1.0-SNAPSHOT

[INFO] --- maven-clean-plugin ---

[INFO] --- maven-resources-plugin ---

[INFO] --- maven-compiler-plugin ---

[INFO] Nothing to compile - all classes are up to date

[INFO] BUILD SUCCESS

[INFO] Total time: 2.590 s
```

The most important message is:

```
BUILD SUCCESS
```

This confirms that the Maven project has been configured correctly.

---

# Executed Output

<img width="1730" height="958" alt="Output" src="https://github.com/user-attachments/assets/ddf7a477-3a13-4301-a46e-3767ee1ab0b9" />

---

# Advantages of Maven

Maven provides several benefits over manually managing Java projects.

### 1. Automatic Dependency Management

Developers only need to specify dependencies inside the `pom.xml` file.

Maven automatically downloads the required libraries.

---

### 2. Standard Project Structure

Every Maven project follows the same directory structure.

This makes projects easy to understand and maintain.

---

### 3. Build Automation

Maven automates common development tasks such as:

- Compilation
- Testing
- Packaging
- Documentation Generation

---

### 4. Version Management

Developers can easily upgrade or downgrade library versions by modifying the version number inside the `pom.xml` file.

---

### 5. Plugin Support

Maven provides plugins for various development tasks such as:

- Compilation
- Testing
- Code Analysis
- Packaging
- Deployment

---

### 6. Reusability

The same dependencies can be reused across multiple projects without downloading them repeatedly.

---

# Advantages of Using Spring Dependencies

Adding Spring dependencies prepares the project for enterprise application development.

### Spring Context

- Provides IoC Container.
- Supports Dependency Injection.
- Manages Beans.

---

### Spring AOP

- Reduces repetitive code.
- Supports Logging.
- Supports Transactions.
- Improves Maintainability.

---

### Spring Web MVC

- Supports MVC Architecture.
- Used for Web Applications.
- Supports REST APIs.
- Simplifies Request Handling.

---

# Common Errors and Solutions

## Error

```
mvn : The term 'mvn' is not recognized...
```

### Reason

Apache Maven is not installed or the Maven `bin` directory is not added to the system PATH.

### Solution

- Install Apache Maven.
- Configure the PATH environment variable.
- Restart the terminal.

---

## Error

```
Could not resolve dependencies
```

### Reason

Internet connection is unavailable or dependency information is incorrect.

### Solution

- Check the internet connection.
- Verify the dependency version.
- Reload the Maven project.

---

## Error

```
BUILD FAILURE
```

### Reason

The `pom.xml` contains incorrect configuration.

### Solution

Verify:

- Dependency syntax.
- Plugin configuration.
- XML structure.

---

# Interview Questions

## 1. What is Maven?

**Answer**

Maven is a build automation and dependency management tool used primarily for Java projects. It simplifies project configuration, dependency management, and build processes.

---

## 2. What is the purpose of the `pom.xml` file?

**Answer**

The `pom.xml` file contains the complete configuration of a Maven project, including project information, dependencies, plugins, Java version, and build settings.

---

## 3. What is a dependency?

**Answer**

A dependency is an external library required by a project. Maven automatically downloads dependencies from the Maven Central Repository.

---

## 4. What is the Maven Compiler Plugin?

**Answer**

The Maven Compiler Plugin compiles Java source code and allows developers to specify the Java source and target versions.

---

## 5. What is the Maven Central Repository?

**Answer**

The Maven Central Repository is an online repository that stores thousands of Java libraries. Maven downloads dependencies from this repository automatically.

---

## 6. What is the purpose of Spring Context?

**Answer**

Spring Context provides the IoC Container, Dependency Injection, Bean Management, and ApplicationContext.

---

## 7. What is Spring AOP?

**Answer**

Spring AOP (Aspect-Oriented Programming) separates common functionalities such as logging, security, and transactions from business logic.

---

## 8. What is Spring Web MVC?

**Answer**

Spring Web MVC is a web framework that follows the Model-View-Controller architecture and is used to develop web applications and REST APIs.

---

## 9. Why is the Maven Compiler Plugin configured for Java 1.8?

**Answer**

The plugin ensures that the project is compiled using Java 8 compatibility, allowing it to run on Java 8 supported environments.

---

## 10. What does BUILD SUCCESS mean?

**Answer**

BUILD SUCCESS indicates that Maven successfully downloaded dependencies, executed the configured plugins, compiled the project, and completed the build without errors.

---

# Key Learnings

After completing this exercise, you have learned:

- How to create a Maven project.
- The purpose of Maven.
- The importance of the `pom.xml` file.
- How Maven manages dependencies.
- How to configure Spring Framework dependencies.
- How to configure the Maven Compiler Plugin.
- How Maven builds Java projects.
- How Maven downloads libraries automatically.
- The role of Spring Context, Spring AOP, and Spring Web MVC.

---

# Conclusion

This exercise introduced the fundamentals of **Maven Project Configuration** and demonstrated how Maven simplifies Java project development by automating dependency management and the build process.

The project was configured by adding **Spring Context**, **Spring AOP**, and **Spring Web MVC** dependencies, making it ready for future Spring application development. Additionally, the **Maven Compiler Plugin** was configured to compile the project with Java 1.8 compatibility.

Understanding Maven is an essential skill for every Java developer because almost all modern Java and Spring applications use Maven (or Gradle) for dependency management and project building.

This exercise provides the foundation required for future topics such as **Spring Core**, **Spring Boot**, **Spring Data JPA**, **Spring MVC**, **Spring Security**, and **Microservices**, where Maven plays a central role in managing project dependencies and the application lifecycle.

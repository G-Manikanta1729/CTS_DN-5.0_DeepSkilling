# Exercise 1 – Create a Spring Web Project using Maven

---

# Introduction

Spring Boot is one of the most popular frameworks used for developing modern Java enterprise applications. It is built on top of the Spring Framework and simplifies application development by eliminating complex configuration, reducing boilerplate code, and providing production-ready features out of the box.

Before Spring Boot was introduced, developers had to manually configure the application, manage external web servers such as Apache Tomcat, define XML configuration files, download multiple dependencies, and spend significant time setting up a project before writing business logic.

Spring Boot solves these problems by providing an opinionated framework that automatically configures the application based on the dependencies available in the project. It also includes an embedded web server, starter dependencies, auto-configuration, and developer tools, allowing developers to focus on application development rather than project setup.

This exercise demonstrates how to create a Spring Boot Web project using Maven, understand the generated project structure, explore the purpose of important files such as `pom.xml` and `SpringLearnApplication.java`, and run the application successfully using the embedded Tomcat server.

---

# Objective

The objective of this exercise is to understand the basic structure and execution of a Spring Boot application.

After completing this exercise, you will be able to:

- Create a Spring Boot Web project using Spring Initializr.
- Understand the Maven project structure.
- Understand the purpose of `pom.xml`.
- Understand the purpose of `@SpringBootApplication`.
- Understand the execution of `SpringApplication.run()`.
- Build the project using Maven.
- Run a Spring Boot application successfully.
- Understand Embedded Tomcat.
- Include logging in the application.
- Understand how Spring Boot starts internally.

---

# What is Spring Boot?

Spring Boot is an extension of the Spring Framework that simplifies Java application development by providing automatic configuration, starter dependencies, embedded servers, and production-ready features.

Instead of configuring every component manually, Spring Boot automatically detects the required configuration based on the project dependencies.

Without Spring Boot, developers need to configure numerous XML files, web servers, dependency libraries, and application settings. With Spring Boot, most of these tasks are performed automatically.

---

# Why Do We Need Spring Boot?

Traditional Spring applications require significant manual configuration before development can begin.

Typical challenges include:

- Configuring XML files.
- Managing dependencies manually.
- Deploying WAR files to external servers.
- Configuring web servers.
- Writing large amounts of boilerplate code.
- Longer development time.

Spring Boot eliminates these problems by providing automatic configuration and embedded servers.

---

# Advantages of Spring Boot

Spring Boot offers several advantages over traditional Spring applications.

- Rapid application development.
- Automatic configuration.
- Embedded Tomcat server.
- Simplified dependency management.
- No XML configuration required for most applications.
- Production-ready features.
- Easy Maven integration.
- Faster development cycle.
- Reduced boilerplate code.
- Easy testing and deployment.

---

# Technologies Used

| Technology | Version |
|------------|----------|
| Java | 21 |
| Spring Boot | 3.x |
| Maven | 3.x |
| Spring Web | Latest |
| Spring Boot DevTools | Latest |
| Embedded Tomcat | 10.x |
| IntelliJ IDEA | 2024.x |
| Git | Latest |
| GitHub | Repository Hosting |

---

# Software Requirements

Before running this project, ensure the following software is installed.

- Java Development Kit (JDK 21)
- IntelliJ IDEA
- Maven
- Git
- GitHub Account
- Internet Connection (to download Maven dependencies)

---

# Project Creation

The project was created using **Spring Initializr**.

Project Configuration

| Property | Value |
|----------|-------|
| Project | Maven |
| Language | Java |
| Spring Boot | 3.x |
| Group | com.cognizant |
| Artifact | spring-learn |
| Packaging | Jar |
| Java Version | 21 |

Dependencies Added

- Spring Web
- Spring Boot DevTools

---

# Project Structure

```text
spring-learn
│
├── .mvn
│
├── src
│   │
│   ├── main
│   │   │
│   │   ├── java
│   │   │
│   │   │   └── com
│   │   │       └── cognizant
│   │   │           └── springlearn
│   │   │
│   │   │               SpringLearnApplication.java
│   │   │
│   │   └── resources
│   │           │
│   │           ├── application.properties
│   │           ├── static
│   │           ├── templates
│   │           └── ...
│   │
│   └── test
│       │
│       └── java
│
├── pom.xml
│
├── mvnw
│
├── mvnw.cmd
│
└── HELP.md
```

---

# Folder Structure Explanation

## src/main/java

This folder contains the Java source code of the application.

It includes:

- Controllers
- Services
- Repositories
- Configuration Classes
- Models
- Main Application Class

Every business logic of the application resides in this folder.

---

## src/main/resources

This folder contains all application resources.

Examples include:

- application.properties
- HTML templates
- CSS files
- JavaScript files
- Images
- XML configuration files
- Static resources

Spring Boot automatically loads these resources during application startup.

---

## src/test/java

This folder contains test classes.

It is used for:

- Unit Testing
- Integration Testing
- JUnit Tests
- Mockito Tests

No application code should be written here.

---

## pom.xml

`pom.xml` is the most important file in every Maven project.

It defines:

- Project information.
- Dependencies.
- Plugins.
- Java version.
- Build configuration.
- Packaging information.

Maven reads this file and downloads all required libraries automatically.

---

## SpringLearnApplication.java

This is the entry point of the Spring Boot application.

Execution starts from the `main()` method present in this class.

It is responsible for starting the Spring Boot application and initializing the entire Spring Framework.

---

# Dependencies Used

Two dependencies were added while creating the project.

## Spring Web

Provides support for developing REST APIs and web applications.

Features include:

- REST Controllers
- HTTP Request Handling
- JSON Processing
- Embedded Tomcat
- Spring MVC

---

## Spring Boot DevTools

Provides development-time features.

Benefits include:

- Automatic Restart
- Live Reload
- Faster Development
- Improved Productivity

---

# Build Tool

The project uses **Apache Maven** as the build automation tool.

Maven performs the following tasks:

- Downloads dependencies.
- Compiles source code.
- Runs unit tests.
- Packages the application.
- Builds executable JAR files.

All configuration required by Maven is defined in the `pom.xml` file.

---

# Exercise Workflow

The complete workflow of this exercise is shown below.

```text
Spring Initializr

↓

Generate Project

↓

Download ZIP

↓

Extract Project

↓

Open in IntelliJ IDEA

↓

Maven Downloads Dependencies

↓

Project Builds Successfully

↓

Run SpringLearnApplication

↓

Spring Boot Starts

↓

Embedded Tomcat Starts

↓

Application Ready
```

---

# Concepts Covered

This exercise introduces several important Spring Boot concepts that will be used throughout the remaining hands-ons.

- Spring Boot
- Spring Initializr
- Maven Project
- Embedded Tomcat
- Spring Boot DevTools
- Spring Web
- Project Structure
- Maven Dependencies
- `pom.xml`
- `@SpringBootApplication`
- `SpringApplication.run()`
- Application Startup
- Logging

These concepts provide the foundation for building RESTful web services and enterprise Spring Boot applications in the upcoming exercises.

# Complete Implementation

This exercise demonstrates how to create, build, and execute a Spring Boot Web application using Maven. Although the application does not yet expose any REST endpoints, it establishes the complete foundation upon which all future Spring Boot and REST applications will be developed.

The project is generated using **Spring Initializr**, built using **Apache Maven**, and executed using the embedded **Apache Tomcat** server provided by Spring Boot.

---

# Implementation Overview

The implementation consists of the following steps.

```
Spring Initializr

↓

Generate Spring Boot Project

↓

Download ZIP

↓

Extract Project

↓

Open in IntelliJ IDEA

↓

Maven Downloads Dependencies

↓

Project Compilation

↓

Spring Boot Starts

↓

Embedded Tomcat Starts

↓

Application Ready
```

Each step plays an important role in preparing the application for development.

---

# Spring Initializr

Spring Initializr is an online project generator provided by the Spring team.

Website

```
https://start.spring.io
```

Instead of manually creating a Maven project and downloading dozens of JAR files, Spring Initializr generates an enterprise-ready Spring Boot project within seconds.

The generated project already contains

- Maven configuration
- Project structure
- Starter dependencies
- Main application class
- Application configuration
- Test classes

This saves a significant amount of development time.

---

# Project Configuration

The following configuration was selected while generating the project.

| Property | Value |
|----------|-------|
| Project | Maven |
| Language | Java |
| Spring Boot | 3.x |
| Group | com.cognizant |
| Artifact | spring-learn |
| Packaging | Jar |
| Java Version | 21 |

Dependencies

```
Spring Web

↓

Spring Boot DevTools
```

---

# Importing the Project

After downloading the ZIP file,

the project was extracted and opened in IntelliJ IDEA.

When IntelliJ opens the project,

it automatically detects

```
pom.xml
```

and starts

```
Maven Import
```

Maven then

- Reads pom.xml
- Downloads required libraries
- Configures the project
- Builds the dependency tree

No manual JAR downloads are required.

---

# Understanding pom.xml

The `pom.xml` file is the heart of every Maven project.

POM stands for

```
Project Object Model
```

Every dependency, plugin, Java version, and build configuration is defined inside this file.

Spring Boot itself is brought into the project through Maven dependencies defined in `pom.xml`.

Without this file,

the project cannot be compiled or executed.

---

# Important Sections of pom.xml

A typical Spring Boot `pom.xml` contains the following sections.

```
Project Information

↓

Parent

↓

Properties

↓

Dependencies

↓

Build Plugins
```

Each section has a specific responsibility.

---

# Parent Dependency

One of the most important sections is

```xml
<parent>
```

Example

```xml
<parent>
    <groupId>org.springframework.boot</groupId>

    <artifactId>
        spring-boot-starter-parent
    </artifactId>

    <version>3.x.x</version>
</parent>
```

Purpose

- Provides default dependency versions.
- Provides plugin management.
- Simplifies Maven configuration.
- Reduces XML configuration.

Without this parent,

developers must manually specify versions for every Spring dependency.

---

# Project Coordinates

Every Maven project has a unique identity.

Example

```xml
<groupId>com.cognizant</groupId>

<artifactId>spring-learn</artifactId>

<version>0.0.1-SNAPSHOT</version>
```

Explanation

**groupId**

Represents the organization.

Example

```
com.cognizant
```

---

**artifactId**

Represents the project name.

Example

```
spring-learn
```

---

**version**

Represents the current version of the project.

Example

```
0.0.1-SNAPSHOT
```

SNAPSHOT means

```
Project is still under development.
```

---

# Java Version

The following property specifies the Java version.

```xml
<java.version>21</java.version>
```

Purpose

Ensures Maven compiles the application using Java 21.

---

# Dependencies

The project contains two dependencies.

## Spring Web

```xml
spring-boot-starter-web
```

Purpose

Provides

- Spring MVC
- REST APIs
- DispatcherServlet
- Jackson JSON Library
- Embedded Tomcat

Without this dependency,

REST APIs cannot be created.

---

## Spring Boot DevTools

```xml
spring-boot-devtools
```

Purpose

Provides

- Automatic Restart
- Live Reload
- Faster Development
- Better Developer Experience

Whenever source code changes,

the application restarts automatically.

---

# Dependency Hierarchy

The CTS document asks to view the Dependency Hierarchy.

Although only two dependencies were selected,

Maven downloads many additional libraries automatically.

Example

```
Spring Web

↓

Spring MVC

↓

Spring Core

↓

Spring Beans

↓

Spring Context

↓

Spring Expression

↓

Jackson

↓

Embedded Tomcat

↓

Logging Libraries
```

Similarly,

DevTools downloads additional development libraries.

This automatic dependency resolution is called

```
Transitive Dependency Management.
```

---

# SpringLearnApplication.java

This is the most important Java file in the project.

It contains

```java
public static void main(String[] args)
```

Execution always starts here.

The class is annotated with

```java
@SpringBootApplication
```

and contains

```java
SpringApplication.run(...)
```

which starts the complete Spring Boot framework.

---

# Understanding @SpringBootApplication

This annotation tells Spring Boot

```
"This is the main configuration class."
```

Internally,

it combines three annotations.

```
@SpringBootApplication

↓

@Configuration

↓

@EnableAutoConfiguration

↓

@ComponentScan
```

---

## @Configuration

Marks the class as a Spring configuration class.

Instead of XML configuration,

Java configuration is used.

---

## @EnableAutoConfiguration

Automatically configures the application.

Example

If

```
Spring Web
```

dependency is detected,

Spring Boot automatically configures

- DispatcherServlet
- Embedded Tomcat
- Spring MVC
- HTTP Message Converters

No manual configuration is required.

---

## @ComponentScan

Searches the package

```
com.cognizant.springlearn
```

for Spring-managed classes.

It automatically detects

```
@Controller

@Service

@Repository

@Component

@Configuration
```

and creates objects (Beans) for them.

---

# Understanding SpringApplication.run()

This single line of code

```java
SpringApplication.run(
SpringLearnApplication.class,
args
);
```

starts the complete Spring Boot application.

Internally,

it performs numerous operations.

```
Read Configuration

↓

Create Application Context

↓

Scan Components

↓

Create Beans

↓

Dependency Injection

↓

Configure Auto Configuration

↓

Start Embedded Tomcat

↓

Application Ready
```

Although it is only one line,

it initializes the entire Spring Framework.

---

# Logging Implementation

The CTS exercise requires adding logs to verify that the `main()` method executes successfully.

The application uses the **SLF4J** logging API.

Example

```java
LOGGER.info("START");

SpringApplication.run(...);

LOGGER.info("END");
```

Purpose

- Verify application startup.
- Track execution flow.
- Debug application behavior.
- Record important events.

Professional enterprise applications use logging instead of `System.out.println()` because logging frameworks provide configurable log levels and better control over output.

---

# Application Execution Flow

The complete execution flow of this exercise is illustrated below.

```
main()

↓

LOGGER.info("START")

↓

SpringApplication.run()

↓

Spring Boot Starts

↓

Read pom.xml Dependencies

↓

Create Application Context

↓

Component Scan

↓

Auto Configuration

↓

Create Spring Beans

↓

Embedded Tomcat Starts

↓

Application Ready

↓

LOGGER.info("END")
```

Every Spring Boot application follows this startup sequence.

---

# Embedded Tomcat

Unlike traditional Java web applications,

Spring Boot contains an embedded Apache Tomcat server.

Therefore,

developers do not need to install Tomcat separately.

Application

```
↓

Embedded Tomcat

↓

HTTP Requests

↓

Spring MVC

↓

Response
```

When the application starts,

Tomcat automatically listens on

```
Port 8080
```

The console displays

```
Tomcat started on port(s): 8080
```

confirming successful startup.

---

# Output Verification

A successful execution produces output similar to the following.

```
INFO

START

...

Tomcat started on port 8080

Started SpringLearnApplication

END
```

This verifies that

- Logging works correctly.
- Spring Boot starts successfully.
- Embedded Tomcat is initialized.
- Application context is created.
- The project has been configured correctly.

At this stage, the application does not expose any REST endpoints because those will be implemented in the upcoming Spring REST hands-on exercises.

# Internal Working of Spring Boot

Understanding how Spring Boot works internally is essential for developing enterprise-grade applications. Although starting a Spring Boot application requires only one line of code, many internal processes occur before the application becomes ready to serve requests.

When the application starts, Spring Boot initializes the Spring Framework, creates the IoC Container, scans the project for components, configures the application automatically, creates required objects (Beans), starts the embedded Tomcat server, and finally makes the application ready to receive HTTP requests.

The complete startup process is shown below.

```
main()

↓

SpringApplication.run()

↓

Spring Boot Starts

↓

Spring Application Context Created

↓

Component Scan

↓

Bean Creation

↓

Dependency Injection

↓

Auto Configuration

↓

Embedded Tomcat Starts

↓

Application Ready
```

---

# Spring Boot Startup Process

The startup process consists of multiple stages.

```
User Runs Application

↓

JVM Starts

↓

main() Method Executes

↓

SpringApplication.run()

↓

Spring Container Starts

↓

Configuration Classes Loaded

↓

Beans Created

↓

Dependencies Injected

↓

Embedded Tomcat Starts

↓

Application Ready
```

Although the developer writes only one line of code, Spring Boot performs all these operations automatically.

---

# What Happens Inside main()

Every Java application starts from the `main()` method.

Example

```java
public static void main(String[] args) {

    LOGGER.info("START");

    SpringApplication.run(
            SpringLearnApplication.class,
            args);

    LOGGER.info("END");
}
```

Execution Flow

```
JVM

↓

main()

↓

LOGGER.info("START")

↓

SpringApplication.run()

↓

Spring Boot Startup

↓

LOGGER.info("END")
```

The `main()` method acts as the entry point of the application.

---

# SpringApplication.run()

This is the most important method in every Spring Boot application.

```java
SpringApplication.run(
SpringLearnApplication.class,
args);
```

Although it appears simple, internally it performs many operations.

```
Read Configuration

↓

Create Spring Context

↓

Perform Component Scan

↓

Create Beans

↓

Dependency Injection

↓

Auto Configuration

↓

Start Embedded Tomcat

↓

Application Ready
```

Without this method, Spring Boot cannot start.

---

# What is the Spring IoC Container?

IoC stands for

```
Inversion of Control
```

It is the heart of the Spring Framework.

The IoC Container is responsible for creating, managing, and destroying Java objects known as **Beans**.

Instead of developers creating objects using the `new` keyword everywhere, Spring creates and manages these objects automatically.

Traditional Java

```java
EmployeeService service =
new EmployeeService();
```

Spring Boot

```java
@Autowired

private EmployeeService service;
```

The IoC Container creates the object and injects it wherever required.

---

# What is ApplicationContext?

ApplicationContext is the implementation of the Spring IoC Container.

It stores all Spring Beans.

```
ApplicationContext

↓

EmployeeService Bean

↓

CountryService Bean

↓

CountryController Bean

↓

Repository Beans
```

Whenever an object is required,

Spring retrieves it from the ApplicationContext.

---

# What is a Spring Bean?

A Bean is simply a Java object managed by the Spring Framework.

Example

```java
@Service

public class CountryService{

}
```

Spring automatically creates an object.

```
CountryService

↓

Spring Bean

↓

Stored inside ApplicationContext
```

Developers do not need to instantiate these objects manually.

---

# Component Scanning

Spring Boot automatically scans the project's base package.

Example

```
com.cognizant.springlearn
```

It searches for classes annotated with

```
@Controller

↓

@Service

↓

@Repository

↓

@Component

↓

@Configuration
```

Every detected class becomes a Spring Bean.

---

# Dependency Injection

Dependency Injection is one of the most important concepts in Spring.

Suppose

```
CountryController

↓

CountryService
```

Instead of creating the service manually,

Spring injects it automatically.

Example

```java
@Autowired

private CountryService countryService;
```

Flow

```
Controller

↓

Autowired

↓

Spring Container

↓

CountryService Bean
```

This reduces coupling between classes and improves maintainability.

---

# Auto Configuration

One of Spring Boot's biggest features is **Auto Configuration**.

Instead of asking developers to configure everything manually,

Spring Boot examines the project dependencies.

Example

```
spring-boot-starter-web

↓

Detected

↓

Configure DispatcherServlet

↓

Configure Jackson

↓

Configure Embedded Tomcat

↓

Configure MVC
```

No manual XML configuration is required.

---

# Embedded Tomcat

Traditional Java Web Applications require an external web server.

Example

```
Developer

↓

Build WAR

↓

Install Tomcat

↓

Deploy WAR

↓

Start Server
```

Spring Boot simplifies this process.

```
Application

↓

Embedded Tomcat

↓

Run Application

↓

Server Starts Automatically
```

No separate Tomcat installation is required.

---

# Why Port 8080?

By default,

Embedded Tomcat starts on

```
8080
```

Console Output

```
Tomcat started on port 8080
```

This means the application is ready to receive HTTP requests.

Later REST APIs will become accessible using

```
http://localhost:8080
```

---

# Logging Framework

The application uses

```
SLF4J

↓

Logback
```

instead of

```java
System.out.println()
```

Logging Levels

```
TRACE

↓

DEBUG

↓

INFO

↓

WARN

↓

ERROR
```

For this exercise,

the `INFO` level was used.

```java
LOGGER.info("START");

LOGGER.info("END");
```

Logging is preferred because it supports configurable log levels, file logging, timestamps, and integration with monitoring tools.

---

# Maven Dependency Management

Maven automatically downloads all required libraries from remote repositories.

```
pom.xml

↓

Maven

↓

Download Dependencies

↓

Local Repository

↓

Compile Project
```

Downloaded libraries are stored in the local Maven repository, so they do not need to be downloaded again for future builds.

---

# Dependency Hierarchy

Although only two dependencies were selected,

Spring Boot downloads many additional libraries automatically.

```
Spring Web

↓

Spring MVC

↓

Spring Core

↓

Spring Context

↓

Spring Beans

↓

Jackson

↓

Embedded Tomcat

↓

Logging

↓

Validation

↓

Servlet API
```

This is known as **Transitive Dependency Management**.

It greatly simplifies dependency management for developers.

---

# Build Lifecycle

When the command

```bash
mvn clean package
```

is executed,

Maven performs the following lifecycle.

```
Clean

↓

Compile

↓

Test

↓

Package

↓

Executable JAR
```

The generated JAR contains

- Application classes
- Spring Boot libraries
- Embedded Tomcat
- Resources

This JAR can be executed directly using

```bash
java -jar spring-learn.jar
```

---

# Why DevTools?

Spring Boot DevTools improves the development experience.

Without DevTools

```
Modify Code

↓

Stop Application

↓

Run Again
```

With DevTools

```
Modify Code

↓

Save

↓

Application Restarts Automatically
```

This saves development time.

---

# Best Practices

While developing Spring Boot applications, follow these best practices.

- Use Java 21 (or the project's standard JDK version).
- Keep the `main()` class in the root package.
- Use meaningful package names.
- Prefer logging over `System.out.println()`.
- Let Spring manage object creation through Dependency Injection.
- Keep dependencies minimal.
- Use Maven Wrapper (`mvnw`) when sharing projects.
- Avoid modifying generated project structure unless necessary.

---

# Real-World Applications

Spring Boot is widely used to build enterprise applications such as:

- Banking Systems
- E-Commerce Platforms
- Hospital Management Systems
- Learning Management Systems
- Payroll Systems
- Inventory Management Systems
- Customer Relationship Management (CRM)
- Airline Reservation Systems
- Hotel Booking Applications
- Microservices-based Applications

Most modern Java backend systems use Spring Boot because of its simplicity, scalability, and production-ready features.

---

# Summary

This exercise introduced the internal architecture and startup process of a Spring Boot application. We explored how `SpringApplication.run()` initializes the Spring Framework, creates the ApplicationContext, performs component scanning, creates Spring Beans, injects dependencies, configures the application automatically, and starts the embedded Tomcat server.

We also learned about the role of the IoC Container, Dependency Injection, Maven dependency management, logging with SLF4J, and the importance of the generated project structure. These concepts form the foundation for all subsequent Spring Boot and Spring REST exercises, where controllers, services, and REST APIs will be built on top of this project.

# Running the Application

Follow the steps below to execute the Spring Boot application successfully.

---

# Step 1: Open the Project

Open IntelliJ IDEA.

Select

```
File

↓

Open

↓

spring-learn
```

Wait until IntelliJ finishes downloading all Maven dependencies.

The Maven icon at the bottom-right should disappear after synchronization is complete.

---

# Step 2: Verify Project Structure

Before running the application, ensure the project structure is correct.

```
spring-learn
│
├── src
│   ├── main
│   │   ├── java
│   │   │    └── com.cognizant.springlearn
│   │   │            SpringLearnApplication.java
│   │   │
│   │   └── resources
│   │        └── application.properties
│   │
│   └── test
│
├── pom.xml
│
├── mvnw
│
└── mvnw.cmd
```

If your project matches the above structure, you are ready to proceed.

---

# Step 3: Build the Project

Spring Boot projects use Maven as the build tool.

Build the project using

```bash
mvn clean package
```

If the build completes successfully, Maven displays

```
BUILD SUCCESS
```

During the build process Maven performs the following tasks.

```
Clean Previous Build

↓

Download Dependencies

↓

Compile Source Code

↓

Run Unit Tests

↓

Package Application

↓

Create Executable JAR
```

---

# Step 4: Run the Application

Open

```
SpringLearnApplication.java
```

Right Click

↓

```
Run SpringLearnApplication
```

OR

Click the green **Run** button in IntelliJ IDEA.

Spring Boot starts the application automatically.

---

# Step 5: Verify Console Output

A successful execution displays output similar to the following.

```
INFO

START

...

Tomcat initialized with port 8080

...

Started SpringLearnApplication

END
```

The appearance of the **START** and **END** log messages confirms that the `main()` method executed successfully.

The message

```
Tomcat started on port 8080
```

confirms that the embedded web server is running.

---

# Output Verification

The following output verifies that the application started correctly.

| Verification | Expected Result |
|--------------|-----------------|
| START Log | Displayed |
| Spring Boot Banner | Displayed |
| Embedded Tomcat | Started |
| Port | 8080 |
| Spring Context | Initialized |
| SpringLearnApplication | Started Successfully |
| END Log | Displayed |

---

# Understanding the Console Output

When the application starts,

the console displays several messages.

Example

```
START
```

This is the custom log message added in the `main()` method.

---

```
Starting SpringLearnApplication
```

Spring Boot begins initialization.

---

```
No active profile set
```

The application uses the default profile because no custom profile has been configured.

---

```
Tomcat initialized with port 8080
```

Embedded Apache Tomcat is created.

---

```
Root WebApplicationContext initialized
```

Spring creates the IoC Container and ApplicationContext.

---

```
Started SpringLearnApplication
```

The application has started successfully.

---

```
END
```

The final custom log confirms that the `SpringApplication.run()` method completed.

---

# Screenshots to Capture

Capture the following screenshots for documentation.

| Screenshot | Description |
|------------|-------------|
| 01_Project_Structure.png | Complete project structure in IntelliJ |
| 02_Spring_Initializer.png | Spring Initializr configuration |
| 03_Maven_Dependencies.png | Maven dependencies in IntelliJ |
| 04_Application_Run.png | Successful application execution |
| 05_Console_Output.png | Console showing START, Tomcat, and END logs |

---

# Common Errors and Solutions

---

## Maven Dependencies Not Downloaded

### Error

```
Cannot resolve symbol
```

### Cause

Maven dependencies were not downloaded.

### Solution

```
Reload Maven Project
```

or execute

```bash
mvn clean install
```

---

## Java Version Error

### Error

```
Invalid Source Release
```

### Cause

Incorrect JDK version.

### Solution

Configure Project SDK as Java 21.

---

## Port Already in Use

### Error

```
Port 8080 was already in use
```

### Cause

Another application is using port 8080.

### Solution

Stop the application using port 8080 or change the server port in

```
application.properties
```

Example

```properties
server.port=9090
```

---

## Application Failed to Start

### Cause

Missing dependency or incorrect configuration.

### Solution

- Reload Maven.
- Check `pom.xml`.
- Verify project structure.
- Rebuild the project.

---

## Build Failure

### Error

```
BUILD FAILURE
```

### Solution

Execute

```bash
mvn clean package
```

again after resolving compilation errors.

---

# Advantages of Maven

- Automatic dependency management.
- Standard project structure.
- Easy project build.
- Plugin support.
- Reproducible builds.
- Simplified project maintenance.

---

# Advantages of Spring Boot

- Easy project setup.
- Auto Configuration.
- Embedded Tomcat.
- Starter Dependencies.
- Rapid Development.
- Production Ready Features.
- Easy Integration with Spring Framework.
- Minimal Configuration.
- Simplified Dependency Management.
- Faster Application Development.

---

# Advantages of Embedded Tomcat

- No separate installation required.
- Runs inside the application.
- Easy deployment.
- Simplifies development.
- Lightweight.
- Reduces server configuration.

---

# Interview Questions

## Basic

1. What is Spring Boot?
2. What is Spring Initializr?
3. What is Maven?
4. What is `pom.xml`?
5. What is `@SpringBootApplication`?
6. What is `SpringApplication.run()`?
7. What is Embedded Tomcat?
8. What is the purpose of `application.properties`?
9. What is Spring Boot DevTools?
10. What is the purpose of logging?

---

## Intermediate

11. Explain the Maven project structure.
12. What are starter dependencies?
13. What is Component Scanning?
14. What is Auto Configuration?
15. Explain Dependency Injection.
16. What is the Spring IoC Container?
17. What is ApplicationContext?
18. What happens internally when `SpringApplication.run()` is called?
19. What is the default port used by Spring Boot?
20. How does Maven download dependencies?

---

## Advanced

21. Explain the startup lifecycle of a Spring Boot application.
22. What is the difference between Spring Framework and Spring Boot?
23. Explain transitive dependency management.
24. What is the role of `spring-boot-starter-parent`?
25. How does Spring Boot configure Embedded Tomcat automatically?
26. What are Spring Beans?
27. How does Component Scanning work internally?
28. Explain the purpose of DevTools.
29. Why is Maven preferred over manually managing JAR files?
30. Explain the complete execution flow from `main()` to application startup.

---

# Key Learnings

After completing this exercise, the following concepts were understood.

- Creating a Spring Boot project using Spring Initializr.
- Understanding the standard Maven project structure.
- Using Maven for dependency management and project builds.
- Understanding the purpose of `pom.xml`.
- Understanding the role of `SpringLearnApplication.java`.
- Understanding the `@SpringBootApplication` annotation.
- Understanding `SpringApplication.run()`.
- Working with Embedded Apache Tomcat.
- Using Spring Boot DevTools.
- Adding and verifying application logs using SLF4J.
- Running and verifying a Spring Boot application successfully.

---

# Conclusion

This exercise successfully demonstrated how to create a **Spring Boot Web Project** using **Maven** and **Spring Initializr**. The project was configured with the **Spring Web** and **Spring Boot DevTools** dependencies, imported into IntelliJ IDEA, built using Maven, and executed successfully.

During the exercise, we explored the standard Maven project structure, the purpose of `pom.xml`, the responsibilities of `SpringLearnApplication.java`, the significance of the `@SpringBootApplication` annotation, and the internal working of `SpringApplication.run()`. We also verified the successful startup of the application by observing the embedded Apache Tomcat server and custom log messages.

This exercise serves as the foundation for all upcoming Spring Boot REST hands-ons. The project created here will be extended in future exercises to build REST controllers, web services, request handling mechanisms, and enterprise-level Spring Boot applications.

# Spring REST using Spring Boot 4

## CTS Digital Nurture 5.0 – Deep Skilling

### Week 3 – Spring REST using Spring Boot

**Exercise Name:** Spring_REST_using_Spring_Boot_4

---

# Author

**Name:** Grandhe Manikanta Sri Sai Kiran

**Program:** Cognizant Digital Nurture (DN 5.0)

**Technology Stack**

- Java 21
- Spring Boot
- Spring Web
- Maven
- REST API
- Embedded Tomcat

---

# Contents

- Introduction
- Objectives
- Prerequisites
- Folder Structure
- Spring Framework
- History of Spring
- Evolution of Spring
- Why Spring was Created
- Problems before Spring
- What is Spring Boot
- Why Spring Boot
- Spring Boot Architecture
- Spring Boot Features
- Spring Boot Advantages
- Spring Boot vs Spring Framework
- Enterprise Usage
- Summary

---

# Introduction

Spring REST is a module of the Spring Framework that allows developers to build RESTful Web Services quickly and efficiently.

Modern software applications rarely work in isolation. Mobile applications, web applications, desktop applications, smart TVs, IoT devices, banking applications, e-commerce systems, and cloud platforms all need to exchange information with one another.

Spring Boot provides an easy way to expose Java objects as REST APIs without requiring complex configuration.

In this CTS Digital Nurture hands-on, we will implement multiple REST services using Spring Boot and Maven while understanding the complete request-response lifecycle.

---

# Objectives

The objectives of this module are:

- Create a Spring Boot Web Project using Maven
- Understand Spring Boot project structure
- Develop RESTful Web Services
- Implement GET REST APIs
- Return Java objects as JSON
- Build layered architecture using Controller, Service, and DAO
- Test APIs using Browser and Postman
- Handle exceptions
- Implement REST best practices
- Understand DispatcherServlet
- Understand Embedded Tomcat
- Understand Spring MVC Architecture

---

# Learning Outcomes

After completing this module, you will be able to:

- Create Spring Boot projects
- Build REST APIs
- Understand HTTP requests and responses
- Work with JSON
- Create Controller classes
- Develop Service classes
- Develop DAO classes
- Load XML configuration
- Return Java Beans as JSON
- Test REST APIs using Postman
- Understand enterprise REST architecture

---

# Prerequisites

Before starting this module, the following concepts should already be completed.

✔ Java Fundamentals

✔ Object Oriented Programming

✔ Maven

✔ Spring Core

✔ Dependency Injection

✔ Spring Beans

✔ XML Configuration

✔ ApplicationContext

✔ IoC Container

---

# Software Requirements

| Software | Version |
|-----------|----------|
| Java | 21 |
| IntelliJ IDEA | Latest |
| Maven | 3.9+ |
| Spring Boot | 4 (or latest stable available) |
| Postman | Latest |
| Git | Latest |

---

# Folder Structure

```

Spring_REST_using_Spring_Boot_4

│

├── spring-rest-handson

│ │

│ ├── src

│ │ │

│ │ ├── main

│ │ │ │

│ │ │ ├── java

│ │ │ │

│ │ │ └── resources

│ │

│ ├── pom.xml

│

└── README.md

```

---

# What is Spring Framework?

Spring Framework is an open-source Java framework used to build enterprise applications.

It provides infrastructure support so that developers can focus on writing business logic instead of repetitive configuration code.

Spring offers solutions for:

- Dependency Injection
- Transaction Management
- MVC
- Security
- Data Access
- REST APIs
- Microservices
- Cloud Applications

---

# History of Spring Framework

Before Spring became popular, Java Enterprise applications were developed using Enterprise Java Beans (EJB).

EJB introduced many problems.

Developers had to:

- Write XML configurations
- Create Home Interfaces
- Create Remote Interfaces
- Configure Application Servers
- Deploy WAR/EAR files
- Write Boilerplate Code

Development became slow and difficult.

In 2002, Rod Johnson introduced the concepts that later became the Spring Framework.

In 2004, Spring Framework 1.0 was officially released.

Its goal was simple:

> Make Java Enterprise Development Simple.

---

# Evolution of Spring

| Year | Version | Major Improvement |
|------|----------|------------------|
| 2004 | Spring 1.0 | Dependency Injection |
| 2006 | Spring 2.x | XML Improvements |
| 2009 | Spring 3.x | Annotation Configuration |
| 2013 | Spring 4.x | Java 8 Support |
| 2017 | Spring 5.x | Reactive Programming |
| 2022+ | Spring 6.x | Jakarta EE |
| Current | Spring Boot | Rapid Development |

---

# Problems Before Spring Boot

Developers had to manually configure:

- Servlet
- DispatcherServlet
- web.xml
- Tomcat
- Logging
- Database
- Dependency Management
- Build Configuration
- Bean Configuration

Creating even a simple web application required hundreds of lines of configuration.

Example workflow:

1. Create Dynamic Web Project
2. Configure web.xml
3. Configure DispatcherServlet
4. Configure View Resolver
5. Configure Context Loader
6. Configure Tomcat
7. Add JAR files manually
8. Configure Logging
9. Configure Build Path

This process was time-consuming and error-prone.

---

# Why Spring Boot was Created

Spring Boot was introduced to simplify Spring application development.

Its primary goals are:

- Reduce configuration
- Eliminate boilerplate code
- Provide embedded servers
- Simplify dependency management
- Enable rapid application development
- Improve developer productivity

Instead of spending time on configuration, developers can focus on business logic.

---

# What is Spring Boot?

Spring Boot is an extension of the Spring Framework that provides production-ready features with minimal configuration.

It is built on top of the Spring Framework and follows the convention-over-configuration principle.

Spring Boot automatically configures many components based on the dependencies present in the project.

---

# Features of Spring Boot

- Auto Configuration
- Embedded Tomcat
- Embedded Jetty
- Embedded Undertow
- Spring Initializr Support
- Starter Dependencies
- Production-ready Features
- Health Checks
- Metrics
- Logging
- External Configuration
- DevTools
- REST API Support
- Microservices Support

---

# Why Developers Prefer Spring Boot

- Less Configuration
- Faster Development
- Easy Testing
- Built-in Server
- Easy Deployment
- Better Dependency Management
- Easy Integration with Databases
- Easy REST API Development
- Cloud Ready
- Enterprise Ready

---

# Spring Boot Architecture

```

                Client

                   │

            HTTP Request

                   │

         Embedded Tomcat

                   │

         DispatcherServlet

                   │

            Controller

                   │

             Service

                   │

                DAO

                   │

             Database/XML

                   │

            HTTP Response

```

---

# Enterprise Applications Using Spring Boot

Spring Boot is widely used in:

- Banking Applications
- E-Commerce Platforms
- Hospital Management Systems
- Insurance Systems
- ERP Solutions
- CRM Systems
- Airline Reservation Systems
- Government Portals
- Online Education Platforms
- Cloud-native Microservices

Major companies using Spring technologies include:

- Cognizant
- Accenture
- Infosys
- TCS
- Capgemini
- IBM
- Amazon
- Netflix
- VMware

---

# Advantages of Spring Boot

- Faster Development
- Minimal Configuration
- Easy Dependency Management
- Embedded Server
- Easy Testing
- Excellent Community Support
- Production Ready
- Easy REST API Development
- Easy Cloud Deployment
- Microservice Friendly

---

# Summary

In this first part of the README, we established the foundation for the Spring REST module by understanding:

- The purpose of Spring Framework
- The evolution of Spring
- Why Spring Boot was introduced
- The challenges it solved
- Its architecture and core features
- Typical enterprise use cases
- The overall goals of the CTS Spring REST hands-on exercises

The following sections will build on this foundation by covering REST fundamentals, HTTP, JSON, project structure, Maven, Spring MVC, DispatcherServlet, REST controllers, request handling, and the implementation of the hands-on exercises.

# REST (Representational State Transfer)

---

# What is REST?

REST stands for **Representational State Transfer**.

It is an architectural style used to develop web services that communicate over the HTTP protocol.

REST was introduced by **Roy Fielding** in his Ph.D. dissertation in the year **2000**.

REST is not:

- A programming language
- A framework
- A software
- A protocol

REST is simply a **set of architectural principles** used to design scalable web services.

---

# Why REST was Introduced?

Before REST became popular, enterprise applications mainly used **SOAP (Simple Object Access Protocol)**.

SOAP-based web services had several drawbacks:

- Complex XML request format
- Large message size
- Slow communication
- Difficult implementation
- Platform dependency
- Higher bandwidth usage

REST solved these issues by introducing:

- Lightweight communication
- HTTP-based operations
- JSON data format
- Simple URL structure
- Better scalability
- Improved performance

---

# REST Architecture

A REST application follows a client-server architecture.

```

            Client

                │

        HTTP Request

                │

        REST Web Service

                │

        Business Logic

                │

         Data Source

                │

        HTTP Response

                │

            Client

```

The client sends a request.

The server processes the request.

The server sends back a response.

---

# REST Components

A REST application mainly consists of:

- Client
- Server
- Resource
- URI
- HTTP Methods
- HTTP Request
- HTTP Response
- Representation

---

# Client

A client is any application that consumes a REST service.

Examples:

- Browser
- Android Application
- iOS Application
- React Application
- Angular Application
- Postman
- cURL
- Another Microservice

Example

```

Browser

↓

GET /countries

↓

Spring Boot

```

---

# Server

A server hosts the REST API.

In our hands-on,

Spring Boot acts as the server.

```

Spring Boot Application

↓

Embedded Tomcat

↓

Listening on Port 8083

```

---

# Resource

A resource is any data exposed by a REST service.

Examples

```

Country

Employee

Student

Book

Department

Customer

Order

```

Each resource is identified using a URI.

---

# URI (Uniform Resource Identifier)

A URI uniquely identifies a resource.

Examples

```

/country

/countries

/employees

/students

/books

/orders

```

REST APIs should use meaningful nouns instead of verbs.

Good

```

GET /countries

```

Bad

```

GET /getCountries

```

---

# HTTP Protocol

REST uses the HTTP protocol for communication.

HTTP defines how clients and servers exchange information.

Every REST API request is an HTTP request.

Every REST API response is an HTTP response.

---

# HTTP Request

An HTTP request contains:

```

Request Line

Headers

Body (Optional)

```

Example

```http
GET /hello HTTP/1.1
Host: localhost:8083
User-Agent: Mozilla/5.0
Accept: */*
```

---

# Request Line

The request line contains three parts.

```

HTTP Method

Resource

HTTP Version

```

Example

```

GET

/country

HTTP/1.1

```

---

# Request Headers

Headers provide additional information.

Examples

```

Host

Accept

Authorization

Content-Type

User-Agent

Accept-Language

```

Example

```http
Host: localhost:8083

Content-Type: application/json
```

---

# Request Body

Used mainly in:

- POST
- PUT
- PATCH

Example

```json
{
    "code":"IN",
    "name":"India"
}
```

GET requests generally do not contain a request body.

---

# HTTP Response

An HTTP response consists of:

```

Status Line

Headers

Body

```

Example

```http
HTTP/1.1 200 OK

Content-Type: application/json

{
    "code":"IN",
    "name":"India"
}
```

---

# Response Status Line

Contains

```

HTTP Version

Status Code

Status Message

```

Example

```

HTTP/1.1 200 OK

```

---

# HTTP Status Codes

## 200 OK

Request processed successfully.

```

GET /country

↓

200 OK

```

---

## 201 Created

A new resource has been created.

```

POST /countries

↓

201 Created

```

---

## 204 No Content

Request succeeded but no response body is returned.

---

## 400 Bad Request

Client sent invalid data.

Example

```

Country Code = A

```

---

## 401 Unauthorized

Authentication required.

---

## 403 Forbidden

User authenticated but not allowed.

---

## 404 Not Found

Requested resource not found.

Example

```

/country/ZZ

```

---

## 500 Internal Server Error

Unexpected error occurred on the server.

---

# Common HTTP Methods

| Method | Purpose |
|---------|---------|
| GET | Read data |
| POST | Create data |
| PUT | Update entire resource |
| PATCH | Update partial resource |
| DELETE | Delete resource |

---

# GET

Used to retrieve data.

Example

```

GET /countries

```

Returns

```json
[
  {
    "code":"IN",
    "name":"India"
  }
]
```

---

# POST

Creates a new resource.

Example

```

POST /countries

```

Request

```json
{
    "code":"JP",
    "name":"Japan"
}
```

---

# PUT

Updates an existing resource.

Example

```

PUT /countries/IN

```

---

# DELETE

Deletes a resource.

Example

```

DELETE /countries/IN

```

---

# JSON (JavaScript Object Notation)

REST services commonly exchange information using JSON.

Example

```json
{
    "code":"IN",
    "name":"India"
}
```

JSON is:

- Lightweight
- Human readable
- Language independent
- Easy to parse
- Faster than XML for many use cases

---

# XML vs JSON

| XML | JSON |
|------|------|
| Tag Based | Key Value |
| More Verbose | Compact |
| Larger Payload | Smaller Payload |
| Slower Parsing | Faster Parsing |
| More Complex | Easy to Read |

---

# REST URL Naming Guidelines

Good

```

/countries

/countries/IN

/employees

/departments

```

Avoid

```

/getCountry

/deleteCountry

/updateEmployee

/createDepartment

```

HTTP methods should express the action; the URL should represent the resource.

---

# REST Constraints

According to Roy Fielding, REST follows these constraints:

- Client-Server
- Stateless
- Cacheable
- Uniform Interface
- Layered System
- Code on Demand (optional)

---

## Stateless

Each request must contain all the information needed to process it.

The server should not rely on previous requests.

Example

```

Request 1

↓

Completed

↓

Request 2

↓

Processed independently

```

---

## Cacheable

Responses can be cached when appropriate to improve performance and reduce server load.

---

## Uniform Interface

All resources should be accessed consistently using standard HTTP methods and meaningful URIs.

---

## Layered System

The client does not need to know whether it is communicating directly with the application or through intermediate components like gateways, proxies, or load balancers.

```

Client

↓

Load Balancer

↓

API Gateway

↓

Spring Boot

↓

Database

```

---

# REST in Enterprise Applications

REST is widely used in:

- Banking APIs
- E-Commerce Platforms
- Payment Gateways
- Social Media Platforms
- Hospital Management Systems
- Airline Reservation Systems
- Cloud Services
- Government Portals
- Inventory Systems
- ERP Solutions

---

# Summary

In this section, we covered:

- REST fundamentals
- Client-server architecture
- Resources and URIs
- HTTP protocol
- HTTP requests and responses
- Status codes
- HTTP methods
- JSON
- REST constraints
- REST URL naming guidelines
- Enterprise use of REST

These concepts form the foundation for implementing RESTful Web Services in the upcoming Spring Boot hands-on exercises.

# Spring Web

---

# What is Spring Web?

Spring Web is a module of the Spring Framework that is used to develop web applications and RESTful Web Services.

It provides all the necessary components required to receive HTTP requests, process them, and send HTTP responses.

Without Spring Web, developers have to manually create Servlets, configure web.xml, and manage request routing.

Spring Web simplifies all these tasks.

---

# Why Do We Need Spring Web?

Consider an application where users access the following URLs.

```

http://localhost:8083/login

http://localhost:8083/register

http://localhost:8083/products

http://localhost:8083/orders

```

Some component should:

- Receive the request
- Identify the URL
- Execute the correct Java method
- Prepare the response
- Send it back to the client

Spring Web performs all these operations automatically.

---

# Spring Web Architecture

```

                Browser

                    │

                    │ HTTP Request

                    ▼

          Embedded Tomcat Server

                    │

                    ▼

          DispatcherServlet

                    │

                    ▼

            Controller Layer

                    │

                    ▼

             Service Layer

                    │

                    ▼

               DAO Layer

                    │

                    ▼

             Database / XML

                    │

                    ▼

            HTTP Response

                    │

                    ▼

                 Browser

```

---

# What is Spring MVC?

Spring MVC stands for

**Spring Model View Controller**

It is one of the most popular modules of the Spring Framework.

MVC divides the application into three layers.

```

Model

View

Controller

```

This separation makes applications easier to develop and maintain.

---

# MVC Architecture

```

               User

                 │

                 ▼

             Controller

                 │

                 ▼

              Service

                 │

                 ▼

                Model

                 │

                 ▼

             Database

```

---

# Model

The Model represents application data.

Examples

```

Country

Employee

Student

Department

Book

```

Example

```java
public class Country {

    private String code;

    private String name;

}
```

---

# View

The View represents what the user sees.

Examples

```

HTML

JSP

Thymeleaf

React

Angular

```

In REST applications, JSON acts as the view because data is returned instead of HTML pages.

---

# Controller

The Controller receives HTTP requests and returns HTTP responses.

Example

```java
@RestController
public class CountryController {

}
```

---

# Embedded Tomcat

---

## What is Tomcat?

Tomcat is a Web Server and Servlet Container.

It is responsible for:

- Listening for HTTP requests
- Running Servlets
- Returning HTTP responses

---

## Before Spring Boot

Developers had to:

- Download Tomcat
- Install Tomcat
- Configure Tomcat
- Deploy WAR files manually

Development was slower.

---

## With Spring Boot

Spring Boot provides an Embedded Tomcat.

```

Run Application

↓

Tomcat Starts Automatically

↓

Ready to Receive Requests

```

No separate installation is required.

---

# Embedded Server Options

Spring Boot supports multiple embedded servers.

| Server | Description |
|----------|-------------|
| Tomcat | Default Server |
| Jetty | Lightweight Server |
| Undertow | High Performance Server |

---

# Spring Initializr

---

## What is Spring Initializr?

Spring Initializr is an online tool used to generate Spring Boot projects.

Website

```

https://start.spring.io

```

It automatically creates

- Maven Project
- Project Structure
- Dependencies
- Maven Wrapper
- Application Class
- Configuration Files

---

# Information Required

While creating a project,

Spring Initializr asks for

```

Project

Language

Spring Boot Version

Group

Artifact

Package Name

Packaging

Java Version

Dependencies

```

---

# Example

```

Project

Maven

Language

Java

Group

com.cognizant

Artifact

spring-rest-handson

Packaging

Jar

Java

21

Dependency

Spring Web

```

---

# Generated Project Structure

```

spring-rest-handson

│

├── src

│

├── main

│   ├── java

│   └── resources

│

├── test

│

├── pom.xml

│

├── mvnw

│

└── mvnw.cmd

```

---

# Maven

---

## What is Maven?

Maven is a Build Automation Tool.

It helps in

- Dependency Management
- Project Build
- Testing
- Packaging
- Deployment

---

# Why Maven?

Suppose your application needs

- Spring Boot
- Jackson
- Tomcat
- Logging
- JUnit

Instead of downloading every JAR manually,

Maven downloads everything automatically.

---

# Maven Lifecycle

```

validate

↓

compile

↓

test

↓

package

↓

verify

↓

install

↓

deploy

```

---

# pom.xml

The heart of every Maven project.

It contains

- Dependencies
- Plugins
- Java Version
- Build Configuration

Example

```xml
<dependencies>

    <dependency>

        <groupId>org.springframework.boot</groupId>

        <artifactId>spring-boot-starter-web</artifactId>

    </dependency>

</dependencies>
```

---

# Spring Boot Starter

A Starter is a predefined collection of dependencies.

Instead of adding

- Spring MVC
- Jackson
- Servlet API
- Validation
- Logging

one by one,

we simply add

```xml
spring-boot-starter-web
```

Everything is downloaded automatically.

---

# spring-boot-starter-web Includes

Some important libraries included are

```

Spring MVC

Spring Core

Spring Beans

Spring Context

Embedded Tomcat

Jackson

Spring Web

Logging

Validation Support

```

---

# Dependency Hierarchy

```

spring-boot-starter-web

│

├── spring-web

├── spring-webmvc

├── spring-core

├── spring-context

├── spring-beans

├── jackson-databind

├── tomcat-embed-core

├── tomcat-embed-websocket

├── slf4j

└── logback

```

---

# Maven Wrapper

The generated project contains

```

mvnw

mvnw.cmd

```

These files ensure that everyone working on the project uses the correct Maven version without installing Maven separately.

---

# Resources Folder

```

src/main/resources

```

Contains

- application.properties
- XML Configuration Files
- Static Resources
- Templates
- Messages
- Configuration Files

---

# Java Source Folder

```

src/main/java

```

Contains

- Controllers
- Services
- DAO
- Models
- Configuration Classes

---

# Test Folder

```

src/test/java

```

Contains

- Unit Tests
- Integration Tests
- MockMVC Tests

---

# Typical Spring Boot Project Structure

```

src

├── main

│   ├── java

│   │

│   ├── controller

│   ├── service

│   ├── dao

│   ├── model

│   └── config

│

└── resources

    ├── application.properties

    ├── static

    ├── templates

    └── *.xml

```

---

# Enterprise Usage

Large organizations like

- Cognizant
- TCS
- Infosys
- Accenture
- Capgemini
- IBM
- Amazon

use Maven and Spring Boot because they

- simplify dependency management
- standardize project structure
- automate builds
- integrate easily with Jenkins, GitHub Actions, Azure DevOps, and other CI/CD tools
- improve collaboration across development teams

---

# Best Practices

- Follow Maven Standard Directory Structure.
- Keep dependencies up to date.
- Add only required starters.
- Separate Controller, Service, DAO, and Model packages.
- Keep configuration in `application.properties` or `application.yml`.
- Use Maven Wrapper (`mvnw`) for consistent builds.

---

# Summary

In this section, we covered:

- Spring Web
- Spring MVC
- MVC Architecture
- Embedded Tomcat
- Spring Initializr
- Maven
- Maven Lifecycle
- `pom.xml`
- Spring Boot Starter Web
- Dependency Hierarchy
- Standard Project Structure
- Enterprise Best Practices

These concepts provide the foundation for understanding how a Spring Boot REST application is structured before implementing controllers and REST endpoints.

# @SpringBootApplication Annotation

---

# Introduction

Every Spring Boot application starts from a single Java class that contains the `main()` method.

This class acts as the entry point of the application.

Example

```java
@SpringBootApplication
public class SpringRestHandsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestHandsonApplication.class, args);
    }

}
```

This class is automatically generated by **Spring Initializr**.

---

# What is @SpringBootApplication?

`@SpringBootApplication` is the main annotation of every Spring Boot application.

It tells Spring Boot:

- This is the starting point of the application.
- Perform Auto Configuration.
- Scan Spring Components.
- Enable Spring Boot configuration.

Without this annotation, Spring Boot cannot automatically configure the application.

---

# Definition

> `@SpringBootApplication` is a convenience annotation that combines three important Spring annotations into one.

These three annotations are:

```
@Configuration

@EnableAutoConfiguration

@ComponentScan
```

---

# Internal Structure

```
@SpringBootApplication

        │

        ▼

 ┌──────────────────────┐

 @Configuration

 @EnableAutoConfiguration

 @ComponentScan

 └──────────────────────┘
```

---

# @Configuration

This annotation tells Spring that the class contains bean definitions.

Example

```java
@Configuration
public class AppConfig {

}
```

Spring loads this class during application startup.

---

# @EnableAutoConfiguration

This enables Spring Boot's automatic configuration mechanism.

Spring Boot checks:

- Available JAR files
- Dependencies
- Configuration properties

Based on them, it automatically configures the application.

Example

If Spring Boot detects

```
spring-boot-starter-web
```

It automatically configures:

- DispatcherServlet
- Tomcat
- Jackson
- Spring MVC
- REST Support

No manual configuration is required.

---

# @ComponentScan

Spring searches for classes annotated with

```
@Component

@Service

@Repository

@Controller

@RestController

@Configuration
```

and automatically creates objects (beans) for them.

---

# Component Scan Example

```
com.cognizant.springlearn

│

├── controller

│     CountryController

│

├── service

│     CountryService

│

├── dao

│     CountryDao

│

└── model

      Country
```

During startup,

Spring scans all these packages automatically.

---

# What Happens When Application Starts?

When

```java
SpringApplication.run(
SpringRestHandsonApplication.class,
args);
```

is executed,

Spring Boot performs the following steps.

```
Start JVM

↓

Load Main Class

↓

Read Annotations

↓

Create Application Context

↓

Scan Packages

↓

Create Beans

↓

Auto Configure Spring

↓

Start Embedded Tomcat

↓

Register DispatcherServlet

↓

Application Ready
```

---

# SpringApplication.run()

---

## Purpose

Starts the complete Spring Boot application.

Example

```java
SpringApplication.run(
SpringRestHandsonApplication.class,
args);
```

---

# Internal Working

```
SpringApplication.run()

↓

Create SpringApplication Object

↓

Prepare Environment

↓

Read application.properties

↓

Create ApplicationContext

↓

Component Scan

↓

Bean Creation

↓

Dependency Injection

↓

Auto Configuration

↓

Start Embedded Server

↓

Application Ready
```

---

# ApplicationContext

ApplicationContext is the Spring IoC Container.

Responsibilities

- Creates Beans
- Stores Beans
- Injects Dependencies
- Manages Bean Lifecycle
- Provides Bean Lookup

---

# IoC Container

IoC stands for

```
Inversion of Control
```

Instead of

```
Developer creates objects
```

Spring creates objects.

```
Developer

↓

Spring Container

↓

Bean Objects

↓

Dependency Injection
```

---

# Bean

A Bean is an object managed by the Spring Container.

Example

```java
@RestController
public class CountryController {

}
```

Spring automatically creates

```
CountryController Object
```

This object becomes a Bean.

---

# Bean Creation Flow

```
@ComponentScan

↓

Find Controller

↓

Find Service

↓

Find DAO

↓

Create Objects

↓

Store in IoC Container
```

---

# Dependency Injection

Suppose

```
CountryController

↓

CountryService

↓

CountryDao
```

Instead of writing

```java
CountryService service =
new CountryService();
```

Spring automatically injects it.

Example

```java
@Autowired
private CountryService countryService;
```

---

# Bean Lifecycle

```
Class Loaded

↓

Bean Created

↓

Dependencies Injected

↓

Ready to Use

↓

Destroyed
```

---

# DispatcherServlet

DispatcherServlet is the Front Controller of Spring MVC.

Every HTTP request first reaches DispatcherServlet.

---

# Request Flow

```
Browser

↓

GET /country

↓

DispatcherServlet

↓

CountryController

↓

CountryService

↓

CountryDao

↓

Country Object

↓

DispatcherServlet

↓

JSON Response

↓

Browser
```

---

# Why DispatcherServlet?

Instead of every controller handling requests independently,

DispatcherServlet acts as a single entry point.

Advantages

- Centralized request handling
- Better security
- Better logging
- Easy exception handling
- URL mapping
- Request routing

---

# Auto Configuration

Spring Boot automatically configures components based on dependencies.

Example

Dependency

```
spring-boot-starter-web
```

Automatically Configures

```
Tomcat

DispatcherServlet

Jackson

Spring MVC

Error Controller

Message Converters
```

---

# Bean Naming Convention

Example

```java
@RestController
public class CountryController {

}
```

Default Bean Name

```
countryController
```

Spring converts

```
CountryController

↓

countryController
```

---

# Spring Boot Startup Sequence

```
main()

↓

SpringApplication.run()

↓

Read Configuration

↓

Create Environment

↓

Create IoC Container

↓

Component Scan

↓

Create Beans

↓

Inject Dependencies

↓

Auto Configure

↓

Start Embedded Tomcat

↓

Register DispatcherServlet

↓

Listening on Port 8083
```

---

# Memory Diagram

```
JVM

────────────────────────────

Heap Memory

────────────────────────────

ApplicationContext

│

├── CountryController Bean

├── CountryService Bean

├── CountryDao Bean

├── DispatcherServlet

└── Other Spring Beans

────────────────────────────

Method Area

────────────────────────────

Class Metadata

SpringRestHandsonApplication

CountryController

CountryService

CountryDao

Country

────────────────────────────
```

---

# Execution Flow Diagram

```
main()

↓

SpringApplication.run()

↓

@SpringBootApplication

↓

Component Scan

↓

ApplicationContext

↓

Beans Created

↓

Tomcat Started

↓

HTTP Request Received

↓

DispatcherServlet

↓

Controller

↓

Service

↓

DAO

↓

Response Generated

↓

HTTP Response Sent
```

---

# Common Mistakes

### 1. Placing the Main Class in the Wrong Package

Incorrect

```
com.demo

↓

controller package outside scan path
```

Spring cannot discover controllers.

---

### 2. Missing @SpringBootApplication

Without this annotation,

Spring Boot will not start correctly.

---

### 3. Incorrect Component Scan Location

Always place the main application class in the root package.

Example

```
com.cognizant.springlearn
```

Sub-packages

```
controller

service

dao

model
```

are automatically scanned.

---

### 4. Manual Object Creation

Avoid

```java
CountryService service =
new CountryService();
```

Instead

```java
@Autowired
private CountryService service;
```

---

# Best Practices

- Keep the application class in the root package.
- Use `@SpringBootApplication` only once.
- Do not create Spring-managed objects using `new`.
- Organize packages into `controller`, `service`, `dao`, `model`, and `config`.
- Keep business logic out of controllers.
- Prefer constructor injection in production projects (although `@Autowired` field injection is common in training exercises).

---

# Interview Questions

### 1. What is `@SpringBootApplication`?

A convenience annotation that combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.

---

### 2. What is `SpringApplication.run()`?

It bootstraps the Spring Boot application by creating the application context, performing auto-configuration, creating beans, and starting the embedded server.

---

### 3. What is the role of `@ComponentScan`?

It scans the specified package and its sub-packages for Spring-managed components such as controllers, services, repositories, and configuration classes.

---

### 4. What is DispatcherServlet?

The front controller in Spring MVC that receives all incoming HTTP requests and dispatches them to the appropriate controller methods.

---

### 5. What is an IoC Container?

A container that creates, manages, and injects Spring beans instead of requiring the developer to instantiate them manually.

---

# Summary

In this section, we covered:

- `@SpringBootApplication`
- `@Configuration`
- `@EnableAutoConfiguration`
- `@ComponentScan`
- `SpringApplication.run()`
- ApplicationContext
- IoC Container
- Spring Beans
- Dependency Injection
- Bean Lifecycle
- DispatcherServlet
- Auto Configuration
- Startup Sequence
- Memory Diagram
- Execution Flow
- Best Practices
- Common Mistakes
- Interview Questions

These concepts explain what happens internally from the moment the application starts until it is ready to receive HTTP requests, providing the foundation for implementing REST controllers and APIs in the subsequent hands-on exercises.

# Implementing the First RESTful Web Service

# Hello World RESTful Web Service

The first REST API in this CTS hands-on is a simple **Hello World** service.

Although the response is just a simple string, this exercise introduces the complete REST request processing pipeline.

CTS Exercise Details

```
Method      : GET
URL         : /hello
Controller  : HelloController
Method      : sayHello()
Response    : Hello World!!
```

---

# Folder Structure

```
spring-rest-handson

│

├── src

│   ├── main

│   │

│   ├── java

│   │

│   │   └── com

│   │       └── cognizant

│   │           └── springlearn

│   │

│   │               controller

│   │                   HelloController.java

│   │

│   └── resources

│        application.properties
```

---

# HelloController

```java
package com.cognizant.springlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!!";
    }

}
```

---

# Understanding @RestController

```
@RestController
```

This annotation tells Spring

```
This class contains REST APIs.
```

Whenever a request arrives,

Spring searches for methods inside this class.

---

# Internal Working

```
@RestController

↓

Spring registers bean

↓

Bean stored in IoC Container

↓

DispatcherServlet knows this class

↓

Ready to receive requests
```

---

# Difference Between @Controller and @RestController

| @Controller | @RestController |
|-------------|----------------|
| Returns View | Returns Data |
| Used for JSP | Used for REST APIs |
| HTML Response | JSON/String Response |

---

# @GetMapping

```
@GetMapping("/hello")
```

maps

```
GET

↓

/hello

↓

sayHello()
```

Only HTTP GET requests invoke this method.

---

# URL Mapping

```
Browser

↓

GET

↓

http://localhost:8083/hello

↓

HelloController

↓

sayHello()

↓

Hello World!!
```

---

# Request Flow

```
Client

↓

HTTP GET

↓

Embedded Tomcat

↓

DispatcherServlet

↓

Handler Mapping

↓

HelloController

↓

sayHello()

↓

String Returned

↓

HTTP Response

↓

Client
```

---

# Handler Mapping

Spring maintains a mapping table.

```
URL

↓

Controller

↓

Method
```

Example

```
/hello

↓

HelloController

↓

sayHello()
```

DispatcherServlet checks this mapping.

---

# Browser Execution

```
Browser

↓

Enter URL

↓

HTTP GET Request

↓

localhost:8083

↓

Tomcat

↓

DispatcherServlet

↓

HelloController

↓

sayHello()

↓

Return String

↓

Browser displays

Hello World!!
```

---

# Postman Execution

```
Postman

↓

GET

↓

localhost:8083/hello

↓

Spring Boot

↓

HelloController

↓

Hello World!!
```

---

# What Happens Internally?

```
Application Starts

↓

Embedded Tomcat Starts

↓

DispatcherServlet Registered

↓

Controller Bean Created

↓

Request Received

↓

DispatcherServlet Receives Request

↓

Checks URL Mapping

↓

Finds HelloController

↓

Calls sayHello()

↓

Returns String

↓

Writes Response

↓

Browser Receives Response
```

---

# DispatcherServlet Flow

```
Incoming Request

↓

DispatcherServlet

↓

Handler Mapping

↓

Controller

↓

Method

↓

Return Value

↓

Response Converter

↓

HTTP Response
```

---

# Request Processing Pipeline

```
Browser

↓

GET /hello

↓

TCP Connection

↓

Tomcat

↓

DispatcherServlet

↓

Request Mapping

↓

HelloController

↓

sayHello()

↓

Return String

↓

HTTP Response

↓

Browser
```

---

# Why No JSON Here?

Current Method

```java
public String sayHello()
```

returns

```
String
```

Therefore response

```
Hello World!!
```

No object exists.

Hence

No JSON conversion happens.

---

# Returning Object Instead

Suppose

```java
public Country getCountry()
```

returns

```java
Country

code = IN

name = India
```

Spring automatically converts

```
Country Object

↓

JSON
```

Result

```json
{
   "code":"IN",
   "name":"India"
}
```

This automatic conversion is performed by Jackson.

---

# Jackson

Jackson is the default JSON library used by Spring Boot.

It converts

```
Java Object

↓

JSON

```

and

```
JSON

↓

Java Object
```

No additional code is required.

---

# HTTP Request

Example

```http
GET /hello HTTP/1.1

Host: localhost:8083

User-Agent: Chrome
```

---

# HTTP Response

```http
HTTP/1.1 200 OK

Content-Type: text/plain;charset=UTF-8

Hello World!!
```

---

# HTTP Status

Current API returns

```
200 OK
```

Meaning

```
Request Successful
```

---

# Browser Output

```
Hello World!!
```

---

# Postman Output

```
Hello World!!
```

---

# Console Output

```
Tomcat started on port(s): 8083

Started SpringRestHandsonApplication
```

---

# Memory Diagram

```
JVM

──────────────────────────

Heap

ApplicationContext

│

├── DispatcherServlet

├── HelloController Bean

├── Handler Mapping

├── Message Converter

└── Other Spring Beans

──────────────────────────
```

---

# Sequence Diagram

```
Browser

│

│ GET /hello

▼

DispatcherServlet

│

▼

Handler Mapping

│

▼

HelloController

│

▼

sayHello()

│

▼

"Hello World!!"

│

▼

DispatcherServlet

│

▼

HTTP Response

│

▼

Browser
```

---

# Advantages

- Very simple implementation
- No Servlet coding
- No web.xml
- Automatic URL mapping
- Easy testing
- Production ready
- Embedded server support
- Annotation-based configuration

---

# Common Mistakes

### Wrong URL

```
localhost:8083/Hello

❌
```

Correct

```
localhost:8083/hello

✔
```

---

### Wrong HTTP Method

```
POST

❌
```

Correct

```
GET

✔
```

---

### Missing @RestController

Without

```
@RestController
```

Spring cannot expose the method as a REST API.

---

### Missing @GetMapping

Without URL mapping

```
DispatcherServlet

↓

Cannot locate method

↓

404 Not Found
```

---

### Wrong Port

Current application

```
8083
```

Requesting

```
8080

↓

Connection Refused
```

---

# Enterprise Usage

The Hello World example is only for learning.

Real enterprise controllers expose APIs such as

```
GET /employees

GET /countries

GET /orders

POST /customers

PUT /products

DELETE /accounts
```

Every enterprise REST API follows the same lifecycle demonstrated by this simple example.

---

# Interview Questions

### 1. What is @RestController?

A specialization of `@Controller` that automatically serializes return values into the HTTP response body.

---

### 2. What is @GetMapping?

An annotation that maps HTTP GET requests to a controller method.

---

### 3. Which component receives every HTTP request first?

DispatcherServlet.

---

### 4. Which server starts automatically in Spring Boot?

Embedded Apache Tomcat (by default).

---

### 5. Which library converts Java objects into JSON?

Jackson.

---

### 6. What HTTP status code is returned for a successful GET request?

200 OK.

---

### 7. What happens if no matching URL is found?

Spring returns **404 Not Found**.

---

# Best Practices

- Use meaningful endpoint names.
- Follow REST naming conventions.
- Keep controllers lightweight.
- Move business logic to the Service layer.
- Return appropriate HTTP status codes.
- Use logging instead of `System.out.println()` in production.
- Test APIs using both a browser (for simple GET requests) and Postman.

---

# Summary

In this exercise, we implemented our first RESTful Web Service using Spring Boot. We created a `HelloController` with a `GET /hello` endpoint that returns a simple text response. Along the way, we saw how Spring Boot registers the controller, how `DispatcherServlet` routes incoming requests, how `@GetMapping` maps URLs to methods, and how the server returns an HTTP response. Although the response is a plain string, the same request-processing pipeline is used for all REST APIs, making this exercise the foundation for the upcoming Country Web Service and other REST endpoints.

# RESTful Web Service Lifecycle

---

# Complete Lifecycle of a REST API

Every REST API developed using Spring Boot follows a predefined execution lifecycle.

Even though our first API returns only

```
Hello World!!
```

internally Spring Boot executes dozens of operations before sending the response.

Understanding this lifecycle is essential for debugging, interviews, and enterprise application development.

---

# Complete Execution Flow

```

Application Starts

↓

Spring Boot Starts

↓

IoC Container Created

↓

Embedded Tomcat Starts

↓

DispatcherServlet Registered

↓

Controller Beans Created

↓

Application Ready

↓

Browser Sends Request

↓

DispatcherServlet Receives Request

↓

Handler Mapping

↓

Controller Method

↓

Business Logic

↓

Return Value

↓

HTTP Response

↓

Browser Displays Output

```

---

# Layered Architecture

A Spring Boot REST application follows a layered architecture.

```

                Client

                  │

                  ▼

          Controller Layer

                  │

                  ▼

           Service Layer

                  │

                  ▼

              DAO Layer

                  │

                  ▼

         Database / XML File

```

For the Hello World example, only the Controller layer is used.

In upcoming CTS exercises, all four layers will be implemented.

---

# Current Project Architecture

```

spring-rest-handson

│

├── controller

│      HelloController

│

└── SpringRestHandsonApplication

```

---

# Upcoming Architecture

After completing all Spring REST hands-ons, the project will evolve into:

```

spring-rest-handson

│

├── controller

│      HelloController

│      CountryController

│

├── service

│      CountryService

│

├── dao

│      CountryDao

│

├── model

│      Country

│

├── resources

│      country.xml

│

└── SpringRestHandsonApplication

```

---

# Layer Responsibilities

## Controller

Responsible for

- Receiving HTTP Requests
- Calling Service Layer
- Returning HTTP Responses

---

## Service

Responsible for

- Business Logic
- Data Processing
- Validations
- Calling DAO Layer

---

## DAO

Responsible for

- Reading Data
- Writing Data
- Database Interaction
- XML Configuration Access

---

## Model

Represents application data.

Example

```

Country

Employee

Department

Student

```

---

# Browser Request Flow

```

Chrome Browser

↓

GET

↓

localhost:8083/hello

↓

TCP Connection

↓

Tomcat

↓

DispatcherServlet

↓

HelloController

↓

sayHello()

↓

Return String

↓

HTTP Response

↓

Browser

```

---

# Postman Request Flow

```

Postman

↓

GET

↓

localhost:8083/hello

↓

DispatcherServlet

↓

Controller

↓

Response

↓

Postman

```

---

# Browser vs Postman

| Browser | Postman |
|----------|----------|
| Human Interaction | API Testing |
| Limited HTTP Support | Full HTTP Support |
| Mainly GET | GET, POST, PUT, DELETE |
| UI Rendering | Raw Response |

---

# URL Structure

Current API

```

http://localhost:8083/hello

```

Breakdown

```

http

↓

Protocol

localhost

↓

Host

8083

↓

Port

hello

↓

Resource

```

---

# Port Number

Spring Boot starts Tomcat on

```

8083

```

because

```
application.properties
```

contains

```properties
server.port=8083
```

Without this,

Spring Boot starts on

```

8080

```

---

# Message Converter

Spring Boot contains

```

HttpMessageConverter

```

Responsibilities

```

Java Object

↓

JSON

```

and

```

JSON

↓

Java Object

```

---

# Response Types

Spring Boot can return

```

String

JSON

XML

Images

Files

PDF

Byte Stream

```

---

# Content-Type

Hello World API

```

Content-Type

↓

text/plain

```

Country API

```

Content-Type

↓

application/json

```

---

# HTTP Headers

Example

```

Host

Content-Type

Content-Length

Accept

Authorization

Cache-Control

```

Headers provide additional metadata.

---

# Logging

In enterprise applications,

every REST API is logged.

Example

```

START

↓

Request Received

↓

Business Logic

↓

Response Generated

↓

END

```

CTS also recommends adding logging to controller methods in subsequent exercises. :contentReference[oaicite:0]{index=0}

---

# API Testing

REST APIs should be tested using

- Browser
- Postman
- cURL
- MockMVC

CTS progressively introduces these testing methods through the Spring REST hands-ons. 

---

# Error Handling

Typical HTTP Errors

```

200

Success

```

```

400

Bad Request

```

```

401

Unauthorized

```

```

403

Forbidden

```

```

404

Not Found

```

```

500

Internal Server Error

```

---

# Future Enhancements

The next CTS exercises extend the Hello World API with:

```

Country API

↓

Country List

↓

Country by Code

↓

Exception Handling

↓

MockMVC Testing

↓

POST

↓

PUT

↓

DELETE

```

---

# Debugging Checklist

If API is not working,

check the following.

### Application Running

```

Tomcat Started

```

---

### Correct Port

```

8083

```

---

### Correct URL

```

http://localhost:8083/hello

```

---

### Correct Annotation

```

@RestController

```

---

### Correct Mapping

```

@GetMapping("/hello")

```

---

### Package Structure

```

controller

↓

HelloController

```

---

### Build Successful

```

BUILD SUCCESS

```

---

### Maven Dependencies

Ensure

```

spring-boot-starter-web

```

exists inside

```

pom.xml

```

---

# Screenshots to Capture

For this exercise, capture:

### Screenshot 1

Project Structure

```

spring-rest-handson

```

---

### Screenshot 2

HelloController.java

---

### Screenshot 3

SpringRestHandsonApplication.java

---

### Screenshot 4

Application Running

```

Tomcat started on port(s): 8083

```

---

### Screenshot 5

Browser Output

```

http://localhost:8083/hello

```

Output

```

Hello World!!

```

---

### Screenshot 6

Postman Output

```

GET

http://localhost:8083/hello

```

Output

```

Hello World!!

```

---

### Screenshot 7

HTTP Headers (Browser Network Tab)

---

### Screenshot 8

HTTP Headers (Postman)

---

# Git Commands

After completing this exercise:

```bash
git status

git add .

git commit -m "Week 3 - Exercise 2.1: Implement Hello World RESTful Web Service"

git push origin main
```

---

# Revision Notes

- Spring Boot starts an Embedded Tomcat server.
- `@SpringBootApplication` is the application entry point.
- `@RestController` exposes REST endpoints.
- `@GetMapping` maps HTTP GET requests.
- DispatcherServlet handles all incoming requests.
- Handler Mapping locates the appropriate controller method.
- `HelloController` returns a plain text response.
- A successful request returns **HTTP 200 OK**.
- The browser and Postman can both consume GET endpoints.
- This exercise forms the foundation for all subsequent REST services.

---

# Cheat Sheet

| Annotation | Purpose |
|------------|---------|
| `@SpringBootApplication` | Starts Spring Boot application |
| `@RestController` | Creates REST Controller |
| `@GetMapping` | Maps GET request |
| `SpringApplication.run()` | Boots the application |

| URL | Response |
|-----|----------|
| `/hello` | Hello World!! |

| HTTP Method | Purpose |
|-------------|---------|
| GET | Retrieve Data |

---

# Frequently Asked Questions (FAQs)

### Q1. Why does `/hello` return plain text instead of JSON?

Because the controller method returns a `String`. When a method returns an object (such as `Country`), Spring Boot automatically converts it to JSON using Jackson.

---

### Q2. Why do we need `@RestController`?

It tells Spring that the class contains REST endpoints and that return values should be written directly to the HTTP response body.

---

### Q3. Can I access the API from a browser?

Yes. Since this exercise uses a GET request, entering `http://localhost:8083/hello` in the browser is sufficient.

---

### Q4. Why is Postman still useful?

Postman supports all HTTP methods (GET, POST, PUT, DELETE), custom headers, authentication, and request bodies, making it ideal for testing REST APIs.

---

# Conclusion

The Hello World RESTful Web Service is the first practical step in building REST APIs with Spring Boot. Although the implementation is simple, it introduces the complete request lifecycle, Spring MVC request mapping, the role of `DispatcherServlet`, and the use of `@RestController` and `@GetMapping`.

All subsequent CTS Spring REST exercises—Country Web Service, Get All Countries, Country by Code, exception handling, MockMVC testing, and later POST/PUT/DELETE operations—are built on the same architecture and execution flow introduced here.

# Internal Working of Spring Boot REST

---

# What Happens After We Press Run?

When we execute

```java
public static void main(String[] args) {
    SpringApplication.run(SpringRestHandsonApplication.class, args);
}
```

many internal operations happen before our application becomes ready.

The complete startup flow is shown below.

```

Run Application

↓

JVM Starts

↓

Load Main Class

↓

Read @SpringBootApplication

↓

Create Spring Application

↓

Read application.properties

↓

Create IoC Container

↓

Component Scan

↓

Create Beans

↓

Inject Dependencies

↓

Auto Configuration

↓

Embedded Tomcat Starts

↓

DispatcherServlet Registered

↓

Ready to Accept HTTP Requests

```

---

# Internal Working of REST Request

When the browser requests

```
http://localhost:8083/hello
```

the request follows this path.

```

Browser

↓

DNS Lookup

↓

TCP Connection

↓

HTTP Request

↓

Embedded Tomcat

↓

DispatcherServlet

↓

Handler Mapping

↓

HelloController

↓

sayHello()

↓

Return Value

↓

HttpMessageConverter

↓

HTTP Response

↓

Browser

```

---

# DispatcherServlet Complete Workflow

```

Incoming Request

↓

DispatcherServlet

↓

HandlerMapping

↓

Find Matching URL

↓

Controller

↓

Method Invocation

↓

Return Value

↓

Message Converter

↓

HTTP Response

```

DispatcherServlet is called the **Front Controller** because every request passes through it.

---

# Handler Mapping

HandlerMapping stores the mapping between URLs and controller methods.

Example

```

URL

↓

/hello

↓

Controller

↓

HelloController

↓

Method

↓

sayHello()

```

Whenever a request comes,

DispatcherServlet asks HandlerMapping

```
Which controller should process this URL?
```

---

# Handler Adapter

After HandlerMapping identifies the controller,

HandlerAdapter invokes the appropriate Java method.

```

DispatcherServlet

↓

HandlerAdapter

↓

HelloController

↓

sayHello()

```

---

# HttpMessageConverter

After controller execution,

Spring converts the return value into HTTP response.

If return type

```
String
```

Response

```
Hello World!!
```

If return type

```
Country
```

Response

```json
{
   "code":"IN",
   "name":"India"
}
```

---

# Spring Beans Created

Current project creates

```

Application Bean

↓

HelloController Bean

↓

DispatcherServlet Bean

↓

HandlerMapping Bean

↓

MessageConverter Bean

↓

Embedded Tomcat Bean

```

As more exercises are completed,

additional beans will be created.

```

CountryController

CountryService

CountryDao

Country Beans

Exception Handler

MockMVC Beans

```

---

# ApplicationContext Contents

```

ApplicationContext

│

├── HelloController

├── DispatcherServlet

├── HandlerMapping

├── RequestMappingHandlerAdapter

├── HttpMessageConverters

├── Embedded Tomcat

├── Environment

└── AutoConfigured Beans

```

---

# JVM Memory During Execution

```

JVM

──────────────────────────────────

Method Area

──────────────────────────────────

SpringRestHandsonApplication

HelloController

DispatcherServlet

HandlerMapping

Spring Classes

──────────────────────────────────

Heap

──────────────────────────────────

ApplicationContext

HelloController Object

DispatcherServlet Object

HandlerMapping Object

Tomcat Object

──────────────────────────────────

Stack

──────────────────────────────────

main()

↓

SpringApplication.run()

↓

sayHello()

──────────────────────────────────

PC Register

Native Method Stack

──────────────────────────────────
```

---

# Sequence Diagram

```

Browser

│

│ GET /hello

▼

Tomcat

│

▼

DispatcherServlet

│

▼

Handler Mapping

│

▼

Handler Adapter

│

▼

HelloController

│

▼

sayHello()

│

▼

Return String

│

▼

HttpMessageConverter

│

▼

DispatcherServlet

│

▼

Browser

```

---

# Request Processing Timeline

```

Time

↓

Application Running

↓

Request Arrives

↓

URL Matching

↓

Controller Method

↓

Business Logic

↓

Response Creation

↓

HTTP Response Sent

```

---

# Response Lifecycle

```

Controller

↓

Return Value

↓

HttpMessageConverter

↓

Response Headers

↓

Response Body

↓

HTTP Response

↓

Client

```

---

# Browser Developer Tools

Open

```
F12

↓

Network

↓

hello

```

Observe

```

Request URL

Request Method

Status Code

Remote Address

Content-Type

Response Headers

Request Headers

Response Body

```

---

# Postman Observation

When testing

```
GET

http://localhost:8083/hello
```

observe

```

Status

200 OK

Headers

Body

Time

Size

```

---

# Comparison

| Browser | Postman |
|----------|----------|
| Mainly GET | All HTTP Methods |
| UI Rendering | Raw API Testing |
| Simple Testing | Advanced Testing |
| Limited Headers | Full Header Control |

---

# Real Enterprise Example

Suppose an E-Commerce application.

```

Customer

↓

GET /products

↓

DispatcherServlet

↓

ProductController

↓

ProductService

↓

ProductDao

↓

Database

↓

JSON

↓

Customer

```

Exactly the same architecture is used.

Only resource names change.

---

# REST API Naming Standards

Good

```

GET /employees

GET /countries

GET /departments

POST /employees

PUT /employees

DELETE /employees/101

```

Bad

```

getEmployees()

deleteEmployee()

updateCountry()

```

Use **nouns** instead of **verbs** in URLs.

---

# Logging Standards

Enterprise applications log

```

START

↓

Request URL

↓

Execution Time

↓

Business Logic

↓

Response

↓

END

```

Example

```text
INFO  START

INFO  GET /hello

INFO  Response Sent

INFO  END
```

---

# Performance Considerations

REST APIs should

- Return only required data
- Avoid unnecessary processing
- Use proper HTTP status codes
- Use caching where applicable
- Keep response payloads small
- Follow layered architecture

---

# Security Considerations

Even simple REST APIs should consider

- Authentication
- Authorization
- HTTPS
- Input Validation
- Exception Handling
- Secure Headers
- Logging

Later CTS exercises introduce authentication using JWT. :contentReference[oaicite:0]{index=0}

---

# Common Interview Questions

### 1. What is DispatcherServlet?

The front controller of Spring MVC that receives every incoming HTTP request and dispatches it to the appropriate controller.

---

### 2. What is HandlerMapping?

It maps the incoming request URL to the correct controller method.

---

### 3. What is HandlerAdapter?

It invokes the selected controller method.

---

### 4. What is HttpMessageConverter?

It converts Java return values into HTTP response formats such as JSON or plain text, and vice versa.

---

### 5. What happens when a request reaches Tomcat?

Tomcat receives the HTTP request and forwards it to Spring's `DispatcherServlet` for processing.

---

### 6. Why does Spring Boot not require web.xml?

Spring Boot uses auto-configuration and embedded servers, eliminating the need for traditional XML-based servlet configuration.

---

### 7. Which object stores all Spring beans?

The `ApplicationContext` (IoC Container).

---

### 8. Which layer should contain business logic?

The **Service** layer.

---

### 9. Which layer should access the database or XML configuration?

The **DAO** layer.

---

### 10. What is the default embedded web server in Spring Boot?

Apache Tomcat.

---

# Quick Revision

- Spring Boot starts an embedded Tomcat server.
- `DispatcherServlet` is the entry point for all HTTP requests.
- `HandlerMapping` finds the appropriate controller.
- `HandlerAdapter` invokes the controller method.
- `HttpMessageConverter` prepares the HTTP response.
- `ApplicationContext` manages Spring beans.
- `@RestController` exposes REST endpoints.
- `@GetMapping` maps HTTP GET requests.
- REST follows a layered architecture: Controller → Service → DAO.

---

# What's Next?

The next CTS hands-on is:

## REST - Country Web Service

In the next exercise, we will implement:

- `Country.java`
- `country.xml`
- `CountryDao`
- `CountryService`
- `CountryController`
- `GET /country`

This extends the Hello World example by returning a Java object (`Country`) that Spring automatically converts into JSON, introducing bean loading from XML and object serialization. 

---

# Conclusion

This chapter explained the complete internal execution of a Spring Boot REST application—from application startup to request handling, controller invocation, response conversion, and delivery to the client. It also covered the key Spring MVC components (`DispatcherServlet`, `HandlerMapping`, `HandlerAdapter`, and `HttpMessageConverter`), memory layout, request lifecycle, enterprise practices, security considerations, and interview-oriented concepts.

With this foundation, you are ready to implement the remaining CTS Spring REST hands-ons, where the same execution pipeline will be used with increasingly complex resources and business logic.

# Appendix

---

# Complete Project Structure

After completing the **Hello World RESTful Web Service**, the project structure should be:

```
Spring_REST_using_Spring_Boot_4

│

├── spring-rest-handson

│   │

│   ├── src

│   │   ├── main

│   │   │

│   │   ├── java

│   │   │   │

│   │   │   └── com

│   │   │       └── cognizant

│   │   │           └── springlearn

│   │   │               │

│   │   │               ├── SpringRestHandsonApplication.java

│   │   │               │

│   │   │               └── controller

│   │   │                     HelloController.java

│   │   │

│   │   └── resources

│   │         application.properties

│   │

│   └── test

│

├── pom.xml

├── mvnw

├── mvnw.cmd

└── README.md
```

---

# Project Files

## SpringRestHandsonApplication.java

Responsible for:

- Starting the Spring Boot application
- Creating the Spring IoC Container
- Starting Embedded Tomcat
- Registering DispatcherServlet

---

## HelloController.java

Responsible for:

- Receiving HTTP GET request
- Returning the response
- Exposing the REST endpoint

---

## application.properties

Responsible for:

- Application configuration
- Server port
- Environment properties

Current configuration

```properties
spring.application.name=spring-rest-handson

server.port=8083
```

---

## pom.xml

Responsible for

- Dependency Management
- Build Configuration
- Packaging
- Plugin Configuration

Current Dependency

```xml
spring-boot-starter-web
```

---

# Exercise Summary

Exercise Name

```
Hello World RESTful Web Service
```

Technology Used

```
Java 21

Spring Boot

Spring Web

Maven

REST API

Embedded Tomcat
```

Endpoint

```
GET

/hello
```

Response

```
Hello World!!
```

---

# End-to-End Flow

```
User

↓

Browser

↓

HTTP GET

↓

Embedded Tomcat

↓

DispatcherServlet

↓

HandlerMapping

↓

HelloController

↓

sayHello()

↓

Return String

↓

HTTP Response

↓

Browser

```

---

# Expected Console Output

```
Tomcat started on port(s): 8083 (http)

Started SpringRestHandsonApplication
```

---

# Expected Browser Output

Open

```
http://localhost:8083/hello
```

Output

```
Hello World!!
```

---

# Expected Postman Output

Method

```
GET
```

URL

```
http://localhost:8083/hello
```

Response

```
Hello World!!
```

Status

```
200 OK
```

---

# Verification Checklist

| Item | Status |
|------|--------|
| Maven Project Created | ✅ |
| Spring Boot Application Created | ✅ |
| Embedded Tomcat Started | ✅ |
| Spring Web Dependency Added | ✅ |
| HelloController Created | ✅ |
| @RestController Used | ✅ |
| @GetMapping Used | ✅ |
| Browser Test Passed | ✅ |
| Postman Test Passed | ✅ |
| Response Returned | ✅ |

---

# Screenshots to Capture

### Screenshot 1

Project Structure

```
spring-rest-handson
```

---

### Screenshot 2

SpringRestHandsonApplication.java

---

### Screenshot 3

HelloController.java

---

### Screenshot 4

application.properties

---

### Screenshot 5

pom.xml

---

### Screenshot 6

Application Running

```
Tomcat started on port(s): 8083
```

---

### Screenshot 7

Browser

```
http://localhost:8083/hello
```

Output

```
Hello World!!
```

---

### Screenshot 8

Postman

```
GET

http://localhost:8083/hello
```

Output

```
Hello World!!
```

---

### Screenshot 9

HTTP Headers

Status

```
200 OK
```

---

### Screenshot 10

Git Commit History

---

# Git Commands

Check Status

```bash
git status
```

Stage Files

```bash
git add .
```

Commit

```bash
git commit -m "Week 3 - Exercise 2.1: Implement Hello World RESTful Web Service"
```

Push

```bash
git push origin main
```

---

# Common Errors and Solutions

## Error 1

```
404 Not Found
```

Reason

- Wrong URL
- Incorrect mapping
- Controller not detected

Solution

- Verify `@GetMapping("/hello")`
- Ensure the controller is under the base package
- Restart the application

---

## Error 2

```
Port 8083 already in use
```

Solution

- Stop the application using the port
- Or change the port in `application.properties`

Example

```properties
server.port=8084
```

---

## Error 3

```
Application Failed to Start
```

Possible Reasons

- Missing dependency
- Invalid `pom.xml`
- Build failure

Solution

- Reload Maven
- Clean and rebuild the project

---

## Error 4

```
Whitelabel Error Page
```

Possible Reasons

- Incorrect endpoint
- No matching request mapping

Solution

- Verify the URL
- Ensure the application is running
- Confirm the controller is annotated with `@RestController`

---

# Best Practices

- Follow standard Maven directory structure.
- Use meaningful package names.
- Place the main class in the root package.
- Keep controllers focused on request handling.
- Keep business logic in the Service layer.
- Keep data access in the DAO layer.
- Use meaningful endpoint names.
- Use proper HTTP status codes.
- Test every API with Postman.
- Commit code after each completed exercise.

---

# Interview Cheat Sheet

| Topic | Key Point |
|--------|-----------|
| Spring Boot | Rapid application development |
| Spring Web | Module for web and REST applications |
| REST | Architectural style for web services |
| @SpringBootApplication | Main application annotation |
| @RestController | Exposes REST endpoints |
| @GetMapping | Maps HTTP GET requests |
| DispatcherServlet | Front Controller |
| Embedded Tomcat | Default web server |
| ApplicationContext | Spring IoC Container |
| HTTP GET | Retrieve data |
| Status Code | 200 OK |

---

# Module Completion Status

## Completed

- ✅ Create Spring Web Project using Maven
- ✅ Hello World RESTful Web Service

## Upcoming CTS Hands-ons

The remaining exercises in the **Spring REST using Spring Boot** module are:

- REST - Country Web Service
- REST - Get All Countries
- REST - Get Country Based on Country Code
- REST - Country Exceptional Scenario
- MockMVC Testing

These exercises build incrementally on the concepts introduced in the Hello World service by adding layered architecture, JSON responses, exception handling, and automated testing.

---

# Final Conclusion

The **Hello World RESTful Web Service** is the first practical implementation in the Spring REST module. Even though it returns a simple text response, it introduces the complete Spring Boot web application lifecycle, including application startup, embedded Tomcat, request mapping, controller execution, and HTTP response generation.

This exercise establishes the foundation required for all subsequent CTS Spring REST hands-ons. The same request-processing pipeline will be reused as we progress to returning Java objects as JSON, implementing service and DAO layers, handling exceptions, and testing APIs with MockMVC.

With this exercise completed, the project is now ready to move to the next CTS hands-on: **REST – Country Web Service**.

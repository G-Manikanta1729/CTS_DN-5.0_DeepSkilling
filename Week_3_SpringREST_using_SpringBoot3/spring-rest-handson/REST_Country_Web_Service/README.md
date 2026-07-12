# REST - Country Web Service

## Cognizant Digital Nurture 5.0 (DN 5.0)

### Week 3 - Spring REST using Spring Boot

---

# Introduction

In this exercise, we build our first real RESTful Web Service using Spring Boot.

In the previous exercise, we created a simple REST endpoint that returned a plain text message (`Hello World!!`). Although that exercise helped us understand how to expose an endpoint, enterprise applications rarely return plain text.

Most enterprise applications exchange data in the form of objects such as:

- Employee
- Student
- Country
- Product
- Customer
- Order

These objects are transferred between the client and the server using a standard data format called **JSON (JavaScript Object Notation)**.

In this exercise, instead of returning a String, we return a **Country object**. Spring Boot automatically converts this object into JSON before sending it to the client.

This exercise also introduces one of the most common software architectures used in enterprise applications:

- Controller Layer
- Service Layer
- DAO Layer
- Model Layer

Understanding this exercise is important because almost every Spring Boot application, whether it is an e-commerce website, banking application, hospital management system, or airline reservation system, follows the same architecture.

---

# Exercise Objective

Develop a REST Web Service that returns the details of India.

### Request

```
GET http://localhost:8083/country
```

### Response

```json
{
    "code": "IN",
    "name": "India"
}
```

The data should be loaded from a Spring XML configuration file (`country.xml`) and returned as a JSON response.

---

# What is a Web Service?

## Definition

A Web Service is a software component that allows two different applications to communicate with each other over a network.

It acts as a bridge between applications.

The communication happens using standard internet protocols such as HTTP.

---

## Why Do We Need Web Services?

Imagine an online shopping application.

The system contains different applications.

```
Mobile App

Website

Payment Gateway

Inventory System

Delivery System
```

These applications need to exchange information.

For example,

The mobile app requests product details.

```
Mobile App

↓

Product Service

↓

Product Details
```

Similarly,

The payment service asks the banking server whether the payment is successful.

```
Payment Gateway

↓

Bank Server

↓

Payment Status
```

Without Web Services, these applications cannot communicate.

---

## Real-World Example

Consider the Google Maps application.

When we search for

```
Vijayawada Railway Station
```

Google Maps does not already know the location.

Instead,

it sends a request to the Google Maps server.

```
Mobile App

↓

Google Maps Server

↓

Location Information

↓

Mobile App
```

The server returns the requested information.

This communication happens using Web Services.

---

# What is REST?

## Definition

REST stands for **Representational State Transfer**.

It is an architectural style used to develop lightweight web services that communicate using the HTTP protocol.

REST was introduced by **Roy Fielding** in the year **2000** as part of his doctoral dissertation.

Unlike SOAP, REST is simple, lightweight, scalable, and easy to understand.

---

# Why Was REST Created?

Before REST became popular, most web services were developed using **SOAP (Simple Object Access Protocol)**.

SOAP had several disadvantages.

- Complex XML messages
- Large request size
- Difficult to understand
- Slower communication
- More bandwidth consumption
- More configuration

Developers wanted something simpler.

REST solved these problems by using:

- HTTP
- Simple URLs
- JSON
- Standard HTTP methods

Today, almost every modern application uses REST APIs.

Examples include:

- Amazon
- Flipkart
- Netflix
- Instagram
- WhatsApp
- Paytm
- PhonePe

---

# Characteristics of REST

REST follows a few important principles.

## 1. Client-Server Architecture

The client requests data.

The server processes the request and returns the response.

```
Client

↓

HTTP Request

↓

Server

↓

HTTP Response

↓

Client
```

Examples of Clients

- Browser
- Mobile App
- React Application
- Angular Application
- Postman

---

## 2. Stateless Communication

Every request is independent.

The server does not remember previous requests.

Example

Request 1

```
GET /country
```

Request 2

```
GET /employee
```

The server processes each request separately.

---

## 3. Resource-Based

Everything in REST is considered a resource.

Examples

```
Country

Employee

Student

Department

Product

Customer
```

In this exercise,

our resource is

```
Country
```

---

# What is a Resource?

## Definition

A Resource is any data that can be accessed through a REST API.

Examples

```
Employee

Country

Book

Student

Product
```

Each resource is identified using a URL.

Example

```
/country

/student

/employee

/product
```

---

# HTTP Protocol

## Definition

HTTP stands for **HyperText Transfer Protocol**.

It is the communication protocol used between clients and servers.

Whenever we access a website,

our browser sends an HTTP request.

The server processes it and sends an HTTP response.

```
Browser

↓

HTTP Request

↓

Spring Boot

↓

HTTP Response

↓

Browser
```

---

# HTTP Methods

REST mainly uses five HTTP methods.

| Method | Purpose |
|---------|---------|
| GET | Retrieve data |
| POST | Create data |
| PUT | Update existing data |
| DELETE | Delete data |
| PATCH | Partially update data |

---

## Why Are We Using GET?

This exercise only retrieves data.

It does not create,

update,

or delete anything.

Therefore,

the correct HTTP method is

```
GET
```

---

# What is JSON?

## Definition

JSON stands for **JavaScript Object Notation**.

It is a lightweight data format used to exchange information between applications.

Spring Boot automatically converts Java objects into JSON.

Example

Java Object

```java
Country

Code = IN

Name = India
```

JSON Response

```json
{
    "code":"IN",
    "name":"India"
}
```

---

# Why JSON Instead of XML?

JSON has several advantages.

- Easy to read
- Easy to write
- Smaller message size
- Faster parsing
- Language independent
- Widely supported

For these reasons,

modern REST APIs prefer JSON.

---

# What Are We Building in This Exercise?

Our application returns the details of India.

```
Browser

↓

GET /country

↓

Spring Boot

↓

Country Object

↓

JSON

↓

Browser
```

The Country object is not created manually.

Instead,

Spring loads it from an XML configuration file called

```
country.xml
```

---

# Architecture of This Exercise

The application follows a layered architecture.

```
                Client
                   │
                   ▼
        CountryController
                   │
                   ▼
         CountryService
                   │
                   ▼
           CountryDao
                   │
                   ▼
            country.xml
                   │
                   ▼
            Country Object
                   │
                   ▼
          JSON Response
```

Each layer has a specific responsibility.

### Controller

Receives HTTP requests from the client and returns HTTP responses.

### Service

Contains business logic and acts as a bridge between the Controller and DAO.

### DAO (Data Access Object)

Responsible for accessing the data source.

In this exercise, the data source is an XML configuration file.

In real-world applications, the DAO usually communicates with a database.

### Model

Represents the application's data.

In this exercise, the `Country` class is the model.

---

# Project Structure

```
spring-rest-handson
│
├── controller
│      CountryController.java
│
├── service
│      CountryService.java
│
├── dao
│      CountryDao.java
│
├── model
│      Country.java
│
├── resources
│      country.xml
│      application.properties
│
└── SpringRestHandsonApplication.java
```

Each package follows the standard Spring Boot layered architecture and has a single responsibility, making the application easier to understand, maintain, and extend.

# Java Bean (POJO)

Before understanding the implementation, we need to understand what a **Java Bean** is because our `Country` class is a Java Bean.

---

## Definition

A Java Bean is a reusable Java class that represents an object with data.

It is a special type of class that follows certain rules.

A Java Bean generally contains:

- Private data members (fields)
- Public getter methods
- Public setter methods
- A public default constructor

---

## Rules of a Java Bean

A class is called a Java Bean if it follows these rules:

- It must have a public default constructor.
- All data members should be private.
- Public getter methods should be provided.
- Public setter methods should be provided.

Example

```java
public class Student {

    private int id;
    private String name;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
```

---

## Why Do We Need Java Beans?

Suppose we want to represent a country.

The country has

- Country Code
- Country Name

Instead of storing these values separately,

```
String code = "IN";

String name = "India";
```

we group them into a single object.

```
Country

↓

Code : IN

Name : India
```

This makes the application easier to understand and maintain.

---

## Real-World Analogy

Think of an Aadhaar Card.

An Aadhaar card contains

- Aadhaar Number
- Name
- Date of Birth
- Address

Instead of keeping each value separately,

all the information belongs to one person.

Similarly,

a Java Bean groups related information into one object.

---

# What is a Spring Bean?

## Definition

A Spring Bean is simply a Java object that is created, managed, and maintained by the Spring IoC Container.

Not every Java object is a Spring Bean.

Example

```java
Country country = new Country();
```

This object is created manually.

It is **not** a Spring Bean.

However,

if Spring creates the object,

it becomes a Spring Bean.

---

## Why Spring Beans?

Imagine an application with hundreds of classes.

```
Employee

Country

Customer

Product

Order

Invoice
```

If developers create every object manually,

the code becomes difficult to maintain.

Spring solves this problem by creating and managing objects automatically.

---

# IoC (Inversion of Control)

## Definition

IoC stands for **Inversion of Control**.

Normally,

the programmer creates objects.

Example

```java
Country country = new Country();
```

With Spring,

the control of object creation is transferred to the Spring Framework.

Instead of the developer,

Spring creates the object.

---

## Traditional Way

```
Developer

↓

new Country()

↓

Object Created
```

---

## Spring Way

```
Developer

↓

Spring Container

↓

Country Object

↓

Developer Uses Object
```

This is called **Inversion of Control**.

---

# ApplicationContext

## Definition

ApplicationContext is the Spring IoC Container.

Its responsibility is to

- Read configuration
- Create objects
- Store objects
- Manage object lifecycle
- Provide objects whenever required

---

## Real-World Example

Imagine a library.

The library stores thousands of books.

Whenever you need a book,

you don't create one.

You simply ask the librarian.

```
Student

↓

Librarian

↓

Book
```

Similarly,

ApplicationContext stores all Spring Beans.

Whenever a class needs an object,

it asks ApplicationContext.

---

# ClassPathXmlApplicationContext

## Definition

`ClassPathXmlApplicationContext` is an implementation of `ApplicationContext`.

It loads bean definitions from an XML file present inside the project's classpath.

Example

```java
ApplicationContext context =
        new ClassPathXmlApplicationContext("country.xml");
```

When this statement executes,

Spring performs the following steps:

1. Searches for `country.xml`.
2. Reads the XML file.
3. Identifies all bean definitions.
4. Creates the required objects.
5. Stores them inside the IoC Container.

---

# XML Bean Configuration

Spring allows beans to be configured using XML.

Example

```xml
<bean id="country"
      class="com.cognizant.springlearn.model.Country">

    <property name="code" value="IN"/>

    <property name="name" value="India"/>

</bean>
```

---

## What Happens Internally?

Spring reads the XML.

Internally,

it performs something similar to

```java
Country country = new Country();

country.setCode("IN");

country.setName("India");
```

Finally,

the object is stored inside the Spring Container.

---

# Implementation - Country.java

```java
package com.cognizant.springlearn.model;

public class Country {

    private String code;
    private String name;

    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

---

# Line-by-Line Explanation

### Package

```java
package com.cognizant.springlearn.model;
```

This statement places the `Country` class inside the `model` package.

The `model` package contains classes that represent the application's data.

---

### Class Declaration

```java
public class Country
```

This creates a class named `Country`.

Each object of this class represents one country.

Example

```
Country

↓

Code : IN

Name : India
```

---

### Data Members

```java
private String code;
```

Stores the country code.

Example

```
IN

US

JP
```

The variable is declared `private` to follow the principle of **Encapsulation**, which protects the data from direct access.

---

```java
private String name;
```

Stores the name of the country.

Example

```
India

Japan

USA
```

---

### Default Constructor

```java
public Country() {
}
```

Spring requires a public default constructor to create objects while reading the XML configuration.

Without it, Spring may fail to instantiate the bean.

---

### Parameterized Constructor

```java
public Country(String code, String name)
```

This constructor initializes the object with values in a single statement.

Example

```java
Country country = new Country("IN", "India");
```

Although this exercise uses setter injection, having a parameterized constructor is considered a good programming practice.

---

### Getter Methods

```java
public String getCode()
```

Returns the value of the `code` field.

This method is also used by the Jackson library while converting the object into JSON.

Similarly,

```java
public String getName()
```

returns the country name.

---

### Setter Methods

```java
public void setCode(String code)
```

Updates the country code.

Spring internally calls this method while reading

```xml
<property name="code" value="IN"/>
```

Similarly,

```java
public void setName(String name)
```

is called for

```xml
<property name="name" value="India"/>
```

---

# Key Points to Remember

- A Java Bean is a reusable class that stores data.
- A Spring Bean is a Java object managed by the Spring IoC Container.
- `ApplicationContext` creates and manages Spring Beans.
- `ClassPathXmlApplicationContext` loads bean definitions from an XML file.
- The `Country` class is a Java Bean.
- Spring creates the `Country` object using the XML configuration.
- Getter methods are used by Jackson to generate JSON.
- Setter methods are used by Spring to inject values from `country.xml`.

  # DAO (Data Access Object)

Before understanding the implementation, we need to understand what a DAO is.

---

# What is DAO?

## Definition

DAO stands for **Data Access Object**.

It is a design pattern that provides an abstraction between the business logic and the data source.

A DAO is responsible for performing all data-related operations.

The data source can be:

- Database
- XML File
- JSON File
- CSV File
- REST API
- Cloud Storage

In this exercise, the data source is **country.xml**.

---

# Why Do We Need DAO?

Imagine a shopping application.

The application needs product details.

Without DAO

```
Controller

↓

Database
```

The Controller directly accesses the database.

This is not recommended because the Controller now has two responsibilities.

- Handling HTTP requests
- Accessing the database

If the database changes, the Controller must also change.

This violates the **Single Responsibility Principle (SRP).**

---

With DAO

```
Controller

↓

Service

↓

DAO

↓

Database
```

Now,

only the DAO communicates with the database.

If the database changes,

only the DAO needs modification.

The Controller and Service remain unchanged.

This makes the application easier to maintain.

---

# Real World Example

Imagine a restaurant.

Customer

↓

Waiter

↓

Chef

↓

Kitchen

The customer never enters the kitchen.

Similarly,

```
Browser

↓

Controller

↓

Service

↓

DAO

↓

Database/XML
```

The Controller never directly accesses the XML or database.

The DAO performs that responsibility.

---

# DAO in This Exercise

The data source is

```
country.xml
```

The DAO reads the XML file,

retrieves the Country Bean,

and returns it to the Service layer.

---

# CountryDao.java

```java
package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao {

    public Country getCountry() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        return context.getBean("country", Country.class);

    }

}
```

---

# Line-by-Line Explanation

## Package

```java
package com.cognizant.springlearn.dao;
```

Places this class inside the DAO package.

All classes responsible for data access are kept inside this package.

---

## Import Statements

```java
import com.cognizant.springlearn.model.Country;
```

Imports the Country class because this DAO returns a Country object.

---

```java
import org.springframework.context.ApplicationContext;
```

Imports the Spring IoC Container.

ApplicationContext is responsible for managing Spring Beans.

---

```java
import org.springframework.context.support.ClassPathXmlApplicationContext;
```

Allows Spring to load bean definitions from an XML file.

---

```java
import org.springframework.stereotype.Repository;
```

Marks this class as a Repository (DAO).

During Component Scanning,

Spring automatically creates an object of this class.

---

## @Repository

```java
@Repository
```

This annotation tells Spring

"This class performs data access operations."

Spring automatically registers this class as a Bean.

---

## Class Declaration

```java
public class CountryDao
```

Creates the DAO class.

---

## Method

```java
public Country getCountry()
```

Returns one Country object.

---

## Creating ApplicationContext

```java
ApplicationContext context =
        new ClassPathXmlApplicationContext("country.xml");
```

This is the most important statement.

When it executes,

Spring performs the following steps.

```
Search country.xml

↓

Read XML

↓

Find Bean Definitions

↓

Create Country Object

↓

Store Inside IoC Container
```

---

## Retrieving Bean

```java
return context.getBean("country", Country.class);
```

Spring searches for

```
Bean ID

↓

country
```

inside

```
country.xml
```

and returns

```
Country Object
```

Equivalent Java Code

```java
Country country = new Country();

country.setCode("IN");

country.setName("India");
```

Spring performs these steps automatically.

---

# Service Layer

---

# What is Service?

## Definition

The Service Layer contains the application's business logic.

It acts as an intermediary between the Controller and the DAO.

```
Controller

↓

Service

↓

DAO
```

---

# Why Service Layer?

Suppose tomorrow,

before returning the country,

we need to

- Validate the country
- Log the request
- Apply business rules
- Check permissions

Where should this logic be written?

Not in Controller.

Not in DAO.

It belongs in the Service Layer.

---

# CountryService.java

```java
package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.CountryDao;
import com.cognizant.springlearn.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public Country getCountry() {
        return countryDao.getCountry();
    }

}
```

---

# Line-by-Line Explanation

## @Service

```java
@Service
```

Marks this class as the Service Layer.

Spring automatically creates a Bean of this class.

---

## Dependency Injection

```java
@Autowired
private CountryDao countryDao;
```

Instead of writing

```java
CountryDao dao = new CountryDao();
```

Spring automatically creates the DAO object

and injects it here.

This is called **Dependency Injection**.

---

## getCountry()

```java
public Country getCountry()
```

Calls the DAO

and returns the Country object.

Currently,

there is no business logic.

It simply delegates the request.

---

# Controller Layer

---

# What is a Controller?

## Definition

A Controller is the entry point of a Spring MVC application.

It receives HTTP requests from the client,

processes them,

calls the Service layer,

and returns HTTP responses.

---

# Why Controller?

Without a Controller,

Spring would not know

which Java method should execute

when a request arrives.

The Controller maps URLs to Java methods.

---

# Real World Example

Imagine a receptionist.

Customer

↓

Receptionist

↓

Concerned Department

↓

Response

Similarly,

```
Browser

↓

Controller

↓

Service

↓

DAO
```

The Controller receives every request first.

---

# CountryController.java

```java
package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping("/country")
    public Country getCountryIndia() {

        return countryService.getCountry();

    }

}
```

---

# Line-by-Line Explanation

## @RestController

```java
@RestController
```

Marks this class as a REST Controller.

Unlike `@Controller`,

it returns data directly instead of returning a web page.

The returned object is automatically converted into JSON.

---

## Dependency Injection

```java
@Autowired
private CountryService countryService;
```

Spring injects the Service Bean automatically.

No need to create the object manually.

---

## @RequestMapping

```java
@RequestMapping("/country")
```

Maps the URL

```
/country
```

to

```java
getCountryIndia()
```

Whenever the browser sends

```
GET /country
```

Spring executes this method.

---

## Method

```java
public Country getCountryIndia()
```

This method receives the request,

calls the Service,

and returns the Country object.

---

## Returning Data

```java
return countryService.getCountry();
```

Execution Flow

```
CountryController

↓

CountryService

↓

CountryDao

↓

country.xml

↓

Country Object

↓

Controller

↓

Browser
```

The Controller itself does not create the object.

It simply delegates the work to the Service layer.

---

# Key Points to Remember

- DAO communicates with the data source.
- Service contains business logic.
- Controller receives HTTP requests.
- `@Repository` marks the DAO.
- `@Service` marks the Service layer.
- `@RestController` marks the REST Controller.
- `@Autowired` performs Dependency Injection.
- `@RequestMapping` maps a URL to a Java method.
- The Controller never directly accesses the XML or database.
- Every layer has a single responsibility, making the application modular and maintainable.

  # Internal Working of the Application

Now that we have understood each layer and its implementation, let us understand what happens internally when a user accesses the REST API.

Suppose the user enters the following URL in the browser.

```
http://localhost:8083/country
```

The application performs several steps before returning the JSON response.

---

# Complete Request Flow

```
Browser / Postman

        │

        ▼

HTTP GET Request

        │

        ▼

Embedded Tomcat Server

        │

        ▼

DispatcherServlet

        │

        ▼

Handler Mapping

        │

        ▼

CountryController

        │

        ▼

CountryService

        │

        ▼

CountryDao

        │

        ▼

ApplicationContext

        │

        ▼

country.xml

        │

        ▼

Country Bean

        │

        ▼

Country Object

        │

        ▼

Jackson Library

        │

        ▼

JSON Response

        │

        ▼

Browser / Postman
```

---

# Step-by-Step Execution

## Step 1

The user enters

```
http://localhost:8083/country
```

or Postman sends

```
GET /country
```

This creates an HTTP GET request.

---

## Step 2

The request reaches the Embedded Tomcat Server.

Tomcat is the default web server provided by Spring Boot.

Its responsibility is

- Listen for HTTP requests
- Forward requests to Spring MVC

Tomcat does not execute business logic.

It simply forwards the request.

---

## Step 3

Tomcat forwards the request to

```
DispatcherServlet
```

DispatcherServlet is known as the **Front Controller** of Spring MVC.

Every HTTP request first reaches DispatcherServlet.

No controller directly receives requests.

---

# DispatcherServlet

## Definition

DispatcherServlet is the central controller of Spring MVC.

It is responsible for

- Receiving requests
- Finding the correct controller
- Executing controller methods
- Returning HTTP responses

Think of it as the manager of the Spring MVC application.

---

# Step 4

DispatcherServlet asks

```
Handler Mapping
```

Which controller handles

```
/country
```

Handler Mapping searches all controller methods.

It finds

```java
@RequestMapping("/country")
public Country getCountryIndia()
```

Now DispatcherServlet knows which method should execute.

---

# Step 5

DispatcherServlet calls

```
CountryController
```

The following method executes.

```java
public Country getCountryIndia() {

    return countryService.getCountry();

}
```

Notice that

the Controller does not create the object.

It simply delegates the work.

---

# Step 6

The Controller calls

```java
countryService.getCountry();
```

Now execution moves to

```
CountryService
```

The Service layer contains business logic.

In this exercise,

there is no business logic,

so it immediately calls

```
CountryDao
```

---

# Step 7

CountryDao executes

```java
ApplicationContext context =
new ClassPathXmlApplicationContext("country.xml");
```

Spring performs

```
Locate country.xml

↓

Read XML

↓

Find Bean Definition

↓

Create Country Object

↓

Store Inside IoC Container
```

---

# Step 8

DAO executes

```java
context.getBean("country", Country.class);
```

Spring searches for

```
Bean ID

↓

country
```

inside

```
country.xml
```

It retrieves

```
Country Bean
```

which contains

```
Code = IN

Name = India
```

The DAO returns the object to the Service.

The Service returns it to the Controller.

---

# Step 9

The Controller now returns

```java
Country
```

instead of a String.

Spring Boot understands that

the object must be converted into JSON.

---

# Jackson Library

## Definition

Jackson is a Java library used by Spring Boot to convert Java Objects into JSON.

Spring Boot automatically includes Jackson through

```
spring-boot-starter-web
```

No additional configuration is required.

---

# Object to JSON Conversion

Country Object

```
Country

↓

Code = IN

↓

Name = India
```

Jackson converts it into

```json
{
    "code":"IN",
    "name":"India"
}
```

This process is called

```
Serialization
```

Serialization means converting an object into a transferable format.

---

# HTTP Response

After conversion,

Spring Boot creates an HTTP Response.

Example

```http
HTTP/1.1 200 OK

Content-Type: application/json

{
   "code":"IN",
   "name":"India"
}
```

The browser or Postman receives this response.

---

# Sequence Diagram

```
Browser

    │

    │ GET /country

    ▼

DispatcherServlet

    │

    ▼

CountryController

    │

    ▼

CountryService

    │

    ▼

CountryDao

    │

    ▼

country.xml

    │

    ▼

Country Object

    │

    ▼

Jackson

    │

    ▼

JSON Response

    │

    ▼

Browser
```

---

# Memory Diagram

```
JVM

────────────────────────────────────

Heap Memory

────────────────────────────────────

ApplicationContext

│

├── Country Bean

├── CountryController Bean

├── CountryService Bean

├── CountryDao Bean

├── DispatcherServlet

└── Other Spring Beans

────────────────────────────────────

Method Area

────────────────────────────────────

Country.class

CountryController.class

CountryService.class

CountryDao.class

Spring Classes

────────────────────────────────────
```

---

# HTTP Request

```
GET /country HTTP/1.1

Host: localhost:8083

Accept: application/json
```

---

# HTTP Response

```
HTTP/1.1 200 OK

Content-Type: application/json
```

Response Body

```json
{
    "code":"IN",
    "name":"India"
}
```

---

# Best Practices

- Follow layered architecture (Controller → Service → DAO).
- Keep business logic inside the Service layer.
- Keep data access logic inside the DAO layer.
- Do not access XML or databases directly from the Controller.
- Use meaningful URL names such as `/country`.
- Return Java objects instead of manually creating JSON strings.
- Let Spring Boot handle JSON conversion using Jackson.
- Keep model classes simple and reusable.

---

# Common Mistakes

### 1. Accessing DAO directly from Controller

❌ Wrong

```
Controller

↓

DAO
```

✔ Correct

```
Controller

↓

Service

↓

DAO
```

---

### 2. Creating Objects Using `new`

❌

```java
CountryDao dao = new CountryDao();
```

✔

Use Dependency Injection.

```java
@Autowired
private CountryDao countryDao;
```

---

### 3. Returning String Instead of Object

❌

```java
return "India";
```

✔

```java
return country;
```

Returning the object allows Spring Boot to generate proper JSON.

---

### 4. Hardcoding Data in Controller

The Controller should never create business objects.

Always delegate to the Service layer.

---

# Interview Questions

### 1. What is a REST Web Service?

A REST Web Service is a web service that follows REST architectural principles and communicates over HTTP.

---

### 2. What is the role of `@RestController`?

It marks a class as a REST Controller and tells Spring to return data directly as the HTTP response body.

---

### 3. What is `@RequestMapping`?

It maps an HTTP request URL to a Java method.

---

### 4. What is DAO?

DAO (Data Access Object) is responsible for accessing data from the data source.

---

### 5. Why do we need the Service layer?

The Service layer contains business logic and separates the Controller from the data access layer.

---

### 6. What is `ApplicationContext`?

It is the Spring IoC Container that creates, stores, and manages Spring Beans.

---

### 7. What is `ClassPathXmlApplicationContext`?

It loads Spring Bean definitions from an XML file located in the application's classpath.

---

### 8. What is Jackson?

Jackson is a Java library used by Spring Boot to convert Java objects into JSON and JSON into Java objects.

---

### 9. What is Serialization?

Serialization is the process of converting a Java object into a format such as JSON so that it can be transferred over a network.

---

### 10. Why do we use layered architecture?

Layered architecture separates responsibilities, improves maintainability, makes testing easier, and follows enterprise development standards.

---

# Quick Revision

- REST APIs communicate using HTTP.
- `GET` is used to retrieve data.
- `Country` is the Model (Java Bean).
- `CountryController` receives HTTP requests.
- `CountryService` contains business logic.
- `CountryDao` accesses the data source.
- `country.xml` stores the Spring Bean configuration.
- `ApplicationContext` loads and manages Spring Beans.
- `DispatcherServlet` is the Front Controller of Spring MVC.
- `@RequestMapping` maps URLs to methods.
- `@Autowired` performs Dependency Injection.
- Jackson converts Java objects into JSON automatically.
- The response for this exercise is:

```json
{
    "code":"IN",
    "name":"India"
}
```

# REST - Get Country Based on Country Code

## Cognizant Digital Nurture 5.0 (DN 5.0)

### Week 3 - Spring REST using Spring Boot

---

# Introduction

In the previous exercise (**REST - Country Web Service**), we created a REST API that always returned the details of one country (India).

The API was static because no matter how many times the client sent a request, the response was always the same.

Example

```
GET /country
```

Response

```json
{
    "code": "IN",
    "name": "India"
}
```

Although this helped us understand how REST APIs work, real-world applications rarely return the same data for every request.

Instead, the client requests specific data by providing an identifier.

For example,

- Employee ID
- Student ID
- Product ID
- Order ID
- Country Code

This exercise teaches us how to develop a **dynamic REST API**, where the response changes based on the value provided in the URL.

Instead of returning the same country every time, our application returns the country that matches the country code supplied by the client.

---

# Exercise Objective

Develop a REST API that returns a specific country based on the country code provided in the URL.

The search should be **case-insensitive**.

### Sample Request

```
GET http://localhost:8083/countries/in
```

### Sample Response

```json
{
    "code": "IN",
    "name": "India"
}
```

Similarly,

```
GET /countries/us
```

should return

```json
{
    "code":"US",
    "name":"United States"
}
```

---

# Concepts Covered

This exercise introduces several new Spring Boot concepts in addition to the concepts learned in the previous exercise.

- Dynamic REST APIs
- Path Variables
- URL Mapping
- @GetMapping
- @PathVariable
- Collection of Beans
- XML List Configuration
- Case-Insensitive Search
- equalsIgnoreCase()
- Searching Objects from a Collection
- Layered Architecture

---

# What is a Dynamic REST API?

## Definition

A Dynamic REST API is an API whose response changes depending on the values supplied by the client.

Unlike a static API, which always returns the same data, a dynamic API processes the request parameters and returns different results.

---

## Static REST API

A static API always produces the same output.

Example

Request

```
GET /country
```

Response

```json
{
    "code":"IN",
    "name":"India"
}
```

No matter who sends the request,

the response remains the same.

---

## Dynamic REST API

A dynamic API produces different responses depending on the request.

Example

Request

```
GET /countries/in
```

Response

```json
{
    "code":"IN",
    "name":"India"
}
```

Request

```
GET /countries/us
```

Response

```json
{
    "code":"US",
    "name":"United States"
}
```

Request

```
GET /countries/jp
```

Response

```json
{
    "code":"JP",
    "name":"Japan"
}
```

Here,

the response changes according to the country code supplied by the client.

---

# Why Do We Need Dynamic APIs?

Imagine an online shopping application.

Suppose there are one million products.

Should we create one REST API for every product?

```
/product1

/product2

/product3

/product4
```

No.

Instead,

we create a single dynamic API.

```
GET /products/{id}
```

Examples

```
GET /products/101

GET /products/250

GET /products/1005
```

The same API serves all products.

Similarly,

our application uses

```
/countries/{code}
```

instead of creating separate APIs for every country.

---

# Real World Examples

## Amazon

```
GET /products/12345
```

Returns Product 12345.

---

## Student Management System

```
GET /students/101
```

Returns Student 101.

---

## Employee Management System

```
GET /employees/5001
```

Returns Employee 5001.

---

## Banking Application

```
GET /accounts/987654321
```

Returns account details.

---

## Country Service

```
GET /countries/in
```

Returns India.

```
GET /countries/us
```

Returns United States.

```
GET /countries/de
```

Returns Germany.

The same REST API returns different countries.

---

# What is a Path Variable?

## Definition

A Path Variable is a value embedded directly inside the URL.

Spring extracts this value automatically and passes it to the controller method.

Example

URL

```
GET /countries/in
```

Here,

```
in
```

is the Path Variable.

---

Another example

```
GET /students/101
```

Path Variable

```
101
```

---

Another example

```
GET /employees/5001
```

Path Variable

```
5001
```

The value changes depending on the client's request.

---

# Why Path Variables?

Without Path Variables,

we would need separate URLs.

```
/india

/usa

/japan

/germany
```

This approach is not scalable.

Instead,

we create one URL.

```
/countries/{code}
```

Now,

```
GET /countries/in
```

```
GET /countries/us
```

```
GET /countries/jp
```

all use the same API.

---

# @PathVariable Annotation

## Definition

`@PathVariable` is a Spring annotation used to retrieve values from the URL.

Example

```java
@GetMapping("/countries/{code}")
public Country getCountry(@PathVariable String code)
```

If the client requests

```
GET /countries/in
```

Spring automatically stores

```
in
```

inside

```java
String code
```

No manual parsing is required.

Spring performs this automatically.

---

# What is @GetMapping?

## Definition

`@GetMapping` is a specialized Spring annotation used to map HTTP GET requests to a controller method.

Instead of writing

```java
@RequestMapping(value="/countries/{code}",
method=RequestMethod.GET)
```

Spring provides the simpler annotation

```java
@GetMapping("/countries/{code}")
```

Both perform the same task.

`@GetMapping` is shorter, cleaner, and easier to read.

---

# Why Are We Using GET?

This exercise only retrieves country information.

No new data is created.

No data is updated.

No data is deleted.

Therefore,

the appropriate HTTP method is

```
GET
```

---

# Case-Insensitive Search

## Definition

A case-insensitive search ignores uppercase and lowercase differences while comparing values.

Example

The following values are considered equal.

```
IN

in

In

iN
```

All of them represent the same country code.

---

# Why Case-Insensitive Search?

Suppose the client enters

```
GET /countries/in
```

but the XML stores

```
IN
```

If we use a normal comparison,

```java
equals()
```

the comparison fails.

Instead,

we use

```java
equalsIgnoreCase()
```

which treats

```
IN

in

In

iN
```

as identical.

This improves usability because the client does not have to worry about letter casing.

---

# Architecture of This Exercise

```
Client (Browser/Postman)

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

List<Country>

        │

        ▼

Matching Country

        │

        ▼

JSON Response
```

Unlike the previous exercise,

the DAO now retrieves a **list of countries** instead of a single country.

The Service searches the list,

finds the matching country,

and returns it to the Controller.

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

The project structure remains the sam
e as the previous exercise.

The main difference is that the application now retrieves a **collection of Country objects** and returns only the object whose country code matches the client's request.

# Collection in Java

Before understanding the implementation, we need to understand why this exercise uses a **List of Country objects** instead of a single Country object.

---

# What is a Collection?

## Definition

A Collection is a framework in Java used to store and manage multiple objects as a single unit.

Instead of storing one object,

a Collection stores many objects.

Example

Instead of

```java
Country country = new Country();
```

we can store multiple countries.

```java
List<Country> countries = new ArrayList<>();
```

Now,

the list can contain

- India
- USA
- Japan
- Germany

all together.

---

# Why Do We Need Collections?

Imagine a school.

There are many students.

Without Collection

```
Student1

Student2

Student3

Student4
```

Managing them individually becomes difficult.

Instead,

we create

```
List<Student>
```

Similarly,

instead of storing one Country,

we store

```
List<Country>
```

This allows our application to search any country whenever required.

---

# Why List?

Java provides several Collection types.

| Collection | Stores Duplicate Values | Maintains Order |
|------------|------------------------|-----------------|
| List | Yes | Yes |
| Set | No | No |
| Queue | Yes | Yes |

In this exercise,

we use **List** because

- Countries should remain in order.
- Searching through a list is simple.
- CTS specifically asks us to retrieve a country list.

---

# What is List<Country>?

## Definition

`List<Country>` represents a collection of Country objects.

Instead of one Country,

we now have multiple Country objects.

Example

```
Country List

↓

India

↓

United States

↓

Japan

↓

Germany
```

Each object is stored separately inside the list.

---

# XML Bean Configuration

In the previous exercise,

our XML contained only one Country Bean.

Example

```xml
<bean id="country">

...
```

Now,

CTS asks us to maintain a list of countries.

Therefore,

the XML configuration changes.

---

# country.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="countryList"
          class="java.util.ArrayList">

        <constructor-arg>

            <list>

                <bean class="com.cognizant.springlearn.model.Country">

                    <property name="code" value="IN"/>

                    <property name="name" value="India"/>

                </bean>

                <bean class="com.cognizant.springlearn.model.Country">

                    <property name="code" value="US"/>

                    <property name="name" value="United States"/>

                </bean>

                <bean class="com.cognizant.springlearn.model.Country">

                    <property name="code" value="JP"/>

                    <property name="name" value="Japan"/>

                </bean>

                <bean class="com.cognizant.springlearn.model.Country">

                    <property name="code" value="DE"/>

                    <property name="name" value="Germany"/>

                </bean>

            </list>

        </constructor-arg>

    </bean>

</beans>
```

---

# Understanding the XML

## Bean Declaration

```xml
<bean id="countryList"
      class="java.util.ArrayList">
```

Spring creates an object of

```
ArrayList
```

and stores it as a Bean.

Bean ID

```
countryList
```

Bean Type

```
ArrayList
```

---

# Constructor Argument

```xml
<constructor-arg>
```

This tells Spring

while creating the ArrayList,

pass the following values to its constructor.

---

# List Tag

```xml
<list>
```

This represents a Java List.

Everything inside this tag becomes an element of the List.

---

# Country Bean

```xml
<bean class="com.cognizant.springlearn.model.Country">
```

Creates one Country object.

---

## Property Injection

```xml
<property name="code" value="IN"/>
```

Spring internally executes

```java
country.setCode("IN");
```

Similarly,

```xml
<property name="name" value="India"/>
```

becomes

```java
country.setName("India");
```

Spring repeats the same process

for every Country Bean.

Finally,

it creates

```
ArrayList

↓

India

↓

United States

↓

Japan

↓

Germany
```

---

# Country.java

The Country model remains unchanged.

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

# Why Didn't Country.java Change?

In the previous exercise,

one Country object was required.

Now,

many Country objects are required.

However,

each individual Country still contains

- Code
- Name

Therefore,

the Country class remains exactly the same.

The only difference is that

instead of creating

```
Country
```

Spring now creates

```
List<Country>
```

---

# Case-Insensitive Search

## Definition

A case-insensitive comparison ignores the difference between uppercase and lowercase letters.

Example

The following values are treated as equal.

```
IN

in

In

iN
```

---

# equals() vs equalsIgnoreCase()

## equals()

```java
"IN".equals("in")
```

Result

```
false
```

because

```
IN ≠ in
```

---

## equalsIgnoreCase()

```java
"IN".equalsIgnoreCase("in")
```

Result

```
true
```

because

```
Uppercase

↓

Lowercase

↓

Compared Ignoring Case
```

---

# Why Are We Using equalsIgnoreCase()?

Suppose the XML stores

```
IN
```

The client may send

```
in

IN

In

iN
```

All of these should return

```json
{
    "code":"IN",
    "name":"India"
}
```

Using

```java
equalsIgnoreCase()
```

ensures that the search succeeds regardless of the letter case entered by the client.

---

# Key Points to Remember

- A Collection stores multiple objects.
- `List<Country>` stores multiple Country objects.
- Spring creates the complete list from `country.xml`.
- Each `<bean>` inside `<list>` becomes one Country object.
- `countryList` is the Bean ID of the complete list.
- The `Country` class remains unchanged.
- `equalsIgnoreCase()` performs case-insensitive comparison and satisfies the CTS requirement that the country code search should ignore letter casing.

# DAO (Data Access Object)

Before understanding the implementation, we need to understand what a DAO is and why it is used.

---

# What is DAO?

## Definition

DAO stands for **Data Access Object**.

It is a design pattern responsible for interacting with the application's data source.

The data source may be:

- Database
- XML File
- JSON File
- CSV File
- REST API

A DAO separates the data access logic from the business logic.

---

# Why Do We Need DAO?

Imagine an online shopping application.

Suppose we need to retrieve product information.

Without DAO

```
Controller

↓

Database
```

The Controller directly accesses the database.

This approach has several disadvantages.

- Controller becomes complex.
- Business logic and data access logic become mixed.
- Difficult to maintain.
- Difficult to test.

Instead, enterprise applications use a DAO.

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

only the DAO knows how to access the data.

If tomorrow the data source changes,

only the DAO needs modification.

---

# DAO in This Exercise

In this exercise,

the data source is

```
country.xml
```

The DAO loads the complete list of countries from the XML file.

Then it returns the list to the Service layer.

---

# CountryDao.java

```java
package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDao {

    @SuppressWarnings("unchecked")
    public List<Country> getCountryList() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        return (List<Country>) context.getBean("countryList");

    }

}
```

---

# Code Explanation

## Package

```java
package com.cognizant.springlearn.dao;
```

Places the class inside the DAO package.

---

## Import Statements

```java
import java.util.List;
```

Imports Java's List interface because multiple Country objects are returned.

---

```java
import org.springframework.context.ApplicationContext;
```

Imports the Spring IoC Container.

---

```java
import org.springframework.context.support.ClassPathXmlApplicationContext;
```

Used to load the XML configuration file.

---

```java
@Repository
```

Marks this class as a Repository.

Spring automatically creates an object of this class during component scanning.

---

## Method

```java
public List<Country> getCountryList()
```

Returns the complete list of Country objects.

Unlike the previous exercise,

it no longer returns a single Country.

---

## Loading XML

```java
ApplicationContext context =
        new ClassPathXmlApplicationContext("country.xml");
```

Spring performs the following operations.

```
Read country.xml

↓

Find countryList Bean

↓

Create ArrayList

↓

Create Country Objects

↓

Store Inside IoC Container
```

---

## Retrieving Bean

```java
return (List<Country>) context.getBean("countryList");
```

Spring searches for

```
countryList
```

inside

```
country.xml
```

and returns

```
List<Country>
```

containing all countries.

---

# Service Layer

## Definition

The Service Layer contains the application's business logic.

It acts as a bridge between the Controller and DAO.

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

before returning a country,

we need to

- Validate the country code
- Check user permissions
- Log requests
- Apply business rules

All these operations belong in the Service layer.

---

# CountryService.java

```java
package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.CountryDao;
import com.cognizant.springlearn.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public Country getCountry(String code) {

        List<Country> countryList = countryDao.getCountryList();

        for (Country country : countryList) {

            if (country.getCode().equalsIgnoreCase(code)) {

                return country;

            }

        }

        return null;

    }

}
```

---

# Code Explanation

## @Service

```java
@Service
```

Marks this class as the Service Layer.

Spring automatically creates a Service Bean.

---

## Dependency Injection

```java
@Autowired
private CountryDao countryDao;
```

Spring automatically injects the DAO object.

No need to create it using

```java
new CountryDao();
```

---

## getCountry()

```java
public Country getCountry(String code)
```

Receives the country code from the Controller.

Example

```
in

us

jp
```

---

## Retrieve Country List

```java
List<Country> countryList =
        countryDao.getCountryList();
```

The Service requests all countries from the DAO.

---

## Iterating Through the List

```java
for (Country country : countryList)
```

Visits every Country object one by one.

Example

```
India

↓

United States

↓

Japan

↓

Germany
```

---

## Case-Insensitive Comparison

```java
country.getCode().equalsIgnoreCase(code)
```

Compares

```
IN

↓

in
```

or

```
IN

↓

IN
```

or

```
IN

↓

In
```

All comparisons return

```
true
```

---

## Return Country

```java
return country;
```

As soon as a matching country is found,

it is returned to the Controller.

---

## Country Not Found

```java
return null;
```

If no country matches,

the method returns

```
null
```

In future exercises,

this will be replaced with proper exception handling.

---

# Controller Layer

## Definition

The Controller is the entry point of a Spring MVC application.

It receives HTTP requests,

calls the Service layer,

and returns HTTP responses.

---

# CountryController.java

```java
package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {

        return countryService.getCountry(code);

    }

}
```

---

# Code Explanation

## @RestController

```java
@RestController
```

Marks this class as a REST Controller.

Spring automatically converts returned Java objects into JSON.

---

## Dependency Injection

```java
@Autowired
private CountryService countryService;
```

Spring injects the Service Bean.

---

## @GetMapping

```java
@GetMapping("/countries/{code}")
```

Maps the URL

```
/countries/{code}
```

to this method.

Example

```
GET /countries/in
```

calls

```java
getCountry("in")
```

---

## @PathVariable

```java
@PathVariable String code
```

Extracts the value from the URL.

Example

```
URL

↓

/countries/in

↓

code = "in"
```

Spring automatically performs this mapping.

---

## Calling Service

```java
return countryService.getCountry(code);
```

The Controller forwards the request to the Service layer.

It does not search the list itself.

---

# Request Flow

```
Browser

↓

GET /countries/in

↓

CountryController

↓

CountryService

↓

CountryDao

↓

country.xml

↓

List<Country>

↓

Search Matching Country

↓

Country Object

↓

Controller

↓

JSON Response

↓

Browser
```

---

# Key Points to Remember

- DAO is responsible for data access.
- Service contains business logic.
- Controller handles HTTP requests.
- `@GetMapping` maps GET requests.
- `@PathVariable` extracts values from the URL.
- `List<Country>` stores multiple Country objects.
- The Service searches the list using `equalsIgnoreCase()`.
- The matching Country object is returned as a JSON response.

  # Internal Working of the Application

Now that we have understood the Controller, Service, and DAO layers, let us understand what happens internally when a client requests a specific country.

Suppose the client enters the following URL.

```
http://localhost:8083/countries/in
```

Several Spring Boot components work together before the JSON response reaches the client.

---

# Complete Request Processing Flow

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

List<Country>

        │

        ▼

Search Matching Country

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

## Step 1 – Client Sends Request

The user enters

```
http://localhost:8083/countries/in
```

or Postman sends

```
GET /countries/in
```

This creates an HTTP GET request.

---

## Step 2 – Embedded Tomcat Receives the Request

Spring Boot starts an Embedded Tomcat server.

Tomcat listens for incoming HTTP requests.

Whenever a request arrives,

Tomcat forwards it to Spring MVC.

Tomcat does **not** execute application logic.

---

## Step 3 – DispatcherServlet Receives the Request

Every HTTP request first reaches

```
DispatcherServlet
```

DispatcherServlet is known as the **Front Controller** of Spring MVC.

Its responsibilities are

- Receive all requests
- Find the correct controller
- Execute the appropriate method
- Return the HTTP response

---

## Step 4 – Handler Mapping

DispatcherServlet asks

```
HandlerMapping
```

Which method should execute for

```
/countries/in
```

HandlerMapping searches all controller methods.

It finds

```java
@GetMapping("/countries/{code}")
public Country getCountry(@PathVariable String code)
```

Now Spring knows which method should process the request.

---

## Step 5 – Extracting the Path Variable

The requested URL is

```
/countries/in
```

Spring automatically extracts

```
in
```

and stores it in

```java
String code
```

The Controller receives

```java
code = "in"
```

No manual string parsing is required.

---

## Step 6 – Controller Calls Service

The Controller executes

```java
return countryService.getCountry(code);
```

Execution moves to the Service layer.

---

## Step 7 – Service Requests Data

The Service executes

```java
countryDao.getCountryList();
```

Execution moves to the DAO layer.

---

## Step 8 – DAO Loads XML

The DAO creates

```java
ApplicationContext context =
new ClassPathXmlApplicationContext("country.xml");
```

Spring performs the following operations.

```
Read country.xml

↓

Identify countryList Bean

↓

Create ArrayList

↓

Create Country Objects

↓

Store Objects Inside IoC Container
```

---

## Step 9 – Retrieve Country List

DAO executes

```java
context.getBean("countryList");
```

Spring returns

```
List<Country>

↓

India

↓

United States

↓

Japan

↓

Germany
```

The DAO returns the list to the Service.

---

## Step 10 – Searching the List

The Service executes

```java
for (Country country : countryList)
```

Each Country object is checked one by one.

```
India

↓

United States

↓

Japan

↓

Germany
```

---

## Step 11 – Case-Insensitive Comparison

For every Country object,

the following comparison is performed.

```java
country.getCode().equalsIgnoreCase(code)
```

Suppose

XML

```
IN
```

User Input

```
in
```

Comparison

```
IN

↓

equalsIgnoreCase()

↓

in

↓

true
```

The matching Country object is returned.

---

## Step 12 – JSON Conversion

The Controller returns

```java
Country
```

Spring Boot now converts the Java object into JSON.

This conversion is performed by the **Jackson** library.

Country Object

```
Country

↓

Code = IN

↓

Name = India
```

becomes

```json
{
    "code":"IN",
    "name":"India"
}
```

This process is called **Serialization**.

---

# What is Jackson?

## Definition

Jackson is a Java library used by Spring Boot to convert

- Java Objects → JSON
- JSON → Java Objects

Spring Boot automatically configures Jackson through

```
spring-boot-starter-web
```

No additional configuration is required.

---

# HTTP Request

```
GET /countries/in HTTP/1.1

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

# Sequence Diagram

```
Browser

     │

GET /countries/in

     ▼

DispatcherServlet

     ▼

CountryController

     ▼

CountryService

     ▼

CountryDao

     ▼

country.xml

     ▼

List<Country>

     ▼

Search Country

     ▼

Return Country

     ▼

Jackson

     ▼

JSON Response

     ▼

Browser
```

---

# Memory Diagram

```
JVM

──────────────────────────────────────

Heap Memory

──────────────────────────────────────

ApplicationContext

│

├── CountryController Bean

├── CountryService Bean

├── CountryDao Bean

├── countryList Bean

│      │

│      ├── Country(IN)

│      ├── Country(US)

│      ├── Country(JP)

│      └── Country(DE)

└── DispatcherServlet

──────────────────────────────────────

Method Area

──────────────────────────────────────

Country.class

CountryController.class

CountryService.class

CountryDao.class

Spring Framework Classes

──────────────────────────────────────
```

---

# Best Practices

- Follow the layered architecture (Controller → Service → DAO).
- Keep business logic inside the Service layer.
- Keep data access inside the DAO layer.
- Use `@PathVariable` for resource identifiers.
- Use meaningful REST URLs such as `/countries/{code}`.
- Perform case-insensitive comparisons using `equalsIgnoreCase()` when required.
- Return Java objects instead of manually constructing JSON.
- Let Spring Boot and Jackson handle JSON conversion automatically.

---

# Common Mistakes

## 1. Using `equals()` Instead of `equalsIgnoreCase()`

Wrong

```java
country.getCode().equals(code);
```

Searching for

```
in
```

will not match

```
IN
```

Correct

```java
country.getCode().equalsIgnoreCase(code);
```

---

## 2. Accessing XML Directly from the Controller

Wrong

```
Controller

↓

country.xml
```

Correct

```
Controller

↓

Service

↓

DAO

↓

country.xml
```

---

## 3. Creating DAO Objects Manually

Wrong

```java
CountryDao dao = new CountryDao();
```

Correct

```java
@Autowired
private CountryDao countryDao;
```

---

## 4. Returning a String Instead of a Country Object

Wrong

```java
return "India";
```

Correct

```java
return country;
```

Spring Boot automatically converts the object into JSON.

---

# Interview Questions

### 1. What is a Path Variable?

A Path Variable is a value embedded in the URL that Spring extracts automatically using the `@PathVariable` annotation.

---

### 2. What is the difference between `@RequestMapping` and `@GetMapping`?

`@RequestMapping` can map multiple HTTP methods, whereas `@GetMapping` is specifically designed for HTTP GET requests.

---

### 3. Why do we use `@PathVariable`?

To extract dynamic values from the URL and pass them directly to a controller method.

---

### 4. Why is `equalsIgnoreCase()` used?

It performs case-insensitive comparison, allowing values like `IN`, `in`, `In`, and `iN` to be treated as equal.

---

### 5. What is a DAO?

DAO (Data Access Object) is responsible for retrieving data from the application's data source.

---

### 6. Why do we use a Service layer?

The Service layer contains business logic and separates the Controller from the DAO.

---

### 7. What is `ApplicationContext`?

It is the Spring IoC Container responsible for creating, storing, and managing Spring Beans.

---

### 8. What is Jackson?

Jackson is the library used by Spring Boot to automatically convert Java objects into JSON.

---

### 9. What happens when the requested country code is not found?

In the current implementation, the Service returns `null`. In production applications, this is typically replaced with exception handling (for example, returning HTTP 404 Not Found).

---

### 10. Why is layered architecture used?

It separates responsibilities, improves maintainability, supports testing, and follows enterprise software design principles.

---

# Quick Revision

- `@GetMapping` maps HTTP GET requests.
- `@PathVariable` extracts values from the URL.
- `List<Country>` stores multiple Country objects.
- `country.xml` contains the list of Country Beans.
- `CountryDao` loads the list from XML.
- `CountryService` searches the list.
- `equalsIgnoreCase()` enables case-insensitive searching.
- `CountryController` returns the matching Country object.
- `DispatcherServlet` handles every incoming request.
- Jackson converts the returned Java object into JSON automatically.
- The response for this exercise is:

```json
{
    "code":"IN",
    "name":"India"
}
```

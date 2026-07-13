# Part 3 – Create Authentication Controller

## Week 3 – Spring REST using Spring Boot 3

### JWT Hands-on

---

# Introduction

In the previous exercises, we secured our REST APIs using Spring Security and created custom users with different roles.

At this stage, users can authenticate themselves using **HTTP Basic Authentication** by sending their username and password with every request.

However, there is one major limitation.

The client must send the username and password repeatedly for every API call.

For example,

```
GET /countries/in
```

The client sends

```
Username

↓

user

Password

↓

pwd
```

Again,

```
GET /countries/us
```

The client sends

```
Username

↓

user

Password

↓

pwd
```

Again,

```
GET /countries/jp
```

The client sends

```
Username

↓

user

Password

↓

pwd
```

This happens for every request.

Although HTTP Basic Authentication is simple,

it is not the preferred authentication mechanism for modern REST APIs.

Instead,

modern applications authenticate the user **once** and return a **token**.

The client then sends that token with every future request instead of sending the username and password repeatedly.

This exercise introduces the first step toward implementing that mechanism by creating an **Authentication Controller**.

---

# Exercise Objective

The objective of this exercise is to create an Authentication Controller that exposes an endpoint for authenticating users.

Initially,

the controller simply receives the authentication request and returns a placeholder response.

Later exercises will enhance this controller to

- Read the Authorization Header
- Decode credentials
- Generate JWT
- Return JWT
- Authenticate future requests using JWT

This exercise lays the foundation for the remaining JWT implementation.

---

# Problem Statement

Suppose our application contains

```
GET

/countries/in
```

Every request requires

```
Username

↓

Password
```

The client repeatedly sends

```
user

↓

pwd
```

for every API.

Problems with this approach

- Credentials travel with every request.
- Password exposure risk increases.
- Client repeatedly sends sensitive information.
- Not suitable for large enterprise applications.
- Not suitable for distributed systems.
- Difficult for mobile applications.
- Difficult for microservices.

Instead,

the application should authenticate the user once.

Example

```
Username

↓

Password

↓

Authentication Successful

↓

Generate Token

↓

Return Token
```

Future requests become

```
Bearer Token

↓

REST API

↓

Response
```

Instead of

```
Username

↓

Password
```

This is the reason an Authentication Controller is required.

---

# Why Do We Need an Authentication Controller?

Imagine an online banking application.

Whenever a customer opens the mobile application,

the first screen asks for

```
Username

↓

Password
```

After successful login,

the application does **not** ask for the password every time the customer checks

- Balance
- Transactions
- Mini Statement
- Profile

Instead,

the server generates

```
Authentication Token
```

The mobile application stores that token.

Every future request becomes

```
Client

↓

Authentication Token

↓

Server

↓

Response
```

The password is not transmitted repeatedly.

This is safer and more efficient.

The Authentication Controller is responsible for creating this authentication entry point.

---

# What is an Authentication Endpoint?

## Definition

An Authentication Endpoint is a REST API responsible for verifying user credentials and initiating the authentication process.

Its responsibilities include

- Receiving authentication requests
- Validating credentials
- Identifying the user
- Returning an authentication response

In JWT-based applications,

the authentication response usually contains a JWT token.

---

# Authentication Endpoint in This Exercise

In this exercise,

we create

```
GET

/authenticate
```

Initially,

it returns

```json
{
    "token":""
}
```

The token is intentionally empty.

Later,

this endpoint will return an actual JWT.

---

# Why Do We Use `/authenticate`?

Instead of exposing every API publicly,

applications first authenticate the user.

Example

```
POST

/login
```

or

```
POST

/authenticate
```

The user provides credentials.

The server verifies them.

If authentication succeeds,

the server returns an authentication response.

Only after this step can the user access secured resources.

---

# Authentication Flow in This Exercise

```
Client

↓

GET /authenticate

↓

Spring Security

↓

Validate Username

↓

Validate Password

↓

AuthenticationController

↓

Return Response

↓

Client
```

Currently,

the response contains

```json
{
    "token":""
}
```

In later exercises,

the response becomes

```json
{
    "token":"eyJhbGc..."
}
```

---

# Stateless Authentication

## Definition

Stateless Authentication is an authentication mechanism in which the server does **not** store user session information.

Every request contains all the information required to authenticate the client.

In JWT-based authentication,

this information is the JWT token.

The server does not remember previous requests.

Each request is processed independently.

---

# Why Stateless Authentication?

Suppose an application serves

```
10 Million Users
```

If the server stores a session for every user,

memory consumption becomes enormous.

Instead,

the server generates a token.

```
Authenticate Once

↓

Generate Token

↓

Client Stores Token

↓

Client Sends Token

↓

Server Validates Token

↓

Response
```

The server no longer needs to remember every logged-in user.

This makes stateless authentication highly scalable.

---

# Stateful vs Stateless Authentication

## Stateful Authentication

```
Client

↓

Login

↓

Server Creates Session

↓

Session Stored in Memory

↓

Future Requests

↓

Session Validation

↓

Response
```

The server stores session information.

---

## Stateless Authentication

```
Client

↓

Authenticate

↓

Receive Token

↓

Store Token

↓

Future Requests

↓

Send Token

↓

Server Validates Token

↓

Response
```

The server stores no session.

Each request is self-contained.

JWT follows this stateless model.

---

# Real-World Analogy

Imagine entering a large technology conference.

### Step 1 – Registration

You visit the registration desk.

You provide

- Identity Proof
- Registration Details

The organizer verifies your identity.

This is similar to calling

```
/authenticate
```

---

### Step 2 – Receive Entry Badge

After verification,

you receive an entry badge.

```
Registration

↓

Verified

↓

Conference Badge
```

The badge proves that you are authenticated.

---

### Step 3 – Enter Conference Halls

Whenever you enter a hall,

security checks only your badge.

They do **not** ask you to register again.

Similarly,

a JWT token replaces repeated username and password verification.

The Authentication Controller performs the registration step.

Future JWT requests use the generated token instead of repeatedly sending user credentials.

---

# Enterprise Usage

Authentication Controllers are present in almost every enterprise application.

Examples include

- Internet Banking
- Google
- Microsoft
- GitHub
- Amazon
- Flipkart
- Netflix
- Cloud Platforms
- Government Portals
- Healthcare Systems

Although the implementation details may differ,

every modern application exposes an authentication endpoint responsible for validating users and issuing an authentication artifact such as a session identifier or a JWT.

This exercise introduces that endpoint, which becomes the foundation for all subsequent JWT-based authentication in the application.

# HTTP Headers

Before understanding the implementation of the `AuthenticationController`, we need to understand how information travels between a client and a server.

Whenever a Browser, Postman, Mobile Application, or another Server sends an HTTP request, the request contains much more than just the URL.

It contains additional information called **HTTP Headers**.

Without HTTP Headers,

the server would not know

- Who sent the request
- What data format is expected
- How the client authenticated itself
- What language is preferred
- Which content type is being sent

Headers provide metadata (information about the request) rather than the actual business data.

---

# What is an HTTP Header?

## Definition

An HTTP Header is a collection of key-value pairs that provide additional information about an HTTP request or HTTP response.

Headers do not contain the main data.

Instead,

they describe the request or response.

Example

```
GET /authenticate HTTP/1.1

Host: localhost:8083

Authorization: Basic dXNlcjpwd2Q=

Accept: application/json

User-Agent: PostmanRuntime
```

Here,

```
Authorization

Accept

Host

User-Agent
```

are all HTTP Headers.

---

# Structure of an HTTP Header

Every header follows the format

```
Header Name

:

Header Value
```

Example

```
Authorization

:

Basic dXNlcjpwd2Q=
```

Another example

```
Content-Type

:

application/json
```

---

# Why Are HTTP Headers Needed?

Suppose a client sends

```
GET

/countries/in
```

How does the server know

- whether the client is authenticated?
- whether JSON is expected?
- which language is preferred?

The URL alone is not enough.

Headers carry this additional information.

---

# Common HTTP Headers

| Header | Purpose |
|---------|---------|
| Host | Server address |
| Authorization | User authentication information |
| Content-Type | Format of request body |
| Accept | Expected response format |
| User-Agent | Information about the client |
| Cache-Control | Controls caching |

In this exercise,

the most important header is

```
Authorization
```

---

# What is the Authorization Header?

## Definition

The Authorization Header is an HTTP Header used to send authentication information from the client to the server.

Whenever a secured REST API is called,

the client includes credentials inside this header.

Example

```
Authorization

↓

Basic dXNlcjpwd2Q=
```

Later,

during JWT authentication,

the same header changes to

```
Authorization

↓

Bearer eyJhbGc...
```

---

# Why Is the Authorization Header Required?

Suppose the client requests

```
GET /countries/in
```

Without the Authorization Header,

the server has no way of identifying the client.

Instead,

the client sends

```
Authorization

↓

Credentials
```

The server reads the credentials,

verifies them,

and decides whether to allow access.

---

# Authorization Header in This Exercise

During this exercise,

Postman sends

```
Username

↓

user

Password

↓

pwd
```

Spring Security automatically converts these credentials into

```
Authorization

↓

Basic dXNlcjpwd2Q=
```

The Authentication Controller receives this header.

---

# What is HTTP Basic Authentication?

## Definition

HTTP Basic Authentication is one of the simplest authentication mechanisms supported by the HTTP protocol.

The client sends

```
Username

↓

Password
```

with every request.

Before sending,

the credentials are combined.

Example

```
user

↓

:

↓

pwd
```

Result

```
user:pwd
```

This string is encoded using Base64.

The encoded value becomes

```
dXNlcjpwd2Q=
```

Finally,

the Authorization Header becomes

```
Authorization

↓

Basic dXNlcjpwd2Q=
```

---

# Internal Structure of Basic Authentication

```
Username

↓

user

Password

↓

pwd

↓

Combine

↓

user:pwd

↓

Base64 Encode

↓

dXNlcjpwd2Q=

↓

Authorization Header

↓

Basic dXNlcjpwd2Q=
```

This is exactly what Spring Security receives.

---

# What is Base64 Encoding?

## Definition

Base64 is an encoding technique used to convert binary or text data into ASCII characters.

It is commonly used when data needs to travel safely over communication protocols.

Important

Base64 is **not encryption**.

It is only encoding.

Anyone can decode Base64.

---

# Why Is Base64 Used?

HTTP Headers contain only textual information.

Suppose the credentials are

```
user:pwd
```

Instead of sending them directly,

HTTP Basic Authentication sends

```
dXNlcjpwd2Q=
```

This avoids problems with special characters during transmission.

Again,

Base64 does **not** hide the password securely.

Therefore,

HTTP Basic Authentication should always be used over HTTPS.

---

# Base64 Encoding Process

```
Original Text

↓

user:pwd

↓

UTF-8 Bytes

↓

Base64 Encoding

↓

dXNlcjpwd2Q=
```

---

# Base64 Decoding

Inside our Authentication Controller,

the reverse operation occurs.

```
Authorization Header

↓

Basic dXNlcjpwd2Q=

↓

Remove "Basic "

↓

dXNlcjpwd2Q=

↓

Base64 Decode

↓

user:pwd
```

Later,

the username and password are separated.

---

# What is @RequestHeader?

## Definition

`@RequestHeader` is a Spring MVC annotation used to read HTTP Header values from incoming requests.

Instead of manually parsing the HTTP request,

Spring automatically extracts the required header.

Example

```java
@RequestHeader("Authorization")
String authHeader
```

Spring automatically performs

```
Authorization Header

↓

Extract Value

↓

Store in authHeader
```

No manual parsing is required.

---

# Why Are We Using @RequestHeader?

Without `@RequestHeader`,

developers would need to access the raw HTTP request object and search for headers manually.

Spring simplifies this process.

Instead of writing complex code,

one annotation is sufficient.

---

# Logging Using SLF4J

During authentication,

it is useful to know

- Whether the request reached the controller.
- Which Authorization Header was received.
- Whether credentials were decoded correctly.
- Which username was extracted.

Instead of using

```java
System.out.println()
```

enterprise applications use **SLF4J**.

---

# What is SLF4J?

## Definition

SLF4J (Simple Logging Facade for Java) is a logging abstraction used by enterprise Java applications.

It provides a common logging API independent of the actual logging implementation.

Spring Boot uses SLF4J by default.

---

# Logger

A `Logger` object is responsible for writing log messages.

Example

```java
private static final Logger LOGGER =
LoggerFactory.getLogger(AuthenticationController.class);
```

This creates a logger for the `AuthenticationController`.

---

# LoggerFactory

`LoggerFactory` is a utility class used to create Logger objects.

Instead of manually creating logger instances,

developers use

```java
LoggerFactory.getLogger(...)
```

Spring automatically configures the logging framework.

---

# Logging Levels

SLF4J supports multiple logging levels.

| Level | Purpose |
|--------|----------|
| TRACE | Very detailed information |
| DEBUG | Debugging information |
| INFO | General application events |
| WARN | Warning messages |
| ERROR | Errors and exceptions |

In this exercise,

we mainly use

```java
LOGGER.info(...)
```

to trace the authentication flow.

---

# What is Map<String, String>?

## Definition

A `Map` is a Java Collection used to store data as **key-value pairs**.

Example

```
Key

↓

token

Value

↓

eyJhbGc...
```

Unlike a List,

a Map stores values using keys.

---

# Why Are We Returning Map<String, String>?

At this stage,

our controller needs to return

```json
{
    "token":""
}
```

Instead of creating a separate Java class,

we temporarily use

```java
Map<String,String>
```

Spring Boot automatically converts the Map into JSON.

Example

```java
Map<String,String> response = new HashMap<>();

response.put("token","");
```

becomes

```json
{
    "token":""
}
```

Later,

this empty string will be replaced with the actual JWT.

---

# JSON Response Generation

When the controller returns

```java
Map<String,String>
```

Spring Boot automatically uses **Jackson** to convert it into JSON.

Flow

```
Map<String,String>

↓

Jackson Library

↓

JSON

↓

HTTP Response
```

The client receives

```json
{
    "token":""
}
```

without the developer writing any JSON conversion code.

This automatic object-to-JSON conversion is one of the powerful features provided by Spring Boot.

# Project Structure

```
spring-rest-handson
│
├── src
│   ├── main
│   │
│   ├── java
│   │   │
│   │   └── com
│   │       └── cognizant
│   │           └── springlearn
│   │               │
│   │               ├── controller
│   │               │      AuthenticationController.java
│   │               │      CountryController.java
│   │               │
│   │               ├── dao
│   │               │      CountryDao.java
│   │               │
│   │               ├── model
│   │               │      Country.java
│   │               │
│   │               ├── service
│   │               │      CountryService.java
│   │               │
│   │               ├── security
│   │               │      SecurityConfig.java
│   │               │
│   │               └── SpringRestHandsonApplication.java
│   │
│   └── resources
│       │
│       ├── application.properties
│       └── country.xml
│
└── pom.xml
```

---

# Components Used in This Exercise

| Component | Responsibility |
|-----------|----------------|
| AuthenticationController | Provides the `/authenticate` endpoint |
| SecurityConfig | Secures the authentication endpoint |
| CountryController | Existing REST Controller |
| SLF4J Logger | Logs request processing |
| Authorization Header | Carries user credentials |
| Map<String,String> | Returns authentication response |
| Spring Security | Authenticates the incoming request |

---

# AuthenticationController.java

This is the most important class in this exercise.

It exposes the authentication endpoint.

Complete Code

```java
package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("Start");

        LOGGER.info("Authorization Header : {}", authHeader);

        Map<String, String> response = new HashMap<>();

        response.put("token", "");

        LOGGER.info("End");

        return response;
    }
}
```

---

# Line-by-Line Code Explanation

## @RestController

```java
@RestController
```

This annotation tells Spring Boot that this class is a REST Controller.

It combines two annotations internally.

```
@Controller

+

@ResponseBody
```

Meaning,

every method inside this class returns data directly as an HTTP response instead of rendering an HTML page.

---

## Class Declaration

```java
public class AuthenticationController
```

This class is responsible for handling authentication-related HTTP requests.

At present,

it contains one endpoint.

```
GET

/authenticate
```

Later,

additional authentication-related functionality can also be added here.

---

## Logger Creation

```java
private static final Logger LOGGER =
LoggerFactory.getLogger(AuthenticationController.class);
```

Creates a logger object.

This logger is used to print application logs.

Instead of

```java
System.out.println()
```

enterprise applications use

```
LOGGER.info()

LOGGER.debug()

LOGGER.warn()

LOGGER.error()
```

Logging makes debugging much easier.

---

## @GetMapping

```java
@GetMapping("/authenticate")
```

Maps

```
GET

/authenticate
```

to this Java method.

Whenever a client requests

```
http://localhost:8083/authenticate
```

Spring automatically calls

```
authenticate()
```

---

## @RequestHeader

```java
@RequestHeader("Authorization")
String authHeader
```

Reads the HTTP Authorization Header.

Suppose Postman sends

```
Authorization

↓

Basic dXNlcjpwd2Q=
```

Spring automatically stores

```
Basic dXNlcjpwd2Q=
```

inside

```java
authHeader
```

No manual parsing is required.

---

## Start Log

```java
LOGGER.info("Start");
```

Prints

```
INFO AuthenticationController : Start
```

This indicates that the request has reached the controller.

---

## Authorization Header Log

```java
LOGGER.info("Authorization Header : {}", authHeader);
```

Prints the Authorization Header.

Example

```
Authorization Header

↓

Basic dXNlcjpwd2Q=
```

This helps verify that Spring Security has forwarded the authenticated request correctly.

---

## Creating Response Map

```java
Map<String,String> response =
new HashMap<>();
```

Creates an empty Map.

Initially

```
Map

↓

{}
```

Later,

we insert the token.

---

## Add Token

```java
response.put("token","");
```

Stores

```
Key

↓

token

Value

↓

""
```

The Map becomes

```
{

token :

""

}
```

In later exercises,

the empty string will be replaced by an actual JWT.

---

## End Log

```java
LOGGER.info("End");
```

Indicates that the controller has completed processing.

Console

```
INFO AuthenticationController : End
```

---

## Return Statement

```java
return response;
```

Spring Boot automatically converts

```
Map

↓

JSON
```

using Jackson.

The client receives

```json
{
    "token":""
}
```

---

# Internal Working

Suppose the client sends

```
GET

/authenticate
```

using

```
Username

↓

user

Password

↓

pwd
```

The complete execution flow is

```
Postman

        │

        ▼

Authorization Header

        │

        ▼

Basic Authentication

        │

        ▼

Spring Security

        │

Credentials Valid?

      /         \

    No           Yes

    │             │

401 Unauthorized

                  ▼

AuthenticationController

                  │

                  ▼

@RequestHeader

                  │

                  ▼

Read Authorization Header

                  │

                  ▼

Create Response Map

                  │

                  ▼

token = ""

                  │

                  ▼

Jackson

                  │

                  ▼

JSON Response

                  │

                  ▼

Client
```

Notice that

the controller executes **only after** Spring Security successfully authenticates the user.

---

# Request Flow Diagram

```
Client

        │

        ▼

GET /authenticate

        │

        ▼

Embedded Tomcat

        │

        ▼

Spring Security Filter Chain

        │

Authentication

        │

Credentials Valid?

      /          \

    No            Yes

    │              │

401 Unauthorized

                   ▼

DispatcherServlet

                   ▼

AuthenticationController

                   ▼

Map<String,String>

                   ▼

Jackson

                   ▼

JSON Response
```

---

# JVM Memory Diagram

```
                    JVM

──────────────────────────────────────────

Method Area

──────────────────────────────────────────

AuthenticationController.class

CountryController.class

SecurityConfig.class

Logger.class

LoggerFactory.class

HashMap.class

DispatcherServlet.class

──────────────────────────────────────────

Heap Memory

──────────────────────────────────────────

Spring IoC Container

│

├── AuthenticationController Bean

├── CountryController Bean

├── SecurityConfig Bean

├── Logger Object

└── SecurityFilterChain Bean

──────────────────────────────────────────
```

When the application starts,

Spring creates one instance of `AuthenticationController`.

Every request uses this same controller instance.

---

# Best Practices

- Keep authentication endpoints separate from business controllers.
- Never log passwords or sensitive credentials in production.
- Use SLF4J instead of `System.out.println()`.
- Return structured JSON responses.
- Keep authentication logic focused and simple.
- Use HTTPS whenever transmitting authentication headers.
- In later stages, replace placeholder responses with securely generated JWT tokens.

---

# Common Mistakes

## 1. Forgetting `@RestController`

Without

```java
@RestController
```

Spring treats the class as a normal Java class instead of a REST controller.

---

## 2. Incorrect URL Mapping

Wrong

```java
@GetMapping("/authentication")
```

Correct

```java
@GetMapping("/authenticate")
```

The URL must match the client request.

---

## 3. Incorrect Header Name

Wrong

```java
@RequestHeader("Auth")
```

Correct

```java
@RequestHeader("Authorization")
```

Header names must exactly match the HTTP specification.

---

## 4. Logging Sensitive Information

Avoid logging passwords or JWT tokens in production environments.

Logging credentials is acceptable only for learning purposes and debugging in a controlled environment.

---

## 5. Returning Plain Strings

Instead of

```java
return "Success";
```

return structured JSON objects.

Example

```json
{
    "token":""
}
```

This makes the API easier to consume and extend.

---

# Interview Questions

### 1. What is an Authentication Controller?

An Authentication Controller exposes endpoints responsible for authenticating users and returning authentication-related responses such as JWT tokens.

---

### 2. Why do we create `/authenticate`?

It provides a dedicated endpoint where users authenticate themselves before accessing secured REST APIs.

---

### 3. What does `@RequestHeader` do?

It reads the value of a specified HTTP header from the incoming request and injects it into the controller method.

---

### 4. Why is the Authorization Header important?

It carries authentication information such as Basic Authentication credentials or JWT Bearer tokens.

---

### 5. What is the difference between HTTP Basic Authentication and JWT?

HTTP Basic Authentication sends the username and password with every request.

JWT authenticates once, generates a token, and the client sends only the token with future requests.

---

### 6. Why do we use `Map<String, String>` in this exercise?

It provides a simple way to return a JSON response without creating a dedicated response class.

---

### 7. How does Spring Boot convert a `Map` into JSON?

Spring Boot uses the Jackson library to automatically serialize Java objects such as `Map` into JSON.

---

### 8. Why do we use SLF4J?

SLF4J provides standardized logging with different log levels and integrates seamlessly with Spring Boot.

---

### 9. Does the controller authenticate the user?

No.

Spring Security authenticates the user **before** the request reaches the controller.

The controller simply processes authenticated requests.

---

### 10. Why does the response contain an empty token?

This exercise introduces the authentication endpoint.

The actual JWT generation is implemented in the next parts of the hands-on.

---

# Quick Revision

- `AuthenticationController` exposes the `/authenticate` endpoint.
- `@RestController` makes the class a REST controller.
- `@GetMapping("/authenticate")` maps HTTP GET requests.
- `@RequestHeader("Authorization")` reads the Authorization header.
- SLF4J logs the execution flow.
- `Map<String, String>` is used to create a simple JSON response.
- Spring Boot automatically converts the `Map` to JSON using Jackson.
- Spring Security authenticates the request before the controller executes.
- This exercise prepares the foundation for JWT generation in the upcoming parts.
  

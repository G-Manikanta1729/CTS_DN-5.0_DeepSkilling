# Part 1 – Add Spring Security

## Week 3 – Spring REST using Spring Boot 3

### JWT Hands-on

---

# Introduction

Modern applications are no longer standalone desktop applications. Almost every application today communicates over the Internet through Web Services or REST APIs.

Whenever a client (Browser, Mobile Application, Desktop Application, or another Server) sends a request to a REST API, the server must decide whether that client is allowed to access the requested resource.

Imagine a banking application.

A customer should only be able to view his own account details.

A student should only be able to view his own marks.

An employee should only be able to access company resources after logging in.

If there is no security mechanism, anyone can access sensitive information simply by knowing the URL.

For example,

```
http://localhost:8083/countries/in
```

Without security,

every user can access this endpoint.

There is no verification of

- Who the user is
- Whether the user has logged in
- Whether the user has permission

This creates a serious security risk.

To solve these problems, Spring provides one of the most powerful security frameworks called **Spring Security**.

In this exercise, we begin securing our REST APIs by integrating Spring Security into our Spring Boot application.

Initially, we will secure the APIs using **HTTP Basic Authentication**.

Later exercises will enhance the security using **JWT (JSON Web Token)** authentication.

---

# Exercise Objective

The objective of this exercise is to secure the REST endpoints using Spring Security.

After completing this exercise,

- Every incoming request should be authenticated.
- Unauthorized users should not access REST APIs.
- Spring Security should automatically intercept HTTP requests.
- Users should be required to provide valid credentials before accessing the API.

---

# Problem Statement

Suppose we already developed the following REST API.

```
GET

/countries/in
```

Response

```json
{
    "code":"IN",
    "name":"India"
}
```

Currently,

anyone who knows this URL can access it.

Example

```
User A

↓

GET /countries/in

↓

Response Returned
```

```
Unknown User

↓

GET /countries/in

↓

Response Returned
```

```
Attacker

↓

GET /countries/in

↓

Response Returned
```

There is no security.

The server never asks

```
Who are you?
```

This is extremely dangerous in enterprise applications.

---

# Why Do We Need Security?

Imagine a banking website.

Suppose someone enters

```
https://bank.com/account/1001
```

Should the bank immediately display

- Account Balance
- Transactions
- Personal Details

without checking who the user is?

Obviously,

No.

The application must first verify

```
↓

Username

↓

Password

↓

Identity

↓

Permission

↓

Access Granted
```

Only after successful verification should the user be allowed to access the requested resource.

This verification process is called **Security**.

---

# What is Security?

## Definition

Security is the process of protecting an application, its resources, and its data from unauthorized access.

Security ensures that

- Only authenticated users can access the application.
- Users access only the resources they are permitted to use.
- Sensitive information remains protected.

In software applications,

security is one of the most important non-functional requirements.

---

# Why Was Spring Security Created?

Before Spring Security,

developers had to implement security manually.

For every request,

they needed to write code to

- Read username
- Read password
- Validate user
- Compare passwords
- Check permissions
- Handle sessions
- Reject invalid users

Example

```java
if(username.equals("admin")
        && password.equals("admin123"))
{

    // Allow Access

}
else
{

    // Reject

}
```

Imagine writing similar code

for

- Login
- Employee Module
- Student Module
- Admin Module
- Reports
- Finance
- Payroll

This leads to

- Duplicate code
- Difficult maintenance
- Poor security
- Higher chances of bugs

Spring Security automates all these responsibilities.

Instead of writing authentication logic repeatedly,

developers simply configure Spring Security.

---

# Problems Before Spring Security

Without a security framework,

developers faced many challenges.

## Manual Authentication

Every application had to create its own login system.

---

## Manual Session Management

Developers had to store and manage logged-in users manually.

---

## Password Encryption

Developers needed to write encryption logic.

Incorrect implementations often led to security vulnerabilities.

---

## Authorization

Checking whether a user could access a particular page required custom code.

Example

```java
if(userRole.equals("ADMIN"))
```

Such checks became scattered across the application.

---

## Security Bugs

Small mistakes could expose confidential data.

For example,

forgetting a single validation could allow unauthorized users to access sensitive resources.

---

# What is Authentication?

## Definition

Authentication is the process of verifying the identity of a user.

Authentication answers the question

```
Who are you?
```

The application verifies the credentials supplied by the user.

Common credentials include

- Username
- Password
- OTP
- Fingerprint
- Face Recognition
- Smart Card

Only after successful verification does the application identify the user.

---

# Authentication Example

Suppose a user logs into an online banking application.

The user enters

```
Username

↓

john

Password

↓

john123
```

The server checks

```
Database

↓

Username Exists?

↓

Password Correct?

↓

Yes

↓

Authenticated
```

Now the application knows

```
This user is John.
```

Authentication only verifies identity.

It does not decide what the user is allowed to do.

---

# What is Authorization?

## Definition

Authorization is the process of determining what an authenticated user is allowed to access.

Authorization answers the question

```
What are you allowed to do?
```

Example

Suppose three users exist.

```
Admin

Faculty

Student
```

All three users are authenticated.

However,

their permissions are different.

```
Admin

↓

Can Add Users

↓

Can Delete Users

↓

Can View Reports
```

```
Faculty

↓

Can Enter Marks

↓

Can View Students
```

```
Student

↓

Can View Marks

↓

Cannot Modify Marks
```

This process is called Authorization.

---

# Authentication vs Authorization

| Authentication | Authorization |
|---------------|---------------|
| Verifies identity | Verifies permissions |
| Answers "Who are you?" | Answers "What can you access?" |
| Happens first | Happens after authentication |
| Uses credentials | Uses roles and permissions |
| Example: Username & Password | Example: ADMIN can delete users |

Both are essential.

Authentication without Authorization is incomplete.

Authorization without Authentication is impossible.

---

# Real-World Analogy

Imagine entering an airport.

### Step 1 – Authentication

At the entrance,

security personnel check your

- Passport
- Identity Card
- Ticket

They verify

```
Who are you?
```

If everything is valid,

you are allowed inside.

This is **Authentication**.

---

### Step 2 – Authorization

After entering,

your boarding pass determines

- Which gate you can enter
- Which flight you can board
- Which lounge you can access

The airport does not allow every passenger to enter every area.

This is **Authorization**.

---

# Security in This Exercise

In this exercise,

our application contains the REST endpoint

```
GET

/countries/in
```

Initially,

everyone can access it.

After adding Spring Security,

the flow becomes

```
Client

↓

Send HTTP Request

↓

Spring Security

↓

Authentication

↓

Valid User ?

↓

Yes

↓

Controller

↓

Response
```

If authentication fails,

the request never reaches the Controller.

Spring Security immediately rejects it with an HTTP **401 Unauthorized** response.

This forms the foundation for all the upcoming JWT exercises, where authentication will evolve from simple HTTP Basic Authentication to secure token-based authentication.

# What is Spring Security?

## Definition

Spring Security is a powerful authentication and authorization framework provided by the Spring ecosystem.

It protects Java applications from unauthorized access by providing built-in security features.

Instead of developers writing security code manually, Spring Security automatically handles authentication, authorization, session management, password encryption, protection against common attacks, and many other security-related tasks.

It is the standard security framework used in almost every enterprise Spring Boot application.

---

# Why Do We Need Spring Security?

Consider our application before adding Spring Security.

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
```

Every client can directly access the controller.

There is no validation.

There is no authentication.

There is no authorization.

Now consider the application after adding Spring Security.

```
Client

      │

      ▼

Spring Security

      │

Authentication

      │

Authorization

      │

      ▼

CountryController

      │

      ▼

CountryService

      │

      ▼

CountryDao
```

Every request first passes through Spring Security.

Only valid requests are allowed to continue.

Invalid requests are rejected immediately.

---

# Features of Spring Security

Spring Security provides numerous built-in features.

## Authentication

Verifies the identity of the user.

Example

```
Username

↓

user

Password

↓

pwd
```

Spring Security verifies whether these credentials are correct.

---

## Authorization

Determines what resources the authenticated user can access.

Example

```
Admin

↓

All APIs
```

```
User

↓

Limited APIs
```

---

## Password Encryption

Passwords are never stored as plain text.

Spring Security supports

- BCrypt
- SCrypt
- PBKDF2
- Argon2

These algorithms securely hash passwords before storing them.

---

## Session Management

Automatically manages user sessions.

Developers do not need to manually store logged-in users.

---

## Protection Against Common Attacks

Spring Security automatically protects applications against

- CSRF
- Session Fixation
- Clickjacking
- Many common web security vulnerabilities

---

## Integration with Spring Boot

Spring Security integrates seamlessly with Spring Boot.

Simply adding the dependency

```xml
<dependency>

    <groupId>org.springframework.boot</groupId>

    <artifactId>spring-boot-starter-security</artifactId>

</dependency>
```

automatically secures the application.

No additional libraries are required.

---

# What Happens After Adding Spring Security?

Suppose our application contains

```
GET

/countries/in
```

Without Spring Security

```
Client

↓

Controller

↓

Response
```

After adding Spring Security

```
Client

↓

Security Filter

↓

Authentication

↓

Authorization

↓

Controller

↓

Response
```

If authentication fails,

the request never reaches the controller.

---

# Spring Security Architecture

```
                HTTP Request

                     │

                     ▼

           Embedded Tomcat Server

                     │

                     ▼

        Spring Security Filter Chain

                     │

        Authentication Filters

                     │

        Authorization Filters

                     │

                     ▼

          DispatcherServlet

                     │

                     ▼

            Spring Controller

                     │

                     ▼

             Business Logic

                     │

                     ▼

             HTTP Response
```

Every incoming request passes through the Security Filter Chain before reaching Spring MVC.

---

# What is a Security Filter?

A Filter is a Java component that intercepts every HTTP request before it reaches the application.

Think of a filter as a security checkpoint.

```
Visitor

↓

Security Check

↓

Allowed?

↓

Yes

↓

Office
```

Similarly,

```
HTTP Request

↓

Security Filter

↓

Authenticated?

↓

Yes

↓

Controller
```

---

# Security Filter Chain

## Definition

The Security Filter Chain is a collection of security filters executed one after another.

Each filter performs a specific task.

Examples

- Read HTTP Request
- Check Authentication
- Validate Password
- Validate JWT
- Check Roles
- Create Security Context

Only after all required filters complete successfully does the request reach the controller.

---

# Request Flow Through Security Filter Chain

```
HTTP Request

        │

        ▼

Security Filter 1

        │

        ▼

Security Filter 2

        │

        ▼

Security Filter 3

        │

        ▼

Security Filter 4

        │

        ▼

DispatcherServlet

        │

        ▼

Controller
```

This layered approach keeps security modular and easy to extend.

---

# What is SecurityFilterChain?

## Definition

`SecurityFilterChain` is the modern Spring Security configuration mechanism introduced in Spring Security 5.7 and used in Spring Security 6.

Instead of extending `WebSecurityConfigurerAdapter` (which has been removed),

we now define a bean of type `SecurityFilterChain`.

Example

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http)
```

Spring automatically registers this bean and uses it to configure security.

---

# Why Was SecurityFilterChain Introduced?

Earlier versions of Spring Security used

```java
extends WebSecurityConfigurerAdapter
```

This approach had several limitations.

- Inheritance-based configuration
- Difficult to customize
- Less flexible
- Harder to understand

Spring Security 6 introduced

```
SecurityFilterChain
```

which follows

- Composition over Inheritance
- Functional Programming Style
- Better readability
- Better modularity

This is the recommended approach for all modern Spring Boot applications.

---

# What is HttpSecurity?

## Definition

`HttpSecurity` is a configuration object used to define how HTTP requests should be secured.

It allows developers to configure

- Authentication
- Authorization
- CSRF
- Login
- Logout
- Session Management
- JWT
- HTTP Basic Authentication

Everything related to web security is configured using `HttpSecurity`.

---

# HTTP Basic Authentication

## Definition

HTTP Basic Authentication is one of the simplest authentication mechanisms.

The client sends

```
Username

↓

Password
```

with every HTTP request.

These credentials are Base64 encoded and placed inside the Authorization header.

Example

```
Authorization

↓

Basic dXNlcjpwd2Q=
```

Here

```
user:pwd
```

is converted into Base64.

The server decodes it,

validates the credentials,

and decides whether to allow the request.

---

# Why Are We Using HTTP Basic Authentication?

This exercise is the first step toward implementing JWT.

Before learning JWT,

we need a simple authentication mechanism.

HTTP Basic Authentication is easy to configure and demonstrates how Spring Security authenticates users.

In the later exercises,

HTTP Basic Authentication will be replaced with JWT-based authentication.

---

# What is CSRF?

## Definition

CSRF stands for

**Cross-Site Request Forgery**.

It is a web security attack where a malicious website tricks a logged-in user into performing unwanted actions on another website.

Example

Suppose a user is logged into an online banking application.

If the user visits a malicious website,

that website may silently send a money transfer request using the user's active session.

Without CSRF protection,

the bank may execute the request.

---

# Why Do We Disable CSRF in REST APIs?

Our application is a REST API.

REST APIs are generally

- Stateless
- Accessed using Postman
- Accessed using Mobile Apps
- Accessed using JWT

They do not rely on browser sessions.

Therefore,

during REST API development,

we commonly disable CSRF.

Example

```java
http.csrf(csrf -> csrf.disable());
```

This configuration is appropriate for this hands-on exercise.

---

# Internal Working of Part 1

```
Browser / Postman

        │

        ▼

HTTP Request

        │

        ▼

Embedded Tomcat

        │

        ▼

Spring Security Filter Chain

        │

Authentication Check

        │

Credentials Valid?

      /      \

    No        Yes

    │          │

401 Unauthorized

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

JSON Response
```

This architecture ensures that unauthorized requests are rejected before they reach any business logic, making Spring Security the first line of defense for every incoming HTTP request.

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

# Project Components

This exercise consists of the following major components.

| Component | Responsibility |
|-----------|----------------|
| pom.xml | Adds Spring Security dependency |
| application.properties | Application configuration |
| SecurityConfig | Configures Spring Security |
| CountryController | Handles HTTP requests |
| CountryService | Business logic |
| CountryDao | Reads data from XML |
| country.xml | Stores Country Beans |
| Country.java | Country model |

---

# Dependency Added

To enable Spring Security, we added the following dependency inside **pom.xml**.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

---

# Why This Dependency?

Spring Boot is modular.

It follows the principle

```
Only include what you need.
```

By default,

Spring Boot does not provide authentication and authorization.

When we add

```xml
spring-boot-starter-security
```

Spring Boot automatically includes

- Spring Security
- Authentication libraries
- Authorization libraries
- Security Filters
- Password Encoder support
- Security Configuration classes

Instead of downloading dozens of individual JAR files,

Spring Boot downloads everything required automatically.

---

# SecurityConfig.java

This is the heart of this exercise.

Complete Code

```java
package com.cognizant.springlearn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth ->
                        auth.anyRequest().authenticated())

                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
```

---

# Line-by-Line Code Explanation

## @Configuration

```java
@Configuration
```

This annotation tells Spring that this class contains Bean configuration.

Spring scans this class during application startup.

Every Bean defined inside this class is registered in the Spring IoC Container.

---

## SecurityConfig Class

```java
public class SecurityConfig
```

This class contains all the security rules of our application.

Whenever an HTTP request arrives,

Spring refers to this configuration to decide

- Which URLs are secured
- Which authentication mechanism should be used
- Whether access should be granted or denied

---

## @Bean

```java
@Bean
```

Marks the method as a Spring Bean producer.

Spring executes this method once during application startup.

The returned object becomes a Bean inside the IoC Container.

---

## SecurityFilterChain

```java
SecurityFilterChain
```

This object contains all the filters responsible for securing HTTP requests.

Internally,

it maintains an ordered chain of security filters.

Example

```
Authentication Filter

↓

Authorization Filter

↓

Exception Filter

↓

Session Filter

↓

CSRF Filter

↓

Controller
```

Every request passes through this chain.

---

## HttpSecurity

```java
HttpSecurity http
```

`HttpSecurity` is the configuration builder for Spring Security.

Using this object,

we specify

- Authentication rules
- Authorization rules
- Login mechanism
- Logout mechanism
- CSRF settings
- JWT configuration
- Session management

Everything related to HTTP security is configured here.

---

## Disable CSRF

```java
http.csrf(csrf -> csrf.disable());
```

Disables Cross-Site Request Forgery protection.

Since this project is a REST API,

clients communicate using

- Postman
- Browser
- Mobile Apps

rather than browser-based HTML forms.

Therefore,

CSRF protection is disabled for this exercise.

---

## Authorize Requests

```java
.authorizeHttpRequests(auth ->
        auth.anyRequest().authenticated())
```

This is the authorization rule.

Meaning

```
Every HTTP Request

↓

Must be Authenticated
```

There are no public endpoints.

Every request requires valid credentials.

---

## HTTP Basic Authentication

```java
.httpBasic(Customizer.withDefaults());
```

Enables HTTP Basic Authentication.

When an unauthenticated client accesses a secured API,

Spring automatically asks for

```
Username

Password
```

The browser displays a login dialog.

Postman sends credentials using the Authorization header.

---

## Build Security Configuration

```java
return http.build();
```

This finalizes the security configuration.

Spring converts the configuration into a `SecurityFilterChain` object.

That object is then used for every incoming request.

---

# Internal Working of the Application

Suppose the client sends

```
GET

/countries/in
```

The request flows as follows.

```
Client

        │

        ▼

Embedded Tomcat

        │

        ▼

SecurityFilterChain

        │

        ▼

Authentication Check

        │

Credentials Present?

      /        \

    No          Yes

    │            │

401 Unauthorized

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

Country Object

                 ▼

JSON Response
```

Notice that the request reaches the controller **only after** passing through the security filters.

---

# JVM Memory Diagram

```
                    JVM

────────────────────────────────────────

Method Area

────────────────────────────────────────

SecurityConfig.class

CountryController.class

CountryService.class

CountryDao.class

Country.class

DispatcherServlet.class

SecurityFilterChain.class

────────────────────────────────────────

Heap Memory

────────────────────────────────────────

Spring IoC Container

│

├── SecurityConfig Bean

├── SecurityFilterChain Bean

├── CountryController Bean

├── CountryService Bean

├── CountryDao Bean

└── Country Bean(s)

────────────────────────────────────────
```

When the application starts,

Spring creates these beans and stores them inside the IoC Container.

The same objects are reused for every incoming request.

---

# Best Practices

- Keep all security-related configuration in a dedicated `SecurityConfig` class.
- Use `SecurityFilterChain` for Spring Boot 3 and Spring Security 6.
- Avoid exposing sensitive endpoints without authentication.
- Use HTTPS in production so credentials are encrypted during transmission.
- Keep CSRF enabled for traditional web applications and disable it only for stateless REST APIs when appropriate.
- Organize security classes under a separate `security` package for better maintainability.

---

# Common Mistakes

## 1. Forgetting the Spring Security Dependency

Without

```xml
spring-boot-starter-security
```

none of the security configuration will work.

---

## 2. Using `WebSecurityConfigurerAdapter`

This class has been removed from Spring Security 6.

Modern applications should use `SecurityFilterChain`.

---

## 3. Forgetting `http.build()`

Without

```java
return http.build();
```

the security configuration is incomplete.

---

## 4. Disabling Authentication Accidentally

Example

```java
.anyRequest().permitAll()
```

This makes every endpoint publicly accessible.

Use

```java
.anyRequest().authenticated()
```

when the application should require authentication.

---

## 5. Assuming HTTP Basic is Production Ready

HTTP Basic is useful for learning and simple APIs.

Enterprise applications usually use

- JWT
- OAuth2
- OpenID Connect

for stronger security.

---

# Interview Questions

### 1. What is Spring Security?

Spring Security is a framework that provides authentication, authorization, and protection against common web security vulnerabilities for Spring applications.

---

### 2. Why do we add `spring-boot-starter-security`?

It automatically brings all the libraries required for securing a Spring Boot application.

---

### 3. What is `SecurityFilterChain`?

It is the modern mechanism used to configure Spring Security in Spring Boot 3 and Spring Security 6. It defines the chain of filters that process every incoming HTTP request.

---

### 4. What is `HttpSecurity`?

`HttpSecurity` is a builder used to configure HTTP security such as authentication, authorization, CSRF, session management, and login mechanisms.

---

### 5. Why do we disable CSRF in this exercise?

Because this is a stateless REST API that is tested using Postman or other API clients rather than browser-based forms.

---

### 6. What is HTTP Basic Authentication?

It is a simple authentication mechanism where the client sends a Base64-encoded username and password in the `Authorization` header with each request.

---

### 7. What happens if authentication fails?

Spring Security stops the request immediately and returns an HTTP **401 Unauthorized** response. The request never reaches the controller.

---

### 8. What replaces `WebSecurityConfigurerAdapter` in Spring Boot 3?

`SecurityFilterChain`.

---

# Quick Revision

- Spring Security secures REST APIs.
- Authentication verifies **who** the user is.
- Authorization verifies **what** the user can access.
- `spring-boot-starter-security` enables Spring Security.
- `SecurityConfig` contains all security rules.
- `SecurityFilterChain` is the modern configuration mechanism.
- `HttpSecurity` is used to define authentication and authorization rules.
- `.anyRequest().authenticated()` secures every endpoint.
- `.httpBasic()` enables HTTP Basic Authentication.
- Every request passes through the **Security Filter Chain** before reaching the controller.

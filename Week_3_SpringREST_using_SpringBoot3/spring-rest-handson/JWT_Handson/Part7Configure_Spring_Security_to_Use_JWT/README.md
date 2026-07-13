# Part 7 – Configure Spring Security to Use JWT

## Week 3 – Spring REST using Spring Boot 3

### JWT Hands-on

---

# Introduction

In the previous exercise (**Part 6 – JWT Authorization Filter**), we successfully created a custom filter that can

- Read the Authorization Header
- Extract the JWT
- Validate the JWT
- Verify the Signature
- Check Expiration
- Extract the Username
- Create the Authentication Object
- Store the Authentication inside the SecurityContext

At this stage, our JWT filter is fully functional.

However,

there is still one important problem.

Spring Security **does not know that our filter exists**.

Simply creating the filter class does **not** make Spring Security execute it.

Our filter is just another Java class until we register it inside the Spring Security configuration.

This exercise completes the JWT authentication implementation by integrating the custom JWT Authorization Filter into the Spring Security Filter Chain.

After this configuration,

every secured request automatically passes through our JWT filter before reaching the controller.

---

# Exercise Objective

The objective of this exercise is to configure Spring Security so that it uses our custom JWT Authorization Filter.

After completing this exercise,

our application will

- Register the JWT Authorization Filter.
- Execute the filter for every incoming request.
- Authenticate users using JWT.
- Protect REST APIs using JWT authentication.
- Reject invalid or missing JWTs.
- Allow valid JWTs to access protected resources.

This is the final step required to build a complete JWT Authentication system.

---

# Problem Statement

Suppose we have already created

```
JwtAuthorizationFilter.java
```

Now,

a client sends

```
GET

/countries/in

Authorization

↓

Bearer eyJhbGc...
```

What happens?

Without registering the filter,

Spring Security performs

```
Incoming Request

↓

Security Filter Chain

↓

Default Filters

↓

Controller
```

Notice that

```
JwtAuthorizationFilter
```

never executes.

As a result,

the JWT is never validated,

the username is never extracted,

and Spring Security still treats the request as unauthenticated.

Eventually,

the client receives

```
401 Unauthorized
```

even though the JWT is valid.

Therefore,

creating the filter alone is **not sufficient**.

It must also be registered with Spring Security.

---

# Why Configure Spring Security?

Spring Security controls

- Authentication
- Authorization
- Session Management
- CSRF Protection
- Filter Execution

Every incoming request passes through Spring Security before reaching the application.

If Spring Security is unaware of our JWT filter,

it cannot use it.

Therefore,

we explicitly configure Spring Security to execute our filter.

---

# Why Isn't Creating the Filter Enough?

Consider a classroom.

Suppose a new teacher joins the school.

The teacher is hired,

but the timetable is never updated.

What happens?

Students continue attending classes,

but the new teacher never teaches.

Why?

Because the school timetable never scheduled the teacher.

Similarly,

creating

```
JwtAuthorizationFilter
```

only creates the class.

Spring Security still needs instructions such as

```
Execute this filter

Before

UsernamePasswordAuthenticationFilter
```

Only then will the filter participate in request processing.

---

# What is Security Configuration?

## Definition

Security Configuration is the process of defining how Spring Security should protect an application.

The configuration specifies

- Which URLs are protected.
- Which URLs are public.
- Which authentication mechanism should be used.
- Which filters should execute.
- The order in which filters should execute.

In Spring Boot 3,

this configuration is usually performed inside

```
SecurityConfig.java
```

using a

```
SecurityFilterChain
```

bean.

---

# SecurityFilterChain Revisited

A **SecurityFilterChain** is an ordered collection of security filters that process every incoming HTTP request.

Instead of one large security component,

Spring Security divides responsibilities among multiple filters.

Each filter performs a specific task.

Example

```
Request

↓

Filter 1

↓

Filter 2

↓

JWT Authorization Filter

↓

Authorization Filter

↓

Controller
```

Each filter executes one after another.

Only after all required filters finish successfully does the request reach the controller.

---

# How Spring Executes Filters

Whenever a client sends an HTTP request,

Spring Security automatically creates a filter execution pipeline.

```
HTTP Request

↓

SecurityFilterChain

↓

Filter 1

↓

Filter 2

↓

Filter 3

↓

Controller
```

Each filter decides

- Continue
- Reject
- Modify Request

The JWT Authorization Filter becomes one of these filters.

---

# Filter Ordering

The order in which filters execute is extremely important.

Suppose the order is

```
Authorization Filter

↓

JWT Filter
```

The Authorization Filter executes first.

It checks

```
Current User?

↓

Not Authenticated
```

Result

```
401 Unauthorized
```

The JWT Filter never gets an opportunity to authenticate the user.

Therefore,

incorrect filter ordering causes authentication to fail.

---

# Why Must JWT Filter Execute Before UsernamePasswordAuthenticationFilter?

Spring Security already contains a built-in filter called

```
UsernamePasswordAuthenticationFilter
```

Its responsibility is

```
Username

↓

Password

↓

Authenticate User
```

However,

our application does **not** use username and password for every request.

Instead,

it uses

```
Bearer JWT
```

Therefore,

our JWT filter must execute **before** Spring's built-in authentication filter.

Execution becomes

```
Incoming Request

↓

JWT Authorization Filter

↓

Extract Username

↓

Create Authentication

↓

SecurityContext

↓

UsernamePasswordAuthenticationFilter

↓

Already Authenticated

↓

Continue

↓

Controller
```

When the built-in filter executes,

it sees that authentication has already been completed.

No additional authentication is required.

---

# Request Flow Before Registering JWT Filter

Before registration,

Spring Security behaves as follows.

```
Client

↓

Bearer JWT

↓

Security Filter Chain

↓

UsernamePasswordAuthenticationFilter

↓

No Username

↓

No Password

↓

Authentication Failed

↓

401 Unauthorized
```

The JWT is completely ignored.

---

# Request Flow After Registering JWT Filter

After registering the JWT filter,

the flow changes.

```
Client

↓

Bearer JWT

↓

JWT Authorization Filter

↓

Validate JWT

↓

Extract Username

↓

Create Authentication

↓

Store Authentication

↓

Remaining Security Filters

↓

Controller

↓

JSON Response
```

Now,

every secured request is authenticated using the JWT.

---

# Real-World Analogy

Imagine a company introduces a new biometric access system.

Previously,

employees entered the office using

```
Employee ID Card
```

Now,

the company installs

```
Fingerprint Scanner
```

Simply purchasing the scanner is **not enough**.

The scanner must also be connected to the entrance gate.

Only then does the gate know

```
Before Opening Door

↓

Scan Fingerprint

↓

Verify Identity

↓

Allow Entry
```

Similarly,

creating

```
JwtAuthorizationFilter
```

is like purchasing the fingerprint scanner.

Configuring Spring Security is like installing that scanner at the entrance gate.

From that moment onward,

every person entering the building must first pass through fingerprint verification.

In the same way,

every HTTP request entering our application now passes through the JWT Authorization Filter before accessing any secured REST API.

This configuration transforms our standalone JWT filter into an active part of Spring Security, completing the integration between JWT authentication and the Spring Security framework.

# addFilterBefore()

The most important configuration in this exercise is

```java
.addFilterBefore(
        new JwtAuthorizationFilter(),
        UsernamePasswordAuthenticationFilter.class
)
```

This single statement tells Spring Security

> Execute our custom JWT Authorization Filter before Spring's built-in UsernamePasswordAuthenticationFilter.

Without this configuration,

our JWT filter will never execute.

---

# Why do we use addFilterBefore()?

Spring Security already contains dozens of built-in filters.

When a request arrives,

Spring executes these filters one after another.

Example

```
HTTP Request

↓

Filter 1

↓

Filter 2

↓

Filter 3

↓

Controller
```

Our JWT filter is not automatically included in this chain.

Therefore,

we explicitly tell Spring

```
Insert JwtAuthorizationFilter

Before

UsernamePasswordAuthenticationFilter
```

This is exactly what

```java
addFilterBefore()
```

does.

---

# Syntax

```java
http.addFilterBefore(

    Custom Filter,

    Existing Filter

);
```

Example

```java
.addFilterBefore(

    new JwtAuthorizationFilter(),

    UsernamePasswordAuthenticationFilter.class

)
```

Meaning

```
Existing Security Filters

↓

Insert JWT Filter Here

↓

Continue Remaining Filters
```

---

# Internal Working

Before registration

```
HTTP Request

↓

Security Filters

↓

Controller
```

JWT Filter

```
×

Not Executed
```

After registration

```
HTTP Request

↓

Security Filters

↓

JWT Authorization Filter

↓

Remaining Filters

↓

Controller
```

Now every request passes through our JWT filter.

---

# Why "Before"?

Spring Security authenticates users before authorization.

If

```
UsernamePasswordAuthenticationFilter
```

executes first,

Spring checks

```
Authenticated User?

↓

No

↓

Reject Request
```

Our JWT filter never gets the opportunity to authenticate the user.

Therefore,

JWT authentication must happen first.

---

# UsernamePasswordAuthenticationFilter

## Definition

`UsernamePasswordAuthenticationFilter` is Spring Security's built-in authentication filter.

Its responsibility is

- Read Username
- Read Password
- Authenticate User
- Store Authentication

It supports authentication methods such as

- Form Login
- HTTP Basic Authentication

It does **not** understand JWT.

---

# Why Don't We Use UsernamePasswordAuthenticationFilter?

Suppose the request contains

```
Authorization

↓

Bearer eyJhbGc...
```

Spring's built-in filter expects

```
Username

↓

Password
```

Instead,

it receives

```
JWT
```

It cannot authenticate the request.

Therefore,

we create

```
JwtAuthorizationFilter
```

which understands JWT authentication.

---

# Filter Registration

Creating a filter

```
JwtAuthorizationFilter.java
```

does not automatically activate it.

It must be registered.

Registration means

```
Spring Security

↓

Use this Filter

↓

During Every Request
```

Only after registration does Spring execute it.

---

# Authentication Flow with JWT

After registration,

authentication works like this.

```
Client

↓

Bearer JWT

↓

JWT Authorization Filter

↓

Validate JWT

↓

Extract Username

↓

Create Authentication

↓

SecurityContext

↓

Remaining Security Filters

↓

Controller
```

Notice that

authentication is completed before the request reaches the controller.

---

# HTTP Basic Authentication + JWT

In this CTS exercise,

the configuration still contains

```java
http.httpBasic(Customizer.withDefaults());
```

Therefore,

the application supports both

```
HTTP Basic Authentication
```

and

```
JWT Authentication
```

Flow

```
Login Request

↓

HTTP Basic Authentication

↓

Generate JWT

↓

Future Requests

↓

Bearer JWT
```

This approach allows the user to authenticate once using username and password,

receive a JWT,

and then use the JWT for subsequent API requests.

---

# Stateless Authentication

Another important configuration is

```java
http.csrf(csrf -> csrf.disable());
```

and in production applications,

JWT is usually combined with

```java
SessionCreationPolicy.STATELESS
```

Stateless means

```
Server

↓

No Session Storage
```

Instead,

every request carries its own authentication information inside the JWT.

Flow

```
Request

↓

JWT

↓

Authenticate

↓

Response
```

No server-side session is created.

This makes JWT ideal for

- REST APIs
- Cloud Applications
- Microservices
- Distributed Systems

---

# Why Disable CSRF?

## What is CSRF?

CSRF stands for

```
Cross-Site Request Forgery
```

It is a security attack where a malicious website tricks a logged-in user into sending unintended requests.

Spring Security enables CSRF protection by default.

However,

JWT-based REST APIs are generally stateless and do not rely on server-side sessions.

Therefore,

CSRF protection is usually disabled.

Configuration

```java
http.csrf(csrf -> csrf.disable());
```

This simplifies REST API authentication.

---

# RequestMatchers()

Another important configuration is

```java
.requestMatchers("/authenticate")
```

This specifies which URL pattern the rule applies to.

Example

```
/authenticate
```

or

```
/countries/**
```

Request matchers allow us to define different security rules for different endpoints.

---

# Authorization Rules

Spring Security allows us to define authorization policies.

Example

```java
.authorizeHttpRequests(auth -> auth

        .requestMatchers("/authenticate")
        .authenticated()

        .anyRequest()
        .authenticated()

)
```

Meaning

```
/authenticate

↓

Authenticated User Required
```

```
All Other Requests

↓

Authenticated User Required
```

In real-world applications,

we may configure

```
/login

↓

Permit All
```

```
/admin/**

↓

ROLE_ADMIN
```

```
/user/**

↓

ROLE_USER
```

This provides fine-grained access control.

---

# Complete Security Configuration Flow

```
HTTP Request

        │

        ▼

SecurityFilterChain

        │

        ▼

JWT Authorization Filter

        │

        ▼

Authorization Header Present?

      /                     \

    No                       Yes

    │                         │

Continue               Validate JWT

Request                     │

                             ▼

                     Signature Valid?

                       /          \

                    No            Yes

                    │              │

             Reject Request    Extract Username

                                     │

                                     ▼

                          Create Authentication

                                     │

                                     ▼

                           SecurityContextHolder

                                     │

                                     ▼

                    UsernamePasswordAuthenticationFilter

                                     │

                                     ▼

                          Remaining Security Filters

                                     │

                                     ▼

                               Controller

                                     │

                                     ▼

                               JSON Response
```

---

# Why Is This Configuration Important?

Without registering the JWT Authorization Filter,

our application can generate JWTs,

but it cannot use them.

The authentication process would stop after token generation.

By configuring Spring Security,

we complete the entire JWT lifecycle.

```
User Login

↓

Generate JWT

↓

Client Stores JWT

↓

Future Requests

↓

JWT Authorization Filter

↓

Validate JWT

↓

Authenticate User

↓

Protected REST API

↓

Response
```

This integration is what transforms JWT from a simple generated token into a fully functional authentication mechanism within the Spring Security framework.

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
│   │               │      JwtAuthorizationFilter.java
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
| SecurityConfig | Configures Spring Security |
| SecurityFilterChain | Defines the security rules for HTTP requests |
| JwtAuthorizationFilter | Validates JWT before the request reaches the controller |
| UsernamePasswordAuthenticationFilter | Default Spring Security authentication filter |
| PasswordEncoder | Encrypts passwords using BCrypt |
| InMemoryUserDetailsManager | Stores users in memory |
| HttpSecurity | Configures authentication and authorization rules |
| Spring Security Filter Chain | Executes all security filters in order |

---

# SecurityConfig.java

Complete Code

```java
package com.cognizant.springlearn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(
            PasswordEncoder passwordEncoder) {

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("pwd"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("pwd"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/authenticate")
                        .authenticated()

                        .anyRequest()
                        .authenticated()

                )

                .httpBasic(Customizer.withDefaults())

                .addFilterBefore(

                        new JwtAuthorizationFilter(),

                        UsernamePasswordAuthenticationFilter.class

                );

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

Marks this class as a Spring Configuration class.

Instead of creating objects manually,

Spring automatically creates and manages every Bean defined inside this class.

Example

```
SecurityConfig

↓

@Bean

↓

Spring IoC Container

↓

Managed Object
```

---

## @Bean

```java
@Bean
```

A Bean is an object managed by the Spring IoC Container.

Whenever Spring starts,

it executes every method marked with

```java
@Bean
```

and stores the returned object inside the IoC Container.

Example

```
@Bean

↓

PasswordEncoder

↓

Spring Container

↓

Reusable Everywhere
```

---

## InMemoryUserDetailsManager

```java
public InMemoryUserDetailsManager
userDetailsService(...)
```

Creates an in-memory user store.

Users are stored only while the application is running.

Example

```
User

↓

user

↓

ROLE_USER

Admin

↓

admin

↓

ROLE_ADMIN
```

This is suitable for

- Learning
- Testing
- Small demonstrations

Production applications usually use a database.

---

## PasswordEncoder

```java
return new BCryptPasswordEncoder();
```

Creates a BCrypt Password Encoder.

Instead of storing passwords as plain text,

Spring stores encrypted passwords.

Example

```
pwd

↓

BCrypt

↓

$2a$10$F0.....
```

Even if someone accesses the database,

they cannot read the original password.

---

## SecurityFilterChain

```java
public SecurityFilterChain
securityFilterChain(...)
```

Creates the Security Filter Chain.

This is the heart of Spring Security.

Every HTTP request passes through this chain before reaching any controller.

Flow

```
HTTP Request

↓

SecurityFilterChain

↓

Security Filters

↓

Controller
```

---

## Disable CSRF

```java
.csrf(csrf -> csrf.disable())
```

Disables CSRF protection.

JWT-based REST APIs are stateless.

Since they do not rely on server-side sessions,

CSRF protection is generally unnecessary.

---

## authorizeHttpRequests()

```java
.authorizeHttpRequests(...)
```

Defines authorization rules.

This section tells Spring Security

```
Which URLs

↓

Need Authentication

↓

Which URLs

↓

Can Be Accessed
```

---

## requestMatchers()

```java
.requestMatchers("/authenticate")
```

Selects a specific endpoint.

Here,

the rule applies only to

```
/authenticate
```

Different endpoints can have different security rules.

---

## authenticated()

```java
.authenticated()
```

Means

```
Only Authenticated Users

↓

Can Access
```

If the user is not authenticated,

Spring returns

```
401 Unauthorized
```

---

## anyRequest()

```java
.anyRequest()
```

Matches every remaining request.

Example

```
/countries/in

/admin

/student

/faculty
```

All remaining URLs follow the rule that comes after it.

---

## HTTP Basic

```java
.httpBasic(
Customizer.withDefaults())
```

Enables HTTP Basic Authentication.

The login request

```
Username

↓

Password
```

is authenticated using HTTP Basic.

After authentication,

our application generates the JWT.

This configuration remains only for the CTS learning exercise.

---

## Register JWT Filter

```java
.addFilterBefore(
new JwtAuthorizationFilter(),
UsernamePasswordAuthenticationFilter.class)
```

This is the most important line in the entire exercise.

It tells Spring

```
Insert

↓

JwtAuthorizationFilter

↓

Before

↓

UsernamePasswordAuthenticationFilter
```

Now,

every incoming request first passes through

```
JwtAuthorizationFilter
```

before reaching Spring's built-in authentication filter.

---

## Return Filter Chain

```java
return http.build();
```

Builds the complete Security Filter Chain.

Once built,

Spring automatically uses it for every incoming request.

---

# Complete Internal Working

Suppose the client sends

```
GET

/countries/in
```

along with

```
Authorization

↓

Bearer eyJhbGc...
```

Execution Flow

```
HTTP Request

        │

        ▼

Embedded Tomcat

        │

        ▼

SecurityFilterChain

        │

        ▼

JwtAuthorizationFilter

        │

        ▼

Read Authorization Header

        │

        ▼

Extract JWT

        │

        ▼

Validate Signature

        │

        ▼

Check Expiration

        │

        ▼

Extract Username

        │

        ▼

Create Authentication

        │

        ▼

SecurityContextHolder

        │

        ▼

UsernamePasswordAuthenticationFilter

        │

Already Authenticated

        │

        ▼

Authorization Rules

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

---

# Complete Security Flow Diagram

```
                 Client

                   │

                   ▼

          HTTP Request

                   │

                   ▼

        Embedded Tomcat

                   │

                   ▼

       Spring Security

                   │

                   ▼

      SecurityFilterChain

                   │

                   ▼

      JwtAuthorizationFilter

                   │

        Validate JWT

                   │

        Authentication

                   │

                   ▼

 SecurityContextHolder

                   │

                   ▼

UsernamePasswordAuthenticationFilter

                   │

Already Authenticated

                   │

                   ▼

 Authorization Manager

                   │

                   ▼

    DispatcherServlet

                   │

                   ▼

     CountryController

                   │

                   ▼

        Business Logic

                   │

                   ▼

        JSON Response
```

---

# JVM Memory Diagram

```
                     JVM

───────────────────────────────────────

Method Area

───────────────────────────────────────

SecurityConfig.class

JwtAuthorizationFilter.class

SecurityFilterChain.class

PasswordEncoder.class

UserDetails.class

───────────────────────────────────────

Heap Memory

───────────────────────────────────────

Spring IoC Container

│

├── SecurityConfig Bean

├── PasswordEncoder Bean

├── InMemoryUserDetailsManager Bean

├── SecurityFilterChain Bean

├── JwtAuthorizationFilter Bean

├── User Bean

└── Admin Bean

───────────────────────────────────────
```

---

# Best Practices

- Register custom filters in the correct position within the Security Filter Chain.
- Always validate JWTs before authorizing access to protected resources.
- Use BCrypt for password encryption.
- Keep JWT authentication stateless.
- Separate authentication logic from business logic.
- Store secret keys securely using environment variables or secret management tools.
- Configure URL-based authorization rules clearly and consistently.

---

# Common Mistakes

## 1. Forgetting to Register the JWT Filter

Wrong

```java
new JwtAuthorizationFilter();
```

This only creates the object.

Correct

```java
.addFilterBefore(
new JwtAuthorizationFilter(),
UsernamePasswordAuthenticationFilter.class)
```

This registers the filter.

---

## 2. Registering the Filter in the Wrong Position

Wrong

```
UsernamePasswordAuthenticationFilter

↓

JwtAuthorizationFilter
```

Correct

```
JwtAuthorizationFilter

↓

UsernamePasswordAuthenticationFilter
```

The JWT must be validated before Spring attempts authentication.

---

## 3. Forgetting `http.build()`

Without

```java
return http.build();
```

the Security Filter Chain is never created.

---

## 4. Using Plain Text Passwords

Wrong

```java
.password("pwd")
```

Correct

```java
.password(
passwordEncoder.encode("pwd"))
```

Passwords should always be encoded.

---

## 5. Mixing Authentication and Authorization

Authentication verifies

```
Who are you?
```

Authorization verifies

```
What are you allowed to do?
```

These responsibilities should remain separate.

---

# Interview Questions

### 1. Why do we need `SecurityConfig`?

It centralizes all Spring Security configuration, including authentication, authorization, password encoding, and filter registration.

---

### 2. What is a `SecurityFilterChain`?

It is an ordered collection of security filters that process every incoming HTTP request before it reaches the controller.

---

### 3. Why do we use `addFilterBefore()`?

To register the custom JWT Authorization Filter before Spring's `UsernamePasswordAuthenticationFilter`, ensuring JWT authentication occurs first.

---

### 4. Why is the filter registered before `UsernamePasswordAuthenticationFilter`?

Because the JWT must be validated and the user authenticated before Spring's default authentication mechanisms execute.

---

### 5. What is the purpose of `PasswordEncoder`?

It securely hashes passwords using BCrypt instead of storing them as plain text.

---

### 6. Why is CSRF disabled?

JWT-based REST APIs are stateless and do not rely on server-side sessions, so CSRF protection is typically unnecessary.

---

### 7. What does `requestMatchers()` do?

It specifies which URL patterns a particular security rule applies to.

---

### 8. Why do we use `InMemoryUserDetailsManager`?

It provides a simple in-memory user store for development and learning purposes.

---

### 9. What happens if the JWT filter is not registered?

Spring Security never executes the custom filter, JWTs are ignored, and protected endpoints return **401 Unauthorized**.

---

### 10. What is the main purpose of this exercise?

To integrate the custom JWT Authorization Filter into the Spring Security Filter Chain so that every secured request is authenticated using JWT before reaching the application.

---

# Quick Revision

- `SecurityConfig` is the central configuration class for Spring Security.
- `SecurityFilterChain` defines how every HTTP request is secured.
- `@Bean` methods create Spring-managed objects.
- `PasswordEncoder` encrypts passwords using BCrypt.
- `InMemoryUserDetailsManager` stores users for development and testing.
- `authorizeHttpRequests()` defines authorization rules.
- `requestMatchers()` applies rules to specific endpoints.
- `httpBasic()` enables HTTP Basic Authentication for the CTS login flow.
- `addFilterBefore()` registers the JWT Authorization Filter before Spring's default authentication filter.
- `http.build()` creates the Security Filter Chain used by Spring Security.
- This exercise completes the **integration of JWT authentication with Spring Security**, allowing the application to authenticate and authorize secured REST API requests using JWTs.

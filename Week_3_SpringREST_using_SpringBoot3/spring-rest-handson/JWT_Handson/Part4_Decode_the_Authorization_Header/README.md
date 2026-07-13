# Part 4 – Decode the Authorization Header

## Week 3 – Spring REST using Spring Boot 3

### JWT Hands-on

---

# Introduction

In the previous exercise, we created an **Authentication Controller** that received authentication requests through the `/authenticate` endpoint.

When a client called this endpoint using **HTTP Basic Authentication**, Spring Security authenticated the user before the request reached our controller.

However, our controller was only logging the **Authorization Header** and returning a placeholder response.

At this stage, our application still does **not know who the authenticated user is**.

The controller only receives a string similar to

```
Authorization

↓

Basic dXNlcjpwd2Q=
```

This value is not directly useful.

To generate a JWT in the next exercise, we must first identify **which user** has logged in.

Therefore, we must decode the Authorization Header and extract the username from it.

This exercise teaches exactly how this process works internally.

---

# Exercise Objective

The objective of this exercise is to read the Authorization Header received from the client, decode it from Base64 format, separate the username and password, and extract the authenticated username.

After completing this exercise, the application will be able to

- Read the Authorization Header
- Remove the **Basic** prefix
- Decode the Base64 encoded credentials
- Convert bytes into readable text
- Separate username and password
- Extract the username
- Prepare the application for JWT generation

This exercise acts as the bridge between HTTP Basic Authentication and JWT Authentication.

---

# Problem Statement

Suppose a client sends

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

The browser or Postman never sends

```
user

↓

pwd
```

directly.

Instead,

it automatically converts the credentials into

```
Authorization

↓

Basic dXNlcjpwd2Q=
```

Our controller receives only

```
Basic dXNlcjpwd2Q=
```

Now imagine we want to generate a JWT.

A JWT usually contains information like

```
Username

↓

Roles

↓

Issued Time

↓

Expiry Time
```

How can we generate a token if we don't even know who the user is?

Therefore,

our first task is

```
Authorization Header

↓

Decode

↓

Username

↓

Generate JWT
```

Without decoding the Authorization Header,

JWT generation is impossible.

---

# Why Do We Need to Decode the Authorization Header?

The Authorization Header contains the user's credentials in an encoded format.

Example

```
Authorization

↓

Basic dXNlcjpwd2Q=
```

This string cannot be used directly.

Our application needs

```
Username

↓

user
```

not

```
dXNlcjpwd2Q=
```

Therefore,

we decode it.

---

# How HTTP Basic Authentication Works Internally

Suppose the user enters

```
Username

↓

user

Password

↓

pwd
```

The browser or Postman combines them.

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

Now this string is converted into Base64.

```
user:pwd

↓

Base64 Encoding

↓

dXNlcjpwd2Q=
```

Finally,

the HTTP Header becomes

```
Authorization

↓

Basic dXNlcjpwd2Q=
```

This header is sent to the server.

---

# Complete Authentication Flow

```
Client

↓

Enter Username

↓

user

↓

Enter Password

↓

pwd

↓

Combine

↓

user:pwd

↓

Base64 Encoding

↓

dXNlcjpwd2Q=

↓

Authorization Header

↓

Basic dXNlcjpwd2Q=

↓

HTTP Request

↓

Spring Boot
```

Our controller receives only

```
Basic dXNlcjpwd2Q=
```

Everything before this happens automatically.

---

# What is Base64 Encoding?

## Definition

Base64 is an encoding mechanism that converts binary or textual data into a standard ASCII character format.

It is widely used when data must travel safely through protocols such as

- HTTP
- SMTP
- MIME
- XML
- JSON

Base64 is **not a security mechanism**.

It simply changes the representation of data.

---

# Why Was Base64 Created?

Communication protocols originally supported only printable text.

Suppose we send binary data.

```
10110101010100011101010
```

Some systems may interpret these bytes incorrectly.

To avoid transmission problems,

binary data is converted into printable characters.

Example

```
Original

↓

user:pwd

↓

Base64

↓

dXNlcjpwd2Q=
```

The receiving application decodes it back.

---

# Is Base64 Encryption?

No.

This is one of the biggest misconceptions.

Base64

- Does NOT encrypt
- Does NOT hide information
- Does NOT secure passwords

Anyone can decode

```
dXNlcjpwd2Q=
```

back into

```
user:pwd
```

within milliseconds.

Therefore,

HTTP Basic Authentication should always be used with **HTTPS**.

---

# Base64 Encoding vs Encryption vs Hashing

| Feature | Base64 Encoding | Encryption | Hashing |
|----------|-----------------|------------|----------|
| Purpose | Data Representation | Protect Data | Verify Integrity |
| Reversible | Yes | Yes (using key) | No |
| Security | No | Yes | One-way |
| Used In | HTTP Headers | Secure Communication | Password Storage |
| Example | `user:pwd → dXNlcjpwd2Q=` | AES, RSA | BCrypt, SHA-256 |

Understanding this difference is very important.

Many beginners incorrectly assume that Base64 secures passwords.

It does not.

---

# Authorization Header Format

The Authorization Header follows a standard format.

```
Authorization

:

Authentication Scheme

↓

Credentials
```

For HTTP Basic Authentication

```
Authorization

↓

Basic dXNlcjpwd2Q=
```

For JWT Authentication

```
Authorization

↓

Bearer eyJhbGciOiJIUzI1NiJ9...
```

Notice that

only the **Authentication Scheme** changes.

The header name remains the same.

---

# Why Do We Remove the "Basic" Prefix?

Suppose the controller receives

```
Basic dXNlcjpwd2Q=
```

The Base64 decoder cannot decode the word

```
Basic
```

It can decode only

```
dXNlcjpwd2Q=
```

Therefore,

the first step is

```
Basic dXNlcjpwd2Q=

↓

Remove "Basic "

↓

dXNlcjpwd2Q=
```

Only after removing the prefix can decoding begin.

---

# Real-World Analogy

Imagine receiving a sealed envelope.

The outside of the envelope contains

```
CONFIDENTIAL

↓

Letter
```

Before reading the letter,

you first remove the envelope.

Similarly,

our Authorization Header contains

```
Basic

↓

Encoded Credentials
```

Before decoding,

we first remove

```
Basic
```

Only then can we read the actual contents.

The decoded credentials become

```
user:pwd
```

which are then separated into

```
Username

↓

user

Password

↓

pwd
```

This extracted username becomes the identity used in the next exercise to generate a JWT token.

# Authorization Header Anatomy

Before writing the decoding logic, we should understand the exact structure of the Authorization Header.

When Postman sends

```
Username

↓

user

Password

↓

pwd
```

Spring Security receives

```
Authorization

↓

Basic dXNlcjpwd2Q=
```

This single string actually contains two parts.

```
Authentication Scheme

↓

Basic

+

Encoded Credentials

↓

dXNlcjpwd2Q=
```

Visually,

```
Basic dXNlcjpwd2Q=
│      │
│      │
│      └──── Encoded Username and Password
│
└──────── Authentication Scheme
```

Our controller is interested only in the encoded credentials.

Therefore,

the first step is to remove

```
Basic
```

---

# Removing the "Basic " Prefix

The Authorization Header contains

```
Basic dXNlcjpwd2Q=
```

Notice the space after the word

```
Basic
```

The Base64 decoder cannot decode

```
Basic dXNlcjpwd2Q=
```

It expects only

```
dXNlcjpwd2Q=
```

Therefore,

our program removes the first six characters.

```
Basic

↓

5 letters

+

1 space

↓

6 characters
```

Remaining

```
dXNlcjpwd2Q=
```

---

# What is substring()?

## Definition

`substring()` is a Java String method used to extract a portion of a string.

Syntax

```java
string.substring(startIndex)
```

It returns a new string beginning from the specified index.

---

# Example

Suppose

```java
String text = "HelloWorld";
```

```
Index

0 1 2 3 4 5 6 7 8 9

H e l l o W o r l d
```

Now,

```java
text.substring(5)
```

returns

```
World
```

because index 5 starts from

```
W
```

---

# substring() in This Exercise

Authorization Header

```
Basic dXNlcjpwd2Q=
```

Character positions

```
B a s i c _ d X N l c j p w d 2 Q =

0 1 2 3 4 5 6 ...
```

Now

```java
authHeader.substring(6)
```

returns

```
dXNlcjpwd2Q=
```

The word

```
Basic
```

is removed.

---

# What is Base64.getDecoder()?

## Definition

`Base64.getDecoder()` returns a Base64 decoder object capable of converting Base64 encoded text back into its original bytes.

Example

```java
Base64.getDecoder()
```

creates

```
Decoder

↓

Ready to Decode
```

---

# Decoding the Credentials

Example

```java
byte[] decodedBytes =
Base64.getDecoder().decode(encodedCredentials);
```

Suppose

```
encodedCredentials

↓

dXNlcjpwd2Q=
```

The decoder converts

```
dXNlcjpwd2Q=

↓

user:pwd
```

Internally,

the decoder returns bytes.

```
[117,115,101,114,58,112,119,100]
```

These bytes are not readable.

Therefore,

another step is required.

---

# Why Does Base64 Return Bytes?

Computers store all information internally as numbers.

The word

```
user
```

is actually stored as

```
117

115

101

114
```

Similarly,

```
user:pwd
```

becomes

```
117

115

101

114

58

112

119

100
```

These numbers are called

```
Byte Array
```

Humans cannot read byte arrays easily.

Therefore,

we convert bytes back into a String.

---

# What is StandardCharsets.UTF_8?

## Definition

`StandardCharsets.UTF_8` represents the UTF-8 character encoding.

It tells Java

```
Interpret these bytes as UTF-8 characters.
```

Example

```java
new String(decodedBytes,
StandardCharsets.UTF_8)
```

converts

```
117

115

101

114
```

into

```
user
```

---

# Why UTF-8?

UTF-8 is the most widely used character encoding.

It supports

- English
- Telugu
- Hindi
- Japanese
- Chinese
- Arabic
- Almost every language

Therefore,

Spring Boot uses UTF-8 by default.

---

# Conversion Flow

```
Base64 String

↓

dXNlcjpwd2Q=

↓

Base64 Decoder

↓

Byte Array

↓

UTF-8

↓

user:pwd
```

---

# What is split()?

## Definition

`split()` is a Java String method used to divide a string into multiple parts using a delimiter.

Syntax

```java
string.split(delimiter)
```

Example

```java
String text = "Java,Python,C++";
```

Now

```java
text.split(",");
```

returns

```
Java

Python

C++
```

---

# split() in This Exercise

Decoded Credentials

```
user:pwd
```

Now

```java
credentials.split(":");
```

returns

```
user

pwd
```

Internally

```
Index

0

↓

user

Index

1

↓

pwd
```

---

# Extracting Username

Our program writes

```java
String username =
credentials.split(":")[0];
```

Meaning

```
user:pwd

↓

Split

↓

user

pwd

↓

Take Index 0

↓

user
```

Similarly,

```
credentials.split(":")[1]
```

returns

```
pwd
```

Although this exercise only uses the username,

both username and password are available after decoding.

---

# Complete Decoding Flow

```
Authorization Header

↓

Basic dXNlcjpwd2Q=

↓

substring(6)

↓

dXNlcjpwd2Q=

↓

Base64 Decoder

↓

Byte Array

↓

UTF-8

↓

user:pwd

↓

split(":")

↓

Username

↓

user

Password

↓

pwd
```

This is exactly what our Authentication Controller performs.

---

# Why Do We Decode Before JWT Generation?

A JWT contains information about the authenticated user.

Typical JWT payload

```
Username

↓

user

Roles

↓

ROLE_USER

Issued Time

↓

Current Time

Expiry Time

↓

Future Time
```

Without knowing the username,

we cannot create a meaningful JWT.

Therefore,

the decoding process is mandatory before generating the token.

---

# Internal Request Flow

```
Postman

        │

        ▼

Username

↓

user

Password

↓

pwd

        │

        ▼

Basic Authentication

        │

        ▼

Authorization Header

↓

Basic dXNlcjpwd2Q=

        │

        ▼

AuthenticationController

        │

        ▼

substring(6)

        │

        ▼

Base64 Decoder

        │

        ▼

UTF-8 Conversion

        │

        ▼

user:pwd

        │

        ▼

split(":")

        │

        ▼

Username

↓

user

        │

        ▼

Ready for JWT Generation
```

---

# Security Considerations

Although HTTP Basic Authentication uses Base64 encoding, it does **not** protect credentials.

Anyone who intercepts the request can decode

```
dXNlcjpwd2Q=
```

back into

```
user:pwd
```

Therefore,

HTTP Basic Authentication should always be used over **HTTPS**.

In enterprise applications,

HTTP Basic Authentication is usually used only during the initial login process.

After successful authentication,

the server generates a JWT.

From that point onward,

the client sends only the JWT instead of repeatedly transmitting the username and password.

This significantly improves both security and scalability and is exactly what we will implement in the next part of this hands-on.

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
| AuthenticationController | Receives the Authorization Header and decodes it |
| Spring Security | Authenticates the user before reaching the controller |
| Base64 Decoder | Converts encoded credentials into original text |
| StandardCharsets.UTF_8 | Converts decoded bytes into readable characters |
| Logger (SLF4J) | Logs every step of the decoding process |
| Map<String, String> | Returns the authentication response |

---

# AuthenticationController.java

Complete Code

```java
package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authorizationHeader) {

        LOGGER.info("Start");

        LOGGER.info("Authorization Header : {}", authorizationHeader);

        String encodedCredentials = authorizationHeader.substring(6);

        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String credentials =
                new String(decodedBytes, StandardCharsets.UTF_8);

        LOGGER.info("Decoded Credentials : {}", credentials);

        String username = credentials.split(":")[0];

        LOGGER.info("Username : {}", username);

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

Marks this class as a REST Controller.

Every method inside this class returns data directly as an HTTP response.

Spring automatically converts returned Java objects into JSON.

---

## Logger

```java
private static final Logger LOGGER =
LoggerFactory.getLogger(AuthenticationController.class);
```

Creates a logger object.

It records important execution steps such as

- Start
- Authorization Header
- Decoded Credentials
- Username
- End

These logs help developers understand the authentication process.

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

to the `authenticate()` method.

Whenever a client sends

```
http://localhost:8083/authenticate
```

this method is executed.

---

## @RequestHeader

```java
@RequestHeader("Authorization")
String authorizationHeader
```

Spring automatically reads the value of the HTTP Authorization Header.

Example

```
Authorization

↓

Basic dXNlcjpwd2Q=
```

The value

```
Basic dXNlcjpwd2Q=
```

is stored inside

```java
authorizationHeader
```

---

## Start Log

```java
LOGGER.info("Start");
```

Prints

```
INFO AuthenticationController : Start
```

This indicates that the controller has started processing the request.

---

## Authorization Header Log

```java
LOGGER.info("Authorization Header : {}", authorizationHeader);
```

Example output

```
Authorization Header :

Basic dXNlcjpwd2Q=
```

This confirms that the Authorization Header has been received correctly.

---

## Extract Encoded Credentials

```java
String encodedCredentials =
authorizationHeader.substring(6);
```

Original Header

```
Basic dXNlcjpwd2Q=
```

After removing

```
Basic
```

Result

```
dXNlcjpwd2Q=
```

Only the encoded credentials remain.

---

## Decode Base64

```java
byte[] decodedBytes =
Base64.getDecoder().decode(encodedCredentials);
```

Input

```
dXNlcjpwd2Q=
```

Output

```
Byte Array

↓

[117,115,101,114,58,112,119,100]
```

At this stage,

the credentials are decoded,

but still stored as bytes.

---

## Convert Bytes into String

```java
String credentials =
new String(decodedBytes,
StandardCharsets.UTF_8);
```

Byte Array

```
[117,115,101,114,58,112,119,100]
```

becomes

```
user:pwd
```

Now the credentials are human-readable.

---

## Log Decoded Credentials

```java
LOGGER.info("Decoded Credentials : {}", credentials);
```

Console

```
Decoded Credentials

↓

user:pwd
```

This confirms that Base64 decoding was successful.

---

## Extract Username

```java
String username =
credentials.split(":")[0];
```

Input

```
user:pwd
```

Split

```
Index 0

↓

user

Index 1

↓

pwd
```

Taking index

```
0
```

returns

```
user
```

This username will be used in the next exercise to generate the JWT.

---

## Username Log

```java
LOGGER.info("Username : {}", username);
```

Console

```
Username

↓

user
```

This verifies that the username has been extracted successfully.

---

## Create Response Map

```java
Map<String,String> response =
new HashMap<>();
```

Creates an empty response.

Initially

```
{}
```

---

## Add Token

```java
response.put("token","");
```

Stores

```
token

↓

""
```

Current response

```json
{
    "token":""
}
```

In the next exercise,

this empty value will be replaced with an actual JWT.

---

## End Log

```java
LOGGER.info("End");
```

Marks the completion of the request.

Console

```
INFO AuthenticationController : End
```

---

## Return Response

```java
return response;
```

Spring Boot automatically converts

```
Map

↓

JSON
```

using the Jackson library.

The client receives

```json
{
    "token":""
}
```

---

# Complete Internal Working

Suppose Postman sends

```
Username

↓

user

Password

↓

pwd
```

Complete execution flow

```
Postman

        │

        ▼

Username

↓

user

Password

↓

pwd

        │

        ▼

Combine

↓

user:pwd

        │

        ▼

Base64 Encoding

↓

dXNlcjpwd2Q=

        │

        ▼

Authorization Header

↓

Basic dXNlcjpwd2Q=

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

Credentials Valid?

      /         \

    No           Yes

    │             │

401 Unauthorized

                  ▼

AuthenticationController

                  │

                  ▼

substring(6)

                  │

                  ▼

Base64 Decoder

                  │

                  ▼

Byte Array

                  │

                  ▼

UTF-8 Conversion

                  │

                  ▼

user:pwd

                  │

                  ▼

split(":")

                  │

                  ▼

Username

↓

user

                  │

                  ▼

Create Response

↓

token=""

                  │

                  ▼

Jackson

                  │

                  ▼

JSON Response
```

---

# JVM Memory Diagram

```
                     JVM

──────────────────────────────────────────────

Method Area

──────────────────────────────────────────────

AuthenticationController.class

Logger.class

Base64.class

HashMap.class

String.class

DispatcherServlet.class

SecurityFilterChain.class

──────────────────────────────────────────────

Heap Memory

──────────────────────────────────────────────

Spring IoC Container

│

├── AuthenticationController Bean

├── SecurityFilterChain Bean

├── Logger Object

├── HashMap Object

└── Authorization Header String

──────────────────────────────────────────────
```

---

# Execution Flow Diagram

```
Client

        │

        ▼

GET /authenticate

        │

        ▼

Authorization Header

↓

Basic dXNlcjpwd2Q=

        │

        ▼

Spring Security

        │

Authentication Successful

        │

        ▼

AuthenticationController

        │

        ▼

Remove "Basic"

        │

        ▼

Decode Base64

        │

        ▼

Convert to String

        │

        ▼

Split Username

        │

        ▼

Return JSON Response
```

---

# Best Practices

- Always use HTTPS when transmitting Authorization Headers.
- Never assume Base64 provides security.
- Log usernames only for debugging in development environments.
- Avoid logging passwords or decoded credentials in production systems.
- Validate the Authorization Header before decoding it.
- Handle malformed Base64 strings gracefully using exception handling.
- Keep authentication logic separate from business logic.

---

# Common Mistakes

## 1. Forgetting to Remove `"Basic "` Prefix

Wrong

```java
Base64.getDecoder().decode(authHeader);
```

Correct

```java
Base64.getDecoder().decode(
authHeader.substring(6));
```

---

## 2. Assuming Base64 Is Encryption

Many beginners think

```
dXNlcjpwd2Q=
```

is secure.

It is not.

Anyone can decode it.

---

## 3. Using Default Character Encoding

Wrong

```java
new String(decodedBytes);
```

Correct

```java
new String(decodedBytes,
StandardCharsets.UTF_8);
```

Always specify the character encoding explicitly.

---

## 4. Incorrect Delimiter

Wrong

```java
split("-")
```

Correct

```java
split(":")
```

The username and password are separated by a colon (`:`).

---

## 5. Logging Passwords in Production

Never log

```
user:password
```

or JWT tokens in production environments.

Sensitive information should not appear in application logs.

---

# Interview Questions

### 1. Why do we decode the Authorization Header?

To extract the original username and password from the Base64 encoded credentials so that the application can identify the authenticated user.

---

### 2. What does `substring(6)` do?

It removes the `"Basic "` prefix from the Authorization Header, leaving only the Base64 encoded credentials.

---

### 3. Why does `Base64.getDecoder().decode()` return a byte array?

Because Base64 decoding converts encoded text into its original binary representation, which is stored as bytes.

---

### 4. Why do we use `StandardCharsets.UTF_8`?

To correctly convert decoded bytes into readable characters using the UTF-8 character encoding.

---

### 5. Why do we use `split(":")`?

Because HTTP Basic Authentication combines the username and password in the format:

```
username:password
```

The colon separates the two values.

---

### 6. Is Base64 secure?

No.

Base64 is only an encoding mechanism.

It provides no confidentiality or protection.

---

### 7. Why is the extracted username important?

The username becomes the identity that will be embedded into the JWT in the next exercise.

---

### 8. Why do we still return an empty token?

Because this exercise focuses only on decoding the Authorization Header.

JWT generation is implemented in the next part of the hands-on.

---

### 9. What happens if the Authorization Header is missing?

The controller will not receive the expected header, and Spring Security or the application should reject the request or handle the missing header appropriately.

---

### 10. What is the next step after decoding the credentials?

Generate a JWT containing the authenticated user's information and return it to the client.

---

# Quick Revision

- HTTP Basic Authentication sends credentials as a Base64 encoded string.
- The Authorization Header contains both the authentication scheme (`Basic`) and the encoded credentials.
- `substring(6)` removes the `"Basic "` prefix.
- `Base64.getDecoder()` decodes the Base64 string.
- `StandardCharsets.UTF_8` converts decoded bytes into readable text.
- `split(":")` separates the username and password.
- The extracted username is required for JWT generation.
- This exercise prepares the application for creating a JWT in the next part.

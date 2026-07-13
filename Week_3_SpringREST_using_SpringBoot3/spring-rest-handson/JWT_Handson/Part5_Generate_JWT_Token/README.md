# Part 5 – Generate JWT Token

## Week 3 – Spring REST using Spring Boot 3

### JWT Hands-on

---

# Introduction

In the previous exercise (**Part 4 – Decode the Authorization Header**), we successfully extracted the username from the HTTP Authorization Header.

The complete flow became

```
Authorization Header

↓

Basic dXNlcjpwd2Q=

↓

Remove "Basic "

↓

Base64 Decode

↓

user:pwd

↓

Extract Username

↓

user
```

At this point, our application knows **who the authenticated user is**.

However, there is still one major problem.

For every REST API request,

the client continues sending

```
Username

↓

Password
```

again and again.

Although Spring Security authenticates these credentials correctly,

this is **not the authentication mechanism used by modern enterprise applications**.

Instead,

modern applications authenticate the user **only once**.

After successful authentication,

the server generates a secure token called a **JSON Web Token (JWT)**.

The client stores this token and sends it with every future request.

The username and password are no longer transmitted repeatedly.

This exercise implements the most important step in the JWT authentication process:

**Generating the JWT Token.**

---

# Exercise Objective

The objective of this exercise is to generate a JWT (JSON Web Token) after successful authentication.

After completing this exercise,

our application will

- Extract the authenticated username.
- Create a JWT.
- Add standard JWT claims.
- Digitally sign the token.
- Return the JWT to the client.
- Prepare the application for JWT validation in the next exercises.

Instead of returning

```json
{
    "token":""
}
```

our application will now return

```json
{
    "token":"eyJhbGciOiJIUzI1NiJ9..."
}
```

---

# Problem Statement

Suppose a user wants to access

```
GET

/countries/in
```

Using HTTP Basic Authentication,

every request contains

```
Username

↓

user

Password

↓

pwd
```

Even if the same user makes

100 API requests,

the username and password are transmitted

100 times.

Problems

- Credentials travel repeatedly over the network.
- Password exposure risk increases.
- Authentication is performed repeatedly.
- Performance decreases.
- Difficult for mobile applications.
- Difficult for microservices.
- Not scalable.

Instead,

the application should authenticate only once.

```
Username

↓

Password

↓

Authentication Successful

↓

Generate JWT

↓

Return JWT

↓

Future Requests

↓

Bearer JWT
```

Only the token travels across the network.

This is exactly what we implement in this exercise.

---

# What is JWT?

## Definition

**JWT (JSON Web Token)** is a compact, URL-safe, digitally signed token used to securely transfer authentication and authorization information between two parties.

A JWT acts as a digital identity card.

Instead of repeatedly sending

```
Username

↓

Password
```

the client sends

```
JWT Token
```

The server verifies the token and identifies the user.

JWT follows the open standard

```
RFC 7519
```

and is one of the most widely used authentication mechanisms in modern REST APIs.

---

# Why Was JWT Created?

Before JWT,

most web applications used

```
Session-Based Authentication
```

Whenever a user logged in,

the server created a session.

Example

```
User Login

↓

Server

↓

Session Created

↓

Session ID

↓

Browser
```

Future requests

```
Browser

↓

Session ID

↓

Server

↓

Session Lookup

↓

Response
```

Although this works,

it has several limitations.

---

# Problems with Session-Based Authentication

Suppose an application serves

```
10 Million Users
```

Every user has one session.

The server must store

```
Session 1

Session 2

Session 3

...

Session 10 Million
```

Problems

- High memory usage
- Difficult to scale
- Load balancing becomes complicated
- Multiple servers must share session data
- Additional infrastructure is required

This approach works for small applications,

but becomes challenging in distributed systems.

---

# Problems with HTTP Basic Authentication

HTTP Basic Authentication removes the need for sessions,

but introduces another problem.

Example

```
GET

/countries/in
```

Every request contains

```
Username

↓

user

Password

↓

pwd
```

Even after successful authentication,

the client must continue sending the password.

Problems

- Password transmitted repeatedly.
- Higher security risk.
- Inefficient communication.
- Not recommended for large REST APIs.

---

# Why JWT Was Introduced?

JWT combines the advantages of both approaches.

Authentication occurs only once.

```
Username

↓

Password

↓

Authentication

↓

JWT Generated

↓

Client Stores JWT
```

Future requests become

```
Authorization

↓

Bearer eyJhbGc...
```

No password is sent again.

The server simply verifies the JWT.

---

# Stateless Authentication Using JWT

JWT enables

```
Stateless Authentication
```

Meaning,

the server does **not** store user sessions.

Instead,

all required authentication information is stored inside the JWT itself.

Authentication Flow

```
Client

↓

Login

↓

Generate JWT

↓

Client Stores JWT

↓

Future Requests

↓

Bearer JWT

↓

Server Validates JWT

↓

Response
```

No session storage is required.

This makes JWT highly scalable.

---

# Why Is Stateless Authentication Better?

Imagine an e-commerce website.

Users

```
1 Million
```

Servers

```
Server 1

Server 2

Server 3

Server 4
```

With session-based authentication,

every server must know about every session.

With JWT,

every server only needs the secret key.

Example

```
Client

↓

JWT

↓

Server 1

↓

Valid

↓

Response
```

Another request

```
Client

↓

JWT

↓

Server 4

↓

Valid

↓

Response
```

No session sharing is required.

Every server independently verifies the JWT.

This architecture is ideal for

- Microservices
- Cloud Applications
- Kubernetes
- Load Balanced Systems
- Distributed Applications

---

# JWT Authentication Flow

The complete JWT authentication process is

```
Client

↓

Username

↓

Password

↓

Spring Security

↓

Authentication Successful

↓

AuthenticationController

↓

Generate JWT

↓

Return JWT

↓

Client Stores JWT

↓

Future Request

↓

Authorization

↓

Bearer JWT

↓

Spring Security

↓

Validate JWT

↓

Controller

↓

Response
```

Notice that

the username and password are transmitted only **once**.

Every future request uses only the JWT.

---

# Real-World Analogy

Imagine entering an international airport.

### Step 1 – Identity Verification

At the security counter,

you present

- Passport
- Visa
- Identity Proof

The airport verifies your identity.

This is similar to

```
Username

↓

Password

↓

Authentication
```

---

### Step 2 – Boarding Pass Issued

After verification,

the airport gives you

```
Boarding Pass
```

The boarding pass contains

- Passenger Name
- Flight Number
- Boarding Time
- Seat Number

You no longer need to show your passport at every checkpoint.

You simply show the boarding pass.

---

### Step 3 – Security Checkpoints

Whenever you move

- Security Gate
- Boarding Gate
- Aircraft Entry

officials check only your boarding pass.

Similarly,

our application

- authenticates the user once,
- generates a JWT,
- and every future API request carries only the JWT.

The JWT acts exactly like a digital boarding pass.

It proves that the user has already been authenticated and allows the server to identify the user without repeatedly asking for the username and password.

This exercise introduces the creation of that digital identity, which forms the foundation of modern authentication systems used in enterprise applications worldwide.

# JWT Structure

A JWT is not a random string.

It is a structured token containing three different parts.

```
JWT

↓

Header

.

Payload

.

Signature
```

Visually,

```
xxxxx.yyyyy.zzzzz
```

Every JWT follows this format.

Example

```
eyJhbGciOiJIUzI1NiJ9

.

eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNzIwNTY2MjAwLCJleHAiOjE3MjA1Njc0MDB9

.

XJkLx7VQd4.......
```

The three parts are separated using

```
.
```

(dot)

---

# JWT Header

## Definition

The Header is the first part of the JWT.

It contains metadata describing the token.

It tells the receiver

- Which algorithm was used
- What type of token it is

Typical Header

```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

Where

```
alg

↓

Algorithm
```

```
HS256
```

means

```
HMAC SHA-256
```

and

```
typ

↓

JWT
```

indicates that the token is a JSON Web Token.

---

# Why Do We Need the Header?

Suppose someone receives a JWT.

How does the application know

- Which signing algorithm was used?
- Whether this is actually a JWT?

The Header provides this information.

```
JWT

↓

Read Header

↓

Algorithm

↓

HS256

↓

Verify Signature
```

Without the Header,

the receiver would not know how to validate the token.

---

# JWT Payload

## Definition

The Payload is the second part of the JWT.

It contains information about the authenticated user.

This information is called **Claims**.

Example

```json
{
    "sub":"user",
    "iat":1720566200,
    "exp":1720567400
}
```

The payload stores

- User identity
- Issue time
- Expiration time
- Roles
- Email
- Custom information

The payload is **Base64URL encoded**, not encrypted.

Anyone who has the JWT can decode and view the payload.

Therefore,

sensitive information such as

- Password
- Bank Account Number
- Aadhaar Number
- Credit Card Number

should **never** be stored inside the payload.

---

# What are Claims?

## Definition

Claims are pieces of information stored inside the JWT Payload.

Claims describe the authenticated user.

Think of claims as properties.

Example

```
Username

↓

user

Role

↓

ADMIN

Email

↓

abc@gmail.com
```

Each piece of information is a claim.

---

# Types of Claims

JWT supports three categories of claims.

### 1. Registered Claims

These are predefined claim names defined by the JWT specification.

Examples

```
sub

↓

Subject
```

```
iat

↓

Issued At
```

```
exp

↓

Expiration Time
```

```
iss

↓

Issuer
```

```
aud

↓

Audience
```

These names have standard meanings.

---

### 2. Public Claims

These are custom claims that applications define.

Example

```json
{
    "department":"IT",
    "designation":"Developer"
}
```

Any application can create its own public claims.

---

### 3. Private Claims

Private claims are custom claims agreed upon between two applications.

Example

```json
{
    "employeeId":"EMP101",
    "project":"DigitalNurture"
}
```

These claims are meaningful only within that application.

---

# Standard Claims Used in This Exercise

Our implementation uses three important claims.

---

## Subject (sub)

Definition

The Subject identifies the authenticated user.

Example

```json
{
    "sub":"user"
}
```

Meaning

```
Authenticated User

↓

user
```

In our implementation,

the extracted username becomes the Subject.

---

## Issued At (iat)

Definition

The Issued At claim stores the time when the JWT was created.

Example

```json
{
    "iat":1720566200
}
```

Purpose

```
Token Created

↓

Current Time
```

The server knows exactly when the JWT was generated.

---

## Expiration Time (exp)

Definition

The Expiration claim specifies when the JWT becomes invalid.

Example

```json
{
    "exp":1720567400
}
```

Meaning

```
Current Time

↓

12:00 PM

↓

Token Expires

↓

12:20 PM
```

After expiration,

the JWT cannot be used.

The client must authenticate again.

---

# Why Do Tokens Expire?

Suppose a user's JWT is stolen.

If the token never expires,

an attacker can use it forever.

Instead,

every JWT has a limited lifetime.

Example

```
Generate JWT

↓

Valid for

↓

20 Minutes

↓

Automatically Expires
```

This reduces security risks.

---

# JWT Signature

## Definition

The Signature is the third and most important part of the JWT.

Its purpose is

- Verify authenticity
- Detect modifications
- Prevent tampering

The signature proves that the token was generated by the trusted server.

---

# Why Is the Signature Needed?

Suppose a JWT contains

```json
{
    "role":"USER"
}
```

A malicious user edits it to

```json
{
    "role":"ADMIN"
}
```

Without a signature,

the server would accept the modified token.

The signature prevents this.

Whenever any part of the JWT changes,

the signature becomes invalid.

The server immediately rejects the token.

---

# HMAC SHA-256 (HS256)

Our application signs the JWT using

```
HS256
```

HS256 stands for

```
HMAC

+

SHA-256
```

It is a symmetric signing algorithm.

Meaning,

the same secret key is used for

- Creating the signature
- Verifying the signature

Both the sender and receiver must know the same secret.

---

# What is a Secret Key?

## Definition

A Secret Key is a confidential string known only to the server.

Example

```
secretkeysecretkeysecretkeysecretkey
```

The client never sees this key.

The key is used to digitally sign the JWT.

Whenever the server receives a JWT,

it uses the same secret key to verify the signature.

If verification succeeds,

the token is genuine.

Otherwise,

the token is rejected.

---

# JWT Creation Process

The complete JWT generation process is

```
Username

↓

user

↓

Create Header

↓

Create Payload

↓

Generate Secret Key

↓

Sign using HS256

↓

Generate Signature

↓

Combine

↓

Header

.

Payload

.

Signature

↓

JWT
```

The client receives only the final JWT string.

---

# Security Considerations

Although JWTs are digitally signed,

they are **not encrypted** by default.

Anyone can decode

- Header
- Payload

using any online JWT decoder.

However,

they **cannot modify** the token successfully because the signature would become invalid.

Therefore,

follow these best practices.

- Never store passwords inside the payload.
- Never store sensitive personal information inside the payload.
- Keep the secret key confidential.
- Use sufficiently long and randomly generated secret keys.
- Always use HTTPS when transmitting JWTs.
- Configure reasonable expiration times.
- Rotate secret keys periodically in production environments.

A JWT provides **integrity** and **authenticity** through its digital signature, but **confidentiality** must still be provided by HTTPS and by avoiding sensitive data inside the token.

# JJWT Library

To generate a JWT, we need a library that understands the JWT standard and can create properly formatted tokens.

Instead of manually writing code to

- Create Header
- Create Payload
- Generate Signature
- Combine all three parts
- Encode using Base64URL

we use a library called **JJWT**.

---

# What is JJWT?

## Definition

JJWT (Java JWT) is an open-source Java library used to create, sign, parse, validate, and decode JSON Web Tokens (JWTs).

It provides a simple and developer-friendly API for implementing JWT authentication in Java applications.

Instead of writing hundreds of lines of code manually,

developers can generate a JWT using just a few method calls.

---

# Why Do We Need JJWT?

Suppose we want to generate a JWT manually.

We would need to

```
Create Header

↓

Convert to JSON

↓

Base64URL Encode

↓

Create Payload

↓

Convert to JSON

↓

Base64URL Encode

↓

Generate Signature

↓

Combine

↓

JWT
```

This process is

- Complex
- Error-prone
- Difficult to maintain

Instead,

JJWT performs all these steps automatically.

---

# JJWT in This Exercise

We use the JJWT Builder API.

```
Username

↓

user

↓

JJWT Builder

↓

Header Created

↓

Payload Created

↓

Signature Generated

↓

JWT Returned
```

---

# Dependencies Used

```xml
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.6</version>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.12.6</version>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.12.6</version>
    <scope>runtime</scope>
</dependency>
```

These libraries provide

- JWT Creation
- JWT Parsing
- JWT Validation
- JSON Serialization

---

# What is SecretKey?

## Definition

A `SecretKey` is a cryptographic key used to digitally sign and verify a JWT.

It is shared only by the server.

Clients never know this key.

Example

```java
private static final String SECRET =
        "secretkeysecretkeysecretkeysecretkey";
```

Internally,

this string is converted into a cryptographic key.

```
String

↓

Bytes

↓

SecretKey
```

---

# Why Do We Need a Secret Key?

Suppose two servers exist.

```
Server A

↓

Generate JWT
```

```
Server B

↓

Validate JWT
```

Both servers must use the same secret key.

If someone changes even one character of the JWT,

verification fails.

This guarantees

- Authenticity
- Integrity

---

# Keys.hmacShaKeyFor()

## Definition

`Keys.hmacShaKeyFor()` is a utility method provided by JJWT.

It converts a byte array into a valid HMAC SecretKey.

Example

```java
SecretKey key =
Keys.hmacShaKeyFor(
SECRET.getBytes(StandardCharsets.UTF_8));
```

Flow

```
Secret String

↓

UTF-8 Bytes

↓

SecretKey

↓

Ready for Signing
```

---

# Why Use UTF-8?

Java stores Strings internally as Unicode.

JWT signing requires bytes.

Therefore,

```
String

↓

UTF-8

↓

Byte Array

↓

SecretKey
```

UTF-8 ensures consistent encoding across all platforms.

---

# What is Jwts.builder()?

## Definition

`Jwts.builder()` creates a JWT Builder object.

A Builder follows the Builder Design Pattern.

Instead of constructing the JWT all at once,

we add information step by step.

```
Builder

↓

Subject

↓

Issued Time

↓

Expiration

↓

Signature

↓

JWT
```

---

# Why Builder Pattern?

Imagine building a house.

```
Foundation

↓

Walls

↓

Roof

↓

Doors

↓

Windows

↓

Finished House
```

Similarly,

JWT construction happens in stages.

```
Builder

↓

Header

↓

Payload

↓

Signature

↓

JWT
```

This makes the API easier to read and maintain.

---

# subject()

```java
.subject(user)
```

## Purpose

Sets the **Subject (sub)** claim.

Example

```
Subject

↓

user
```

Generated Payload

```json
{
    "sub":"user"
}
```

The subject identifies the authenticated user.

---

# issuedAt()

```java
.issuedAt(new Date())
```

## Purpose

Stores the token creation time.

Example

```
Current Time

↓

10:30 AM

↓

iat

↓

10:30 AM
```

Generated Payload

```json
{
    "iat":1720566200
}
```

---

# expiration()

```java
.expiration(new Date(System.currentTimeMillis()+1200000))
```

## Purpose

Defines how long the token remains valid.

```
Current Time

↓

10:30 AM

↓

+20 Minutes

↓

10:50 AM

↓

Token Expires
```

Generated Payload

```json
{
    "exp":1720567400
}
```

After expiration,

the server rejects the JWT.

---

# signWith()

```java
.signWith(key)
```

## Purpose

Digitally signs the JWT using the SecretKey.

Flow

```
Header

↓

Payload

↓

SecretKey

↓

HS256

↓

Signature
```

The generated signature protects the JWT against tampering.

---

# compact()

```java
.compact()
```

## Purpose

Generates the final JWT String.

Before

```
Builder Object
```

After

```
eyJhbGciOiJIUzI1NiJ9.
eyJzdWIiOiJ1c2VyIn0.
AbCdEfGhIjKlMn...
```

The returned value is the JWT sent to the client.

---

# Complete JWT Generation Flow

```
Username

↓

user

↓

Secret Key

↓

Jwts.builder()

↓

Subject

↓

Issued Time

↓

Expiration

↓

Sign Token

↓

Generate Signature

↓

compact()

↓

JWT String

↓

Return to Client
```

---

# Token Expiration

Every JWT should have an expiration time.

Why?

Suppose a JWT is stolen.

Without expiration,

the attacker can use it forever.

Instead,

```
JWT Created

↓

Valid for

↓

20 Minutes

↓

Expired

↓

Rejected
```

The client must authenticate again to obtain a new token.

---

# Internal JWT Generation Flow

```
AuthenticationController

        │

        ▼

Extract Username

        │

        ▼

Create SecretKey

        │

        ▼

Jwts.builder()

        │

        ▼

Header Created

        │

        ▼

Payload Created

        │

        ▼

Claims Added

        │

        ▼

Digital Signature Generated

        │

        ▼

Header.Payload.Signature

        │

        ▼

JWT Token

        │

        ▼

Return JSON Response
```

This completes the JWT creation process. In the next section, we will examine the complete implementation of `AuthenticationController.java`, explain every line of code, and understand how all these concepts work together to generate a secure JWT.

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
| AuthenticationController | Authenticates the user and generates JWT |
| Spring Security | Authenticates the username and password |
| JJWT Library | Creates the JWT |
| SecretKey | Signs the JWT |
| Base64 Decoder | Decodes the Authorization Header |
| Logger | Logs the authentication process |
| Map<String,String> | Returns the JWT as JSON |

---

# AuthenticationController.java

Complete Code

```java
package com.cognizant.springlearn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.crypto.SecretKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    private static final String SECRET =
            "secretkeysecretkeysecretkeysecretkey";

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authorizationHeader) {

        LOGGER.info("Start");

        String encodedCredentials = authorizationHeader.substring(6);

        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String credentials =
                new String(decodedBytes, StandardCharsets.UTF_8);

        String username =
                credentials.split(":")[0];

        SecretKey key =
                Keys.hmacShaKeyFor(
                        SECRET.getBytes(StandardCharsets.UTF_8));

        String jwtToken =
                Jwts.builder()

                        .subject(username)

                        .issuedAt(new Date())

                        .expiration(
                                new Date(
                                        System.currentTimeMillis()
                                                + 1200000))

                        .signWith(key)

                        .compact();

        Map<String, String> response =
                new HashMap<>();

        response.put("token", jwtToken);

        LOGGER.info("JWT Generated Successfully");

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

Marks the class as a REST Controller.

Instead of returning HTML pages,

it returns Java objects that Spring Boot automatically converts into JSON.

---

## Logger

```java
private static final Logger LOGGER =
LoggerFactory.getLogger(AuthenticationController.class);
```

Creates a logger object.

The logger records important execution steps during authentication.

Example

```
Start

JWT Generated Successfully

End
```

Logging helps developers debug and monitor the application.

---

## Secret Key

```java
private static final String SECRET =
"secretkeysecretkeysecretkeysecretkey";
```

Defines the secret key used for signing the JWT.

This key should

- Remain confidential
- Be sufficiently long
- Never be exposed to clients

In enterprise applications,

the secret key is usually stored in

- Environment Variables
- Vault Services
- Configuration Servers

rather than directly inside the source code.

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

to this controller method.

Whenever a client accesses

```
http://localhost:8083/authenticate
```

this method executes.

---

## Read Authorization Header

```java
@RequestHeader("Authorization")
String authorizationHeader
```

Spring automatically reads

```
Authorization

↓

Basic dXNlcjpwd2Q=
```

from the incoming HTTP request.

---

## Extract Encoded Credentials

```java
String encodedCredentials =
authorizationHeader.substring(6);
```

Removes

```
Basic
```

from

```
Basic dXNlcjpwd2Q=
```

Result

```
dXNlcjpwd2Q=
```

---

## Decode Base64

```java
byte[] decodedBytes =
Base64.getDecoder().decode(encodedCredentials);
```

Converts

```
dXNlcjpwd2Q=
```

into

```
Byte Array
```

representing

```
user:pwd
```

---

## Convert Bytes to String

```java
String credentials =
new String(decodedBytes,
StandardCharsets.UTF_8);
```

Converts

```
Byte Array

↓

user:pwd
```

into a readable String.

---

## Extract Username

```java
String username =
credentials.split(":")[0];
```

Splits

```
user:pwd
```

into

```
Index 0

↓

user

Index 1

↓

pwd
```

The username becomes

```
user
```

This value is stored as the JWT Subject.

---

## Create SecretKey

```java
SecretKey key =
Keys.hmacShaKeyFor(
SECRET.getBytes(StandardCharsets.UTF_8));
```

Converts the secret string into a cryptographic key.

Flow

```
Secret String

↓

UTF-8 Bytes

↓

SecretKey
```

This key will digitally sign the JWT.

---

## Create JWT Builder

```java
Jwts.builder()
```

Creates a JWT Builder object.

The builder is used to gradually construct the JWT.

---

## Set Subject

```java
.subject(username)
```

Adds the Subject claim.

Payload

```json
{
    "sub":"user"
}
```

The subject identifies the authenticated user.

---

## Set Issued Time

```java
.issuedAt(new Date())
```

Adds the current date and time.

Payload

```json
{
    "iat":1720566200
}
```

The server knows exactly when the JWT was generated.

---

## Set Expiration Time

```java
.expiration(
new Date(
System.currentTimeMillis()+1200000))
```

Adds an expiration time.

```
Current Time

↓

10:30 AM

↓

+20 Minutes

↓

10:50 AM
```

After this time,

the JWT becomes invalid.

---

## Sign the JWT

```java
.signWith(key)
```

Signs the JWT using

```
HS256
```

and the SecretKey.

This generates the digital signature.

Without a valid signature,

the JWT is rejected.

---

## Generate Final JWT

```java
.compact();
```

Converts the Builder into a JWT String.

Example

```
Header

.

Payload

.

Signature
```

↓

```
eyJhbGciOiJIUzI1NiJ9...
```

This String is ready to send to the client.

---

## Create Response

```java
Map<String,String> response =
new HashMap<>();
```

Creates an empty response object.

---

## Store JWT

```java
response.put("token",jwtToken);
```

Stores the generated JWT.

Response

```json
{
    "token":"eyJhbGc..."
}
```

---

## Logging

```java
LOGGER.info(
"JWT Generated Successfully");
```

Prints a success message.

Example

```
JWT Generated Successfully
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

using Jackson.

The client receives

```json
{
    "token":"eyJhbGc..."
}
```

---

# Complete Internal Working

Suppose the client sends

```
Username

↓

user

Password

↓

pwd
```

Complete execution

```
Postman

        │

        ▼

HTTP Basic Authentication

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

user:pwd

        │

        ▼

Extract Username

↓

user

        │

        ▼

Create SecretKey

        │

        ▼

JWT Builder

        │

        ▼

Subject

↓

Issued Time

↓

Expiration

↓

Sign Token

        │

        ▼

JWT Generated

↓

eyJhbGc...

        │

        ▼

JSON Response

↓

{
 "token":"eyJhbGc..."
}
```

---

# JWT Generation Sequence Diagram

```
Client
   │
   │  GET /authenticate
   ▼
Spring Security
   │
Authenticate User
   │
   ▼
AuthenticationController
   │
Decode Authorization Header
   │
Extract Username
   │
Create SecretKey
   │
Build JWT
   │
Sign JWT
   │
Return Token
   ▼
Client Receives JWT
```

---

# JVM Memory Diagram

```
                  JVM

────────────────────────────────────

Method Area

────────────────────────────────────

AuthenticationController.class

Jwts.class

Keys.class

SecretKey.class

Logger.class

HashMap.class

────────────────────────────────────

Heap Memory

────────────────────────────────────

Spring IoC Container

│

├── AuthenticationController Bean

├── Logger

├── SecretKey Object

├── JWT Builder

├── JWT String

└── Response Map

────────────────────────────────────
```

---

# Best Practices

- Store secret keys outside the source code in production.
- Use strong secret keys (at least 256 bits for HS256).
- Set reasonable expiration times for tokens.
- Never include sensitive information such as passwords in JWT claims.
- Always transmit JWTs over HTTPS.
- Rotate secret keys periodically.
- Log authentication events but avoid logging JWTs or sensitive data in production.

---

# Common Mistakes

## 1. Using a Short Secret Key

Wrong

```java
"secret"
```

Correct

```java
"secretkeysecretkeysecretkeysecretkey"
```

HS256 requires a sufficiently strong key.

---

## 2. Forgetting to Sign the JWT

Wrong

```java
Jwts.builder()
.subject(username)
.compact();
```

Correct

```java
.signWith(key)
.compact();
```

Without a signature,

the JWT cannot be trusted.

---

## 3. Omitting Expiration

A JWT without an expiration time can remain valid indefinitely, increasing security risks.

Always include an expiration claim.

---

## 4. Storing Sensitive Data in the Payload

Never store

- Passwords
- PINs
- Credit Card Numbers
- Aadhaar Numbers

inside the JWT payload because it can be decoded.

---

## 5. Hardcoding Secrets in Production

Hardcoding secrets is acceptable only for learning purposes.

Production applications should use secure secret management solutions.

---

# Interview Questions

### 1. What is JWT?

JWT (JSON Web Token) is a compact, URL-safe, digitally signed token used to securely transfer authentication and authorization information.

---

### 2. Why do we generate a JWT?

To authenticate the user once and allow future requests using the token instead of repeatedly sending the username and password.

---

### 3. What is the purpose of the `sub` claim?

It identifies the authenticated user.

---

### 4. Why do we include `iat` and `exp` claims?

`iat` records when the token was issued, and `exp` specifies when the token expires.

---

### 5. What is the purpose of the SecretKey?

The SecretKey is used to digitally sign and later verify the JWT.

---

### 6. What does `Jwts.builder()` do?

It creates a builder object used to construct the JWT step by step.

---

### 7. What does `.compact()` return?

It generates and returns the final JWT string.

---

### 8. Why is JWT considered stateless?

Because the server does not store session information; all required authentication data is carried inside the token.

---

### 9. Can JWT payload data be hidden?

No. The payload is encoded, not encrypted. Anyone can decode it, so sensitive information should never be stored there.

---

### 10. What happens when the JWT expires?

The server rejects the expired token, and the client must authenticate again to obtain a new JWT.

---

# Quick Revision

- JWT replaces repeated username and password transmission.
- JJWT library simplifies JWT creation.
- `SecretKey` signs the token.
- `subject()` stores the authenticated username.
- `issuedAt()` records the token creation time.
- `expiration()` defines the token's validity period.
- `signWith()` digitally signs the JWT.
- `compact()` generates the final JWT string.
- Spring Boot automatically returns the JWT as a JSON response.
- This exercise completes the **JWT Generation** phase and prepares the application for **JWT Validation** in the next hands-on.

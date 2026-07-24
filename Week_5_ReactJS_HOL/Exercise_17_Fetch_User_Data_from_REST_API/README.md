# Exercise 17: Fetch User Data from REST API

## Week 5 – ReactJS Hands-on Lab

> **Response 1 of 4**

---

# Table of Contents

1. Project Title

2. Introduction

3. Learning Objectives

4. Prerequisites

5. Background Concepts

- What is an API?
- What is a REST API?
- Why REST APIs are Important?
- What is API Consumption?
- What is HTTP?
- HTTP Request and Response
- HTTP Methods
- HTTP GET Method
- What is JSON?
- What is Fetch API?
- What is a Promise?
- React Class Components
- React Lifecycle Methods
- componentDidMount()
- React State
- setState()
- Rendering Dynamic Data
- Project Overview
- High-Level Architecture
- Technologies Used

---

# 1. Project Title

# Fetch User Data from REST API

**Week 5 – ReactJS Hands-on Lab**

**Exercise 17 – Fetch User Data from REST API**

---

# 2. Introduction

## What is this project?

This hands-on exercise demonstrates how a React application can **consume a REST API**, retrieve data from an external server, and display it dynamically on the webpage.

According to the uploaded Hands-on Lab, you will create a React application named **fetchuserapp**. The application contains a component named **Getuser**, which invokes the Random User REST API (`https://api.randomuser.me/`) inside the **componentDidMount()** lifecycle method using the **fetch()** API. The application displays the **title**, **first name**, and **image** of a randomly generated user. :contentReference[oaicite:0]{index=0}

---

## What problem does this project solve?

Many modern applications require information that is stored on remote servers instead of inside the application itself.

Examples include:

- Weather Applications
- Online Banking
- Shopping Websites
- Hospital Management Systems
- Social Media Platforms

Instead of storing all information locally,

the application requests the required data from a server whenever it is needed.

Example

```text
React Application

↓

Request Data

↓

REST API

↓

Receive Data

↓

Display Data
```

This project demonstrates this complete process.

---

## Why do we consume REST APIs?

A React application usually displays information obtained from a backend server.

Examples:

- User Details
- Products
- Student Information
- Employee Records
- News Articles
- Weather Reports

Without REST APIs,

applications would not have access to live or frequently updated information.

---

## What is a REST API?

A REST API (Representational State Transfer Application Programming Interface) is a web service that allows one application to communicate with another over HTTP.

Flow

```text
Client

↓

HTTP Request

↓

REST API

↓

Database

↓

HTTP Response

↓

Client
```

---

## What is API Consumption?

API Consumption means requesting data from an API and using that data inside an application.

In this project,

React consumes data from

```text
https://api.randomuser.me/
```

and displays selected user information.

---

## What is Fetch API?

The Fetch API is a built-in JavaScript feature used to send HTTP requests.

Example

```javascript
fetch("https://api.randomuser.me/")
```

It retrieves data asynchronously without refreshing the webpage.

---

## What is JSON?

JSON (JavaScript Object Notation) is a lightweight format used for exchanging data between applications.

Example

```json
{
  "name": {
    "title": "Mr",
    "first": "John"
  }
}
```

The Random User API returns its response in JSON format.

---

## Why use componentDidMount()?

The uploaded Hands-on Lab specifies calling the REST API inside **componentDidMount()**. :contentReference[oaicite:1]{index=1}

This lifecycle method executes automatically after the component is rendered for the first time.

It is the ideal place to:

- Fetch data from APIs
- Connect to servers
- Load external resources

---

## Real-world Applications

REST APIs are used in:

- Online Banking Systems
- E-Commerce Websites
- Hospital Management Systems
- Railway Reservation Systems
- Student Management Portals
- Weather Applications
- Food Delivery Apps
- Social Networking Platforms
- Movie Recommendation Systems
- Stock Market Applications

---

# 3. Learning Objectives

According to the uploaded Hands-on Lab, after completing this exercise you should be able to:

- Explain how to consume REST APIs from React applications.
- Construct a React application that invokes a REST API.
- Fetch data from an external API using the Fetch API.
- Display API data inside a React component. :contentReference[oaicite:2]{index=2}

In addition, this implementation helps you understand:

- React Class Components
- Lifecycle Methods
- Fetch API
- Promises
- JSON
- React State
- Dynamic Rendering

---

# 4. Prerequisites

The uploaded Hands-on Lab specifies the following prerequisites:

| Software | Purpose |
|----------|----------|
| Node.js | JavaScript Runtime |
| npm | Package Manager |
| Visual Studio Code | Code Editor | :contentReference[oaicite:3]{index=3}

Basic knowledge of

- HTML
- CSS
- JavaScript
- React Components

will help you understand this exercise more easily.

---

# 5. Background Concepts

---

# 5.1 What is an API?

## Definition

API stands for **Application Programming Interface**.

It acts as a communication bridge between two software applications.

Example

```text
React App

↓

API

↓

Database
```

Instead of accessing the database directly,

the React application communicates through an API.

---

# 5.2 What is a REST API?

## Definition

REST (Representational State Transfer) is a standard architectural style used to build web services.

A REST API communicates using HTTP requests.

Flow

```text
Client

↓

HTTP Request

↓

REST Server

↓

HTTP Response

↓

Client
```

---

# 5.3 Why are REST APIs Important?

REST APIs allow applications to exchange data over the Internet.

Benefits include:

- Platform independence
- Scalability
- Faster communication
- Reusability
- Easy integration

Most modern web and mobile applications rely on REST APIs.

---

# 5.4 What is API Consumption?

API Consumption means requesting information from an external service and using it inside an application.

Example

```text
React

↓

Request User

↓

Random User API

↓

Receive User

↓

Display User
```

---

# 5.5 What is HTTP?

HTTP stands for **HyperText Transfer Protocol**.

It defines how clients and servers exchange information over the Internet.

Example

```text
Browser

↓

HTTP Request

↓

Server

↓

HTTP Response

↓

Browser
```

---

# 5.6 HTTP Request and Response

A client sends an HTTP Request.

The server processes it and sends an HTTP Response.

Flow

```text
React

↓

Request

↓

Server

↓

Response

↓

React
```

---

# 5.7 HTTP Methods

| Method | Purpose |
|---------|---------|
| GET | Retrieve Data |
| POST | Create Data |
| PUT | Update Existing Data |
| DELETE | Remove Data |

This project uses the **GET** method to retrieve user details from the Random User API. :contentReference[oaicite:4]{index=4}

---

# 5.8 HTTP GET Method

The GET method requests data from the server without modifying it.

Example

```javascript
fetch("https://api.randomuser.me/")
```

The server responds with user information.

---

# 5.9 What is JSON?

## Definition

JSON (JavaScript Object Notation) is a text-based format used to exchange structured data.

Example

```json
{
  "results": [
    {
      "name": {
        "title": "Mr",
        "first": "John"
      }
    }
  ]
}
```

The Random User API sends its response in JSON format.

---

# 5.10 What is Fetch API?

The Fetch API is a built-in JavaScript interface for sending HTTP requests.

Example

```javascript
fetch("https://api.randomuser.me/")
```

Advantages:

- Built into modern browsers
- Promise-based
- Easy to use
- Supports asynchronous programming

---

# 5.11 What is a Promise?

A Promise represents the result of an asynchronous operation.

A Promise has three possible states:

| State | Meaning |
|--------|---------|
| Pending | Request is in progress |
| Fulfilled | Request completed successfully |
| Rejected | Request failed |

Flow

```text
fetch()

↓

Promise

↓

Success

or

Failure
```

---

# 5.12 React Class Components

A Class Component is a React component created using JavaScript classes.

Example

```jsx
class Getuser extends Component{

}
```

The uploaded Hands-on Lab specifically uses a **Class Component** named **Getuser**. :contentReference[oaicite:5]{index=5}

---

# 5.13 React Lifecycle Methods

Lifecycle methods define what happens during different stages of a component's life.

Major stages include:

- Mounting
- Updating
- Unmounting

This exercise uses the **Mounting** stage.

---

# 5.14 componentDidMount()

`componentDidMount()` executes immediately after the component is rendered.

Flow

```text
Component Created

↓

Rendered

↓

componentDidMount()

↓

REST API Call

↓

Receive Data

↓

Update State
```

According to the uploaded Hands-on Lab, the API should be invoked inside `componentDidMount()`. :contentReference[oaicite:6]{index=6}

---

# 5.15 React State

State stores data that changes during the execution of a React component.

Example

```jsx
this.state = {
  person: null,
  loading: true
};
```

After the API returns data,

React updates the State and automatically re-renders the UI.

---

# 5.16 setState()

`setState()` updates the State of a Class Component.

Example

```jsx
this.setState({

person:data.results[0],

loading:false

});
```

Whenever `setState()` is called,

React automatically updates the user interface.

---

# 5.17 Rendering Dynamic Data

Instead of displaying fixed values,

React displays values obtained from the API.

Example

```jsx
person.name.title

person.name.first

person.picture.large
```

Each time the API returns a different user,

the displayed information changes automatically.

---

# 6. Project Overview

The **fetchuserapp** demonstrates how a React application communicates with an external REST API.

The application:

- Sends an HTTP GET request
- Receives JSON data
- Converts JSON into JavaScript objects
- Stores the data inside React State
- Displays the user's title
- Displays the user's first name
- Displays the user's profile image

---

# 7. High-Level Architecture

```text
                React Application
                       │
                       ▼
                    App.js
                       │
                       ▼
                 Getuser Component
                       │
                       ▼
             componentDidMount()
                       │
                       ▼
                  fetch() API
                       │
                       ▼
        https://api.randomuser.me/
                       │
                       ▼
                 JSON Response
                       │
                       ▼
                  setState()
                       │
                       ▼
               React Re-renders UI
                       │
                       ▼
        Display Image, Title and Name
```

---

# 8. Technologies Used

| Technology | Purpose | Role in this Project |
|------------|---------|----------------------|
| **React** | JavaScript Library | Builds the user interface |
| **JSX** | Syntax Extension | Creates UI Components |
| **JavaScript (ES6)** | Programming Language | Implements Fetch API logic |
| **Fetch API** | HTTP Requests | Retrieves data from REST API |
| **REST API** | Web Service | Provides random user details |
| **JSON** | Data Format | Transfers structured user data |
| **React Class Components** | UI Component | Implements Getuser component |
| **Lifecycle Methods** | Component Lifecycle | Calls API after rendering |
| **HTML** | Structure | Displays fetched data |
| **CSS** | Styling | Styles the application |
| **Node.js** | JavaScript Runtime | Runs the React application |
| **npm** | Package Manager | Installs dependencies |
| **Visual Studio Code** | IDE | Used for development |

---

# Exercise 17: Fetch User Data from REST API

## Week 5 – ReactJS Hands-on Lab

> **Response 2 of 4**

---

# 9. Project Structure

The **fetchuserapp** follows a simple and organized React project structure. Each file has a specific responsibility, making the application easy to understand, maintain, and extend.

```text
fetchuserapp
│
├── node_modules
│
├── public
│
├── src
│   │
│   ├── components
│   │      │
│   │      └── Getuser.js
│   │
│   ├── App.js
│   ├── App.css
│   ├── index.js
│   └── index.css
│
├── package.json
└── README.md
```

---

# 10. Folder Explanation

## node_modules

This folder contains all the libraries and packages required by the React application.

Examples include:

- React
- React DOM
- Babel
- Webpack

This folder is automatically created after executing:

```bash
npm install
```

---

## public

The **public** folder contains static resources that are directly served by the browser.

Common files include:

- index.html
- favicon.ico
- manifest.json

The React application is mounted inside **index.html**.

---

## src

The **src** folder contains the complete source code of the React application.

It includes:

- Components
- CSS files
- JavaScript files
- Application entry point

---

## components

The **components** folder stores reusable React components.

In this project it contains:

```text
Getuser.js
```

According to the uploaded Hands-on Lab, **Getuser** is the component responsible for fetching and displaying user information from the Random User REST API. :contentReference[oaicite:0]{index=0}

---

# 11. File-by-File Explanation

---

# Getuser.js

## Purpose

`Getuser.js` is the main component of this project.

Its responsibilities include:

- Calling the REST API
- Receiving user data
- Storing data inside React State
- Displaying loading status
- Rendering the user's image
- Rendering the user's title
- Rendering the user's first name

---

## Import Statement

```jsx
import React, { Component } from "react";
```

This imports:

- React
- Component class

Since the uploaded HOL uses a **Class Component**, we extend the `Component` class. :contentReference[oaicite:1]{index=1}

---

## Constructor

The constructor initializes the component before rendering.

Example

```jsx
constructor(props){

super(props);

}
```

Responsibilities:

- Initialize State
- Prepare the component for execution

---

## State Initialization

Initially the component stores

```jsx
this.state={

person:null,

loading:true

};
```

Meaning

```text
person

↓

No user available yet
```

and

```text
loading

↓

API request still in progress
```

---

## componentDidMount()

The uploaded Hands-on Lab specifically instructs invoking the REST API inside **componentDidMount()**. :contentReference[oaicite:2]{index=2}

Flow

```text
Component Rendered

↓

componentDidMount()

↓

Call REST API
```

This lifecycle method is executed automatically after the component is displayed for the first time.

---

## Fetch API

The application retrieves user information using

```jsx
fetch("https://api.randomuser.me/")
```

Flow

```text
React

↓

fetch()

↓

Random User API

↓

JSON Response

↓

React
```

The request is asynchronous, meaning the UI remains responsive while waiting for the server.

---

## Promise Handling

The Fetch API returns a Promise.

The application processes it using

```jsx
.then(...)
```

Flow

```text
fetch()

↓

Promise

↓

Success

↓

Receive Data
```

If the request fails,

the application handles the error using

```jsx
.catch(...)
```

---

## Converting Response to JSON

The server sends data in JSON format.

React converts it using

```jsx
response.json()
```

Flow

```text
HTTP Response

↓

JSON

↓

JavaScript Object
```

---

## Updating React State

After receiving the data,

the component updates the State.

Example

```jsx
this.setState({

person:data.results[0],

loading:false

});
```

Flow

```text
API Response

↓

setState()

↓

State Updated

↓

Component Re-rendered
```

---

## Rendering User Details

Once the API response is available,

the component displays

```jsx
person.name.title
```

```jsx
person.name.first
```

```jsx
person.picture.large
```

These fields satisfy the requirement to display the user's **title**, **first name**, and **image**. :contentReference[oaicite:3]{index=3}

---

## Loading Screen

Before the API returns data,

the application displays

```text
Loading...
```

Flow

```text
Application Starts

↓

API Request

↓

Loading...

↓

Receive Data

↓

Display User
```

This prevents runtime errors caused by accessing unavailable data.

---

# App.js

## Purpose

`App.js` is the root component of the application.

Responsibilities:

- Import the `Getuser` component
- Display the `Getuser` component

Example

```jsx
<Getuser/>
```

Flow

```text
App.js

↓

Getuser

↓

User Information
```

---

# App.css

## Purpose

`App.css` styles the application.

It provides:

- Center alignment
- Card layout
- Image styling
- Heading colors
- Proper spacing

The CSS makes the displayed user information visually appealing and easy to read.

---

# index.js

## Purpose

`index.js` is the entry point of the React application.

Responsibilities:

- Create the React Root
- Render `<App />`
- Load global CSS

Flow

```text
Browser

↓

index.js

↓

<App/>

↓

Getuser

↓

Display User
```

---

# index.css

## Purpose

Provides global styling for the application.

Example

```css
body{

margin:0;

font-family:Arial, Helvetica, sans-serif;

background:#f4f4f4;

}
```

These styles apply to the entire application.

---

# 12. Configuration Explanation

Create the project.

```bash
npx create-react-app fetchuserapp
```

Move into the project.

```bash
cd fetchuserapp
```

Install dependencies.

```bash
npm install
```

Run the application.

```bash
npm start
```

Open the browser.

```text
http://localhost:3000
```

---

# 13. Implementation Explanation

The application executes the following sequence.

### Step 1

Application Starts

↓

index.js Loaded

---

### Step 2

App Component Rendered

↓

Getuser Component Loaded

---

### Step 3

Constructor Executes

↓

Initialize State

```text
person = null

loading = true
```

---

### Step 4

Component Rendered

↓

Loading Screen Displayed

---

### Step 5

componentDidMount()

↓

Invoke REST API

---

### Step 6

Receive JSON Response

↓

Convert JSON

↓

Update State

---

### Step 7

State Updated

↓

loading = false

↓

person = API Data

---

### Step 8

React Re-renders Component

↓

Display

- User Image
- User Title
- User First Name

---

# 14. Code Flow

```text
Application Starts

↓

index.js

↓

App.js

↓

Getuser Component

↓

Constructor

↓

Initialize State

↓

componentDidMount()

↓

fetch()

↓

REST API

↓

Receive JSON

↓

response.json()

↓

setState()

↓

Render()

↓

Display User
```

---

# 15. Execution Flow

```text
User Opens Browser

↓

React Application Starts

↓

Getuser Component Created

↓

Loading Message

↓

HTTP GET Request

↓

Random User API

↓

JSON Response

↓

Update State

↓

React Re-renders

↓

Display User Image

↓

Display User Title

↓

Display User First Name
```

---

# 16. Internal Working

Internally the application performs the following operations.

```text
Browser Opens

↓

React Starts

↓

Constructor

↓

Initialize State

↓

Render()

↓

componentDidMount()

↓

fetch()

↓

HTTP GET Request

↓

REST API

↓

Receive JSON

↓

Convert JSON

↓

setState()

↓

React Virtual DOM Updated

↓

UI Updated
```

---

# 17. REST API Implementation

## Constructor

Creates the initial state.

```text
person = null

loading = true
```

---

## componentDidMount()

Automatically executes after the component is rendered.

Used for:

- Fetching data
- Calling REST APIs
- Loading external resources

---

## fetch()

Sends an HTTP GET request.

```text
React

↓

Server

↓

JSON
```

---

## response.json()

Converts the server response into a JavaScript object.

---

## setState()

Stores the received user inside React State.

React automatically updates the UI after `setState()` is called.

---

## Rendering User Data

The component displays:

- Profile Image
- User Title
- User First Name

using values obtained from the REST API.

---

## Loading State

Before data is available,

the application displays

```text
Loading...
```

After receiving the response,

the loading message disappears and the fetched user information is displayed.

This implementation follows the uploaded Hands-on Lab by consuming the Random User REST API through `componentDidMount()` using the Fetch API and rendering the user's title, first name, and image. :contentReference[oaicite:4]{index=4}

---

# Exercise 17: Fetch User Data from REST API

## Week 5 – ReactJS Hands-on Lab

> **Response 3 of 4**

---

# 18. Concepts Explained in Detail

The uploaded Hands-on Lab focuses on learning how a React application communicates with an external REST API and displays the received data dynamically. The main concepts covered are:

- REST API
- API Consumption
- HTTP GET Request
- Fetch API
- JSON Response
- Promises
- React Class Components
- React Lifecycle (`componentDidMount()`)
- React State
- `setState()`
- Rendering Dynamic Data :contentReference[oaicite:0]{index=0}

---

# 18.1 What is a REST API?

## Definition

REST API stands for **Representational State Transfer Application Programming Interface**.

It is a web service that allows two different applications to communicate with each other over the Internet using HTTP.

Example

```text
React Application

↓

HTTP Request

↓

REST API

↓

Database

↓

HTTP Response

↓

React Application
```

REST APIs are one of the most common ways to exchange information between frontend and backend applications.

---

## Why are REST APIs Important?

REST APIs make applications more flexible because the frontend and backend are independent.

Benefits include:

- Platform independent
- Easy integration
- Faster development
- Scalable architecture
- Reusable services

---

# 18.2 API Consumption

## Definition

API Consumption means requesting information from an external API and using the returned data inside an application.

In this project,

React requests user details from

```text
https://api.randomuser.me/
```

and displays selected information.

Flow

```text
React

↓

Request

↓

Random User API

↓

Receive User

↓

Display User
```

This process is called **consuming a REST API**.

---

# 18.3 HTTP GET Request

## Definition

The GET method requests information from the server without changing any data.

Example

```javascript
fetch("https://api.randomuser.me/")
```

Flow

```text
Client

↓

GET Request

↓

Server

↓

JSON Response

↓

Client
```

The uploaded Hands-on Lab specifically uses the GET method through the Fetch API. :contentReference[oaicite:1]{index=1}

---

# 18.4 Fetch API

## Definition

The Fetch API is a built-in JavaScript interface used to communicate with web servers.

Syntax

```javascript
fetch(URL)
```

Example

```javascript
fetch("https://api.randomuser.me/")
```

Advantages

- Built into browsers
- Easy to use
- Promise-based
- Supports asynchronous programming
- No additional library required

---

## Fetch API Workflow

```text
React Component

↓

fetch()

↓

HTTP GET Request

↓

REST API

↓

HTTP Response

↓

JSON

↓

Display Data
```

---

# 18.5 JSON Response

## Definition

JSON (JavaScript Object Notation) is the standard format used to exchange structured data between applications.

A simplified response from the Random User API looks like this:

```json
{
  "results": [
    {
      "name": {
        "title": "Mr",
        "first": "John"
      },
      "picture": {
        "large": "image-url"
      }
    }
  ]
}
```

The application extracts:

- `name.title`
- `name.first`
- `picture.large`

These are the fields displayed according to the uploaded Hands-on Lab. :contentReference[oaicite:2]{index=2}

---

# 18.6 Promises

## Definition

A Promise represents the result of an asynchronous operation.

The Fetch API returns a Promise.

A Promise has three states:

| State | Meaning |
|--------|---------|
| Pending | Request is in progress |
| Fulfilled | Request completed successfully |
| Rejected | Request failed |

Flow

```text
fetch()

↓

Promise

↓

Success

↓

Receive Data

or

Failure

↓

Catch Error
```

---

# 18.7 React Lifecycle

Every React Class Component goes through different stages.

These stages are called the **Lifecycle**.

Major lifecycle stages include:

- Mounting
- Updating
- Unmounting

This project mainly uses the **Mounting** phase.

---

# 18.8 componentDidMount()

## Definition

`componentDidMount()` executes automatically after the component is rendered for the first time.

Flow

```text
Constructor

↓

Render

↓

componentDidMount()

↓

REST API Call

↓

Receive Data

↓

setState()

↓

Render Again
```

The uploaded Hands-on Lab instructs invoking the REST API inside `componentDidMount()`. :contentReference[oaicite:3]{index=3}

---

## Why use componentDidMount()?

Because:

- The UI is already rendered.
- The component is ready to communicate with the server.
- It prevents unnecessary API calls during rendering.

Typical use cases:

- Fetch data
- Load configuration
- Connect to servers

---

# 18.9 React State

## Definition

State stores information that can change during the execution of a React component.

Example

```jsx
this.state = {

person:null,

loading:true

};
```

Initially

```text
person

↓

null
```

After the API returns data

```text
person

↓

User Information
```

---

## Why use State?

State allows React to automatically update the UI whenever data changes.

Flow

```text
State Changes

↓

React Detects Change

↓

UI Updated
```

---

# 18.10 setState()

`setState()` updates the State of a Class Component.

Example

```jsx
this.setState({

person:data.results[0],

loading:false

});
```

Flow

```text
API Response

↓

setState()

↓

Render()

↓

Display User
```

Unlike directly modifying variables,

`setState()` tells React to re-render the component.

---

# 18.11 Rendering Dynamic Data

Instead of displaying fixed values,

React displays information received from the API.

Example

```jsx
person.name.title

person.name.first

person.picture.large
```

Since the API returns a different user on each request,

the displayed information changes dynamically.

---

# 19. Sample API Response

The Random User API returns a JSON object similar to the following.

```json
{
  "results": [
    {
      "name": {
        "title": "Mr",
        "first": "John"
      },
      "picture": {
        "large": "https://..."
      }
    }
  ]
}
```

The application extracts only the required fields:

- Title
- First Name
- Profile Image

as required by the uploaded Hands-on Lab. :contentReference[oaicite:4]{index=4}

---

# 20. Sample Output

When the application starts,

the following message appears.

```text
Loading...
```

After the API responds,

the page displays

```text
Random User Details

(Image)

Mr John
```

Since the API generates random users,

the displayed details change each time the application is refreshed.

---

# 21. How to Run the Project

Create the project.

```bash
npx create-react-app fetchuserapp
```

Move into the project.

```bash
cd fetchuserapp
```

Install dependencies.

```bash
npm install
```

Run the application.

```bash
npm start
```

Open the browser.

```text
http://localhost:3000
```

---

# 22. Testing

Verify the following test cases after running the application.

| Test Case | Expected Result |
|-----------|-----------------|
| Application starts | Successfully loads |
| Loading message displayed | ✅ |
| API request sent | ✅ |
| JSON response received | ✅ |
| User image displayed | ✅ |
| User title displayed | ✅ |
| User first name displayed | ✅ |
| Component updates automatically | ✅ |

---

# 23. Best Practices

When consuming REST APIs in React:

- Use `componentDidMount()` for API calls in Class Components.
- Store API responses in React State.
- Show a loading indicator while waiting for data.
- Handle API errors using `.catch()`.
- Render data only after confirming it exists.
- Keep API logic separate from presentation logic.

---

# 24. Common Mistakes

### Calling `fetch()` inside `render()`

Incorrect

```jsx
render(){

fetch(...);

}
```

This causes repeated API requests because `render()` may execute multiple times.

Correct

```jsx
componentDidMount(){

fetch(...);

}
```

---

### Forgetting `response.json()`

Incorrect

```jsx
.then(response=>response)
```

Correct

```jsx
.then(response=>response.json())
```

Without converting the response to JSON, the application cannot access the returned data.

---

### Accessing Data Before It Loads

Incorrect

```jsx
person.name.first
```

when `person` is still `null`.

Correct

Display a loading message until the API response is received.

---

### Forgetting `setState()`

Incorrect

```jsx
person=data.results[0];
```

Correct

```jsx
this.setState({

person:data.results[0]

});
```

Using `setState()` ensures React updates the UI.

---

# 25. Real-world Applications

Fetching data from REST APIs is used in:

- Weather Applications
- Banking Dashboards
- E-Commerce Websites
- Hospital Management Systems
- Student Portals
- Employee Management Systems
- Flight Booking Systems
- News Applications
- Food Delivery Platforms
- Social Media Applications

---

# 26. Advantages

Using REST APIs in React provides:

- Live data updates
- Dynamic user interfaces
- Separation of frontend and backend
- Easy integration with different services
- Scalable application architecture
- Better maintainability

---

# 27. Limitations

Although REST APIs are powerful,

they also have some limitations:

- Internet connection is required.
- Server downtime affects data availability.
- Slow network responses may increase loading time.
- Applications should handle API failures gracefully.
- Sensitive data should always be protected through proper authentication and authorization.

---

# Exercise 17: Fetch User Data from REST API

## Week 5 – ReactJS Hands-on Lab

> **Response 4 of 4**

---

# 28. Frequently Asked Interview Questions

## 1. What is an API?

**Answer:**

API (Application Programming Interface) is a communication bridge that allows two software applications to exchange data and functionality.

---

## 2. What is a REST API?

**Answer:**

A REST API (Representational State Transfer API) is a web service that allows applications to communicate over HTTP using standard methods such as GET, POST, PUT, and DELETE.

---

## 3. What is API Consumption?

**Answer:**

API Consumption is the process of sending a request to an API, receiving the response, and using that data inside an application.

---

## 4. Why do React applications consume REST APIs?

**Answer:**

React applications consume REST APIs to display dynamic data such as user information, products, weather reports, news, and more.

---

## 5. What is the Fetch API?

**Answer:**

The Fetch API is a built-in JavaScript interface used to send HTTP requests and receive responses from web servers.

---

## 6. Why is Fetch API preferred?

**Answer:**

Because it is:

- Built into modern browsers
- Promise-based
- Easy to use
- Supports asynchronous programming

---

## 7. Which HTTP method is used in this project?

**Answer:**

GET

The GET method retrieves user data from the Random User REST API. :contentReference[oaicite:0]{index=0}

---

## 8. What is JSON?

**Answer:**

JSON (JavaScript Object Notation) is a lightweight data format used to exchange structured information between applications.

---

## 9. Why is `response.json()` used?

**Answer:**

It converts the HTTP response into a JavaScript object so that React can access the returned data.

---

## 10. What is a Promise?

**Answer:**

A Promise represents the result of an asynchronous operation.

---

## 11. What are the three states of a Promise?

**Answer:**

- Pending
- Fulfilled
- Rejected

---

## 12. What is asynchronous programming?

**Answer:**

Asynchronous programming allows the application to continue executing other tasks while waiting for long-running operations, such as API requests, to complete.

---

## 13. What is a React Class Component?

**Answer:**

A Class Component is a React component created using JavaScript classes and extending the `Component` class.

---

## 14. Which lifecycle method is used in this project?

**Answer:**

`componentDidMount()`

---

## 15. Why is `componentDidMount()` used?

**Answer:**

Because it executes immediately after the component is rendered and is the recommended place to fetch data from external APIs.

---

## 16. What is React State?

**Answer:**

State is an object that stores dynamic data for a component.

Whenever State changes,

React automatically updates the UI.

---

## 17. What is `setState()`?

**Answer:**

`setState()` updates the State of a Class Component and triggers a re-render.

---

## 18. Why is `setState()` important?

**Answer:**

Without `setState()`,

React will not know that the data has changed, so the UI will not update automatically.

---

## 19. Why do we display a loading message?

**Answer:**

To inform the user that data is being fetched and to prevent accessing data before it is available.

---

## 20. Which API is used in this project?

**Answer:**

```text
https://api.randomuser.me/
```

This API provides randomly generated user information. :contentReference[oaicite:1]{index=1}

---

## 21. Which user details are displayed?

**Answer:**

According to the uploaded Hands-on Lab:

- Title
- First Name
- Profile Image :contentReference[oaicite:2]{index=2}

---

## 22. Which component performs the API call?

**Answer:**

`Getuser`

---

## 23. Which component loads `Getuser`?

**Answer:**

`App.js`

---

## 24. Why should `fetch()` not be called inside `render()`?

**Answer:**

Because `render()` can execute multiple times, resulting in repeated API requests and performance issues.

---

## 25. What happens after `setState()`?

**Answer:**

React automatically re-renders the component with the updated data.

---

## 26. What is dynamic rendering?

**Answer:**

Dynamic rendering displays data received at runtime instead of hardcoded values.

---

## 27. How is the profile image displayed?

**Answer:**

Using the image URL returned by the API, for example:

```jsx
<img src={person.picture.large} alt="User" />
```

---

## 28. What happens if the API request fails?

**Answer:**

The `.catch()` block handles the error, allowing the application to log or display an appropriate message.

---

## 29. Why is `.catch()` used?

**Answer:**

To handle network errors or unexpected failures during the API request.

---

## 30. What software is required for this project?

**Answer:**

- Node.js
- npm
- Visual Studio Code :contentReference[oaicite:3]{index=3}

---

## 31. Can Fetch API send POST requests?

**Answer:**

Yes.

Fetch API supports:

- GET
- POST
- PUT
- DELETE
- PATCH

---

## 32. What is the main objective of this exercise?

**Answer:**

To learn how to consume a REST API from a React application and display the retrieved data dynamically. :contentReference[oaicite:4]{index=4}

---

## 33. Why are REST APIs widely used?

**Answer:**

Because they are simple, scalable, platform-independent, and widely supported by web and mobile applications.

---

## 34. Can multiple API calls be made in one React component?

**Answer:**

Yes.

A component can call multiple APIs depending on the application's requirements.

---

## 35. What are the benefits of separating frontend and backend using REST APIs?

**Answer:**

- Independent development
- Easier maintenance
- Better scalability
- Reusable backend services
- Support for multiple client applications

---

# 29. Quick Revision Notes

## Important Concepts

- API
- REST API
- HTTP
- HTTP GET
- Fetch API
- JSON
- Promise
- React Class Components
- Lifecycle Methods
- `componentDidMount()`
- React State
- `setState()`
- Dynamic Rendering

---

## Important Files

```text
src/
│
├── components/
│     └── Getuser.js
│
├── App.js
├── App.css
├── index.js
└── index.css
```

---

## Important Commands

Create project

```bash
npx create-react-app fetchuserapp
```

Move into project

```bash
cd fetchuserapp
```

Install dependencies

```bash
npm install
```

Run application

```bash
npm start
```

---

# 30. REST API Cheat Sheet

| Concept | Purpose |
|---------|---------|
| REST API | Exchange data between applications |
| HTTP GET | Retrieve data |
| Fetch API | Send HTTP requests |
| Promise | Handle asynchronous operations |
| `response.json()` | Convert response to JavaScript object |
| `componentDidMount()` | Fetch data after component mounts |
| State | Store dynamic data |
| `setState()` | Update state and re-render UI |
| JSON | Structured data exchange format |
| `.catch()` | Handle request errors |

---

# 31. Project Workflow Summary

```text
Start Application
        │
        ▼
Render App Component
        │
        ▼
Render Getuser Component
        │
        ▼
Initialize State
        │
        ▼
componentDidMount()
        │
        ▼
Send HTTP GET Request
        │
        ▼
Random User REST API
        │
        ▼
Receive JSON Response
        │
        ▼
Convert JSON
        │
        ▼
Update State
        │
        ▼
React Re-renders Component
        │
        ▼
Display User Image
        │
        ▼
Display User Title
        │
        ▼
Display User First Name
```

---

# 32. Key Takeaways

After completing this exercise, you should be able to:

- Explain what an API is.
- Understand the purpose of REST APIs.
- Consume REST APIs from React applications.
- Send HTTP GET requests using the Fetch API.
- Process JSON responses.
- Understand Promises and asynchronous programming.
- Use React Class Components.
- Use the `componentDidMount()` lifecycle method.
- Manage dynamic data using React State.
- Update the UI using `setState()`.
- Display data retrieved from external APIs.

These learning outcomes are aligned with the objectives of the uploaded Hands-on Lab. :contentReference[oaicite:5]{index=5}

---

# 33. Conclusion

The **fetchuserapp** project demonstrates how a React application can communicate with an external REST API to retrieve and display dynamic information.

In this exercise, the **Getuser** class component invokes the Random User API inside the `componentDidMount()` lifecycle method using the Fetch API. The JSON response is converted into a JavaScript object, stored in the component's State, and rendered to display the user's **title**, **first name**, and **profile image**. This exercise provides a practical introduction to consuming REST APIs, working with asynchronous operations, and managing dynamic data in React applications. :contentReference[oaicite:6]{index=6}

---

# 34. Next Learning Path

After mastering this exercise, continue with the following React topics:

1. Functional Components with Hooks
2. `useEffect()` for API Calls
3. Axios for HTTP Requests
4. React Router
5. Context API
6. Redux
7. Authentication with JWT
8. Protected Routes
9. CRUD Operations with REST APIs
10. Deployment of React Applications

These topics will help you build scalable, data-driven, and production-ready React applications.

---

# README Completed

This README provides:

- Beginner-friendly explanations
- REST API fundamentals
- HTTP request/response concepts
- Fetch API and Promise explanation
- Project architecture
- File-by-file explanation
- Workflow diagrams
- Lifecycle method details
- Best practices
- Common mistakes
- 35 Interview Questions
- Quick revision notes
- REST API cheat sheet
- Conclusion
- Next learning path

It is based on **Exercise 17 – Fetch User Data from REST API** from the uploaded Week 5 ReactJS Hands-on Lab and is suitable for GitHub documentation, revision, and interview preparation. :contentReference[oaicite:7]{index=7}

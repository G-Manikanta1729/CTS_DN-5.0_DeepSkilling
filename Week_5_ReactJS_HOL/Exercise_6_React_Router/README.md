# Exercise 6: React Router

## Week 5 – ReactJS Hands-on Lab

> **Response 1 of 4**

---

# Table of Contents

1. Project Title

2. Introduction

3. Learning Objectives

4. Prerequisites

5. Background Concepts

* What is a Single Page Application (SPA)?
* What is Routing?
* What is React Router?
* Why React Router is Needed?
* Features of React Router
* BrowserRouter
* Routes
* Route
* Link
* Navigate
* URL Parameters
* useParams Hook
* Client-side Routing vs Server-side Routing

6. Project Overview

7. High-Level Architecture

8. Technologies Used

---

# 1. Project Title

# React Router – Trainers Management Application

**Week 5 – ReactJS Hands-on Lab**

**Exercise 6 – React Router**

---

# 2. Introduction

## What is this project?

This exercise introduces **React Router**, the standard routing library used in React applications for navigation between different pages without reloading the browser.

According to the uploaded Cognizant hands-on lab, the objective is to build a **Single Page Application (SPA)** that maintains a list of trainers and allows users to:

* Navigate between Home and Trainers pages.
* View a list of trainers.
* Click a trainer name to view detailed information.
* Pass trainer IDs through the URL.
* Retrieve URL parameters using the `useParams` hook.
* Configure routing using React Router components. 

---

## Why is this project important?

Modern web applications rarely consist of a single page.

Examples include:

* Student Portals
* Banking Applications
* E-Commerce Websites
* Hospital Management Systems
* Employee Dashboards

Users expect smooth navigation without refreshing the entire application.

React Router makes this possible through **client-side routing**, providing a faster and more responsive user experience.

---

## Real-world Example

Consider an online shopping website.

Instead of loading a new webpage every time you click:

```text
Home

↓

Products

↓

Product Details

↓

Cart

↓

Checkout
```

React updates only the required component while keeping the rest of the application unchanged.

This is the concept used in this exercise.

---

## Where is React Router Used?

React Router is commonly used in:

* Banking Portals
* E-Commerce Websites
* Learning Management Systems
* HR Management Systems
* Hospital Applications
* Online Examination Portals
* Employee Dashboards
* Social Media Platforms

---

# 3. Learning Objectives

After completing this exercise, you should be able to:

* Understand the need for routing in React.
* Explain the benefits of React Router.
* Configure React Router in a React application.
* Create navigation links.
* Define routes using `Routes` and `Route`.
* Redirect users using `Navigate`.
* Pass parameters through URLs.
* Retrieve URL parameters using `useParams`.
* Build a simple Single Page Application (SPA).

These objectives are taken directly from the uploaded hands-on lab. 

---

# 4. Prerequisites

Before starting this exercise, ensure the following software is installed.

| Software           | Purpose                |
| ------------------ | ---------------------- |
| Node.js            | JavaScript Runtime     |
| npm                | Package Manager        |
| Visual Studio Code | Code Editor            |
| React              | User Interface Library |
| React Router DOM   | Routing Library        |

The uploaded lab lists Node.js, npm, and Visual Studio Code as prerequisites, and instructs installing `react-router-dom`. 

---

# 5. Background Concepts

---

# 5.1 What is a Single Page Application (SPA)?

## Definition

A **Single Page Application (SPA)** is a web application that loads a single HTML page and dynamically updates the content without refreshing the entire browser page.

Traditional websites:

```text
Home

↓

Reload Browser

↓

About

↓

Reload Browser

↓

Contact
```

Single Page Application:

```text
Home

↓

About

↓

Contact

(No Page Reload)
```

---

## Advantages of SPA

* Faster navigation
* Better user experience
* Reduced server requests
* Smooth page transitions
* Improved performance

---

# 5.2 What is Routing?

## Definition

Routing is the process of displaying different components based on the current URL.

Example

```text
/home

↓

Home Component
```

```text
/trainers

↓

Trainers List Component
```

```text
/trainers/t-syed8

↓

Trainer Details Component
```

Routing allows a single application to behave like a multi-page website.

---

# 5.3 What is React Router?

## Definition

React Router is the official routing library for React that enables navigation between different components without reloading the page.

It allows developers to:

* Create multiple routes.
* Navigate between pages.
* Pass parameters through URLs.
* Redirect users.
* Build Single Page Applications.

The uploaded lab specifically requires installing `react-router-dom` and using its routing components. 

---

# 5.4 Why is React Router Needed?

Without React Router:

```text
Home

↓

Reload Browser

↓

Trainers

↓

Reload Browser

↓

Trainer Details
```

With React Router:

```text
Home

↓

Trainers

↓

Trainer Details

(No Reload)
```

Benefits include:

* Faster navigation
* Better performance
* Seamless user experience
* Component-based navigation

---

# 5.5 Features of React Router

React Router provides several useful features:

* Client-side routing
* Dynamic URL handling
* Route parameters
* Nested routing
* Navigation links
* Page redirection
* Browser history integration

This exercise focuses on basic routing, navigation links, and URL parameter passing. 

---

# 5.6 BrowserRouter

## Definition

`BrowserRouter` is the top-level router component that enables routing using the browser's History API.

Example

```jsx
<BrowserRouter>

    <App />

</BrowserRouter>
```

Without `BrowserRouter`, routing will not work.

---

# 5.7 Routes

## Definition

`Routes` is a container that holds all route definitions.

Example

```jsx
<Routes>

    <Route path="/home" element={<Home />} />

</Routes>
```

It ensures that only the matching route is rendered.

---

# 5.8 Route

## Definition

A `Route` maps a URL path to a React component.

Example

```jsx
<Route

path="/trainers"

element={<TrainersList />}

/>
```

Meaning

```text
URL

↓

/trainers

↓

Render TrainersList Component
```

---

# 5.9 Link

## Definition

`Link` creates navigation hyperlinks inside a React application.

Example

```jsx
<Link to="/home">

Home

</Link>
```

Unlike an HTML `<a>` tag, `Link` changes the route without reloading the page.

---

# 5.10 Navigate

## Definition

`Navigate` redirects users from one route to another.

Example

```jsx
<Route

path="/"

element={<Navigate to="/home" replace />}

/>
```

Meaning

```text
User Opens "/"

↓

Automatically Redirect

↓

"/home"
```

The uploaded lab requires the root URL (`/`) to redirect to the Home component. 

---

# 5.11 URL Parameters

## Definition

URL parameters allow values to be passed as part of the URL.

Example

```text
/trainers/t-syed8
```

Here,

```text
t-syed8
```

is the parameter.

React Router captures this value using:

```jsx
useParams()
```

---

# 5.12 useParams Hook

## Definition

`useParams` is a React Router hook used to retrieve parameters from the URL.

Example

```jsx
const { id } = useParams();
```

If the URL is

```text
/trainers/t-jojo
```

then

```text
id = "t-jojo"
```

The uploaded lab specifically instructs creating a `TrainerDetails` component that retrieves the trainer ID using `useParams`. 

---

# 5.13 Client-side Routing vs Server-side Routing

| Client-side Routing         | Server-side Routing                                      |
| --------------------------- | -------------------------------------------------------- |
| Navigation handled by React | Navigation handled by the server                         |
| No full page reload         | Entire page reloads                                      |
| Faster user experience      | Slower due to repeated page loads                        |
| Uses React Router           | Uses server technologies such as JSP, ASP.NET, PHP, etc. |

---

# 6. Project Overview

In this exercise, you build a **Trainers Management Application** that demonstrates the core concepts of React Router.

The application contains:

* A Home page.
* A Trainers List page.
* A Trainer Details page.
* Navigation links.
* Route configuration.
* URL parameter passing.
* Dynamic rendering of trainer details using mock data.

This structure follows the workflow described in the uploaded Cognizant hands-on lab. 

---

# 7. High-Level Architecture

```text
                    User Opens Browser
                            │
                            ▼
                    BrowserRouter
                            │
                            ▼
                      React Router
                            │
         ┌──────────────────┼──────────────────┐
         ▼                  ▼                  ▼
      Home Page       Trainers List     Trainer Details
                            │                  ▲
                            │                  │
                            ▼                  │
                  Click Trainer Name ──────────┘
                            │
                            ▼
                 URL Parameter (/trainers/:id)
                            │
                            ▼
                     useParams() Hook
                            │
                            ▼
                 Display Selected Trainer
```

---

# 8. Technologies Used

| Technology             | Purpose                                                    |
| ---------------------- | ---------------------------------------------------------- |
| **React**              | Builds reusable user interface components.                 |
| **React Router DOM**   | Provides client-side routing and navigation.               |
| **JavaScript (ES6)**   | Implements application logic and routing behavior.         |
| **JSX**                | Combines HTML-like syntax with JavaScript for UI creation. |
| **Node.js**            | JavaScript runtime used during development.                |
| **npm**                | Installs and manages project dependencies.                 |
| **Visual Studio Code** | Recommended IDE for developing the application.            |

---

# Exercise 6: React Router

## Week 5 – ReactJS Hands-on Lab

> **Response 2 of 4**

---

# Table of Contents

9. Project Structure

10. Folder Explanation

11. File-by-File Explanation

12. Configuration Explanation

13. Implementation Explanation

14. Internal Working

15. Routing Flow

16. Execution Flow

---

# 9. Project Structure

The uploaded hands-on lab instructs creating a React application named **TrainersApp**, adding trainer-related files, components, and configuring React Router. Based on those instructions, the project structure is as follows. 

```text
TrainersApp
│
├── node_modules
│
├── public
│   ├── favicon.ico
│   ├── index.html
│   ├── manifest.json
│   └── robots.txt
│
├── src
│   ├── Components
│   │     ├── Home.js
│   │     ├── TrainersList.js
│   │     └── TrainerDetails.js
│   │
│   ├── trainer.js
│   ├── TrainersMock.js
│   ├── App.js
│   ├── App.css
│   ├── index.js
│   ├── index.css
│   ├── reportWebVitals.js
│   └── setupTests.js
│
├── package.json
├── package-lock.json
└── README.md
```

---

# 10. Folder Explanation

---

# node_modules

## Purpose

This folder contains every package installed using npm.

Examples include:

* React
* React DOM
* React Router DOM
* Babel
* Webpack

These packages are automatically downloaded after running:

```bash
npm install
```

or

```bash
npm install react-router-dom
```

---

# public

The **public** folder contains static files served directly by the browser.

Typical contents:

```text
public
│
├── index.html
├── favicon.ico
├── manifest.json
└── robots.txt
```

---

## index.html

This file contains

```html
<div id="root"></div>
```

React renders the complete application inside this element.

---

# src

The **src** folder contains the application's source code.

```text
src
│
├── Components
├── trainer.js
├── TrainersMock.js
├── App.js
├── index.js
└── App.css
```

Everything related to the application's logic and UI is stored here.

---

# Components Folder

This folder stores reusable React components.

For this exercise:

```text
Components
│
├── Home.js
├── TrainersList.js
└── TrainerDetails.js
```

Each component has a single responsibility.

---

# trainer.js

Stores the **Trainer** model.

Instead of using plain JavaScript objects throughout the project, trainer information is organized using a dedicated class.

---

# TrainersMock.js

Stores mock trainer records.

Since this hands-on does not use a database, all trainer information is stored locally in this file. 

---

# App.js

Acts as the main component.

Responsibilities include:

* Displaying the navigation menu.
* Configuring React Router.
* Defining routes.
* Redirecting the default URL.
* Loading the appropriate page.

---

# index.js

Acts as the entry point of the application.

It renders

```text
<App />
```

inside

```text
<div id="root"></div>
```

---

# App.css

Contains global styling for the application such as:

* Navigation
* Headings
* Links
* Margins
* Font styles

---

# 11. File-by-File Explanation

---

# File 1 – trainer.js

## Purpose

Defines the **Trainer** class.

The uploaded lab specifies the following properties:

* TrainerId
* Name
* Email
* Phone
* Technology
* Skills 

---

## Responsibilities

```text
Trainer Object

↓

Stores Trainer Information

↓

Reusable Across Application
```

Example object

```text
Trainer

↓

Trainer ID

↓

Name

↓

Technology

↓

Skills
```

---

# File 2 – TrainersMock.js

## Purpose

Contains sample trainer data.

The application imports this file whenever trainer information is required.

---

## Responsibilities

```text
Store Trainer Data

↓

Export Trainer Array

↓

Used by Components
```

---

## Why use Mock Data?

During development:

* No database required.
* Faster testing.
* Easier debugging.
* Simulates real application data.

---

# File 3 – Home.js

## Purpose

Displays the welcome page.

Example flow

```text
Application Starts

↓

Home Page

↓

Welcome Message
```

The uploaded lab includes a Home component that displays a welcome message for the trainers page. 

---

# File 4 – TrainersList.js

This component displays every trainer.

---

## Responsibilities

```text
Import Trainer Data

↓

Loop Through Trainers

↓

Display Trainer Names

↓

Create Hyperlinks
```

---

## Why use map()?

Instead of writing

```jsx
<Link>Trainer 1</Link>

<Link>Trainer 2</Link>

<Link>Trainer 3</Link>
```

React automatically generates the list.

```text
Trainer Array

↓

map()

↓

Multiple Components
```

---

## Why use Link?

Each trainer name is clickable.

Example

```text
Syed Khaleelullah

↓

Click

↓

Trainer Details
```

The uploaded lab explicitly requires trainer names to be clickable hyperlinks. 

---

# File 5 – TrainerDetails.js

This component displays detailed information about one trainer.

---

## Responsibilities

```text
Read URL Parameter

↓

Find Trainer

↓

Display Details
```

---

## useParams()

The uploaded lab instructs using

```text
useParams()
```

to retrieve the trainer ID from the URL. 

Example

```text
/trainers/t-syed8

↓

id = t-syed8
```

---

## Finding Trainer

The component searches

```text
TrainersMock
```

using

```text
find()
```

Example

```text
Trainer Array

↓

Search ID

↓

Return Trainer

↓

Display Information
```

---

# File 6 – App.js

This is the heart of the application.

---

## Responsibilities

```text
Navigation Menu

↓

BrowserRouter

↓

Routes

↓

Route Definitions

↓

Redirect

↓

Render Components
```

---

### Navigation

Contains two links

```text
Home

Show Trainers
```

---

### Routes

```text
/

↓

Redirect

↓

/home
```

```text
/home

↓

Home Component
```

```text
/trainers

↓

Trainer List
```

```text
/trainers/:id

↓

Trainer Details
```

These routes match the URLs specified in the uploaded lab. 

---

# File 7 – index.js

Purpose

Application Entry Point.

Flow

```text
Browser

↓

index.js

↓

<App/>

↓

BrowserRouter

↓

Application
```

---

# 12. Configuration Explanation

---

# package.json

Contains

* Project information
* Installed packages
* Scripts
* React Router dependency

Important dependencies include

```text
react

react-dom

react-router-dom
```

---

# Scripts

```text
npm start

↓

Run Development Server
```

```text
npm run build

↓

Production Build
```

```text
npm test

↓

Execute Tests
```

---

# index.html

Contains

```html
<div id="root"></div>
```

React injects the application into this element.

---

# 13. Implementation Explanation

Implementation sequence

```text
Create React Project

↓

Install React Router

↓

Create Trainer Model

↓

Create Mock Data

↓

Create Home Component

↓

Create Trainers List

↓

Create Trainer Details

↓

Configure BrowserRouter

↓

Define Routes

↓

Run Application
```

This sequence reflects the order of tasks described in the uploaded hands-on lab. 

---

# 14. Internal Working

Step 1

```text
npm start
```

↓

React starts.

---

Step 2

```text
index.js
```

executes.

---

Step 3

```text
<App />
```

is rendered.

---

Step 4

`BrowserRouter` initializes routing.

---

Step 5

Navigation menu appears.

---

Step 6

Default route

```text
/
```

redirects to

```text
/home
```

---

Step 7

User clicks

```text
Show Trainers
```

---

Step 8

React renders

```text
TrainersList
```

---

Step 9

User clicks a trainer name.

---

Step 10

URL changes

```text
/trainers/t-syed8
```

---

Step 11

`useParams()` retrieves

```text
t-syed8
```

---

Step 12

Trainer is searched inside

```text
TrainersMock
```

---

Step 13

Trainer details are displayed.

---

# 15. Routing Flow

```text
User Opens Application

        │

        ▼

BrowserRouter

        │

        ▼

Home Page

        │

        ▼

Click Show Trainers

        │

        ▼

Trainer List

        │

        ▼

Click Trainer Name

        │

        ▼

URL Changes

        │

        ▼

useParams()

        │

        ▼

TrainerDetails Component

        │

        ▼

Display Trainer Information
```

---

# 16. Execution Flow

```text
npm start

↓

React Application Starts

↓

BrowserRouter Loads

↓

Navigation Menu Appears

↓

Home Page

↓

User Navigates

↓

Route Matches

↓

Component Renders

↓

Trainer Selected

↓

Trainer Details Displayed
```

---

# Exercise 6: React Router

## Week 5 – ReactJS Hands-on Lab

> **Response 3 of 4**

---

# Table of Contents

14. Sample Input and Output

15. How to Run the Project

16. Testing

17. Best Practices

18. Common Mistakes

19. Real-world Applications

20. Advantages

21. Limitations

---

# 14. Sample Input and Output

The uploaded hands-on lab provides sample trainer information and screenshots showing the expected navigation flow between the Home page, Trainers List, and Trainer Details page. The following examples reflect that workflow. 

---

# Sample Input

Example trainer data

```text
Trainer ID : t-syed8

Name : Syed Khaleelullah

Email : khaleelullah@cognizant.com

Phone : 97676516962

Technology : .NET

Skills :

• C#
• SQL Server
• React
• .NET Core
```

---

Another trainer

```text
Trainer ID : t-jojo

Name : Jojo Jose

Technology : Java

Skills :

• Java
• JSP
• Angular
• Spring
```

---

# Expected Home Page

```text
-------------------------------------

My Academy Trainers App

Home | Show Trainers

-------------------------------------

Welcome to My Academy trainers page
```

---

# Expected Trainers List

```text
-------------------------------------

Trainers List

-------------------------------------

Syed Khaleelullah

Jojo Jose

Elisa Jones
```

Each trainer name is displayed as a clickable hyperlink, as shown in the uploaded lab. 

---

# Expected Trainer Details

Click

```text
Syed Khaleelullah
```

Expected page

```text
---------------------------------------

Trainers Details

---------------------------------------

Syed Khaleelullah (.NET)

khaleelullah@cognizant.com

97676516962

Skills

• C#

• SQL Server

• React

• .NET Core
```

---

# URL Flow

```text
Home

↓

/home
```

```text
Trainer List

↓

/trainers
```

```text
Trainer Details

↓

/trainers/t-syed8
```

The uploaded exercise specifically demonstrates passing the trainer ID through the URL and retrieving it using `useParams()`. 

---

# Navigation Flow

```text
Application Starts

↓

Home

↓

Click Show Trainers

↓

Trainer List

↓

Click Trainer Name

↓

Trainer Details
```

---

# 15. How to Run the Project

---

## Step 1

Install Node.js

Verify

```bash
node -v
```

---

## Step 2

Verify npm

```bash
npm -v
```

---

## Step 3

Create Project

```bash
npx create-react-app TrainersApp
```

---

## Step 4

Move into Project

```bash
cd TrainersApp
```

---

## Step 5

Install React Router

```bash
npm install react-router-dom
```

This installation step is explicitly required in the uploaded lab. 

---

## Step 6

Open VS Code

```bash
code .
```

---

## Step 7

Create Required Files

```text
trainer.js

TrainersMock.js

Home.js

TrainersList.js

TrainerDetails.js
```

---

## Step 8

Configure Routing

Use

* BrowserRouter
* Routes
* Route
* Link
* Navigate

---

## Step 9

Run Application

```bash
npm start
```

---

## Step 10

Open Browser

```text
http://localhost:3000
```

Application automatically redirects

```text
/

↓

/home
```

---

## Production Build

```bash
npm run build
```

Creates

```text
build/
```

---

## Run Tests

```bash
npm test
```

---

## Stop Server

```text
Ctrl + C
```

---

# Important Commands

| Command                          | Purpose          |
| -------------------------------- | ---------------- |
| node -v                          | Check Node.js    |
| npm -v                           | Check npm        |
| npx create-react-app TrainersApp | Create Project   |
| npm install react-router-dom     | Install Router   |
| npm start                        | Run Application  |
| npm test                         | Execute Tests    |
| npm run build                    | Production Build |
| Ctrl + C                         | Stop Server      |

---

# 16. Testing

---

## Test 1

Application Starts

Expected

```text
Compiled Successfully
```

---

## Test 2

Home Page Loads

Expected

```text
Welcome to My Academy trainers page
```

---

## Test 3

Navigation Menu

Expected

```text
Home

Show Trainers
```

---

## Test 4

Click Home

Expected

```text
Home Component
```

is displayed.

---

## Test 5

Click Show Trainers

Expected

```text
Trainers List
```

appears.

---

## Test 6

Trainer Names

Expected

Every trainer appears as a clickable hyperlink.

---

## Test 7

Click Trainer

Expected

Trainer Details page opens.

---

## Test 8

Verify URL

Expected

```text
/trainers/t-syed8
```

---

## Test 9

Verify Details

Expected

Correct

* Name
* Email
* Phone
* Technology
* Skills

are displayed.

---

## Test 10

Invalid URL

Example

```text
/trainers/xyz
```

Expected

```text
Trainer Not Found
```

---

# Manual Testing Checklist

| Test                        | Status |
| --------------------------- | ------ |
| React Runs                  | ✅      |
| Home Page Opens             | ✅      |
| Navigation Menu Works       | ✅      |
| Home Route Works            | ✅      |
| Trainers Route Works        | ✅      |
| Trainer Details Route Works | ✅      |
| URL Parameter Works         | ✅      |
| useParams Works             | ✅      |
| Trainer Details Displayed   | ✅      |

These checks verify the navigation and routing behavior described in the uploaded hands-on lab. 

---

# 17. Best Practices

---

## Keep Components Small

Good

```text
Home

↓

One Responsibility
```

```text
TrainerList

↓

One Responsibility
```

---

## Store Data Separately

Instead of writing trainer data inside components,

store it inside

```text
TrainersMock.js
```

---

## Use Link Instead of Anchor Tag

Correct

```jsx
<Link to="/trainers">

Show Trainers

</Link>
```

Avoid

```html
<a href="/trainers">
```

because it refreshes the page.

---

## Use Route Parameters

Instead of creating

```text
Trainer1 Page

Trainer2 Page

Trainer3 Page
```

Use

```text
/trainers/:id
```

This is more scalable and reusable.

---

## Validate Parameters

Always check

```javascript
if(!trainer)
```

before displaying data.

---

## Keep Routing Inside App.js

A centralized routing configuration makes the application easier to understand and maintain.

---

# 18. Common Mistakes

---

## Mistake 1

Forgot

```jsx
<BrowserRouter>
```

Result

```text
Routing Doesn't Work
```

---

## Mistake 2

Imported

```javascript
Route
```

without

```javascript
Routes
```

Modern React Router requires routes to be wrapped inside `Routes`.

---

## Mistake 3

Using

```html
<a>
```

instead of

```jsx
<Link>
```

Causes full page refresh.

---

## Mistake 4

Incorrect Route Path

Wrong

```text
/trainer
```

Correct

```text
/trainers
```

---

## Mistake 5

Forgot

```javascript
useParams()
```

Result

Trainer ID cannot be retrieved.

---

## Mistake 6

Forgot

```jsx
Navigate
```

Default page will not redirect.

---

## Mistake 7

Wrong URL Parameter

Wrong

```text
/trainers/id
```

Correct

```text
/trainers/:id
```

---

## Mistake 8

No

```javascript
key
```

inside

```jsx
map()
```

React will display warnings.

---

# 19. Real-world Applications

React Router is widely used in modern web applications.

---

## Banking Portal

```text
Login

↓

Accounts

↓

Transactions

↓

Transfer Money
```

---

## E-Commerce

```text
Home

↓

Products

↓

Product Details

↓

Cart
```

---

## Hospital Management

```text
Patients

↓

Doctors

↓

Appointments

↓

Medical Records
```

---

## Learning Management System

```text
Dashboard

↓

Courses

↓

Assignments

↓

Results
```

---

## HR Portal

```text
Employees

↓

Departments

↓

Payroll

↓

Leave Management
```

---

## Student Management System

```text
Home

↓

Students

↓

Student Details
```

This exercise models a simplified version of such navigation using trainer data.

---

# 20. Advantages

| Advantage               | Explanation                                                  |
| ----------------------- | ------------------------------------------------------------ |
| Fast Navigation         | Components change without reloading the page.                |
| Better User Experience  | Smooth transitions between pages.                            |
| SPA Support             | Enables Single Page Applications.                            |
| URL Parameter Passing   | Makes dynamic pages possible.                                |
| Reusable Components     | One component can display many trainers using different IDs. |
| Browser History Support | Back and Forward buttons work naturally.                     |
| Easy Maintenance        | Routes are centrally managed.                                |

---

# 21. Limitations

---

## Mock Data Only

The exercise uses local mock data instead of a database. 

---

## No Backend

Trainer information is not retrieved from an API.

---

## No Authentication

Any user can access every page.

---

## No Database

Changes are not permanently stored.

---

## Basic Routing

The exercise introduces:

* Basic Routes
* Navigation
* URL Parameters

Advanced topics such as nested routes, protected routes, lazy loading, and route guards are beyond the scope of this lab.

---

# Exercise 6: React Router

## Week 5 – ReactJS Hands-on Lab

> **Response 4 of 4**

---

# Table of Contents

22. Frequently Asked Interview Questions

23. Quick Revision Notes

24. React Router Cheat Sheet

25. Important Commands Cheat Sheet

26. Important Files Summary

27. Complete Routing Workflow

28. Key Takeaways

29. Conclusion

30. Next Learning Path

---

# 22. Frequently Asked Interview Questions

---

## Q1. What is React Router?

**Answer:**

React Router is the official routing library for React that enables navigation between different components without refreshing the browser page.

---

## Q2. Why do we need React Router?

**Answer:**

React Router allows us to:

* Navigate between pages
* Build Single Page Applications
* Avoid page reloads
* Pass parameters through URLs
* Manage browser history

---

## Q3. What is a Single Page Application (SPA)?

**Answer:**

A Single Page Application loads one HTML page and dynamically updates only the required components without reloading the browser.

---

## Q4. What is BrowserRouter?

**Answer:**

`BrowserRouter` is the top-level router component that enables client-side routing using the browser's History API.

Example:

```jsx
<BrowserRouter>
    <App />
</BrowserRouter>
```

---

## Q5. What is Routes?

**Answer:**

`Routes` is a container that groups all `Route` components and renders the first matching route.

---

## Q6. What is Route?

**Answer:**

A `Route` maps a URL path to a React component.

Example:

```jsx
<Route path="/home" element={<Home />} />
```

---

## Q7. What is Link?

**Answer:**

`Link` creates navigation links without reloading the page.

Example:

```jsx
<Link to="/trainers">
    Show Trainers
</Link>
```

---

## Q8. Why use Link instead of `<a>`?

**Answer:**

`<a>` reloads the browser page.

`Link` performs client-side navigation, making the application faster and preserving state.

---

## Q9. What is Navigate?

**Answer:**

`Navigate` redirects users from one route to another.

Example:

```jsx
<Route
    path="/"
    element={<Navigate to="/home" replace />}
/>
```

The uploaded lab requires redirecting the root URL (`/`) to the Home component. 

---

## Q10. What is URL Parameter Passing?

**Answer:**

URL parameter passing allows values to be included in the URL.

Example:

```text
/trainers/t-syed8
```

where `t-syed8` is the parameter.

---

## Q11. What is useParams?

**Answer:**

`useParams()` retrieves parameters from the current URL.

Example:

```jsx
const { id } = useParams();
```

---

## Q12. What is Dynamic Routing?

**Answer:**

Dynamic routing uses variables in the URL instead of fixed paths.

Example:

```text
/trainers/:id
```

---

## Q13. Why do we use route parameters?

**Answer:**

Route parameters allow one component to display different data based on the URL.

---

## Q14. What is Mock Data?

**Answer:**

Mock data is sample data stored locally for development and testing without connecting to a database.

---

## Q15. Why is TrainersMock.js used?

**Answer:**

It stores trainer information so components can access it without using a backend service.

---

## Q16. What is trainer.js?

**Answer:**

It defines the `Trainer` class used to create trainer objects with consistent properties.

---

## Q17. Why use map() in TrainersList?

**Answer:**

`map()` generates one list item for every trainer in the array automatically.

---

## Q18. Why is key required in lists?

**Answer:**

`key` uniquely identifies each rendered item so React can efficiently update the UI.

---

## Q19. What does find() do?

**Answer:**

`find()` searches an array and returns the first matching element.

Example:

```javascript
trainersMock.find(
    trainer => trainer.trainerId === id
);
```

---

## Q20. What happens if an invalid trainer ID is entered?

**Answer:**

The application should display a message such as:

```text
Trainer Not Found
```

instead of crashing.

---

## Q21. Can BrowserRouter have multiple Routes?

**Answer:**

Yes. A single `BrowserRouter` can manage multiple routes.

---

## Q22. What is client-side routing?

**Answer:**

Client-side routing changes the displayed component without requesting a new HTML page from the server.

---

## Q23. What is server-side routing?

**Answer:**

Server-side routing requests a new page from the server for every navigation.

---

## Q24. Why is React Router faster?

**Answer:**

Because only the required React component changes instead of reloading the entire page.

---

## Q25. What is the benefit of SPA?

**Answer:**

* Faster navigation
* Better user experience
* Reduced server requests
* Smooth transitions

---

## 23. Quick Revision Notes

### React Router Components

```text
BrowserRouter

↓

Routes

↓

Route

↓

Link

↓

Navigate

↓

useParams
```

---

### Route Example

```jsx
<Route
    path="/trainers"
    element={<TrainersList />}
/>
```

---

### Dynamic Route

```jsx
<Route
    path="/trainers/:id"
    element={<TrainerDetails />}
/>
```

---

### Link Example

```jsx
<Link to="/home">
    Home
</Link>
```

---

### Redirect

```jsx
<Navigate to="/home" replace />
```

---

### URL Parameter

```text
/trainers/t-syed8
```

↓

```text
id = t-syed8
```

---

### useParams

```jsx
const { id } = useParams();
```

---

### Navigation Flow

```text
Home

↓

Trainer List

↓

Trainer Details
```

---

# 24. React Router Cheat Sheet

| Component     | Purpose                         |
| ------------- | ------------------------------- |
| BrowserRouter | Enables routing                 |
| Routes        | Holds all routes                |
| Route         | Maps URL to component           |
| Link          | Navigation without page refresh |
| Navigate      | Redirects users                 |
| useParams     | Reads URL parameters            |

---

### Basic Route

```jsx
<Route
    path="/home"
    element={<Home />}
/>
```

---

### Dynamic Route

```jsx
<Route
    path="/trainers/:id"
    element={<TrainerDetails />}
/>
```

---

### Redirect

```jsx
<Navigate
    to="/home"
    replace
/>
```

---

### Hyperlink

```jsx
<Link
    to="/trainers"
>
    Show Trainers
</Link>
```

---

# 25. Important Commands Cheat Sheet

| Command                            | Purpose                     |
| ---------------------------------- | --------------------------- |
| `node -v`                          | Check Node.js version       |
| `npm -v`                           | Check npm version           |
| `npx create-react-app TrainersApp` | Create React project        |
| `cd TrainersApp`                   | Enter project folder        |
| `npm install react-router-dom`     | Install React Router        |
| `code .`                           | Open VS Code                |
| `npm start`                        | Run development server      |
| `npm test`                         | Execute tests               |
| `npm run build`                    | Build production version    |
| `Ctrl + C`                         | Stop the development server |

---

# 26. Important Files Summary

| File                | Purpose                                                       |
| ------------------- | ------------------------------------------------------------- |
| `trainer.js`        | Defines the Trainer model.                                    |
| `TrainersMock.js`   | Stores mock trainer data.                                     |
| `Home.js`           | Displays the welcome page.                                    |
| `TrainersList.js`   | Displays clickable trainer names.                             |
| `TrainerDetails.js` | Displays details of the selected trainer using `useParams()`. |
| `App.js`            | Configures navigation and routing.                            |
| `App.css`           | Contains application styling.                                 |
| `index.js`          | Entry point that renders the application.                     |
| `package.json`      | Stores project configuration and dependencies.                |

---

# 27. Complete Routing Workflow

```text
Start React Application

        │

        ▼

BrowserRouter Initializes

        │

        ▼

Navigation Menu Displayed

        │

        ▼

Home Route Loaded

        │

        ▼

User Clicks "Show Trainers"

        │

        ▼

Trainers List Displayed

        │

        ▼

User Clicks Trainer Name

        │

        ▼

URL Changes to

/trainers/:id

        │

        ▼

useParams()

        │

        ▼

Find Trainer in TrainersMock

        │

        ▼

Display Trainer Details
```

This workflow matches the navigation sequence described in the uploaded React Router hands-on lab. 

---

# 28. Key Takeaways

After completing this exercise, you should understand:

* The purpose of React Router.
* The concept of Single Page Applications (SPA).
* How `BrowserRouter` enables routing.
* The role of `Routes` and `Route`.
* How `Link` provides client-side navigation.
* How `Navigate` performs redirection.
* How URL parameters work.
* How `useParams()` retrieves values from the URL.
* How to build a basic multi-page React application without page reloads.

---

# 29. Conclusion

This exercise introduces the fundamental concepts of **React Router**, which is the standard routing solution for React applications.

By implementing the **Trainers Management Application**, you learned how to:

* Create a Single Page Application.
* Configure client-side routing.
* Navigate between pages using `Link`.
* Redirect users using `Navigate`.
* Pass values through URL parameters.
* Retrieve URL parameters with `useParams`.
* Display dynamic content based on the selected trainer.

These concepts form the foundation for building scalable React applications with multiple pages and dynamic navigation. The implementation follows the objectives and workflow described in the uploaded Cognizant ReactJS Hands-on Lab. 

---

# Exercise 12: React Conditional Rendering

## Week 5 – ReactJS Hands-on Lab

> **Response 1 of 4**

---

# Table of Contents

1. Project Title

2. Introduction

3. Learning Objectives

4. Prerequisites

5. Background Concepts

- What is Rendering?
- What is Conditional Rendering?
- Why Conditional Rendering is Needed
- Element Variables
- Preventing Components from Rendering
- Conditional Rendering Techniques
- React State (`useState`)
- Props
- Component Communication
- Login and Logout Flow
- Project Overview
- High-Level Architecture
- Technologies Used

---

# 1. Project Title

# React Conditional Rendering

**Week 5 – ReactJS Hands-on Lab**

**Exercise 12 – React Conditional Rendering**

---

# 2. Introduction

## What is this project?

This hands-on exercise introduces **Conditional Rendering** in React.

According to the uploaded hands-on lab, you will create a React application named **ticketbookingapp** where:

- Guest users can browse flight details.
- Only logged-in users can book tickets.
- Initially, the Guest page is displayed.
- Clicking **Login** displays the User page.
- Clicking **Logout** returns to the Guest page.

The hands-on lab also suggests implementing separate **LoginButton**, **LogoutButton**, and **Greeting** components to control which page is displayed. :contentReference[oaicite:0]{index=0}

---

## What problem does this project solve?

Many applications display different content depending on who is using them.

For example,

A visitor to an airline website can:

- View available flights
- View ticket prices

But cannot:

- Book tickets
- Cancel reservations
- View booking history

Only authenticated users can perform those actions.

This is achieved using **Conditional Rendering**.

---

## Why is Conditional Rendering Important?

Suppose you build an Online Flight Booking System.

If the user is:

### Guest

Display

```text
Browse Flights

Login Button
```

If the user logs in

Display

```text
Welcome User

Book Ticket

Logout Button
```

Instead of creating two separate applications,

React decides which components should appear based on a condition.

---

## Real-world Applications

Conditional Rendering is used in almost every React application.

Examples include:

- Airline Booking Systems
- Banking Applications
- Student Portals
- Hospital Management Systems
- E-Commerce Websites
- Food Delivery Apps
- Hotel Booking Systems
- Employee Portals
- Online Examination Systems
- Social Media Platforms

---

## Why do we use Conditional Rendering?

Without Conditional Rendering,

every user would see the same page.

Example

```text
Guest

↓

Book Ticket

Delete Booking

Payment
```

This is incorrect.

Instead,

React displays only the appropriate components.

```text
Guest

↓

View Flights

Login
```

```text
Logged-in User

↓

Book Ticket

Logout
```

---

# 3. Learning Objectives

According to the uploaded hands-on lab, after completing this exercise you should be able to:

- Explain Conditional Rendering in React.
- Define Element Variables.
- Explain how to prevent components from rendering.
- Implement Conditional Rendering in React applications. :contentReference[oaicite:1]{index=1}

In this implementation, you will also learn:

- Using `useState()` for login status.
- Passing data using Props.
- Rendering components conditionally.
- Component communication.
- Login and Logout flow.
- Reusable React components.

---

# 4. Prerequisites

The uploaded hands-on lab specifies the following prerequisites:

| Software | Purpose |
|----------|----------|
| Node.js | JavaScript Runtime |
| npm | Package Manager |
| Visual Studio Code | Code Editor | :contentReference[oaicite:2]{index=2}

You should also know the basics of:

- HTML
- CSS
- JavaScript
- React Components
- JSX
- React Events

---

# 5. Background Concepts

---

# 5.1 What is Rendering?

## Definition

Rendering is the process of displaying components on the browser screen.

Whenever React executes a component,

it creates the user interface and displays it in the browser.

Example

```jsx
function App(){

    return <h1>Hello</h1>;

}
```

React renders

```text
Hello
```

on the webpage.

---

## Rendering Flow

```text
React Component

↓

JSX

↓

Virtual DOM

↓

Real DOM

↓

Browser Output
```

---

# 5.2 What is Conditional Rendering?

## Definition

Conditional Rendering means displaying different user interfaces depending on a condition.

Example

```text
If Condition is TRUE

↓

Display Component A

Else

↓

Display Component B
```

In this project,

the condition is

```text
isLoggedIn
```

If

```text
true
```

display

```text
User Page
```

Otherwise

display

```text
Guest Page
```

---

## Real-world Example

Consider a College Portal.

Students see

```text
View Marks

Attendance

Assignments
```

Faculty see

```text
Upload Marks

Manage Attendance

Create Assignments
```

Both users access the same application,

but React displays different pages based on the user's role.

---

# 5.3 Why is Conditional Rendering Needed?

Conditional Rendering allows applications to:

- Hide unnecessary information.
- Display user-specific pages.
- Improve security.
- Improve user experience.
- Reduce duplicate code.

Without Conditional Rendering,

every user would see every feature.

---

# 5.4 Element Variables

## Definition

An **Element Variable** stores a JSX element inside a variable.

Example

```jsx
let button;

if(isLoggedIn){

button = <LogoutButton />;

}
else{

button = <LoginButton />;

}
```

Instead of returning multiple JSX blocks,

React can store them inside variables and render them later.

The uploaded hands-on lab lists **Element Variables** as one of the concepts to understand. :contentReference[oaicite:3]{index=3}

---

# 5.5 Preventing Components from Rendering

Sometimes,

React should not display a component.

A component can return

```jsx
return null;
```

When

```text
null
```

is returned,

React renders nothing.

Example

```jsx
function Example(){

return null;

}
```

This technique is commonly used when a component should remain hidden until a specific condition becomes true.

The uploaded hands-on lab includes preventing components from rendering as one of its learning objectives. :contentReference[oaicite:4]{index=4}

---

# 5.6 Conditional Rendering Techniques

React provides several techniques for Conditional Rendering.

### 1. if...else

```jsx
if(isLoggedIn){

return <UserPage />;

}
else{

return <GuestPage />;

}
```

---

### 2. Ternary Operator

```jsx
isLoggedIn

?

<UserPage />

:

<GuestPage />
```

---

### 3. Logical AND (`&&`)

```jsx
isLoggedIn &&

<UserPage />
```

Displays the component only when the condition is true.

---

# 5.7 React State (`useState()`)

The login status changes during execution.

Initially,

```text
false
```

After Login,

```text
true
```

React stores this changing value using

```javascript
const [isLoggedIn, setIsLoggedIn] = useState(false);
```

Whenever the value changes,

React automatically updates the displayed page.

---

# 5.8 Props

Props allow one component to send information to another.

Example

```jsx
<Greeting

isLoggedIn={isLoggedIn}

/>
```

Here,

`App` sends the login status to the `Greeting` component.

---

# 5.9 Component Communication

The components communicate as follows:

```text
App

↓

Greeting

↓

GuestPage

OR

UserPage

↓

LoginButton

OR

LogoutButton
```

This creates a clear separation of responsibilities between components.

---

# 5.10 Login and Logout Flow

Initial State

```text
Application Starts

↓

isLoggedIn = false

↓

Guest Page

↓

Login Button
```

After Login

```text
Click Login

↓

isLoggedIn = true

↓

User Page

↓

Logout Button
```

After Logout

```text
Click Logout

↓

isLoggedIn = false

↓

Guest Page
```

---

# 6. Project Overview

The **Ticket Booking Application** demonstrates how React can display different pages based on the user's login status.

The application:

- Displays flight details.
- Shows Guest and User pages.
- Uses Login and Logout buttons.
- Uses React state for login management.
- Demonstrates Conditional Rendering using components.

---

# 7. High-Level Architecture

```text
                React Application
                       │
                       ▼
                    App.js
                       │
                       ▼
                 Greeting Component
                 ┌──────────────┐
                 │              │
        isLoggedIn = false   isLoggedIn = true
                 │              │
                 ▼              ▼
           GuestPage        UserPage
                 │              │
                 ▼              ▼
          LoginButton     LogoutButton
                 │              │
                 └──────┬───────┘
                        ▼
                Update Login State
                        │
                        ▼
                  Re-render UI
```

---

# 8. Technologies Used

| Technology | Purpose | Role in this Project |
|------------|---------|----------------------|
| **React** | JavaScript library | Builds reusable UI components |
| **JSX** | Syntax extension | Creates UI using HTML-like syntax |
| **JavaScript (ES6)** | Programming language | Implements login logic and conditional rendering |
| **React Hooks (`useState`)** | State management | Stores login status |
| **Props** | Component communication | Passes data between components |
| **Node.js** | JavaScript runtime | Runs the React application |
| **npm** | Package manager | Installs project dependencies |
| **Visual Studio Code** | Code editor | Used to develop the project |
| **CSS** | Styling | Styles the application interface |

---

# Exercise 12: React Conditional Rendering

## Week 5 – ReactJS Hands-on Lab

> **Response 2 of 4**

---

# 9. Project Structure

The application is organized into reusable React components. Each component is responsible for a specific part of the user interface, making the code modular and easy to maintain.

```text
ticketbookingapp
│
├── node_modules
│
├── public
│
├── src
│   │
│   ├── components
│   │      │
│   │      ├── LoginButton.js
│   │      ├── LogoutButton.js
│   │      ├── Greeting.js
│   │      ├── GuestPage.js
│   │      ├── UserPage.js
│   │      └── FlightDetails.js
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

Contains all third-party libraries installed using npm.

Examples:

- React
- React DOM
- Babel
- Webpack

This folder is automatically created after running:

```bash
npm install
```

---

## public

Contains static files used by the application.

Examples:

- index.html
- favicon
- images

React injects the application into **index.html**.

---

## src

The **src** folder contains the entire React application source code.

It includes:

- Components
- CSS files
- Entry point
- Main application component

---

## components

The **components** folder stores all reusable React components.

Each component has a single responsibility.

Benefits include:

- Better code organization
- Reusability
- Easier maintenance
- Independent testing

---

# 11. File-by-File Explanation

---

# App.js

## Purpose

`App.js` is the root component of the application.

It controls the login status and passes it to child components.

---

## Responsibilities

- Creates application state.
- Stores login status.
- Handles Login event.
- Handles Logout event.
- Passes data through Props.
- Renders Greeting component.

---

## State Used

```javascript
const [isLoggedIn, setIsLoggedIn] = useState(false);
```

Initially,

```text
false
```

means

Guest User.

After Login,

```text
true
```

means

Logged-in User.

---

## Login Function

```javascript
function handleLogin(){

setIsLoggedIn(true);

}
```

Updates login status.

---

## Logout Function

```javascript
function handleLogout(){

setIsLoggedIn(false);

}
```

Returns user to Guest mode.

---

## Rendering

```jsx
<Greeting

isLoggedIn={isLoggedIn}

onLogin={handleLogin}

onLogout={handleLogout}

/>
```

App sends data to Greeting through Props.

---

# Greeting.js

## Purpose

Greeting decides which page should be displayed.

This is the heart of Conditional Rendering.

---

## Logic

```text
isLoggedIn ?

↓

YES

↓

User Page

+

Logout Button

----------------

NO

↓

Guest Page

+

Login Button
```

Instead of creating two separate applications,

React displays different components depending on the login state.

This follows the flow described in the uploaded hands-on lab, where Login and Logout determine whether the Guest or User page is displayed. :contentReference[oaicite:0]{index=0}

---

# LoginButton.js

## Purpose

Displays the Login button.

```jsx
<button>

Login

</button>
```

When clicked,

it executes

```javascript
props.onClick()
```

received from App.

Flow

```text
Click Login

↓

handleLogin()

↓

setIsLoggedIn(true)

↓

React Re-renders

↓

User Page
```

---

# LogoutButton.js

## Purpose

Displays Logout button.

```jsx
<button>

Logout

</button>
```

Clicking it executes

```javascript
props.onClick()
```

Flow

```text
Click Logout

↓

handleLogout()

↓

setIsLoggedIn(false)

↓

Guest Page
```

---

# GuestPage.js

## Purpose

Displays information for visitors.

Guest users can:

- View flights
- Read flight information

Guest users cannot:

- Book tickets

Example Screen

```text
Please Sign Up

Flight Details

Login
```

This behavior matches the uploaded exercise, where Guest users are limited to browsing flight details. :contentReference[oaicite:1]{index=1}

---

# UserPage.js

## Purpose

Displays information for logged-in users.

User sees

```text
Welcome Back

Book Your Ticket

Flight Details

Book Ticket

Logout
```

Unlike Guest users,

logged-in users have access to booking functionality, satisfying the requirement that only logged-in users can book tickets. :contentReference[oaicite:2]{index=2}

---

## Book Ticket Button

The sample implementation includes a **Book Ticket** button to demonstrate that booking is available only after login.

Example

```jsx
<button>

Book Ticket

</button>
```

Optionally,

an event handler can be attached.

```javascript
function bookTicket(){

alert("Ticket Booked Successfully!");

}
```

---

# FlightDetails.js

## Purpose

Displays available flight information.

Example

| Flight | Source | Destination | Fare |
|---------|--------|-------------|------|
| AI202 | Hyderabad | Delhi | ₹6500 |
| 6E315 | Chennai | Mumbai | ₹5200 |
| UK808 | Bangalore | Kolkata | ₹7100 |

This component is shared by both GuestPage and UserPage.

Benefits:

- Reusable
- Easy to update
- Avoids duplicate code

---

# App.css

## Purpose

Provides styling for:

- Buttons
- Headings
- Tables
- Overall layout

Example

```css
button{

padding:8px 18px;

cursor:pointer;

}
```

CSS separates presentation from application logic.

---

# index.js

## Purpose

Entry point of the React application.

Creates the React root.

```javascript
ReactDOM.createRoot()
```

Renders

```jsx
<App />
```

inside

```text
index.html
```

---

# index.css

## Purpose

Provides global styles.

Example

```css
body{

margin:0;

padding:20px;

}
```

These styles affect the complete application.

---

# 12. Configuration Explanation

The application is created using Create React App.

Create project

```bash
npx create-react-app ticketbookingapp
```

Navigate

```bash
cd ticketbookingapp
```

Run

```bash
npm start
```

Open

```text
http://localhost:3000
```

The development server automatically recompiles the project whenever changes are saved.

---

# 13. Implementation Explanation

The application works by storing the user's login status in React state.

Step 1

Application starts.

```text
isLoggedIn = false
```

↓

Guest Page

---

Step 2

User clicks Login.

↓

Login function executes.

↓

```text
setIsLoggedIn(true)
```

↓

React updates the state.

↓

User Page appears.

---

Step 3

User clicks Logout.

↓

Logout function executes.

↓

```text
setIsLoggedIn(false)
```

↓

Guest Page appears again.

---

# 14. Code Flow

```text
Application Starts

↓

App Component

↓

Creates State

↓

Greeting Component

↓

Checks Login Status

↓

TRUE ?

───────────────┐

YES            NO

│              │

▼              ▼

UserPage   GuestPage

│              │

Logout      Login

│              │

└───────┬──────┘

        ▼

State Updated

↓

React Re-renders
```

---

# 15. Execution Flow

```text
User Opens Website

↓

Guest Page

↓

Login Button

↓

Login Clicked

↓

State Changes

↓

Greeting Re-executes

↓

User Page

↓

Logout Button

↓

Logout Clicked

↓

Guest Page Again
```

---

# 16. Internal Working

The application's internal workflow can be summarized as follows:

```text
Browser

↓

App.js

↓

useState()

↓

isLoggedIn

↓

Greeting Component

↓

Condition Checked

↓

GuestPage

OR

UserPage

↓

User Interaction

↓

State Changes

↓

React Virtual DOM

↓

Real DOM Updated
```

React does **not** reload the entire webpage.

Instead, it compares the updated Virtual DOM with the previous one and updates only the changed portions of the UI, making the application fast and efficient.

---

# 17. Conditional Rendering in this Project

This project demonstrates Conditional Rendering using the login state.

The condition is:

```javascript
isLoggedIn
```

If the value is:

```text
false
```

React displays:

- GuestPage
- LoginButton

If the value becomes:

```text
true
```

React displays:

- UserPage
- LogoutButton

This allows a single application to provide different user experiences without navigating to different pages, which is the primary objective of the uploaded hands-on exercise. :contentReference[oaicite:3]{index=3}

---

# Exercise 12: React Conditional Rendering

## Week 5 – ReactJS Hands-on Lab

> **Response 3 of 4**

---

# 18. Conditional Rendering Concepts Explained

To understand this project completely, it is important to understand the concepts behind **Conditional Rendering**.

The uploaded hands-on lab focuses on three major topics:

- Conditional Rendering
- Element Variables
- Preventing Components from Rendering :contentReference[oaicite:0]{index=0}

---

# 18.1 Rendering in React

## Definition

Rendering is the process of displaying a React component on the browser.

Whenever a component returns JSX,

React converts it into HTML and displays it.

Example

```jsx
function Welcome(){

    return <h1>Welcome</h1>;

}
```

Browser Output

```text
Welcome
```

Rendering occurs whenever:

- The application starts.
- State changes.
- Props change.
- Parent component re-renders.

---

## Rendering Process

```text
React Component

↓

Returns JSX

↓

Virtual DOM

↓

Compare Changes

↓

Update Real DOM

↓

Display Output
```

---

# 18.2 What is Conditional Rendering?

## Definition

Conditional Rendering means displaying different UI components depending on a condition.

Instead of always displaying the same page,

React checks a condition first.

Example

```text
Condition

↓

True ?

↓

YES

↓

Display Component A

NO

↓

Display Component B
```

In this project,

the condition is

```javascript
isLoggedIn
```

If

```text
true
```

React displays

```text
User Page
```

Otherwise,

React displays

```text
Guest Page
```

---

## Real-life Example

Imagine a Hospital Management System.

### Visitor

```text
View Doctors

Contact Hospital
```

### Doctor

```text
View Patients

Update Reports

Prescribe Medicines
```

Both use the same application,

but React displays different screens.

This is Conditional Rendering.

---

# 18.3 Element Variables

The uploaded hands-on lab introduces **Element Variables** as one of the concepts to learn. :contentReference[oaicite:1]{index=1}

## Definition

An Element Variable stores a JSX element inside a JavaScript variable.

Example

```jsx
let button;

if(isLoggedIn){

    button = <LogoutButton />;

}
else{

    button = <LoginButton />;

}

return(

<div>

{button}

</div>

);
```

Instead of writing multiple return statements,

React stores the component inside a variable.

---

## Advantages

- Cleaner code
- Easier maintenance
- Avoids duplicate JSX
- Easy to switch components

---

# 18.4 Preventing Components from Rendering

Sometimes,

a component should not appear.

React allows us to return

```jsx
return null;
```

Example

```jsx
function Welcome(props){

if(!props.show){

return null;

}

return <h1>Welcome</h1>;

}
```

If

```text
show = false
```

Nothing appears on the screen.

---

## Why is this useful?

Examples

- Hide Admin Panel
- Hide Login Button
- Hide Notifications
- Hide Error Messages
- Hide Premium Features

Instead of deleting components,

React simply does not render them.

---

# 18.5 Conditional Rendering using if...else

This is the most common approach.

Example

```jsx
if(isLoggedIn){

return <UserPage />;

}
else{

return <GuestPage />;

}
```

Flow

```text
Check Condition

↓

True ?

↓

YES

↓

UserPage

NO

↓

GuestPage
```

This is the technique used in the sample implementation.

---

# 18.6 Conditional Rendering using Ternary Operator

Syntax

```jsx
condition

?

<ComponentA />

:

<ComponentB />
```

Example

```jsx
return(

isLoggedIn

?

<UserPage />

:

<GuestPage />

);
```

Advantages

- Short code
- Easy to read
- Good for simple conditions

---

# 18.7 Conditional Rendering using Logical AND (&&)

Syntax

```jsx
condition && <Component />
```

Example

```jsx
isLoggedIn &&

<UserPage />
```

Meaning

If

```text
isLoggedIn = true
```

Display UserPage.

Otherwise,

display nothing.

---

# 18.8 State-based Rendering

This project uses React State.

```javascript
const [isLoggedIn, setIsLoggedIn] = useState(false);
```

Initially

```text
false
```

↓

Guest Page

After Login

```text
true
```

↓

User Page

Whenever state changes,

React automatically renders the correct page.

---

# 18.9 Props-based Rendering

State belongs to

```text
App.js
```

Greeting receives it using Props.

Example

```jsx
<Greeting

isLoggedIn={isLoggedIn}

/>
```

Flow

```text
App

↓

Props

↓

Greeting

↓

UserPage

OR

GuestPage
```

Props help components communicate with each other.

---

# 18.10 Component Re-rendering

React automatically re-renders whenever:

- State changes
- Props change

Example

```text
Application Starts

↓

Guest Page

↓

Login Button

↓

Click Login

↓

State Updated

↓

Greeting Re-renders

↓

User Page
```

No manual page refresh is required.

---

# 19. Sample Input and Output

### Initial Screen

```text
Please Sign Up

Flight Details

---------------------------------------

Flight      Source      Destination

AI202       Hyderabad   Delhi

6E315       Chennai     Mumbai

UK808       Bangalore   Kolkata

---------------------------------------

Login
```

---

### After Clicking Login

```text
Welcome Back

Book Your Ticket

---------------------------------------

Flight      Source      Destination

AI202       Hyderabad   Delhi

6E315       Chennai     Mumbai

UK808       Bangalore   Kolkata

---------------------------------------

Book Ticket

Logout
```

---

### After Clicking Book Ticket
*(If you added the optional event handler)*

```text
Ticket Booked Successfully!
```

---

### After Clicking Logout

```text
Please Sign Up

Flight Details

Login
```

---

# 20. How to Run the Project

Create the project

```bash
npx create-react-app ticketbookingapp
```

Move into the project

```bash
cd ticketbookingapp
```

Install dependencies

```bash
npm install
```

Start the development server

```bash
npm start
```

Open

```text
http://localhost:3000
```

The browser automatically displays the application.

---

# 21. Testing

After running the project, verify the following:

| Test Case | Expected Result |
|-----------|-----------------|
| Application starts | Guest Page is displayed |
| Flight Details | Visible to Guest |
| Login button | Visible on Guest Page |
| Click Login | User Page is displayed |
| Flight Details | Visible on User Page |
| Book Ticket button | Visible only after Login |
| Click Book Ticket *(optional implementation)* | Confirmation alert appears |
| Logout button | Visible only after Login |
| Click Logout | Guest Page appears again |

---

# 22. Best Practices

Follow these practices while implementing Conditional Rendering:

- Keep components small and reusable.
- Store UI-changing values in state.
- Pass data using Props.
- Use descriptive component names.
- Avoid duplicate JSX.
- Use `if...else` for complex conditions.
- Use the ternary operator for simple conditions.
- Return `null` when a component should not render.
- Keep styling separate in CSS files.

---

# 23. Common Mistakes

Avoid the following mistakes:

### Forgetting to update state

```javascript
isLoggedIn = true;
```

Incorrect.

Always use

```javascript
setIsLoggedIn(true);
```

---

### Forgetting Props

Incorrect

```jsx
<Greeting />
```

Correct

```jsx
<Greeting

isLoggedIn={isLoggedIn}

/>
```

---

### Writing multiple return statements incorrectly

Instead,

use Conditional Rendering.

---

### Placing logic inside JSX unnecessarily

Move complex logic into variables or functions before the `return` statement.

---

# 24. Real-world Applications

Conditional Rendering is widely used in modern React applications.

Examples include:

- Airline Ticket Booking Systems
- Online Banking
- Hospital Management Systems
- Student Information Systems
- Learning Management Systems
- Employee Portals
- E-Commerce Websites
- Hotel Reservation Systems
- Food Delivery Platforms
- Social Media Applications

---

# 25. Advantages

Using Conditional Rendering provides several benefits:

- Improves user experience.
- Displays relevant information only.
- Reduces duplicate code.
- Makes components reusable.
- Simplifies application maintenance.
- Supports role-based interfaces.
- Enables dynamic user interfaces.

---

# 26. Limitations

Although powerful, Conditional Rendering should be used carefully.

Some limitations include:

- Complex conditions can reduce readability.
- Deeply nested conditions make debugging harder.
- Excessive conditional logic inside JSX can make components difficult to maintain.
- Poor state management may lead to unexpected UI updates.

---

# Exercise 12: React Conditional Rendering

## Week 5 – ReactJS Hands-on Lab

> **Response 4 of 4**

---

# 27. Frequently Asked Interview Questions

## 1. What is Rendering in React?

Rendering is the process of displaying React components on the browser.

---

## 2. What is Conditional Rendering?

Conditional Rendering is the technique of displaying different UI elements based on a condition.

---

## 3. Why do we need Conditional Rendering?

It allows applications to display different interfaces for different situations, such as logged-in users and guest users.

---

## 4. Which hook is used in this project?

`useState()` is used to store the login status.

---

## 5. What is State?

State is data managed by a component that can change during the application's execution.

---

## 6. What is Props?

Props are read-only values used to pass data from one component to another.

---

## 7. Which component stores the login state?

`App.js`

---

## 8. Which component decides which page should be displayed?

`Greeting.js`

---

## 9. Which component is displayed initially?

`GuestPage`

---

## 10. Which component is displayed after Login?

`UserPage`

---

## 11. What value represents a logged-in user?

```text
true
```

---

## 12. What value represents a guest user?

```text
false
```

---

## 13. Which React Hook was used?

```javascript
useState()
```

---

## 14. What does `setIsLoggedIn(true)` do?

It updates the login state and causes React to re-render the UI to show the User page.

---

## 15. What happens when Logout is clicked?

The login state becomes `false`, and React displays the Guest page again.

---

## 16. What are Element Variables?

Element Variables store JSX elements inside JavaScript variables before rendering them.

---

## 17. What is the purpose of returning `null`?

Returning `null` prevents a component from rendering anything.

---

## 18. Name three Conditional Rendering techniques.

- `if...else`
- Ternary Operator (`? :`)
- Logical AND (`&&`)

---

## 19. What is the Virtual DOM?

The Virtual DOM is React's in-memory representation of the Real DOM used to efficiently update the user interface.

---

## 20. Does React reload the entire page when state changes?

No. React updates only the affected parts of the UI.

---

## 21. Why are components reusable?

A component can be used multiple times in different parts of an application without rewriting its code.

---

## 22. Why is `FlightDetails` a separate component?

To avoid duplicate code and improve reusability.

---

## 23. What is component communication?

It is the process of passing data between components using Props.

---

## 24. What is JSX?

JSX is a syntax extension that allows developers to write HTML-like code inside JavaScript.

---

## 25. Why is `useState()` important?

It allows React components to store dynamic values and update the UI automatically when those values change.

---

## 26. What is the difference between State and Props?

| State | Props |
|-------|-------|
| Managed by the component | Passed from parent component |
| Can change | Read-only |
| Uses `useState()` | Passed as attributes |

---

## 27. Can multiple components use the same state?

No. State belongs to the component where it is created. It can be shared with child components using Props.

---

## 28. What is re-rendering?

Re-rendering is the process of updating the UI after State or Props change.

---

## 29. Why is Conditional Rendering commonly used?

To display different content based on user actions, roles, or application state.

---

## 30. What is the role of `App.js`?

It is the root component that stores the login state and controls the application's overall behavior.

---

## 31. Why is `Greeting.js` important?

It checks the login status and decides whether to display the Guest page or the User page.

---

## 32. What is the advantage of splitting the application into components?

It improves code organization, reusability, readability, and maintainability.

---

## 33. How does React know when to update the UI?

React monitors changes in State and Props. When they change, React automatically re-renders the affected components.

---

## 34. What happens when the Login button is clicked?

The `handleLogin()` function updates `isLoggedIn` to `true`, causing the User page to be displayed.

---

## 35. Give one real-world use case of Conditional Rendering.

Displaying different dashboards for an Administrator, Faculty member, and Student in a College Management System.

---

# 28. Quick Revision

## Project Objective

Build a **Ticket Booking Application** that demonstrates **Conditional Rendering** by displaying different pages for Guest users and Logged-in users. :contentReference[oaicite:0]{index=0}

---

## Important Concepts

- Rendering
- Conditional Rendering
- Element Variables
- Preventing Components from Rendering
- React Components
- JSX
- State (`useState`)
- Props
- Re-rendering
- Component Communication

---

## Important Files

```text
App.js
Greeting.js
LoginButton.js
LogoutButton.js
GuestPage.js
UserPage.js
FlightDetails.js
App.css
index.js
index.css
```

---

## Important Commands

### Create Project

```bash
npx create-react-app ticketbookingapp
```

---

### Move to Project

```bash
cd ticketbookingapp
```

---

### Install Dependencies

```bash
npm install
```

---

### Start Development Server

```bash
npm start
```

---

### Build for Production

```bash
npm run build
```

---

# 29. Conditional Rendering Cheat Sheet

## if...else

```jsx
if(isLoggedIn){

return <UserPage />;

}
else{

return <GuestPage />;

}
```

---

## Ternary Operator

```jsx
isLoggedIn

?

<UserPage />

:

<GuestPage />
```

---

## Logical AND (`&&`)

```jsx
isLoggedIn &&

<UserPage />
```

---

## Return `null`

```jsx
if(!show){

return null;

}
```

---

## React State

```javascript
const [isLoggedIn, setIsLoggedIn] = useState(false);
```

---

## Passing Props

```jsx
<Greeting

isLoggedIn={isLoggedIn}

onLogin={handleLogin}

onLogout={handleLogout}

/>
```

---

# 30. Project Workflow

```text
Start Application

        │
        ▼

App Component

        │
        ▼

Create Login State

        │
        ▼

Greeting Component

        │
        ▼

Check isLoggedIn

        │
 ┌──────┴──────┐
 │             │
 ▼             ▼

GuestPage   UserPage

 │             │

 ▼             ▼

Login      Book Ticket

 │             │

 ▼             ▼

handleLogin()  Logout

        │
        ▼

Update State

        │
        ▼

React Re-renders

        │
        ▼

Updated User Interface
```

---

# 31. Key Takeaways

After completing this exercise, you should understand:

- How React renders components.
- What Conditional Rendering is.
- How State controls the user interface.
- How Props transfer data between components.
- How React automatically updates the UI.
- How reusable components simplify application development.
- Why Conditional Rendering is essential for role-based applications.

---

# 32. Conclusion

This exercise introduced one of the most important concepts in React: **Conditional Rendering**.

Using a simple Ticket Booking Application, you learned how React can display different interfaces depending on whether a user is logged in or not. The project demonstrated how `useState()` manages application state, how Props enable communication between components, and how reusable components make applications easier to maintain.

The uploaded hands-on lab specifically focused on understanding Conditional Rendering, Element Variables, and preventing components from rendering, all of which were implemented through the Guest and User page workflow. :contentReference[oaicite:1]{index=1}

---

# 33. Next Learning Path

After mastering Conditional Rendering, you should continue with:

1. Lists and Keys
2. Forms in React
3. Controlled Components
4. Uncontrolled Components
5. Lifting State Up
6. React Router
7. React Hooks (`useEffect`, `useContext`, `useReducer`)
8. REST API Integration
9. Context API
10. Redux (Advanced State Management)

Learning these topics will help you build larger, real-world React applications with dynamic user interfaces and efficient state management.

---

## End of README

This completes the documentation for **Exercise 12 – React Conditional Rendering**. The README is designed to complement the uploaded hands-on lab by explaining the required concepts, project structure, implementation, and practical usage in a clear, beginner-friendly manner while remaining aligned with the exercise objectives. :contentReference[oaicite:2]{index=2}

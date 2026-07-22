# Exercise 8: React State

## Week 5 – ReactJS Hands-on Lab

> **Response 1 of 4**

---

# Table of Contents

1. Project Title

2. Introduction

3. Learning Objectives

4. Prerequisites

5. Background Concepts

* What is React State?
* Why State is Needed
* Features of React State
* State vs Props
* Constructor in React Class Components
* What is `setState()`?
* Why `setState()` is Needed
* Component Re-rendering
* Event Handling in React
* Project Overview
* High-Level Architecture
* Technologies Used

---

# 1. Project Title

# React State – Counter Application

**Week 5 – ReactJS Hands-on Lab**

**Exercise 8 – React State**

---

# 2. Introduction

## What is this project?

This hands-on exercise introduces one of the most important concepts in React: **State**.

According to the uploaded hands-on lab, you will create a React application named **counterapp** with a class component called **CountPeople**. The component maintains two counters:

* **Entry Count**
* **Exit Count**

using a **constructor** and **state**. Two buttons (**Login** and **Exit**) update these counters using the `setState()` method. 

---

## What problem does it solve?

Many applications need to display information that changes while the application is running.

Examples include:

* Number of users online
* Shopping cart item count
* Notification count
* Likes on a post
* Visitors entering and leaving a building

If we use normal JavaScript variables, React will not automatically update the user interface when their values change.

React **State** solves this problem by storing dynamic data and automatically updating the UI whenever the state changes.

---

## Why is React State important?

Without State, React components could only display static information.

State enables applications to:

* Display changing data.
* Respond to user interactions.
* Update the UI automatically.
* Build interactive applications.

Nearly every real-world React application relies on State.

---

## Real-world Example

Imagine a shopping cart.

Initially,

```text
Cart Items = 0
```

User adds one item.

```text
Cart Items = 1
```

User adds another item.

```text
Cart Items = 2
```

The number displayed on the screen changes instantly.

This changing value is stored using **React State**.

The same concept is used in this exercise where the number of people entering and exiting the mall changes dynamically.

---

## Where is React State Used?

React State is used in almost every interactive React application.

Examples include:

* Shopping Cart Counters
* Login Forms
* Like Buttons
* Notification Badges
* Attendance Systems
* Banking Dashboards
* Student Portals
* Hospital Management Systems
* Live Scoreboards
* Dashboard Analytics

---

# 3. Learning Objectives

According to the uploaded hands-on lab, after completing this exercise you should be able to:

* Explain React State.
* Use the React State object. 

In this implementation, you will also learn how to:

* Create state using a constructor.
* Update state using `setState()`.
* Handle button click events.
* Automatically re-render components after state updates.

These additional concepts are directly involved in implementing the exercise described in the lab. 

---

# 4. Prerequisites

The uploaded lab specifies the following prerequisites:

| Software           | Purpose            |   |
| ------------------ | ------------------ | - |
| Node.js            | JavaScript Runtime |   |
| npm                | Package Manager    |   |
| Visual Studio Code | Code Editor        |   |

Additionally, you should have a basic understanding of:

* JavaScript
* React Components
* JSX

---

# 5. Background Concepts

---

# 5.1 What is React State?

## Definition

**State** is a built-in React object used to store data that can change over time.

Whenever the state changes, React automatically updates the user interface.

Think of State as the **memory of a component**.

---

## Example

Suppose we have a counter.

Initially,

```text
Count = 0
```

User clicks a button.

```text
Count = 1
```

Clicks again.

```text
Count = 2
```

Since the value changes while the application is running, it should be stored in **State**.

---

## Characteristics of State

* Stores dynamic data.
* Can change during execution.
* Private to the component.
* Triggers UI updates.
* Managed by the component itself.

---

# 5.2 Why State is Needed?

Consider the following example.

Without State:

```javascript
let count = 0;

count++;
```

The value changes internally, but React does **not** automatically update the UI.

With State:

```javascript
this.setState({
    count: this.state.count + 1
});
```

React updates both:

* The stored value.
* The user interface.

---

## In This Project

```text
Login Button

↓

Increase Entry Count

↓

State Updated

↓

Screen Updates
```

Similarly,

```text
Exit Button

↓

Increase Exit Count

↓

State Updated

↓

Screen Updates
```

This is the core functionality required by the uploaded hands-on lab. 

---

# 5.3 Features of React State

React State provides several important features:

* Stores dynamic data.
* Automatically updates the UI.
* Component-specific.
* Easy to modify using `setState()`.
* Supports interactive applications.
* Improves user experience.

---

# 5.4 State vs Props

| State                                   | Props                                       |
| --------------------------------------- | ------------------------------------------- |
| Managed by the component itself         | Passed from a parent component              |
| Mutable (can change using `setState()`) | Read-only (cannot be modified by the child) |
| Used for dynamic data                   | Used to pass data between components        |
| Private to the component                | Controlled by the parent component          |
| Triggers re-render when updated         | Re-renders when new props are received      |

---

# 5.5 Constructor in React Class Components

## Definition

A **constructor** is a special method that is automatically executed when a class component is created.

It is commonly used to:

* Initialize State.
* Bind methods (if required).

Example

```jsx
constructor() {
    super();

    this.state = {
        entrycount: 0,
        exitcount: 0
    };
}
```

The uploaded lab specifically instructs using a **constructor** and **state** to store `entrycount` and `exitcount`. 

---

# 5.6 What is `setState()`?

## Definition

`setState()` is the method used to update the component's state.

Whenever `setState()` is called:

1. State changes.
2. React detects the change.
3. The component re-renders.
4. The updated values appear on the screen.

Example

```jsx
this.setState({
    count: this.state.count + 1
});
```

---

## Why use `setState()` instead of direct assignment?

Incorrect

```javascript
this.state.count++;
```

React does not know that the value has changed, so the UI may not update correctly.

Correct

```javascript
this.setState({
    count: this.state.count + 1
});
```

React is notified of the change and updates the UI.

---

# 5.7 Why is `setState()` Needed?

Suppose the initial value is:

```text
Entry Count = 0
```

User clicks **Login**.

Using `setState()`:

```text
0

↓

1

↓

2

↓

3
```

Each click updates both the stored value and the displayed count.

---

# 5.8 Component Re-rendering

Whenever State changes, React automatically calls the component's `render()` method again.

Flow

```text
State Changes

↓

React Detects Change

↓

render()

↓

Updated UI
```

This automatic update mechanism is one of the key advantages of using React State.

---

# 5.9 Event Handling in React

React responds to user actions through **event handlers**.

Examples include:

* Button clicks
* Mouse movements
* Keyboard input
* Form submissions

In this exercise:

```text
Login Button

↓

updateEntry()

↓

setState()
```

and

```text
Exit Button

↓

updateExit()

↓

setState()
```

The uploaded lab requires implementing these two methods to update the counters when the corresponding buttons are clicked. 

---

# 6. Project Overview

This project demonstrates how to use **React State** by building a simple counter application.

The application:

* Initializes two counters.
* Displays the counters.
* Increments the entry count when the **Login** button is clicked.
* Increments the exit count when the **Exit** button is clicked.
* Automatically updates the UI using `setState()`.

This workflow matches the implementation described in the uploaded hands-on lab. 

---

# 7. High-Level Architecture

```text
                 React Application
                        │
                        ▼
                     App.js
                        │
                        ▼
                CountPeople Component
                        │
          ┌─────────────┴─────────────┐
          ▼                           ▼
     Constructor                 State Object
          │                           │
          ▼                           ▼
 entrycount = 0              exitcount = 0
          │                           │
          └─────────────┬─────────────┘
                        ▼
                  Button Click Event
                (Login / Exit Button)
                        │
                        ▼
                 updateEntry() /
                  updateExit()
                        │
                        ▼
                    setState()
                        │
                        ▼
                Component Re-renders
                        │
                        ▼
               Updated Counter Display
```

---

# 8. Technologies Used

| Technology             | Purpose                                         | Role in this Project                                                 |
| ---------------------- | ----------------------------------------------- | -------------------------------------------------------------------- |
| **React**              | JavaScript library for building user interfaces | Creates reusable UI components and manages state.                    |
| **JavaScript (ES6)**   | Programming language                            | Implements the application logic, event handling, and state updates. |
| **JSX**                | JavaScript syntax extension                     | Allows writing HTML-like UI inside JavaScript.                       |
| **Node.js**            | JavaScript runtime                              | Provides the environment to run React development tools.             |
| **npm**                | Package manager                                 | Installs and manages project dependencies.                           |
| **Visual Studio Code** | Source code editor                              | Used to develop and edit the React application.                      |
| **CSS**                | Styling language                                | Styles the buttons, layout, and counter display.                     |

---

# Exercise 8: React State

## Week 5 – ReactJS Hands-on Lab

> **Response 2 of 4**

---

# Table of Contents

6. Project Structure

7. Folder Explanation

8. File-by-File Explanation

9. Configuration Explanation

10. Implementation Explanation

11. Code Flow

12. Execution Flow

13. Internal Working

14. Function Explanation

* Constructor
* `updateEntry()`
* `updateExit()`
* `render()`

---

# 6. Project Structure

According to the uploaded hands-on lab, the project is a React application named **counterapp** containing a class component named **CountPeople** that maintains two counters using React State. 

```text
counterapp
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
│   │      └── CountPeople.js
│   │
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

# 7. Folder Explanation

---

# node_modules

## Purpose

This folder stores every package installed through **npm**.

Examples include:

* React
* React DOM
* Babel
* Webpack
* ESLint

This folder is automatically created after executing

```bash
npx create-react-app counterapp
```

---

# public

The **public** folder stores static resources that are directly served by the browser.

Typical files include

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

The most important part is

```html
<div id="root"></div>
```

React renders the complete application inside this HTML element.

---

# src

The **src** folder contains all application source code.

```text
src
│
├── Components
├── App.js
├── index.js
├── App.css
└── index.css
```

Everything related to the application's logic is written inside this folder.

---

# Components Folder

The Components folder stores reusable React components.

For this project

```text
Components
│
└── CountPeople.js
```

This component contains:

* Constructor
* State
* Event handlers
* UI

---

# CountPeople.js

This is the main component of the application.

Responsibilities:

* Initialize State
* Store entry count
* Store exit count
* Handle Login button click
* Handle Exit button click
* Update UI automatically

The uploaded lab specifies creating this component and implementing the two update methods. 

---

# App.js

Acts as the root component.

Responsibilities

* Load CountPeople
* Display the application

---

# index.js

Acts as the application's entry point.

Responsibilities

* Create the React Root
* Render App component

---

# App.css

Contains styling for

* Layout
* Buttons
* Counter display
* Font
* Spacing

---

# 8. File-by-File Explanation

---

# File 1 — CountPeople.js

## Purpose

This component demonstrates **React State**.

It stores two counters:

* Entry Count
* Exit Count

using the component's State object.

---

## Responsibilities

```text
Create Constructor

↓

Initialize State

↓

Display Counters

↓

Handle Button Clicks

↓

Update State

↓

Update UI
```

---

## Why is this component needed?

Instead of storing values inside ordinary variables,

React stores dynamic values inside **State**.

Whenever State changes,

React automatically updates the screen.

---

## State Variables

```text
entrycount

↓

Number of people entered
```

```text
exitcount

↓

Number of people exited
```

---

# File 2 — App.js

## Purpose

Loads the main component.

Responsibilities

```text
Load

↓

CountPeople

↓

Display UI
```

---

## Component Hierarchy

```text
App

↓

CountPeople
```

---

# File 3 — index.js

## Purpose

Starts the React application.

Flow

```text
Browser

↓

index.js

↓

<App/>

↓

CountPeople
```

---

## ReactDOM.createRoot()

Modern React applications use

```javascript
ReactDOM.createRoot()
```

instead of

```javascript
ReactDOM.render()
```

Earlier React versions used `ReactDOM.render()`, while React 18 introduced `ReactDOM.createRoot().render()`. The uploaded lab mentions `reactDOM.render()` as part of the learning objectives, but current Create React App projects use the newer API. 

---

# File 4 — App.css

## Purpose

Styles the application.

Responsibilities include:

* Center alignment
* Button styling
* Layout spacing
* Font styling

---

# File 5 — index.css

## Purpose

Applies global styling to the application.

Responsibilities include:

* Removing default margins
* Setting font family
* Page padding

---

# 9. Configuration Explanation

---

# package.json

This file stores:

* Project information
* Installed dependencies
* npm scripts

Important scripts

```text
npm start

↓

Run Development Server
```

```text
npm run build

↓

Create Production Build
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

React injects the entire application into this element.

---

# 10. Implementation Explanation

The uploaded lab specifies the following implementation workflow: create the application, define a `CountPeople` component, initialize `entrycount` and `exitcount` in the constructor using State, and update them through the Login and Exit buttons. 

Implementation sequence

```text
Create React Project

↓

Create CountPeople Component

↓

Create Constructor

↓

Initialize State

↓

Create updateEntry()

↓

Create updateExit()

↓

Create Login Button

↓

Create Exit Button

↓

Run Application
```

---

# 11. Code Flow

The internal processing of the application follows this sequence.

```text
User Clicks Button

↓

Button Event

↓

Corresponding Method Executes

↓

setState()

↓

State Updated

↓

React Detects Change

↓

render()

↓

Updated UI
```

---

## Login Flow

```text
Login Button

↓

updateEntry()

↓

setState()

↓

entrycount + 1

↓

render()

↓

Updated Entry Count
```

---

## Exit Flow

```text
Exit Button

↓

updateExit()

↓

setState()

↓

exitcount + 1

↓

render()

↓

Updated Exit Count
```

---

# 12. Execution Flow

```text
React Starts

        │

        ▼

index.js

        │

        ▼

<App/>

        │

        ▼

CountPeople Component

        │

        ▼

Constructor Executes

        │

        ▼

State Initialized

(entrycount = 0)

(exitcount = 0)

        │

        ▼

UI Displayed

        │

        ▼

User Clicks Login / Exit

        │

        ▼

Corresponding Method Executes

        │

        ▼

State Updated

        │

        ▼

React Re-renders Component

        │

        ▼

Updated Counts Displayed
```

---

# 13. Internal Working

The application works internally as follows.

Step 1

```text
React Starts
```

↓

Step 2

```text
index.js
```

loads.

↓

Step 3

```text
<App/>
```

is rendered.

↓

Step 4

`CountPeople` component is created.

↓

Step 5

Constructor initializes

```text
entrycount = 0

exitcount = 0
```

↓

Step 6

React displays the component.

↓

Step 7

User clicks

```text
Login
```

↓

Step 8

`updateEntry()`

executes.

↓

Step 9

`setState()`

updates

```text
entrycount
```

↓

Step 10

React automatically calls

```text
render()
```

↓

Step 11

Updated UI appears.

The same sequence occurs when the **Exit** button is clicked, updating `exitcount` instead. 

---

# 14. Function Explanation

---

# Constructor

## Purpose

Creates the initial state of the component.

Responsibilities

```text
Create State

↓

Initialize Variables

↓

Prepare Component
```

---

# updateEntry()

## Purpose

Increases the number of people entering the mall.

Flow

```text
Login Button

↓

updateEntry()

↓

setState()

↓

entrycount + 1

↓

UI Updated
```

---

# updateExit()

## Purpose

Increases the number of people leaving the mall.

Flow

```text
Exit Button

↓

updateExit()

↓

setState()

↓

exitcount + 1

↓

UI Updated
```

---

# render()

## Purpose

Displays the user interface based on the current state.

Responsibilities

* Display Login button
* Display Exit button
* Display Entry Count
* Display Exit Count
* Refresh the UI whenever State changes

Flow

```text
State

↓

render()

↓

JSX

↓

Browser

↓

Updated Display
```

---

# Exercise 8: React State

## Week 5 – ReactJS Hands-on Lab

> **Response 3 of 4**

---

# Table of Contents

16. Sample Inputs and Outputs

17. How to Run the Project

18. Testing

19. Best Practices

20. Common Mistakes

21. Real-world Applications

22. Advantages

23. Limitations

---

# 16. Sample Inputs and Outputs

The uploaded hands-on lab requires building a **counterapp** that maintains two counters using **React State**:

* Entry Count
* Exit Count

Initially, both counters start at **0**. Clicking the **Login** button increments the entry count, while clicking the **Exit** button increments the exit count. 

---

# Initial State

When the application starts:

```text
Entry Count = 0

Exit Count = 0
```

Displayed on the screen as:

```text
------------------------------------------

[ Login ]    0 People Entered!!!

[ Exit ]     0 People Left!!!

------------------------------------------
```

---

# Sample Input 1

User clicks

```text
Login
```

one time.

---

## Expected Output

```text
------------------------------------------

[ Login ]    1 People Entered!!!

[ Exit ]     0 People Left!!!

------------------------------------------
```

---

# Sample Input 2

User clicks

```text
Login
```

three times.

---

## Expected Output

```text
------------------------------------------

[ Login ]    3 People Entered!!!

[ Exit ]     0 People Left!!!

------------------------------------------
```

---

# Sample Input 3

User clicks

```text
Exit
```

two times.

---

## Expected Output

```text
------------------------------------------

[ Login ]    3 People Entered!!!

[ Exit ]     2 People Left!!!

------------------------------------------
```

---

# Sample Input 4

Sequence of operations

```text
Login

↓

Login

↓

Exit

↓

Login

↓

Exit
```

---

## Expected Output

```text
Entry Count = 3

Exit Count = 2
```

---

# Complete State Transition

```text
Initial State

Entry = 0

Exit = 0

↓

Login

↓

Entry = 1

Exit = 0

↓

Login

↓

Entry = 2

Exit = 0

↓

Exit

↓

Entry = 2

Exit = 1

↓

Login

↓

Entry = 3

Exit = 1

↓

Exit

↓

Entry = 3

Exit = 2
```

This behavior matches the functionality described in the uploaded hands-on lab. 

---

# 17. How to Run the Project

---

## Step 1

Install **Node.js**

Verify installation

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

Create React Project

```bash
npx create-react-app counterapp
```

---

## Step 4

Move into the project directory

```bash
cd counterapp
```

---

## Step 5

Open in Visual Studio Code

```bash
code .
```

---

## Step 6

Create the required component

```text
src/

└── Components

      └── CountPeople.js
```

---

## Step 7

Configure

* App.js
* index.js
* App.css
* index.css

---

## Step 8

Run the application

```bash
npm start
```

---

## Step 9

Open Browser

```text
http://localhost:3000
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

folder.

---

## Run Tests

```bash
npm test
```

---

## Stop Development Server

```text
Ctrl + C
```

---

# Important Commands

| Command                           | Purpose                  |
| --------------------------------- | ------------------------ |
| `node -v`                         | Check Node.js version    |
| `npm -v`                          | Check npm version        |
| `npx create-react-app counterapp` | Create React project     |
| `cd counterapp`                   | Open project directory   |
| `code .`                          | Open project in VS Code  |
| `npm start`                       | Start development server |
| `npm test`                        | Execute tests            |
| `npm run build`                   | Production build         |
| `Ctrl + C`                        | Stop development server  |

---

# 18. Testing

---

## Test 1

Application Starts

Expected

```text
Compiled successfully!
```

---

## Test 2

Initial Screen

Expected

```text
0 People Entered!!!

0 People Left!!!
```

---

## Test 3

Click Login Once

Expected

```text
1 People Entered!!!

0 People Left!!!
```

---

## Test 4

Click Login Three Times

Expected

```text
3 People Entered!!!

0 People Left!!!
```

---

## Test 5

Click Exit Once

Expected

```text
3 People Entered!!!

1 People Left!!!
```

---

## Test 6

Click Exit Twice

Expected

```text
3 People Entered!!!

2 People Left!!!
```

---

## Test 7

Verify State

Expected

```text
entrycount

↓

Updated Correctly
```

```text
exitcount

↓

Updated Correctly
```

---

## Test 8

Verify Automatic UI Update

Expected

```text
Button Click

↓

State Changes

↓

UI Changes Immediately
```

---

## Test 9

Refresh Browser

Expected

```text
Entry Count = 0

Exit Count = 0
```

Because the counters are stored only in the component's state and are not persisted.

---

## Manual Testing Checklist

| Test                        | Status |
| --------------------------- | ------ |
| React Starts                | ✅      |
| Component Loads             | ✅      |
| Constructor Executes        | ✅      |
| State Initialized           | ✅      |
| Login Button Works          | ✅      |
| Exit Button Works           | ✅      |
| Entry Count Updates         | ✅      |
| Exit Count Updates          | ✅      |
| UI Re-renders Automatically | ✅      |
| No Console Errors           | ✅      |

These tests verify the functionality required by the uploaded hands-on lab. 

---

# 19. Best Practices

---

## Initialize State in Constructor

For class components, initialize state inside the constructor.

```jsx
constructor() {
    super();

    this.state = {
        entrycount: 0,
        exitcount: 0
    };
}
```

---

## Always Use `setState()`

Correct

```jsx
this.setState({
    entrycount: this.state.entrycount + 1
});
```

Avoid

```javascript
this.state.entrycount++;
```

because React will not reliably detect the change.

---

## Use Functional `setState()` When Based on Previous State

Correct

```jsx
this.setState((prevState) => ({
    entrycount: prevState.entrycount + 1
}));
```

This ensures the latest state value is used, especially when multiple updates occur quickly.

---

## Keep State Minimal

Store only values that change over time.

For this project:

```text
entrycount

exitcount
```

---

## Keep Event Handlers Focused

Each event handler should perform a single task.

```text
updateEntry()

↓

Increment Entry Count
```

```text
updateExit()

↓

Increment Exit Count
```

---

# 20. Common Mistakes

---

## Mistake 1

Updating State Directly

Wrong

```javascript
this.state.entrycount++;
```

Correct

```javascript
this.setState({
    entrycount: this.state.entrycount + 1
});
```

---

## Mistake 2

Forgetting `super()`

Wrong

```javascript
constructor() {
}
```

Correct

```javascript
constructor() {
    super();
}
```

---

## Mistake 3

Using Normal Variables Instead of State

Wrong

```javascript
let count = 0;
```

React will not automatically update the UI.

---

## Mistake 4

Misspelling State Variables

Wrong

```javascript
entryCount
```

Correct

```javascript
entrycount
```

Use the same property names consistently throughout the component.

---

## Mistake 5

Forgetting `this`

Wrong

```javascript
setState(...)
```

Correct

```javascript
this.setState(...)
```

---

## Mistake 6

Not Binding Event Handlers (when using normal methods)

If using standard class methods, they must be bound in the constructor.

Using arrow functions, as in this implementation, automatically preserves `this`.

---

## Mistake 7

Changing Multiple State Values Incorrectly

Always update state through `setState()` instead of modifying the state object directly.

---

# 21. Real-world Applications

React State is used in almost every interactive React application.

---

## Shopping Cart

```text
Add Product

↓

Cart Count Updates
```

---

## Banking Dashboard

```text
Deposit

↓

Balance Updates
```

---

## Attendance System

```text
Student Enters

↓

Attendance Count Updates
```

---

## Hospital Management

```text
Patient Check-in

↓

Current Patients Updated
```

---

## Parking Management

```text
Vehicle Enters

↓

Occupied Slots Increase
```

---

## Airport Passenger Counter

```text
Passenger Boards

↓

Boarding Count Updates
```

---

## Live Sports Scoreboard

```text
Goal Scored

↓

Score Updates
```

The mall entry/exit counter used in this exercise is a simplified version of these real-world systems.

---

# 22. Advantages

| Advantage                | Explanation                                            |
| ------------------------ | ------------------------------------------------------ |
| Dynamic UI               | Automatically updates the interface when data changes. |
| Interactive Applications | Enables user-driven interactions.                      |
| Automatic Re-rendering   | No manual DOM manipulation required.                   |
| Better User Experience   | Users immediately see updated information.             |
| Component Encapsulation  | Each component manages its own state independently.    |
| Easy Maintenance         | Logic and UI remain closely connected.                 |

---

# 23. Limitations

---

## State is Local

State belongs only to the component where it is defined.

---

## Data is Temporary

Refreshing the browser resets the counters because state is stored in memory.

---

## No Backend Storage

This project does not save the counts in a database.

---

## No Shared State

Other components cannot directly access this component's state unless it is passed as props or managed using a shared state solution.

---

## Simple Counter Only

The uploaded lab focuses only on demonstrating **React State** using entry and exit counters. More advanced concepts such as Context API, Redux, or Hooks are beyond the scope of this exercise. 

---

# Exercise 8: React State

## Week 5 – ReactJS Hands-on Lab

> **Response 4 of 4**

---

# Table of Contents

24. Frequently Asked Interview Questions

25. Quick Revision

* Important Concepts
* Important Files
* Important Commands
* Important Workflow
* Important Configurations
* Key Takeaways

26. Conclusion

27. Next Learning Path

---

# 24. Frequently Asked Interview Questions

## Q1. What is State in React?

**Answer**

State is a built-in React object used to store data that can change over time. When the state changes, React automatically updates the user interface.

---

## Q2. Why do we need State?

**Answer**

State is required to store dynamic information such as:

* Counter values
* Shopping cart items
* Form inputs
* Notifications
* User information

Without State, components can only display static data.

---

## Q3. What is the difference between State and Props?

| State                      | Props                        |
| -------------------------- | ---------------------------- |
| Managed by the component   | Passed from parent component |
| Mutable                    | Read-only                    |
| Used for dynamic data      | Used to transfer data        |
| Updated using `setState()` | Cannot be modified by child  |

---

## Q4. Can State be modified directly?

**Answer**

No.

Incorrect

```javascript
this.state.entrycount++;
```

Correct

```javascript
this.setState({
    entrycount: this.state.entrycount + 1
});
```

---

## Q5. What is `setState()`?

**Answer**

`setState()` is the method used to update a component's state.

Whenever it is called:

```text
State Updates

↓

Component Re-renders

↓

Updated UI Appears
```

---

## Q6. Why should we use `setState()` instead of directly changing the state?

**Answer**

`setState()` informs React that the state has changed. React then schedules a re-render and updates the UI efficiently. Directly modifying `this.state` bypasses this mechanism and can lead to incorrect or missing UI updates.

---

## Q7. What is a constructor?

**Answer**

A constructor is a special method of a class that executes automatically when the component is created. It is commonly used to initialize the component's state.

---

## Q8. Why is `super()` required inside the constructor?

**Answer**

`super()` calls the constructor of the parent `React.Component` class. It must be called before accessing `this` inside the constructor.

---

## Q9. What happens if we forget `super()`?

**Answer**

The application throws an error because `this` is not initialized.

---

## Q10. What is component re-rendering?

**Answer**

Re-rendering is the process where React executes the `render()` method again after the state or props change, updating only the necessary parts of the user interface.

---

## Q11. Does every `setState()` call immediately update the state?

**Answer**

Not always. React may batch multiple state updates together for better performance. This is why the functional form of `setState()` is recommended when the new value depends on the previous state.

---

## Q12. Why use the functional form of `setState()`?

**Answer**

Because it guarantees that the update is based on the latest state value.

Example:

```jsx
this.setState((prevState) => ({
    entrycount: prevState.entrycount + 1
}));
```

---

## Q13. What is the purpose of the `render()` method?

**Answer**

The `render()` method returns the JSX that React converts into HTML and displays in the browser. It is called during the initial render and whenever state or props change.

---

## Q14. Can multiple state variables exist in one component?

**Answer**

Yes.

Example:

```javascript
this.state = {
    entrycount: 0,
    exitcount: 0
};
```

---

## Q15. What happens when the Login button is clicked in this project?

**Answer**

```text
User Clicks Login

↓

updateEntry()

↓

setState()

↓

entrycount Increases

↓

render()

↓

Updated Count Displayed
```

---

## Q16. What happens when the Exit button is clicked?

**Answer**

```text
User Clicks Exit

↓

updateExit()

↓

setState()

↓

exitcount Increases

↓

render()

↓

Updated Count Displayed
```

---

## Q17. Where is State stored?

**Answer**

State is stored inside the React component instance and managed internally by React.

---

## Q18. Is State shared between components?

**Answer**

No.

Each component has its own independent state unless the data is lifted to a common parent or managed through shared state solutions.

---

## Q19. Can State store objects and arrays?

**Answer**

Yes.

State can store:

* Numbers
* Strings
* Booleans
* Arrays
* Objects
* Nested objects

---

## Q20. Why is this project a good example of React State?

**Answer**

Because it demonstrates how user interactions change the state and how React automatically reflects those changes in the UI without manual DOM manipulation.

---

# 25. Quick Revision

---

# Important Concepts

| Concept        | Summary                                           |
| -------------- | ------------------------------------------------- |
| React State    | Stores dynamic data inside a component.           |
| Constructor    | Initializes the component and its state.          |
| `setState()`   | Updates state and triggers re-rendering.          |
| Event Handling | Executes methods when users interact with the UI. |
| `render()`     | Displays the UI based on the current state.       |
| Re-rendering   | Refreshes the UI after state changes.             |

---

# Important Files

| File             | Purpose                                                       |
| ---------------- | ------------------------------------------------------------- |
| `CountPeople.js` | Contains the main class component, state, and event handlers. |
| `App.js`         | Renders the `CountPeople` component.                          |
| `index.js`       | Entry point of the React application.                         |
| `App.css`        | Styles the component layout and buttons.                      |
| `index.css`      | Applies global styles.                                        |
| `package.json`   | Stores project metadata, dependencies, and npm scripts.       |

---

# Important Commands

| Command                           | Description                              |
| --------------------------------- | ---------------------------------------- |
| `npx create-react-app counterapp` | Creates the React project.               |
| `cd counterapp`                   | Opens the project directory.             |
| `code .`                          | Opens the project in Visual Studio Code. |
| `npm start`                       | Starts the development server.           |
| `npm test`                        | Runs project tests.                      |
| `npm run build`                   | Creates the production build.            |

---

# Important Workflow

```text
Create React Project

↓

Create CountPeople Component

↓

Initialize State

↓

Render UI

↓

User Clicks Button

↓

Event Handler Executes

↓

setState()

↓

State Updates

↓

React Re-renders

↓

Updated Counter Displayed
```

---

# Important Configurations

| Configuration  | Purpose                                                       |
| -------------- | ------------------------------------------------------------- |
| `package.json` | Defines dependencies and project scripts.                     |
| `index.html`   | Provides the root element where React mounts the application. |
| `App.css`      | Component-level styling.                                      |
| `index.css`    | Global styling.                                               |

---

# React State Cheat Sheet

| Topic         | Key Point                                         |
| ------------- | ------------------------------------------------- |
| State         | Stores changing data.                             |
| Constructor   | Initializes state in class components.            |
| `this.state`  | Holds the current state values.                   |
| `setState()`  | Updates state safely.                             |
| `render()`    | Re-renders the UI after state changes.            |
| Event Handler | Responds to user interactions like button clicks. |

---

# Key Takeaways

* State stores data that changes during the application's lifetime.
* Class components initialize state using a constructor.
* `setState()` is the correct way to update state.
* Updating state automatically triggers a re-render.
* Event handlers connect user actions to state changes.
* React updates only the affected parts of the UI, making applications efficient and responsive.
* This exercise demonstrates the core idea of building interactive React applications using state management, as described in the uploaded hands-on lab. 

---

# 26. Conclusion

In this hands-on exercise, you learned how to build a simple React application that uses **State** to manage dynamic data. The project initializes two counters (`entrycount` and `exitcount`) in a class component, updates them using the `setState()` method when the **Login** and **Exit** buttons are clicked, and automatically refreshes the user interface to reflect the latest values. This implementation follows the objectives and workflow described in the uploaded ReactJS Hands-on Lab. 

By completing this exercise, you have gained an understanding of:

* The purpose of React State.
* Initializing state in a constructor.
* Updating state with `setState()`.
* Handling user events.
* React's automatic re-rendering mechanism.
* Organizing a simple React application into reusable components.

These concepts form the foundation for building interactive React applications and are essential before moving on to more advanced topics.

---

# 27. Next Learning Path

After mastering **React State**, continue with these topics in sequence:

```text
React Components
        │
        ▼
React Props
        │
        ▼
React State
        │
        ▼
Component Lifecycle
        │
        ▼
Forms and Controlled Components
        │
        ▼
React Hooks (useState, useEffect)
        │
        ▼
Context API
        │
        ▼
React Router
        │
        ▼
API Integration (Fetch / Axios)
        │
        ▼
State Management Libraries
(Redux, Zustand, etc.)
```

Understanding **React State** is a crucial milestone because nearly every modern React application relies on state management. Whether you are developing dashboards, e-commerce platforms, social media applications, or enterprise systems, the ability to manage and update application state efficiently is one of the most important React skills for both development and technical interviews.



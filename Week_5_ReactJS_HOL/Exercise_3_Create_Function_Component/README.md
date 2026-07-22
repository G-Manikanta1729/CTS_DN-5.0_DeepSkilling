# Exercise 3: Create a Function Component in React

## Week 5 – ReactJS Hands-on Lab

> **Response 1 of 4**

---

# Table of Contents

1. Project Title
2. Introduction
3. Learning Objectives
4. Prerequisites
5. Background Concepts

   * React Components
   * Function Components
   * JSX
   * Props
   * CSS in React
   * React Project Structure
   * Component Reusability
6. Project Overview
7. High-Level Architecture
8. Technologies Used

---

# 1. Project Title

# Student Score Calculator using React Function Components

**Week 5 – ReactJS Hands-on Lab**

**Exercise 3 – Create Function Component**

---

# 2. Introduction

## What is this project?

This project is a simple **Student Score Calculator** developed using **ReactJS Function Components**.

The application displays a student's information including:

* Name
* School
* Total Marks
* Calculated Score Percentage

Unlike the previous exercise where Class Components were used, this exercise introduces **Function Components**, which are the modern and recommended way of building React applications.

The application receives student details from the parent component (`App.js`) and displays them through a reusable function component named **CalculateScore**. The score percentage is calculated dynamically and styled using an external CSS file. This follows the workflow described in the hands-on document. 

---

## What problem does it solve?

Imagine a school where teachers manually calculate every student's percentage.

For example,

```
Student Name : Rahul

Total Marks Obtained : 450

Maximum Marks : 500

Percentage = ?
```

Instead of calculating manually every time,

our React application performs the calculation automatically and displays the result.

Although this is a small project, it demonstrates how real-world applications separate:

* Data
* Business Logic
* User Interface

---

## Why is it important?

Every React application consists of components.

This exercise introduces one of the most important concepts in React:

> **Function Components**

Almost every modern React application—from Netflix to Facebook to Amazon—uses Function Components extensively.

Understanding Function Components is therefore essential before learning:

* Props
* State
* Hooks
* Routing
* API Integration
* Redux
* Context API

---

## Where is this concept used?

Function Components are used in almost every React application.

Examples include:

* Login Form
* Registration Page
* Product Card
* Navigation Bar
* Shopping Cart
* Student Dashboard
* Employee Profile
* Weather Widget
* Chat Message
* Banking Dashboard

---

# 3. Learning Objectives

After completing this exercise, you should be able to:

* Explain what a Function Component is.
* Differentiate Function Components from Class Components.
* Understand JSX syntax.
* Understand how Props work.
* Create reusable React components.
* Apply external CSS styles to components.
* Perform calculations inside components.
* Pass data from one component to another.
* Render components inside the parent component.
* Understand the modern React development approach.

---

# 4. Prerequisites

Before starting this exercise, you should have the following installed.

| Software           | Purpose            |
| ------------------ | ------------------ |
| Node.js            | JavaScript Runtime |
| npm                | Package Manager    |
| Visual Studio Code | Code Editor        |
| React              | UI Library         |

You should also be familiar with:

* Basic JavaScript
* Variables
* Functions
* ES6 Syntax
* HTML
* CSS

It is recommended to complete **Exercise 1** and **Exercise 2** before starting this exercise because they introduce React setup and Class Components.

---

# 5. Background Concepts

---

# 5.1 What is React?

## Definition

React is an open-source JavaScript library used for building User Interfaces (UI).

It was developed by **Meta (Facebook)**.

---

## Why was React created?

Before React,

developers used to build webpages using plain HTML, CSS and JavaScript.

Large applications became difficult to maintain because:

* HTML became huge.
* JavaScript became complex.
* Code duplication increased.
* Updating webpages became slow.

React solved these problems by introducing reusable components.

---

## Why is React needed?

Suppose Facebook had one HTML page containing:

* Login
* News Feed
* Messenger
* Notifications
* Friends
* Profile

Everything in one file.

Imagine modifying this file every day.

It would become nearly impossible.

React divides the UI into independent components.

---

## Advantages

* Reusable code
* Better readability
* Faster rendering
* Easier maintenance
* Component-based architecture
* Virtual DOM

---

## Real-world Analogy

Think of a **car**.

A car is made of:

```
Car

├── Engine

├── Wheels

├── Doors

├── Seats

└── Steering
```

Each part has its own responsibility.

Similarly,

React applications are divided into independent components.

---

# 5.2 What is a Component?

## Definition

A Component is an independent, reusable piece of User Interface.

Each component performs one specific job.

---

## Example

Instead of writing

```
Entire Website

10000 lines
```

React divides it into

```
Website

│

├── Header

├── Navbar

├── Sidebar

├── Content

├── Footer
```

Each section becomes an independent component.

---

## Why Components Exist

Without components,

developers repeat the same code.

With components,

one component can be reused multiple times.

Example

```
Product Card

↓

Laptop

Phone

Tablet

Headphones
```

Same component.

Different data.

---

## Advantages

* Reusability
* Easy maintenance
* Better testing
* Independent development
* Cleaner code

---

# 5.3 Function Components

## Definition

A Function Component is a JavaScript function that returns JSX.

Example

```jsx
function Home() {
    return (
        <h1>Hello React</h1>
    );
}
```

---

## Why Function Components?

Initially,

React used Class Components.

Modern React prefers Function Components because they are:

* Smaller
* Cleaner
* Easier to understand
* Easier to test
* Less code

---

## Advantages

* Less boilerplate
* Better readability
* Hooks support
* Easier maintenance
* Faster development

---

## Limitation

Earlier,

Function Components could not use State.

React Hooks solved this limitation.

---

## Real-world Analogy

Suppose you have a calculator.

You press

```
Calculate
```

Input

↓

Processing

↓

Result

Similarly,

Function Components

accept data,

process it,

return UI.

---

# Function Component vs Class Component

| Function Component        | Class Component                |
| ------------------------- | ------------------------------ |
| JavaScript Function       | JavaScript Class               |
| Simpler                   | More verbose                   |
| Uses Hooks                | Uses Lifecycle Methods         |
| Preferred in Modern React | Mostly used in legacy projects |
| Less code                 | More code                      |
| Easier to understand      | More complex                   |

---

# 5.4 What is JSX?

## Definition

JSX stands for

**JavaScript XML**

It allows developers to write HTML-like syntax inside JavaScript.

Example

```jsx
function App() {
    return (
        <h1>Hello React</h1>
    );
}
```

Although it looks like HTML,

React converts it into JavaScript before rendering.

---

## Why JSX Exists

Without JSX,

the same code would look like

```javascript
React.createElement(
    "h1",
    null,
    "Hello React"
);
```

JSX makes React code easier to read and write.

---

## Advantages

* Cleaner syntax
* Easier debugging
* Better readability
* Similar to HTML

---

# 5.5 What are Props?

## Definition

Props stands for

**Properties**

Props are used to send data from one component to another.

---

## Real-world Example

Teacher

↓

Student Report Card

The teacher provides the information.

The report card only displays it.

Similarly,

```
App Component

↓

CalculateScore Component
```

The App component provides:

* Name
* School
* Total Marks
* Goal

The CalculateScore component simply receives and displays them.

---

Example

```jsx
<CalculateScore
    Name="Steeve"
    School="DNV Public School"
    total={284}
    goal={3}
/>
```

Inside the component,

```jsx
const CalculateScore = ({ Name, School, total, goal }) => {

}
```

The values are received using Props.

---

# 5.6 Why External CSS?

React allows styling in multiple ways.

This exercise uses an external CSS file because it:

* Separates UI from styling
* Improves readability
* Encourages reuse
* Simplifies maintenance

Instead of writing styles inside JSX,

the project creates

```
Stylesheets

↓

mystyle.css
```

This CSS file is imported into the component and applied using `className`, matching the approach in the lab document. 

---

# 5.7 React Project Structure

A React project contains several important folders.

```
scorecalculatorapp

│

├── node_modules

├── public

├── src

├── package.json

└── package-lock.json
```

Purpose of each:

| Folder/File       | Purpose                                |
| ----------------- | -------------------------------------- |
| node_modules      | Stores installed packages              |
| public            | Static resources like index.html       |
| src               | Application source code                |
| package.json      | Project configuration and dependencies |
| package-lock.json | Locks dependency versions              |

---

# 5.8 Component Reusability

Suppose a school has

```
500 Students
```

Instead of writing

```
Student1 Component

Student2 Component

Student3 Component

...
```

We create

```
CalculateScore Component
```

and reuse it.

Example

```jsx
<CalculateScore
    Name="Rahul"
    School="ABC School"
    total={450}
    goal={500}
/>

<CalculateScore
    Name="Anjali"
    School="XYZ School"
    total={470}
    goal={500}
/>
```

The same component displays different students simply by changing the props.

This principle of **write once, reuse many times** is one of React's biggest strengths.

---

# 6. Project Overview

In this exercise, we build a **Student Score Calculator** using a **Function Component**.

The application:

* Creates a reusable `CalculateScore` component.
* Accepts student details as props.
* Calculates the score percentage.
* Displays the result in a styled format.
* Applies external CSS for presentation.
* Renders the component from `App.js`.

Although simple, this project demonstrates several core React concepts working together:

* Function Components
* Props
* JSX
* Component Reusability
* CSS Integration
* Parent–Child Component Communication

---

# 7. High-Level Architecture

## Overall Architecture

```text
                 User Opens Browser
                         │
                         ▼
                    React Application
                         │
                         ▼
                     index.js
                         │
                         ▼
                      App.js
                         │
                         ▼
              CalculateScore Component
                         │
        ┌────────────────┼────────────────┐
        ▼                ▼                ▼
      Props         Business Logic     CSS Styles
(Name, School,   Calculate Percentage  mystyle.css
 Total, Goal)
        │                │                │
        └────────────────┴────────────────┘
                         │
                         ▼
                   Rendered Web Page
```

---

## Component Relationship

```text
App.js
   │
   │ passes props
   ▼
CalculateScore.js
   │
   ├── Displays Name
   ├── Displays School
   ├── Displays Total
   ├── Calculates Score
   └── Applies CSS Styling
```

---

# 8. Technologies / Languages / Libraries / Tools Used

| Technology             | Purpose in This Project                                                      |
| ---------------------- | ---------------------------------------------------------------------------- |
| **React**              | Builds the user interface using reusable components.                         |
| **JavaScript (ES6)**   | Implements the function component, helper functions, and calculation logic.  |
| **JSX**                | Allows HTML-like syntax within JavaScript for creating UI.                   |
| **CSS**                | Styles the displayed student information using an external stylesheet.       |
| **Node.js**            | Provides the JavaScript runtime needed for React development.                |
| **npm**                | Installs and manages project dependencies.                                   |
| **Create React App**   | Generates the initial React project structure and development configuration. |
| **Visual Studio Code** | Used to write, edit, and manage the project files.                           |

---

# Exercise 3: Create a Function Component in React

## Week 5 – ReactJS Hands-on Lab

> **Response 2 of 4**

---

# Table of Contents

9. Project Structure
10. Implementation Explanation
11. Configuration Explanation
12. Code Flow
13. Execution Flow
14. Internal Working of React
15. Function & Module Explanation
16. Parent–Child Component Communication

---

# 9. Project Structure

The project follows the standard **Create React App (CRA)** folder structure with additional folders (`Components` and `Stylesheets`) created specifically for this exercise. 

```
scorecalculatorapp
│
├── node_modules/
│
├── public/
│   ├── favicon.ico
│   ├── index.html
│   ├── manifest.json
│   └── robots.txt
│
├── src/
│   │
│   ├── Components/
│   │      └── CalculateScore.js
│   │
│   ├── Stylesheets/
│   │      └── mystyle.css
│   │
│   ├── App.js
│   ├── App.css
│   ├── index.js
│   ├── index.css
│   ├── reportWebVitals.js
│   ├── setupTests.js
│   └── logo.svg
│
├── .gitignore
├── package.json
├── package-lock.json
└── README.md
```

---

# Folder Explanation

---

## node_modules

Contains all installed npm packages.

Example

```
react

react-dom

react-scripts

babel

webpack

eslint
```

### Why is it needed?

React itself is not stored inside your project.

When we install React,

npm downloads thousands of files.

They are stored here.

---

## public

Contains files that are served directly by the browser.

```
public

│

├── index.html

├── favicon.ico

└── manifest.json
```

The most important file is

```
index.html
```

This contains

```html
<div id="root"></div>
```

React injects the entire application into this element.

---

## src

This is the heart of the application.

Everything you write lives here.

```
src

│

├── Components

├── Stylesheets

├── App.js

├── index.js
```

---

## Components

Contains reusable React components.

In this project

```
CalculateScore.js
```

is stored here.

Keeping components inside a dedicated folder makes projects organized and scalable.

---

## Stylesheets

Contains CSS files.

Instead of mixing CSS with JavaScript,

React encourages separating styles.

```
Stylesheets

↓

mystyle.css
```

---

## App.js

Acts as the Parent Component.

Responsibilities

* Imports CalculateScore
* Passes Props
* Displays Component

---

## index.js

Entry point of the application.

React starts execution from here.

---

## package.json

Stores project metadata.

Contains

* dependencies
* scripts
* project name
* version

---

## package-lock.json

Locks dependency versions.

Ensures everyone installs the same package versions.

---

# 10. Implementation Explanation

---

# File 1 — CalculateScore.js

This is the most important file.

Purpose

* Receive student data.
* Calculate percentage.
* Display information.
* Apply CSS.

---

### Responsibilities

```
Receive Props

↓

Calculate Percentage

↓

Return JSX

↓

Display Student Details
```

---

### Code Breakdown

---

### Import CSS

```javascript
import '../Stylesheets/mystyle.css';
```

Why?

React doesn't automatically load CSS.

We explicitly import it.

Without this line

```
No Styling
```

---

### percentToDecimal()

```javascript
const percentToDecimal = (decimal) => {
    return decimal.toFixed(2) + "%";
}
```

Purpose

Convert

```
94.666666
```

into

```
94.67%
```

---

### Why use toFixed()?

Without

```javascript
94.6666666666666
```

With

```javascript
94.67
```

Much cleaner.

---

### calcScore()

```javascript
const calcScore = (total, goal) => {
    return percentToDecimal(total / goal);
}
```

Purpose

Performs

```
Percentage

=

Marks Obtained

÷

Maximum Marks
```

Example

```
284

÷

3

=

94.666

↓

94.67%
```

The document uses `total={284}` and `goal={3}`, so the displayed score becomes **94.67%** after formatting. 

---

### Function Component

```javascript
const CalculateScore = ({ Name, School, total, goal }) => {

}
```

Purpose

Receive Props.

Instead of writing

```javascript
props.Name

props.School

props.total
```

React allows

```javascript
{Name, School, total, goal}
```

called

**Object Destructuring**

---

### Returning JSX

```jsx
return (

<div>

...

</div>

)
```

Everything displayed in browser comes from here.

---

### JSX Layout

```
Student Details

↓

Name

↓

School

↓

Total

↓

Score
```

Every item is placed inside

```
div
```

for proper layout.

---

### Export

```javascript
export default CalculateScore;
```

Without export,

App.js cannot use the component.

---

# File 2 — mystyle.css

Purpose

Makes the UI attractive.

Without CSS

```
Black Text

Default Font

No Formatting
```

With CSS

```
Colored Text

Spacing

Alignment

Better Readability
```

---

### CSS Classes

```
.Name

↓

Blue
```

```
.School

↓

Crimson
```

```
.Total

↓

Dark Magenta
```

```
.Score

↓

Green
```

```
.formatstyle

↓

Center Alignment
```

---

### Why className?

React uses

```jsx
className
```

instead of

```html
class
```

Reason

```
class

↓

Reserved JavaScript Keyword
```

Therefore React introduced

```
className
```

---

# File 3 — App.js

Purpose

Acts as Parent Component.

---

Responsibilities

* Import Component
* Pass Data
* Render Component

---

Imports

```javascript
import CalculateScore from './Components/CalculateScore';
```

Without import

React cannot find the component.

---

Passing Props

```jsx
<CalculateScore

Name="Steeve"

School="DNV Public School"

total={284}

goal={3}

/>
```

This is exactly how the exercise passes data from the parent to the function component. 

---

Think of

App.js

as

```
Teacher

↓

Report Card
```

Teacher provides

* Name

* School

* Total

* Goal

Report card displays them.

---

# File 4 — index.js

Purpose

Start the application.

Flow

```
ReactDOM

↓

Find root

↓

Load App

↓

Display Browser
```

Code

```javascript
root.render(

<App/>

)
```

---

# 11. Configuration Explanation

---

# package.json

One of the most important files.

Example

```json
{

"name":"scorecalculatorapp"

}
```

Contains

```
Project Name

↓

Dependencies

↓

Scripts

↓

Version
```

---

### Dependencies

Example

```
react

react-dom

react-scripts
```

Without dependencies

React won't run.

---

### Scripts

Important commands

```
npm start

↓

Development Server
```

```
npm test

↓

Run Tests
```

```
npm run build

↓

Production Build
```

---

### What if package.json changes?

Removing

```
react
```

↓

Project breaks.

Removing

```
react-scripts
```

↓

Cannot start project.

---

# package-lock.json

Purpose

Locks versions.

Example

Without lock file

Developer A installs

```
React 19
```

Developer B installs

```
React 20
```

Different behaviour.

Lock file avoids this.

---

# .gitignore

Purpose

Prevent unnecessary files from Git.

Example

```
node_modules
```

Never upload

because

```
Very Large

Automatically Generated
```

---

# 12. Code Flow

```
User

↓

Open Browser

↓

React Starts

↓

App.js

↓

CalculateScore Component

↓

Receive Props

↓

Calculate Score

↓

Format Percentage

↓

Return JSX

↓

Browser Displays Output
```

---

## Detailed Flow

```
App.js

↓

Passes

↓

Name

School

Total

Goal

↓

CalculateScore

↓

calcScore()

↓

percentToDecimal()

↓

JSX Returned

↓

React Virtual DOM

↓

Real DOM

↓

Browser
```

---

# 13. Execution Flow

When you execute

```
npm start
```

React performs the following sequence:

```
Step 1

↓

Node starts Development Server

↓

Step 2

↓

Browser opens

↓

Step 3

↓

index.js executes

↓

Step 4

↓

App Component loads

↓

Step 5

↓

CalculateScore Component loads

↓

Step 6

↓

Props received

↓

Step 7

↓

Percentage calculated

↓

Step 8

↓

JSX generated

↓

Step 9

↓

Virtual DOM created

↓

Step 10

↓

Real DOM updated

↓

Output displayed
```

---

# 14. Internal Working of React

Understanding what React does behind the scenes is important.

---

## Step 1 — JSX Compilation

You write

```jsx
<h1>Hello</h1>
```

React (through Babel) converts it to

```javascript
React.createElement(...)
```

This is why browsers can understand JSX even though they do not support it directly.

---

## Step 2 — Component Execution

React calls the Function Component like a normal JavaScript function.

```
CalculateScore(props)
```

The returned JSX becomes a description of the UI.

---

## Step 3 — Virtual DOM Creation

React creates a lightweight in-memory representation called the **Virtual DOM**.

```
Function Component

↓

JSX

↓

Virtual DOM
```

---

## Step 4 — Diffing

When data changes,

React compares:

```
Old Virtual DOM

↓

New Virtual DOM
```

Only the differences are identified.

---

## Step 5 — Real DOM Update

Instead of refreshing the whole page,

React updates only the changed elements.

This is one of the reasons React applications are fast.

---

# 15. Function & Module Explanation

## Module: CalculateScore.js

### Purpose

Displays a student's details and calculated score.

### Inputs (Props)

| Prop   | Type   | Description                                                   |
| ------ | ------ | ------------------------------------------------------------- |
| Name   | String | Student's name                                                |
| School | String | School name                                                   |
| total  | Number | Marks obtained                                                |
| goal   | Number | Maximum marks / divisor used for calculation in this exercise |

### Internal Helper Functions

#### `percentToDecimal(decimal)`

**Purpose**

Formats a decimal number as a percentage string.

**Parameter**

| Parameter | Type   | Description                        |
| --------- | ------ | ---------------------------------- |
| decimal   | Number | Percentage value before formatting |

**Returns**

```
String

Example

94.67%
```

---

#### `calcScore(total, goal)`

**Purpose**

Calculates the percentage and formats it.

**Parameters**

| Parameter | Description             |
| --------- | ----------------------- |
| total     | Marks obtained          |
| goal      | Maximum marks / divisor |

**Returns**

Formatted percentage string.

---

# 16. Parent–Child Component Communication

One of the most important React concepts demonstrated in this project is **Props**.

```
Parent Component

(App.js)

        │

        │ Passes Data

        ▼

Child Component

(CalculateScore.js)

        │

        ▼

Displays Student Details
```

The child component **does not create the data**.

It only receives it from the parent and displays it.

This separation of responsibilities makes React applications modular, reusable, and easier to maintain.

---

# Exercise 3: Create a Function Component in React

## Week 5 – ReactJS Hands-on Lab

> **Response 3 of 4**

---

# Table of Contents

17. Sample Inputs and Outputs
18. How to Run the Project
19. Testing
20. Best Practices
21. Common Mistakes
22. Real-world Applications
23. Advantages
24. Limitations

---

# 17. Sample Inputs and Outputs

One of the biggest advantages of React components is that the **same component can be reused** with different data.

Instead of writing multiple components for different students, we simply pass different **props**.

---

## Example 1

### Input

```jsx
<CalculateScore
    Name="Steeve"
    School="DNV Public School"
    total={284}
    goal={3}
/>
```

### Processing

```
Score = total / goal

284 ÷ 3

↓

94.6666

↓

94.67%
```

### Output

```text
Student Details

Name : Steeve

School : DNV Public School

Total : 284 Marks

Score : 94.67%
```

This matches the implementation demonstrated in the hands-on document. 

---

## Example 2

### Input

```jsx
<CalculateScore
    Name="Rahul"
    School="ABC Public School"
    total={450}
    goal={500}
/>
```

### Output

```text
Student Details

Name : Rahul

School : ABC Public School

Total : 450 Marks

Score : 90.00%
```

---

## Example 3

### Input

```jsx
<CalculateScore
    Name="Anjali"
    School="XYZ High School"
    total={485}
    goal={500}
/>
```

### Output

```text
Student Details

Name : Anjali

School : XYZ High School

Total : 485 Marks

Score : 97.00%
```

---

## Example 4

### Input

```jsx
<CalculateScore
    Name="John"
    School="National School"
    total={300}
    goal={500}
/>
```

### Output

```text
Student Details

Name : John

School : National School

Total : 300 Marks

Score : 60.00%
```

---

# Reusability Demonstration

Instead of writing

```text
Student1 Component

Student2 Component

Student3 Component

Student4 Component
```

We simply reuse

```jsx
<CalculateScore />
```

with different values.

Example

```jsx
<CalculateScore
    Name="Rahul"
    School="ABC"
    total={420}
    goal={500}
/>

<CalculateScore
    Name="Priya"
    School="XYZ"
    total={480}
    goal={500}
/>

<CalculateScore
    Name="Aman"
    School="National"
    total={350}
    goal={500}
/>
```

Same component.

Different data.

---

# 18. How to Run the Project

---

## Step 1

Install Node.js

Verify installation

```bash
node -v
```

Example

```text
v22.17.0
```

---

## Step 2

Verify npm

```bash
npm -v
```

Example

```text
10.9.2
```

---

## Step 3

Create the project

```bash
npx create-react-app scorecalculatorapp
```

---

## Step 4

Move into the project

```bash
cd scorecalculatorapp
```

---

## Step 5

Open VS Code

```bash
code .
```

---

## Step 6

Create folders

```
Components

Stylesheets
```

---

## Step 7

Create files

```
CalculateScore.js

mystyle.css
```

---

## Step 8

Replace

```
App.js
```

with the implementation.

---

## Step 9

Start the development server

```bash
npm start
```

---

## Step 10

Browser automatically opens

```
http://localhost:3000
```

If it doesn't,

open manually.

---

# Build for Production

```bash
npm run build
```

Creates

```
build/
```

folder.

---

# Run Tests

```bash
npm test
```

Although this exercise does not include unit tests, Create React App provides the testing setup by default.

---

# Stop Server

```
Ctrl + C
```

---

# Useful npm Commands

| Command                  | Purpose                   |
| ------------------------ | ------------------------- |
| npm start                | Starts Development Server |
| npm test                 | Runs Test Runner          |
| npm run build            | Production Build          |
| npm install              | Installs Dependencies     |
| npm install package-name | Installs New Package      |

---

# 19. Testing

Testing ensures that the application behaves as expected.

---

## Functional Testing

Verify the following:

### Test 1

Application starts.

Expected

```text
Compiled Successfully
```

---

### Test 2

Browser opens.

Expected

```
http://localhost:3000
```

---

### Test 3

Student Details heading appears.

Expected

```
Student Details
```

---

### Test 4

Name displayed correctly.

---

### Test 5

School displayed correctly.

---

### Test 6

Total Marks displayed correctly.

---

### Test 7

Percentage calculated correctly.

Example

```
450

÷

500

=

90%
```

---

### Test 8

CSS colors applied.

Expected

* Blue
* Crimson
* Dark Magenta
* Green

---

### Test 9

Center alignment.

Expected

Everything displayed in the center.

---

### Test 10

No console errors.

Open

```
Developer Tools

↓

Console
```

Expected

```
No Errors
```

---

# Manual Testing Checklist

| Check              | Status |
| ------------------ | ------ |
| Application Starts | ✅      |
| Browser Opens      | ✅      |
| Props Received     | ✅      |
| Score Calculated   | ✅      |
| CSS Applied        | ✅      |
| Component Rendered | ✅      |
| No Errors          | ✅      |

---

# 20. Best Practices

---

## Keep Components Small

Good

```text
CalculateScore

↓

One Responsibility
```

Bad

```text
CalculateScore

↓

Login

↓

Database

↓

Payment

↓

Email
```

---

## Use Meaningful Names

Good

```jsx
CalculateScore
```

Bad

```jsx
A

Component1

Demo

Test
```

---

## Separate CSS

Good

```
Component

↓

CSS File
```

Avoid inline styling unless necessary.

---

## Reuse Components

Never duplicate code.

Always reuse.

---

## Keep Logic Separate

Good

```javascript
calcScore()
```

instead of

writing the calculation directly inside JSX.

---

## Use Props

Avoid hardcoding values inside components.

Instead,

pass data from the parent.

---

## Follow Folder Structure

```
Components

Stylesheets

Assets

Pages

Services
```

Organized projects are easier to maintain.

---

## Use Descriptive Variable Names

Good

```javascript
total

goal

percentage
```

Bad

```javascript
a

b

c
```

---

## Keep Components Pure

A Function Component should

* receive data
* process it
* return JSX

Avoid unnecessary side effects.

---

# 21. Common Mistakes

---

## Mistake 1

Forgetting export

Wrong

```javascript
function CalculateScore(){

}
```

Correct

```javascript
export default CalculateScore;
```

---

## Mistake 2

Wrong import path

Wrong

```javascript
import CalculateScore from './CalculateScore';
```

Correct

```javascript
import CalculateScore from './Components/CalculateScore';
```

---

## Mistake 3

Using class

Wrong

```html
<div class="box">
```

Correct

```jsx
<div className="box">
```

---

## Mistake 4

Forgetting CSS import

Wrong

```javascript
// No CSS import
```

Correct

```javascript
import '../Stylesheets/mystyle.css';
```

---

## Mistake 5

Using props incorrectly

Wrong

```jsx
<Name>
```

Correct

```jsx
{Name}
```

---

## Mistake 6

Typing errors

Example

```text
Component

↓

Components
```

One letter difference

↓

Import fails.

---

## Mistake 7

Division by zero

Example

```javascript
goal = 0
```

Always validate inputs in real-world applications before performing calculations.

---

## Mistake 8

Using incorrect JSX syntax

Wrong

```jsx
return

<h1>Hello</h1>
```

Correct

```jsx
return(
<h1>Hello</h1>
)
```

---

# 22. Real-world Applications

Although this project is simple, the concepts are widely used.

---

## Student Management Systems

```
Student Profile

Attendance

Marks

Grades
```

---

## Employee Portals

```
Employee Details

Salary

Department

Performance
```

---

## Banking Applications

```
Account Details

Balance

Transactions
```

---

## Hospital Management

```
Patient Details

Doctor

Diagnosis

Reports
```

---

## E-Commerce

```
Product Card

↓

Price

↓

Discount

↓

Rating
```

Each product is simply another instance of the same reusable component.

---

## Dashboard Applications

```
Weather Card

Stock Card

News Card

Analytics Card
```

Each card is usually implemented as a reusable Function Component.

---

## HR Systems

```
Employee Card

Department

Experience

Salary
```

---

## Social Media

```
User Profile

Post

Comment

Notification
```

Every screen is composed of reusable components.

---

# 23. Advantages

| Advantage              | Explanation                                                    |
| ---------------------- | -------------------------------------------------------------- |
| Reusable Components    | Write once and use multiple times with different props.        |
| Easy Maintenance       | Small components are easier to understand and modify.          |
| Better Readability     | Code is organized into focused files.                          |
| Faster Development     | Existing components can be reused instead of rewritten.        |
| Separation of Concerns | UI, logic, and styling are kept separate.                      |
| Modular Architecture   | Applications can grow without becoming difficult to manage.    |
| Easy Testing           | Small components are easier to test individually.              |
| Scalable               | Suitable for both small and large React applications.          |
| Modern Approach        | Function Components are the recommended style in modern React. |

---

# 24. Limitations

Although Function Components are powerful, this exercise has a few limitations.

---

## Static Data

The student information is hardcoded in `App.js`.

Real applications usually retrieve data from:

* Databases
* REST APIs
* GraphQL
* User Input

---

## No User Interaction

Users cannot edit the values.

A production application would use forms.

---

## No Validation

The component assumes valid input.

Real applications should validate:

* Empty names
* Negative marks
* Division by zero
* Invalid data types

---

## Single Student Display

Only one student's details are displayed.

A production application would render a list of students using arrays and the `map()` function.

---

## No State Management

The component does not use **State** or **Hooks**.

Those concepts are introduced in later React topics.

---

## No Backend Integration

The application runs entirely on the client side.

In enterprise applications, the data would typically come from a backend service or database.

---

# Exercise 3: Create a Function Component in React

## Week 5 – ReactJS Hands-on Lab

> **Response 4 of 4**

---

# Table of Contents

25. Frequently Asked Interview Questions
26. Quick Revision Notes
27. Important Commands Cheat Sheet
28. Important Files Summary
29. Workflow Recap
30. Key Takeaways
31. Conclusion
32. Next Steps

---

# 25. Frequently Asked Interview Questions

This section contains conceptual interview questions that are frequently asked in React interviews. Understanding these will strengthen your fundamentals.

---

# Q1. What is React?

### Answer

React is an **open-source JavaScript library** developed by **Meta (Facebook)** for building **User Interfaces (UI)**.

React follows a **Component-Based Architecture**, where an application is divided into multiple reusable components.

Instead of updating an entire webpage, React updates only the necessary parts using the **Virtual DOM**, making applications faster and more efficient.

---

# Q2. What is a Component?

### Answer

A Component is an independent, reusable block of UI.

Examples include:

* Header
* Footer
* Login Form
* Product Card
* Navigation Bar

Every React application is made up of components.

---

# Q3. What is a Function Component?

### Answer

A Function Component is a JavaScript function that returns JSX.

Example

```jsx
function Welcome() {
    return <h1>Hello React</h1>;
}
```

Modern React applications primarily use Function Components because they are simpler, cleaner, and support Hooks.

---

# Q4. Difference Between Function Component and Class Component

| Function Component  | Class Component        |
| ------------------- | ---------------------- |
| JavaScript Function | JavaScript Class       |
| Uses Hooks          | Uses Lifecycle Methods |
| Less Code           | More Boilerplate       |
| Easier to Learn     | More Complex           |
| Preferred Today     | Mostly Legacy Code     |

---

# Q5. What is JSX?

### Answer

JSX stands for **JavaScript XML**.

It allows developers to write HTML-like syntax inside JavaScript.

Example

```jsx
<h1>Hello React</h1>
```

Behind the scenes, Babel converts JSX into JavaScript (`React.createElement()`).

---

# Q6. What are Props?

### Answer

Props (Properties) are used to **pass data from a Parent Component to a Child Component**.

Example

```jsx
<CalculateScore
    Name="Rahul"
    School="ABC School"
/>
```

Inside the child component:

```jsx
const CalculateScore = ({ Name, School }) => {
    return <h2>{Name}</h2>;
};
```

Props are **read-only** and should not be modified inside the child component.

---

# Q7. Why do we use `className` instead of `class`?

### Answer

In JavaScript, `class` is a reserved keyword used for defining classes.

React uses `className` instead to apply CSS classes.

Example

```jsx
<div className="box">
```

---

# Q8. What is Component Reusability?

### Answer

Component Reusability means creating a component once and using it multiple times with different data.

Example

```jsx
<CalculateScore Name="Rahul" total={450} goal={500} />

<CalculateScore Name="Priya" total={480} goal={500} />
```

The same component is reused without duplicating code.

---

# Q9. What is the purpose of `export default`?

### Answer

`export default` makes a component available to other files.

Without it, the component cannot be imported.

Example

```javascript
export default CalculateScore;
```

---

# Q10. What is the purpose of `import`?

### Answer

`import` is used to include components, CSS files, or libraries into another file.

Example

```javascript
import CalculateScore from './Components/CalculateScore';
```

---

# Q11. What is Create React App (CRA)?

### Answer

Create React App is a tool that generates a ready-to-use React project with the required configuration, including Webpack, Babel, and development scripts.

Command

```bash
npx create-react-app scorecalculatorapp
```

---

# Q12. What is npm?

### Answer

npm (Node Package Manager) is used to install, update, and manage JavaScript packages.

Example

```bash
npm install
```

---

# Q13. Why do we use helper functions like `calcScore()`?

### Answer

Separating business logic into helper functions improves:

* Readability
* Reusability
* Maintainability
* Testing

Instead of embedding calculations directly inside JSX, dedicated functions keep the code organized.

---

# Q14. How does React render this application?

### Answer

1. `index.js` starts the application.
2. `App.js` is rendered.
3. `App.js` renders `CalculateScore`.
4. Props are passed.
5. The score is calculated.
6. JSX is returned.
7. React updates the Virtual DOM.
8. The browser displays the UI.

---

# Q15. What happens if Props change?

### Answer

When props change:

1. The Function Component executes again.
2. New JSX is generated.
3. React compares the new Virtual DOM with the old one.
4. Only the changed parts of the Real DOM are updated.

This process makes React efficient.

---

# 26. Quick Revision Notes

---

## React

* JavaScript library for building user interfaces.
* Developed by Meta.
* Uses reusable components.

---

## Function Component

* JavaScript function.
* Returns JSX.
* Preferred in modern React.
* Supports Hooks.

---

## JSX

* JavaScript XML.
* HTML-like syntax inside JavaScript.
* Converted to JavaScript by Babel.

---

## Props

* Pass data from Parent to Child.
* Read-only.
* Improve component reusability.

---

## CSS

* Stored in `Stylesheets/mystyle.css`.
* Imported into the component.
* Applied using `className`.

---

## Project Flow

```text
index.js
    │
    ▼
App.js
    │
    ▼
CalculateScore.js
    │
    ▼
Calculate Percentage
    │
    ▼
Return JSX
    │
    ▼
Browser
```

---

## Folder Structure

```text
scorecalculatorapp
│
├── src
│   ├── Components
│   │      └── CalculateScore.js
│   │
│   ├── Stylesheets
│   │      └── mystyle.css
│   │
│   ├── App.js
│   └── index.js
│
└── package.json
```

---

# 27. Important Commands Cheat Sheet

| Command                                   | Purpose                           |
| ----------------------------------------- | --------------------------------- |
| `node -v`                                 | Check Node.js version             |
| `npm -v`                                  | Check npm version                 |
| `npx create-react-app scorecalculatorapp` | Create a new React project        |
| `cd scorecalculatorapp`                   | Navigate to the project directory |
| `code .`                                  | Open the project in VS Code       |
| `npm install`                             | Install project dependencies      |
| `npm start`                               | Start the development server      |
| `npm test`                                | Run tests                         |
| `npm run build`                           | Create a production build         |
| `Ctrl + C`                                | Stop the development server       |

---

# 28. Important Files Summary

| File                | Purpose                                                                                     |
| ------------------- | ------------------------------------------------------------------------------------------- |
| `index.js`          | Entry point of the React application.                                                       |
| `App.js`            | Parent component that renders `CalculateScore`.                                             |
| `CalculateScore.js` | Function component that receives props, calculates the score, and displays student details. |
| `mystyle.css`       | External stylesheet that formats the UI.                                                    |
| `package.json`      | Project metadata, dependencies, and scripts.                                                |
| `package-lock.json` | Locks dependency versions for consistent installations.                                     |
| `public/index.html` | Contains the `<div id="root"></div>` where React mounts the application.                    |

---

# 29. Workflow Recap

The following diagram summarizes the complete workflow of the application.

```text
User Runs:
npm start
        │
        ▼
React Development Server Starts
        │
        ▼
Browser Opens
        │
        ▼
index.js Executes
        │
        ▼
App.js Loads
        │
        ▼
App Passes Props
(Name, School, Total, Goal)
        │
        ▼
CalculateScore Component Receives Props
        │
        ▼
calcScore() Calculates Percentage
        │
        ▼
percentToDecimal() Formats Output
        │
        ▼
JSX is Returned
        │
        ▼
Virtual DOM Created
        │
        ▼
Real DOM Updated
        │
        ▼
Student Details Displayed in Browser
```

---

# 30. Key Takeaways

After completing this exercise, you should be able to:

* Explain the purpose of React and Component-Based Architecture.
* Create and use Function Components.
* Write JSX to build user interfaces.
* Pass data using Props.
* Organize a React project into reusable components.
* Separate styling using external CSS.
* Understand the flow from `index.js` to `App.js` to child components.
* Explain how React renders components using the Virtual DOM.
* Reuse the same component with different data.
* Build simple, maintainable React applications.

---

# 31. Conclusion

This exercise marks an important transition from understanding React basics to writing modern React applications using **Function Components**.

By implementing the **Student Score Calculator**, you learned how to:

* Create reusable Function Components.
* Pass data using Props.
* Perform business logic inside helper functions.
* Format and display calculated results.
* Apply external CSS styling.
* Organize a React project into a clean and maintainable structure.

Although the application is intentionally simple, it demonstrates several core principles that are used in production React applications. The same ideas—component reuse, parent–child communication, separation of concerns, and declarative UI—scale from small educational projects to large enterprise systems.

The implementation in this README follows the structure and workflow described in the Cognizant hands-on exercise while expanding the explanations into a complete learning guide. 

---

# 32. Next Steps

Now that you understand Function Components, the next topics to learn are:

1. **React Hooks**

   * `useState`
   * `useEffect`
   * `useContext`

2. **Event Handling**

   * Button Clicks
   * Form Submission
   * Input Handling

3. **Conditional Rendering**

   * `if` Statements
   * Ternary Operator
   * Logical `&&`

4. **Lists and Keys**

   * Rendering Arrays
   * `map()` Function
   * Unique Keys

5. **Forms in React**

   * Controlled Components
   * Validation
   * Form State

6. **React Router**

   * Navigation
   * Routes
   * Dynamic URLs

7. **API Integration**

   * `fetch()`
   * Axios
   * REST APIs

8. **State Management**

   * Context API
   * Redux Toolkit


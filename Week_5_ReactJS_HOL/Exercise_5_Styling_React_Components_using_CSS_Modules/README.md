# Exercise 5: Styling React Components using CSS Modules

## Week 5 – ReactJS Hands-on Lab

> **Response 1 of 4**

---

# Table of Contents

1. Project Title
2. Introduction
3. Learning Objectives
4. Prerequisites
5. Background Concepts

   * What is Styling in React?
   * Why Styling is Important?
   * Different Ways to Style React Components
   * Inline Styling
   * Internal CSS
   * External CSS
   * CSS Modules
   * Difference Between CSS and CSS Modules
   * `className` vs `class`
   * `style` Property
   * Conditional Styling
   * Why CSS Modules are Used
6. Project Overview
7. High-Level Architecture
8. Technologies Used

---

# 1. Project Title

# Styling React Components using CSS Modules

**Week 5 – ReactJS Hands-on Lab**

**Exercise 5 – Styling React Components using CSS Modules**

---

# 2. Introduction

## What is this project?

This exercise focuses on **styling React components** using **CSS Modules** and **inline styles**.

The objective is to improve the appearance of an existing React application that displays information about training cohorts. According to the hands-on document, you are required to:

* Create a CSS Module named `CohortDetails.module.css`.
* Define a reusable `.box` class with specified layout and border properties.
* Style the `<dt>` HTML element.
* Import the CSS Module into the React component.
* Apply the `.box` class using `className`.
* Use the `style` property to display the cohort status in **green** for **ongoing** cohorts and **blue** for all other statuses. 

---

## Why is this project important?

React separates **structure**, **behavior**, and **presentation**.

* JSX defines the user interface.
* JavaScript controls the logic.
* CSS controls the appearance.

Without proper styling:

* Applications become difficult to read.
* Information is harder to distinguish.
* User experience decreases.

This exercise demonstrates how React applications can be styled in a clean and maintainable way.

---

## Real-world Example

Consider a Learning Management System (LMS).

Without styling:

```text
Java Full Stack
Ongoing
Coach: John
Trainer: David
```

With styling:

```text
+------------------------------+
| Java Full Stack              |
| Ongoing (Green)              |
| Coach: John                  |
| Trainer: David               |
+------------------------------+
```

The same information becomes easier to understand because styling improves readability.

---

## Where is this concept used?

Component styling is used in nearly every React application, including:

* Student Portals
* Banking Dashboards
* Hospital Management Systems
* E-Commerce Websites
* Social Media Platforms
* HR Portals
* Employee Dashboards
* Analytics Applications

---

# 3. Learning Objectives

After completing this exercise, you should be able to:

* Understand the need for styling React components.
* Create and use CSS Modules.
* Apply styles using `className`.
* Apply inline styles using the `style` property.
* Understand conditional styling.
* Differentiate between CSS Modules and traditional CSS.
* Build reusable, component-specific styles.

These objectives are based on the learning outcomes listed in the uploaded hands-on exercise. 

---

# 4. Prerequisites

Before starting this exercise, ensure the following software is installed.

| Software           | Purpose            |
| ------------------ | ------------------ |
| Node.js            | JavaScript Runtime |
| npm                | Package Manager    |
| Visual Studio Code | Code Editor        |
| React              | UI Library         |

Basic knowledge required:

* HTML
* CSS
* JavaScript
* React Components
* JSX
* ES6 Syntax

The uploaded lab also lists Node.js, npm, and Visual Studio Code as prerequisites. 

---

# 5. Background Concepts

---

# 5.1 What is Styling in React?

## Definition

Styling in React refers to the process of changing the appearance of React components using CSS.

Styling controls:

* Colors
* Fonts
* Borders
* Margins
* Padding
* Layout
* Alignment

---

## Why is Styling Needed?

Imagine two dashboards.

Without Styling

```text
Student
Marks
Attendance
Faculty
```

With Styling

```text
+----------------------------+

Student Dashboard

Marks

Attendance

Faculty

+----------------------------+
```

The second interface is much easier to read.

---

## Real-world Analogy

Think of constructing a house.

* Bricks represent the structure (HTML/JSX).
* Electrical wiring represents the logic (JavaScript).
* Paint, furniture, and decoration represent CSS.

The house functions without decoration, but styling makes it visually appealing and easier to use.

---

# 5.2 Different Ways to Style React Components

React supports several approaches for styling.

### 1. Inline Styling

```jsx
<h1 style={{color:"green"}}>

Welcome

</h1>
```

Properties are written directly inside the JSX element.

---

### 2. Internal CSS

Styles are defined inside the same JavaScript file.

Example:

```javascript
const headingStyle = {

color:"blue"

}
```

Used as

```jsx
<h1 style={headingStyle}>
```

---

### 3. External CSS

Create

```text
App.css
```

Import

```javascript
import "./App.css";
```

Apply

```jsx
<h1 className="heading">
```

---

### 4. CSS Modules

Create

```text
Component.module.css
```

Import

```javascript
import styles from "./Component.module.css";
```

Use

```jsx
<div className={styles.box}>
```

This is the styling approach required by the uploaded hands-on exercise. 

---

# 5.3 What is Inline Styling?

## Definition

Inline Styling means writing CSS directly inside a JSX element using the `style` property.

Example

```jsx
<h3
style={{
color:"green"
}}
>
```

---

## Why use Inline Styling?

Useful when styles depend on conditions.

Example

```jsx
color:
status==="ongoing"

?

"green"

:

"blue"
```

This matches the requirement in the exercise to display:

* Green for **ongoing**
* Blue otherwise. 

---

# 5.4 What is a CSS Module?

## Definition

A CSS Module is a CSS file whose class names are scoped locally to the component that imports it.

File name:

```text
Component.module.css
```

Example

```text
CohortDetails.module.css
```

---

## Why use CSS Modules?

Suppose two components both define:

```css
.box
```

With normal CSS:

```text
.box

↓

Global

↓

Conflict Possible
```

With CSS Modules:

```text
.box

↓

Component Specific

↓

No Conflict
```

This prevents style collisions between components.

---

# 5.5 Difference Between CSS and CSS Modules

| Normal CSS                           | CSS Modules                           |
| ------------------------------------ | ------------------------------------- |
| Global scope                         | Local scope                           |
| Class name conflicts possible        | No class name conflicts               |
| Imported as CSS                      | Imported as a JavaScript object       |
| Uses `className="box"`               | Uses `className={styles.box}`         |
| Less suitable for large applications | Better suited for reusable components |

---

# 5.6 `className` vs `class`

In HTML

```html
<div class="box">
```

In React

```jsx
<div className="box">
```

### Why?

`class` is a reserved keyword in JavaScript.

React therefore uses

```text
className
```

instead.

---

# 5.7 The `style` Property

The `style` property accepts a JavaScript object.

Example

```jsx
style={{

color:"green",

fontWeight:"bold"

}}
```

Notice

```text
CSS

font-weight
```

becomes

```text
JavaScript

fontWeight
```

using camelCase.

---

# 5.8 Conditional Styling

Conditional styling changes the appearance of an element depending on data.

Example

```jsx
style={{
color:
status==="ongoing"

?

"green"

:

"blue"
}}
```

If

```text
Status = Ongoing
```

↓

Green

If

```text
Status = Completed
```

↓

Blue

This is exactly the behavior required in the lab instructions. 

---

# 5.9 Why CSS Modules are Preferred

Advantages include:

* Local scope
* Better organization
* Reusable styles
* Prevent naming conflicts
* Easier maintenance
* Cleaner project structure

Large React applications commonly use CSS Modules to keep component styles isolated.

---

# 6. Project Overview

The hands-on describes an existing React application that displays information about **ongoing** and **completed** training cohorts. Your task is to style this application by:

* Creating a CSS Module.
* Defining a `.box` class with specific dimensions and border properties.
* Styling the `<dt>` element.
* Applying the CSS Module to the component.
* Using inline styles to color the cohort status based on its value. 

---

# 7. High-Level Architecture

```text
                User Opens Browser
                        │
                        ▼
                React Application
                        │
                        ▼
                    App Component
                        │
                        ▼
             CohortDetails Component
                        │
        ┌───────────────┼───────────────┐
        ▼               ▼               ▼
   CSS Module      Inline Style      Cohort Data
        │               │               │
        └───────────────┼───────────────┘
                        ▼
                Styled Cohort Card
```

---

# 8. Technologies Used

| Technology                                        | Purpose                                                          |
| ------------------------------------------------- | ---------------------------------------------------------------- |
| **React**                                         | Builds reusable user interface components.                       |
| **JavaScript (ES6)**                              | Implements component logic and conditional styling.              |
| **JSX**                                           | Combines HTML-like syntax with JavaScript to describe the UI.    |
| **CSS Modules**                                   | Provides locally scoped component styles.                        |
| **Inline Styles**                                 | Applies dynamic styles based on runtime data.                    |
| **HTML Definition List (`<dl>`, `<dt>`, `<dd>`)** | Displays labeled cohort information as required by the exercise. |
| **Node.js**                                       | JavaScript runtime for development.                              |
| **npm**                                           | Installs and manages project dependencies.                       |
| **Visual Studio Code**                            | Used to develop and edit the React project.                      |

---

# Exercise 5: Styling React Components using CSS Modules

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

15. Code Flow

16. Execution Flow

---

# 9. Project Structure

Since the uploaded hands-on references an **attached React application** that is not included, the following structure represents the reconstructed implementation created from the available requirements. The original starter project structure cannot be verified from the document alone. 

```text
cohorttracker
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
│   ├── Components/
│   │     ├── CohortDetails.js
│   │     └── CohortDetails.module.css
│   │
│   ├── App.js
│   ├── App.css
│   ├── data.js
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

Contains every npm package installed for the project.

Examples include:

```text
react

react-dom

react-scripts

babel

webpack
```

---

## Why is it needed?

Whenever we execute

```bash
npm install
```

npm downloads all required dependencies into this folder.

---

# public

Contains files served directly by the browser.

```text
public

│

├── index.html

├── favicon.ico

├── manifest.json

└── robots.txt
```

---

## Important File

### index.html

Contains

```html
<div id="root"></div>
```

React renders the complete application inside this element.

---

# src

Contains all application source code.

```text
src

│

├── Components

├── App.js

├── data.js

├── index.js
```

---

# Components

Stores reusable React components.

For this exercise:

```text
Components

│

├── CohortDetails.js

└── CohortDetails.module.css
```

---

# App.js

Acts as the parent component.

Responsibilities:

* Displays page heading
* Reads cohort data
* Renders each cohort card

---

# data.js

Stores sample cohort information.

Every object represents one training cohort.

---

# index.js

Entry point of the application.

Responsible for rendering

```text
<App />
```

inside

```text
root
```

---

# App.css

Contains global styling for the App component.

---

# CohortDetails.module.css

Contains component-specific styles.

According to the uploaded lab, this file should contain:

* `.box`
* `<dt>` styling

using CSS Modules. 

---

# 11. File-by-File Explanation

---

# File 1 — index.js

Purpose

Application Entry Point.

Flow

```text
ReactDOM

↓

Find root

↓

Load App

↓

Browser
```

Main responsibilities

* Import React
* Import ReactDOM
* Import App
* Render App

---

# File 2 — App.js

Purpose

Acts as Parent Component.

Responsibilities

```text
Import Data

↓

Loop Through Data

↓

Display CohortDetails
```

---

### Why map()?

Suppose there are four cohorts.

Instead of writing

```jsx
<CohortDetails />

<CohortDetails />

<CohortDetails />
```

we use

```javascript
cohorts.map(...)
```

React automatically creates one component for every cohort.

---

### Data Flow

```text
data.js

↓

App.js

↓

CohortDetails
```

---

# File 3 — data.js

Purpose

Store sample cohort information.

Example structure

```javascript
{

id,

name,

status,

startedOn,

coach,

trainer

}
```

---

Why create a separate file?

Benefits

* Reusable
* Cleaner code
* Easier maintenance
* Better organization

---

# File 4 — CohortDetails.js

This is the most important file.

Responsibilities

```text
Receive Props

↓

Apply CSS Module

↓

Apply Inline Style

↓

Display Cohort Information
```

---

## Props

The component receives

```javascript
cohort
```

from App.js.

Example

```javascript
<CohortDetails

cohort={cohort}

/>
```

---

Inside the component

```javascript
function CohortDetails({cohort})
```

Now the component can access

```text
cohort.name

cohort.status

cohort.startedOn
```

---

# CSS Module Import

The uploaded exercise specifically instructs importing the CSS Module. 

Example

```javascript
import styles from "./CohortDetails.module.css";
```

---

# Applying CSS Module

Instead of

```jsx
className="box"
```

React uses

```jsx
className={styles.box}
```

Why?

Because CSS Modules generate unique class names internally.

This prevents naming conflicts.

---

# Inline Styling

The exercise asks for

Green

↓

Ongoing

Blue

↓

All Other Status

Example

```jsx
style={{

color:

status==="ongoing"

?

"green"

:

"blue"

}}
```

This is called **Conditional Styling**.

---

# Displaying Details

Information is displayed using

```html
<dl>

<dt>

<dd>
```

Why?

Definition Lists naturally represent

```text
Label

↓

Value
```

Example

```text
Started On

22-Feb-2024
```

---

# File 5 — CohortDetails.module.css

Purpose

Store component-specific CSS.

The uploaded exercise instructs creating this file and defining:

* `.box`
* `dt`

styles. 

---

## .box

Responsibilities

```text
Width

↓

Border

↓

Padding

↓

Margin

↓

Border Radius
```

---

## dt

Purpose

Increase heading visibility.

Required style

```css
font-weight:500;
```

This value is specified directly in the lab instructions. 

---

# 12. Configuration Explanation

---

# package.json

Contains

```text
Project Name

↓

Dependencies

↓

Scripts
```

Important dependencies

```text
react

react-dom

react-scripts
```

---

# Scripts

```text
npm start

↓

Development Server
```

```text
npm run build

↓

Production Build
```

```text
npm test

↓

Testing
```

---

# package-lock.json

Purpose

Ensure consistent dependency versions.

Without it

Different developers

↓

Different package versions

↓

Different behavior

---

# index.html

Contains

```html
<div id="root"></div>
```

React injects the application here.

---

# 13. Implementation Explanation

Overall implementation sequence

```text
Create React Project

↓

Create Components Folder

↓

Create CSS Module

↓

Create Data File

↓

Import CSS Module

↓

Apply className

↓

Apply Inline Style

↓

Display Dashboard

↓

Run Application
```

The styling steps (creating the CSS Module, applying the `.box` class, styling `<dt>`, and using inline styles for status colors) are taken directly from the uploaded hands-on exercise. 

---

# 14. Internal Working

---

## Step 1

Application Starts

```text
npm start
```

↓

Development Server

---

## Step 2

React executes

```text
index.js
```

---

## Step 3

React renders

```text
<App/>
```

---

## Step 4

App imports

```text
data.js
```

---

## Step 5

Data is stored inside

```text
cohorts
```

array.

---

## Step 6

App loops

```text
map()
```

through the array.

---

## Step 7

Each iteration creates

```text
<CohortDetails/>
```

---

## Step 8

Component receives

```text
Props
```

---

## Step 9

CSS Module is imported.

---

## Step 10

React applies

```text
styles.box
```

to the card.

---

## Step 11

React evaluates

```text
status
```

If

```text
Ongoing
```

↓

Green

Else

↓

Blue

---

## Step 12

Browser displays the styled dashboard.

---

# 15. Code Flow

```text
User Opens Browser

↓

index.js

↓

App.js

↓

Import Data

↓

Map Through Cohorts

↓

Create CohortDetails Components

↓

Import CSS Module

↓

Apply Box Style

↓

Apply Conditional Color

↓

Render Browser
```

---

# 16. Execution Flow

```text
npm start

↓

React Starts

↓

Browser Opens

↓

App Component

↓

Read Data

↓

Render Cohort Cards

↓

Apply CSS Module

↓

Apply Inline Styling

↓

Display Final Dashboard
```

---

# Exercise 5: Styling React Components using CSS Modules

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

> **Note:** The uploaded lab document does **not** provide sample cohort data. The following examples are based on the reconstructed implementation created to demonstrate the styling requirements. 

---

# Sample Input

Example data in

```text
data.js
```

```javascript
const cohorts = [

    {

        id:1,

        name:"INTADMDF10 .NET FSD",

        status:"Ongoing",

        startedOn:"22-Feb-2024",

        currentCoach:"John Smith",

        currentTrainer:"David"

    },

    {

        id:2,

        name:"ADM21JF014 Java FSD",

        status:"Completed",

        startedOn:"10-Jan-2024",

        currentCoach:"Michael",

        currentTrainer:"Williams"

    }

];
```

---

# Expected Output

```text
--------------------------------------------

Cognizant Academy Dashboard

--------------------------------------------

INTADMDF10 .NET FSD

Ongoing        ← Green

Started On
22-Feb-2024

Current Coach
John Smith

Current Trainer
David

--------------------------------------------

ADM21JF014 Java FSD

Completed      ← Blue

Started On
10-Jan-2024

Current Coach
Michael

Current Trainer
Williams
```

---

# Color Logic

```text
Status

↓

Ongoing

↓

Green
```

```text
Status

↓

Completed

↓

Blue
```

This matches the styling behavior described in the uploaded exercise. 

---

# CSS Module Effect

Without CSS Module

```text
Card

↓

No Border

↓

No Padding

↓

Difficult to Read
```

After CSS Module

```text
Card

↓

Border

↓

Padding

↓

Rounded Corners

↓

Better UI
```

---

# 15. How to Run the Project

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

---

## Step 3

Create React Project

```bash
npx create-react-app cohorttracker
```

---

## Step 4

Move into project

```bash
cd cohorttracker
```

---

## Step 5

Open VS Code

```bash
code .
```

---

## Step 6

Replace

```text
App.js

App.css

index.js

index.css
```

---

## Step 7

Create

```text
Components

↓

CohortDetails.js

↓

CohortDetails.module.css
```

---

## Step 8

Create

```text
data.js
```

---

## Step 9

Run

```bash
npm start
```

---

## Step 10

Browser

```text
http://localhost:3000
```

---

# Build for Production

```bash
npm run build
```

Creates

```text
build/
```

folder.

---

# Run Tests

```bash
npm test
```

Although this exercise focuses on styling, Create React App provides the default testing environment.

---

# Stop Server

```text
Ctrl + C
```

---

# Useful Commands

| Command       | Purpose          |
| ------------- | ---------------- |
| npm install   | Install Packages |
| npm start     | Start React      |
| npm test      | Run Tests        |
| npm run build | Production Build |
| Ctrl + C      | Stop Server      |

---

# 16. Testing

---

## Test 1

Application starts.

Expected

```text
Compiled Successfully
```

---

## Test 2

Dashboard displayed.

Expected

```text
Cognizant Academy Dashboard
```

---

## Test 3

Multiple cards displayed.

Expected

```text
Four Cards
```

(or the number of cohorts present in your data source).

---

## Test 4

Border Applied

Expected

```text
1px Black Border
```

---

## Test 5

Rounded Corners

Expected

```text
10px Border Radius
```

---

## Test 6

Card Width

Expected

```text
300px
```

---

## Test 7

Padding

Expected

```text
10px 20px
```

---

## Test 8

Definition Title

Expected

```text
font-weight:500
```

for

```html
<dt>
```

---

## Test 9

Status Color

Expected

```text
Ongoing

↓

Green
```

---

## Test 10

Completed Status

Expected

```text
Completed

↓

Blue
```

---

# Manual Testing Checklist

| Test                | Status |
| ------------------- | ------ |
| React Runs          | ✅      |
| Cards Displayed     | ✅      |
| CSS Module Imported | ✅      |
| Border Applied      | ✅      |
| Padding Applied     | ✅      |
| Margin Applied      | ✅      |
| Width Correct       | ✅      |
| Status Green        | ✅      |
| Status Blue         | ✅      |

The checklist verifies the styling requirements described in the uploaded hands-on exercise. 

---

# 17. Best Practices

---

## Keep CSS Inside CSS Modules

Good

```text
CohortDetails.module.css
```

Avoid placing all styles inside one large global CSS file.

---

## Use Meaningful Class Names

Good

```css
.box
```

Bad

```css
.a

.demo

.test
```

---

## Use Inline Styling Only for Dynamic Values

Good

```jsx
style={{

color:

status==="ongoing"

?

"green"

:

"blue"

}}
```

Static styles should remain in CSS Modules.

---

## Separate Data

Instead of writing

```jsx
<Card

name="Java"

coach="John"
/>
```

Store information in

```text
data.js
```

---

## Reuse Components

Instead of

```jsx
<Card/>

<Card/>

<Card/>
```

Use

```javascript
map()
```

---

## Keep CSS Local

Using CSS Modules prevents global conflicts between components.

---

## Keep Components Small

Each component should perform a single responsibility.

Example

```text
App

↓

Dashboard
```

```text
CohortDetails

↓

Display One Card
```

---

# 18. Common Mistakes

---

## Mistake 1

Using

```html
class
```

instead of

```jsx
className
```

Wrong

```jsx
<div class="box">
```

Correct

```jsx
<div className={styles.box}>
```

---

## Mistake 2

Wrong CSS Module Import

Wrong

```javascript
import "./CohortDetails.css";
```

Correct

```javascript
import styles from "./CohortDetails.module.css";
```

---

## Mistake 3

Using

```jsx
className="box"
```

instead of

```jsx
className={styles.box}
```

---

## Mistake 4

Wrong File Name

Wrong

```text
CohortDetails.css
```

Correct

```text
CohortDetails.module.css
```

---

## Mistake 5

Wrong Style Property

Wrong

```jsx
font-weight
```

Correct

```jsx
fontWeight
```

because JSX uses camelCase.

---

## Mistake 6

Incorrect Comparison

Wrong

```javascript
status="ongoing"
```

Correct

```javascript
status==="ongoing"
```

---

## Mistake 7

Wrong Folder Name

Wrong

```text
component
```

Correct

```text
Components
```

---

## Mistake 8

Not Exporting Component

Wrong

```javascript
function CohortDetails(){

}
```

Correct

```javascript
export default CohortDetails;
```

---

# 19. Real-world Applications

---

## Student Management Systems

Student Cards

↓

Styled Dashboard

---

## Banking

Customer Details

↓

Account Cards

---

## Hospital

Patient Records

↓

Information Cards

---

## HR Portal

Employee Profiles

↓

Styled Cards

---

## E-Commerce

Products

↓

Product Cards

---

## Social Media

Profile Cards

↓

Styled Components

---

## Learning Management Systems

Training Cohorts

↓

Dashboard Cards

This exercise models a simplified version of that type of dashboard.

---

## Analytics Dashboard

Statistics

↓

Information Panels

---

# 20. Advantages

| Advantage           | Explanation                                                           |
| ------------------- | --------------------------------------------------------------------- |
| Component Isolation | CSS Modules prevent style conflicts by scoping classes locally.       |
| Better Readability  | Styles are organized close to the component that uses them.           |
| Dynamic Styling     | Inline styles allow values such as colors to change based on data.    |
| Reusability         | Components and their styles can be reused throughout the application. |
| Maintainability     | Easier to modify a single component without affecting others.         |
| Cleaner UI          | Borders, spacing, and layout improve the user experience.             |
| Scalability         | Suitable for medium and large React applications.                     |

---

# 21. Limitations

Because the uploaded exercise only focuses on styling, the reconstructed implementation has some limitations.

---

## Missing Starter Project

The hands-on references an attached React application, but it was not included with the uploaded document. Therefore, the example application structure and sample data are reconstructed rather than taken from the original project. 

---

## Static Data

The reconstructed project uses hardcoded cohort data.

Production systems typically retrieve this information from a REST API or database.

---

## No State Management

The exercise does not introduce:

* `useState`
* `Context API`
* Redux

---

## No Routing

The application displays a single dashboard.

Navigation between pages is not included.

---

## Basic Styling Only

The lab focuses on:

* CSS Modules
* Inline Styling

Advanced styling techniques such as CSS preprocessors, Tailwind CSS, or CSS-in-JS are outside the scope of this exercise.

---

# Exercise 5: Styling React Components using CSS Modules

## Week 5 – ReactJS Hands-on Lab

> **Response 4 of 4**

---

# Table of Contents

22. Frequently Asked Interview Questions

23. Quick Revision Notes

24. Important Commands Cheat Sheet

25. Important Files Summary

26. CSS Modules Cheat Sheet

27. Complete Workflow Summary

28. Key Takeaways

29. Conclusion

30. Next Learning Path

---

# 22. Frequently Asked Interview Questions

---

## Q1. What is Styling in React?

### Answer

Styling in React refers to changing the appearance of React components using CSS.

Styling controls:

* Colors
* Fonts
* Borders
* Margin
* Padding
* Layout
* Positioning

---

## Q2. Why is Styling important?

### Answer

Without styling,

applications become difficult to understand.

Styling improves:

* User Experience
* Readability
* Navigation
* Professional Appearance

---

## Q3. What are the different ways to style React components?

### Answer

React supports four common methods:

* Inline Styling
* Internal Styling
* External CSS
* CSS Modules

---

## Q4. What is Inline Styling?

### Answer

Inline Styling means writing CSS directly inside JSX using the

```text id="ywrtrf"
style
```

property.

Example

```jsx id="7ax1cf"
<h1
style={{
color:"red"
}}
>
Hello
</h1>
```

---

## Q5. What is a CSS Module?

### Answer

A CSS Module is a CSS file whose class names are scoped locally to the component that imports it.

Example

```text id="lqm0kl"
CohortDetails.module.css
```

---

## Q6. Why are CSS Modules preferred?

### Answer

Advantages include:

* Local Scope
* No Naming Conflicts
* Better Organization
* Reusable Components
* Easier Maintenance

---

## Q7. What is the difference between CSS and CSS Modules?

| Normal CSS                | CSS Modules                   |
| ------------------------- | ----------------------------- |
| Global Scope              | Local Scope                   |
| Naming Conflicts Possible | No Conflicts                  |
| Imported Normally         | Imported as JavaScript Object |
| Uses className="box"      | Uses className={styles.box}   |

---

## Q8. Why do we use `className` instead of `class`?

### Answer

`class` is a reserved keyword in JavaScript.

React therefore uses

```text id="gqahdy"
className
```

---

## Q9. Why is `style` written as a JavaScript object?

### Answer

JSX is JavaScript.

Therefore,

style values must be written as JavaScript objects.

Example

```jsx id="djsm8v"
style={{

color:"green"

}}
```

---

## Q10. Why do CSS properties use camelCase?

### Answer

React follows JavaScript naming conventions.

Example

CSS

```text id="pjlwm5"
font-weight
```

React

```text id="nmn1dz"
fontWeight
```

---

## Q11. What is Conditional Styling?

### Answer

Conditional Styling changes CSS based on a condition.

Example

```jsx id="pd7nsd"
style={{

color:

status==="ongoing"

?

"green"

:

"blue"

}}
```

The uploaded exercise specifically requires this behavior for the cohort status. 

---

## Q12. Why use CSS Modules instead of global CSS?

### Answer

Because global CSS may create conflicts when different components use the same class names.

CSS Modules isolate styles to the component that imports them.

---

## Q13. What does `styles.box` mean?

### Answer

After importing

```javascript id="e76l4s"
import styles from "./CohortDetails.module.css";
```

React converts CSS class names into JavaScript object properties.

Therefore

```jsx id="dtgqeb"
styles.box
```

refers to the locally scoped `.box` class.

---

## Q14. Why do we import CSS Modules?

### Answer

To access locally scoped CSS classes inside the component.

---

## Q15. What is the purpose of the `.box` class?

### Answer

According to the exercise,

it provides

* Width
* Border
* Margin
* Padding
* Rounded Corners

for each cohort card. 

---

## Q16. Why use `<dl>`, `<dt>`, and `<dd>`?

### Answer

They represent a **definition list**, which is useful for displaying label–value pairs.

Example

```text id="yudmql"
Started On

22-Feb-2024
```

---

## Q17. Why do we use `map()`?

### Answer

`map()` creates one React component for each item in an array.

---

## Q18. Why is `key` required?

### Answer

The `key` prop uniquely identifies each item in a rendered list, allowing React to update the UI efficiently.

---

## Q19. Can CSS Modules contain tag selectors?

### Answer

Yes.

The exercise instructs defining a style for the `<dt>` element using a tag selector with:

```css id="muuhkt"
font-weight:500;
```



---

## Q20. What are the benefits of component-based styling?

### Answer

* Better organization
* Easier debugging
* Reusable components
* Reduced style conflicts

---

# 23. Quick Revision Notes

---

## Ways to Style React

```text id="j33j2v"
Inline

↓

Internal

↓

External

↓

CSS Modules
```

---

## CSS Module Import

```javascript id="woc5vh"
import styles from "./CohortDetails.module.css";
```

---

## Apply CSS Module

```jsx id="b3cym6"
<div className={styles.box}>
```

---

## Inline Style

```jsx id="gdb4km"
style={{

color:"green"

}}
```

---

## Conditional Style

```text id="g0pw6n"
Status

↓

Ongoing

↓

Green
```

```text id="ffefyo"
Status

↓

Completed

↓

Blue
```

---

## CSS Module File

```text id="z0aw6d"
Component.module.css
```

---

## Required CSS

```css id="8rprqz"
.box{

width:300px;

display:inline-block;

margin:10px;

padding:10px 20px;

border:1px solid black;

border-radius:10px;

}
```

These properties come directly from the uploaded lab instructions. 

---

# 24. Important Commands Cheat Sheet

| Command                              | Purpose                 |
| ------------------------------------ | ----------------------- |
| `node -v`                            | Check Node.js version   |
| `npm -v`                             | Check npm version       |
| `npx create-react-app cohorttracker` | Create React project    |
| `cd cohorttracker`                   | Enter project folder    |
| `code .`                             | Open VS Code            |
| `npm install`                        | Install dependencies    |
| `npm start`                          | Run development server  |
| `npm test`                           | Execute tests           |
| `npm run build`                      | Create production build |
| `Ctrl + C`                           | Stop development server |

---

# 25. Important Files Summary

| File                       | Purpose                                                                |
| -------------------------- | ---------------------------------------------------------------------- |
| `index.js`                 | Entry point that renders the React application.                        |
| `App.js`                   | Parent component that displays the dashboard.                          |
| `App.css`                  | Global styling for the application.                                    |
| `data.js`                  | Stores cohort data (reconstructed example).                            |
| `CohortDetails.js`         | Displays a single cohort and applies CSS Modules plus inline styling.  |
| `CohortDetails.module.css` | Contains the `.box` class and `<dt>` styling required by the exercise. |
| `package.json`             | Project configuration and dependencies.                                |

---

# 26. CSS Modules Cheat Sheet

## Naming Convention

```text id="njlwmg"
Component.module.css
```

Example

```text id="13g94u"
CohortDetails.module.css
```

---

## Import

```javascript id="zydd1g"
import styles from "./CohortDetails.module.css";
```

---

## Apply Class

```jsx id="nbubml"
<div className={styles.box}>
```

---

## Local Scope

```text id="qd2mhm"
Component

↓

Own CSS

↓

No Conflict
```

---

## Conditional Color

```jsx id="3j9h7m"
style={{

color:

status==="ongoing"

?

"green"

:

"blue"

}}
```

---

# 27. Complete Workflow Summary

```text id="79uycc"
Create React Project

        │

        ▼

Create CSS Module

        │

        ▼

Define .box Style

        │

        ▼

Define dt Style

        │

        ▼

Import CSS Module

        │

        ▼

Apply styles.box

        │

        ▼

Read Cohort Data

        │

        ▼

Display Cohort Card

        │

        ▼

Apply Inline Color

        │

        ▼

Render Dashboard
```

The styling workflow above follows the sequence described in the uploaded hands-on exercise. 

---

# 28. Key Takeaways

After completing this exercise, you should understand:

* Why styling is essential in React.
* Different ways to style React components.
* How CSS Modules isolate styles.
* How to import and use CSS Modules.
* The difference between `class` and `className`.
* How to use the `style` property.
* How to implement conditional styling.
* How component-specific styling improves maintainability.

---

# 29. Conclusion

This exercise introduces one of the most important concepts in React UI development: **component styling**.

By completing this hands-on, you learned how to:

* Create and use a CSS Module.
* Apply reusable styles through `className`.
* Use inline styles for dynamic values.
* Style HTML definition list elements.
* Display different colors based on application data.

Although the uploaded lab references an attached starter application that was not available, the documented styling requirements demonstrate how React combines **JSX**, **CSS Modules**, and **inline styles** to build clean and maintainable user interfaces. 

---

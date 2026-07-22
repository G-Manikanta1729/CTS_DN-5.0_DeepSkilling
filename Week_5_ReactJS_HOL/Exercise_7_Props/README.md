# Exercise 7: Props

## Week 5 – ReactJS Hands-on Lab

> **Response 1 of 4**

---

# Table of Contents

1. Project Title

2. Introduction

3. Learning Objectives

4. Prerequisites

5. Background Concepts

* What are Props?
* Why Props are Needed?
* Features of Props
* What are Default Props?
* What is `reactDOM.render()` / `ReactDOM.createRoot().render()`?
* Difference Between State and Props
* Parent and Child Components
* Data Flow in React
* Project Overview
* High-Level Architecture
* Technologies Used

---

# 1. Project Title

# React Props – Shopping Cart Application

**Week 5 – ReactJS Hands-on Lab**

**Exercise 7 – Props**

---

# 2. Introduction

## What is this project?

This hands-on exercise introduces one of the most fundamental concepts in React: **Props (Properties)**.

According to the uploaded lab, the application named **shoppingapp** consists of two class components:

* **OnlineShopping**
* **Cart**

The `OnlineShopping` component creates an array containing five shopping items and passes it to the `Cart` component using **Props**. The `Cart` component then displays the item names and prices in a table. The learning objectives also include understanding **Default Props**, the **difference between State and Props**, and **reactDOM.render()**. 

---

## Why is this project important?

React applications are built by combining multiple components.

However, these components often need to communicate with one another.

For example:

* An online shopping website sends product information to product cards.
* A student portal sends student details to profile components.
* A banking application sends account information to account summary pages.

This communication is achieved using **Props**.

Without Props, components cannot easily share data.

---

## Real-world Example

Consider an online shopping website.

```text
Amazon

↓

Product List

↓

Product Card

↓

Display Product Information
```

The Product List component stores the products.

Each Product Card receives one product through **Props** and displays it.

The same concept is implemented in this exercise.

---

## Where are Props Used?

Props are commonly used in:

* E-Commerce Websites
* Banking Applications
* Hospital Management Systems
* Student Management Systems
* Employee Dashboards
* Food Delivery Applications
* Social Media Platforms
* Learning Management Systems

---

# 3. Learning Objectives

According to the uploaded hands-on lab, after completing this exercise you should understand:

* Define Props.
* Explain Default Props.
* Identify the differences between State and Props.
* Explain `reactDOM.render()`.
* Use Props.
* Apply `reactDOM.render()`. 

---

# 4. Prerequisites

The uploaded lab lists the following prerequisites:

| Software           | Purpose            |   |
| ------------------ | ------------------ | - |
| Node.js            | JavaScript Runtime |   |
| npm                | Package Manager    |   |
| Visual Studio Code | Code Editor        |   |

Additionally, this exercise requires a React application created using Create React App.

---

# 5. Background Concepts

---

# 5.1 What are Props?

## Definition

**Props** (short for **Properties**) are read-only data that a parent component passes to a child component.

Props allow components to communicate with each other.

Think of Props as function parameters.

Just as a function receives values through parameters, a React component receives data through Props.

Example

```jsx
function Welcome(props) {
    return <h1>Hello {props.name}</h1>;
}
```

Usage

```jsx
<Welcome name="Sai Kiran" />
```

Output

```text
Hello Sai Kiran
```

---

## Characteristics of Props

* Read-only
* Passed from Parent to Child
* Cannot be modified by the receiving component
* Improve component reusability
* Help in component communication

---

# 5.2 Why are Props Needed?

Suppose we create a product card.

Without Props:

```text
Product Card

↓

Laptop

(Always Laptop)
```

The component can display only one product.

Using Props:

```text
Product Card

↓

Laptop

TV

Mobile

Fridge

Washing Machine
```

The same component displays different products by receiving different data.

---

## In This Project

```text
OnlineShopping

↓

CartInfo Array

↓

Props

↓

Cart Component

↓

Display Shopping Items
```

This is exactly the data flow required in the uploaded hands-on lab. 

---

# 5.3 Features of Props

Props provide several benefits:

* Parent-to-child communication
* Component reusability
* Better code organization
* Dynamic user interfaces
* Easy data sharing
* One-way data flow

---

# 5.4 What are Default Props?

## Definition

Default Props provide default values when a parent component does not supply a prop.

Example

```jsx
Greeting.defaultProps = {
    name: "Guest"
};
```

If used as

```jsx
<Greeting />
```

Output

```text
Hello Guest
```

Although **Default Props** are listed as a learning objective in the uploaded lab, this specific hands-on implementation does not require creating or using them. 

---

# 5.5 What is `reactDOM.render()` / `ReactDOM.createRoot().render()`?

The uploaded lab includes understanding `reactDOM.render()` as one of its objectives. 

In modern React (React 18 and later), applications use:

```jsx
const root = ReactDOM.createRoot(
    document.getElementById("root")
);

root.render(
    <App />
);
```

This renders the root component inside the HTML element with the ID `root`.

Flow

```text
index.html

↓

<div id="root">

↓

index.js

↓

<App />

↓

Browser
```

---

# 5.6 Difference Between State and Props

| Props                        | State                           |
| ---------------------------- | ------------------------------- |
| Passed from Parent Component | Managed inside the component    |
| Read-only                    | Can be modified                 |
| Used for communication       | Used for storing component data |
| Parent controls the value    | Component controls the value    |
| Helps reuse components       | Helps manage dynamic UI         |

---

# 5.7 Parent and Child Components

A **Parent Component** sends data.

A **Child Component** receives data.

Example from this project:

```text
OnlineShopping

(Parent)

        │

        ▼

Cart

(Child)
```

The `OnlineShopping` component creates the shopping items and passes them to `Cart` through Props. 

---

# 5.8 Data Flow in React

React follows **One-Way Data Flow**.

Meaning

```text
Parent

↓

Child
```

NOT

```text
Child

↓

Parent
```

In this exercise

```text
OnlineShopping

↓

Props

↓

Cart
```

The child component displays the data but does not modify it.

---

# 6. Project Overview

This project demonstrates how to use **Props** in React by building a simple shopping cart application.

The application:

* Creates five shopping items.
* Stores them in an array.
* Passes the array from `OnlineShopping` to `Cart`.
* Uses `map()` to display each item in a table.
* Displays the item name and price.

These steps follow the implementation described in the uploaded hands-on lab. 

---

# 7. High-Level Architecture

```text
                    React Application
                           │
                           ▼
                         App.js
                           │
                           ▼
                  OnlineShopping Component
                           │
             Creates CartInfo Array
                           │
                           ▼
                 Passes Props to Cart
                           │
                           ▼
                     Cart Component
                           │
                 Reads this.props.item
                           │
                           ▼
                      map() Function
                           │
                           ▼
                  Display Shopping Table
```

---

# 8. Technologies Used

| Technology             | Purpose                                    |
| ---------------------- | ------------------------------------------ |
| **React**              | Builds reusable user interface components. |
| **JavaScript (ES6)**   | Implements the application logic.          |
| **JSX**                | Combines HTML-like syntax with JavaScript. |
| **Node.js**            | JavaScript runtime for development.        |
| **npm**                | Installs and manages project dependencies. |
| **Visual Studio Code** | Recommended IDE for development.           |
| **CSS**                | Styles the shopping table and layout.      |

---

# Exercise 7: Props

## Week 5 – ReactJS Hands-on Lab

> **Response 2 of 4**

---

# Table of Contents

6. Project Structure

7. Folder Explanation

8. File-by-File Explanation

9. Configuration Explanation

10. Implementation Explanation

11. Internal Working

12. Props Flow

13. Execution Flow

---

# 6. Project Structure

Based on the uploaded hands-on lab, the project consists of a React application named **shoppingapp** containing two class components (`OnlineShopping` and `Cart`) along with the standard React project files. 

```text
shoppingapp
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
│   │      ├── Cart.js
│   │      └── OnlineShopping.js
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

This folder stores all packages installed using npm.

Examples:

* React
* React DOM
* Babel
* Webpack
* ESLint

It is automatically created after running:

```bash
npm install
```

or

```bash
npx create-react-app shoppingapp
```

---

# public

The **public** folder contains static files that are directly served to the browser.

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

Every React component is created inside this folder.

---

# Components Folder

This folder stores reusable React components.

For this project:

```text
Components
│
├── OnlineShopping.js
└── Cart.js
```

---

# OnlineShopping.js

Acts as the **Parent Component**.

Responsibilities:

* Creates shopping item data.
* Stores five shopping items.
* Passes data to `Cart`.
* Displays the heading.

The uploaded lab specifies that `OnlineShopping` should create an array of five `Cart` items. 

---

# Cart.js

Acts as the **Child Component**.

Responsibilities:

* Receives data using Props.
* Displays item names.
* Displays prices.
* Generates table rows.

---

# App.js

Acts as the root component.

Responsibilities:

* Loads the `OnlineShopping` component.
* Serves as the application's main component.

---

# index.js

Acts as the entry point.

Responsibilities:

* Creates the React root.
* Renders the `App` component.

---

# App.css

Contains styling for:

* Heading
* Table
* Fonts
* Layout
* Borders

---

# 8. File-by-File Explanation

---

# File 1 – OnlineShopping.js

## Purpose

This is the Parent Component.

It creates an array containing shopping items and passes that array to the child component using Props.

---

## Responsibilities

```text
Create Shopping Items

↓

Store in Array

↓

Pass Using Props

↓

Render Cart Component
```

---

## Why is this component needed?

Without this component, there would be no centralized place to manage shopping data.

Instead of every component creating its own items, only one component creates the data.

---

## Data Created

Example

```text
Laptop

TV

Washing Machine

Mobile

Fridge
```

Each item contains

```text
Item Name

↓

Price
```

---

# File 2 – Cart.js

## Purpose

Receives shopping items from the parent component.

---

## Responsibilities

```text
Receive Props

↓

Loop Through Array

↓

Generate Table Rows

↓

Display Data
```

---

## How does it work?

The parent sends

```text
CartInfo Array
```

The child receives

```javascript
this.props.item
```

Then

```javascript
map()
```

iterates over every item.

---

## Why use map()?

Instead of writing

```text
Laptop

TV

Mobile

Fridge
```

manually, React automatically creates rows.

Flow

```text
Array

↓

map()

↓

Rows

↓

Table
```

---

# File 3 – App.js

## Purpose

Acts as the root UI component.

Responsibilities

```text
Load OnlineShopping

↓

Display Entire Application
```

---

## Component Hierarchy

```text
App

↓

OnlineShopping

↓

Cart
```

---

# File 4 – index.js

## Purpose

Starts the React application.

Flow

```text
Browser

↓

index.js

↓

<App />

↓

Render UI
```

---

## ReactDOM.createRoot()

Modern React applications use

```javascript
ReactDOM.createRoot()
```

instead of the older

```javascript
ReactDOM.render()
```

to render the application.

The uploaded lab lists `reactDOM.render()` as a learning objective because earlier React versions used that API. Modern Create React App projects generated with React 18 use `ReactDOM.createRoot().render()` instead. This difference is due to the React version, while the purpose—rendering the root component into the DOM—remains the same. 

---

# File 5 – App.css

## Purpose

Provides styling.

Responsibilities

* Center alignment
* Table borders
* Font styling
* Heading color
* Spacing

---

# 9. Configuration Explanation

---

# package.json

Stores

* Project metadata
* Installed packages
* Scripts

Important scripts

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

Execute Tests
```

---

# index.html

Contains

```html
<div id="root"></div>
```

React injects the application inside this element.

---

# 10. Implementation Explanation

The uploaded lab specifies the following implementation sequence. 

```text
Create React Project

↓

Create Cart Component

↓

Create OnlineShopping Component

↓

Initialize Five Items

↓

Pass Array Using Props

↓

Receive Props

↓

Display Data

↓

Run Application
```

---

# 11. Internal Working

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

`App.js` loads

```text
OnlineShopping
```

---

Step 5

`OnlineShopping`

creates

```text
CartInfo Array
```

---

Step 6

Props are passed.

```text
<Cart item={CartInfo}/>
```

---

Step 7

`Cart`

receives

```text
this.props.item
```

---

Step 8

`map()`

loops through the array.

---

Step 9

Rows are generated.

---

Step 10

Table appears in the browser.

---

# 12. Props Flow

```text
OnlineShopping

        │

Creates CartInfo

        │

        ▼

<Cart item={CartInfo} />

        │

        ▼

Cart Component

        │

Receives Props

        │

        ▼

this.props.item

        │

        ▼

map()

        │

        ▼

Generate Table

        │

        ▼

Display Shopping Items
```

This illustrates the one-way parent-to-child data flow required by the uploaded lab. 

---

# 13. Execution Flow

```text
React Starts

        │

        ▼

index.js

        │

        ▼

App.js

        │

        ▼

OnlineShopping Component

        │

        ▼

Create Shopping Array

        │

        ▼

Pass Props

        │

        ▼

Cart Component

        │

        ▼

Receive Props

        │

        ▼

Loop Using map()

        │

        ▼

Display Shopping Table
```

---

# Exercise 7: Props

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

The uploaded hands-on lab requires creating a **shoppingapp** where the `OnlineShopping` component creates an array of **five shopping items**, passes it to the `Cart` component using **Props**, and the `Cart` component displays the **Item Name** and **Price** in a table. The sample output shown in the lab reflects this table-based display. 

---

# Sample Input

Shopping Items Array

```text
Item Name           Price
--------------------------------
Laptop              80000
TV                 120000
Washing Machine     50000
Mobile              30000
Fridge              70000
```

---

## Data Created by Parent Component

```text
CartInfo

↓

[
    Laptop,
    TV,
    Washing Machine,
    Mobile,
    Fridge
]
```

---

# Props Passed

```text
OnlineShopping

↓

<Cart item={CartInfo}/>
```

---

# Expected Output

```text
                Items Ordered

+--------------------------------------+
| Name                 | Price         |
+--------------------------------------+
| Laptop               | 80000         |
| TV                   | 120000        |
| Washing Machine      | 50000         |
| Mobile               | 30000         |
| Fridge               | 70000         |
+--------------------------------------+
```

This output matches the table displayed in the uploaded lab document. 

---

# Application Flow

```text
React Starts

↓

App Component

↓

OnlineShopping

↓

CartInfo Array

↓

Props

↓

Cart Component

↓

Display Shopping Table
```

---

# Props Flow Example

```text
Parent

↓

<Cart item={CartInfo}/>

↓

Child

↓

this.props.item

↓

Display Data
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
npx create-react-app shoppingapp
```

---

## Step 4

Move to Project Folder

```bash
cd shoppingapp
```

---

## Step 5

Open VS Code

```bash
code .
```

---

## Step 6

Create Components

```text
OnlineShopping.js

Cart.js
```

---

## Step 7

Configure App.js

Import

```text
OnlineShopping
```

and render it.

---

## Step 8

Run Application

```bash
npm start
```

---

## Step 9

Browser Opens

```text
http://localhost:3000
```

---

## Production Build

```bash
npm run build
```

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

| Command                            | Purpose                 |
| ---------------------------------- | ----------------------- |
| `node -v`                          | Check Node.js version   |
| `npm -v`                           | Check npm version       |
| `npx create-react-app shoppingapp` | Create React project    |
| `cd shoppingapp`                   | Enter project folder    |
| `code .`                           | Open project in VS Code |
| `npm start`                        | Run application         |
| `npm test`                         | Execute tests           |
| `npm run build`                    | Production build        |
| `Ctrl + C`                         | Stop server             |

---

# 16. Testing

---

## Test 1

Application Starts

Expected

```text
Compiled successfully!
```

---

## Test 2

Heading Appears

Expected

```text
Items Ordered
```

---

## Test 3

Table Appears

Expected

```text
Name

Price
```

---

## Test 4

Verify Rows

Expected

Five rows are displayed.

---

## Test 5

Verify First Item

Expected

```text
Laptop

80000
```

---

## Test 6

Verify Second Item

Expected

```text
TV

120000
```

---

## Test 7

Verify Third Item

Expected

```text
Washing Machine

50000
```

---

## Test 8

Verify Fourth Item

Expected

```text
Mobile

30000
```

---

## Test 9

Verify Fifth Item

Expected

```text
Fridge

70000
```

---

## Test 10

Verify Props

Expected Flow

```text
OnlineShopping

↓

Props

↓

Cart

↓

Display Items
```

---

# Manual Testing Checklist

| Test                      | Status |
| ------------------------- | ------ |
| React Runs                | ✅      |
| App Loads                 | ✅      |
| OnlineShopping Loads      | ✅      |
| Cart Component Loads      | ✅      |
| Props Passed Successfully | ✅      |
| Table Displayed           | ✅      |
| Five Items Displayed      | ✅      |
| Prices Displayed          | ✅      |
| No Console Errors         | ✅      |

These checks verify that the application behaves as described in the uploaded hands-on lab. 

---

# 17. Best Practices

---

## Keep Components Small

Good

```text
OnlineShopping

↓

Manage Data
```

```text
Cart

↓

Display Data
```

Each component should have a single responsibility.

---

## Pass Only Required Data

Instead of sending unnecessary information, pass only the required props.

Example

```jsx
<Cart item={CartInfo}/>
```

---

## Never Modify Props

Props are **read-only**.

Incorrect

```javascript
this.props.item = [];
```

Correct

Display the data without changing it.

---

## Use map() for Lists

Correct

```javascript
this.props.item.map(...)
```

Avoid manually writing multiple table rows.

---

## Use Meaningful Prop Names

Good

```text
item

student

employee
```

Avoid

```text
a

x

obj
```

---

## Keep Parent Responsible for Data

The parent component should create and manage data, while the child component should only display it.

---

# 18. Common Mistakes

---

## Mistake 1

Forgot to pass Props.

Wrong

```jsx
<Cart />
```

Correct

```jsx
<Cart item={CartInfo}/>
```

---

## Mistake 2

Wrong Prop Name

Parent

```jsx
<Cart products={CartInfo}/>
```

Child

```javascript
this.props.item
```

Result

```text
Undefined
```

---

## Mistake 3

Trying to Modify Props

Wrong

```javascript
this.props.item.push(...)
```

Props are immutable.

---

## Mistake 4

Forgot `this.props`

Wrong

```javascript
item.map(...)
```

Correct

```javascript
this.props.item.map(...)
```

---

## Mistake 5

Forgot `key`

Wrong

```jsx
<tr>
```

Correct

```jsx
<tr key={index}>
```

---

## Mistake 6

Using `for` Loop Instead of `map()`

Although possible, `map()` is the recommended React approach for rendering lists.

---

## Mistake 7

Component Not Exported

Forgot

```javascript
export default Cart;
```

Result

```text
Import Error
```

---

## Mistake 8

Incorrect Import Path

Wrong

```javascript
import Cart from "./Cart";
```

when the file is in another directory.

Always verify import paths.

---

# 19. Real-world Applications

Props are used extensively in modern React applications.

---

## E-Commerce Website

```text
Product List

↓

Product Card

↓

Display Product Information
```

---

## Student Portal

```text
Students

↓

Student Card

↓

Display Student Details
```

---

## Banking Dashboard

```text
Accounts

↓

Account Card

↓

Balance

↓

Transactions
```

---

## Hospital Management

```text
Patients

↓

Patient Card

↓

Medical Information
```

---

## Employee Management

```text
Employees

↓

Employee Card

↓

Employee Details
```

---

## Food Delivery Application

```text
Restaurant

↓

Food Card

↓

Food Details
```

---

# 20. Advantages

| Advantage              | Explanation                                                  |
| ---------------------- | ------------------------------------------------------------ |
| Reusable Components    | One component can display different data.                    |
| One-Way Data Flow      | Makes applications easier to understand and debug.           |
| Better Maintainability | Parent manages data, child focuses on presentation.          |
| Cleaner Code           | Separates business logic from UI.                            |
| Easy Communication     | Enables parent-to-child data transfer.                       |
| Improved Scalability   | New data can be passed without changing component structure. |

---

# 21. Limitations

---

## Read-Only

Props cannot be modified by the child component.

---

## One-Way Communication

Props only flow from **Parent → Child**.

Child components cannot directly update parent data.

---

## No Data Persistence

The application uses a local array of shopping items.

There is no database or backend.

---

## No User Interaction

This exercise only displays shopping items.

Users cannot:

* Add items
* Delete items
* Edit prices

---

## Static Data

The five shopping items are hardcoded in the parent component, as required by the uploaded lab. 

---

# Exercise 7: Props

## Week 5 – ReactJS Hands-on Lab

> **Response 4 of 4**

---

# Table of Contents

22. Frequently Asked Interview Questions

23. Quick Revision Notes

24. Props Cheat Sheet

25. Important Commands Cheat Sheet

26. Important Files Summary

27. Complete Props Workflow

28. Key Takeaways

29. Conclusion

30. Next Learning Path

---

# 22. Frequently Asked Interview Questions

---

## Q1. What are Props in React?

**Answer:**

Props (Properties) are read-only values passed from a parent component to a child component. They enable communication between components.

---

## Q2. Why are Props used?

**Answer:**

Props are used to:

* Pass data between components.
* Make components reusable.
* Maintain one-way data flow.
* Separate logic from presentation.

---

## Q3. What is the full form of Props?

**Answer:**

**Props = Properties**

---

## Q4. Are Props mutable or immutable?

**Answer:**

Props are **immutable (read-only)**. A child component must not modify the props it receives.

---

## Q5. Who passes Props?

**Answer:**

The **Parent Component** passes props to the **Child Component**.

---

## Q6. Who receives Props?

**Answer:**

The **Child Component** receives props from the parent component.

---

## Q7. How are Props accessed in a Class Component?

**Answer:**

Using `this.props`.

Example:

```jsx id="c5m1y9"
this.props.item
```

---

## Q8. How are Props accessed in a Function Component?

**Answer:**

Using the `props` parameter.

Example:

```jsx id="ztx5v4"
function Cart(props) {
    return props.item;
}
```

---

## Q9. What are Default Props?

**Answer:**

Default Props provide default values when the parent component does not pass a value.

Example:

```jsx id="lwk26j"
Greeting.defaultProps = {
    name: "Guest"
};
```

The uploaded lab includes Default Props as a learning objective, although they are not implemented in this exercise. 

---

## Q10. Can a child component modify Props?

**Answer:**

No.

Props are read-only.

---

## Q11. What is One-Way Data Flow?

**Answer:**

Data flows only from the Parent Component to the Child Component.

```text id="0rq5zv"
Parent

↓

Child
```

---

## Q12. What is the Parent Component in this project?

**Answer:**

`OnlineShopping`

---

## Q13. What is the Child Component?

**Answer:**

`Cart`

---

## Q14. Which component stores shopping data?

**Answer:**

`OnlineShopping`

---

## Q15. Which component displays shopping data?

**Answer:**

`Cart`

---

## Q16. Why is map() used?

**Answer:**

`map()` loops through an array and creates UI elements for every object.

---

## Q17. Why is key used in map()?

**Answer:**

It uniquely identifies each rendered element and helps React efficiently update the UI.

---

## Q18. What is ReactDOM.createRoot()?

**Answer:**

It creates the React root in modern React (React 18+) applications.

---

## Q19. What is reactDOM.render()?

**Answer:**

It was the rendering method used in React versions before React 18. Modern applications use `ReactDOM.createRoot().render()` instead. The uploaded lab lists `reactDOM.render()` as one of the concepts to understand. 

---

## Q20. What is JSX?

**Answer:**

JSX is a syntax extension that allows developers to write HTML-like code inside JavaScript.

---

## Q21. Can Props contain arrays?

**Answer:**

Yes.

Example:

```jsx id="lg8dcu"
<Cart item={CartInfo}/>
```

---

## Q22. Can Props contain objects?

**Answer:**

Yes.

Objects are commonly passed as props.

---

## Q23. Can Props contain functions?

**Answer:**

Yes.

Functions can be passed as props to allow child components to communicate actions back to the parent.

---

## Q24. What is component reusability?

**Answer:**

The ability to use the same component with different data without rewriting it.

---

## Q25. What is the advantage of Props?

**Answer:**

They make components reusable, maintainable, and easier to test.

---

# 23. Quick Revision Notes

### Props

```text id="kl2ctk"
Read Only
```

---

### Parent Component

```text id="t0mpq7"
OnlineShopping
```

---

### Child Component

```text id="tyq2a9"
Cart
```

---

### Data Flow

```text id="7jlwmr"
Parent

↓

Props

↓

Child
```

---

### Access Props

Class Component

```jsx id="lqhrgw"
this.props.item
```

---

Function Component

```jsx id="yjlwmw"
props.item
```

---

### Loop

```javascript id="ccjlwm"
map()
```

---

### Render

```javascript id="0fn39o"
ReactDOM.createRoot()
```

---

### Project Flow

```text id="zz2ndc"
App

↓

OnlineShopping

↓

Props

↓

Cart

↓

Display Table
```

---

# 24. Props Cheat Sheet

| Concept                 | Description                                |
| ----------------------- | ------------------------------------------ |
| Props                   | Data passed from Parent to Child           |
| Parent Component        | Sends data                                 |
| Child Component         | Receives data                              |
| `this.props`            | Access props in class components           |
| `props`                 | Access props in function components        |
| `map()`                 | Render lists                               |
| `key`                   | Unique identifier for list items           |
| Default Props           | Default values when props are not provided |
| `ReactDOM.createRoot()` | Renders the React application              |

---

### Pass Props

```jsx id="m4y8jb"
<Cart item={CartInfo} />
```

---

### Receive Props

```jsx id="55iyb7"
this.props.item
```

---

### Loop Through Data

```jsx id="nhkpvw"
this.props.item.map(...)
```

---

# 25. Important Commands Cheat Sheet

| Command                            | Purpose                  |
| ---------------------------------- | ------------------------ |
| `node -v`                          | Check Node.js version    |
| `npm -v`                           | Check npm version        |
| `npx create-react-app shoppingapp` | Create React project     |
| `cd shoppingapp`                   | Enter project folder     |
| `code .`                           | Open project in VS Code  |
| `npm start`                        | Start development server |
| `npm test`                         | Run tests                |
| `npm run build`                    | Create production build  |
| `Ctrl + C`                         | Stop development server  |

---

# 26. Important Files Summary

| File                | Purpose                                                                         |
| ------------------- | ------------------------------------------------------------------------------- |
| `OnlineShopping.js` | Parent component that creates the shopping items array and passes it as props.  |
| `Cart.js`           | Child component that receives props and displays the shopping items in a table. |
| `App.js`            | Loads the `OnlineShopping` component.                                           |
| `index.js`          | Entry point that renders the React application.                                 |
| `App.css`           | Styles the application and shopping table.                                      |
| `index.css`         | Provides global styles.                                                         |
| `package.json`      | Stores project metadata, scripts, and dependencies.                             |

---

# 27. Complete Props Workflow

```text id="5dkt2j"
Start React Application

        │

        ▼

index.js

        │

        ▼

Render <App />

        │

        ▼

Load OnlineShopping

        │

        ▼

Create CartInfo Array

        │

        ▼

Pass Props

<Cart item={CartInfo} />

        │

        ▼

Cart Component

        │

        ▼

Receive this.props.item

        │

        ▼

Loop Using map()

        │

        ▼

Generate Table Rows

        │

        ▼

Display Shopping Items
```

This workflow reflects the implementation described in the uploaded hands-on lab, where `OnlineShopping` passes an array of five shopping items to `Cart` using Props. 

---

# 28. Key Takeaways

After completing this exercise, you should be able to:

* Define **Props** and explain their purpose.
* Understand **Parent-to-Child communication** in React.
* Access props using `this.props` in class components.
* Explain **Default Props** conceptually.
* Differentiate between **State** and **Props**.
* Use `map()` to render lists dynamically.
* Explain the role of `ReactDOM.createRoot().render()` (and understand that earlier React versions used `reactDOM.render()`).
* Build reusable React components by passing data through Props.

These learning outcomes align with the objectives stated in the uploaded hands-on lab. 

---

# 29. Conclusion

This exercise demonstrates one of the core concepts of React: **Props**.

By building the **shoppingapp**, you learned how to:

* Create reusable class components.
* Pass data from a parent component (`OnlineShopping`) to a child component (`Cart`).
* Display dynamic content using `map()`.
* Understand one-way data flow in React.
* Organize UI logic by separating data management from presentation.

These concepts form the basis for building scalable and maintainable React applications.

---

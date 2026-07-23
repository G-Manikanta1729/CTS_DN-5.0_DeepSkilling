# Exercise 10: React JSX

## Week 5 – ReactJS Hands-on Lab

> **Response 1 of 4**

---

# Table of Contents

1. Project Title

2. Introduction

3. Learning Objectives

4. Prerequisites

5. Background Concepts

- What is React?
- What is JSX?
- Why JSX was Introduced
- React.createElement()
- JSX vs HTML
- JSX Elements
- JSX Attributes
- Rendering JSX to the DOM
- JavaScript Expressions in JSX
- Inline CSS in JSX
- Objects in JavaScript
- Arrays of Objects
- map() in JSX
- Conditional Styling
- Project Overview
- High-Level Architecture
- Technologies Used

---

# 1. Project Title

# React JSX

**Week 5 – ReactJS Hands-on Lab**

**Exercise 10 – React JSX**

---

# 2. Introduction

## What is this project?

This hands-on exercise introduces **React JSX**, a syntax extension that allows developers to write HTML-like code inside JavaScript.

According to the uploaded hands-on lab, you will create a React application named **officespacerentalapp** that demonstrates:

- Creating JSX elements
- Using JSX attributes
- Rendering JSX to the DOM
- Displaying office images
- Creating JavaScript objects
- Displaying office details
- Looping through an array of office objects
- Applying inline CSS based on conditions. :contentReference[oaicite:0]{index=0}

---

## What problem does this project solve?

Suppose you are developing an Office Space Rental application.

Every office contains information like:

- Office Name
- Rent
- Address
- Image

Instead of manually writing HTML for every office,

React allows us to:

- Store office information in JavaScript objects.
- Store multiple offices inside an array.
- Use JSX to generate the user interface automatically.

This makes the application:

- Easier to maintain
- Easier to update
- Less repetitive
- More scalable

---

## Why JSX is Important?

Before JSX, React developers had to create UI using JavaScript functions such as:

```javascript
React.createElement(...)
```

This becomes difficult to read for complex interfaces.

JSX provides a much cleaner syntax.

Instead of writing:

```javascript
React.createElement(
    "h1",
    null,
    "Office Space"
);
```

We can simply write:

```jsx
<h1>Office Space</h1>
```

JSX makes React code look similar to HTML while still being JavaScript.

---

## Real-world Example

Imagine an office rental website.

Each office contains:

```text
Office Name

↓

Rent

↓

Address

↓

Image
```

Instead of creating separate HTML for every office,

React stores all offices inside an array and automatically displays them using JSX.

If a new office is added,

Only the array changes.

The UI updates automatically.

---

## Where is JSX Used?

JSX is widely used in:

- React Applications
- Company Dashboards
- Banking Applications
- Hospital Management Systems
- E-Commerce Websites
- Student Portals
- Hotel Booking Applications
- Employee Management Systems
- Real Estate Websites
- Office Rental Platforms

---

# 3. Learning Objectives

According to the uploaded hands-on lab, after completing this exercise you should be able to:

- Define JSX.
- Explain ECMAScript.
- Explain `React.createElement()`.
- Explain how to create React nodes using JSX.
- Explain how JSX is rendered to the DOM.
- Explain how JavaScript expressions are used inside JSX.
- Explain how inline CSS is applied in JSX.

In this implementation, you will also learn to:

- Display office information using JSX.
- Display office images.
- Create JavaScript objects.
- Create arrays of objects.
- Display multiple office records using `map()`.
- Apply conditional inline styling for rent values. :contentReference[oaicite:1]{index=1}

---

# 4. Prerequisites

The uploaded hands-on lab specifies the following prerequisites:

| Software | Purpose |
|----------|----------|
| Node.js | JavaScript Runtime |
| npm | Package Manager |
| Visual Studio Code | Code Editor | :contentReference[oaicite:2]{index=2}

You should also have basic knowledge of:

- HTML
- CSS
- JavaScript
- React Components

---

# 5. Background Concepts

---

# 5.1 What is React?

## Definition

React is an open-source JavaScript library used for building fast, interactive, and reusable user interfaces.

It was developed by **Meta (Facebook)**.

React applications are built using small reusable units called **components**.

---

## Features of React

- Component-Based Architecture
- Virtual DOM
- One-Way Data Flow
- Reusable Components
- Fast Rendering
- Easy UI Development

---

## Real-world Analogy

Imagine building a house.

Instead of constructing everything from scratch every time,

you create reusable parts like:

- Doors
- Windows
- Tables
- Chairs

Similarly,

React builds applications using reusable components.

---

# 5.2 What is JSX?

## Definition

JSX (JavaScript XML) is a syntax extension for JavaScript that allows developers to write HTML-like code inside JavaScript.

Example

```jsx
<h1>Office Space</h1>
```

Although it looks like HTML, it is actually JSX.

React converts JSX into JavaScript before it is executed.

---

## Why was JSX introduced?

Without JSX,

creating user interfaces required calling JavaScript functions repeatedly.

Example

```javascript
React.createElement(
    "h1",
    null,
    "Office Space"
);
```

This becomes difficult to read as applications grow.

JSX simplifies UI creation by allowing developers to write familiar HTML-like syntax.

---

# 5.3 React.createElement()

Before JSX,

React elements were created using:

```javascript
React.createElement(
    type,
    props,
    children
);
```

Example

```javascript
React.createElement(
    "h1",
    null,
    "Welcome"
);
```

JSX automatically converts

```jsx
<h1>Welcome</h1>
```

into the equivalent `React.createElement()` call during compilation.

---

# 5.4 JSX vs HTML

| HTML | JSX |
|------|------|
| Uses `class` | Uses `className` |
| Uses `for` | Uses `htmlFor` |
| Static | Can contain JavaScript expressions |
| Plain markup | JavaScript syntax extension |
| Browser understands directly | Converted into JavaScript before execution |

---

# 5.5 JSX Elements

JSX elements describe the structure of the user interface.

Example

```jsx
<h2>Available Office Spaces</h2>
```

A JSX element can represent:

- Heading
- Paragraph
- Image
- Table
- Button
- Form
- Any HTML element

---

# 5.6 JSX Attributes

Attributes provide additional information to JSX elements.

Example

```jsx
<img
    src={office}
    alt="Office"
    width="300"
    height="220"
/>
```

Common JSX attributes include:

- `src`
- `alt`
- `width`
- `height`
- `className`
- `style`

---

# 5.7 Rendering JSX to the DOM

React renders JSX into the browser using `ReactDOM`.

Flow

```text
JSX

↓

React

↓

Virtual DOM

↓

Real DOM

↓

Browser Output
```

The application starts from:

```javascript
ReactDOM.createRoot(...)
```

and renders the `<App />` component into the HTML element with the id `root`.

---

# 5.8 JavaScript Expressions in JSX

JSX allows JavaScript expressions to be written inside curly braces `{}`.

Example

```jsx
const heading = "Office Space";

<h1>{heading}</h1>
```

Output

```text
Office Space
```

In this project, expressions are used to display:

- Office Name
- Rent
- Address

---

# 5.9 Inline CSS in JSX

React allows CSS to be applied directly using the `style` attribute.

Example

```jsx
<h3
    style={{
        color: "red"
    }}
>
    Rent: Rs. 50000
</h3>
```

In this exercise, inline CSS is used to change the rent color based on its value, as specified in the uploaded hands-on lab. :contentReference[oaicite:3]{index=3}

---

# 5.10 Objects in JavaScript

An object stores related information using key-value pairs.

Example

```javascript
const office = {
    Name: "DBS",
    Rent: 50000,
    Address: "Chennai"
};
```

Each property can be accessed using:

```javascript
office.Name
office.Rent
office.Address
```

---

# 5.11 Arrays of Objects

An array can contain multiple objects.

Example

```javascript
const officeList = [
    {
        Name: "DBS",
        Rent: 50000
    },
    {
        Name: "Regus",
        Rent: 75000
    }
];
```

This makes it easy to display multiple office spaces dynamically.

---

# 5.12 map() in JSX

`map()` is used to iterate over arrays and generate JSX elements.

Example

```jsx
officeList.map((office) => (
    <h2>{office.Name}</h2>
))
```

Instead of writing multiple headings manually, `map()` automatically creates one heading for each office.

---

# 5.13 Conditional Styling

Conditional styling allows the appearance of an element to change based on a condition.

Example

```jsx
style={{
    color:
        office.Rent <= 60000
            ? "red"
            : "green"
}}
```

In this project:

- Rent **≤ 60000** is displayed in **red**.
- Rent **> 60000** is displayed in **green**.

This matches the behavior required in the uploaded hands-on lab. :contentReference[oaicite:4]{index=4}

---

# 6. Project Overview

The **Office Space Rental App** demonstrates how JSX can be used to create dynamic user interfaces.

The application:

- Displays a page heading.
- Displays an office image.
- Shows details of a single office.
- Displays multiple office spaces from an array.
- Uses inline CSS to highlight rent values.
- Uses JSX expressions to render dynamic data.

---

# 7. High-Level Architecture

```text
                 React Application
                        │
                        ▼
                     App.js
                        │
        ┌───────────────┼────────────────┐
        ▼               ▼                ▼
   Office Image    Office Object    Office List
                        │                │
                        ▼                ▼
               JSX Expressions      map()
                        │                │
                        └──────┬─────────┘
                               ▼
                    Conditional Styling
                               │
                               ▼
                         Browser Output
```

---

# 8. Technologies Used

| Technology | Purpose | Role in this Project |
|------------|---------|----------------------|
| **React** | JavaScript library | Builds reusable UI components. |
| **JSX** | JavaScript syntax extension | Creates HTML-like UI inside JavaScript. |
| **JavaScript (ES6)** | Programming language | Creates objects, arrays, expressions, and rendering logic. |
| **Node.js** | JavaScript runtime | Runs the React development environment. |
| **npm** | Package manager | Installs project dependencies. |
| **Visual Studio Code** | Code editor | Used to write and manage the project. |
| **CSS** | Styling language | Styles the application and applies layout. |

---

# Exercise 10: React JSX

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

14. JSX and Component Explanation

---

# 6. Project Structure

According to the uploaded hands-on lab, the React application **officespacerentalapp** demonstrates the use of JSX, JavaScript expressions, object rendering, looping through arrays, and inline CSS. :contentReference[oaicite:0]{index=0}

```text
officespacerentalapp
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
│   ├── office.jpg
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

This folder contains all the packages installed using **npm**.

Examples include:

- React
- React DOM
- Babel
- Webpack
- ESLint

This folder is automatically generated after running:

```bash
npm install
```

or

```bash
npx create-react-app officespacerentalapp
```

---

# public

The **public** folder stores static files that are directly served by the browser.

```text
public
│
├── index.html
├── favicon.ico
├── manifest.json
└── robots.txt
```

The most important file is:

```text
index.html
```

Inside it, React renders the application into:

```html
<div id="root"></div>
```

---

# src

The **src** folder contains the application's source code.

```text
src
│
├── office.jpg
├── App.js
├── App.css
├── index.js
└── index.css
```

Everything we write for this exercise is placed inside this folder.

---

# office.jpg

This is the office image displayed on the webpage.

The uploaded hands-on lab requires displaying an office image along with the office details. Only a single image file is sufficient and it can be reused for all office records. :contentReference[oaicite:1]{index=1}

---

# 8. File-by-File Explanation

---

# File 1 — App.js

## Purpose

This is the main React component.

It is responsible for:

- Creating the heading
- Importing the office image
- Creating an office object
- Creating an array of office objects
- Displaying office details
- Looping through all offices
- Applying conditional styling to rent

---

## Responsibilities

```text
Create Heading

↓

Import Image

↓

Create Office Object

↓

Create Office List

↓

Display Office Details

↓

Apply Inline CSS

↓

Render UI
```

---

# File 2 — App.css

## Purpose

Provides styling for the application.

Examples include:

- Margins
- Font styles
- Image spacing
- Office card spacing

---

# File 3 — index.js

## Purpose

This is the entry point of the React application.

Responsibilities:

```text
Browser

↓

index.js

↓

<App />

↓

Render to DOM
```

---

# File 4 — index.css

Provides global styling for the application.

Examples:

- Page margin
- Background color
- Default font

---

# File 5 — office.jpg

Stores the office image displayed in the application.

The same image is reused for all office cards.

---

# 9. Configuration Explanation

---

# package.json

Contains:

- Project information
- Installed packages
- React dependencies
- Scripts

Important scripts:

```text
npm start
```

Starts the development server.

---

```text
npm test
```

Runs test cases.

---

```text
npm run build
```

Creates the production build.

---

# index.html

Contains:

```html
<div id="root"></div>
```

React injects the entire application inside this element.

---

# Image Configuration

The office image is imported into `App.js`.

```javascript
import office from "./office.jpg";
```

React bundles this image during compilation and makes it available for rendering.

---

# 10. Implementation Explanation

The implementation follows the workflow given in the uploaded hands-on lab.

```text
Create React Project

↓

Import Office Image

↓

Create Office Object

↓

Create Office Array

↓

Display Heading

↓

Display Image

↓

Display Single Office

↓

Loop Through Office Array

↓

Apply Conditional Styling

↓

Render Output
```

---

# 11. Code Flow

Overall application flow:

```text
Application Starts

↓

index.js

↓

App.js

↓

Import Image

↓

Create Objects

↓

Create Array

↓

Render JSX

↓

Browser Displays Output
```

---

## Data Flow

```text
Office Object

↓

JSX Expressions

↓

Office Details
```

---

```text
Office Array

↓

map()

↓

Generate JSX

↓

Display Office Cards
```

---

# 12. Execution Flow

```text
React Starts

↓

ReactDOM.createRoot()

↓

<App />

↓

App.js Executes

↓

Office Data Created

↓

JSX Generated

↓

Virtual DOM Created

↓

Real DOM Updated

↓

Browser Displays UI
```

---

# 13. Internal Working

### Step 1

React application starts.

↓

### Step 2

`index.js` creates the React root.

↓

### Step 3

`App.js` is loaded.

↓

### Step 4

The office image is imported.

↓

### Step 5

A JavaScript object is created for a single office.

↓

### Step 6

An array containing multiple office objects is created.

↓

### Step 7

JSX displays:

- Heading
- Image
- Office details

↓

### Step 8

`map()` iterates through the office array.

↓

### Step 9

For each office:

- Name
- Rent
- Address
- Image

are displayed.

↓

### Step 10

React checks the rent value.

```text
Rent ≤ 60000

↓

Red
```

```text
Rent > 60000

↓

Green
```

↓

### Step 11

Virtual DOM compares changes.

↓

### Step 12

Browser displays the final webpage.

---

# 14. JSX and Component Explanation

---

# Heading

The page heading is created using JSX.

```jsx
<h1>Office Space, at Affordable Range</h1>
```

Purpose:

Displays the title of the application.

---

# Image Rendering

The office image is displayed using JSX.

```jsx
<img
    src={office}
    alt="Office Space"
/>
```

Purpose:

Displays the office image imported from the `src` folder.

---

# Office Object

A JavaScript object stores one office's information.

```javascript
const officeDetails = {
    Name: "DBS",
    Rent: 50000,
    Address: "Chennai"
};
```

Purpose:

Stores related information together using key-value pairs.

---

# Office List

An array stores multiple office objects.

```javascript
const officeList = [
    {...},
    {...},
    {...}
];
```

Purpose:

Allows multiple office spaces to be managed efficiently.

---

# map()

`map()` is used to display every office in the array.

Flow:

```text
Office Array

↓

map()

↓

Generate JSX

↓

Display Office Cards
```

---

# JSX Expressions

Curly braces `{}` allow JavaScript values to be displayed inside JSX.

Example:

```jsx
<h2>{officeItem.Name}</h2>
```

Purpose:

Displays dynamic data from JavaScript.

---

# Inline CSS

Inline styling is applied using the `style` attribute.

Example:

```jsx
style={{
    color:
        officeItem.Rent <= 60000
            ? "red"
            : "green"
}}
```

Purpose:

Changes the rent color dynamically.

---

# Conditional Rent Color Logic

The uploaded hands-on lab specifies:

- Rent below or equal to **60000** → **Red**
- Rent above **60000** → **Green** :contentReference[oaicite:2]{index=2}

Flow:

```text
Office Rent

↓

Is Rent ≤ 60000?

↓

Yes ─────────► Red

No ─────────► Green
```

This conditional styling makes the rent value visually distinguishable based on its amount.

---

# Exercise 10: React JSX

## Week 5 – ReactJS Hands-on Lab

> **Response 3 of 4**

---

# Table of Contents

15. JSX Concepts Explained

16. Sample Input and Output

17. How to Run the Project

18. Testing

19. Best Practices

20. Common Mistakes

21. Real-world Applications

22. Advantages

23. Limitations

---

# 15. JSX Concepts Explained

The uploaded hands-on lab focuses on using JSX to create user interface elements, render them to the DOM, use JavaScript expressions, and apply inline CSS in a React application. :contentReference[oaicite:0]{index=0}

---

# 15.1 JSX Syntax

## Definition

JSX (JavaScript XML) is a syntax extension that allows developers to write HTML-like code inside JavaScript.

Example

```jsx
<h1>Office Space</h1>
```

Although it resembles HTML, JSX is converted into JavaScript before execution.

---

## Why JSX?

Without JSX

```javascript
React.createElement(
    "h1",
    null,
    "Office Space"
);
```

With JSX

```jsx
<h1>Office Space</h1>
```

JSX is easier to read and write.

---

## Flow

```text
JSX Code

↓

Babel Compiler

↓

React.createElement()

↓

Virtual DOM

↓

Browser
```

---

# 15.2 JSX Elements

A JSX element represents a part of the user interface.

Examples

```jsx
<h1>Heading</h1>

<p>Paragraph</p>

<img />

<div></div>
```

In this project, JSX elements include:

- Heading
- Image
- Office Details
- Horizontal Line
- Office Cards

---

# 15.3 JSX Attributes

Attributes provide additional information about JSX elements.

Example

```jsx
<img
    src={office}
    alt="Office"
    width="300"
    height="220"
/>
```

Common JSX attributes used in this project:

- src
- alt
- width
- height
- className
- style

---

# 15.4 JavaScript Expressions in JSX

JavaScript expressions are written inside curly braces `{}`.

Example

```jsx
const heading = "Office Space";

<h1>{heading}</h1>
```

Output

```text
Office Space
```

---

In this project

```jsx
{officeDetails.Name}

{officeDetails.Rent}

{officeDetails.Address}
```

React replaces these expressions with their corresponding values.

---

# 15.5 Rendering JSX to the DOM

React renders JSX into the browser using ReactDOM.

Flow

```text
App.js

↓

JSX

↓

Virtual DOM

↓

Real DOM

↓

Browser Output
```

Everything displayed on the webpage originates from the JSX returned by the `App` component.

---

# 15.6 Inline CSS

React allows styles to be written directly inside JSX.

Example

```jsx
<h3
    style={{
        color: "green"
    }}
>
    Rent
</h3>
```

The `style` attribute accepts a JavaScript object.

---

## Dynamic Inline CSS

Instead of a fixed color,

React can determine the color at runtime.

```jsx
style={{
    color:
        officeItem.Rent <= 60000
            ? "red"
            : "green"
}}
```

---

Flow

```text
Rent Value

↓

Condition

↓

Color Selected

↓

Applied to JSX
```

---

# 15.7 Objects

JavaScript objects store related data.

Example

```javascript
const office = {
    Name: "DBS",
    Rent: 50000,
    Address: "Chennai"
};
```

Properties are accessed using

```javascript
office.Name

office.Rent

office.Address
```

---

# 15.8 Arrays of Objects

Multiple offices are stored inside an array.

Example

```javascript
const officeList = [

{
Name: "DBS",
Rent: 50000
},

{
Name: "Regus",
Rent: 75000
}

];
```

This makes it easy to manage multiple records.

---

# 15.9 map()

`map()` loops through every office object.

Example

```jsx
officeList.map((office) => (

<div>

<h2>{office.Name}</h2>

</div>

))
```

---

Flow

```text
Office Array

↓

map()

↓

Each Office

↓

Generate JSX

↓

Display
```

---

# 15.10 Conditional Styling

The uploaded hands-on lab specifies:

- Rent below or equal to **60000** → **Red**
- Rent above **60000** → **Green** :contentReference[oaicite:1]{index=1}

Implementation

```jsx
style={{
color:
officeItem.Rent <= 60000
? "red"
: "green"
}}
```

Flow

```text
Rent

↓

Check Condition

↓

True

↓

Red

OR

False

↓

Green
```

---

# 16. Sample Input and Output

## Office Object

```javascript
{
Name: "DBS",
Rent: 50000,
Address: "Chennai"
}
```

Output

```text
Name: DBS

Rent: Rs. 50000 (Red)

Address: Chennai
```

---

## Office List

```javascript
[
{
Name:"DBS",
Rent:50000,
Address:"Chennai"
},
{
Name:"Regus",
Rent:75000,
Address:"Hyderabad"
},
{
Name:"WeWork",
Rent:65000,
Address:"Bangalore"
},
{
Name:"SmartWorks",
Rent:45000,
Address:"Pune"
}
]
```

Output

```text
Office Space, at Affordable Range

[Office Image]

Name : DBS
Rent : 50000 (Red)
Address : Chennai

--------------------------

Name : Regus
Rent : 75000 (Green)
Address : Hyderabad

--------------------------

Name : WeWork
Rent : 65000 (Green)
Address : Bangalore

--------------------------

Name : SmartWorks
Rent : 45000 (Red)
Address : Pune
```

This matches the expected behavior described in the uploaded hands-on lab. :contentReference[oaicite:2]{index=2}

---

# 17. How to Run the Project

## Step 1

Create the project.

```bash
npx create-react-app officespacerentalapp
```

---

## Step 2

Navigate into the project.

```bash
cd officespacerentalapp
```

---

## Step 3

Open in Visual Studio Code.

```bash
code .
```

---

## Step 4

Copy the office image into the `src` folder.

```text
src
│
├── office.jpg
```

---

## Step 5

Replace

- App.js
- App.css
- index.js
- index.css

with the implementation provided.

---

## Step 6

Run the project.

```bash
npm start
```

---

## Step 7

Open

```text
http://localhost:3000
```

---

## Useful Commands

| Command | Purpose |
|----------|----------|
| `npm install` | Install dependencies |
| `npm start` | Run React application |
| `npm test` | Execute tests |
| `npm run build` | Generate production build |
| `Ctrl + C` | Stop development server |

---

# 18. Testing

Verify the following:

| Test Case | Expected Result |
|------------|-----------------|
| Application compiles successfully | ✅ |
| Heading is displayed | ✅ |
| Office image is visible | ✅ |
| Single office details are shown | ✅ |
| Office list is displayed | ✅ |
| `map()` displays every office | ✅ |
| Rent ≤ 60000 appears in red | ✅ |
| Rent > 60000 appears in green | ✅ |
| No console errors | ✅ |
| JSX expressions render correctly | ✅ |

---

# 19. Best Practices

- Use meaningful variable names.
- Store related information inside objects.
- Use arrays to manage multiple records.
- Use `map()` instead of writing repetitive JSX.
- Keep JSX clean and readable.
- Use `const` whenever values do not change.
- Separate styling into CSS where possible.
- Use inline CSS only for dynamic styles.
- Always provide a unique `key` when rendering lists.

---

# 20. Common Mistakes

### Mistake 1

Using HTML attributes instead of JSX attributes.

Wrong

```html
class="card"
```

Correct

```jsx
className="card"
```

---

### Mistake 2

Forgetting curly braces around JavaScript expressions.

Wrong

```jsx
<h2>office.Name</h2>
```

Correct

```jsx
<h2>{office.Name}</h2>
```

---

### Mistake 3

Incorrect image path.

Wrong

```jsx
import office from "./images/office.jpg";
```

Correct

```jsx
import office from "./office.jpg";
```

---

### Mistake 4

Forgetting the `key` property inside `map()`.

Wrong

```jsx
<div>
```

Correct

```jsx
<div key={index}>
```

---

### Mistake 5

Incorrect conditional styling.

Wrong

```jsx
style={{color:"red"}}
```

This makes every rent red.

Correct

```jsx
style={{
color:
officeItem.Rent <= 60000
? "red"
: "green"
}}
```

---

# 21. Real-world Applications

JSX is used in almost every React application.

Examples include:

- Office Rental Portals
- Real Estate Websites
- Shopping Applications
- Banking Dashboards
- Hospital Management Systems
- Employee Portals
- Hotel Booking Systems
- Student Management Systems
- Inventory Management Applications
- E-Commerce Platforms

---

# 22. Advantages

| Advantage | Explanation |
|------------|-------------|
| Easy to Read | JSX resembles HTML. |
| Less Code | Reduces boilerplate compared to `React.createElement()`. |
| Dynamic UI | JavaScript expressions can be embedded directly. |
| Better Maintainability | Data and UI remain closely connected. |
| Reusable Components | Encourages modular application design. |
| Powerful Rendering | Easily renders lists and dynamic content. |

---

# 23. Limitations

- Uses static office data instead of a database.
- Reuses a single office image for all office cards.
- No user interaction (forms or events).
- No backend or API integration.
- Styling is intentionally simple because the focus is on learning JSX concepts.

---

# Exercise 10: React JSX

## Week 5 – ReactJS Hands-on Lab

> **Response 4 of 4**

---

# Table of Contents

24. Frequently Asked Interview Questions

25. Quick Revision

- Important Concepts
- Important Files
- Important Commands
- JSX Cheat Sheet
- Project Workflow
- Key Takeaways

26. Conclusion

27. Next Learning Path

---

# 24. Frequently Asked Interview Questions

---

## Q1. What is React?

**Answer**

React is an open-source JavaScript library developed by Meta (Facebook) for building fast, interactive, and reusable user interfaces.

---

## Q2. What is JSX?

**Answer**

JSX (JavaScript XML) is a syntax extension for JavaScript that allows developers to write HTML-like code inside JavaScript.

---

## Q3. Is JSX HTML?

**Answer**

No.

JSX looks like HTML, but it is actually JavaScript syntax that is converted into JavaScript function calls before execution.

---

## Q4. What is the advantage of JSX?

**Answer**

- Easier to read
- Easier to write
- Supports JavaScript expressions
- Improves developer productivity

---

## Q5. What is `React.createElement()`?

**Answer**

It is the JavaScript function React uses to create React elements.

JSX is automatically converted into `React.createElement()` calls during compilation.

---

## Q6. Why do we use JSX instead of `React.createElement()`?

**Answer**

JSX is much more readable and easier to maintain than writing nested `React.createElement()` calls.

---

## Q7. What are JSX expressions?

**Answer**

JavaScript expressions written inside curly braces `{}` within JSX.

Example:

```jsx
<h1>{title}</h1>
```

---

## Q8. What are JSX attributes?

**Answer**

Attributes provide additional information to JSX elements.

Examples:

- `src`
- `alt`
- `className`
- `style`

---

## Q9. Why is `className` used instead of `class`?

**Answer**

`class` is a reserved keyword in JavaScript.

React uses `className` for CSS classes.

---

## Q10. What is inline CSS in JSX?

**Answer**

Inline CSS is applied using the `style` attribute, which accepts a JavaScript object.

Example:

```jsx
style={{ color: "red" }}
```

---

## Q11. How are JavaScript objects used in React?

**Answer**

Objects are used to store related data such as office details, user information, or product information.

---

## Q12. Why do we use arrays of objects?

**Answer**

They allow multiple records of similar data to be stored and displayed dynamically.

---

## Q13. What is `map()`?

**Answer**

`map()` is an array method that processes every element of an array and returns a new array.

In React, it is commonly used to render lists of JSX elements.

---

## Q14. Why is `map()` preferred over writing repeated JSX?

**Answer**

It reduces code duplication and automatically generates UI for each item in a collection.

---

## Q15. What is the purpose of the `key` prop?

**Answer**

The `key` prop uniquely identifies each element in a rendered list, helping React efficiently update the UI.

---

## Q16. What is the Virtual DOM?

**Answer**

The Virtual DOM is a lightweight copy of the Real DOM that React uses to detect changes and update only the necessary parts of the page.

---

## Q17. What is the Real DOM?

**Answer**

The Real DOM is the actual Document Object Model displayed in the browser.

---

## Q18. What is rendering in React?

**Answer**

Rendering is the process of converting React components into browser-visible HTML.

---

## Q19. Why is JSX faster to develop with?

**Answer**

It combines JavaScript and HTML-like syntax, reducing the amount of code developers need to write.

---

## Q20. What is the purpose of `ReactDOM.createRoot()`?

**Answer**

It creates the React root where the application is rendered into the browser.

---

## Q21. What does `npm start` do?

**Answer**

It starts the React development server and opens the application in the browser.

---

## Q22. Why are curly braces `{}` used in JSX?

**Answer**

Curly braces allow JavaScript expressions to be evaluated and displayed inside JSX.

---

## Q23. What happens if the image path is incorrect?

**Answer**

The image will not be displayed, and the browser may show a broken image icon.

---

## Q24. Why is conditional styling used in this project?

**Answer**

To visually distinguish office rents:

- Rent ≤ 60000 → Red
- Rent > 60000 → Green

---

## Q25. Can JSX contain JavaScript logic?

**Answer**

Yes. JSX can include JavaScript expressions, conditional operators, function calls, and variables inside curly braces.

---

# 25. Quick Revision

---

# Important Concepts

| Concept | Summary |
|----------|---------|
| React | JavaScript library for building user interfaces |
| JSX | HTML-like syntax used in React |
| React.createElement() | Function used internally to create React elements |
| JSX Expressions | JavaScript code inside `{}` |
| JSX Attributes | Properties assigned to JSX elements |
| Inline CSS | Styling applied using the `style` attribute |
| Object | Stores related data as key-value pairs |
| Array of Objects | Stores multiple records |
| `map()` | Displays collections dynamically |
| Conditional Styling | Changes appearance based on conditions |

---

# Important Files

| File | Purpose |
|------|---------|
| `App.js` | Main React component containing the application logic |
| `office.jpg` | Office image displayed in the application |
| `App.css` | Styles the application layout |
| `index.js` | Entry point that renders the React application |
| `index.css` | Global CSS styling |
| `package.json` | Project configuration and dependencies |

---

# Important Commands

| Command | Purpose |
|----------|----------|
| `npx create-react-app officespacerentalapp` | Create a new React project |
| `cd officespacerentalapp` | Navigate to the project directory |
| `code .` | Open the project in Visual Studio Code |
| `npm install` | Install project dependencies |
| `npm start` | Start the development server |
| `npm test` | Run test cases |
| `npm run build` | Generate the production build |
| `Ctrl + C` | Stop the development server |

---

# JSX Cheat Sheet

| Feature | Syntax |
|----------|--------|
| JSX Element | `<h1>Hello</h1>` |
| JavaScript Expression | `{variable}` |
| Image | `<img src={image} />` |
| CSS Class | `className="card"` |
| Inline CSS | `style={{ color: "red" }}` |
| `map()` | `array.map()` |
| Object Property | `office.Name` |
| Conditional Styling | `condition ? "red" : "green"` |

---

# Complete Project Workflow

```text
Create React Project

        │

        ▼

Create Office Image

        │

        ▼

Create Office Object

        │

        ▼

Create Office Array

        │

        ▼

Write JSX

        │

        ▼

Display Office Details

        │

        ▼

Loop Through Office List

        │

        ▼

Apply Inline CSS

        │

        ▼

Render JSX

        │

        ▼

Browser Displays Output
```

---

# Key Takeaways

- JSX makes React code easier to read and write than using `React.createElement()`.
- JavaScript expressions inside `{}` allow dynamic data to be displayed.
- Objects are useful for storing related information like office details.
- Arrays of objects make it easy to manage and display multiple records.
- `map()` is the preferred way to render lists in React.
- Inline CSS enables dynamic styling based on conditions.
- The rent color changes according to the rule specified in the hands-on lab:
  - **Rent ≤ 60000 → Red**
  - **Rent > 60000 → Green** :contentReference[oaicite:0]{index=0}
- React components organize code into reusable and maintainable units.

---

# 26. Conclusion

In this exercise, you learned how **JSX** simplifies the creation of user interfaces in React applications. By building the **Office Space Rental App**, you practiced creating JSX elements, using JavaScript expressions, rendering images, displaying object data, iterating through arrays with `map()`, and applying inline CSS based on conditions.

The application demonstrates how React combines JavaScript and HTML-like syntax to build dynamic user interfaces with minimal code. These are the core concepts introduced in the uploaded ReactJS Hands-on Lab. :contentReference[oaicite:1]{index=1}

After completing this exercise, you should be comfortable with:

- Writing JSX syntax.
- Understanding how JSX is rendered to the DOM.
- Using JavaScript expressions inside JSX.
- Displaying data from objects and arrays.
- Rendering lists using `map()`.
- Applying dynamic inline styling.
- Building simple React applications using JSX.

---

# 27. Next Learning Path

After mastering React JSX, continue learning in the following order:

```text
JavaScript Fundamentals
        │
        ▼
ES6 Features
        │
        ▼
React Components
        │
        ▼
JSX
        │
        ▼
Props
        │
        ▼
State
        │
        ▼
Event Handling
        │
        ▼
Forms
        │
        ▼
Component Lifecycle
        │
        ▼
React Hooks
(useState, useEffect)
        │
        ▼
React Router
        │
        ▼
REST API Integration
        │
        ▼
Context API
        │
        ▼
State Management
(Redux / Zustand)
```

Mastering JSX is a fundamental step in React development because almost every React component is written using JSX. A strong understanding of these concepts will make it much easier to build larger applications, work with reusable components, and prepare for React-based technical interviews.

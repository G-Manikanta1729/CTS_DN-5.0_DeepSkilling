# Exercise 2: Create React Components

## Week 5 – ReactJS Hands-on Lab

---

# Objective

The objective of this exercise is to understand **React Components**, which are the fundamental building blocks of every React application. In this hands-on, you will create multiple **Class Components** (`Home`, `About`, and `Contact`) for a **Student Management Portal** and render them together from the main `App` component.

This exercise introduces the concept of modular UI development, where different sections of an application are developed independently and then combined to build a complete application.

---

# Learning Outcomes

After completing this exercise, you will be able to:

- Understand what React Components are.
- Differentiate React Components from normal JavaScript functions.
- Explain the types of React Components.
- Create Class Components.
- Understand the purpose of the `render()` method.
- Understand the purpose of the Component constructor.
- Organize React applications using multiple components.
- Import and Export React Components.
- Render multiple components inside another component.
- Understand how React applications become modular and reusable.

---

# Prerequisites

Before starting this exercise, ensure you have:

- Node.js installed
- npm installed
- Visual Studio Code installed
- Basic knowledge of JSX
- Successfully completed **Exercise 1 – Create Your First React Application**

---

# Concepts Covered

---

# 1. What is a React Component?

A Component is an independent and reusable piece of UI.

Instead of writing one huge webpage, React divides the UI into several smaller components.

Each component performs one specific task.

Think of a website like building a house.

```
House
│
├── Living Room
├── Kitchen
├── Bedroom
└── Bathroom
```

Each room is independent.

Similarly,

```
React Application
│
├── Header
├── Navbar
├── Home
├── About
├── Contact
└── Footer
```

Each section is a component.

---

# Why Components?

Without components

```
One file

1000+
2000+
5000+
lines of code
```

Very difficult to

- Read
- Debug
- Reuse
- Maintain

With components

```
Home.js

About.js

Contact.js

Header.js

Footer.js
```

Each file performs only one task.

Advantages

- Easy to maintain
- Easy to debug
- Easy to reuse
- Better readability
- Faster development
- Cleaner project structure

---

# Characteristics of Components

A React Component

- is reusable
- is independent
- returns JSX
- can be nested
- can receive data using Props
- can maintain State (Class Components)

---

# Components vs JavaScript Functions

| React Component | JavaScript Function |
|-----------------|--------------------|
| Returns JSX | Returns any JavaScript value |
| Used for UI | Used for logic |
| Starts with Capital Letter | Can start with lowercase |
| Rendered using `<Component/>` | Called using `functionName()` |
| Can use Props and State | Cannot directly use React features |

Example

JavaScript Function

```javascript
function add(a, b) {
    return a + b;
}
```

React Component

```jsx
function Home() {
    return <h1>Home Component</h1>;
}
```

---

# Types of React Components

There are two types.

## 1. Function Component

Modern React applications mostly use Function Components.

Example

```jsx
function Home() {
    return <h2>Home</h2>;
}

export default Home;
```

---

## 2. Class Component

Used in this hands-on.

Class Components extend the `Component` class and implement the `render()` method.

Example

```jsx
import React, { Component } from 'react';

class Home extends Component {
    render() {
        return (
            <h2>Home</h2>
        );
    }
}

export default Home;
```

---

# Why Class Components?

Before React Hooks were introduced, Class Components were the only way to use:

- State
- Lifecycle Methods
- Event Handling
- Component Logic

Although Function Components are now preferred, understanding Class Components is important because many enterprise applications still use them.

---

# Understanding `extends Component`

```jsx
class Home extends Component
```

means

Home inherits all features of React's Component class.

This enables:

- `render()`
- State
- Lifecycle methods
- Props

---

# What is `render()`?

The `render()` method tells React what should appear on the screen.

Example

```jsx
render() {
    return (
        <h2>Home</h2>
    );
}
```

Whenever React needs to display or update a component, it calls the `render()` method.

---

# What is a Constructor?

A constructor is a special method used to initialize a Class Component.

Syntax

```jsx
constructor(props){
    super(props);
}
```

Although this exercise does not use a constructor, it is an important concept because constructors are commonly used to initialize component state.

Example

```jsx
constructor(props){
    super(props);

    this.state = {
        name: "Student"
    };
}
```

---

# What is `export default`?

```jsx
export default Home;
```

This makes the component available to other files.

Without exporting, other components cannot import and use it.

---

# What is `import`?

Example

```jsx
import Home from './Components/Home';
```

This imports the `Home` component into `App.js`.

---

# Component Relationship in this Exercise

```
App
│
├── Home
├── About
└── Contact
```

The `App` component is the parent.

The `Home`, `About`, and `Contact` components are child components.

---

# Project Structure

```
StudentApp
│
├── node_modules
├── public
│
├── src
│   │
│   ├── Components
│   │      ├── Home.js
│   │      ├── About.js
│   │      └── Contact.js
│   │
│   ├── App.js
│   ├── App.css
│   ├── index.js
│   └── index.css
│
├── package.json
└── package-lock.json
```

---

# Implementation

## Step 1

Create the React project.

```bash
npx create-react-app studentapp
```

> **Note:** Modern npm versions do not allow uppercase letters in project names. Although the lab document uses `StudentApp`, use `studentapp` (or another lowercase name) to avoid npm naming restrictions while keeping the implementation identical. :contentReference[oaicite:0]{index=0}

---

## Step 2

Navigate into the project.

```bash
cd studentapp
```

---

## Step 3

Open VS Code.

```bash
code .
```

---

## Step 4

Create the folder

```
src
    │
    └── Components
```

---

## Step 5

Create

```
Home.js
```

```jsx
import React, { Component } from 'react';

class Home extends Component {

    render() {
        return (
            <div>
                <h3>Welcome to the Home Page of Student Management Portal</h3>
            </div>
        );
    }

}

export default Home;
```

---

## Step 6

Create

```
About.js
```

```jsx
import React, { Component } from 'react';

class About extends Component {

    render() {
        return (
            <div>
                <h3>Welcome to the About Page of Student Management Portal</h3>
            </div>
        );
    }

}

export default About;
```

---

## Step 7

Create

```
Contact.js
```

```jsx
import React, { Component } from 'react';

class Contact extends Component {

    render() {
        return (
            <div>
                <h3>Welcome to the Contact Page of Student Management Portal</h3>
            </div>
        );
    }

}

export default Contact;
```

---

## Step 8

Modify `App.js`

```jsx
import './App.css';

import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';

function App() {

    return (

        <div className="container">

            <Home />
            <About />
            <Contact />

        </div>

    );

}

export default App;
```

---

## Step 9 (Optional Styling)

To make the output similar to the document:

```css
.container{
    text-align:center;
    margin-top:80px;
}

h3{
    margin:20px;
}
```

---

## Step 10

Run the project.

```bash
npm start
```

Open

```
http://localhost:3000
```

---

# Expected Output

```
Welcome to the Home Page of Student Management Portal

Welcome to the About Page of Student Management Portal

Welcome to the Contact Page of Student Management Portal
```

---

# Files Used

| File | Purpose |
|------|---------|
| Home.js | Displays Home page message |
| About.js | Displays About page message |
| Contact.js | Displays Contact page message |
| App.js | Imports and renders all components |
| App.css | Optional styling |

---

# Component Flow

```
index.js

      │

      ▼

App.js

      │

      ├───────────────┐
      │               │
      ▼               ▼
 Home.js         About.js
      │
      ▼
 Contact.js
```

React starts from `index.js`, renders `App.js`, and then `App.js` renders the three child components.

---

# Commands Used

Create project

```bash
npx create-react-app studentapp
```

Go inside project

```bash
cd studentapp
```

Run application

```bash
npm start
```

Stop application

```
Ctrl + C
```

---

# Common Errors and Solutions

## Cannot create project because of capital letters

**Error**

```
Cannot create a project named "StudentApp"
```

**Reason**

Modern npm package names cannot contain uppercase letters.

**Solution**

```bash
npx create-react-app studentapp
```

---

## Module not found

```
Cannot find './Components/Home'
```

**Reason**

Wrong file name or folder name.

**Solution**

Ensure the folder is named `Components` and the files are named `Home.js`, `About.js`, and `Contact.js`.

---

## Component not rendering

**Reason**

Forgot to export the component.

**Solution**

```jsx
export default Home;
```

---

## JSX Syntax Error

Ensure every component returns a single parent element.

Correct

```jsx
return(
    <div>
        <h3>Hello</h3>
    </div>
)
```

---

# Key Takeaways

- Components are the building blocks of React applications.
- Class Components extend `React.Component` and use the `render()` method to display UI.
- The `App` component can act as a parent that renders multiple child components.
- `import` and `export` enable component reuse across files.
- Organizing code into multiple components improves readability, maintainability, and scalability.
- Although modern React favors Function Components and Hooks, understanding Class Components is valuable because many existing enterprise applications still use them.

---

# Conclusion

This exercise demonstrates how React applications are structured using reusable components. By creating separate `Home`, `About`, and `Contact` Class Components and rendering them through the parent `App` component, you learn the fundamentals of component-based architecture. These concepts form the foundation for building scalable React applications, where each part of the user interface is developed, maintained, and reused independently. This hands-on also introduces essential React concepts such as component creation, importing/exporting modules, rendering child components, and organizing projects into a clean, modular structure based on the workflow described in the lab document. :contentReference[oaicite:1]{index=1}

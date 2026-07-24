# Exercise 14: React Context API

## Week 5 – ReactJS Hands-on Lab

> **Response 1 of 4**

---

# Table of Contents

1. Project Title

2. Introduction

3. Learning Objectives

4. Prerequisites

5. Background Concepts

- What is State?
- What are Props?
- Parent-to-Child Communication
- What is Props Drilling?
- Problems with Props Drilling
- What is React Context API?
- Why do we need Context API?
- createContext()
- Context Provider
- Context Consumer
- useContext() Hook
- Theme Switching
- Project Overview
- High-Level Architecture
- Technologies Used

---

# 1. Project Title

# React Context API

**Week 5 – ReactJS Hands-on Lab**

**Exercise 14 – React Context API**

---

# 2. Introduction

## What is this project?

This hands-on exercise demonstrates how React's **Context API** can be used to share data between multiple components without passing it manually through every intermediate component.

According to the uploaded hands-on lab, an Employee Management Application currently passes the **theme name** using React **state** and **props** from the `App` component to `EmployeesList` and then to `EmployeeCard`. The objective of this exercise is to replace this approach with the **React Context API**. :contentReference[oaicite:0]{index=0}

---

## What problem does this project solve?

Consider the following component hierarchy.

```text
App

↓

EmployeesList

↓

EmployeeCard
```

Initially,

the **theme** travels through every component.

```text
App

↓

theme

↓

EmployeesList

↓

theme

↓

EmployeeCard
```

Even though `EmployeesList` does not actually use the theme, it still receives and forwards it.

This unnecessary passing of data is called **Props Drilling**.

---

## Why was Context API introduced?

Imagine an application containing

- Dashboard
- Employee List
- Employee Card
- Profile
- Settings
- Notifications

Suppose all these components need the current theme.

Without Context API,

the theme must be passed through every intermediate component.

```text
App

↓

Dashboard

↓

Employees

↓

EmployeeCard

↓

Button
```

As applications grow larger,

this becomes difficult to manage.

React Context API solves this problem.

---

## What is Props Drilling?

Props Drilling means passing data through multiple components even when intermediate components do not use it.

Example

```text
App

↓

Theme

↓

EmployeesList

↓

Theme

↓

EmployeeCard
```

Here,

only **EmployeeCard** requires the theme,

but **EmployeesList** receives it only to forward it.

---

## How does Context API solve this?

Context API creates a shared storage.

Instead of passing

```text
App

↓

EmployeesList

↓

EmployeeCard
```

the data becomes

```text
Theme Context

↓

EmployeeCard
```

Now,

`EmployeeCard`

can directly access the theme.

---

## Real-world Applications

React Context API is widely used for

- Light and Dark Themes
- User Authentication
- Logged-in User Information
- Language Selection
- Shopping Cart
- Notifications
- User Preferences
- Global Application Settings
- Banking Dashboards
- Hospital Management Systems

---

## Why is Theme Switching a good example?

Themes are needed by many components.

For example

```text
Header

Sidebar

Buttons

Cards

Footer
```

Passing the theme individually to every component is inefficient.

Context API provides the same value to every component that needs it.

---

# 3. Learning Objectives

According to the uploaded hands-on lab, after completing this exercise you should be able to:

- Explain the need and benefits of React Context API.
- Work with `createContext()`.
- Create a Context to be used by child components.
- Create a Provider and Consumer of the Context.
- Use React Context API instead of Props Drilling. :contentReference[oaicite:1]{index=1}

In this implementation you will also learn:

- Theme management
- Global state sharing
- `useContext()` Hook
- Cleaner component communication
- Reusable React components

---

# 4. Prerequisites

The uploaded hands-on lab specifies the following prerequisites:

| Software | Purpose |
|----------|----------|
| Node.js | JavaScript Runtime |
| npm | Package Manager |
| Visual Studio Code | Code Editor | :contentReference[oaicite:2]{index=2}

Basic knowledge of

- HTML
- CSS
- JavaScript
- React Components
- Props
- State

is recommended.

---

# 5. Background Concepts

---

# 5.1 What is State?

## Definition

State is a built-in React object used to store information that may change while the application is running.

Example

```jsx
const [theme, setTheme] = useState("light");
```

Whenever the state changes,

React automatically updates the user interface.

---

## State Flow

```text
State Changes

↓

React Re-renders

↓

Updated UI
```

---

# 5.2 What are Props?

## Definition

Props (Properties) are used to send data from a parent component to a child component.

Example

```jsx
<EmployeeCard

theme={theme}

/>
```

Flow

```text
Parent

↓

Props

↓

Child
```

Props are **read-only**.

Child components cannot modify them.

---

# 5.3 Parent-to-Child Communication

Normally,

React shares information like this.

```text
App

↓

EmployeesList

↓

EmployeeCard
```

Every component receives information through Props.

This works well for small applications.

---

# 5.4 What is Props Drilling?

## Definition

Props Drilling means passing data through several components,

even when intermediate components do not use that data.

Example

```text
App

↓

theme

↓

EmployeesList

↓

theme

↓

EmployeeCard
```

Here,

`EmployeesList`

does not use the theme,

but it must still receive and pass it.

This makes code difficult to maintain.

The uploaded hands-on lab specifically identifies this as the problem to solve using React Context API. :contentReference[oaicite:3]{index=3}

---

# 5.5 Problems with Props Drilling

As applications grow,

Props Drilling causes several issues.

### Extra Code

Every intermediate component receives unnecessary props.

---

### Difficult Maintenance

Changing one prop often requires updating many files.

---

### Reduced Readability

Large component hierarchies become difficult to understand.

---

### Poor Scalability

As more nested components are added,

the amount of prop passing increases.

---

# 5.6 What is React Context API?

## Definition

React Context API is a built-in feature that allows data to be shared among multiple components without manually passing Props through every level.

Instead of

```text
App

↓

EmployeesList

↓

EmployeeCard
```

React stores the value inside

```text
Context
```

Any component can access it directly.

---

## Context Flow

```text
Provider

↓

Context

↓

Consumer
```

---

# 5.7 Why do we need Context API?

Context API simplifies communication between components.

Instead of passing

```text
Theme

↓

Props

↓

Props

↓

Props
```

React provides

```text
Theme Context

↓

Required Component
```

Only the component that needs the data accesses it.

This is exactly what the uploaded HOL requires by replacing Props with Context API. :contentReference[oaicite:4]{index=4}

---

# 5.8 createContext()

`createContext()` creates a new Context object.

Example

```jsx
const ThemeContext = createContext("light");
```

Here,

the default theme is

```text
light
```

The uploaded hands-on lab specifically instructs creating `ThemeContext.js` with a default value of `"light"`. :contentReference[oaicite:5]{index=5}

---

# 5.9 Context Provider

The Provider supplies data to child components.

Example

```jsx
<ThemeContext.Provider value={theme}>

...

</ThemeContext.Provider>
```

Every component inside the Provider can access the shared value.

---

## Provider Flow

```text
Theme

↓

Provider

↓

All Child Components
```

---

# 5.10 Context Consumer

A Consumer retrieves data from the Context.

Modern React typically uses the `useContext()` Hook instead of the older Consumer component.

The uploaded hands-on lab instructs retrieving the Context value with `useContext()`. :contentReference[oaicite:6]{index=6}

---

# 5.11 useContext() Hook

`useContext()` reads the current Context value.

Example

```jsx
const theme = useContext(ThemeContext);
```

Now,

`theme`

contains

```text
light
```

or

```text
dark
```

depending on the Provider.

---

# 5.12 Theme Switching

The application stores the theme inside React State.

Example

```text
light

↓

dark

↓

light

↓

dark
```

Whenever the state changes,

the Provider automatically shares the new value with every component using the Context.

---

# 6. Project Overview

The Employee Management Application demonstrates how to replace Props Drilling with the React Context API.

The application:

- Creates a Theme Context.
- Wraps the application inside a Context Provider.
- Shares the current theme globally.
- Removes unnecessary prop passing.
- Retrieves the theme using `useContext()`.
- Applies the theme to employee buttons.

This follows the objectives described in the uploaded hands-on lab. :contentReference[oaicite:7]{index=7}

---

# 7. High-Level Architecture

```text
                  React Application
                         │
                         ▼
                      App.js
                         │
                         ▼
              ThemeContext.Provider
                         │
              value = "light"/"dark"
                         │
                         ▼
                  EmployeesList
                         │
                         ▼
                   EmployeeCard
                         │
                         ▼
         useContext(ThemeContext)
                         │
                         ▼
             Apply Theme to Button
```

---

# 8. Technologies Used

| Technology | Purpose | Role in this Project |
|------------|---------|----------------------|
| **React** | JavaScript library | Builds reusable UI components |
| **Context API** | Global state sharing | Eliminates Props Drilling |
| **createContext()** | Context creation | Creates `ThemeContext` |
| **useContext()** | Context consumption | Reads the current theme |
| **React State** | State management | Stores the current theme |
| **JavaScript (ES6)** | Programming language | Implements application logic |
| **Node.js** | JavaScript runtime | Runs the React application |
| **npm** | Package manager | Installs project dependencies |
| **Visual Studio Code** | Code editor | Used to develop the application |
| **CSS** | Styling | Styles the employee cards and buttons |

---


# Exercise 14: React Context API

## Week 5 – ReactJS Hands-on Lab

> **Response 2 of 4**

---

# 9. Project Structure

The Employee Management Application is organized into multiple reusable React components.

Each component has a specific responsibility.

This improves

- Readability
- Reusability
- Maintainability
- Scalability

Project Structure

```text
employeesapp
│
├── node_modules
│
├── public
│
├── src
│   │
│   ├── components
│   │      │
│   │      ├── EmployeesList.js
│   │      └── EmployeeCard.js
│   │
│   ├── ThemeContext.js
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

This folder contains all installed npm packages.

Examples include

- React
- React DOM
- Babel
- Webpack

It is automatically created after executing

```bash
npm install
```

---

## public

The **public** folder stores static resources used by the application.

Examples

- index.html
- favicon
- images

React renders the application inside

```text
index.html
```

---

## src

The **src** folder contains the complete application source code.

It includes

- Components
- Context
- CSS
- Main App
- Entry Point

---

## components

Contains reusable React components.

This project contains

```text
EmployeesList.js

EmployeeCard.js
```

Each component performs only one task.

---

# 11. File-by-File Explanation

---

# ThemeContext.js

## Purpose

Creates the application's Theme Context.

Instead of passing

```text
theme

↓

EmployeesList

↓

EmployeeCard
```

the Context stores the theme in one shared location.

---

## Implementation

```jsx
const ThemeContext = createContext("light");
```

Default Value

```text
light
```

The uploaded hands-on lab specifically instructs creating `ThemeContext.js`, defining `ThemeContext`, assigning `"light"` as the default value, and exporting it. :contentReference[oaicite:0]{index=0}

---

# App.js

## Purpose

App.js is the root component.

Responsibilities

- Store the theme in React State.
- Create Theme Provider.
- Pass theme through Context.
- Display Employee List.
- Remove Props Drilling.

---

## State

```jsx
const [theme,setTheme]=useState("light");
```

Stores

```text
light

or

dark
```

---

## Theme Provider

```jsx
<ThemeContext.Provider

value={theme}

>

...

</ThemeContext.Provider>
```

Every child component inside the Provider receives access to the theme.

The uploaded hands-on lab requires wrapping the entire JSX with the Provider and assigning the Provider value from the component state. :contentReference[oaicite:1]{index=1}

---

## Removing Props

Old approach

```text
App

↓

EmployeesList

↓

EmployeeCard
```

Theme Prop

↓

Theme Prop

↓

Button

---

New approach

```text
Provider

↓

Context

↓

EmployeeCard
```

No theme props are passed.

---

# EmployeesList.js

## Purpose

Displays all employee cards.

Responsibilities

- Receive Employee List.
- Iterate through employees.
- Render EmployeeCard.
- Do NOT pass Theme.

Example

```jsx
<EmployeeCard

employee={employee}

/>
```

Notice

```text
theme

is NOT passed.
```

The uploaded hands-on lab specifically asks to modify `EmployeesList` so that the theme is no longer passed explicitly to its child component. :contentReference[oaicite:2]{index=2}

---

## Why?

Since Context is global,

EmployeeCard can directly access Theme.

No intermediate component needs to receive or forward it.

---

# EmployeeCard.js

## Purpose

Displays employee information.

Responsibilities

- Receive Employee.
- Read Theme using Context.
- Apply Button Theme.

---

## Import Context

```jsx
import ThemeContext
```

---

## Read Context

```jsx
const theme =

useContext(ThemeContext);
```

Now

```text
theme

=

light

or

dark
```

---

## Button

```jsx
<button

className={theme}

>

View Profile

</button>
```

When Theme changes,

the button style changes automatically.

The uploaded hands-on lab instructs importing `ThemeContext`, retrieving the value using `useContext()`, storing it in a variable, and using that variable as the button's `className`. :contentReference[oaicite:3]{index=3}

---

# App.css

## Purpose

Provides styling.

Contains

- Page Alignment
- Employee Card Design
- Light Theme
- Dark Theme
- Button Styles

---

## Light Theme

```css
.light{

background:white;

color:black;

}
```

Button

```text
White

Black Text
```

---

## Dark Theme

```css
.dark{

background:black;

color:white;

}
```

Button

```text
Black

White Text
```

---

# index.js

## Purpose

Application Entry Point.

Creates React Root.

```jsx
ReactDOM.createRoot()
```

Renders

```jsx
<App/>
```

inside

```text
index.html
```

---

# index.css

## Purpose

Contains global CSS.

Example

```css
body{

margin:0;

}
```

Applies styles to the complete application.

---

# 12. Configuration Explanation

Create project

```bash
npx create-react-app employeesapp
```

Move into project

```bash
cd employeesapp
```

Install packages

```bash
npm install
```

Start application

```bash
npm start
```

Open Browser

```text
http://localhost:3000
```

---

# 13. Implementation Explanation

The implementation follows these steps.

### Step 1

Application Starts

↓

App.js

---

### Step 2

Create Theme State

```text
light
```

---

### Step 3

Create ThemeContext

```text
createContext()

↓

ThemeContext
```

---

### Step 4

Wrap App using Provider

```text
ThemeContext.Provider

↓

Entire Application
```

---

### Step 5

Render EmployeesList

↓

EmployeeCard

---

### Step 6

EmployeeCard reads Context

```text
useContext()

↓

Theme
```

---

### Step 7

Button receives

```text
className

↓

light

or

dark
```

---

### Step 8

Click

```text
Switch Theme
```

↓

Theme changes

↓

Context updates

↓

Buttons update automatically

---

# 14. Code Flow

```text
Application Starts

↓

App.js

↓

Create Theme State

↓

ThemeContext.Provider

↓

EmployeesList

↓

EmployeeCard

↓

useContext()

↓

Theme

↓

Button Class

↓

Browser Output
```

---

# 15. Execution Flow

```text
User Opens Website

↓

App Component

↓

Theme State Created

↓

ThemeContext Provider

↓

EmployeesList Rendered

↓

EmployeeCard Rendered

↓

EmployeeCard Reads Context

↓

Theme Applied

↓

Button Displayed

↓

User Clicks

Switch Theme

↓

Theme Changes

↓

Provider Updates

↓

EmployeeCard Re-renders

↓

Button Theme Changes
```

---

# 16. Internal Working

React internally performs the following sequence.

```text
App.js

↓

useState()

↓

ThemeContext.Provider

↓

Context Object

↓

EmployeeCard

↓

useContext()

↓

Current Theme

↓

Button ClassName

↓

Virtual DOM

↓

Compare Previous DOM

↓

Update Button

↓

Browser Output
```

Notice that **EmployeesList** is no longer responsible for forwarding the theme.

Instead,

React Context delivers the value directly to the component that requires it.

---

# 17. Context API Implementation

## Step 1 — Creating Context

```text
createContext()

↓

ThemeContext
```

---

## Step 2 — Providing Context

```jsx
<ThemeContext.Provider

value={theme}

>
```

The Provider makes the theme available to all nested components.

---

## Step 3 — Consuming Context

```jsx
const theme =

useContext(ThemeContext);
```

Now the component can directly access the shared value.

---

## Step 4 — Theme Switching Flow

```text
Button Click

↓

State Changes

↓

ThemeContext.Provider

↓

Context Updated

↓

EmployeeCard

↓

useContext()

↓

Button Class Updated
```

---

## Step 5 — Removing Props Drilling

### Before Context API

```text
App

↓

theme Prop

↓

EmployeesList

↓

theme Prop

↓

EmployeeCard
```

---

### After Context API

```text
App

↓

ThemeContext.Provider

↓

EmployeeCard

↓

useContext()
```

The uploaded hands-on lab specifically asks to replace prop passing with the React Context API, remove explicit theme passing from `EmployeesList`, and access the theme directly in `EmployeeCard`. :contentReference[oaicite:4]{index=4}

---

# Exercise 14: React Context API

## Week 5 – ReactJS Hands-on Lab

> **Response 3 of 4**

---

# 18. Concepts Explained in Detail

The uploaded hands-on lab focuses on implementing the following concepts:

- React Context API
- `createContext()`
- Context Provider
- Context Consumer
- `useContext()`
- Replacing Props Drilling
- Theme Sharing between Components :contentReference[oaicite:0]{index=0}

These concepts are essential for sharing data globally in React applications.

---

# 18.1 React Context API

## Definition

React Context API is a built-in feature that allows data to be shared among multiple components without manually passing props through every intermediate component.

Instead of

```text
App

↓

EmployeesList

↓

EmployeeCard
```

React creates one shared Context.

```text
Theme Context

↓

EmployeeCard
```

Any component inside the Provider can access the shared value directly.

---

## Why was Context API introduced?

As React applications become larger,

passing data through multiple levels becomes difficult.

Example

```text
App

↓

Dashboard

↓

Employees

↓

Employee Card

↓

Button
```

Without Context,

the same value must travel through every level.

Context API removes this unnecessary data passing.

---

# 18.2 Props Drilling

## Definition

Props Drilling means passing data through components that do not actually use it.

Example

```text
App

↓

theme

↓

EmployeesList

↓

theme

↓

EmployeeCard
```

Only

```text
EmployeeCard
```

requires the theme.

However,

```text
EmployeesList
```

still receives and forwards it.

The uploaded hands-on lab specifically identifies this as the existing problem and asks to replace it using React Context API. :contentReference[oaicite:1]{index=1}

---

## Problems with Props Drilling

- Extra code
- Difficult maintenance
- Poor readability
- Reduced scalability
- Tight coupling between components

---

# 18.3 createContext()

## Definition

`createContext()` creates a Context object.

Syntax

```jsx
const ThemeContext = createContext("light");
```

Here,

```text
light
```

is the default value.

The uploaded hands-on lab instructs creating `ThemeContext` with `"light"` as the default value. :contentReference[oaicite:2]{index=2}

---

## Flow

```text
createContext()

↓

ThemeContext

↓

Provider

↓

Consumer
```

---

# 18.4 Context Provider

## Definition

The Provider supplies data to all child components.

Example

```jsx
<ThemeContext.Provider

value={theme}

>

...

</ThemeContext.Provider>
```

Every component inside the Provider can access the current theme.

---

## Provider Flow

```text
Theme

↓

Provider

↓

EmployeesList

↓

EmployeeCard
```

Although `EmployeesList` is inside the Provider, it does not need to access the theme unless required.

---

# 18.5 Context Consumer

A Consumer reads data from the Context.

Modern React applications generally use the `useContext()` Hook instead of the older `<Context.Consumer>` component.

The uploaded hands-on lab specifically instructs using `useContext()` to retrieve the Context value. :contentReference[oaicite:3]{index=3}

---

# 18.6 useContext() Hook

## Definition

`useContext()` retrieves the current value stored inside a Context.

Example

```jsx
const theme = useContext(ThemeContext);
```

Now,

```text
theme
```

contains

```text
light
```

or

```text
dark
```

depending on the Provider.

---

## Flow

```text
ThemeContext

↓

useContext()

↓

theme Variable

↓

Button Class
```

---

# 18.7 Theme Management

The application stores the theme in React State.

Example

```jsx
const [theme, setTheme] = useState("light");
```

When

```text
theme
```

changes,

the Provider automatically shares the updated value with every component using the Context.

---

## Theme Flow

```text
Switch Theme Button

↓

setTheme()

↓

State Updated

↓

Provider Updated

↓

Context Updated

↓

EmployeeCard

↓

Button Style Updated
```

---

# 18.8 State vs Context

Although both State and Context store data, they have different purposes.

| State | Context |
|--------|---------|
| Stores local component data | Shares global data |
| Used inside one component | Used across multiple components |
| Updated with `useState()` | Accessed using `useContext()` |
| Passed using Props | No Props Drilling required |

In this project,

- **State** stores the current theme.
- **Context** shares that theme with child components.

---

# 18.9 Component Reusability

Context API improves component reusability.

Without Context,

each component depends on receiving multiple props.

With Context,

components request only the shared data they need.

Benefits

- Cleaner components
- Less code
- Better maintenance
- Easier scalability

---

# 19. Sample Input and Output

### Initial Theme

```text
Theme

↓

Light
```

Output

```text
Employee Management System

Switch Theme

John Smith

Software Engineer

[ View Profile ]
```

The **View Profile** button appears using the **light** style.

---

### After Clicking "Switch Theme"

```text
Theme

↓

Dark
```

Output

```text
Employee Management System

Switch Theme

John Smith

Software Engineer

[ View Profile ]
```

The **View Profile** button changes to the **dark** style while the employee information remains the same. This matches the recreated implementation where the Context value is applied to the button's `className`, as described in the HOL. :contentReference[oaicite:4]{index=4}

---

# 20. How to Run the Project

Create the project

```bash
npx create-react-app employeesapp
```

Move into the project

```bash
cd employeesapp
```

Install dependencies

```bash
npm install
```

Run the application

```bash
npm start
```

Open

```text
http://localhost:3000
```

---

# 21. Testing

Verify the following after running the application.

| Test Case | Expected Result |
|-----------|-----------------|
| Application starts | Successfully loads |
| ThemeContext created | Yes |
| Provider added | Yes |
| `EmployeesList` receives no theme prop | Yes |
| `EmployeeCard` uses `useContext()` | Yes |
| Initial button theme | Light |
| After clicking **Switch Theme** | Button changes to dark theme |
| React errors | None |

---

# 22. Best Practices

When using React Context API:

- Create separate Context files.
- Wrap only the components that need the Context.
- Use `useContext()` instead of unnecessary prop passing.
- Keep Context focused on shared data.
- Use meaningful Context names such as `ThemeContext`.
- Avoid storing unrelated values in the same Context.

---

# 23. Common Mistakes

### Forgetting the Provider

Incorrect

```jsx
<EmployeeCard />
```

Correct

```jsx
<ThemeContext.Provider value={theme}>

<EmployeeCard/>

</ThemeContext.Provider>
```

---

### Importing the Wrong Context

Incorrect

```jsx
useContext(UserContext)
```

Correct

```jsx
useContext(ThemeContext)
```

---

### Passing Theme as Props Again

Incorrect

```jsx
<EmployeeCard

theme={theme}
/>
```

Correct

```jsx
<EmployeeCard />
```

The Context should provide the theme.

---

### Forgetting `useContext()`

Incorrect

```jsx
<button>

View Profile

</button>
```

Correct

```jsx
const theme = useContext(ThemeContext);

<button className={theme}>
```

---

# 24. Real-world Applications

React Context API is commonly used in applications that require shared data.

Examples include:

- Theme Management (Light/Dark Mode)
- User Authentication
- Shopping Cart
- Language Selection
- Banking Dashboards
- Hospital Management Systems
- Student Portals
- Employee Management Systems
- Notification Systems
- User Preferences

---

# 25. Advantages

Using React Context API provides:

- Eliminates Props Drilling
- Cleaner code
- Better readability
- Improved maintainability
- Easier scalability
- Global data sharing
- Simplified component communication

---

# 26. Limitations

Although Context API is powerful, it should be used appropriately.

Some limitations include:

- Frequent Context updates can trigger re-renders in consuming components.
- Storing too much unrelated data in a single Context can make it harder to maintain.
- For very large and complex state management requirements, dedicated libraries may be more suitable.

---

# Exercise 14: React Context API

## Week 5 – ReactJS Hands-on Lab

> **Response 4 of 4**

---

# 27. Frequently Asked Interview Questions

## 1. What is React Context API?

React Context API is a built-in React feature used to share data between components without passing props through every intermediate component.

---

## 2. Why was Context API introduced?

To eliminate Props Drilling and simplify data sharing among deeply nested components.

---

## 3. What is Props Drilling?

Props Drilling is the process of passing data through multiple intermediate components that do not actually use the data.

---

## 4. What problem does Props Drilling create?

It increases code complexity, reduces readability, and makes maintenance difficult.

---

## 5. What is `createContext()`?

`createContext()` creates a new Context object.

Example

```jsx
const ThemeContext = createContext("light");
```

---

## 6. What is the default value in `createContext()`?

It is the value used when no Provider supplies a value.

Example

```jsx
createContext("light")
```

---

## 7. What is a Context Provider?

A Provider supplies a Context value to all nested child components.

---

## 8. What is a Context Consumer?

A Consumer retrieves data stored in the Context. Modern React applications commonly use the `useContext()` Hook instead of the older Consumer component.

---

## 9. What is `useContext()`?

`useContext()` is a React Hook used to retrieve the current value from a Context.

---

## 10. Which component stores the theme in this project?

`App.js`

---

## 11. Which file creates the Context?

`ThemeContext.js`

---

## 12. Which component provides the Context?

`App.js` using `ThemeContext.Provider`.

---

## 13. Which component consumes the Context?

`EmployeeCard.js`

---

## 14. Which component no longer passes the theme?

`EmployeesList.js`

---

## 15. Why is `EmployeesList` no longer passing the theme?

Because `EmployeeCard` reads the theme directly from the Context.

---

## 16. Which Hook is used for theme management?

`useState()`

---

## 17. Which Hook is used for reading Context?

`useContext()`

---

## 18. What data is shared using Context in this project?

The current theme (`light` or `dark`).

---

## 19. Why is Context API better than Props Drilling?

It avoids passing data through components that do not need it.

---

## 20. Can multiple components use the same Context?

Yes.

Every component inside the Provider can access the Context.

---

## 21. What happens when the Provider value changes?

All components using that Context receive the updated value and re-render accordingly.

---

## 22. Is Context API built into React?

Yes.

No additional library is required.

---

## 23. Can an application have multiple Contexts?

Yes.

For example:

- ThemeContext
- UserContext
- LanguageContext

---

## 24. What is the purpose of ThemeContext?

To share the current theme across components without using Props.

---

## 25. Can Context replace all state management?

No.

Context is intended for shared data. Local component state should still use `useState()`.

---

## 26. What is the advantage of global data sharing?

It simplifies communication between components and reduces duplicate code.

---

## 27. What happens if a component is outside the Provider?

It receives the default value specified in `createContext()`.

---

## 28. Why is the theme stored in State instead of directly in Context?

State manages changing values, while Context distributes those values to child components.

---

## 29. What is the role of `App.css`?

It styles the application, including the light and dark button themes.

---

## 30. What is the role of `index.js`?

It creates the React root and renders the `App` component.

---

## 31. What is the purpose of wrapping the entire JSX inside the Provider?

It allows all nested child components to access the shared Context value.

---

## 32. Give one real-world example of Context API.

Sharing the logged-in user's information across multiple pages.

---

## 33. What are some common uses of Context API?

- Theme Management
- Authentication
- Language Selection
- Shopping Cart
- User Preferences

---

## 34. What is the biggest advantage of Context API?

It removes unnecessary prop passing and simplifies component communication.

---

## 35. Which React Hook is demonstrated in this exercise?

`useContext()`

---

# 28. Quick Revision

## Project Objective

Build an **Employee Management Application** that replaces **Props Drilling** with the **React Context API** by:

- Creating a Theme Context.
- Providing the Context from `App.js`.
- Removing theme prop passing.
- Accessing the theme using `useContext()`.
- Applying the theme to the employee buttons. :contentReference[oaicite:0]{index=0}

---

## Important Concepts

- React Context API
- Props Drilling
- `createContext()`
- Context Provider
- Context Consumer
- `useContext()`
- State
- Theme Management
- Global Data Sharing
- Component Reusability

---

## Important Files

```text
ThemeContext.js
App.js
EmployeesList.js
EmployeeCard.js
App.css
index.js
index.css
```

---

## Important Commands

### Create Project

```bash
npx create-react-app employeesapp
```

---

### Move to Project

```bash
cd employeesapp
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

# 29. Context API Cheat Sheet

## Create Context

```jsx
import { createContext } from "react";

const ThemeContext = createContext("light");

export default ThemeContext;
```

---

## Provide Context

```jsx
<ThemeContext.Provider value={theme}>

<App/>

</ThemeContext.Provider>
```

---

## Consume Context

```jsx
const theme = useContext(ThemeContext);
```

---

## Apply Theme

```jsx
<button className={theme}>

View Profile

</button>
```

---

## Theme State

```jsx
const [theme, setTheme] = useState("light");
```

---

## Toggle Theme

```jsx
setTheme(

theme === "light"

?

"dark"

:

"light"

);
```

---

# 30. Project Workflow

```text
Start Application

        │
        ▼

App.js

        │
        ▼

Create Theme State

        │
        ▼

ThemeContext.Provider

        │
        ▼

EmployeesList

        │
        ▼

EmployeeCard

        │
        ▼

useContext(ThemeContext)

        │
        ▼

Read Current Theme

        │
        ▼

Apply Button Class

        │
        ▼

Browser Output

        │
        ▼

Click "Switch Theme"

        │
        ▼

State Updated

        │
        ▼

Provider Updated

        │
        ▼

EmployeeCard Re-renders

        │
        ▼

Button Theme Changes
```

---

# 31. Key Takeaways

After completing this exercise, you should understand:

- Why Props Drilling becomes a problem in large applications.
- How React Context API eliminates unnecessary prop passing.
- How to create a Context using `createContext()`.
- How to wrap components with `ThemeContext.Provider`.
- How to retrieve Context values using `useContext()`.
- How State and Context work together.
- How Context improves code readability and maintainability.
- How global data sharing simplifies React applications.

---

# 32. Conclusion

This exercise demonstrated how to replace **Props Drilling** with the **React Context API** in an Employee Management Application.

By creating a `ThemeContext`, wrapping the application with a **Provider**, and retrieving the theme using the **`useContext()` Hook**, the application shares the current theme directly with nested components without passing it through intermediate components.

According to the uploaded hands-on lab, the implementation focuses on creating a Context, defining a Provider and Consumer, assigning the Provider value from the component state, removing explicit theme prop passing, and applying the Context value to the employee button's `className`. :contentReference[oaicite:1]{index=1}

---

# 33. Next Learning Path

After mastering the React Context API, continue with these topics:

1. React Router
2. Navigation in React
3. Route Parameters
4. Nested Routes
5. Protected Routes
6. React Hooks (`useEffect`, `useReducer`)
7. REST API Integration
8. Redux Toolkit
9. Performance Optimization
10. React Project Deployment

These topics build upon Context API and prepare you for developing larger, production-ready React applications.

---

## End of README

This completes the documentation for **Exercise 14 – React Context API**. The README is designed to complement the uploaded hands-on lab by explaining the concepts, project structure, implementation, execution flow, and practical use of the React Context API in a clear, beginner-friendly manner while remaining aligned with the exercise objectives. :contentReference[oaicite:2]{index=2}

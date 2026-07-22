# Exercise 1: Create Your First React Application

## Week 5 – ReactJS Hands-on Lab

---

# Objective

The primary objective of this exercise is to understand the fundamentals of **ReactJS** by creating a simple React application from scratch.

In this exercise, you will:

- Understand what a Single Page Application (SPA) is.
- Learn why React was created.
- Understand the difference between SPA and MPA.
- Learn the basic architecture of React.
- Install the required software.
- Create your first React application.
- Understand the folder structure of a React project.
- Run the application successfully.
- Modify a React component.
- Display your first React output.

This exercise acts as the foundation for all future React applications.

---

# Learning Outcomes

After completing this exercise, you should be able to:

- Explain what React is.
- Explain what a Single Page Application (SPA) is.
- Differentiate SPA and MPA.
- Explain why React is widely used.
- Understand Virtual DOM.
- Install Node.js and npm.
- Create a React project using Create React App.
- Understand the React project structure.
- Run a React application.
- Modify an existing React component.
- Understand JSX basics.

---

# Prerequisites

Before starting this exercise, install the following software.

## 1. Node.js

Node.js provides the JavaScript runtime required for React development.

Download from

https://nodejs.org/

Verify Installation

```bash
node -v
```

Example

```text
v24.x.x
```

---

## 2. npm

npm (Node Package Manager) is installed automatically along with Node.js.

Verify installation

```bash
npm -v
```

Example

```text
11.x.x
```

---

## 3. Visual Studio Code

Download and install Visual Studio Code.

Recommended Extensions

- ES7+ React Snippets
- Prettier
- ESLint

---

# Concepts Covered

---

# 1. What is a Web Application?

A web application is software that runs inside a web browser.

Examples

- Gmail
- YouTube
- Facebook
- Amazon

Traditional web applications reload the entire page whenever the user navigates.

---

# 2. What is a Single Page Application (SPA)?

A Single Page Application (SPA) loads only one HTML page.

Instead of loading a new page every time, JavaScript updates only the required portion of the webpage.

### Example

Suppose you are using Gmail.

When opening a new email,

❌ The whole webpage does not reload.

Only the email content changes.

This is a Single Page Application.

---

## Advantages of SPA

- Faster user experience
- Fewer server requests
- Smooth navigation
- Better responsiveness
- Reduced bandwidth usage
- Better user interaction

---

## Disadvantages of SPA

- Initial loading time may be higher
- SEO is comparatively difficult
- JavaScript must be enabled
- Large applications require good architecture

---

# 3. What is a Multi Page Application (MPA)?

A Multi Page Application loads a completely new webpage whenever the user clicks a link.

Example

Traditional websites

- Banking portals
- Government websites
- Older e-commerce websites

Every click sends a request to the server.

The server returns another HTML page.

---

# SPA vs MPA

| Feature | SPA | MPA |
|----------|-----|-----|
| Page Reload | No | Yes |
| Speed | Faster | Slower |
| User Experience | Smooth | Less smooth |
| Data Transfer | Small | Large |
| Frameworks | React, Angular, Vue | JSP, PHP, ASP.NET |
| Initial Load | Higher | Lower |

---

# 4. What is React?

React is an open-source JavaScript library developed by Meta (Facebook) for building user interfaces.

It focuses on creating reusable UI components.

React only updates the necessary part of the webpage instead of refreshing everything.

---

## Why React?

React solves problems like

- Slow web pages
- Repeated UI code
- Frequent page reloads
- Difficult UI maintenance

---

## Advantages of React

- Component-based architecture
- Fast rendering
- Virtual DOM
- Easy maintenance
- Reusable components
- Huge community support
- Excellent developer tools

---

# 5. What is JSX?

JSX stands for

**JavaScript XML**

It allows HTML-like syntax inside JavaScript.

Example

```jsx
function App() {
  return (
    <h1>Hello React</h1>
  );
}
```

Although it looks like HTML,

React converts JSX into JavaScript internally.

---

# 6. What is the Virtual DOM?

DOM stands for

Document Object Model.

Whenever HTML changes,

the browser updates the webpage.

Updating the Real DOM repeatedly is expensive.

React introduces a Virtual DOM.

Virtual DOM is simply a lightweight copy of the Real DOM.

Whenever data changes,

React

1. Creates a new Virtual DOM
2. Compares it with the previous Virtual DOM
3. Finds the differences (Diffing)
4. Updates only the changed elements

This process makes React very fast.

---

# React Architecture

```
Browser
     │
     ▼
React Components
     │
     ▼
Virtual DOM
     │
Compare Changes
     │
     ▼
Real DOM
```

---

# Tools Used

- Node.js
- npm
- Create React App
- Visual Studio Code
- ReactJS

---

# Implementation

---

## Step 1

Verify Node.js

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

Install Create React App

```bash
npm install -g create-react-app
```

> **Note:** On newer versions of Node.js, you can directly use `npx create-react-app`, so a global installation is often unnecessary. This hands-on follows the document's approach.

---

## Step 4

Create the React application

```bash
npx create-react-app myfirstreact
```

This command creates

- package.json
- node_modules
- public
- src
- configuration files

---

## Step 5

Move inside the project

```bash
cd myfirstreact
```

---

## Step 6

Open VS Code

```bash
code .
```

---

## Step 7

Open

```
src/App.js
```

Replace the existing code with

```jsx
function App() {
  return (
    <div>
      <h1>Welcome to the first session of React</h1>
    </div>
  );
}

export default App;
```

---

## Step 8

Run the application

```bash
npm start
```

The development server starts.

Open

```
http://localhost:3000
```

---

# Expected Output

```
Welcome to the first session of React
```

displayed as a heading in the browser.

---

# React Project Structure

```
myfirstreact
│
├── node_modules/
├── public/
│   ├── favicon.ico
│   ├── index.html
│   └── ...
│
├── src/
│   ├── App.js
│   ├── App.css
│   ├── index.js
│   ├── index.css
│   └── ...
│
├── package.json
├── package-lock.json
└── README.md
```

---

# Understanding the Important Files

## node_modules/

Contains all installed dependencies.

Never edit manually.

Usually ignored using `.gitignore`.

---

## public/

Contains static resources.

Example

- favicon
- index.html
- images

---

## src/

Contains the application source code.

This is the folder where developers spend most of their time.

---

## App.js

Main component of the application.

This exercise modifies only this file.

---

## index.js

Entry point of the React application.

It renders the `App` component into the browser.

---

## package.json

Contains

- project information
- dependencies
- scripts
- versions

Example scripts

```json
"scripts": {
  "start": "react-scripts start",
  "build": "react-scripts build"
}
```

---

# Important Commands

Create project

```bash
npx create-react-app myfirstreact
```

Run project

```bash
npm start
```

Install packages

```bash
npm install
```

Stop server

```
Ctrl + C
```

---

# Common Errors and Solutions

## 'node' is not recognized

**Reason**

Node.js is not installed or not added to PATH.

**Solution**

Reinstall Node.js.

Restart Command Prompt.

---

## 'npm' is not recognized

**Reason**

npm installation is incomplete.

**Solution**

Reinstall Node.js.

---

## 'code' is not recognized

**Reason**

VS Code is not added to PATH.

**Solution**

Open VS Code manually or enable the "Shell Command: Install 'code' command in PATH" option.

---

## Port 3000 already in use

React asks

```
Would you like to run on another port?
```

Type

```
Y
```

---

# Screenshots for Evaluation

Capture the following:

1. `node -v` output.
2. `npm -v` output.
3. Successful execution of `npx create-react-app myfirstreact`.
4. Project opened in Visual Studio Code.
5. Modified `src/App.js`.
6. Terminal after `npm start` showing the development server.
7. Browser displaying **"Welcome to the first session of React"**.

---

# Key Takeaways

- React is a JavaScript library for building user interfaces.
- SPA updates only the required portion of the webpage without reloading the entire page.
- React uses reusable components to build applications.
- JSX allows writing HTML-like syntax inside JavaScript.
- Virtual DOM improves performance by updating only changed elements.
- `create-react-app` generates a complete React project with the required configuration.
- `npm start` launches the development server, making the application available locally.
- `App.js` is the main component modified in this introductory exercise.

---

# Outputs:

## Browser Output

<img width="1368" height="605" alt="image" src="https://github.com/user-attachments/assets/8a58f663-2a0b-48c6-8392-9fae6550e99c" />

## Console Output

<img width="1917" height="870" alt="image" src="https://github.com/user-attachments/assets/bb0b44fc-2046-4cca-a3c7-7b03c718b1ef" />

---

# Conclusion

This exercise serves as the entry point into React development. By installing the required tools, creating a React project, understanding its folder structure, modifying the main component, and running the application successfully, you build the foundation needed for all upcoming React hands-on exercises. The concepts introduced here—SPA, components, JSX, and the Virtual DOM—are fundamental to developing modern, efficient, and maintainable React applications.

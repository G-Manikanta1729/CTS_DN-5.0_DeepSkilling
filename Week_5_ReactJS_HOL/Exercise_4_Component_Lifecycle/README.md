# Exercise 4: React Component Lifecycle

## Week 5 – ReactJS Hands-on Lab

> **Response 1 of 4**

---

# Table of Contents

1. Project Title
2. Introduction
3. Learning Objectives
4. Prerequisites
5. Background Concepts

   * What is a Component Lifecycle?
   * Why Do We Need Lifecycle Methods?
   * Lifecycle Phases
   * Mounting Phase
   * Updating Phase
   * Unmounting Phase
   * Error Handling Phase
   * Constructor()
   * render()
   * componentDidMount()
   * componentDidCatch()
   * State
   * Fetch API
6. Project Overview
7. High-Level Architecture
8. Technologies Used

---

# 1. Project Title

# Blog Application using React Component Lifecycle Methods

**Week 5 – ReactJS Hands-on Lab**

**Exercise 4 – Component Lifecycle**

---

# 2. Introduction

## What is this project?

This exercise demonstrates how **React Class Components** use **Lifecycle Methods** to perform specific tasks during different stages of a component's life.

In this project, we create a **Blog Application** that:

* Retrieves blog posts from an online REST API.
* Stores them inside the component state.
* Displays each post's title and body.
* Handles unexpected runtime errors gracefully.

The exercise specifically demonstrates the use of:

* `componentDidMount()`
* `componentDidCatch()`

as described in the Cognizant hands-on document. 

---

## What problem does this project solve?

Imagine a blogging website like Medium or WordPress.

When a user opens the website:

1. The page loads.
2. The application requests blog posts from a server.
3. The server sends the posts.
4. The application displays them.

Without Lifecycle Methods, React wouldn't know **when** to fetch the data.

Similarly, if an error occurs while rendering a component, the application could crash completely. `componentDidCatch()` allows the application to detect and respond to such errors.

---

## Why is this project important?

Fetching data from an API is one of the most common tasks in React applications.

Examples include:

* News applications
* Shopping websites
* Banking dashboards
* Hospital systems
* Student portals
* Social media feeds

All of these applications retrieve information from servers after a component is displayed.

Understanding **Component Lifecycle** is therefore an essential foundation for learning:

* API Integration
* React Hooks
* useEffect()
* State Management
* Backend Communication

---

## Where is this concept used?

Lifecycle methods (or their modern Hook equivalents) are used in:

* Facebook News Feed
* Instagram Posts
* Amazon Product Listings
* Flipkart Products
* Netflix Movies
* Gmail Inbox
* WhatsApp Chats
* Banking Transactions
* Hospital Patient Records

---

# 3. Learning Objectives

After completing this exercise, you should be able to:

* Explain the React Component Lifecycle.
* Describe the different lifecycle phases.
* Understand why lifecycle methods exist.
* Create a Class Component.
* Initialize state using the constructor.
* Fetch data from an external REST API.
* Store API data inside React State.
* Understand the purpose of `componentDidMount()`.
* Explain when `render()` executes.
* Understand how `componentDidCatch()` handles runtime errors.
* Display dynamic data received from an API.

These objectives align with the goals listed in the uploaded hands-on exercise. 

---

# 4. Prerequisites

Before starting this exercise, ensure the following software is installed.

| Software           | Purpose            |
| ------------------ | ------------------ |
| Node.js            | JavaScript Runtime |
| npm                | Package Manager    |
| Visual Studio Code | Code Editor        |
| React              | UI Library         |

You should also know:

* JavaScript Basics
* ES6 Classes
* Objects
* Arrays
* Functions
* JSX
* React Components

It is recommended that you complete the earlier React exercises before attempting this lifecycle exercise.

---

# 5. Background Concepts

---

# 5.1 What is a React Component Lifecycle?

## Definition

Every React Component goes through different stages from the moment it is created until it is removed from the screen.

These stages together are called the **Component Lifecycle**.

---

## Real-world Analogy

Consider the life of a human being.

```text
Birth

↓

Childhood

↓

Adult

↓

Old Age

↓

Death
```

Every stage has different activities.

Similarly, a React Component also has different stages.

```text
Created

↓

Rendered

↓

Updated

↓

Removed
```

React provides special methods that execute automatically during these stages.

---

## Why does Lifecycle exist?

Imagine React had no lifecycle.

When should it:

* Fetch data?
* Connect to APIs?
* Start timers?
* Stop timers?
* Release memory?
* Handle errors?

Without lifecycle methods, developers would not know the correct time to perform these operations.

Lifecycle methods solve this problem.

---

# 5.2 Lifecycle Phases

A React Class Component has four major lifecycle phases.

```text
                Component Lifecycle

                        │

        ┌───────────────┼───────────────┐

        ▼               ▼               ▼

    Mounting        Updating      Unmounting

                        │

                        ▼

                Error Handling
```

Each phase has a specific purpose.

---

# 5.3 Mounting Phase

## Definition

The Mounting Phase occurs when a component is created and displayed on the screen for the first time.

Sequence

```text
Constructor()

↓

render()

↓

componentDidMount()
```

---

## Why is Mounting important?

During mounting,

we often perform tasks such as:

* API Calls
* Database Requests
* Timer Initialization
* Event Registration

In this exercise, `componentDidMount()` is used to fetch blog posts from the API after the component has been rendered. 

---

# 5.4 Updating Phase

## Definition

The Updating Phase occurs whenever:

* State changes
* Props change

React automatically updates the UI.

Example

```text
State Changes

↓

render()

↓

Browser Updates
```

Although this exercise mainly focuses on mounting, updating happens after `setState()` is called to store the fetched posts.

---

# 5.5 Unmounting Phase

## Definition

Unmounting occurs when a component is removed from the webpage.

Example

```text
Dashboard

↓

Logout

↓

Dashboard Removed
```

During this phase,

React typically performs cleanup such as:

* Stopping timers
* Removing event listeners
* Closing connections

---

# 5.6 Error Handling Phase

Sometimes applications encounter unexpected errors.

Example

```text
API Failure

↓

Null Object

↓

Invalid Data
```

Without error handling,

the entire application could crash.

React provides

```text
componentDidCatch()
```

to handle these situations.

The uploaded exercise specifically asks you to implement `componentDidCatch()` to display errors using alert messages. 

---

# 5.7 Constructor()

## Definition

The constructor is the first method executed when a Class Component is created.

Example

```jsx
constructor(props){

    super(props);

}
```

---

## Why do we need a constructor?

It is used to:

* Initialize State
* Bind methods
* Perform one-time setup

In this exercise,

the constructor initializes

```text
posts = []
```

inside the component state before the data is fetched. 

---

## Real-world Analogy

Imagine opening a notebook.

Before writing anything,

you first create empty pages.

The constructor prepares the component in a similar way.

---

# 5.8 What is State?

## Definition

State is an object that stores information belonging to a component.

Unlike variables,

State can change during execution.

Example

```javascript
this.state = {

    posts: []

}
```

---

## Why State?

Suppose the API returns 100 posts.

Where should React store them?

Inside State.

When State changes,

React automatically updates the UI.

---

## Difference Between Props and State

| Props            | State                      |
| ---------------- | -------------------------- |
| Passed by Parent | Owned by Component         |
| Read-only        | Can Change                 |
| External Data    | Internal Data              |
| Immutable        | Mutable using `setState()` |

---

# 5.9 What is render()?

## Definition

`render()` is responsible for describing what should appear on the screen.

Example

```jsx
render(){

    return(

        <h1>Hello</h1>

    );

}
```

---

## Important Point

`render()` **must not** directly fetch data from APIs.

Instead,

React recommends:

```text
render()

↓

Display UI

↓

componentDidMount()

↓

Fetch Data
```

This keeps rendering fast and predictable.

---

# 5.10 What is componentDidMount()?

## Definition

`componentDidMount()` is called **once**, immediately after the component is displayed on the screen.

Example

```javascript
componentDidMount(){

    this.loadPosts();

}
```

---

## Why is it needed?

It is the ideal place for:

* API Calls
* Fetch Requests
* Database Queries
* Loading External Data

This exercise uses `componentDidMount()` to invoke `loadPosts()` and fetch blog posts from the JSONPlaceholder API after the component is mounted. 

---

## Real-world Analogy

Imagine opening YouTube.

First,

the page appears.

Then,

videos begin loading.

The page is already visible before the data arrives.

That is exactly how `componentDidMount()` works.

---

# 5.11 What is componentDidCatch()?

## Definition

`componentDidCatch()` is a lifecycle method used to catch runtime errors in child components.

Example

```javascript
componentDidCatch(error, info){

    alert(error);

}
```

---

## Why is it important?

Without it,

an application may crash.

With it,

we can:

* Display an alert
* Log the error
* Prevent the whole UI from failing

The lab instructs using this method to display errors as alert messages. 

---

# 5.12 What is the Fetch API?

## Definition

The Fetch API is a modern JavaScript API used to request data from a server.

Example

```javascript
fetch("https://jsonplaceholder.typicode.com/posts")
```

---

## Why Fetch API?

Applications often require external data.

Examples include:

* Weather
* News
* Products
* Movies
* Students
* Blog Posts

Instead of storing all data inside the application,

React requests it from a server.

---

## How Fetch Works

```text
React Application

↓

fetch()

↓

Internet

↓

Server

↓

JSON Response

↓

React State

↓

Browser
```

---

# 6. Project Overview

In this exercise, we build a **Blog Application** using a **React Class Component**.

The application:

* Defines a `Post` model.
* Creates a `Posts` component.
* Initializes component state.
* Fetches blog posts from an external API.
* Stores the retrieved posts in state.
* Displays each title and body.
* Uses `componentDidMount()` for data loading.
* Uses `componentDidCatch()` for runtime error handling.

The implementation follows the sequence described in the Cognizant hands-on document. 

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
                  Posts Component
                        │
        ┌───────────────┼────────────────┐
        ▼               ▼                ▼
   Constructor()   componentDidMount()   render()
        │               │                │
        │               ▼                │
        │         Fetch API Request      │
        │               │                │
        │               ▼                │
        │      JSONPlaceholder Server    │
        │               │                │
        │               ▼                │
        └──────────► setState() ◄────────┘
                        │
                        ▼
                 React Re-renders
                        │
                        ▼
              Blog Posts Displayed
```

---

# 8. Technologies Used

| Technology              | Role in This Project                                               |
| ----------------------- | ------------------------------------------------------------------ |
| **React**               | Builds the user interface and provides lifecycle methods.          |
| **JavaScript (ES6)**    | Implements classes, state, methods, and Fetch API calls.           |
| **JSX**                 | Describes the UI using HTML-like syntax.                           |
| **Fetch API**           | Retrieves blog posts from an external REST API.                    |
| **JSONPlaceholder API** | Provides sample blog post data for development and testing.        |
| **Node.js**             | JavaScript runtime required for React development.                 |
| **npm**                 | Installs and manages project dependencies.                         |
| **Create React App**    | Generates the React project structure and development environment. |
| **Visual Studio Code**  | Used to create and edit the project files.                         |

---

# Exercise 4: React Component Lifecycle

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

17. Lifecycle Execution Sequence

---

# 9. Project Structure

After completing this exercise, your project structure should look like this.

```text
blogapp
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
│   ├── App.js
│   ├── App.css
│   ├── index.js
│   ├── index.css
│   ├── Post.js
│   ├── Posts.js
│   ├── reportWebVitals.js
│   ├── setupTests.js
│   └── logo.svg
│
├── .gitignore
├── package.json
├── package-lock.json
└── README.md
```

This structure corresponds to the files created in the hands-on exercise, where `Post.js` and `Posts.js` are added under the `src` folder. 

---

# 10. Folder Explanation

---

# node_modules

## Purpose

Stores all installed npm packages.

Examples

```
react

react-dom

react-scripts

babel

webpack
```

---

## Why is it needed?

Whenever you execute

```bash
npm install
```

npm downloads every dependency into this folder.

Without it,

the project cannot run.

---

# public

Contains files served directly to the browser.

```
public

│

├── index.html

├── favicon.ico

└── manifest.json
```

---

## Most Important File

```
index.html
```

Contains

```html
<div id="root"></div>
```

React renders the complete application inside this element.

---

# src

The most important folder.

Contains all application source code.

```
src

│

├── Post.js

├── Posts.js

├── App.js

└── index.js
```

---

# Post.js

Stores the Post model.

---

# Posts.js

Contains

* State
* Lifecycle Methods
* Fetch API
* Render Logic

---

# App.js

Acts as the Parent Component.

---

# index.js

Application Entry Point.

---

# package.json

Stores project configuration.

---

# package-lock.json

Locks dependency versions.

---

# 11. File-by-File Explanation

---

# File 1 — Post.js

This file represents a single blog post.

It is **not a React component**.

Instead,

it is a simple JavaScript class.

---

## Purpose

Represent

```
One Blog Post
```

---

Example

```
Post

↓

ID

↓

Title

↓

Body
```

---

### Code

```javascript
class Post{

    constructor(id,title,body){

        this.id=id;
        this.title=title;
        this.body=body;

    }

}

export default Post;
```

This matches the model class shown in Figure 1 of the lab document. 

---

## Why create a Post class?

Without a model

```
Random Objects
```

With model

```
Post Object

↓

Well Organized

↓

Reusable

↓

Easy to Understand
```

---

## Responsibilities

* Store ID
* Store Title
* Store Body

Nothing else.

---

## Real-world Analogy

Imagine

```
Student Class

↓

Roll Number

↓

Name

↓

Branch
```

Similarly,

```
Post Class

↓

ID

↓

Title

↓

Body
```

---

# File 2 — Posts.js

This is the most important file.

Everything happens here.

Responsibilities

```
State

↓

Fetch API

↓

Lifecycle

↓

Rendering

↓

Error Handling
```

---

## Class Declaration

```javascript
class Posts extends React.Component{

}
```

Why?

Because lifecycle methods like

* constructor()
* render()
* componentDidMount()
* componentDidCatch()

are available only in Class Components.

This is exactly why the exercise asks you to create a **class-based component**. 

---

# Constructor

Purpose

Initialize State.

```javascript
constructor(props){

    super(props);

}
```

---

### Why super(props)?

Every React Component inherits

```
React.Component
```

Calling

```javascript
super(props)
```

initializes the parent class.

Without it,

React throws an error.

---

### State Initialization

```javascript
this.state={

posts:[]

}
```

Initially

```
posts

↓

Empty Array
```

Why?

Because data has not yet arrived.

---

# loadPosts()

Purpose

Retrieve blog posts from server.

Example

```javascript
loadPosts(){

}
```

---

### Why separate function?

Instead of writing

```
Fetch

↓

Inside componentDidMount()
```

we create

```
loadPosts()

↓

Reusable

↓

Readable

↓

Maintainable
```

---

### Fetch API

```javascript
fetch(URL)
```

Requests data.

---

### Promise Chain

```
fetch()

↓

response

↓

response.json()

↓

JSON Data

↓

setState()
```

---

### Why response.json()?

Server returns

```
Raw Response
```

React needs

```
JavaScript Object
```

response.json()

converts

```
JSON

↓

JavaScript Object
```

---

### Creating Post Objects

Instead of directly storing JSON,

the exercise converts each item into a `Post` object.

```javascript
new Post(...)
```

This follows the model introduced in `Post.js`. 

---

### setState()

Purpose

Update State.

```javascript
this.setState({

posts:data

})
```

---

Important

Never write

```javascript
this.state.posts=data
```

Wrong.

Always use

```javascript
this.setState()
```

because React needs to know when State changes.

---

# componentDidMount()

Purpose

Runs once

after component appears.

Example

```javascript
componentDidMount(){

this.loadPosts();

}
```

---

Why here?

Sequence

```
Component Appears

↓

componentDidMount()

↓

Fetch API

↓

Display Data
```

This is the lifecycle method specified in Step 7 of the lab. 

---

# render()

Purpose

Display UI.

Example

```javascript
render(){

return()

}
```

---

Inside render

React loops through

```
Posts Array
```

using

```javascript
map()
```

Example

```
Post1

↓

Post2

↓

Post3

↓

...
```

Each post becomes

```
Heading

↓

Paragraph
```

The exercise requires displaying the **title** as a heading and the **body** as a paragraph. 

---

# componentDidCatch()

Purpose

Handle runtime errors.

Example

```javascript
componentDidCatch(error,info){

alert(error);

}
```

---

Why?

Suppose

```
API Failure
```

or

```
Undefined Object
```

Without

```
componentDidCatch()

↓

App Crash
```

With

```
Alert

↓

Error Logged

↓

Better User Experience
```

The hands-on specifically instructs showing alert messages for errors. 

---

# File 3 — App.js

Purpose

Acts as Parent Component.

Responsibilities

```
Import Posts

↓

Render Posts
```

Example

```javascript
import Posts from './Posts';
```

---

Display

```jsx
<Posts/>
```

Nothing else.

---

# File 4 — index.js

Purpose

Application Entry Point.

Sequence

```
ReactDOM

↓

Find root

↓

Load App

↓

Display Browser
```

---

# 12. Configuration Explanation

---

# package.json

One of the most important files.

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

```
react

react-dom

react-scripts
```

Without them

Project won't run.

---

### Scripts

```
npm start
```

Development Server.

```
npm test
```

Testing.

```
npm run build
```

Production Build.

---

# package-lock.json

Purpose

Maintain dependency consistency.

Example

Developer A

```
React 19
```

Developer B

```
React 20
```

Without lock file,

applications may behave differently.

---

# .gitignore

Purpose

Prevent unnecessary files from Git.

Example

```
node_modules
```

Never upload.

---

# 13. Implementation Explanation

Overall implementation sequence:

```text
Create Project

↓

Create Post Model

↓

Create Posts Component

↓

Initialize State

↓

Create loadPosts()

↓

Implement componentDidMount()

↓

Implement render()

↓

Implement componentDidCatch()

↓

Render Posts Component

↓

Run Application
```

This sequence mirrors the numbered steps in the uploaded hands-on document. 

---

# 14. Internal Working

Understanding what React does internally helps explain why lifecycle methods exist.

---

## Step 1

Application starts.

```
npm start
```

↓

Development Server.

---

## Step 2

React executes

```
index.js
```

---

## Step 3

React renders

```
<App/>
```

---

## Step 4

App renders

```
<Posts/>
```

---

## Step 5

React creates

```
Posts Component
```

---

## Step 6

Constructor executes.

State initialized.

```
posts=[]

```

---

## Step 7

render()

Runs.

No posts yet.

Browser initially displays only the heading or an empty list.

---

## Step 8

componentDidMount()

Runs automatically.

---

## Step 9

loadPosts()

Calls

```
fetch()
```

---

## Step 10

Server responds.

```
JSONPlaceholder

↓

100 Posts
```

---

## Step 11

setState()

Updates

```
posts[]
```

---

## Step 12

React notices

```
State Changed
```

---

## Step 13

render()

Executes again.

---

## Step 14

Posts appear.

Browser updates automatically.

---

# 15. Code Flow

```text
User Opens Browser

↓

index.js

↓

App.js

↓

Posts Component

↓

Constructor

↓

posts=[]

↓

render()

↓

componentDidMount()

↓

loadPosts()

↓

Fetch API

↓

JSONPlaceholder

↓

Receive JSON

↓

Create Post Objects

↓

setState()

↓

render()

↓

Display Posts
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

Constructor()

↓

render()

↓

componentDidMount()

↓

Fetch API

↓

Server Response

↓

setState()

↓

render()

↓

Display Blog Posts
```

---

# 17. Lifecycle Execution Sequence

The complete lifecycle followed in this project is:

```text
Component Created

        │

        ▼

constructor()

        │

        ▼

render()

        │

        ▼

componentDidMount()

        │

        ▼

loadPosts()

        │

        ▼

Fetch API Request

        │

        ▼

JSON Response

        │

        ▼

setState()

        │

        ▼

render() Again

        │

        ▼

Blog Posts Displayed

        │

        ▼

If Runtime Error Occurs

        │

        ▼

componentDidCatch()
```

This sequence directly reflects the lifecycle methods required by the Cognizant hands-on exercise: initialize state, fetch posts in `componentDidMount()`, render the data, and handle runtime errors using `componentDidCatch()`. 

---

# Exercise 4: React Component Lifecycle

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

The application fetches blog posts from the following API specified in the hands-on document:

```text
https://jsonplaceholder.typicode.com/posts
```

The server returns JSON data similar to:

```json
[
  {
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati",
    "body": "quia et suscipit suscipit recusandae..."
  },
  {
    "userId": 1,
    "id": 2,
    "title": "qui est esse",
    "body": "est rerum tempore vitae..."
  }
]
```

The application converts each JSON object into a `Post` object and stores it in the component state before rendering it on the page. This workflow follows the implementation described in the uploaded exercise. 

---

## Sample Output

```text
Blog Posts

------------------------------------------------------

sunt aut facere repellat provident occaecati...

quia et suscipit suscipit recusandae consequuntur...

------------------------------------------------------

qui est esse

est rerum tempore vitae sequi sint nihil...
```

---

## Internal Data Transformation

```text
JSON API Response

        │

        ▼

JavaScript Objects

        │

        ▼

Post Objects

        │

        ▼

React State

        │

        ▼

Rendered HTML
```

---

## State Before Fetching

```javascript
this.state = {
    posts: []
}
```

Output

```text
Blog Posts

(No Posts Available Yet)
```

---

## State After Fetching

```javascript
this.state = {
    posts: [

        Post,

        Post,

        Post,

        ...

    ]
}
```

Output

```text
Blog Posts

Title

Body

Title

Body

Title

Body
```

---

# 18. How to Run the Project

---

## Step 1

Install Node.js.

Verify installation.

```bash
node -v
```

Example

```text
v22.17.0
```

---

## Step 2

Verify npm.

```bash
npm -v
```

Example

```text
10.9.2
```

---

## Step 3

Create the React project.

```bash
npx create-react-app blogapp
```

---

## Step 4

Navigate into the project.

```bash
cd blogapp
```

---

## Step 5

Open Visual Studio Code.

```bash
code .
```

---

## Step 6

Create the required files.

```text
Post.js

Posts.js
```

---

## Step 7

Replace

```text
App.js
```

with the implementation.

---

## Step 8

Run the project.

```bash
npm start
```

---

## Step 9

Browser opens automatically.

Otherwise visit

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

Although the exercise does not include custom tests, Create React App provides a default testing setup.

---

## Stop Server

```text
Ctrl + C
```

---

# Useful npm Commands

| Command       | Purpose                   |
| ------------- | ------------------------- |
| npm start     | Starts Development Server |
| npm test      | Runs Tests                |
| npm run build | Production Build          |
| npm install   | Install Packages          |
| Ctrl + C      | Stop Server               |

---

# 19. Testing

Testing ensures that the application works correctly.

---

## Test 1

Application starts successfully.

Expected

```text
Compiled Successfully
```

---

## Test 2

Browser opens.

Expected

```text
http://localhost:3000
```

---

## Test 3

Heading displayed.

Expected

```text
Blog Posts
```

---

## Test 4

Posts loaded successfully.

Expected

Multiple titles displayed.

---

## Test 5

Bodies displayed.

Expected

Each title followed by its paragraph.

---

## Test 6

No blank screen.

Expected

Entire page renders.

---

## Test 7

Network Request

Open

```text
Developer Tools

↓

Network
```

Refresh page.

Expected

```text
GET

/posts

Status

200 OK
```

---

## Test 8

Console Errors

Open

```text
Developer Tools

↓

Console
```

Expected

```text
No Errors
```

---

## Test 9

State Updated

Install React Developer Tools.

Expected

```text
posts

↓

100 Objects
```

(after successful API response).

---

## Test 10

Error Handling

Disconnect internet temporarily.

Reload.

If an error occurs during rendering and reaches `componentDidCatch()`, the exercise expects it to be handled by displaying an alert message. Note that `componentDidCatch()` catches rendering errors in child components; network request failures alone are not automatically caught by it unless they result in a rendering error. The hands-on document, however, specifically asks you to implement `componentDidCatch()` for displaying error alerts. 

---

## Manual Testing Checklist

| Check             | Status |
| ----------------- | ------ |
| Project Starts    | ✅      |
| Browser Opens     | ✅      |
| API Called        | ✅      |
| JSON Received     | ✅      |
| State Updated     | ✅      |
| Titles Displayed  | ✅      |
| Bodies Displayed  | ✅      |
| No Console Errors | ✅      |

---

# 20. Best Practices

---

## Keep Components Focused

Good

```text
Posts Component

↓

Only Blog Logic
```

Avoid placing unrelated functionality inside the same component.

---

## Initialize State Properly

Always initialize state inside the constructor.

Good

```javascript
this.state = {

posts:[]

}
```

---

## Never Modify State Directly

Wrong

```javascript
this.state.posts=data;
```

Correct

```javascript
this.setState({

posts:data

});
```

---

## Separate Business Logic

Good

```text
loadPosts()

↓

Fetch API
```

instead of placing the fetch code directly inside `render()`.

---

## Use Lifecycle Methods Correctly

Correct

```text
componentDidMount()

↓

API Calls
```

Incorrect

```text
render()

↓

API Calls
```

---

## Keep Models Separate

Store reusable data models such as `Post` in their own file.

This improves readability and maintainability.

---

## Handle Errors Gracefully

Always anticipate failures such as:

* Network issues
* Invalid JSON
* Unexpected exceptions

Provide user-friendly feedback instead of allowing the application to crash.

---

## Use Meaningful Names

Good

```text
Posts

Post

loadPosts
```

Bad

```text
A

Demo

Test

ABC
```

---

# 21. Common Mistakes

---

## Mistake 1

Forgetting

```javascript
super(props)
```

Result

```text
Runtime Error
```

---

## Mistake 2

Calling Fetch inside render()

Wrong

```javascript
render(){

fetch(...)

}
```

Result

Infinite API requests.

Correct

```text
componentDidMount()

↓

Fetch API
```

---

## Mistake 3

Directly modifying State

Wrong

```javascript
this.state.posts=data;
```

Correct

```javascript
this.setState({

posts:data

});
```

---

## Mistake 4

Not exporting components

Wrong

```javascript
class Posts{

}
```

Correct

```javascript
export default Posts;
```

---

## Mistake 5

Wrong Import

Wrong

```javascript
import Post from './Models/Post';
```

Correct

```javascript
import Post from './Post';
```

---

## Mistake 6

Forgetting

```javascript
key
```

inside

```jsx
map()
```

React warning

```text
Each child should have a unique key.
```

Correct

```jsx
key={post.id}
```

---

## Mistake 7

Using `componentDidMount()` for repeated updates

Remember:

```text
componentDidMount()

↓

Runs Once
```

It is not called every time the component updates.

---

## Mistake 8

Confusing Props and State

Remember

```text
Props

↓

Read Only
```

```text
State

↓

Mutable

↓

setState()
```

---

# 22. Real-world Applications

Although this project displays blog posts, the same pattern is used in many enterprise applications.

---

## News Websites

```text
News Articles

↓

Fetch API

↓

Display Headlines
```

---

## E-Commerce

```text
Products

↓

Fetch API

↓

Display Products
```

---

## Banking

```text
Transactions

↓

Server

↓

Dashboard
```

---

## Hospital Management

```text
Patients

↓

Database

↓

Patient Dashboard
```

---

## Student Management

```text
Students

↓

REST API

↓

Display Records
```

---

## Social Media

```text
Posts

↓

Comments

↓

Likes

↓

Feeds
```

Facebook, Instagram, LinkedIn, and X (Twitter) all use similar patterns.

---

## Weather Applications

```text
Current Weather

↓

Weather API

↓

Display Forecast
```

---

## Stock Market Applications

```text
Stock Prices

↓

Market API

↓

Live Dashboard
```

---

## Chat Applications

```text
Messages

↓

Server

↓

React UI
```

---

# 23. Advantages

| Advantage                            | Explanation                                                                               |
| ------------------------------------ | ----------------------------------------------------------------------------------------- |
| Automatic Lifecycle Management       | React automatically invokes lifecycle methods at the correct time.                        |
| Clean Separation of Responsibilities | Constructor, rendering, data loading, and error handling each have dedicated methods.     |
| Easy API Integration                 | `componentDidMount()` provides a clear place to load external data.                       |
| Automatic UI Updates                 | Calling `setState()` automatically triggers re-rendering.                                 |
| Error Recovery                       | `componentDidCatch()` helps prevent complete application failure due to rendering errors. |
| Organized Code                       | Business logic is separated from presentation logic.                                      |
| Reusable Components                  | Components can be reused in multiple parts of an application.                             |
| Scalable Architecture                | Suitable for applications ranging from small projects to enterprise systems.              |

---

# 24. Limitations

Although this exercise is valuable for learning lifecycle methods, it has some limitations.

---

## Uses Class Components

Modern React primarily uses **Function Components** with Hooks (`useEffect`, `useState`) instead of lifecycle methods.

---

## Static API Endpoint

The API URL is hardcoded.

In production, URLs are often stored in configuration files or environment variables.

---

## No Loading Indicator

Users do not see a loading message while data is being fetched.

A production application would display:

```text
Loading...
```

until the API response arrives.

---

## No Pagination

All posts are loaded at once.

Large applications usually load data page by page or on demand.

---

## No Search or Filtering

The exercise simply displays all posts.

Real-world blog applications provide:

* Search
* Categories
* Sorting
* Pagination

---

## No Authentication

The application can access the public API without login.

Enterprise systems often require authentication and authorization.

---

## No Retry Mechanism

If the API request fails, there is no automatic retry logic.

---

## Legacy Lifecycle Pattern

While understanding lifecycle methods is important (especially for maintaining older React codebases), new React projects typically use **Hooks** instead of Class Component lifecycle methods. Learning this exercise provides the conceptual foundation for understanding `useEffect()` later.

---

# Exercise 4: React Component Lifecycle

## Week 5 – ReactJS Hands-on Lab

> **Response 4 of 4**

---

# Table of Contents

25. Frequently Asked Interview Questions

26. Quick Revision Notes

27. Important Commands Cheat Sheet

28. Important Files Summary

29. Lifecycle Cheat Sheet

30. Complete Workflow Summary

31. Key Takeaways

32. Conclusion

33. Next Learning Path

---

# 25. Frequently Asked Interview Questions

Below are conceptual interview questions commonly asked in React interviews, especially around Class Components and Lifecycle Methods.

---

# Q1. What is the Component Lifecycle in React?

### Answer

The Component Lifecycle refers to the sequence of stages a React component goes through from creation to removal.

The main phases are:

* Mounting
* Updating
* Unmounting
* Error Handling

React automatically calls lifecycle methods at each stage.

---

# Q2. Why are Lifecycle Methods needed?

### Answer

Lifecycle methods allow developers to perform actions at specific stages of a component's life.

Examples:

* Fetch API data
* Initialize state
* Start timers
* Stop timers
* Handle errors
* Release resources

---

# Q3. What is the Mounting Phase?

### Answer

The Mounting Phase occurs when a component is created and inserted into the DOM for the first time.

Execution order:

```text
constructor()

↓

render()

↓

componentDidMount()
```

---

# Q4. What is the Updating Phase?

### Answer

The Updating Phase occurs whenever:

* State changes
* Props change

React automatically re-renders the component to reflect the updated data.

---

# Q5. What is the Unmounting Phase?

### Answer

The Unmounting Phase occurs when a component is removed from the DOM.

It is commonly used to:

* Stop timers
* Remove event listeners
* Cancel API requests
* Release resources

---

# Q6. What is the purpose of constructor()?

### Answer

The constructor is used to:

* Initialize State
* Bind methods
* Perform one-time setup

Example

```javascript
constructor(props){

super(props);

this.state={

posts:[]

};

}
```

---

# Q7. Why do we call `super(props)`?

### Answer

Every Class Component extends `React.Component`.

`super(props)` initializes the parent class.

Without it, React throws an error.

---

# Q8. What is State?

### Answer

State is an object that stores data belonging to a component.

State is mutable and should always be updated using:

```javascript
this.setState()
```

---

# Q9. What is the difference between Props and State?

| Props                       | State                      |
| --------------------------- | -------------------------- |
| Passed by Parent            | Owned by Component         |
| Read-only                   | Mutable                    |
| External Data               | Internal Data              |
| Cannot be modified by Child | Updated using `setState()` |

---

# Q10. What is `componentDidMount()`?

### Answer

`componentDidMount()` executes once immediately after the component has been rendered.

It is commonly used for:

* Fetch API
* Database Calls
* Timer Initialization
* Event Registration

In this exercise, it calls `loadPosts()` to retrieve blog posts. 

---

# Q11. Why shouldn't API calls be placed inside `render()`?

### Answer

`render()` may execute multiple times.

If an API call is placed inside `render()`:

```text
render()

↓

Fetch

↓

setState()

↓

render()

↓

Fetch Again

↓

Infinite Loop
```

Therefore, React recommends using `componentDidMount()` for API requests.

---

# Q12. What is `componentDidCatch()`?

### Answer

`componentDidCatch()` is an error handling lifecycle method.

It catches runtime errors in child components.

Example

```javascript
componentDidCatch(error,info){

alert(error);

}
```

This is the method requested in the exercise for displaying alert messages when errors occur. 

---

# Q13. What is the Fetch API?

### Answer

Fetch API is a JavaScript API used to request data from servers.

Example

```javascript
fetch("https://jsonplaceholder.typicode.com/posts")
```

---

# Q14. What is JSON?

### Answer

JSON stands for

**JavaScript Object Notation**

It is the most common format used to exchange data between clients and servers.

Example

```json
{
"id":1,
"title":"Hello"
}
```

---

# Q15. What is `setState()`?

### Answer

`setState()` updates the component state.

When State changes,

React automatically calls `render()` again.

---

# Q16. What happens after calling `setState()`?

### Answer

```text
setState()

↓

State Changes

↓

render()

↓

Virtual DOM Updated

↓

Real DOM Updated
```

---

# Q17. Why do we use `map()` inside `render()`?

### Answer

`map()` is used to iterate over arrays and generate JSX elements for each item.

Example

```javascript
posts.map(post => ...)
```

---

# Q18. Why is the `key` prop important?

### Answer

The `key` prop helps React identify each element uniquely when rendering lists.

Example

```jsx
key={post.id}
```

Without unique keys, React displays warnings and may update the UI inefficiently.

---

# Q19. Why do we separate the `Post` model?

### Answer

Separating the `Post` class improves:

* Code organization
* Readability
* Reusability
* Maintainability

---

# Q20. How does React know when to update the UI?

### Answer

Whenever:

* Props change
* State changes

React compares the old Virtual DOM with the new Virtual DOM and updates only the changed parts of the Real DOM.

---

# 26. Quick Revision Notes

---

## Component Lifecycle

```text
Mounting

↓

Updating

↓

Unmounting

↓

Error Handling
```

---

## Mounting Order

```text
constructor()

↓

render()

↓

componentDidMount()
```

---

## State

```text
Internal Data

↓

Mutable

↓

setState()
```

---

## Fetch API

```text
React

↓

Fetch API

↓

Server

↓

JSON

↓

State

↓

Browser
```

---

## Error Handling

```text
componentDidCatch()

↓

Catch Error

↓

Show Alert

↓

Prevent Crash
```

---

## Folder Structure

```text
blogapp

│

├── src

│   ├── App.js

│   ├── Post.js

│   ├── Posts.js

│   └── index.js

│

└── package.json
```

---

# 27. Important Commands Cheat Sheet

| Command                        | Purpose                  |
| ------------------------------ | ------------------------ |
| `node -v`                      | Check Node.js version    |
| `npm -v`                       | Check npm version        |
| `npx create-react-app blogapp` | Create React project     |
| `cd blogapp`                   | Enter project            |
| `code .`                       | Open VS Code             |
| `npm install`                  | Install dependencies     |
| `npm start`                    | Start development server |
| `npm test`                     | Run tests                |
| `npm run build`                | Production build         |
| `Ctrl + C`                     | Stop development server  |

---

# 28. Important Files Summary

| File                | Purpose                                                                                     |
| ------------------- | ------------------------------------------------------------------------------------------- |
| `index.js`          | Entry point that renders the application.                                                   |
| `App.js`            | Parent component that renders the `Posts` component.                                        |
| `Post.js`           | JavaScript model class representing a blog post.                                            |
| `Posts.js`          | Class component implementing lifecycle methods, API calls, state management, and rendering. |
| `package.json`      | Project metadata, dependencies, and scripts.                                                |
| `package-lock.json` | Locks dependency versions for consistent installations.                                     |
| `public/index.html` | Contains the `<div id="root"></div>` where React mounts the application.                    |

---

# 29. Lifecycle Cheat Sheet

## Complete Lifecycle Sequence

```text
Component Created

        │

        ▼

constructor()

        │

        ▼

State Initialized

        │

        ▼

render()

        │

        ▼

HTML Generated

        │

        ▼

componentDidMount()

        │

        ▼

Fetch API

        │

        ▼

JSON Response

        │

        ▼

setState()

        │

        ▼

render()

        │

        ▼

Updated UI

        │

        ▼

If Rendering Error Occurs

        │

        ▼

componentDidCatch()
```

---

## Responsibility of Each Lifecycle Method

| Method                | Responsibility                                                         |
| --------------------- | ---------------------------------------------------------------------- |
| `constructor()`       | Initialize state and perform one-time setup.                           |
| `render()`            | Return JSX to describe the UI.                                         |
| `componentDidMount()` | Perform API calls and other side effects after the component mounts.   |
| `setState()`          | Update component state and trigger a re-render.                        |
| `componentDidCatch()` | Catch rendering errors in child components and handle them gracefully. |

---

# 30. Complete Workflow Summary

The following diagram summarizes the end-to-end execution of the application.

```text
User Runs:

npm start

        │

        ▼

Development Server Starts

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

Posts Component Created

        │

        ▼

constructor()

        │

        ▼

posts = []

        │

        ▼

render()

        │

        ▼

componentDidMount()

        │

        ▼

loadPosts()

        │

        ▼

Fetch API Request

        │

        ▼

JSONPlaceholder Server

        │

        ▼

JSON Response

        │

        ▼

Convert to Post Objects

        │

        ▼

setState()

        │

        ▼

render() Executes Again

        │

        ▼

Titles Displayed

        │

        ▼

Bodies Displayed

        │

        ▼

If Runtime Error Occurs

        │

        ▼

componentDidCatch()

        │

        ▼

Alert Message Displayed
```

This execution sequence follows the workflow presented in the Cognizant hands-on lab: initialize the component, load posts in `componentDidMount()`, render the fetched data, and implement `componentDidCatch()` for error handling. 

---

# 31. Key Takeaways

After completing this exercise, you should now understand:

* The complete React Component Lifecycle.
* The purpose of each lifecycle phase.
* The execution order of lifecycle methods.
* How to initialize state using a constructor.
* How to fetch data using the Fetch API.
* Why `componentDidMount()` is the correct place for API calls.
* How `setState()` updates the UI automatically.
* How `render()` converts state into JSX.
* How `componentDidCatch()` provides error handling.
* How Class Components manage data and rendering.

---

# 32. Conclusion

This exercise introduces one of the most important concepts in React development: the **Component Lifecycle**.

By building a simple **Blog Application**, you learned how React components progress through different lifecycle phases and how each phase serves a specific purpose.

Key concepts demonstrated include:

* Initializing component state with a constructor.
* Loading external data using the Fetch API.
* Using `componentDidMount()` for side effects such as API calls.
* Updating the UI automatically using `setState()`.
* Displaying dynamic content using `render()`.
* Handling runtime errors with `componentDidCatch()`.

Although modern React applications primarily use **Function Components** with Hooks (`useState` and `useEffect`), understanding lifecycle methods remains valuable because many existing enterprise applications still use Class Components. The concepts learned here also provide the foundation for understanding how Hooks work internally.

The implementation described in this README follows the Cognizant hands-on exercise while expanding the explanations into a complete learning guide. 

---

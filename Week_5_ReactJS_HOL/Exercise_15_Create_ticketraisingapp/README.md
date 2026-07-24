# Exercise 15: Create ticketraisingapp (React Forms)

## Week 5 – ReactJS Hands-on Lab

> **Response 1 of 4**

---

# Table of Contents

1. Project Title

2. Introduction

3. Learning Objectives

4. Prerequisites

5. Background Concepts

- What is a Form?
- What are React Forms?
- Why are Forms Important?
- Controlled Components
- Uncontrolled Components
- Various Input Controls
- Textbox
- Textarea
- Button
- Event Handling
- handleChange()
- handleSubmit()
- preventDefault()
- Form Validation
- Reference Number Generation
- Project Overview
- High-Level Architecture
- Technologies Used

---

# 1. Project Title

# Create ticketraisingapp (React Forms)

**Week 5 – ReactJS Hands-on Lab**

**Exercise 15 – React Forms**

---

# 2. Introduction

## What is this project?

This hands-on exercise demonstrates how to create and manage **React Forms** by allowing employees to register complaints through a web application.

According to the uploaded hands-on lab, you must create a React application named **ticketraisingapp** that contains a **ComplaintRegister** component with:

- A textbox to enter the employee name
- A textarea to enter the complaint
- A Submit button
- A `handleSubmit` event
- A generated Reference Number displayed in an alert after successful submission. :contentReference[oaicite:0]{index=0}

---

## What problem does this project solve?

Many organizations require employees to raise complaints such as:

- Keyboard not working
- Monitor damaged
- Internet issues
- Software installation request
- Printer problems

Instead of writing complaints on paper or sending emails,

employees can submit complaints using an online form.

Example

```text
Employee

↓

Complaint Form

↓

Submit

↓

Complaint Registered

↓

Reference Number Generated
```

---

## Why are React Forms Important?

Forms allow users to provide information to an application.

Examples include

- Login Forms
- Registration Forms
- Contact Forms
- Feedback Forms
- Complaint Forms
- Job Application Forms
- Banking Forms
- Hospital Registration Forms

Without forms,

users cannot send information to applications.

---

## Why do we use Controlled Components?

In React,

the application should always know the current value of every input field.

Instead of reading values directly from HTML,

React stores them inside State.

Example

```text
Textbox

↓

useState()

↓

React State

↓

Updated UI
```

This is called a **Controlled Component**.

---

## What are Uncontrolled Components?

An Uncontrolled Component stores its value inside the HTML element itself.

Example

```text
Textbox

↓

Browser Stores Value
```

React does not directly control the value.

Controlled Components are preferred because they provide better control over user input.

---

## Why is Form Submission Important?

After entering data,

the user clicks the **Submit** button.

The application then

- validates the data,
- processes it,
- and performs an action.

In this exercise,

the action is generating a **Reference Number** and displaying it in an alert box. :contentReference[oaicite:1]{index=1}

---

## Real-world Applications

React Forms are used in almost every web application.

Examples include:

- Employee Complaint Portals
- Student Registration Systems
- Online Banking
- Hospital Appointment Systems
- Customer Feedback Portals
- Help Desk Systems
- E-Commerce Checkout Pages
- Online Surveys
- Recruitment Portals
- Technical Support Applications

---

# 3. Learning Objectives

According to the uploaded hands-on lab, after completing this exercise you should be able to:

- Explain React Forms.
- Define Controlled Components.
- Explain various input controls.
- Explain handling forms.
- Explain submitting forms.
- Implement React Forms.
- Use textbox, button, and textarea controls. :contentReference[oaicite:2]{index=2}

In this implementation you will also learn:

- Form validation
- Event handling
- State management using `useState()`
- Controlled form inputs
- Generating dynamic reference numbers

---

# 4. Prerequisites

The uploaded hands-on lab specifies the following prerequisites:

| Software | Purpose |
|----------|----------|
| Node.js | JavaScript Runtime |
| npm | Package Manager |
| Visual Studio Code | Code Editor | :contentReference[oaicite:3]{index=3}

Basic knowledge of

- HTML
- CSS
- JavaScript
- React Components
- JSX
- React State

is recommended.

---

# 5. Background Concepts

---

# 5.1 What is a Form?

## Definition

A Form is an interface that allows users to enter information and submit it to an application.

Examples

- Login
- Registration
- Complaint
- Feedback
- Contact Us

Flow

```text
User

↓

Fill Form

↓

Submit

↓

Application Processes Data
```

---

# 5.2 What are React Forms?

## Definition

React Forms are forms whose input values are managed using React State.

Instead of letting HTML manage the values,

React stores them using Hooks such as `useState()`.

Example

```text
Textbox

↓

React State

↓

Updated UI
```

---

# 5.3 Why are Forms Important?

Forms are the primary method through which users interact with web applications.

Examples

```text
User

↓

Enter Data

↓

Submit

↓

Database

↓

Response
```

Without forms,

applications cannot collect user information.

---

# 5.4 Controlled Components

## Definition

A Controlled Component is a form element whose value is controlled by React State.

Example

```jsx
const [employeeName, setEmployeeName] = useState("");
```

The textbox value is linked to this state.

Whenever the user types,

React updates the state.

Flow

```text
User Types

↓

onChange()

↓

State Updated

↓

Textbox Updated
```

---

# 5.5 Uncontrolled Components

## Definition

An Uncontrolled Component stores its value inside the HTML element rather than React State.

Example

```text
Textbox

↓

DOM Stores Value
```

React does not directly manage the input.

---

# 5.6 Various Input Controls

React supports many input controls.

Common examples include:

- Textbox
- Password
- Email
- Number
- Checkbox
- Radio Button
- Dropdown
- Textarea
- Button

This exercise specifically uses:

- Textbox
- Textarea
- Submit Button. :contentReference[oaicite:4]{index=4}

---

# 5.7 Textbox (`<input>`)

A Textbox allows users to enter a single line of text.

Example

```jsx
<input

type="text"

/>
```

In this project,

it stores the employee's name.

---

# 5.8 Textarea (`<textarea>`)

A Textarea allows users to enter multiple lines of text.

Example

```jsx
<textarea>

</textarea>
```

In this project,

it stores the employee complaint.

---

# 5.9 Button (`<button>`)

Buttons trigger actions.

Example

```jsx
<button>

Submit

</button>
```

When clicked,

the form is submitted.

---

# 5.10 Event Handling

React responds to user actions using events.

Examples

- Click
- Change
- Submit

Flow

```text
User Action

↓

Event

↓

JavaScript Function

↓

Updated UI
```

---

# 5.11 handleChange()

`handleChange()` updates React State whenever the user changes an input value.

Flow

```text
User Types

↓

onChange()

↓

handleChange()

↓

State Updated
```

The uploaded HOL includes a sample `handleChange()` implementation that updates the state using the input's `name` and `value`. :contentReference[oaicite:5]{index=5}

---

# 5.12 handleSubmit()

`handleSubmit()` executes when the user submits the form.

Responsibilities include:

- Prevent default form refresh.
- Read form values.
- Generate a reference number.
- Display a success alert.

The uploaded HOL specifically requires using the `handleSubmit` event and generating a reference number for further follow-ups. :contentReference[oaicite:6]{index=6}

---

# 5.13 preventDefault()

Normally,

submitting an HTML form refreshes the page.

`preventDefault()` stops this default behavior.

Example

```jsx
event.preventDefault();
```

This allows React to process the form without reloading the application.

---

# 5.14 Form Validation

Form validation ensures that required information is entered before submission.

In this project,

both

- Employee Name
- Complaint

should be entered before the form is submitted.

---

# 5.15 Reference Number Generation

After successful submission,

the application generates a unique reference number.

Example

```text
Reference ID

↓

548231
```

This number can be used later to track the complaint.

The uploaded HOL specifies generating a reference number and displaying it in the alert box after submission. :contentReference[oaicite:7]{index=7}

---

# 6. Project Overview

The **ticketraisingapp** demonstrates how React Forms work using Controlled Components.

The application:

- Accepts employee name.
- Accepts complaint details.
- Handles user input using React State.
- Processes the form using `handleSubmit()`.
- Generates a complaint reference number.
- Displays a success message.

---

# 7. High-Level Architecture

```text
                 React Application
                        │
                        ▼
                     App.js
                        │
                        ▼
              ComplaintRegister
                        │
        ┌───────────────┴───────────────┐
        │                               │
        ▼                               ▼
 Employee Name Input            Complaint Textarea
        │                               │
        └───────────────┬───────────────┘
                        ▼
                   React State
                        │
                        ▼
                  handleSubmit()
                        │
                        ▼
           Generate Reference Number
                        │
                        ▼
                  Alert Message
```

---

# 8. Technologies Used

| Technology | Purpose | Role in this Project |
|------------|---------|----------------------|
| **React** | JavaScript library | Builds the user interface |
| **JSX** | Syntax extension | Creates HTML-like components |
| **React Forms** | Form handling | Manages employee complaint form |
| **useState()** | State management | Controls form inputs |
| **JavaScript (ES6)** | Programming language | Handles events and logic |
| **HTML Form Elements** | User input | Textbox, Textarea, Button |
| **CSS** | Styling | Designs the complaint form |
| **Node.js** | JavaScript runtime | Runs the React application |
| **npm** | Package manager | Installs project dependencies |
| **Visual Studio Code** | Code editor | Used to develop the application |

---

# Exercise 15: Create ticketraisingapp (React Forms)

## Week 5 – ReactJS Hands-on Lab

> **Response 2 of 4**

---

# 9. Project Structure

The **ticketraisingapp** is organized into reusable React components. Each file has a specific responsibility, making the project modular, maintainable, and easy to understand.

```text
ticketraisingapp
│
├── node_modules
│
├── public
│
├── src
│   │
│   ├── components
│   │      │
│   │      └── ComplaintRegister.js
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

This folder contains all third-party packages installed by npm.

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

The **src** folder contains the complete source code of the React application.

It includes

- Components
- CSS
- Main Application
- Entry Point

---

## components

The **components** folder contains reusable React components.

This project contains

```text
ComplaintRegister.js
```

This component is responsible for handling the complaint registration form.

---

# 11. File-by-File Explanation

---

# ComplaintRegister.js

## Purpose

`ComplaintRegister.js` is the main component of this application.

It provides a complaint registration form where users can:

- Enter employee name
- Enter complaint details
- Submit the complaint
- Receive a reference number

---

## State Variables

The component uses React's `useState()` Hook.

```jsx
const [employeeName, setEmployeeName] = useState("");

const [complaint, setComplaint] = useState("");
```

These state variables store the current values entered by the user.

---

## Employee Name Textbox

```jsx
<input

type="text"

value={employeeName}

onChange={(e)=>setEmployeeName(e.target.value)}

required

/>
```

Purpose

- Accept employee name
- Update React State
- Keep textbox synchronized with State

---

## Complaint Textarea

```jsx
<textarea

value={complaint}

onChange={(e)=>setComplaint(e.target.value)}

required

/>
```

Purpose

- Accept complaint details
- Allow multiple lines
- Update React State

---

## Form Submission

The form uses

```jsx
<form onSubmit={handleSubmit}>
```

Instead of handling button clicks directly,

React processes the entire form submission.

The uploaded hands-on lab specifically requires using the **handleSubmit** event for submitting complaints. :contentReference[oaicite:0]{index=0}

---

## handleSubmit()

Responsibilities

- Stop page refresh.
- Generate Reference Number.
- Display Alert.
- Clear the form.

Example

```jsx
event.preventDefault();
```

↓

```text
Generate Reference Number
```

↓

```text
Display Alert
```

↓

```text
Clear Form
```

---

## Reference Number

Reference Number is generated dynamically.

Example

```javascript
const referenceNumber =
Math.floor(100000 + Math.random()*900000);
```

Example Output

```text
548231
```

Every submission generates a different reference number.

The uploaded HOL requires generating a reference number after complaint submission. :contentReference[oaicite:1]{index=1}

---

# App.js

## Purpose

App.js is the root component.

Responsibilities

- Import ComplaintRegister
- Display ComplaintRegister

Example

```jsx
<ComplaintRegister/>
```

The application consists of only one primary component.

---

# App.css

## Purpose

Provides styling for

- Heading
- Form
- Textbox
- Textarea
- Button
- Layout

The CSS creates a centered complaint form similar to the output shown in the uploaded HOL. :contentReference[oaicite:2]{index=2}

---

# index.js

## Purpose

Entry point of the application.

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

Provides global CSS.

Example

```css
body{

margin:0;

font-family:Arial;

}
```

Applies common styling throughout the application.

---

# 12. Configuration Explanation

Create Project

```bash
npx create-react-app ticketraisingapp
```

Move into Project

```bash
cd ticketraisingapp
```

Install Packages

```bash
npm install
```

Run Application

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

ComplaintRegister Component Loads

↓

Form Displayed

---

### Step 3

User Enters

```text
Employee Name
```

↓

React State Updated

---

### Step 4

User Enters

```text
Complaint
```

↓

React State Updated

---

### Step 5

User Clicks

```text
Submit
```

↓

handleSubmit()

---

### Step 6

Generate Random Reference Number

↓

Display Alert

---

### Step 7

Reset Form

↓

Ready for Next Complaint

---

# 14. Code Flow

```text
Application Starts

↓

App.js

↓

ComplaintRegister

↓

Textbox

↓

Textarea

↓

React State

↓

handleSubmit()

↓

Generate Reference Number

↓

Alert Message

↓

Reset Form
```

---

# 15. Execution Flow

```text
User Opens Website

↓

Complaint Form Displayed

↓

Enter Employee Name

↓

Enter Complaint

↓

Click Submit

↓

preventDefault()

↓

Read State Values

↓

Generate Reference Number

↓

Display Alert

↓

Clear Textbox

↓

Clear Textarea

↓

Application Ready Again
```

---

# 16. Internal Working

Internally React performs the following sequence.

```text
User Types

↓

onChange()

↓

setEmployeeName()

↓

setComplaint()

↓

React State Updated

↓

Virtual DOM Updated

↓

User Clicks Submit

↓

handleSubmit()

↓

preventDefault()

↓

Generate Random Number

↓

Alert()

↓

Reset State

↓

UI Updated
```

React automatically synchronizes the form controls with the component state because the textbox and textarea are implemented as **Controlled Components**.

---

# 17. React Forms Implementation

## Employee Name Textbox

```text
Employee

↓

Textbox

↓

employeeName State
```

---

## Complaint Textarea

```text
Complaint

↓

Textarea

↓

complaint State
```

---

## Controlled Components

```text
Textbox

↓

React State

↓

Updated UI
```

Both input controls are managed by React State.

---

## handleSubmit()

```text
Submit Button

↓

handleSubmit()

↓

preventDefault()

↓

Generate Reference Number

↓

Alert()

↓

Reset Form
```

---

## Random Reference Number

Example

```text
548231

731905

682114
```

A different six-digit number is generated every time the complaint is submitted.

---

## Alert Message

Example

```text
Thanks Shrivalli

Your Complaint was Submitted.

Reference ID is : 548231
```

This matches the functionality described in the uploaded HOL, where the complaint is submitted using `handleSubmit()` and a reference number is displayed in an alert box. :contentReference[oaicite:3]{index=3}

---

# Exercise 15: Create ticketraisingapp (React Forms)

## Week 5 – ReactJS Hands-on Lab

> **Response 3 of 4**

---

# 18. Concepts Explained in Detail

The uploaded hands-on lab focuses on implementing the following concepts:

- React Forms
- Controlled Components
- Various Input Controls
- Form Handling
- Form Submission
- `handleSubmit()`
- Textbox
- Textarea
- Button :contentReference[oaicite:0]{index=0}

These concepts are essential for collecting and processing user input in React applications.

---

# 18.1 React Forms

## Definition

A React Form is a form whose input values are managed using React State.

Instead of HTML storing the values,

React stores them inside State variables.

Example

```text
Textbox

↓

React State

↓

Updated UI
```

Whenever the user types,

React immediately updates the state.

---

## Why React Forms?

React Forms provide

- Better control
- Easier validation
- Improved user experience
- Dynamic updates
- Simplified event handling

---

# 18.2 Controlled Components

## Definition

A Controlled Component is a form element whose value is completely controlled by React.

Example

```jsx
const [employeeName, setEmployeeName] = useState("");
```

Textbox

```jsx
<input

value={employeeName}

onChange={...}

/>
```

The textbox always displays the value stored inside React State.

---

## Flow

```text
User Types

↓

onChange()

↓

State Updated

↓

Textbox Updated
```

This is exactly how the Employee Name textbox and Complaint textarea are implemented in this exercise.

---

# 18.3 Uncontrolled Components

## Definition

An Uncontrolled Component stores its value inside the browser's DOM instead of React State.

Example

```text
Textbox

↓

DOM

↓

Application Reads Value
```

React does not continuously track the value.

---

## Controlled vs Uncontrolled Components

| Controlled Component | Uncontrolled Component |
|----------------------|------------------------|
| Uses React State | Uses DOM |
| Value managed by React | Value managed by browser |
| Easy validation | Manual value retrieval |
| Recommended in React | Used for simple cases |

The uploaded HOL specifically focuses on implementing the form using React-controlled inputs. :contentReference[oaicite:1]{index=1}

---

# 18.4 Form Handling

## Definition

Form Handling is the process of

- Accepting user input
- Processing input
- Performing required actions

Flow

```text
User

↓

Fill Form

↓

Submit

↓

Application Processes Data
```

In this project,

processing includes

- Reading employee name
- Reading complaint
- Generating reference number
- Displaying success message

---

# 18.5 Event Handling

React responds to user actions using events.

Common Events

- onChange
- onClick
- onSubmit

Flow

```text
User Action

↓

React Event

↓

JavaScript Function

↓

Updated UI
```

---

# 18.6 handleChange()

The `handleChange()` process updates React State whenever the user changes the value of an input.

Flow

```text
User Types

↓

onChange()

↓

setState()

↓

State Updated

↓

UI Updated
```

The uploaded HOL includes a sample implementation where `handleChange()` updates the state using the input's `name` and `value`. :contentReference[oaicite:2]{index=2}

---

# 18.7 handleSubmit()

## Definition

`handleSubmit()` executes when the user submits the form.

Responsibilities

- Prevent page refresh
- Read entered values
- Generate Reference Number
- Display Alert
- Reset Form

Flow

```text
Submit

↓

handleSubmit()

↓

preventDefault()

↓

Generate Reference Number

↓

Alert

↓

Clear Form
```

The uploaded hands-on lab specifically requires using the `handleSubmit` event for complaint submission. :contentReference[oaicite:3]{index=3}

---

# 18.8 preventDefault()

Normally,

submitting an HTML form refreshes the browser.

React prevents this by calling

```jsx
event.preventDefault();
```

Flow

```text
Submit

↓

preventDefault()

↓

No Page Refresh

↓

React Processes Form
```

Without `preventDefault()`,

the page reloads before React finishes processing the form.

---

# 18.9 useState()

The `useState()` Hook stores data entered by the user.

Example

```jsx
const [employeeName, setEmployeeName] = useState("");

const [complaint, setComplaint] = useState("");
```

Flow

```text
Textbox

↓

State

↓

Updated UI
```

Every keystroke updates React State.

---

# 18.10 Form Validation

Form Validation checks whether required information has been entered.

In this project,

validation ensures that

- Employee Name is entered.
- Complaint is entered.

Using

```jsx
required
```

prevents empty form submission.

---

# 19. Sample Input and Output

### Input

Employee Name

```text
Shrivalli
```

Complaint

```text
Keyboard is not working
```

---

### Browser

```text
Register your complaints here!!!

Name:

Shrivalli

Complaint:

Keyboard is not working

[ Submit ]
```

---

### Alert

```text
Thanks Shrivalli

Your Complaint was Submitted.

Reference ID is : 548231
```

The **Reference ID** changes for every submission because it is generated dynamically.

---

# 20. How to Run the Project

Create Project

```bash
npx create-react-app ticketraisingapp
```

Move into Project

```bash
cd ticketraisingapp
```

Install Packages

```bash
npm install
```

Run Application

```bash
npm start
```

Browser

```text
http://localhost:3000
```

---

# 21. Testing

Verify the following after running the application.

| Test Case | Expected Result |
|-----------|-----------------|
| Application starts | Successfully loads |
| Employee Name textbox | Accepts input |
| Complaint textarea | Accepts multiple lines |
| Submit button | Triggers `handleSubmit()` |
| Page refresh | Prevented |
| Alert message | Displayed |
| Reference Number | Random six-digit number |
| Form reset | Fields cleared after submission |

---

# 22. Best Practices

When working with React Forms:

- Use Controlled Components.
- Store input values in React State.
- Use `required` for mandatory fields.
- Use meaningful state variable names.
- Keep form handling logic inside `handleSubmit()`.
- Call `preventDefault()` before processing.
- Reset form after successful submission.

---

# 23. Common Mistakes

### Forgetting `preventDefault()`

Incorrect

```jsx
handleSubmit(){

...
}
```

Correct

```jsx
event.preventDefault();
```

---

### Missing `value`

Incorrect

```jsx
<input

onChange={...}

/>
```

Correct

```jsx
<input

value={employeeName}

onChange={...}

/>
```

---

### Missing `onChange`

Incorrect

```jsx
<input

value={employeeName}

/>
```

The textbox becomes read-only.

Correct

```jsx
<input

value={employeeName}

onChange={(e)=>setEmployeeName(e.target.value)}
```

---

### Not Clearing the Form

Incorrect

```text
Old values remain after submission.
```

Correct

```jsx
setEmployeeName("");

setComplaint("");
```

---

# 24. Real-world Applications

React Forms are widely used in:

- Employee Complaint Systems
- Student Registration Portals
- Online Banking
- Hospital Registration
- Customer Support Portals
- Feedback Systems
- Online Surveys
- Recruitment Applications
- E-Commerce Checkout Forms
- Contact Us Pages

---

# 25. Advantages

Using React Forms provides:

- Better control over input values
- Easier validation
- Dynamic user interface
- Simplified event handling
- Improved maintainability
- Cleaner code
- Better user experience

---

# 26. Limitations

Although React Forms are powerful,

they also have some considerations:

- More code than plain HTML forms.
- Every controlled input requires State.
- Large forms may need additional optimization.
- Complex validation may require dedicated form libraries.

---

# Exercise 15: Create ticketraisingapp (React Forms)

## Week 5 – ReactJS Hands-on Lab

> **Response 4 of 4**

---

# 27. Frequently Asked Interview Questions

## 1. What is a React Form?

A React Form is a form whose input values are managed using React State instead of relying entirely on the browser.

---

## 2. Why are forms important?

Forms collect information from users and send it to an application for processing.

Examples include:

- Login
- Registration
- Complaint
- Feedback
- Contact Forms

---

## 3. What is a Controlled Component?

A Controlled Component is a form element whose value is controlled by React State.

---

## 4. What is an Uncontrolled Component?

An Uncontrolled Component stores its value inside the browser's DOM instead of React State.

---

## 5. Why are Controlled Components preferred?

Because they

- Keep UI synchronized
- Simplify validation
- Make debugging easier
- Provide predictable behavior

---

## 6. What Hook is commonly used with React Forms?

```jsx
useState()
```

---

## 7. What does `useState()` do?

It stores and updates data inside a React component.

---

## 8. Why is `value` used inside an input element?

It connects the input field with React State.

---

## 9. Why is `onChange()` required?

It updates React State whenever the user types.

---

## 10. What happens if `onChange()` is missing?

The input becomes read-only because React cannot update its state.

---

## 11. What is `handleSubmit()`?

It is a function executed when the user submits a form.

---

## 12. Why do we use `preventDefault()`?

It prevents the browser from refreshing the page after form submission.

---

## 13. What happens if `preventDefault()` is not used?

The page reloads before React finishes processing the form.

---

## 14. What is form validation?

Validation checks whether the entered data satisfies the required conditions before processing.

---

## 15. What HTML elements are used in this project?

- `<form>`
- `<input>`
- `<textarea>`
- `<button>`

These are the input controls required by the uploaded HOL. :contentReference[oaicite:0]{index=0}

---

## 16. Which input control accepts multiple lines?

```html
<textarea>
```

---

## 17. Which input control accepts a single line?

```html
<input type="text">
```

---

## 18. Which event occurs when the form is submitted?

```text
onSubmit
```

---

## 19. Which event occurs when the textbox value changes?

```text
onChange
```

---

## 20. Why do we reset the form after submission?

To prepare the application for the next complaint.

---

## 21. How is the reference number generated?

Using a random number generator in JavaScript.

---

## 22. Why is every reference number different?

Because a new random value is generated each time the form is submitted.

---

## 23. Can React Forms work without `useState()`?

Yes, by using uncontrolled components, but controlled components are generally preferred.

---

## 24. What is state?

State is data maintained by a component that can change over time and trigger UI updates.

---

## 25. What is an event in React?

An event is an action performed by the user, such as typing or clicking.

---

## 26. What is event handling?

Event handling is the process of responding to user actions using JavaScript functions.

---

## 27. Why do React Forms use controlled inputs?

To keep the user interface and application data synchronized.

---

## 28. What are the advantages of React Forms?

- Easy validation
- Better control
- Predictable updates
- Improved maintainability

---

## 29. What does `required` do?

It prevents form submission when mandatory fields are empty.

---

## 30. What is JSX?

JSX is a syntax extension that allows writing HTML-like code inside JavaScript.

---

## 31. What is a React component?

A reusable piece of UI that returns JSX.

---

## 32. Which component is the main component in this project?

```text
ComplaintRegister
```

---

## 33. What is the purpose of `App.js`?

It loads and renders the `ComplaintRegister` component.

---

## 34. What is the purpose of `index.js`?

It serves as the entry point that renders the React application.

---

## 35. What does the complaint registration application demonstrate?

It demonstrates how to create and submit a React Form using controlled inputs, process the submission with `handleSubmit()`, and generate a reference number, as required by the uploaded hands-on lab. :contentReference[oaicite:1]{index=1}

---

# 28. Quick Revision

## Important Concepts

- React Forms
- Controlled Components
- Uncontrolled Components
- State Management
- `useState()`
- Event Handling
- `onChange`
- `onSubmit`
- `handleSubmit()`
- `preventDefault()`
- Form Validation
- Reference Number Generation

---

## Important Files

| File | Purpose |
|------|---------|
| `ComplaintRegister.js` | Complaint registration form |
| `App.js` | Root component |
| `App.css` | Component styling |
| `index.js` | Application entry point |
| `index.css` | Global styling |

---

## Important Commands

Create Project

```bash
npx create-react-app ticketraisingapp
```

Move into Project

```bash
cd ticketraisingapp
```

Install Packages

```bash
npm install
```

Run Application

```bash
npm start
```

Build Application

```bash
npm run build
```

---

# 29. React Forms Cheat Sheet

| Concept | Description |
|----------|-------------|
| Form | Collects user input |
| Controlled Component | Input controlled by React State |
| Uncontrolled Component | Input controlled by DOM |
| `useState()` | Stores component data |
| `onChange` | Updates state when input changes |
| `onSubmit` | Handles form submission |
| `preventDefault()` | Prevents page refresh |
| `<input>` | Single-line text input |
| `<textarea>` | Multi-line text input |
| `<button>` | Triggers actions |

---

# 30. Project Workflow

```text
Start Application
        │
        ▼
Render Complaint Form
        │
        ▼
Enter Employee Name
        │
        ▼
Enter Complaint
        │
        ▼
React State Updated
        │
        ▼
Click Submit
        │
        ▼
handleSubmit()
        │
        ▼
preventDefault()
        │
        ▼
Generate Reference Number
        │
        ▼
Display Success Alert
        │
        ▼
Reset Form
        │
        ▼
Ready for Next Complaint
```

---

# 31. Key Takeaways

After completing this exercise, you should understand how to:

- Build forms using React.
- Manage user input with `useState()`.
- Implement controlled components.
- Handle events using `onChange` and `onSubmit`.
- Prevent default browser form submission.
- Generate and display a complaint reference number.
- Reset form fields after successful submission.
- Structure a simple React application using reusable components.

These outcomes align with the learning objectives of the uploaded React Forms hands-on lab. :contentReference[oaicite:2]{index=2}

---

# 32. Conclusion

The **ticketraisingapp** project provides a practical introduction to **React Forms** and **Controlled Components**. It demonstrates how to collect user input through a textbox and textarea, manage that input using React State, process the submission with `handleSubmit()`, prevent the browser's default form behavior, and generate a reference number after a successful complaint submission.

By completing this exercise, you gain hands-on experience with the core concepts required to build interactive form-based applications in React, such as employee portals, feedback systems, registration pages, and customer support applications.

---

# 33. Next Learning Path

After mastering this exercise, you can continue learning:

1. Form Validation with custom error messages
2. Multiple input fields using a single state object
3. Checkbox and Radio Button handling
4. Select (Dropdown) controls
5. File Upload Forms
6. Dynamic Forms
7. React Router for multi-page applications
8. API Integration using `fetch()` or Axios
9. Form Libraries such as React Hook Form
10. State Management using Context API or Redux

---

# README Complete

This README documents the concepts and implementation demonstrated in **Exercise 15 – Create ticketraisingapp (React Forms)**, following the scope and learning objectives of the uploaded hands-on lab. :contentReference[oaicite:3]{index=3}

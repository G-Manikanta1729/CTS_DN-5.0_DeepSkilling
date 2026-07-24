# Exercise 16: Create mailregisterapp (React Forms Validation)

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
- HTML Forms
- React Forms
- HTML Forms vs React Forms
- Why Form Validation is Important?
- Controlled Components
- Uncontrolled Components
- Various Input Controls
- Textbox
- Email Input
- Password Input
- Submit Button
- Event Handling
- handleChange()
- handleSubmit()
- preventDefault()
- Regular Expressions (Regex)
- Validation Rules
- Error Handling
- Project Overview
- High-Level Architecture
- Technologies Used

---

# 1. Project Title

# Create mailregisterapp (React Forms Validation)

**Week 5 – ReactJS Hands-on Lab**

**Exercise 16 – React Forms Validation**

---

# 2. Introduction

## What is this project?

This hands-on exercise demonstrates how to build a **React Registration Form** with **input validation** using **Controlled Components**.

According to the uploaded Hands-on Lab, you need to create a React application named **mailregisterapp** with a component named **Register.js**. The application accepts a user's **Name**, **Email**, and **Password**, validates each field, and displays appropriate messages based on the entered values. The validations must be implemented using **event handling (`handleChange`)** and **form submission (`handleSubmit`)**. :contentReference[oaicite:0]{index=0}

---

## What problem does this project solve?

Imagine a website where users can create an account.

Before creating the account, the application must ensure that the entered information is valid.

Examples:

- Name should not be too short.
- Email should follow a valid format.
- Password should be strong enough.

Without validation, users could submit incorrect information like:

```text
Name     : abc

Email    : hello

Password : 123
```

Such information is not useful and may lead to application errors.

Validation prevents these problems before the data is processed.

---

## Why is Form Validation Important?

Form validation ensures that the user enters correct and meaningful information before submitting the form.

Validation helps to:

- Improve data accuracy
- Prevent invalid submissions
- Improve user experience
- Reduce server-side errors
- Increase application security

Without validation, applications may store incomplete or incorrect information.

---

## What is React Form Validation?

React Form Validation is the process of checking user input before processing or submitting the form.

Instead of allowing every input,

React verifies whether each field satisfies predefined rules.

Example

```text
User

↓

Enter Details

↓

React Validation

↓

Valid?

↓

Yes → Submit

No → Display Error
```

---

## Why do we use Controlled Components?

In React,

the values entered by the user are stored inside the component's **State**.

Every input field is connected with React State.

Example

```text
Textbox

↓

React State

↓

Updated UI
```

This makes React the single source of truth.

---

## What are Uncontrolled Components?

Uncontrolled Components allow the browser's DOM to store input values.

Example

```text
Textbox

↓

Browser DOM

↓

Application Reads Value
```

Unlike Controlled Components,

React does not continuously manage the input values.

---

## Why do we validate during typing?

The uploaded HOL specifies implementing validation through **event handling**.

As the user types,

React immediately checks whether the entered value satisfies the required rule.

Example

```text
User Types

↓

handleChange()

↓

Validation

↓

Display Error / Remove Error
```

This provides immediate feedback to the user. :contentReference[oaicite:1]{index=1}

---

## Why validate again during submission?

Even if validation occurs while typing,

the application performs one final validation when the user clicks **Submit**.

This ensures that all fields are valid before accepting the form.

Flow

```text
Submit

↓

handleSubmit()

↓

Validate All Fields

↓

Valid?

↓

Yes → Success

No → Show Error
```

---

## Real-world Applications

React Form Validation is used in:

- User Registration Systems
- Login Pages
- Banking Applications
- Hospital Registration
- Student Admission Portals
- Online Shopping Websites
- Employee Registration
- Job Application Forms
- Contact Forms
- Government Service Portals

---

# 3. Learning Objectives

According to the uploaded Hands-on Lab, after completing this exercise you should be able to:

- Explain React Forms validation.
- Identify the differences between HTML Forms and React Forms.
- Explain Controlled Components.
- Identify various React Form input controls.
- Explain handling React Forms.
- Explain submitting forms.
- Implement React Forms validation.
- Use textbox, button, and textarea/input controls for validation. :contentReference[oaicite:2]{index=2}

In addition, this implementation helps you understand:

- State Management using `useState()`
- Event Handling
- Regular Expressions (Regex)
- Client-side Validation
- Error Handling

---

# 4. Prerequisites

The uploaded Hands-on Lab specifies the following prerequisites:

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

will help you understand this exercise more easily.

---

# 5. Background Concepts

---

# 5.1 What is a Form?

## Definition

A Form is a user interface element that collects information from users.

Examples include:

- Login Form
- Registration Form
- Feedback Form
- Complaint Form
- Contact Form

General Flow

```text
User

↓

Enter Data

↓

Submit

↓

Application Processes Information
```

---

# 5.2 HTML Forms

HTML Forms collect user information using HTML elements.

Example

```html
<form>

<input>

<button>

</form>
```

The browser manages the form values.

---

# 5.3 React Forms

React Forms also collect user information,

but React manages every input using **State**.

Example

```text
Textbox

↓

React State

↓

Updated UI
```

This gives developers complete control over the data entered by the user.

---

# 5.4 HTML Forms vs React Forms

| HTML Forms | React Forms |
|------------|-------------|
| Browser controls input values | React State controls input values |
| Less control | Complete control |
| Simple validation | Dynamic validation |
| Page reloads by default | Uses `preventDefault()` |
| Suitable for static pages | Suitable for dynamic applications |

---

# 5.5 Why Form Validation is Important?

Validation ensures that users enter valid information before submission.

Examples

Correct

```text
Name

Manikanta
```

Incorrect

```text
Name

abc
```

Correct

```text
Email

manikanta@gmail.com
```

Incorrect

```text
Email

manikanta
```

Validation improves both user experience and data quality.

---

# 5.6 Controlled Components

## Definition

A Controlled Component is a form element whose value is completely controlled by React State.

Example

```jsx
const [user, setUser] = useState({
  fullName: "",
  email: "",
  password: ""
});
```

Every time the user types,

React updates the corresponding State value.

Flow

```text
User Types

↓

handleChange()

↓

State Updated

↓

UI Updated
```

---

# 5.7 Uncontrolled Components

## Definition

An Uncontrolled Component stores its value inside the browser DOM instead of React State.

Flow

```text
Textbox

↓

DOM Stores Value

↓

Application Reads Value
```

React does not automatically synchronize these values.

---

# 5.8 Various Input Controls

React supports many input controls.

Examples

- Textbox
- Email
- Password
- Textarea
- Checkbox
- Radio Button
- Dropdown
- Submit Button

This exercise specifically uses:

- Textbox
- Email Input
- Password Input
- Submit Button. :contentReference[oaicite:4]{index=4}

---

# 5.9 Textbox

Textbox accepts single-line text input.

Example

```jsx
<input type="text" />
```

Used here to collect the user's name.

---

# 5.10 Email Input

Email input collects the user's email address.

Example

```jsx
<input type="text" />
```

The entered value is validated to ensure it contains a valid email format.

---

# 5.11 Password Input

Password fields hide entered characters for security.

Example

```jsx
<input type="password" />
```

The uploaded HOL requires the password to contain at least **8 characters**. :contentReference[oaicite:5]{index=5}

---

# 5.12 Submit Button

The Submit button sends the form for validation.

Example

```jsx
<button>

Submit

</button>
```

Clicking this button triggers the `handleSubmit()` function.

---

# 5.13 Event Handling

React responds to user actions using events.

Examples

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

# 5.14 handleChange()

`handleChange()` executes whenever the user modifies an input field.

Responsibilities:

- Read input value
- Validate input
- Update State
- Store validation message

The uploaded HOL specifically instructs implementing validation through the event handler. :contentReference[oaicite:6]{index=6}

---

# 5.15 handleSubmit()

`handleSubmit()` executes when the user submits the form.

Responsibilities:

- Prevent page refresh
- Validate all fields
- Display error messages
- Display **"Valid Form"** if all inputs satisfy the validation rules

---

# 5.16 preventDefault()

Normally,

HTML Forms refresh the page after submission.

React prevents this behavior using:

```jsx
event.preventDefault();
```

This allows React to validate the form without reloading the page.

---

# 5.17 Regular Expressions (Regex)

A Regular Expression (Regex) is a pattern used to validate text.

In this project,

Regex is used to validate the email format.

Example

```text
user@gmail.com

✔ Valid

abc

✘ Invalid
```

---

# 5.18 Validation Rules

According to the uploaded Hands-on Lab, the validation rules are:

| Field | Validation Rule |
|--------|-----------------|
| Name | At least 5 characters |
| Email | Must contain `@` and `.` |
| Password | At least 8 characters | :contentReference[oaicite:7]{index=7}

---

# 5.19 Error Handling

Whenever a validation fails,

the application displays an appropriate message.

Examples

```text
Full Name must be 5 characters long!
```

```text
Email is not valid!
```

```text
Password must be 8 characters long!
```

---

# 6. Project Overview

The **mailregisterapp** demonstrates how to implement **React Form Validation** using Controlled Components.

The application:

- Accepts Name
- Accepts Email
- Accepts Password
- Validates each field while typing
- Validates again during form submission
- Displays validation messages
- Displays **"Valid Form"** when all inputs are correct

---

# 7. High-Level Architecture

```text
                   React Application
                          │
                          ▼
                       App.js
                          │
                          ▼
                     Register.js
                          │
          ┌───────────────┼───────────────┐
          ▼               ▼               ▼
       Name Input     Email Input    Password Input
          │               │               │
          └───────────────┼───────────────┘
                          ▼
                     handleChange()
                          │
                          ▼
                  React State Updated
                          │
                          ▼
                     handleSubmit()
                          │
                          ▼
                  Validate Entire Form
                          │
             ┌────────────┴────────────┐
             ▼                         ▼
      Validation Error          Valid Form
```

---

# 8. Technologies Used

| Technology | Purpose | Role in this Project |
|------------|---------|----------------------|
| **React** | JavaScript Library | Builds the user interface |
| **JSX** | Syntax Extension | Creates UI Components |
| **React Forms** | Form Handling | Manages Registration Form |
| **useState()** | State Management | Stores user input |
| **JavaScript (ES6)** | Programming Language | Implements validation logic |
| **Regular Expressions (Regex)** | Pattern Matching | Validates Email Format |
| **HTML** | Structure | Creates form controls |
| **CSS** | Styling | Styles the registration form |
| **Node.js** | JavaScript Runtime | Runs the React application |
| **npm** | Package Manager | Installs dependencies |
| **Visual Studio Code** | IDE | Used for development |

---

# Exercise 16: Create mailregisterapp (React Forms Validation)

## Week 5 – ReactJS Hands-on Lab

> **Response 2 of 4**

---

# 9. Project Structure

The **mailregisterapp** follows a simple React project structure. Each file has a specific responsibility, making the application easy to understand, maintain, and extend.

```text
mailregisterapp
│
├── node_modules
│
├── public
│
├── src
│   │
│   ├── components
│   │      │
│   │      └── Register.js
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

This folder contains all the external libraries and packages required by the React application.

Examples include:

- React
- React DOM
- Babel
- Webpack

This folder is automatically created after executing:

```bash
npm install
```

---

## public

The **public** folder stores static files that are directly served by the browser.

Examples include:

- index.html
- favicon.ico
- manifest.json

The React application is injected into **index.html**.

---

## src

The **src** folder contains the complete source code of the project.

It includes:

- React Components
- CSS files
- JavaScript files
- Application entry point

---

## components

The **components** folder stores reusable React components.

This project contains a single component:

```text
Register.js
```

This component contains the complete registration form and validation logic.

---

# 11. File-by-File Explanation

---

# Register.js

## Purpose

`Register.js` is the main component of this project.

It performs the following tasks:

- Displays the registration form
- Stores user input
- Validates Name
- Validates Email
- Validates Password
- Displays validation messages
- Submits the form when all validations pass

---

## React State

The component uses the `useState()` Hook to store user information.

```jsx
const [user, setUser] = useState({
    fullName:"",
    email:"",
    password:""
});
```

The application also stores validation messages.

```jsx
const [errors, setErrors] = useState({
    fullName:"",
    email:"",
    password:""
});
```

---

## Name Validation

Whenever the user types inside the Name textbox,

React checks whether the entered name contains at least **5 characters**.

Flow

```text
User Types

↓

handleChange()

↓

Check Length

↓

Less than 5 ?

↓

Yes → Display Error

No → Remove Error
```

The uploaded HOL specifies that the Name should have at least **5 characters**. :contentReference[oaicite:0]{index=0}

---

## Email Validation

React validates the Email using a Regular Expression.

Flow

```text
User Types

↓

Regex Validation

↓

Contains @ ?

↓

Contains . ?

↓

Valid / Invalid
```

The uploaded HOL specifies that the Email should contain **@** and **.**. :contentReference[oaicite:1]{index=1}

---

## Password Validation

The Password is validated while typing.

Rule

```text
Password Length ≥ 8
```

Flow

```text
User Types

↓

Check Length

↓

Less than 8 ?

↓

Yes → Error

No → Valid
```

The uploaded HOL specifies that the Password should have at least **8 characters**. :contentReference[oaicite:2]{index=2}

---

## handleChange()

Every time the user modifies a field,

`handleChange()` performs the following operations:

```text
Read Input

↓

Identify Field

↓

Validate Input

↓

Update Error

↓

Update State
```

This matches the event-based validation approach shown in the uploaded HOL. :contentReference[oaicite:3]{index=3}

---

## validateForm()

The purpose of `validateForm()` is to ensure that:

- No validation errors exist.
- No field is empty.

Flow

```text
Errors Empty?

↓

Yes

↓

Fields Empty?

↓

No

↓

Valid Form
```

---

## handleSubmit()

When the Submit button is clicked,

`handleSubmit()` executes.

Responsibilities:

- Prevent page refresh
- Validate the complete form
- Display appropriate alert message

Flow

```text
Submit

↓

preventDefault()

↓

validateForm()

↓

Valid?

↓

Yes → Alert("Valid Form")

No → Display Error
```

The uploaded HOL specifically instructs implementing validation using **eventsubmit** (`handleSubmit`). :contentReference[oaicite:4]{index=4}

---

# App.js

## Purpose

`App.js` is the root component of the application.

Responsibilities:

- Import Register component
- Render Register component

Example

```jsx
<Register/>
```

The entire application is displayed through this component.

---

# App.css

## Purpose

`App.css` styles the application.

It provides:

- Center alignment
- Heading color
- Table spacing
- Textbox styling
- Button styling
- Proper layout

The CSS is designed to closely resemble the sample output provided in the uploaded HOL. :contentReference[oaicite:5]{index=5}

---

# index.js

## Purpose

`index.js` is the entry point of the React application.

Responsibilities:

- Create React Root
- Render `<App />`
- Load global CSS

Flow

```text
Browser

↓

index.js

↓

<App/>

↓

React DOM

↓

Display Application
```

---

# index.css

## Purpose

Provides global styling for the application.

Example

```css
body{

margin:0;

font-family:Arial, Helvetica, sans-serif;

background:#f5f5f5;

}
```

This styling is automatically applied throughout the application.

---

# 12. Configuration Explanation

Create the project.

```bash
npx create-react-app mailregisterapp
```

Move into the project.

```bash
cd mailregisterapp
```

Install dependencies.

```bash
npm install
```

Run the application.

```bash
npm start
```

Open the browser.

```text
http://localhost:3000
```

---

# 13. Implementation Explanation

The application executes the following sequence.

### Step 1

Application Starts

↓

App.js Loaded

---

### Step 2

Register Component Loaded

↓

Registration Form Displayed

---

### Step 3

User Enters Name

↓

handleChange()

↓

Validate Name

---

### Step 4

User Enters Email

↓

handleChange()

↓

Validate Email

---

### Step 5

User Enters Password

↓

handleChange()

↓

Validate Password

---

### Step 6

User Clicks Submit

↓

handleSubmit()

↓

validateForm()

---

### Step 7

All Valid?

↓

Yes

↓

Display

```text
Valid Form
```

Otherwise

↓

Display Validation Error

---

# 14. Code Flow

```text
Application Starts

↓

App.js

↓

Register Component

↓

User Input

↓

handleChange()

↓

React State Updated

↓

Validation

↓

handleSubmit()

↓

validateForm()

↓

Alert Message

↓

Process Completed
```

---

# 15. Execution Flow

```text
User Opens Application

↓

Registration Form Appears

↓

Enter Name

↓

Validate Name

↓

Enter Email

↓

Validate Email

↓

Enter Password

↓

Validate Password

↓

Click Submit

↓

preventDefault()

↓

Check All Fields

↓

Validation Success?

↓

Yes → Valid Form

No → Validation Error
```

---

# 16. Internal Working

Internally, React performs the following operations.

```text
User Types

↓

onChange()

↓

handleChange()

↓

Validation Logic

↓

State Updated

↓

Virtual DOM Updated

↓

User Clicks Submit

↓

handleSubmit()

↓

preventDefault()

↓

validateForm()

↓

Alert()

↓

Finish
```

---

# 17. React Forms Validation Implementation

## Name Validation

```text
Textbox

↓

Minimum 5 Characters

↓

Valid / Invalid
```

---

## Email Validation

```text
Email Input

↓

Regex Validation

↓

Contains @ and .

↓

Valid / Invalid
```

---

## Password Validation

```text
Password Input

↓

Minimum 8 Characters

↓

Valid / Invalid
```

---

## Alert Messages

If validation fails,

messages such as

```text
Full Name must be 5 characters long!

Email is not valid!

Password must be 8 characters long!
```

are displayed.

If every validation succeeds,

```text
Valid Form
```

is displayed.

This behavior follows the validation rules and expected output shown in the uploaded Hands-on Lab. :contentReference[oaicite:6]{index=6}

---

# Exercise 16: Create mailregisterapp (React Forms Validation)

## Week 5 – ReactJS Hands-on Lab

> **Response 3 of 4**

---

# 18. Concepts Explained in Detail

The uploaded Hands-on Lab focuses on implementing the following concepts:

- React Forms Validation
- React Forms
- Controlled Components
- Event Handling
- Form Submission
- Validation using `handleChange()`
- Validation using `handleSubmit()`
- Input Controls
- Name Validation
- Email Validation
- Password Validation :contentReference[oaicite:0]{index=0}

These concepts form the foundation of creating secure and user-friendly forms in React applications.

---

# 18.1 React Forms Validation

## Definition

React Forms Validation is the process of checking whether user input satisfies predefined rules before the form is accepted.

Instead of directly accepting every value,

React validates the information entered by the user.

Flow

```text
User

↓

Enter Details

↓

Validation

↓

Valid?

↓

Yes → Submit

No → Show Error
```

---

## Why is Validation Required?

Validation helps to:

- Prevent incorrect data
- Improve user experience
- Maintain data consistency
- Reduce server-side errors
- Improve application security

Without validation,

users could submit invalid or incomplete information.

---

# 18.2 HTML Forms vs React Forms

| HTML Forms | React Forms |
|------------|-------------|
| Browser controls the form | React State controls the form |
| Limited validation | Dynamic validation |
| Page refreshes after submit | Uses `preventDefault()` |
| Less control over input | Complete control over input |
| Suitable for simple pages | Suitable for interactive applications |

The uploaded HOL highlights understanding the differences between HTML Forms and React Forms. :contentReference[oaicite:1]{index=1}

---

# 18.3 Controlled Components

## Definition

A Controlled Component is an input element whose value is managed by React State.

Example

```jsx
const [user, setUser] = useState({
    fullName:"",
    email:"",
    password:""
});
```

Every time the user types,

React immediately updates the state.

Flow

```text
User Types

↓

handleChange()

↓

State Updated

↓

UI Updated
```

---

# 18.4 Uncontrolled Components

## Definition

An Uncontrolled Component stores its value inside the browser's DOM.

Flow

```text
Textbox

↓

Browser DOM

↓

Application Reads Value
```

React does not continuously monitor these values.

---

# 18.5 Form Handling

## Definition

Form Handling is the process of collecting user information and processing it.

Flow

```text
User

↓

Enter Data

↓

React Reads Data

↓

Validation

↓

Submission
```

In this project,

the form collects

- Name
- Email
- Password

before validation.

---

# 18.6 Event Handling

React responds to user actions using events.

Examples include:

- `onChange`
- `onSubmit`
- `onClick`

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

# 18.7 handleChange()

`handleChange()` executes whenever the user changes an input field.

Responsibilities:

- Read entered value
- Identify the field
- Validate the value
- Update State
- Update Error Messages

Flow

```text
User Types

↓

handleChange()

↓

Validation

↓

State Updated

↓

UI Updated
```

The uploaded HOL specifically requires validation through the **event handler** (`handleChange`). :contentReference[oaicite:2]{index=2}

---

# 18.8 handleSubmit()

## Definition

`handleSubmit()` executes when the user clicks the **Submit** button.

Responsibilities:

- Prevent browser refresh
- Validate all fields
- Display validation message
- Display **"Valid Form"** when all inputs are correct

Flow

```text
Submit

↓

handleSubmit()

↓

preventDefault()

↓

validateForm()

↓

Valid?

↓

Yes → Valid Form

No → Error Message
```

The uploaded HOL specifies implementing validation using **eventsubmit** (`handleSubmit`). :contentReference[oaicite:3]{index=3}

---

# 18.9 preventDefault()

Normally,

an HTML form refreshes the page after submission.

React prevents this behavior using

```jsx
event.preventDefault();
```

Flow

```text
Submit

↓

preventDefault()

↓

No Refresh

↓

Validation Continues
```

---

# 18.10 useState()

The `useState()` Hook stores and updates the values entered into the form.

Example

```jsx
const [user, setUser] = useState({
    fullName:"",
    email:"",
    password:""
});
```

Flow

```text
Input Field

↓

React State

↓

Updated UI
```

Every keystroke updates the corresponding state variable.

---

# 18.11 Validation Rules

According to the uploaded Hands-on Lab, the following validation rules must be applied:

| Field | Validation Rule |
|--------|-----------------|
| Name | At least 5 characters |
| Email | Must contain `@` and `.` |
| Password | At least 8 characters | :contentReference[oaicite:4]{index=4}

---

# 18.12 Regular Expressions (Regex)

## Definition

A Regular Expression (Regex) is a sequence of characters used to define a search or validation pattern.

In this project,

Regex is used to verify whether the email follows a valid format.

Example

```text
abc@gmail.com

✔ Valid
```

```text
abcgmail

✘ Invalid
```

---

# 18.13 Error Handling

Whenever a validation rule fails,

the application displays an alert message.

Examples

```text
Full Name must be 5 characters long!
```

```text
Email is not valid!
```

```text
Password must be 8 characters long!
```

These messages guide users to correct their input before submitting the form.

---

# 19. Sample Input and Output

### Invalid Input

```text
Name

abc

Email

abc

Password

12345
```

Output

```text
Full Name must be 5 characters long!
```

or

```text
Email is not valid!
```

or

```text
Password must be 8 characters long!
```

depending on the first validation failure.

---

### Valid Input

```text
Name

Manikanta

Email

manikanta@gmail.com

Password

password123
```

Output

```text
Valid Form
```

The expected validation behavior and output are consistent with the uploaded Hands-on Lab. :contentReference[oaicite:5]{index=5}

---

# 20. How to Run the Project

Create the project.

```bash
npx create-react-app mailregisterapp
```

Move into the project.

```bash
cd mailregisterapp
```

Install dependencies.

```bash
npm install
```

Run the application.

```bash
npm start
```

Open the browser.

```text
http://localhost:3000
```

---

# 21. Testing

Verify the following test cases after running the application.

| Test Case | Expected Result |
|-----------|-----------------|
| Application starts | Successfully loads |
| Name field | Accepts input |
| Email field | Accepts input |
| Password field | Accepts hidden input |
| Name < 5 characters | Validation message displayed |
| Invalid Email | Validation message displayed |
| Password < 8 characters | Validation message displayed |
| Valid Input | "Valid Form" alert displayed |
| Page refresh | Prevented |

---

# 22. Best Practices

While implementing React Forms Validation:

- Use Controlled Components.
- Store all form values in React State.
- Validate inputs during typing.
- Validate again before submission.
- Use meaningful validation messages.
- Prevent page refresh using `preventDefault()`.
- Keep validation logic inside dedicated functions.
- Use Regular Expressions for email validation.

---

# 23. Common Mistakes

### Forgetting `preventDefault()`

Incorrect

```jsx
handleSubmit(){

}
```

Correct

```jsx
event.preventDefault();
```

---

### Missing `onChange`

Incorrect

```jsx
<input value={user.fullName} />
```

The textbox becomes read-only.

Correct

```jsx
<input

value={user.fullName}

onChange={handleChange}

/>
```

---

### Incorrect Email Validation

Incorrect

```text
Only checking for "@"
```

Correct

```text
Validate complete email format using Regex.
```

---

### Forgetting to Update State

Incorrect

```jsx
setErrors(validationErrors);
```

Correct

```jsx
setErrors(validationErrors);

setUser({

...user,

[name]:value

});
```

Both the validation messages and the user input should be updated.

---

# 24. Real-world Applications

React Forms Validation is widely used in:

- User Registration Systems
- Login Applications
- Banking Portals
- Hospital Registration Systems
- Student Admission Portals
- Employee Registration Systems
- Government Service Portals
- Job Application Websites
- Customer Feedback Systems
- E-Commerce Checkout Pages

---

# 25. Advantages

Using React Forms Validation provides:

- Better user experience
- Accurate data collection
- Immediate feedback
- Reduced server-side validation
- Cleaner application logic
- Improved security
- Easier maintenance

---

# 26. Limitations

Although React Forms Validation is powerful,

it also has some limitations:

- Requires additional code compared to plain HTML forms.
- Large forms may need more complex state management.
- Advanced validation may require external libraries.
- Client-side validation should always be complemented by server-side validation in production applications.

---

# Exercise 16: Create mailregisterapp (React Forms Validation)

## Week 5 – ReactJS Hands-on Lab

> **Response 4 of 4**

---

# 27. Frequently Asked Interview Questions

## 1. What is a React Form?

**Answer:**

A React Form is a collection of input elements whose values are managed by React components. Unlike HTML forms, React generally manages form data using **State**.

---

## 2. What is Form Validation?

**Answer:**

Form Validation is the process of verifying whether the user has entered valid information before processing or submitting the form.

---

## 3. Why is Form Validation important?

**Answer:**

It helps to:

- Prevent invalid data
- Improve user experience
- Reduce server-side errors
- Improve application security
- Maintain data consistency

---

## 4. What is a Controlled Component?

**Answer:**

A Controlled Component is an input element whose value is controlled by React State.

---

## 5. What is an Uncontrolled Component?

**Answer:**

An Uncontrolled Component stores its value inside the browser DOM instead of React State.

---

## 6. Which Hook is used to manage form data?

**Answer:**

`useState()`

---

## 7. Why is `useState()` used?

**Answer:**

It stores and updates user input dynamically.

---

## 8. What is `handleChange()`?

**Answer:**

It executes whenever the user changes the value of an input field.

---

## 9. Why is `handleChange()` used?

**Answer:**

To:

- Read input values
- Validate data
- Update React State
- Display validation messages

---

## 10. What is `handleSubmit()`?

**Answer:**

It executes when the form is submitted.

---

## 11. Why is `preventDefault()` used?

**Answer:**

It prevents the browser from refreshing the page after form submission.

---

## 12. What is client-side validation?

**Answer:**

Validation performed in the browser before data is sent to the server.

---

## 13. What is server-side validation?

**Answer:**

Validation performed on the server after receiving data from the client.

---

## 14. What is Regex?

**Answer:**

Regex (Regular Expression) is a pattern used to validate text such as email addresses.

---

## 15. Why is Regex used in this project?

**Answer:**

To verify that the email follows a valid format.

---

## 16. What are the validation rules in this project?

**Answer:**

According to the uploaded Hands-on Lab:

- Name → Minimum 5 characters
- Email → Must contain **@** and **.**
- Password → Minimum 8 characters :contentReference[oaicite:0]{index=0}

---

## 17. Which input controls are used?

**Answer:**

- Textbox
- Email Input
- Password Input
- Submit Button :contentReference[oaicite:1]{index=1}

---

## 18. Which component contains the registration form?

**Answer:**

`Register.js`

---

## 19. Which component loads the Register component?

**Answer:**

`App.js`

---

## 20. What happens when invalid data is entered?

**Answer:**

The application displays an appropriate validation message.

---

## 21. What happens when all inputs are valid?

**Answer:**

The application displays the alert:

```text
Valid Form
```

---

## 22. Why should validation occur while typing?

**Answer:**

It provides immediate feedback to users and helps them correct mistakes early.

---

## 23. Why validate again during submission?

**Answer:**

To ensure all fields are valid before accepting the form.

---

## 24. What is React State?

**Answer:**

State is a React object that stores dynamic data and automatically updates the UI when its values change.

---

## 25. What is JSX?

**Answer:**

JSX is a syntax extension that allows developers to write HTML-like code inside JavaScript.

---

## 26. Why use React Forms instead of HTML Forms?

**Answer:**

React Forms provide better control, dynamic validation, and easier state management.

---

## 27. What event is triggered while typing?

**Answer:**

`onChange`

---

## 28. What event is triggered while submitting the form?

**Answer:**

`onSubmit`

---

## 29. Can validation be performed without React State?

**Answer:**

Yes, by using Uncontrolled Components, but Controlled Components are generally preferred because they provide better control over form data.

---

## 30. Why should forms display meaningful error messages?

**Answer:**

Meaningful messages help users quickly identify and correct mistakes.

---

## 31. What is the purpose of alerts in this project?

**Answer:**

To notify users whether the entered information is valid or invalid.

---

## 32. What software is required to run this project?

**Answer:**

- Node.js
- npm
- Visual Studio Code :contentReference[oaicite:2]{index=2}

---

## 33. Which React Hook is used in this exercise?

**Answer:**

`useState()`

---

## 34. Can this validation replace server-side validation?

**Answer:**

No. Client-side validation improves user experience, but production applications should also perform server-side validation.

---

## 35. What is the main objective of this exercise?

**Answer:**

To learn how to build and validate React Forms using Controlled Components, event handling, and state management. :contentReference[oaicite:3]{index=3}

---

# 28. Quick Revision Notes

## Important Concepts

- React Forms
- Controlled Components
- Uncontrolled Components
- Form Validation
- Event Handling
- `useState()`
- `handleChange()`
- `handleSubmit()`
- `preventDefault()`
- Regex Validation

---

## Important Files

```text
src/
│
├── components/
│     └── Register.js
│
├── App.js
├── App.css
├── index.js
└── index.css
```

---

## Important Commands

Create project

```bash
npx create-react-app mailregisterapp
```

Move into project

```bash
cd mailregisterapp
```

Install dependencies

```bash
npm install
```

Run application

```bash
npm start
```

---

# 29. React Forms Validation Cheat Sheet

| Concept | Purpose |
|---------|---------|
| `useState()` | Store form values |
| `onChange` | Detect input changes |
| `handleChange()` | Update state and validate |
| `onSubmit` | Submit the form |
| `handleSubmit()` | Perform final validation |
| `preventDefault()` | Prevent page refresh |
| Regex | Validate email format |
| Controlled Component | React controls input values |
| Validation | Check user input before submission |

---

# 30. Project Workflow Summary

```text
Start Application
        │
        ▼
Render Register Component
        │
        ▼
User Enters Name
        │
        ▼
Validate Name
        │
        ▼
User Enters Email
        │
        ▼
Validate Email
        │
        ▼
User Enters Password
        │
        ▼
Validate Password
        │
        ▼
Click Submit
        │
        ▼
preventDefault()
        │
        ▼
Validate Entire Form
        │
   ┌────┴────┐
   ▼         ▼
Invalid    Valid
   │         │
Show      Alert
Error   "Valid Form"
```

---

# 31. Key Takeaways

After completing this exercise, you should be able to:

- Create a React registration form.
- Use Controlled Components.
- Manage form data using `useState()`.
- Handle user input with `handleChange()`.
- Submit forms using `handleSubmit()`.
- Prevent page refresh using `preventDefault()`.
- Validate Name, Email, and Password fields.
- Use Regex for email validation.
- Display meaningful validation messages.
- Build user-friendly forms using React.

These learning outcomes align with the objectives of the uploaded Hands-on Lab. :contentReference[oaicite:4]{index=4}

---

# 32. Conclusion

The **mailregisterapp** project introduces the fundamentals of **React Forms Validation** through a practical registration form.

In this exercise, a registration form is created using **Controlled Components**, where React State manages the values entered into the Name, Email, and Password fields. Validation is performed while the user types through `handleChange()` and again during form submission through `handleSubmit()`. By preventing invalid submissions and providing immediate feedback, the application demonstrates how React can be used to build reliable and user-friendly forms.

The Hands-on Lab focuses on implementing validation rules for the Name, Email, and Password fields using event handling and form submission, making it an excellent introduction to React form handling concepts. :contentReference[oaicite:5]{index=5}

---

# 33. Next Learning Path

After mastering this exercise, continue with the following React topics:

1. React Hooks (`useEffect`, `useReducer`)
2. React Router
3. Context API
4. REST API Integration
5. Axios
6. Redux
7. Authentication (JWT)
8. Protected Routes
9. React Performance Optimization
10. Deployment of React Applications

Learning these topics will help you build larger, scalable, and production-ready React applications.

---

# README Completed

This README provides:

- Beginner-friendly explanations
- Detailed concept descriptions
- Project architecture
- File-by-file explanation
- Workflow diagrams
- Validation rules
- Execution flow
- Best practices
- Common mistakes
- 35 Interview Questions
- Quick revision notes
- Cheat sheet
- Conclusion
- Next learning path

It is based on **Exercise 16 – Create mailregisterapp (React Forms Validation)** from the uploaded Week 5 ReactJS Hands-on Lab and is suitable for GitHub documentation, revision, and interview preparation. :contentReference[oaicite:6]{index=6}

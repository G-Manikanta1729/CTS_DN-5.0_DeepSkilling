# PL/SQL Exercises

## Overview

This repository contains the PL/SQL programming exercises completed as part of the **CTS DN 5.0 Deep Skilling Program**. The exercises are designed to develop practical knowledge of Oracle PL/SQL by implementing real-world banking scenarios.

The project covers important PL/SQL concepts such as control structures, stored procedures, functions, cursors, triggers, exception handling, packages, and transaction management.

---

## Technologies Used

* Oracle Database
* PL/SQL
* Oracle Live SQL
* Visual Studio Code
* Git & GitHub

---

## Project Structure

```text
PLSQL_Exercises/
│
├── Exercise_1_Control_Structures/
│   ├── README.md
│   ├── Scenario1_DiscountInterest.sql
│   ├── Scenario2_VIPCustomers.sql
│   └── Scenario3_LoanReminder.sql
│
├── Exercise_3_Stored_Procedures/
│   ├── README.md
│   ├── Scenario1_ProcessMonthlyInterest.sql
│   ├── Scenario2_UpdateEmployeeBonus.sql
│   └── Scenario3_TransferFunds.sql
│
├── Outputs/
│   ├── Exercise_1_Control_Structures/
│   └── Exercise_3_Stored_Procedures/
│
├── Schema.sql
├── SampleData.sql
└── README.md
```

---

## Exercises Completed

### Exercise 1: Control Structures

This exercise demonstrates the use of PL/SQL control structures to implement banking operations.

**Scenarios Implemented**

* Apply loan interest discounts for senior citizens.
* Promote eligible customers to VIP status.
* Generate reminders for loans due within the next 30 days.

**Concepts Covered**

* Anonymous PL/SQL Blocks
* FOR Loops
* IF-THEN Conditions
* UPDATE Statements
* DBMS_OUTPUT.PUT_LINE
* Transaction Management

---

### Exercise 3: Stored Procedures

This exercise focuses on creating reusable stored procedures for common banking operations.

**Scenarios Implemented**

* Process monthly interest for savings accounts.
* Update employee salaries using performance bonuses.
* Transfer funds securely between customer accounts.

**Concepts Covered**

* CREATE OR REPLACE PROCEDURE
* Input Parameters
* SELECT INTO
* UPDATE Statements
* IF-THEN Conditions
* COMMIT
* DBMS_OUTPUT.PUT_LINE

---

## Database Files

### Schema.sql

Contains all table creation scripts required for the exercises, including:

* Customers
* Accounts
* Transactions
* Loans
* Employees

### SampleData.sql

Contains sample records inserted into the database for testing all PL/SQL programs.

---

## Outputs

The **Outputs** folder contains screenshots captured before and after executing each scenario, demonstrating the successful execution of the PL/SQL programs.

---

## Learning Outcomes

After completing these exercises, the following concepts were understood and implemented:

* Writing anonymous PL/SQL blocks.
* Using control structures for decision-making.
* Creating reusable stored procedures.
* Passing parameters to procedures.
* Updating and retrieving database records.
* Implementing business logic using PL/SQL.
* Managing database transactions.
* Displaying execution results using DBMS_OUTPUT.
* Developing practical banking applications using Oracle PL/SQL.

---

## Conclusion

These exercises provide practical experience in Oracle PL/SQL by implementing real-world banking scenarios. The project demonstrates how PL/SQL can be used to automate business processes, maintain data consistency, and improve database programming through reusable and efficient database objects.

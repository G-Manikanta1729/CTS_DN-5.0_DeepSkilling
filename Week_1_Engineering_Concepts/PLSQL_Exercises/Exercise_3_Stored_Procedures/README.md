# Exercise 3: Stored Procedures

## Objective

The objective of this exercise is to understand and implement **Stored Procedures** in PL/SQL using real-world banking scenarios. Stored procedures allow frequently used database operations to be stored, reused, and executed efficiently with or without parameters.

---

## Technologies Used

* Oracle Database
* PL/SQL
* Oracle Live SQL

---

## Database Tables Used

* Accounts
* Employees

---

# Scenario 1: Process Monthly Interest

## Problem Statement

The bank needs to process monthly interest for all **Savings** accounts by applying **1% interest** to the current account balance.

## Tables Used

* Accounts

## Solution Explanation

A stored procedure named **ProcessMonthlyInterest** is created to automate the monthly interest calculation. The procedure updates the balance of every account whose **AccountType** is **Savings** by increasing the current balance by **1%**. The balances of all savings accounts are updated in a single execution while accounts of other types remain unchanged. After successfully updating the records, the transaction is committed and a confirmation message is displayed.

## Expected Output

* Every Savings account receives a 1% increase in its balance.
* Checking and other account types remain unchanged.

---

# Scenario 2: Update Employee Bonus

## Problem Statement

The bank wants to provide performance-based bonuses to employees working in a specific department.

## Tables Used

* Employees

## Solution Explanation

A stored procedure named **UpdateEmployeeBonus** is created with two input parameters: the department name and the bonus percentage. The procedure identifies all employees belonging to the specified department and updates their salary by adding the given percentage as a bonus. Employees from other departments remain unaffected. After updating the salaries, the transaction is committed and a confirmation message is displayed.

## Expected Output

* Employees belonging to the selected department receive the specified bonus.
* Employees from other departments remain unchanged.

---

# Scenario 3: Transfer Funds Between Accounts

## Problem Statement

Customers should be able to transfer funds from one account to another while ensuring that the source account has sufficient balance.

## Tables Used

* Accounts

## Solution Explanation

A stored procedure named **TransferFunds** is created with three input parameters: source account number, destination account number, and transfer amount. The procedure first retrieves the balance of the source account and verifies whether sufficient funds are available. If the balance is adequate, the specified amount is deducted from the source account and added to the destination account. Both updates are committed as a single transaction to ensure data consistency. If sufficient balance is not available, the transfer is cancelled and an appropriate message is displayed.

## Expected Output

* Funds are successfully transferred when the source account has sufficient balance.
* If the balance is insufficient, no changes are made to either account.

---

# Stored Procedure Concepts Used

* CREATE OR REPLACE PROCEDURE
* Input Parameters
* UPDATE Statement
* SELECT INTO Statement
* IF-THEN Condition
* Transaction Management
* COMMIT Statement
* DBMS_OUTPUT.PUT_LINE

---

# Learning Outcomes

After completing this exercise, the following concepts were understood and implemented:

* Creating reusable stored procedures in PL/SQL.
* Using input parameters to make procedures flexible and reusable.
* Updating database records through stored procedures.
* Retrieving values using the SELECT INTO statement.
* Applying conditional logic using IF-THEN statements.
* Managing transactions using the COMMIT statement.
* Displaying execution messages using DBMS_OUTPUT.PUT_LINE.
* Implementing real-world banking operations using stored procedures.
* Ensuring data consistency during financial transactions.

---

# Advantages of Stored Procedures

* Improves code reusability.
* Reduces code duplication.
* Enhances performance by executing compiled SQL.
* Simplifies database maintenance.
* Provides better security by restricting direct table access.
* Ensures consistent implementation of business logic.

---

# Conclusion

This exercise provided practical experience in developing and executing PL/SQL stored procedures using real-world banking scenarios. The implemented procedures automated monthly interest processing, employee bonus calculation, and secure fund transfers between accounts. Through these scenarios, a clear understanding of parameterized procedures, transaction management, conditional processing, and reusable database programming techniques was achieved.

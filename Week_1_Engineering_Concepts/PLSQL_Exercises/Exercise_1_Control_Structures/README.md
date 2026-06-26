# Exercise 1: Control Structures

## Objective

The objective of this exercise is to understand and implement **PL/SQL Control Structures** using real-world banking scenarios. The exercise demonstrates the use of **FOR loops**, **IF conditions**, **UPDATE statements**, and **DBMS_OUTPUT.PUT_LINE** to process records and perform conditional operations on database tables.

---

## Technologies Used

* Oracle Database
* PL/SQL
* Oracle Live SQL

---

## Database Tables Used

* **Customers**
* **Loans**

---

# Scenario 1: Apply Discount to Loan Interest Rate

### Problem Statement

The bank wants to provide a **1% discount on loan interest rates** for customers who are **above 60 years of age**.

### Tables Used

* Customers
* Loans

### Solution Explanation

* The program iterates through every customer using a **FOR loop**.
* For each customer, the age is calculated using the customer's **Date of Birth (DOB)**.
* If the customer's age is greater than **60 years**, the corresponding loan record is identified using the **CustomerID**.
* The loan interest rate is reduced by **1%**.
* A confirmation message is displayed using **DBMS_OUTPUT.PUT_LINE**.
* Finally, the changes are committed to the database.

### Expected Result

* Customers above 60 years receive a 1% reduction in their loan interest rate.
* Customers below or equal to 60 years remain unchanged.

### Execution Screenshots

##### Customers_Table

<img width="1105" height="611" alt="Customers_Table" src="https://github.com/user-attachments/assets/fc1dd67a-0623-4a1c-b1c0-5c8fbc0e6a9f" />

##### Loans_Table

<img width="1347" height="545" alt="Loans_Table" src="https://github.com/user-attachments/assets/e6e6aecb-9e8c-4907-96b6-a34e447de34f" />

##### Solution

<img width="807" height="621" alt="Solution" src="https://github.com/user-attachments/assets/a1079b69-3c29-479a-967d-21b77cc58d00" />

##### Output

<img width="802" height="797" alt="Output" src="https://github.com/user-attachments/assets/d174f9dd-f118-4392-8673-d772877a8b40" />

##### Loans_Table_After_Executing_PLSQL_Block

<img width="1381" height="606" alt="Loans_Table_After_Executing_PLSQL_Block" src="https://github.com/user-attachments/assets/9e6a983b-01be-4911-81f9-944c3eea5a96" />




---

# Scenario 2: Promote Customers to VIP Status

### Problem Statement

Customers having a balance greater than **$10,000** should be promoted to **VIP** status.

### Tables Used

* Customers

### Solution Explanation

* An **IsVIP** column is added to the **Customers** table.
* Initially, all customer records are assigned the value **FALSE**.
* The program iterates through every customer using a **FOR loop**.
* If a customer's balance is greater than **10000**, the **IsVIP** field is updated to **TRUE**.
* A confirmation message is displayed for every promoted customer.
* The updated records are committed to the database.

### Expected Result

* Customers with balances greater than **10000** are marked as **VIP**.
* All other customers continue to have the value **FALSE**.

---

# Scenario 3: Loan Due Reminder

### Problem Statement

The bank wants to identify all customers whose loans are due within the next **30 days** and send reminder messages.

### Tables Used

* Customers
* Loans

### Solution Explanation

* The program retrieves loan records whose **EndDate** falls within the next **30 days**.
* A **JOIN** operation is performed between the **Customers** and **Loans** tables to obtain customer names.
* A **FOR loop** iterates through all matching loan records.
* For each record, a reminder message containing the customer name, loan ID, and due date is displayed using **DBMS_OUTPUT.PUT_LINE**.
* Since this scenario only displays reminders, no database records are modified.

### Expected Result

* Reminder messages are displayed for every customer whose loan is due within the next 30 days.
* No changes are made to the database tables.

---

# PL/SQL Concepts Used

* Anonymous PL/SQL Blocks
* FOR Loop
* IF Statement
* Conditional Processing
* UPDATE Statement
* JOIN Operation
* DBMS_OUTPUT.PUT_LINE
* COMMIT Statement

---

# Learning Outcomes

After completing this exercise, the following PL/SQL concepts were understood and implemented:

* Creating and executing anonymous PL/SQL blocks.
* Using FOR loops to iterate through records.
* Applying IF conditions for decision-making.
* Updating records using the UPDATE statement.
* Displaying output using DBMS_OUTPUT.PUT_LINE.
* Performing conditional operations based on business rules.
* Working with multiple related tables using primary and foreign keys.
* Implementing practical banking scenarios using PL/SQL control structures.

---

## Conclusion

This exercise provides practical experience in implementing PL/SQL control structures through real-world banking applications. It demonstrates how loops, conditional statements, and database operations can be combined to automate business processes such as updating loan interest rates, promoting customers to VIP status, and generating loan reminder notifications.

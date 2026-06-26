INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

-- This is the data given in the document.

--For implementing the Ex_1_Scenario_1 I inserted some data that was below.

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (3, 'Robert Wilson', TO_DATE('1960-03-18', 'YYYY-MM-DD'), 18000, SYSDATE );

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (4, 'Mary Thomas', TO_DATE('1955-11-25', 'YYYY-MM-DD'), 22000, SYSDATE);
   
INSERT INTO Loans(LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES(2, 3, 100000, 8, SYSDATE, ADD_MONTHS(SYSDATE, 60 ));

INSERT INTO Loans(LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES(3, 4, 150000, 9, SYSDATE, ADD_MONTHS(SYSDATE, 48 ));

-- For implementing the Ex_1_Scenario_2 I done the below changes.

ALTER TABLE Customers ADD IsVIP VARCHAR2(5); --Added the IsVIP Column

UPDATE Customers SET IsVIP = 'FALSE'; -- Set the default value of IsVIP to FALSE for all existing customers
COMMIT;

-- For implementing the Ex_1_Scenario_3 I done the below changes.
--Since the existing loan records are due several years later, update two loans so they are due within the next 30 days.

UPDATE Loans SET EndDate = SYSDATE + 10 WHERE LoanID = 2; 

UPDATE Loans SET EndDate = SYSDATE + 25 WHERE LoanID = 3; 

COMMIT;

-- For implementing the Exercise 3 - Scenario 1: Process Monthly Interest I done the below changes.
-- Only one savings account exists.
--To properly demonstrate that the procedure processes all savings accounts, add one more savings account.

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) 
VALUES ( 3, 3, 'Savings', 5000, SYSDATE ); 
COMMIT;

-- For implementing the Exercise 3 - Scenario 2: Update Employee Bonus I done the below changes.
-- To better demonstrate the procedure, add another employee to the IT department.

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) 
VALUES ( 3, 'David Miller', 'Senior Developer', 80000, 'IT', TO_DATE('2018-04-15','YYYY-MM-DD') ); 
COMMIT;

-- No updations for Exercise 3 - Scenario 3: Transfer Funds



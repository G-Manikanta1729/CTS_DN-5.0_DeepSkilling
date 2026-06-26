# Exercise 7: Financial Forecasting

## Objective

The objective of this exercise is to implement **Financial Forecasting** using the **Recursion** technique. The program predicts the future value of an investment based on the principal amount, annual growth rate, and number of years.

---

## Problem Statement

Financial forecasting estimates the future value of an investment by applying a fixed annual growth rate over a specified number of years.

This implementation uses **Recursion** instead of iterative loops to calculate the forecasted value.

---

## Folder Structure

```
Exercise_7_Financial_Forecasting
│
├── ForecastCalculator.java
├── Main.java
└── README.md
```

---

## Classes Description

### ForecastCalculator.java

Implements the recursive forecasting algorithm.

**Responsibilities**

- Calculate the future investment value.
- Apply the annual growth rate recursively.
- Return the forecasted amount.

---

### Main.java

Driver class of the application.

**Responsibilities**

- Read user input.
- Create a `ForecastCalculator` object.
- Invoke the recursive forecasting method.
- Display the forecasted value.

---

## Algorithm

1. Read the principal amount.
2. Read the annual growth rate.
3. Read the number of years.
4. If the number of years is **0**, return the principal amount.
5. Otherwise:
   - Recursively calculate the value for `(years - 1)`.
   - Apply one year's growth to the returned value.
6. Display the forecasted investment value.

---

## Recursive Formula

```
Forecast(P, R, Y)

If Y == 0
    Return P

Else
    Return Forecast(P, R, Y - 1) × (1 + R / 100)
```

---

## Sample Input

```
Enter Principal Amount : 10000
Enter Annual Growth Rate (%) : 10
Enter Number of Years : 5
```

---

## Sample Output

```
Future Value after 5 years = 16105.10
```

---

## Executed Output

<img width="1482" height="281" alt="image" src="https://github.com/user-attachments/assets/39520c52-3072-44fd-8d4a-b706273cede9" />

---

## Dry Run

```
forecast(10000,10,5)

↓

forecast(10000,10,4)

↓

forecast(10000,10,3)

↓

forecast(10000,10,2)

↓

forecast(10000,10,1)

↓

forecast(10000,10,0)

↓

10000

↓

11000

↓

12100

↓

13310

↓

14641

↓

16105.10
```

---

## Time Complexity

| Complexity | Value |
|------------|-------|
| Time Complexity | O(n) |
| Space Complexity | O(n) |

where **n** is the number of years.

---

## Concepts Covered

- Java Classes and Objects
- User Input using Scanner
- Recursion
- Base Case
- Recursive Case
- Call Stack
- Time Complexity Analysis

---

## Learning Outcome

After completing this exercise, I learned:

- How recursion works.
- The importance of the base case in recursive functions.
- How recursive calls reduce a problem into smaller subproblems.
- How recursive functions use the call stack.
- How recursion can be applied to solve financial forecasting problems.

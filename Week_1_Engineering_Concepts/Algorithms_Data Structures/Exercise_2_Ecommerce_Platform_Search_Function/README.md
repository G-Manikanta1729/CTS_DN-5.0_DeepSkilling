# Exercise 2: E-Commerce Platform Search Function

## Objective

The objective of this exercise is to understand and implement searching algorithms used in an e-commerce platform. The program demonstrates both **Linear Search** and **Binary Search** to locate a product based on its name.

---

## Problem Statement

An e-commerce platform contains multiple products. When a customer searches for a product, the system should quickly locate and display the product details.

This exercise implements two searching techniques:

- Linear Search
- Binary Search

---

## Project Structure

```
Exercise_2_Ecommerce_Platform_Search_Function
│
├── LinearSearch
│   ├── Product.java
│   ├── SearchEngine.java
│   └── Main.java
│
└── BinarySearch
    ├── Product.java
    ├── SearchEngine.java
    └── Main.java
```

---

## Algorithms Implemented

### 1. Linear Search

- Searches each product one by one.
- Does not require the products to be sorted.
- Suitable for small datasets.

**Time Complexity**

| Case | Complexity |
|------|------------|
| Best Case | O(1) |
| Average Case | O(n) |
| Worst Case | O(n) |

---

### 2. Binary Search

- Searches the middle element first.
- Requires the products to be sorted before searching.
- Uses Bubble Sort to sort the products before performing Binary Search.
- More efficient for larger datasets.

**Time Complexity**

| Case | Complexity |
|------|------------|
| Best Case | O(1) |
| Average Case | O(log n) |
| Worst Case | O(log n) |

---

## Classes Used

### Product.java

Represents a product with the following attributes:

- Product ID
- Product Name
- Category

---

### SearchEngine.java

Contains the searching algorithms:

- Linear Search
- Bubble Sort
- Binary Search

---

### Main.java

- Creates product objects
- Accepts the search key
- Invokes the search algorithm
- Displays the result

---

## Sample Input

```
Enter Product Name:
Watch
```

---

## Sample Output

```
Product Found

Product ID : 104
Product Name : Watch
Category : Accessories
```

---

## Concepts Covered

- Object-Oriented Programming
- Arrays
- Linear Search
- Bubble Sort
- Binary Search
- Time Complexity Analysis

---

## Learning Outcome

After completing this exercise, I learned:

- How Linear Search works.
- How Binary Search works.
- Why Binary Search requires sorted data.
- How Bubble Sort can be used before Binary Search.
- The difference between O(n) and O(log n) search algorithms.

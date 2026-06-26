# Binary Search - E-Commerce Platform Search Function

## Objective

The objective of this implementation is to demonstrate the Binary Search algorithm for efficiently searching products in an e-commerce platform. Before performing the search, the products are sorted using the Bubble Sort algorithm, as Binary Search requires sorted data.

---

## Problem Statement

Given a collection of products, search for a product using its name. Since Binary Search works only on sorted data, the product array is first sorted alphabetically and then searched efficiently using the Binary Search algorithm.

---

## Folder Structure

```
BinarySearch
│
├── Product.java
├── SearchEngine.java
├── Main.java
└── README.md
```

---

## Classes Description

### Product.java

Represents a product in the e-commerce platform.

**Attributes**

- Product ID
- Product Name
- Category

**Responsibilities**

- Store product information.
- Provide getter methods.
- Display product details using the `toString()` method.

---

### SearchEngine.java

Implements both:

- Bubble Sort
- Binary Search

**Responsibilities**

- Sort the products alphabetically using Bubble Sort.
- Perform Binary Search on the sorted array.
- Return the matching product if found.
- Return `null` if the product is not found.

---

### Main.java

Driver class of the application.

**Responsibilities**

- Create product objects.
- Store products in an array.
- Accept the product name to search.
- Invoke the Binary Search method.
- Display the search result.

---

## Algorithm

### Step 1: Bubble Sort

1. Compare adjacent product names.
2. Swap the products if they are not in alphabetical order.
3. Repeat until the array is completely sorted.

### Step 2: Binary Search

1. Find the middle product.
2. Compare the middle product with the search key.
3. If they match, return the product.
4. If the search key is greater, search the right half.
5. If the search key is smaller, search the left half.
6. Repeat until the product is found or the search space becomes empty.

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

## Executed Output

<img width="1485" height="412" alt="image" src="https://github.com/user-attachments/assets/71a70594-03e9-4e56-aa4b-2d9c0489e2b9" />

---


## Time Complexity

### Bubble Sort

| Case | Complexity |
|------|------------|
| Best Case | O(n²) |
| Average Case | O(n²) |
| Worst Case | O(n²) |

### Binary Search

| Case | Complexity |
|------|------------|
| Best Case | O(1) |
| Average Case | O(log n) |
| Worst Case | O(log n) |

### Overall Complexity

Since the products are sorted before every search:

```
Bubble Sort : O(n²)
Binary Search : O(log n)

Overall : O(n²)
```

---

## Space Complexity

```
O(1)
```

---

## Advantages

- Faster searching compared to Linear Search for sorted data.
- Efficient for large datasets.
- Reduces the search space by half in every iteration.

---

## Limitations

- Requires the data to be sorted.
- Sorting introduces additional processing time.
- Bubble Sort is not efficient for very large datasets.

---

## Concepts Covered

- Java Classes and Objects
- Arrays
- Bubble Sort
- Binary Search
- Divide and Conquer
- Object-Oriented Programming (OOP)
- Time Complexity Analysis

---

## Learning Outcome

After completing this implementation, I learned:

- Why Binary Search requires sorted data.
- How Bubble Sort organizes data before searching.
- How Binary Search reduces the search space in every iteration.
- The difference between Linear Search and Binary Search.
- How to analyze the time and space complexity of searching algorithms.

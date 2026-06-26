# Linear Search - E-Commerce Platform Search Function

## Objective

The objective of this implementation is to demonstrate the Linear Search algorithm by searching for a product in an e-commerce platform.

---

## Problem Statement

Given a collection of products, search for a product using its name. The search is performed sequentially from the first product to the last product until a match is found.

---

## Folder Structure

```
LinearSearch
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

Implements the **Linear Search** algorithm.

**Responsibilities**

- Traverse the product array sequentially.
- Compare each product name with the search key.
- Return the matching product if found.
- Return `null` if the product does not exist.

---

### Main.java

Driver class of the application.

**Responsibilities**

- Create product objects.
- Store products in an array.
- Invoke the Linear Search method.
- Display the search result.

---

## Algorithm

1. Start from the first product.
2. Compare the product name with the search key.
3. If the names match, return the product.
4. Otherwise, continue to the next product.
5. If all products are checked and no match is found, return `null`.

---

## Sample Input

```
Search Product : Watch
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

<img width="1477" height="410" alt="image" src="https://github.com/user-attachments/assets/723f71d2-0796-4af6-827a-7b5da4ea3e63" />

---

## Time Complexity

| Case | Complexity |
|------|------------|
| Best Case | **O(1)** |
| Average Case | **O(n)** |
| Worst Case | **O(n)** |

---

## Space Complexity

```
O(1)
```

---

## Advantages

- Simple to implement.
- Works on both sorted and unsorted data.
- Suitable for small datasets.

---

## Limitations

- Inefficient for large datasets.
- Checks elements one by one.
- Slower than Binary Search for large collections.

---

## Concepts Covered

- Java Classes and Objects
- Arrays
- Encapsulation
- Object-Oriented Programming (OOP)
- Linear Search Algorithm
- Time Complexity Analysis

---

## Learning Outcome

After completing this implementation, I learned:

- How Linear Search works internally.
- How objects are stored in an array.
- How to search sequentially through an array.
- How to analyze the time complexity of Linear Search.
- How to organize Java programs using multiple classes.

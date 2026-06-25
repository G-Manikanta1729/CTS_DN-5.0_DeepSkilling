# Factory Design Pattern - Without Factory

## Overview

This example demonstrates the traditional way of creating objects **without using the Factory Design Pattern**.

The client (`Main.java`) directly creates objects of the required classes using the `new` keyword.

---

## Classes

- `DocumentProcessor` (Interface)
- `PDFProcessor`
- `WordProcessor`
- `ExcelProcessor`
- `Main`

---

## Implementation

The client directly creates the required objects.

```java
PDFProcessor pdf = new PDFProcessor();
WordProcessor word = new WordProcessor();
ExcelProcessor excel = new ExcelProcessor();
```

Each object is created manually inside the client.

---

## Problems

### 1. Tight Coupling

The client knows every implementation class.

```
Main
 ├── PDFProcessor
 ├── WordProcessor
 └── ExcelProcessor
```

If any implementation class changes, the client may also need to change.

---

### 2. Client Handles Object Creation

The client is responsible for deciding:

- Which object to create
- When to create it
- How to create it

This violates the principle of separating responsibilities.

---

### 3. Difficult to Extend

Suppose a new processor is added:

```
PowerPointProcessor
```

The client must be modified.

```java
PowerPointProcessor ppt = new PowerPointProcessor();
```

Every place where objects are created must also be updated.

---

### 4. Poor Maintainability

If object creation becomes more complex (configuration, validation, dependency injection, etc.), the same logic must be written in multiple places.

This results in duplicated code and makes maintenance difficult.

---

## Output

```
Processing PDF Document
Processing Word Document
Processing Excel Document
```

<img width="1486" height="220" alt="image" src="https://github.com/user-attachments/assets/467facdc-2bb8-4ab2-b5c8-9cd016aaef09" />


---

## Conclusion

Although the application works correctly, the design is not scalable because the client is tightly coupled with the implementation classes and is responsible for object creation.

This problem is solved using the **Factory Design Pattern**, where a separate Factory class handles object creation and the client simply requests the required object.

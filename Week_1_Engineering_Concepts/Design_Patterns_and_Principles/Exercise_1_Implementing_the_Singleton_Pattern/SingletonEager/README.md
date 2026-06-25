# Singleton Pattern - Eager Initialization

## Purpose

Ensure that only one object of VisitorCounter exists.

## Key Points

- Constructor is private.
- Object is created immediately when the class loads.
- Access is provided through getInstance().

## Observation

counter1 == counter2

Result: true

Both variables point to the same object.

## Drawback

Object is created even if it is never used.

This leads to unnecessary memory usage.

## Output

<img width="1482" height="275" alt="image" src="https://github.com/user-attachments/assets/da5f5ad6-8a57-4f19-ae31-f1681a1b7e14" />

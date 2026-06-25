# Without Singleton

## Purpose

This example demonstrates a normal Java class where multiple objects can be created.

## Observation

VisitorCounter counter1 = new VisitorCounter();

VisitorCounter counter2 = new VisitorCounter();

Result:

- Two different objects are created.
- Each object maintains its own visitor count.
- No sharing of data between objects.

## Output

Counter1 Visitors: 2

Counter2 Visitors: 1

<img width="1487" height="223" alt="image" src="https://github.com/user-attachments/assets/86be80d8-f0ec-42a2-82ef-02b3da2b6f90" />


Conclusion:
Multiple instances exist, therefore this is NOT a Singleton.


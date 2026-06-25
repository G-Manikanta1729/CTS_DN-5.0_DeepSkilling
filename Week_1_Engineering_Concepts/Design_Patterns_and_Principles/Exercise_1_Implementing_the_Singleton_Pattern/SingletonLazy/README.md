# Singleton Pattern - Lazy Initialization

## Purpose

Create the object only when it is required.

## Key Idea

Initially:

instance = null

When getInstance() is called for the first time:

instance = new VisitorCounter();

After that:

The same object is returned every time.

## Benefit

Memory is not used until the object is actually needed.

## Observation

counter1 == counter2

Result: true

Only one object exists.

## Output

<img width="1487" height="292" alt="image" src="https://github.com/user-attachments/assets/68381a27-984d-4f61-afbf-404aef1f6b04" />

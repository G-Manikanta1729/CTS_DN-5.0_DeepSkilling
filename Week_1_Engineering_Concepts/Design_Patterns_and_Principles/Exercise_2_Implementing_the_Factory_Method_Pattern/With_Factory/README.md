# Factory Pattern - Document Processor

## Purpose

The Factory Pattern centralizes object creation.

## Problem

Without a factory, the client creates objects directly:

new PDFProcessor();
new WordProcessor();
new ExcelProcessor();

This leads to tight coupling.

## Solution

The client requests an object from the factory:

DocumentFactory.getProcessor("PDF");

The factory decides which object to create and returns it.

## Benefits

- Hides object creation logic
- Reduces coupling
- Easier to maintain
- Easier to extend

## Output

<img width="1485" height="215" alt="image" src="https://github.com/user-attachments/assets/8c7be4f6-4d27-47ff-b5b2-dc70255e732c" />

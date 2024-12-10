# Ex1 - Foundations of Functional Programming & Testing

## Overview

In this assignment, I worked on using functional programming concepts to handle strings, arrays, and basic math. I built a program that converts numbers in different bases (like binary or hexadecimal) and performs calculations on them. The goal was to make sure everything works correctly, write clean code, and test it thoroughly.
---

## Problem Description

I built a number converter and calculator that handles strings representing numbers in different bases (from binary to hexadecimal). The format is `<number><b><base>`, where:
- `<number>` is a string of digits.
- `<b>` separates the number from the base.
- `<base>` represents the base, ranging from 2 to 16.

### Input Format:
- Example: `"135bA"` (base 10), `"100111b2"` (binary).
- Invalid inputs: `"b2"`, `"0b1"`, `"123b"`, etc.

### Example Outputs:

1. **Input**:
   ```
   1
   0
   10
   ```
   **Output**:
   ```
   1 + 0 = 1
   1 * 0 = 0
   Max number over [1, 0, 1, 0] is: 1
   ```

2. **Input**:
   ```
   1001b2
   11b3
   10
   ```
   **Output**:
   ```
   1001b2 + 11b3 = 13
   1001b2 * 11b3 = 36
   Max number over [1001b2, 11b3, 13, 36] is: 36
   ```

### Error Handling:
For invalid inputs, the program displays an error message such as:
```
ERR: num1 is in the wrong format! (1b)
```

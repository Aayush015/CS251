# Postfix Calculator

## Overview

This project implements a Postfix Calculator that evaluates expressions in postfix notation. The calculator supports standard arithmetic operations such as addition, subtraction, multiplication, division, and the ability to print the result.

### Author Information

- **Name:** Aayush Kafle
- **Class:** CS-251L-005 (Spring 2022)
- **Email:** akafle1@unm.edu
- **Date Submitted:** 03/25/2022

## Features

- Supports operations using both operator symbols (`+`, `-`, `*`, `/`) and their corresponding textual representations (`add`, `sub`, `mult`, `div`).
- Utilizes a stack-based approach to evaluate postfix expressions.
- Implements basic arithmetic operations:
    - Addition (`+` or `add`)
    - Subtraction (`-` or `sub`)
    - Multiplication (`*` or `mult`)
    - Division (`/` or `div`)
    - Print (`=` or `print`) to display the top value of the stack.

### How It Works

1. **Operands:** When the calculator encounters a number, it pushes it onto the operand stack.
2. **Operators:** When the calculator encounters an operator, it pops the necessary number of operands from the stack, performs the corresponding operation, and pushes the result back onto the stack.
3. **Print Command:** The print operation (`=` or `print`) outputs the top value of the stack.

### Example

Given the input: 

5 1 2 + 4 * + 3 - =
=


The Postfix Calculator evaluates the expression as:

(1 + 2) * 4 + 5 - 3 = 14
=


### Class Descriptions

#### `CalcTest`
- **Purpose:** Acts as the main driver class for the Postfix Calculator. It reads tokens from standard input and directs operands and operators to the `PostfixCalculator` for evaluation.
- **Main Functionality:**
    - Reads numbers and operators using a `Scanner`.
    - Sends numbers to the calculator's stack via the `storeOperand` method.
    - Sends operators to be evaluated by the `evalOperator` method.

#### `PostfixCalculator`
- **Purpose:** Contains the core logic for evaluating postfix expressions.
- **Features:**
    - Uses a stack (`DoubleStack`) to store operands.
    - Maps operator symbols and keywords to their corresponding operations using an operator map (`operatorMap`).
    - Supports arithmetic operations like addition, subtraction, multiplication, and division.
    - Outputs the result using the print (`=` or `print`) operator.

## Usage Instructions

1. **Run the program:**
   The calculator reads postfix expressions from standard input and evaluates them as they are entered.

2. **Operands and Operators:**
    - Enter numbers directly (e.g., `5`, `10.5`).
    - Use the following operators:
        - Addition: `+` or `add`
        - Subtraction: `-` or `sub`
        - Multiplication: `*` or `mult`
        - Division: `/` or `div`
        - Print: `=` or `print`
# FizzBuzz Lab

**Author:** Aayush Kafle  
**Class:** CS-251L-005 (Spring 2022)  
**Date Submitted:** 01/31/2022

## Description

This program is a command-line implementation of the classic FizzBuzz problem. It takes three integer inputs via command line arguments:

1. **First Argument:** Divisor for "Fizz".
2. **Second Argument:** Divisor for "Buzz".
3. **Third Argument:** Upper limit for the sequence.

The program prints the numbers from 1 to the specified upper limit, substituting "Fizz" for multiples of the first argument, "Buzz" for multiples of the second argument, and "FizzBuzz" for numbers that are multiples of both.

### Error Handling

- The program requires exactly three command line arguments. If fewer or more arguments are provided, an error message will be displayed.

## Usage

To run the program, compile it using `javac` and then execute it with three integer arguments:

```bash
javac FizzBuzz.java
java FizzBuzz 3 5 15
```
## Example Output
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz

# Line Sorter

## Description

The Line Sorter program reads lines from a text file, sorts them by length (from shortest to longest), and then by reverse alphabetical order if their lengths are equal. The sorted lines are written to an output file. This program is a part of LAB 6 for the CS-251L-005 course (Spring 2022).

## Features

- Reads lines from an input file.
- Sorts lines first by length (ascending).
- If lines have equal length, sorts them in reverse alphabetical order.
- Writes the sorted lines to an output file.

## Requirements

- Java 8 or higher
- A text editor or IDE (e.g., IntelliJ IDEA) for running the code

## Usage

1. **Compile the Program:**

   Make sure you have the Java Development Kit (JDK) installed. Open a terminal or command prompt and navigate to the directory containing `LineSorter.java`. Compile the program using:

   ```bash
   javac LineSorter.java
    ```

### Run the Program
java LineSorter src/input.txt src/output.txt

### Example Input
apple<br>
banana<br>
cherry<br>
date<br>
n<br>

### Example Output
n<br>
date<br>
apple<br>
banana<br>
cherry<br>

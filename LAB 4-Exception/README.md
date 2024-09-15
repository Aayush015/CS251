# Banking Application

## Overview

This project is a simple banking application implemented in Java. It simulates basic banking operations such as depositing and withdrawing money from a bank account. The application demonstrates exception handling for invalid transactions and maintains separate balances for different accounts.

## Components

### BankAccount.java

This class represents a bank account with functionalities to deposit and withdraw money. It ensures that invalid transactions (such as negative amounts) are handled appropriately.

- **Fields:**
    - `ACCOUNT_NUMBER`: A unique identifier for the account (immutable).
    - `balance`: The current balance of the account.

- **Methods:**
    - `BankAccount(int ACCOUNT_NUMBER)`: Constructor to initialize the account with a given number.
    - `int getAccountNumber()`: Returns the account number.
    - `double getBalance()`: Returns the current balance.
    - `void deposit(double amount)`: Adds money to the account. Throws `IllegalArgumentException` if the amount is negative.
    - `void withdraw(double money) throws InsufficientFundsException`: Subtracts money from the account. Throws `IllegalArgumentException` if the withdrawal amount is negative and `InsufficientFundsException` if there are insufficient funds.

### InsufficientFundsException.java

A custom exception class used when a withdrawal exceeds the available balance.

- **Fields:**
    - `shortfall`: The amount by which the withdrawal exceeds the balance.

- **Methods:**
    - `double getShortfall()`: Returns the shortfall amount.

### BankingTest.java

This class contains the `main` method to test the functionalities of `BankAccount`. It performs various banking operations and handles exceptions.

- **Methods:**
    - `static void printBalance(BankAccount b)`: Prints the account number and balance formatted to two decimal places.
    - `public static void main(String[] args)`: Entry point of the application that performs deposit and withdrawal operations, handles exceptions, and verifies account balances.

## Usage

1. **Compile the Program:**

   Ensure that all `.java` files are in the same directory and use the Java compiler to compile the files:
   ```bash
   javac BankAccount.java InsufficientFundsException.java BankingTest.java

## Example Outputs: 
Account 101 balance = $1000.00 <br>
Withdraw payment 1 of $19.95<br>
Account 101 balance = $980.05<br>
Withdraw payment 2 of $19.95<br>
Account 101 balance = $960.10<br>
Withdraw payment 3 of $19.95<br>
Account 101 balance = $940.15<br>
Finished payments<br>
Account 101 balance = $940.15<br>
Done banking for now<br>
Account 101 balance = $940.15<br>

### With different initial balance: 
Account 101 balance = $50.00<br>
Withdraw payment 1 of $19.95<br>
Account 101 balance = $30.05<br>
Withdraw payment 2 of $19.95<br>
Account 101 balance = $10.10<br>
Withdraw payment 3 of $19.95<br>
Sorry, but you are short $9.85<br>
Done banking for now<br>
Account 101 balance = $10.10<br>
InsufficientFundsException: You need more money!<br>
at BankAccount.withdraw(BankAccount.java:89)<br>
at BankingTest.main(BankingTest.java:52)<br>

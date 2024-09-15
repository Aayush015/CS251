/**
 * LAB 4 : Exceptions
 *
 * Name: Aayush Kafle
 * Class: CS-251L-005 (Spring 2022)
 * Email: akafle1@unm.edu
 * Date Submitted: 03/04/2022
 *
 * Brief explanation of the class:
 * This class contains all the methods used in BankingTest.java. The deposit
 * and withdraw method are defined here, which checks for illegal argument in
 * program. Also, the balance is accordingly updated as the customer withdraws
 * or deposits the money into the account.
 */


public class BankAccount
{
    private final int ACCOUNT_NUMBER;
    private double balance = 0;

    /**
     * Gets account number for a bank account and assigns it to ACCOUNT_NUMBER
     * @param ACCOUNT_NUMBER the account number
     */
    public BankAccount(int ACCOUNT_NUMBER)
    {
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
    }

    /**
     * Returns the account number by this method
     * @return
     */
    public final int getAccountNumber()
    {
        return ACCOUNT_NUMBER;
    }

    /**
     * The method returns the balance
     * @return
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * The method adds the deposit amount to the current balance.Also checks if
     * the amount is negative. If so, then it throws IllegalArgumentException
     * @param amount
     */
    public void deposit(double amount)
    {
        if (amount < 0)
        {
            // throws error if the customer tries to deposit negative amount
            throw new IllegalArgumentException("attempted to deposit negative" +
                    " amount: " + amount);
        }
        else
        {
            balance = amount + balance;
        }
    }

    /**
     * The method subtracts the withdrawn amount from the current balance.
     * Also chekcs for negative withdraw amount and throws
     * IllegalArgumentException. Also, if the withdraw amount is greater than
     * current balance, it throws InsufficientFundsException and shows the
     * amount by which the balance shorts the withdraw amount.
     * @param money
     * @throws InsufficientFundsException
     */
    public void withdraw(double money) throws InsufficientFundsException
    {
            if (money < 0)
            {
                // throws error if the customer tries to withdraw negative amount
                throw new IllegalArgumentException("attempted to withdraw " +
                        "negative amount: " + money);
            }

            else if (money > balance)
            {
                // calls InsufficientFundsException class and prints shortfall
                throw new InsufficientFundsException(money - balance);
            }

            balance = balance - money;
    }
}

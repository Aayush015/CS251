/**
 * LAB 4 : Exceptions
 *
 * Name: Aayush Kafle
 * Class: CS-251L-005 (Spring 2022)
 * Email: akafle1@unm.edu
 * Date Submitted: 03/04/2022
 *
 * Brief explanation of the class:
 * This class throws exception into BankAccount class if the customer tries to
 * withdraw amount more than their current balance.This class extends Exception
 * and return shortfall amount in getShortfall() method.
 */

public class InsufficientFundsException extends Exception
{
    private final double SHORTFALL;

    /**
     * Takes shortfall amount as a double and warns customer that they need
     * more money for withdrawing.
     * @param SHORTFALL
     */
    public InsufficientFundsException(double SHORTFALL)
    {
        super("You need more money!");
        this.SHORTFALL = SHORTFALL;
    }

    /**
     * The method returns shortfall amount
     * @return
     */
    public double getShortfall()
    {
        return SHORTFALL;
    }
}

/**
 * LAB 1
 *
 * Name: Aayush Kafle
 * Class: CS-251L-005 (Spring 2022)
 * Email: akafle1@unm.edu
 * Date Submitted: 01/31/2022
 *
 * Brief explanation of the program:
 * This program takes the values from the command line argument and provides Fizz, Buzz, or FizzBuzz for the multiple
 * of first command line argument to third, second comand line argument to third, or both to third within the limit of the third command line argument.
 * Whenever the command line argument is not equal to 3, it prints out an error, showing that 3 additional numbers should be
 * provided with the command line.
 *
 */

import javax.sound.midi.Soundbank;

public class FizzBuzz
{
    public static void main(String[] args)
    {
        if (args.length != 3) // shows error when command line is not equal to
            // 3 .i.e three additional numbers should be provided.
        {
            System.err.println("Please give 2 argument with numbers, but you" +
                    " gave " + args.length);
        }

        else
        {
            // storing first command line number in first_num
            int first_num = Integer.parseInt(args[0]);
            // same for second command line number
            int second_num = Integer.parseInt(args[1]);
            // the maximum limit .i.e. third command line argument
            int max_limit = Integer.parseInt(args[2]);

            // looping through 1 to the max_limit
            for (int i=1; i<=max_limit; i++)
            {
                // When both are the multiple of max_limit
                if (i % first_num == 0 && i % second_num == 0)
                {
                    System.out.println("FizzBuzz");
                }
                // When the first command line number is the multiple of max_limit
                else if (i % first_num == 0)
                {
                    System.out.println("Fizz");
                }
                // When the second command line number is the multiple of max_limit
                else if(i % second_num == 0)
                {
                    System.out.println("Buzz");
                }
                else
                {
                    System.out.println(i); // or else printing the numbers
                }
            }
        }
    }
}

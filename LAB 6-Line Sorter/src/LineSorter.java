/**
 * LAB 6 : Line Sorter
 *
 * Name: Aayush Kafle
 * Class: CS-251L-005 (Spring 2022)
 * Email: akafle1@unm.edu
 * Date Submitted: 04/06/2022
 *
 * Brief explanation of the program:
 * This program sorts the lines from the shortest length to the longest from
 * the file it gets from the command line arguments. It takes the first command
 * line argument as the input file and the second one as the output. If any
 * line's length is equal, then it sorts that line according to reverse
 * alphabetical order. Then it writes the result in the second command
 * line argument file.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LineSorter {
    public static void main(String[] args) throws IOException {

            // Creating a buffer file to reader the file from command line
            BufferedReader readerFile = new BufferedReader(new
                    FileReader(args[0]));

            // Creating a bufferedwrtier to writer the output
            BufferedWriter outputFile = new BufferedWriter(new
                    FileWriter(args[1]));

            String line;
            // Array to write the given strings in the file
            ArrayList<String> str = new ArrayList<>();

            // Adding each line of the input into the str array
            while ((line = readerFile.readLine()) != null) {
                str.add(line);
            }
            readerFile.close();

        /**
         * Method to compare the length of the strings if they are equal
         */
        Comparator<String> byLength = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            };

            for (int i=0; i<str.size()-1; i++)
            {
                int length = str.get(i).length();
                //If length of one line is equal to the next one reverse order
                if (length == str.get(i+1).length()){
                    Collections.sort(str, Collections.reverseOrder());

                }
                // Also sort them by length
                Collections.sort(str, byLength);
            }

        /**
         * For each of the string write the output file even for the exception
         */
        for (String s: str){
                try
                {
                    if (s.charAt(0) != '#')
                    {
                        outputFile.write(s + "\n");
                    }
                }
                catch (StringIndexOutOfBoundsException name){
                    outputFile.write(s + "\n");
                }
            }
            // Closing the output file after we are done using it
            outputFile.close();
    }
}
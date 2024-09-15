/**
 * LAB 7 : Evil Hangman
 *
 * Name: Aayush Kafle
 * Class: CS-251L-005 (Spring 2022)
 * Email: akafle1@unm.edu
 * Date Submitted: 04/18/2022
 *
 * Brief explanation of the class:
 * This class implements HangmanInterface. All the methods in HangmanInterface
 * are defined in this class. These methods are used in Hangman and HangmanGUI
 * to play the hangman game. In this class, first the file is opened. Then all
 * the methods used in Hangman is defined in this class.
 *
 * This is FairHangman game, where a particular secret word is chosen at the
 * first and kept constant throughout the game, unlike EvilHangman. Certain
 * number of blanks are printed as the length of the secret word. If the player
 * makes all the guesses correct and finds the secret word, he wins the game.
 * Otherwise, he will run out of guesses and lose.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This class contains the implementation of Fair Hangman.
 */
public class FairHangman implements HangmanInterface {
    protected int guess;
    protected ArrayList<Character> guessed_Letters = new ArrayList<>();
    protected String secretWord;
    protected ArrayList<String> words = new ArrayList<>();

    /**
     * This is the FairHangman constructor where we open the file provided at
     * command line argument which contains the dictionary. All the lines in
     * the file is added to words which is an ArrayList of Strings. Try catch
     * is used for proper error handling.
     *
     * @param dictionaryFile command line argument containing the
     *                       dictionary file
     */
    public FairHangman(String dictionaryFile) {

        BufferedReader reader_file = null;
        try {
            reader_file = new BufferedReader(new FileReader(dictionaryFile));

            String newLine = null;
            while((newLine = reader_file.readLine()) !=null){
                words.add(newLine);
            }
            reader_file.close();
        } catch (IOException e) {
            System.out.println("The input file is not correct!");
        }
    }

    /**
     * This method intializes the game. It resets all the bookeepings. The
     * number of guesses and guessed letters is reset. Player decides the
     * number of guesses. Also, a random letter is taken as the secret word
     * which is consistent throughout the game.
     * @param guesses Number of guesses for game.
     */
    @Override
    public void initGame(int guesses) {
        this.guess = guesses;
        guessed_Letters.removeAll(guessed_Letters);
        Collections.shuffle(words);
        secretWord = words.get(0);
    }

    /**
     * This method returns the number of guesses left which is updated
     * throughout the game from updateWithGuess method.
     * @return guess left(Integer)
     */
    @Override
    public int getGuessesRemaining() {
        return guess;
    }

    /**
     * It returns the list of guessed letters which is added throughtout the
     * game in updateWithGuess method.
     * @return (Arraylist of Characters)
     */
    @Override
    public Collection<Character> getGuessedLetters() {
        return guessed_Letters;
    }

    /**
     * It updates the blanks to letters if the user guessed the correct letter
     * from the secret word. If the guessed word is not correct then it returns
     * BLANK.
     * @return (String)
     */
    @Override
    public String getPuzzle() {
        String final_word = "";
        for (int i=0; i<secretWord.length(); i++)
        {
            if (guessed_Letters.contains(secretWord.charAt(i))){
                final_word += secretWord.charAt(i);
            }
            else {
                final_word += BLANK;
            }
        }
        return final_word;
    }

    /**
     * It returns the secret word which is defined at initGame method, which
     * is a random word from the dictionary file.
     * @return (returns String)
     */
    @Override
    public String getSecretWord() {
        return secretWord;
    }

    /**
     * It checks whether the total guessed letters is complete.
     * If the every letters in secret word is guessed then the game is complete
     * @return (returns boolean)
     */
    @Override
    public boolean isComplete() {
        Boolean complete = true;
        for(int i =0; i<secretWord.length();i++){
            if (!guessed_Letters.contains(secretWord.charAt(i)))
            {
                complete = false;
                break;
            }
        }
        return complete;
    }

    /**
     * Checks if the game is over. The game is over only if the guess remaining
     * is 0 or the game is already completed.
     * @return (return Boolean)
     */
    @Override
    public boolean isGameOver() {
        if(guess == 0 || isComplete()){
            return true;
        }
        else
            return false;
    }

    /**
     * Updates the guessed letters if the input letter is in secret word.
     * If the letter is not in the secret word then it decreases the guess
     * remaining by 1. Also, checks if the guessed letter has already been
     * guessed.
     * @param letter The guessed letter.
     * @return
     */
    @Override
    public boolean updateWithGuess(char letter) {
        if (guessed_Letters.contains(letter))
        {
            System.out.println("You have already guessed this letter. Try a  " +
                    "different one");
            return false;
        }
        else {
            guessed_Letters.add(letter);
            if (secretWord.contains("" + letter)){
                return true;
            }
            else {
                guess--;       // If the secret word doesn't contain the letter
                return false;
            }
        }

    }
}

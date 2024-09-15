/**
 * LAB 7 : Evil Hangman
 *
 * Name: Aayush Kafle
 * Class: CS-251L-005 (Spring 2022)
 * Email: akafle1@unm.edu
 * Date Submitted: 04/18/2022
 *
 * Brief explanation of the class:
 * This class extends FairHangman since the basic implementation on both of
 * the classes are same. Only the methods needed to re-write for evil hangman
 * has been Over-ridden here.
 * Unlike FairHangman, this class constantly updates the secret word from the
 * dictionary. It chooses the word with the largest set of dictionary in order
 * to nudge user towards being wrong. The main objective of EvilHangman is to
 * make sure the user fails. If both the words have same letter, then it picks
 * the one with the highest length.
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EvilHangman extends FairHangman {

    private ArrayList<String> filtered_words = new ArrayList<>();
    private ArrayList<String> new_filtered_words = new ArrayList<>();

    /**
     * It imports the constructor used in FairHangman by calling with super
     * @param dictionaryFile (file from the command line argument)
     */
    public EvilHangman(String dictionaryFile) {
        super(dictionaryFile);
    }

    /**
     * Intializes game, updating all the bookeepings. Set the guess remaining
     * according to the one set by the user. Removes all previous arraylists.
     * Also, sets a  random word from the dictionary for now, which will be
     * updated in updateWithGuess method.
     * @param guesses Number of guesses for game.
     */
    @Override
    public void initGame(int guesses) {
        this.guess = guesses;
        guessed_Letters.removeAll(guessed_Letters);

        // Setting a random secret word at first
        Collections.shuffle(words);
        String random_secretWord = words.get(0);

        // To print out blanks in terminal at first
        this.secretWord = "";
        for(int i = 0; i < random_secretWord.length(); i++){
            secretWord += BLANK;
        }

        // Keeping all the words of same length into filtered_word arraylist
        // Since it is to be used by getSecretWord() method, it has to be
        // called here.
        for(int i = 0; i < words.size(); i++){
            if(words.get(i).length() == random_secretWord.length()){
                filtered_words.add(words.get(i));
            }
        }
    }

    /**
     *  Shuffling the words of same length to get a random secret word
     * @return (returns String)
     */
    @Override
    public String getSecretWord(){
        Collections.shuffle(filtered_words);
        return filtered_words.get(0);
    }

    /**
     * This is where the cheating happens. For a large set of words, the
     * words that contain the letter guessed by user is excluded. It is kept
     * in filtered_words and again the length of the words are compared
     * and the word with the greatest length is used as the new secret word.
     * In short, the secret word is constantly updated according to the user's
     * guess with the objective to fail the user.
     * @param letter The guessed letter.
     * @return
     */
    @Override
    public boolean updateWithGuess (char letter){
        // Checks if the letter guessed has already been guessed
        if(guessed_Letters.contains(letter)){
            System.out.println("You already guessed this letter, try again");
            return false;

        } else {
            guessed_Letters.add(letter);

            // Maps the new word list and filtered word list for the words
            // containing the guessed letters.
            Map<String, ArrayList<String>> map = new HashMap<>();

            // Looping through the words of same length
            for(String s : filtered_words){
                String final_word = "";

                for(int i = 0; i < s.length(); i++){
                    // if the guessed letter is in one of the words in filtered
                    if(letter == s.charAt(i)){
                        // add that in the final word
                        final_word += s.charAt(i);
                    } else {
                        // otherwise don't add it instead used secretWord defined
                        // above.
                        final_word += secretWord.charAt(i);
                    }
                }

                // Arraylist to store the words containing the guessed letters
                ArrayList<String> random_arraylist = map.get(final_word);

                // If that arraylist is empty then put that word
                // and arraylist in map
                if(random_arraylist == null){
                    random_arraylist = new ArrayList<>();
                    map.put(final_word, random_arraylist);
                }

                // Now add that strings in the array list having guessed letters
                random_arraylist.add(s);
            }

            /**
             * Now we are finalising the arraylist of final words from the list
             * of words that contain the guessed letters.
             */

            String newWord = "";
            int longestSize = 0;

            // Looping through each item in the map of guessed letter
            for(Map.Entry<String, ArrayList<String>> entry :
                    map.entrySet()){

                // Take word in that particular map and keep its length in length
                String potential_word = entry.getKey();
                int length = entry.getValue().size();

                // Assigning an arraylist for that particular map
                ArrayList<String> final_filteredWords = entry.getValue();

                // If the length of any map is greater than each other update the
                // new_filtered_word
                if (length > longestSize){
                    longestSize = length;
                    newWord = potential_word;
                    new_filtered_words =  final_filteredWords;
                }
            }

            // Updating the final arraylist after all the checks
            filtered_words = new_filtered_words;

            // If the randomly set secretWord is equal to the new one after the
            // checks then subtract one guess.
            if(secretWord.equals(newWord)){
                guess--;
                return false;
            } else {
                secretWord = newWord;
                return true;
            }
        }
    }
}
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

/**
 * LAB 9: Snake Game: Part 1 - Game Manager
 *
 * Name: Aayush Kafle
 * Class: CS-251L-005 (Spring 2022)
 * Email: akafle1@unm.edu
 * Date Submitted: 04/29/2022
 *
 * Description of the class:
 * Implementing the methods defined in GameManager to play the game.
 */
public class GameManagerTester{
    /**
     * Testing the methods and constructor from GameManager.
     * @param args null
     */
    public static void main(String [] args) {
        int left = 0;
        int up = 1;
        int down = 2;
        int right = 3;


        // Creating game 1
        GameManager game_1 = new GameManager("maze_2.txt");
        System.out.println("Printing the first maze");
        game_1.toString();
        game_1.move(left);
        for (int i = 0; i < 3; i++) {
            game_1.move(up);
            game_1.move(right);
        }

//        // Creating game 2
//        GameManager game_2 = new GameManager("maze_3.txt");
//        System.out.println("\n");
//        System.out.println("\n");
//        System.out.println("Creating a different board");
//        game_2.toString();
//        game_2.move(right);
//        game_2.move(down);
//        game_2.move(down);
//        game_2.move(down);
//        game_2.move(left);
//        game_1.move(left);

    }
}
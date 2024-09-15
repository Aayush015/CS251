
/**
 * LAB 9: Snake Game: Part 1 - Game Manager
 *
 * Name: Aayush Kafle
 * Class: CS-251L-005 (Spring 2022)
 * Email: akafle1@unm.edu
 * Date Submitted: 04/29/2022
 *
 * Description of the class:
 * This class keeps track of the direction of the snake. Initially, a snake
 * of length 3 is created which increases as the snake eats the food. This
 * class moves the snake in a particular direction and prints out the direction
 * in which it has moved.
 */
import java.util.ArrayList;

public class Snake {
    protected int x;
    protected int y;
    protected int length=3;
    protected int direction;
    protected ArrayList<Wall> tail = new ArrayList<>();

    /**
     * Constructor for the snake
     * @param x is the starting x position of the snake
     * @param y is the starting y position of the snake
     * @param d is the direction of the snake
     */
    public Snake(int x,int y,int d) {
        this.x=x;
        this.y=y;
        this.direction=d;
    }
    /**
     * Moves the snake by 1 step in its direction
     * @returns a string when snake moves
     */
    public String move(int d) {
        this.tail.add(0,new Wall(x,y));//adds tail
        if (d == 0){
            this.y--;
        }
        if (d == 1){
            this.x--;
        }
        if (d == 2){
            this.x++;
        }
        if (d == 3){
            this.y++;
        }
        if(this.tail.size()>this.length) {
            this.tail.remove(this.tail.size()-1);//trims tail to length
        }
        return "Moved";
    }
    /**
     * Change the snakes direction
     * @param d the direction to change(0=up,1=left,2=right,3=down)
     * @return string describing the change
     */
    public String direction(int d) {
        this.direction=d;
        String s="";
        if (d == 0){
            s = "left";
        }
        if (d == 1){
            s = "up";
        }
        if (d == 2){
            s = "down";
        }
        if (d == 3){
            s = "right";
        }
        return "Snake changed direction to " + s;
    }
}
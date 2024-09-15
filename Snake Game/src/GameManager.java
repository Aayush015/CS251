/**
 * LAB 9: Snake Game: Part 1 - Game Manager
 *
 * Name: Aayush Kafle
 * Class: CS-251L-005 (Spring 2022)
 * Email: akafle1@unm.edu
 * Date Submitted: 04/29/2022
 *
 * Description of the class:
 * This class incorporates all the bookkeeping and updates them as per the
 * positions. First, the input file is read, determining if the file contains
 * two integer value or four integer value. Then, food and snake are created
 * randomly without touching the walls. Also, board is created, position of
 * snake and food is updated. The programs that the snake collied either
 * with itself, or wall and kill itself or increases its length if it collides
 * with food.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
The constructor parses the file as long as the file contains either two integer
values or four. It also creates snake and food at a random position.
 */
public class GameManager{
    int width;
    int height;
    List<Wall> walls;
    Food food;
    Snake snake;
    int food_counter = 0;

    public GameManager(String file) {
        // Array to store the walls
        this.walls = new ArrayList<>();
        // Reads the file and throws exception if not found
        int counter = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                String[] fa = line.split(" ");
                // for input value of only two integers
                if(counter == 0) {
                    this.width=Integer.parseInt(fa[0]);
                    this.height=Integer.parseInt(fa[1]);
                    counter++;
                }
                // for input value of four integers
                else {
                    if (fa[0].isEmpty()){
                        break;
                    }
                    int a=Integer.parseInt(fa[0]);
                    int b=Integer.parseInt(fa[1]);
                    int c=Integer.parseInt(fa[2]);
                    int d=Integer.parseInt(fa[3]);
                    for(int y=b;y<d+1;y++) {
                        for(int x=a;x<c+1;x++) {
                            //adds a new wall for every coordinate within the
                            // specified rectangle
                            this.walls.add(new Wall(x,y));
//                            this.points.put(x, y);
                        }
                    }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //spawns snake randomly between the walls
        Random random = new Random();

        int x_value;
        int y_value;
        while (true){
            boolean checker = true;
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            for (int i = 0; i < walls.size(); i ++){
                if ( x == walls.get(i).x && y == walls.get(i).y){
                    x = random.nextInt(width);
                    y = random.nextInt(height);
                    checker = false;
                    break;
                }
            }
            if (checker = true){
                x_value = x;
                y_value = y;
                break;
            }

        }

        this.snake = new Snake(x_value, y_value, 1);

        // to make sure that food and snake doesn't print in one place
        int x_food;
        int y_food;
        while (true){
            boolean checker = true;
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            for (int i = 0; i < walls.size(); i ++){
                if ( x == walls.get(i).x && y == walls.get(i).y){
                    x = random.nextInt(width);
                    y = random.nextInt(height);
                    checker = false;
                    break;
                }
            }
            if (x == snake.x && y == snake.y){
                checker = false;
            }
            if (checker = true){
                x_food = x;
                y_food = y;
                break;
            }
        }
        this.food = new Food(x_food, y_food);
    }

    /*
    This class will be used in the GUI to get the String representation of
    the board
     */
    public String[][] board(){
            String[][] board = new String[width][height];
            for (int x=0; x<width; x++){
                for (int y=0; y<height;y++){
                    for (int i=0; i<walls.size(); i++){
                        if (walls.get(i).x ==x && y == walls.get(i).y){
                            board[x][y] = "X";
                        }
                    }

                    if(snake.x==x && snake.y==y) {
                        board[x][y] = "S";
                    }
                    for(int i=0;i<snake.tail.size();i++) {
                        if(snake.tail.get(i).x==x && snake.tail.get(i).y==y) {
                            board[x][y] = "s";
                        }
                    }
                    if(food.x==x && food.y==y) {
                        board[x][y] = "f";
                    }

                }
            }
            return board;
    }
    /**
     * Prints the string representation of the current board.
     * The methods prints X for the walls, S for the snake's head,
     * s for the snake's body, f for the food, and . for the rest of
     * the places in the board.
     */
    @Override
    public String toString() {
        String tem_String="";

        for(int x=0;x<width;x++) {
            for(int y=0;y<height;y++) {
                String o=".";
                for(int i=0;i<walls.size();i++) {
                    // For the snake walls
                    if(walls.get(i).x==x && walls.get(i).y==y) {
                        o = "X";
                    }
                }
                // For the snake's head
                if(snake.x==x && snake.y==y) {
                    o="S";
                }
                // For the snake's body
                for(int i=0;i<snake.tail.size();i++) {
                    if(snake.tail.get(i).x==x && snake.tail.get(i).y==y) {
                        o="s";
                    }
                }
                // For the snake's food
                if(food.x==x && food.y==y) {
                    o="f";
                }
                System.out.print(o);
                tem_String += o;
            }
            System.out.println();
        }
        return tem_String;
    }


    /**
     * The method determines if the position at a given coordinate is empty,
     * has a wall,
     * @param x the x coor to test
     * @param y the y coor to test
     * @return a String that represent the situation of that position
     */
    public String empty_positions(int x,int y) {
        String tem_String ="Empty";
        for(int i=0;i<walls.size();i++) {
            if(walls.get(i).x==x && walls.get(i).y==y) {
                tem_String ="Wall";
            }
        }

        for(int i=0;i<this.snake.tail.size();i++) {
            if(this.snake.tail.get(i).x==x && this.snake.tail.get(i).y==y) {
                tem_String ="Tail";
            }
        }
        if(this.snake.x==this.food.x && this.snake.y==this.food.y) {
            tem_String ="Food";
        }
        return tem_String;
    }
    /**
     * moves the snake, checks for collision with the wall or the food.
     * If snake collides with the food, then increases the length of the
     * snake and creates new food.
     */
    public int move(int direction) {

        snake.move(direction);
//        System.out.println(snake.direction(direction));
        // Checking for collisions
        if(empty_positions(this.snake.x,this.snake.y)==("Wall")
                ||empty_positions(snake.x,snake.y)==("Tail")){
                    System.out.println("Collided with "+
                    empty_positions(this.snake.x,this.snake.y));
                    System.exit(1);
                    return 1; // terminates the program if collides with the walls
        }
        // Eating the food
        if(empty_positions(this.snake.x,this.snake.y)=="Food"){
            System.out.println("Tasty");
            int x=(int) (Math.random()*width);
            int y=(int) (Math.random()*height);
            //remove food from the board
            this.food.x=-23;
            this.food.y=-23;
            // Again printing the food at a new location
            while(!empty_positions(x,y).equals("Empty")){
                for (int i = 0; i < walls.size(); i ++){
                    while ( x == walls.get(i).x && y == walls.get(i).y){
                        x = (int) (Math.random()*width);
                        y = (int) (Math.random()*height);
                    }
                }
            }
            this.food.x=x;
            this.food.y=y;
            this.snake.length++;//snake grows when eating
            this.food_counter++;
        }
        toString();//outputs the board
        return 0;
    }
}
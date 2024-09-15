import org.xml.sax.helpers.AttributesImpl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
The class contains constructor which make a new window
to print the movement of the snake in the given direction
 */
public class Snake_GUI extends JPanel {
    static int width=0;
    static int height=0;
    GameManager game;
    String[][] b1;
    static int counter;
    int direction = 0;
//    static String command_line;

    public Snake_GUI() {
        game=new GameManager("maze_2.txt");
        this.b1 = game.board();
        setPreferredSize(new Dimension(width * 25, height * 25));
        setBackground(Color.BLACK);
        counter = game.food_counter;
        addKeyListener(new keylistener());
        setFocusable(true);
        int delay = 1000;
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.move(direction);
                b1 = game.board();
                repaint();
            }
        };
        new Timer(delay, taskPerformer).start();
        this.width = game.width;
        this.height = game.height;
    }

    /*
    The paint component prints out the walls, snake's head, snake's body,
    snake's food with different colors for each one of them.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                g.setColor(Color.gray);
                if (b1[x][y] == "X") {
                    g.setColor(Color.black);
                }

                if (b1[x][y] == "S") {
                    g.setColor(Color.red);
                }
                if (b1[x][y] == "s") {
                    g.setColor(Color.GREEN);
                }
                if (b1[x][y] == "f") {
                    g.setColor(Color.YELLOW);
                }
                g.fillRect((x) * 25, (y) * 25, (x) * 25, (y) * 25);
            }
        }
    }

/*
The main class contains file which make a new frame and adds different
panels in it with the start and pause buttons.
 */
    public static void main(String[] args) {

//        command_line = args[0];
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame("Snake Game");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);

                JPanel panel = new JPanel();//panel
                panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
                JPanel borderedPanel = new Snake_GUI();
                panel.add(borderedPanel);
                JLabel label = new JLabel("Score: " + Snake_GUI.counter);
                panel.add(label);//adds the label



                JButton start_button = new JButton("Start");
                JButton pause_button = new JButton("Pause");
                panel.add(start_button);
                panel.add(pause_button);

//                JOptionPane.showMessageDialog(null,
//                        "Click Ok to start the game", "Starter",
//                        JOptionPane.PLAIN_MESSAGE);


                frame.setSize((width+1)*25, (height+5)*25);
                frame.add(panel);
                frame.setVisible(true);
            }
        });

        }
        /*
        The keylistener class handles the movement of the snake according to
        the arrow keys. Its implemented at Snake_GUI constructor.
         */
    public class keylistener implements KeyListener{
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT: {
                            game.move(1);
                            b1 = game.board();
                            direction = 1;
                            repaint();
                            break;

                    }
                    case KeyEvent.VK_UP: {
                        System.out.println("b");
                        game.move(0);
                        b1 = game.board();
                        direction = 0;
                        repaint();
                        break;
                    }
                    case KeyEvent.VK_RIGHT: {
                        game.move(2);
                        b1 = game.board();
                        direction = 2;
                        repaint();
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        System.out.println("d");
                        game.move(3);
                        b1 = game.board();
                        direction = 3;
                        repaint();
                        break;
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        }

}
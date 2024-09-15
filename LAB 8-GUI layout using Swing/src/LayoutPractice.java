/**
 * LAB 8: GUI Layout Practice
 *
 * Name: Aayush Kafle
 * Class: CS-251L-005 (Spring 2022)
 * Email: akafle1@unm.edu
 * Date Submitted: 04/25/2022
 *
 * Description of the class:
 * This class operates the swing GUI. The program when compiled pops up a
 * screen where three different shapes can be drawn choosing the respective
 * shapes. Also, there is a clicker button which when clicked shows how many
 * times the button was clicked.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LayoutPractice extends JFrame{
    // Defining constants we will use further below in the code
    private int number_of_clicks = 0;
    private final int width = 500;
    private final int height = 500;
    private int selected_button;

    /*
    Making a separate MyPanel which shows the different shapes in the screen
     */
    private class MyPanel extends JPanel {
        private MyPanel() {
            // Setting the window size as of above
            setPreferredSize(new Dimension(width, height));
        }

        // The paint component shows the different shapes
        public void paintComponent(Graphics g) {
            // Showing the background rectangle where we will draw other shapes
            g.setColor(Color.cyan);
            g.fillRect(0, 0, getWidth(),getHeight());

            //Setting the initial variable which we will use to draw the shapes
            int var_1 = 100;
            int var_2 = 150;
            int var_3 = 200;
            // If the selected button is a square
            // Draw the square
            if (selected_button == 1) {
                for (int i = 0; i < 5; i++) {
                    g.setColor(Color.black);
                    g.fillRect(var_1, var_2, var_3, var_3);
                    g.setColor(Color.white);
                    g.fillRect(var_1 + 10, var_2 + 10, var_3 - 20, var_3 - 20);
                    var_1 += 20;
                    var_2 += 20;
                    var_3 -= 40;
                }
            }
            // If the selected button is a circle
            // Draw the circle
            else if (selected_button == 2) {
                for (int i = 0; i < 5; i++) {
                    g.setColor(Color.blue);
                    g.fillOval(var_1, var_2, var_3, var_3);
                    g.setColor(Color.green);
                    g.fillOval(var_1 + 10, var_2 + 10, var_3 - 20, var_3 - 20);
                    var_1 += 20;
                    var_2 += 20;
                    var_3 -= 40;
                }
                // If the selected button is a rectangle
                // Draw the rectangle
            } else {
                for (int i = 0; i < 5; i++) {
                    g.setColor(Color.red);
                    g.fillRoundRect(var_1, var_2, var_3, var_3,50,50);
                    g.setColor(Color.white);
                    g.fillRoundRect(var_1 + 10, var_2 + 10, var_3 - 20,
                            var_3 - 20, 50, 50);
                    var_1 += 20;
                    var_2 += 20;
                    var_3 -= 40;
                }
            }
        }

        }
        /*
        Creating the frames, panels, labels, and buttons in the class
        A parent panel is created where two different panels .i.e. one of them
        draws the shapes and the other one shows the options for different
        shapes and clicker button.
         */
    LayoutPractice() {
        // Creating the main frame
        final JFrame frame = new JFrame("Layout Practice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setBounds(50,100, width, height);

        // Creating the parent panel where we will add the other two panels
        JPanel parent_panel = new JPanel();
        parent_panel.setLayout(new GridLayout(2,1));

        // Creating the first panel to draw shapes
        JPanel panel = new MyPanel();
        panel.setLayout(new FlowLayout());
        panel.setBorder(BorderFactory.createTitledBorder(""));

        // Creating panel1 to draw the options for shapes and clicker button
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));

        // Creating a label "Click Counter"
        JLabel label = new JLabel("Click Counter");
        panel1.add(label);
        panel1.add(Box.createHorizontalGlue());

        // Making the "Click Me!" button for clicker
        JButton button = new JButton("Click Me!");//button
        button.setBounds(50, 200, 225, 25);
        panel1.add(button);//adds the button
        button.addActionListener( new ActionListener()
        {
            // Senses the action in the box (if clicked)
            @Override
            public void actionPerformed(ActionEvent e)
            {
                number_of_clicks++;
                label.setText("Number of Clicks: "+number_of_clicks);
                JOptionPane.showMessageDialog(LayoutPractice.this,
                        "Number of Clicks: " + number_of_clicks, "Clicks",
                                    JOptionPane.PLAIN_MESSAGE);
            }
        });

        // Prints out the spaces and selecting shapes option
        JLabel spaces = new JLabel("      ");
        JLabel label_shapes = new JLabel("Select Shapes: ");
        panel1.add(spaces);
        panel1.add(spaces);
        panel1.add(label_shapes);

        // Creating radio buttons for selection
        ButtonGroup group = new ButtonGroup();
        JRadioButton button_square = new JRadioButton();
        JRadioButton button_circle = new JRadioButton();
        JRadioButton button_rectangle = new JRadioButton();

        // Making the clickable button for the square with action sensor
        button_square.setText("Square");
        button_square.setBounds(10,300,150,25);
        group.add(button_square);
        button_square.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected_button = 1;
                panel.repaint();
            }
        }
        );
        // Making the clickable button for the circle with action sensor
        button_circle.setText("Circle");
        button_circle.setBounds(10, 325, 150, 25);
        group.add(button_circle);
        button_circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Select Shape: ");
                selected_button = 2;
                panel.repaint();
            }
        }
        );
        // Making the clickable button for the rectangle with action sensor
        button_rectangle.setText("Rectangle");
        button_rectangle.setBounds(10, 350, 150, 25);
        group.add(button_rectangle);
        button_rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Select Shape: ");
                selected_button = 3;
                panel.repaint();
            }
        }
        );

        // Adding all the buttons to the panel
        panel1.add(button_square);
        panel1.add(button_circle);
        panel1.add(button_rectangle);
        // Adding the two sub panels to the parent panel
        parent_panel.add(panel);
        parent_panel.add(panel1);
        panel1.setBackground(Color.gray);  // Making the background color

        // Packing all the contents of the panel into the frame
        frame.getContentPane().add(parent_panel);
        frame.pack();
        frame.setVisible(true);
    }

    /*
    Running the constructor
     */
    public static void main(String[] args) {
                new LayoutPractice();
            }
}
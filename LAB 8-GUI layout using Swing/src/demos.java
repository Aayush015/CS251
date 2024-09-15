import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class demos extends JPanel implements ActionListener {

    // declaring the size of frame
    int counter = 0;
    int width = 700;
    int height = 500;

    JRadioButton mybutton1, mybutton2, mybutton3; //radio buttons
    ButtonGroup group; //button group for radio buttons
    JButton button; //regular button
    JLabel label; //label that will be updated with each regular button click
    JFrame frame;
    JPanel panel1; //will contain all buttons
    JPanel panel2; //will show different shapes
    int b;
    demos() {
        frame = new JFrame(); //creating new jframe
        frame.setTitle("LayoutPractice");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //closes
        frame.setLayout(null);
        frame.setBounds(50, 100, width, height); //frame parameters
        Container c = frame.getContentPane();

        //setting up "click me" button

        button = new JButton();
        button = new JButton("Click me for a dialog!!");
        button.setBounds(50, 200, 225, 25);
        button.setFocusable(false);
        button.addActionListener(this);
        label = new JLabel(); //creating new label
        label.setBounds(50, 50, 100, 100);
        label.setFont(new Font("Caliber", Font.BOLD, 14));
        label.setBounds(120, 50, 200, 100);


        //creating radio buttons and adding buttons to button group
        // setting text, size and location for each button with action listener
        group = new ButtonGroup();
        mybutton1 = new JRadioButton();
        group.add(mybutton1);
        mybutton1.setText("Square");
        mybutton1.setBounds(10, 300, 150, 25);
        mybutton1.addActionListener(this);
        mybutton2 = new JRadioButton();
        group.add(mybutton2);
        mybutton2.setBounds(10, 325, 150, 25);
        mybutton2.setText("Circle");
        mybutton2.addActionListener(this);
        mybutton3 = new JRadioButton();
        group.add(mybutton3);
        mybutton3.setText("Rectangle");
        mybutton3.setBounds(10, 350, 150, 25);
        mybutton3.addActionListener(this);

        //creating panel 1

        panel1 = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                //  color the full background here
                g.setColor(Color.blue);
                g.fillRect(0, 0, 50000,10000);
                if (b == 1) {

                    //painting cool square design
                    g.setColor(Color.yellow);
                    g.fillRect(70, 120, 160, 160);
                    g.setColor(Color.red);
                    g.fillRect(80, 130, 140, 140);
                    g.setColor(Color.yellow);
                    g.fillRect(90, 140, 120, 120);
                    g.setColor(Color.red);
                    g.fillRect(100, 150, 100, 100);
                    g.setColor(Color.yellow);
                    g.fillRect(110, 160, 80, 80);
                    g.setColor(Color.red);
                    g.fillRect(120, 170, 60, 60);
                    g.setColor(Color.yellow);
                    g.fillRect(130, 180, 40, 40);
                    g.setColor(Color.red);
                    g.fillRect(140, 190, 20, 20);
                } else if (b == 2) {
                    //painting cool circle design
                    g.setColor(Color.yellow);
                    g.fillOval(50, 135, 200, 200);
                    g.setColor(Color.red);
                    g.fillOval(65, 150, 170, 170);
                    g.setColor(Color.yellow);
                    g.fillOval(80, 165, 140, 140);
                    g.setColor(Color.red);
                    g.fillOval(95, 180, 110, 110);
                    g.setColor(Color.yellow);
                    g.fillOval(110, 195, 80, 80);
                    g.setColor(Color.red);
                    g.fillOval(125, 210, 50, 50);
                    g.setColor(Color.yellow);
                    g.fillOval(140, 225, 20, 20);

                } else {
                    //painting cool rectangle with curved edges design
                    g.setColor(Color.red);
                    g.fillRoundRect(50, 95, 200, 260, 50, 50);
                    g.setColor(Color.yellow);
                    g.fillRoundRect(65, 110, 170, 230, 50, 50);
                    g.setColor(Color.red);
                    g.fillRoundRect(80, 125, 140, 200, 50, 50);
                    g.setColor(Color.yellow);
                    g.fillRoundRect(95, 140, 110, 170, 50, 50);
                    g.setColor(Color.red);
                    g.fillRoundRect(110, 155, 80, 140, 35, 35);
                    g.setColor(Color.yellow);
                    g.fillRoundRect(125, 170, 50, 110, 20, 20);
                    g.setColor(Color.red);
                    g.fillRoundRect(140, 185, 20, 80, 20, 20);
                }
            }
        };
        panel1.setLayout(null);
        //creating the second panel
        panel2 = new JPanel();
        panel2.setLayout(null);
        //adding all buttons to panel 2
        panel2.add(button);
        panel2.add(label);
        panel2.add(mybutton1);
        panel2.add(mybutton2);
        panel2.add(mybutton3);
        //adding panels to the container
        c.add(panel1);
        panel1.setBackground(Color.gray);
        panel1.setBounds(0, 0, width / 2, height);
        c.add(panel2);
        panel2.setBackground(Color.lightGray);
        panel2.setBounds(width / 2, 0, width / 2, height);
        frame.setVisible(true);
    }
    // main part of the code
    public static void main(String[] args) {

        new demos();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("select shape");
        //if radio button one is clicked set global variable b to an integer in order to paint
        if (e.getSource() != mybutton1) {
            if (e.getSource() == mybutton2) b = 2;
            else if (e.getSource() == mybutton3) {
                b = 3;
            } else {
                counter++; //updating counter
                //updating label text with counter and when button is clicked
                label.setText("Button Clicks = " + counter);
                JOptionPane.showMessageDialog(demos.this, "You have clicked " + counter + " times");
            }
        } else {
            b = 1;
        }
        panel1.repaint();
        //repaints panel 1 and shapes
        repaint();
    }
}
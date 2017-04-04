import buttonPackage.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;

/**
 * Leonard Halling, leonardh@kth.se
 * Filip Hildebrandt, filiphil@kth.se
 */


public class Grafik extends JFrame {

    MyButton btn1;
    MyButton btn2;

    Grafik(){
        setTitle("Filip Hildebrandt & Leonard Halling");
        setSize(300, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn1 = new MyButton(Color.green, Color.red, "Run", "Stop");
        btn2 = new MyButton(Color.pink, Color.gray, "Walk", "Go");
        add(btn1);
        add(btn2);
        setVisible(true);


    }


    public static void main(String[] args) {

        Grafik gr = new Grafik();

    }


}


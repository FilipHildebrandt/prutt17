package buttonPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Leonard Halling, leonardh@kth.se
 * Filip Hildebrandt, filiphil@kth.se
 */


public class MyButton extends JButton implements ActionListener{

    Color c1, c2;
    String s1, s2;
    String now = "s1";

    public MyButton(Color c1, Color c2, String s1, String s2){
//        super("My Button");

        this.c1 = c1;
        this.c2 = c2;
        this.s1 = s1;
        this.s2 = s2;


        setBackground(c1);
        setBorderPainted(false);
        setText(s1);
        setOpaque(true);
        addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this)){
            this.toggleState();
        }

    }

    public void toggleState(){
        if (now == "s1"){
            setBackground(c2);
            setText(s2);
            now = "s2";
        }else{
            setBackground(c1);
            setText(s1);
            now = "s1";
        }

    }
}

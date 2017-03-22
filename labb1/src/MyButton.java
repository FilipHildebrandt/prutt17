import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Leonard Halling, leonardh@kth.se
 * Filip Hildebrandt, filiphil@kth.se
 */


public class MyButton extends JButton{

    Color c1, c2;
    String s1, s2;
    String now = "s1";

    MyButton(Color c1, Color c2, String s1, String s2){
//        super("My Button");

        this.c1 = c1;
        this.c2 = c2;
        this.s1 = s1;
        this.s2 = s2;


        this.setBackground(c1);
        this.setText(s1);
        setOpaque(true);
    }



    public void toggleState(){
        if (now == "s1"){
            this.setBackground(c2);
            this.setText(s2);
            now = "s2";
        }else{
            this.setBackground(c1);
            this.setText(s1);
            now = "s1";
        }

    }
}

package buttonPackage;

import javax.swing.*;
import java.awt.*;


/**
 * Leonard Halling, leonardh@kth.se
 * Filip Hildebrandt, filiphil@kth.se
 */


public class MyButton2 extends JButton {

    Color c1, c2;
    String s1, s2;
    String now = "s1";
    static String[] knappnamn = {"Jag", "Du", "Ni", "Vi", "Någon", "Några", "Ingen"};


    public MyButton2(){

        String randString1 = knappnamn[(int )(Math.random()*100%knappnamn.length)];
        String randString2 = knappnamn[(int )(Math.random()*100%knappnamn.length)];
        s1=randString1;
        s2=randString2;
        c1 = Color.pink;
        c2 = Color.gray;
        setText(s1);
        setBackground(c1);
        setBorderPainted(false);
        setOpaque(true);



    }


    public MyButton2(String s1, String s2){
        this();

        this.s1 = s1;
        this.s2 = s2;
        setText(this.s1);

    }
    public MyButton2(Color c1, Color c2, String s1, String s2){

        this(s1, s2);
        this.c1 = c1;
        this.c2 = c2;

        setBackground(this.c1);

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

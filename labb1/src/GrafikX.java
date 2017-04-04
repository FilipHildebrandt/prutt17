import buttonPackage.MyButton;
import buttonPackage.MyButton2;

import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Leonard Halling, leonardh@kth.se
 * Filip Hildebrandt, filiphil@kth.se
 */


public class GrafikX extends JFrame implements ActionListener {

    MyButton2[] knapplista;

    GrafikX(int antal){
        setTitle("Filip Hildebrandt & Leonard Halling");
        setSize(300, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        knapplista = new MyButton2[antal];



    }

    public void actionPerformed(ActionEvent e) {
        for (MyButton2 knapp: knapplista){
            if (!(knapp.equals(e.getSource()))){
                knapp.toggleState();
            }
        }
    }

    public static void main(String[] args) {
        int antal = Integer.parseInt(args[0]);
        GrafikX gr = new GrafikX(antal);
        int counter= 0;
        for (int i = 0; i < antal*2 - 1; i+=2) {
            MyButton2 knapp;
            if (args.length>1){
                knapp = new MyButton2(args[i+1],args[i+2]);
            }
            else{
                knapp = new MyButton2();
            }
            knapp.addActionListener(gr);
            gr.add(knapp);
            gr.knapplista[counter]=knapp;
            counter++;



        }
        gr.setVisible(true);

    }


}


import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

/**
 * Leonard Halling, leonardh@kth.se
 * Filip Hildebrandt, filiphil@kth.se
 */


public class Grafik extends JFrame implements ActionListener{

    MyButton btn;

    Grafik(){
        super("hdsa");
        JFrame myFrame = new JFrame();
//        myFrame.setTitle("Labb1");
        myFrame.setSize(300, 300);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.setLocationRelativeTo(null);

        btn = new MyButton(Color.green, Color.red, "Run", "Stop");
        btn.addActionListener(this);
        myFrame.add(btn);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            btn.toggleState();
        }
    }

    public static void main(String[] args) {

        Grafik gr = new Grafik();
    }


}


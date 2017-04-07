import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2017-04-05.
 */
public class Square extends JButton {

    int i;
    int j;


    public Square(int i, int j, String rep){
        this.i = i;
        this.j = j;

        if (rep.equals("_")){
            rep = " ";
        }
        setText(rep);
    }


    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}

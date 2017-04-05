import javax.swing.*;

/**
 * Created by user on 2017-04-05.
 */
public class Square24 extends JButton {

    int x;
    int y;
    boolean locked = false;
    int sum = 0;

    public Square24(int x, int y, int sum){
        this.x = x;
        this.y = y;
        this.sum = sum;
        setText(sum+"");

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

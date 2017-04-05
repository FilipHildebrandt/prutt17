/**
 * Created by user on 2017-04-05.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private int size;
    private Square[][] board;        // Square är subklass till JButton
    private JLabel mess = new JLabel();
    private int iemp;
    private int jemp;

    public ViewControl (Boardgame gm, int n){

        game = gm;
        size = n;
        board = new Square[n][n];
        setTitle("Filip Hildebrandt & Leonard Halling");
        setSize(400, 400);
        setLayout(new GridLayout(n, n));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createBoard();

    }

    private void createBoard(){
        board = new Square[size][size];
        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                String status = game.getStatus(i, j);
                if (!("*".equals(status))) {


                    Square s = new Square(i, j, status);
                    board[i][j] = s;
                    add(board[i][j]);
                    board[i][j].addActionListener(this);
                    //                board[i][j].setText(Integer.toString(count));
                }


            }
        }
        setVisible(false);
        revalidate();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof Square) {
            Square s = (Square) source;
            int i = s.getI();
            int j = s.getJ();
            game.move(i, j);
            createBoard();



        }


    }



    public static void main(String[] args) {
        FifteenModel fm = new FifteenModel();
        ViewControl vc = new ViewControl(fm, 4);


    }

}





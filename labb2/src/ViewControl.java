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
    private JPanel buttons;
    private JLabel mess = new JLabel();
    private int iemp;
    private int jemp;

    public ViewControl (Boardgame gm, int n){

        game = gm;
        size = n;
        board = new Square[n][n];
        buttons = new JPanel();
        setTitle("Filip Hildebrandt & Leonard Halling");
        setSize(400, 500);
        buttons.setSize(400, 400);
        buttons.setLayout(new GridLayout(n, n));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createBoard();
        setLayout(new BorderLayout());
        add(buttons, BorderLayout.CENTER);
        add(mess, BorderLayout.NORTH);
        mess.setText("Welcome to 15-game");

    }

    private void createBoard(){
//        board = new Square[size][size];
        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                String status = game.getStatus(i, j);
                Square s = new Square(i, j, status);
                board[i][j] = s;
                buttons.add(board[i][j]);
                board[i][j].addActionListener(this);
                }


            }
        setVisible(true);
    }

    private void updateBoard(){
        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                String status = game.getStatus(i, j);
                board[i][j].setText(status);
            }
        }
        mess.setText(game.getMessage());
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof Square) {
            Square s = (Square) source;
            int i = s.getI();
            int j = s.getJ();
            game.move(i, j);
            updateBoard();

        }


    }



    public static void main(String[] args) {
//        Boardgame fm = new FifteenModel();
        Boardgame fm = new MockGame();
//        Boardgame fm = new Game2048();
        ViewControl vc = new ViewControl(fm, 4);


    }

}





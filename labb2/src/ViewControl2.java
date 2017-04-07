/**
 * Created by user on 2017-04-05.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class ViewControl2 extends JFrame implements KeyListener {

    private Boardgame game;
    private int size;
    private Square[][] board;        // Square är subklass till JButton
    private JPanel buttons;
    private JLabel mess = new JLabel();
    private int iemp;
    private int jemp;
    Color[] colorList;
    String[] numberList;
    Map<String, Color> colorDict = new HashMap<>();

    public ViewControl2 (Boardgame gm, int n){
        fillDict();
        game = gm;
        size = n;
        board = new Square[n][n];
        buttons = new JPanel();
        setTitle("Filip Hildebrandt & Leonard Halling");
        setSize(400, 500);
        buttons.setSize(400, 400);
        buttons.setLayout(new GridLayout(n, n));
        buttons.addKeyListener(this);
        buttons.setFocusable(true);
        buttons.requestFocusInWindow();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createBoard();
        setLayout(new BorderLayout());
        add(buttons, BorderLayout.CENTER);
        add(mess, BorderLayout.NORTH);
        mess.setText("Welcome to 2048");

    }

    private void createBoard(){
//        board = new Square[size][size];
        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                String status = game.getStatus(i, j);
                Square s = new Square(i, j, status);
                board[i][j] = s;
                board[i][j].setBorderPainted(false);
                board[i][j].setOpaque(true);
                board[i][j].setBackground(colorDict.get(status));
                buttons.add(board[i][j]);

//                board[i][j].addActionListener(this);
            }


        }
        setVisible(true);
    }

    private void updateBoard(){
        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                String status = game.getStatus(i, j);
                if (status.equals("_")){
                    status = " ";
                }
                board[i][j].setBackground(colorDict.get(status));
                board[i][j].setText(status);
            }
        }
        mess.setText(game.getMessage());
    }

    private void fillDict(){
        numberList = new String[5];
        int count = 2;
        for (int i = 0; i < 5; i++) {
            numberList[i] = Integer.toString(count);
            count *= 2;
        }
        colorList = new Color[] {Color.lightGray, Color.yellow, Color.ORANGE, Color.pink, Color.red};

        for (int i = 0; i < numberList.length; i++) {
            colorDict.put(numberList[i], colorList[i]);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            game.move(-1, 0);
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            game.move(1, 0);
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            game.move(0, 1);
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            game.move(0, -1);
        }
        updateBoard();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

/*    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof Square) {
            Square s = (Square) source;
            int i = s.getI();
            int j = s.getJ();
            game.move(i, j);
            updateBoard();

        }


    }*/



    public static void main(String[] args) {
//        Boardgame fm = new FifteenModel();
//        Boardgame fm = new MockGame();
        Boardgame fm = new Game2048();
        ViewControl2 vc = new ViewControl2(fm, 4);


    }

}





import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Leonard on 2017-04-05.
 */
public class Game2048 implements Boardgame{

    private String[][] status;
    private ArrayList<int[]> empty;
    private ArrayList<int[]> tiles;

    public Game2048(){
        status = new String[4][4];
        createBoard();
    }

    public boolean move(int row, int col){
        checkTiles();
        for (int[] ind : tiles){
            moveTile(row, col, ind);
            }
        return true;
    }

    private void moveTile(int row, int col, int[] idx){
        if (0 > idx[0]+row || idx[0]+row > 3 || 0 > idx[1]+col || idx[1]+col > 3) {
            System.out.println("row: " + row + "col: " + col + "idx0: "+idx[0] + "idx[1]: " + idx[1]);
            sumTiles(row, col, idx);
            return;
        }
        if (status[idx[0]][idx[1]].equals(status[idx[0]+row][idx[1]+col])){
            //läggihop()
            return;
        }
        String currentValue = status[idx[0]][idx[1]];
        status[idx[0]][idx[1]] = "_";
        int[] newIdx = {idx[0]+row, idx[1]+col};
        status[newIdx[0]][newIdx[1]] = currentValue;
        moveTile(row, col, newIdx);
    }

    private void sumTiles(int row, int col, int[] idx){
        int newValue = Integer.parseInt(status[idx[0]][idx[1]]) * 2;
        status[idx[0]][idx[1]] = "_";
        System.out.println(idx[0]+row + "");
        System.out.println(idx[1]+col + "");
        status[idx[0]+row][idx[1]+col] = Integer.toString(newValue);
    }

    private void addTile(){
        /**
         * Adds a 2 or 4 to a random empty index.
         */
        checkEmpty();
        int idx = new Random().nextInt(empty.size());
        int[] randIndex = empty.get(idx);
        status[randIndex[0]][randIndex[1]]
            = Integer.toString(randomTile());
    }

    private int randomTile(){
        /**
         * Generates 2 or 4.
         */
        int value = Math.random() < 0.9 ? 2 : 4;
        return value;
    }

    private void createBoard(){
        /**
         * fills status-array with empty strings
         */
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                status[i][j] = "_";
            }
        }
        addTile();
        addTile();
        addTile();
    }

    private void checkTiles(){
        /**
         * creates arraylist containing indices of occupied tiles
         */
        tiles = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!("_".equals(status[i][j]))){
                    int[] tuple = {i, j};
                    tiles.add(tuple);
                }
            }
        }
    }

    private void checkEmpty(){
        /**
         * creates arraylist containing indices of empty tiles
         */
        empty = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ("_".equals(status[i][j])){
                    int[] tuple = {i, j};
                    empty.add(tuple);
                }
            }
        }
    }

    @Override
    public String getStatus(int i, int j) {
        return status[i][j];
    }

    @Override
    public String getMessage() {
        return null;
    }

}

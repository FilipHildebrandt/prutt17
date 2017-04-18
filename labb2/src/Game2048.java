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

    /*public boolean move(int row, int col){
        checkTiles();
        for (int[] ind : tiles){
            moveTile(row, col, ind);
            }
        return true;
    }*/

    @Override
    public boolean move(int row, int col) {
        boolean moved;
        if (row == -1 && col == 0){
            moved = moveUp();
        }else if (row == 1 && col == 0){
            moved = moveDown();
        }else if (row == 0 && col == 1){
            moved = moveRight();
        }else if (row == 0 && col == -1){
            moved = moveLeft();
        }else{
            return false;
        }
        if (moved){
            addTile();
        }
        return true;
    }

    private boolean moveUp(){
        boolean movedTiles = false;
        for (int col = 0; col < 4; col++) {
            for (int row = 1; row < 4; row++) {
                if (!("_".equals(status[row][col]))){
                    int value = Integer.parseInt(status[row][col]);
                    int newRow = row-1;
                    boolean moved = false;
                    while (newRow > 0 && (status[newRow][col].equals("_"))){
                        moved = true;
                        movedTiles = true;
                        newRow--;
                    }
                    if ("_".equals(status[newRow][col])){
                        status[newRow][col] = status[row][col];
                    }else if (status[newRow][col].equals(status[row][col])){
                        moved = true;
                        movedTiles = true;
                        status[newRow][col] = Integer.toString(value * 2);
                    }
                    else{
                        status[newRow + 1][col] = Integer.toString(value);
                    }
                    if (moved){
                        status[row][col] = "_";
                    }

                }
            }
        }
        return movedTiles;
    }


    private boolean moveDown(){
        boolean movedTiles = false;
        for (int col = 0; col < 4; col++) {
            for (int row = 2; row >= 0; row--) {
                if (!("_".equals(status[row][col]))){
                    int value = Integer.parseInt(status[row][col]);
                    int newRow = row+1;
                    boolean moved = false;
                    while (newRow < 3 && (status[newRow][col].equals("_"))){
                        moved = true;
                        movedTiles = true;
                        newRow++;
                    }
                    if ("_".equals(status[newRow][col])){
                        status[newRow][col] = status[row][col];
                    }else if (status[newRow][col].equals(status[row][col])){
                        status[newRow][col] = Integer.toString(value * 2);
                        moved = true;
                        movedTiles = true;
                    }
                    else{
                        status[newRow - 1][col] = Integer.toString(value);
                    }
                    if (moved){
                        status[row][col] = "_";
                    }
                }
            }
        }
        return movedTiles;
    }

    private boolean moveRight(){
        boolean movedTiles = false;
        for (int row = 0; row < 4; row++) {
            for (int col = 2; col >= 0; col--) {
                if (!("_".equals(status[row][col]))){
                    int value = Integer.parseInt(status[row][col]);
                    int newCol = col+1;
                    boolean moved = false;
                    while (newCol < 3 && (status[row][newCol].equals("_"))){
                        moved = true;
                        movedTiles = true;
                        newCol++;
                    }
                    if ("_".equals(status[row][newCol])){
                        status[row][newCol] = status[row][col];
                    }else if (status[row][newCol].equals(status[row][col])){
                        status[row][newCol] = Integer.toString(value * 2);
                        moved = true;
                        movedTiles = true;
                    }
                    else{
                        status[row][newCol - 1] = Integer.toString(value);
                    }
                    if (moved){
                        status[row][col] = "_";
                    }
                }
            }
        }
        return movedTiles;
    }

    private boolean moveLeft(){
        boolean movedTiles = false;
        for (int row = 0; row < 4; row++) {
            for (int col = 1; col < 4; col++) {
                if (!("_".equals(status[row][col]))){
                    int value = Integer.parseInt(status[row][col]);
                    int newCol = col-1;
                    boolean moved = false;
                    while (newCol > 0 && (status[row][newCol].equals("_"))){
                        moved = true;
                        movedTiles = true;
                        newCol--;
                    }
                    if ("_".equals(status[row][newCol])){
                        status[row][newCol] = status[row][col];
                    }else if (status[row][newCol].equals(status[row][col])){
                        status[row][newCol] = Integer.toString(value * 2);
                        moved = true;
                        movedTiles = true;
                    }
                    else{
                        status[row][newCol + 1] = Integer.toString(value);
                    }
                    if (moved){
                        status[row][col] = "_";
                    }

                }
            }
        }
        return movedTiles;
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

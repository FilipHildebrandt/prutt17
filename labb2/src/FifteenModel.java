import java.text.MessageFormat;

/**
 * Created by Leonard Halling och Filip Hildebrandt
 */
public class FifteenModel implements Boardgame {

    private String currentMessage = "No message yet";
    private String[][] status = new String[4][4];
    private int iemp = 3;
    private int jemp = 3;
    StringBuilder sb;

    @Override
    public boolean move(int i, int j) {
        if ((0>i || i>3) || (0>j || j>3)){
            currentMessage = "Invalid move";
            return false;
        }
        if (Math.abs(i - iemp) + Math.abs(j - jemp) != 1){
            currentMessage = "Invalid move";
            return false;
        }
        status[iemp][jemp] = status[i][j];
        status[i][j] = " ";
        iemp = i;
        jemp = j;
        sb = new StringBuilder();
        sb.append("Pressed ");
        sb.append(i + " ");
        sb.append(j);
        currentMessage = sb.toString();
        return true;

    }

    @Override
    public String getMessage() {
        return currentMessage;
    }

    @Override
    public String getStatus(int i, int j) {
        return status[i][j];
    }

    public FifteenModel(){
        int count =1;
        for (int i = 0; i<4; i++){
            for (int j = 0; j<4; j++){
                status[i][j] = Integer.toString(count);
                count++;
                if (count == 16){
                    break;
                }

            }
        }
        shuffleBoard();
    }

    private void shuffleBoard(){
        int randint;
        int n = 0;
        int m = 0;
        for (int i = 0;i<50;i++){

            do {
                randint = (int )(Math.random()*100%4);
                if (randint == 0){
                    n = iemp - 1;
                    m = jemp;
                }else if (randint == 1){
                    n = iemp;
                    m = jemp -1;
                }else if (randint == 2) {
                    n = iemp;
                    m = jemp + 1;
                }else if (randint == 3) {
                    n = iemp + 1;
                    m = jemp;
                }
            }

            while (!move(n, m));



        }
    }

}

/**
 * Created by Leonard on 2017-04-05.
 */
public class MockGame implements Boardgame {

    @Override
    public boolean move(int i, int j) {
        return true;
    }

    @Override
    public String getMessage() {
        return "Hejsan";
    }

    @Override
    public String getStatus(int i, int j) {
        return "4";
    }
}

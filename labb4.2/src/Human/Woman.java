package Human;

/**
 * Created by Leonard on 2017-05-12.
 */

public class Woman extends Human{

    String name;
    String pnr;

    Woman(String name, String pnr){
        this.name = name;
        this.pnr = pnr;
    }

    @Override
    public String toString() {
        return "Jag är kvinna och heter " + name;
    }
}

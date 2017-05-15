package Human;

/**
 * Created by Leonard on 2017-05-12.
 */
public class NonBinary extends Human{

    String name;
    String pnr;

    NonBinary(String name, String pnr){
        this.name = name;
        this.pnr = pnr;
    }

    @Override
    public String toString() {
        return "Jag är icke-binär och heter " + name;
    }
}

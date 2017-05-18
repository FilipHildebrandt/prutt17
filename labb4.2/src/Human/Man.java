package Human;

/**
 * Created by Leonard on 2017-05-12.
 */
class Man extends Human{

    String name;
    String pnr;

    Man(String name, String pnr){
        this.name = name;
        this.pnr = pnr;
    }

    @Override
    public String toString() {
        return "Jag är man och heter " + name;
    }
}

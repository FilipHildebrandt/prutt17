package Human;

/**
 * Created by Leonard Halling & Filip Hildebrandt on 2017-05-12.
 */


abstract public class Human {

    Human(){}

    public static Human create (String name, String pnr){
        int c = Character.getNumericValue(pnr.charAt(9));

        if (c == 0){
            return new NonBinary(name, pnr);
        }
        else if (c % 2 == 0){
            return new Woman(name, pnr);
        }
        else{
            return new Man(name, pnr);
        }
    }


}




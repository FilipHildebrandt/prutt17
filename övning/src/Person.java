import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by user on 2017-04-20.
 */
public class Person implements Comparable<Person>{

    class Person {
        long pnr;
        String namn;
        Person (long p, String na) {
            pnr = p;
            namn = n;
        }
        public String toString() {
            return namn + " " + pnr;
        }
        // Andra intressanta data och metoder
    }


    //2a
    public int compareTo(Person other){
        return (int) pnr - other.pnr;
    }

    //2b
    public static TreeSet<Person> skapaTräd(){
        return new TreeSet<Person>();

    }

    public static void läggTill(Person ny, TreeSet<Person> samling){
        samling.add(ny);
    }

    public static void läggTillNya(samling){
        Person ny = skapaPerson();
        while (ny!=null){
            samling.add(ny);
            ny = skapaPerson();
        }
    }

    //2c
    public static void skrivUt(TreeSet<Person> samling){
        Iterator<Person> iter = samling.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    //2d
    void sorteraPersoner(List<Person> listan){
        Collections.sort(listan);
    }


}

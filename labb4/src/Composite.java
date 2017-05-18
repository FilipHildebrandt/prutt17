import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Leonard Halling & Filip Hildebrandt on 2017-05-12.
 */


public class Composite extends Component implements Iterable{

    ArrayList<Component> children;

    Composite(String name, int weight){
        super(name, weight);
        children = new ArrayList<>();
    }

    void add(Component newComp){
        children.add(newComp);
    }

    void remove(Component comp){
        children.remove(comp);
    }

    Component getChild(int i){
        return children.get(i);
    }

    @Override
    public int getWeight() {
        int total = weight;

        for (int i = 0; i < children.size(); i++) {

            total += getChild(i).getWeight();
        }
        return total;
    }

    @Override
    public String toString() {
        String total = name + "\n";

        for (int i = 0; i < children.size(); i++) {

            total += " " + getChild(i).toString();
        }
        return total;
    }

    @Override
    public BreadthFirst iterator() {
        return new BreadthFirst(this);
    }
}

/**
 * Created by Leonard Halling & Filip Hildebrandt on 2017-05-12.
 */


abstract public class Component {

    String name;
    int weight;

    Component(){
    }

    Component(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public abstract int getWeight();

    public abstract String toString();
}

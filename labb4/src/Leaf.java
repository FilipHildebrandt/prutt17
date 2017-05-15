/**
 * Created by Leonard Halling & Filip Hildebrandt on 2017-05-12.
 */

public class Leaf extends Component {

    Leaf(String name, int weight){
        super(name, weight);
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + "\n";
    }
}

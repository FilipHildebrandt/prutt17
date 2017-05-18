import java.util.Iterator;

/**
 * Created by Leonard on 2017-05-15.
 */
public class BreadthFirst implements Iterator {

    private Composite comp;
    private int current = 0;

    BreadthFirst(Composite comp){
        this.comp = comp;
    }

    @Override
    public boolean hasNext() {
        return current < comp.children.size() - 1;
    }

    @Override
    public Component next() {
        Component ret = null;
        if (current < comp.children.size() - 1){
            ret = comp.getChild(++current);
        }
        return ret;
    }

    public Component First(){
        return comp.getChild(0);
    }

    @Override
    public void remove() {}


}

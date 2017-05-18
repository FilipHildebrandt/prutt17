import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by Leonard on 2017-05-18.
 */
public class LifeNode extends DefaultMutableTreeNode{

    String name, tag, text;


    LifeNode(String name, String tag, String text){
        this.name = name;
        this.tag = tag;
        this.text = text;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}

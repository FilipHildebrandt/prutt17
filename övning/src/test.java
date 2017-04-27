import java.util.HashMap;

/**
 * Created by Filip on 2017-04-20.
 */
public class test {

    HashMap<String, Integer> dragDict = new HashMap<String, Integer>();
    String[] drag = {"STEN", "SAX", "PÅSE"};
    for (int i = 0; i < drag.length, i++){
        dragDict.put(drag[i], new Integer(i));
    }
    int index(String d, HashMap<String, Integer> dragDict){
        Integer plats = dragDict.get();

        if (null == plats){
            return -1;
        return  plats.intValue();
        }


    }
}

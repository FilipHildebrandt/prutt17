import java.util.Iterator;

/**
 * Created by Leonard Halling & Filip Hildebrandt on 2017-05-12.
 */
public class Main {

    public static void main(String[] args) {
        Composite suitCase = new Composite("Suitcase", 4);

        // Pack suitcase with leafs
        suitCase.add(new Leaf("Jacket", 1));
        suitCase.add(new Leaf("Computer", 2));
        suitCase.add(new Leaf("Jeans", 1));

        // Create composites and add stuff
        Composite leftShoe = new Composite("Left shoe", 1);
        leftShoe.add(new Leaf("Socks", 1));

        Composite rightShoe = new Composite("Right shoe", 1);
        rightShoe.add(new Leaf("Bicycle", 20));

        Composite toiletBag = new Composite("Toilet Bag", 1);
        toiletBag.add(new Leaf("Toothbrush", 1));
        toiletBag.add(new Leaf("Toothpaste", 1));
        toiletBag.add(new Leaf("Deodorant", 1));
        Composite littleBag = new Composite("Little bag", 2);
        littleBag.add(new Leaf("Little thing", 1));
        toiletBag.add(littleBag);


        // Pack suitcase with composites
        suitCase.add(leftShoe);
        suitCase.add(rightShoe);
        suitCase.add(toiletBag);

        // Print weight and content
        System.out.println("Weight: " + suitCase.getWeight());
        System.out.println("Stuff in " + suitCase);

        // Remove right shoe & jacket
        suitCase.remove(rightShoe);
        suitCase.remove(suitCase.getChild(0));

        // Print again
        System.out.println("Weight: " + suitCase.getWeight());
        System.out.println("Stuff in " + suitCase);


//        System.out.println("-----------------------");
//
//        BreadthFirst i = suitCase.iterator();
//        Component item = i.First();
//
//        System.out.println("Iterating over suitcase:");
//        while (item != null){
//            System.out.println(item);
//            item = i.next();
//        }
    }
}

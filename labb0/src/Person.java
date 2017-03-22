/**
Leonard Halling, leonardh@kth.se
Filip Hildebrandt, filiphil@kth.se
 */



public class Person {
    String name;
    int age;


    static String[] names = {"Alex", "Adam", "André", "Axel", "Annika", "Anna",
            "Ann", "Anjelica", "Agatha", "Amelia"};


    Person(String nameIn, int ageIn){
        name = nameIn;
        age = ageIn;
    }

    Person(){
        double randAge;
        do {
            randAge = Math.random();
        }while (randAge < 0.14);

        int randInt = (int )(randAge * 100 + 1);

        int randIndex = (int )(Math.random() * 100 + 1) % names.length;

        name = names[randIndex];
        age = randInt;
    }

    public String toString(){
        String repr = "namn: " + name + ", ålder: " + age;
        return repr;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public static void hej(){
        System.out.println("hej");
    }

    public static void main(String[] args) {
        Person leo = new Person("Leo", 24);
        System.out.println("namn: " + leo.getName() + ", ålder: " + leo.getAge());
        System.out.println(leo);

    }


}

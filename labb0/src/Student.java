/**
 Leonard Halling, leonardh@kth.se
 Filip Hildebrandt, filiphil@kth.se
 */

public class Student extends Person{
    int year;
    String program;

    Student(String nameIn, int ageIn, int yearIn){
        name = nameIn;
        age = ageIn;
        year = yearIn;

        program = "CMETE" + year;
    }

    Student(){

        super();

        int randYear;
        do {
            randYear = (int )(Math.random() * 100 + 1934);
        }while (randYear > 2016);

        year = randYear;
        program = "CMETE" + year;
    }

    public int getYear(){
        return year;
    }

    public String toString(){

        return "Namn: " + name + ", ålder: " + age + ", började på CMETE " + year;
    }

    public static void main(String[] args) {
        Student[] sArray = new Student[20];

        /*for(int i = 0; i < sArray.length; i++){
            sArray[i] = new Student();
            System.out.println(sArray[i]);
        }*/

        Person[] pArray = new Person[20];

        for(int i = 0; i < 10; i++){
            pArray[i] = new Student();
        }
        for(int i = 10; i < pArray.length; i++){
            pArray[i] = new Person();
        }

        for(int i = 0; i < pArray.length; i++){
            System.out.println(pArray[i]);
        }

    }
}

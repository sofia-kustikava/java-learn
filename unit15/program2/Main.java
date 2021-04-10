//Create a holder class that holds three objects of the same type, along with
//the methods to store and fetch those objects and a constructor to initialize all three. 

public class Main {
    public static void main(String[] args) {
        Class1 class1 = new Class1();
        Class2 class2 = new Class2();
        Class3 class3 = new Class3();

        Elements<Class1> elements1 = new Elements<>(class1);
        Elements<Class2> elements2 = new Elements<>(class2);
        Elements<Class3> elements3 = new Elements<>(class3);

        elements1.getMainClass().met1();
        elements2.getMainClass().met2();
        elements3.getMainClass().met3();
    }
}

//Create a class containing an inner class that itself contains an inner
//class. Repeat this using nested classes. Note the names of the .class files produced by the
//compiler. 

public class Main {
    public static void main(String[] args) {
        Class1 a = new Class1();
        Class1.Class2 b = a.new Class2();
        Class1.Class2.Class3 c = b.new Class3();
        
        Nest d = new Nest();
        Nest.Nest2 e = new Nest.Nest2();
        Nest.Nest2.Nest3 f = new Nest.Nest2.Nest3();
    }
}
